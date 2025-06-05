package client;

import LeothapWeek.Leothap;
import LeothapWeek.LeothapManager;
import ai.MobAi;
import ai.NhanBan;
import ai.LinhCanh;
import ai.*;
import core.BXH;
import core.CheckDDOS;
import java.io.IOException;
import java.util.Map.Entry;
import core.GameSrc;
import core.Manager;
import core.MenuController;
import core.MenuController;
import core.Service;
import static core.Service.send_notice_nobox_white;
import core.SessionManager;
import core.Util;
import ev_he.Event_2;
import ev_he.Event_4;
import ev_he.Event_tet;
import ev_he.Event_tet.MobNpc;
import ev_he.Farm;
import ev_he.Farm.MobFarm;
import ev_he.MobCay;
import ev_he.MobMiNuong;
import event_daily.MoLy;
import event_daily.ChienTruong;
import io.Message;
import io.Session;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import map.Dungeon;
import map.DungeonManager;
import map.Map;
import map.MapService;
import template.Pet_mi_nuong;
import template.Pet_mi_nuong_manager;

public class MessageHandler {

    private final Session conn;

    public MessageHandler(Session conn) {
        this.conn = conn;
    }

    public void process_msg(Message m) throws IOException, SQLException, InterruptedException, InterruptedException {
        //System.out.println("Processing case: " + m.cmd);

        switch (m.cmd) {
            case -100: {
                GameSrc.Hop_Ngoc_Kham(conn.p, m);
                break;
            }
            case -102: {
                GameSrc.player_store(conn, m);
                break;
            }
            case -101: {
                conn.p.moithachdau1_process(conn.p, m);
                break;
            }

            case -91: {
                if (m.reader().available() == 4) {
                    Service.remove_time_use_item(conn, m);
                } else if (m.reader().available() == 2) {
                    MoLy.Lottery_process(conn.p, m);
                } else {
                    String[] menu = new String[]{"Mở ly", "Vòng xoay", "Điểm pk", "Thoát kẹt", "Rơi nguyên liệu mề đay", "Xem lôi đài",
                        (conn.p.isShowMobEvents ? "Tắt " : "Bật ") + "hiển thị sự kiện", (conn.p.iseffMedal ? "Tắt " : "Bật ") + "hiển thị eff Mề Đay"};
                    MenuController.send_menu_select(conn, -91, menu);
                }
                break;
            }
            case 77: {
                GameSrc.Wings_Process(conn, m);
                break;
            }
            case -105: {
                if (conn.p.isCreateItemStar) {
                    GameSrc.ActionsItemStar(conn, m);

                } else if (conn.p.isSieuThan) {

                    Helps.NangSt.ActionSieuThan(conn, m);

                } else if (conn.p.isSieuCap) {

                    Helps.NangSc.ActionSieuCap(conn, m);

                } else if (conn.p.isSieuNhan) {
                    Helps.NangSieuNhan.NangSieuNhan(conn, m);
                } else {
                    GameSrc.Create_Medal(conn, m);

                }
                break;
            }
            case 69: {
                byte type = m.reader().readByte();
                if (type == 11) {
                    Player p0 = Map.get_player_by_name(m.reader().readUTF());
                    if (p0 != null && p0.myclan != null) {
                        p0.myclan.accept_mem(conn, p0);
                    }
                } else if (conn.p.myclan != null) {
                    conn.p.myclan.clan_process(conn, m, type);

                }
                break;
            }

            case 73: {
                if (conn.p.hopdo) {

                    Helps.HopDo.hop_trang_bi(conn.p, m);

                } else {
                    GameSrc.replace_item_process(conn.p, m);

                }
                break;
            }
            case 36: {
                if (conn.status != 1 && m.cmd == 36) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt, hãy kích hoạt");
                    return;
                }
                if (conn.p.level < 20 && m.cmd == 36) {
                    Service.send_notice_box(conn, "Level 20 mới giao dịch được");
                    return;
                }
                GameSrc.trade_process(conn, m);
                break;
            }
            case 48: {
                conn.p.map.create_party(conn, m);
                break;
            }

            case 52: {
                short ID = m.reader().readShort();
                byte type = m.reader().readByte();
                byte main_sub = m.reader().readByte();
                if (type == 0) {
                    Player.receiveTask(conn, ID, main_sub);
                } else if (type == 1) {
                    Player.finishTask(conn, ID, main_sub);
                } else if (type == 2) {
                    Player.cancelTask(conn, ID, main_sub);
                }
                break;
            }
            case 67: {
                GameSrc.rebuild_item(conn, m);
                break;
            }
            case 9: {
                // if (conn.p.map.map_id == 48) {
                // conn.p.dungeon.use_skill(conn, m);
                // } else {
                // conn.p.map.use_skill(;
                // }
                MapService.use_skill(conn.p.map, conn, m, 0);
                break;
            }
            case 6: {
                // if (conn.p.map.map_id == 48) {
                // } else {
                // conn.p.map.use_skill(conn, m, 1);
                // }
                MapService.use_skill(conn.p.map, conn, m, 1);
                break;
            }
            case 40: {
                // if (conn.p.map.map_id == 48) {
                // } else {
                // conn.p.map.buff_skill(conn, m);
                // }
                MapService.buff_skill(conn.p.map, conn, m);
                break;
            }
            case 20: {
                conn.p.map.pick_item(conn, m);
//                if (conn.p.map.map_id == 48) {
//                } else {
//                    conn.p.map.pick_item(conn, m);
//                }
                break;
            }
            case 11: {
                if (conn.p.time_speed_rebuild > System.currentTimeMillis()) {
                    if (++conn.p.enough_time_disconnect > 2) {
                        conn.close();
                    }
                    return;
                }
                conn.p.time_speed_rebuild = System.currentTimeMillis() + 500L;
                conn.p.enough_time_disconnect = 0;
                UseItem.ProcessItem3(conn, m);
                break;
            }
            case -107: {
                if (conn.p.time_speed_rebuild > System.currentTimeMillis()) {
                    if (++conn.p.enough_time_disconnect > 2) {
                        conn.close();
                    }
                    return;
                }
                conn.p.time_speed_rebuild = System.currentTimeMillis() + 500L;
                conn.p.enough_time_disconnect = 0;
                UseItem.ProcessItem7(conn, m);
                break;
            }
            case 32: {
                if (conn.p.time_speed_rebuild > System.currentTimeMillis()) {
                    if (++conn.p.enough_time_disconnect > 2) {
                        conn.close();
                    }
                    return;
                }
                conn.p.time_speed_rebuild = System.currentTimeMillis() + 500L;
                conn.p.enough_time_disconnect = 0;
                UseItem.ProcessItem4(conn, m);
                break;
            }
            case 24: {
                Service.buy_item(conn.p, m);
                break;
            }
            case 18: {
                Service.sell_item(conn, m);
                break;
            }
            case 37: {
                // arena
                break;
            }
            case 65: {
            if (conn.p.type_process_chest == false) {
                conn.p.item.box_process(m);
                }else if (conn.p.type_process_chest == true) {
                conn.p.item.tui_process(m);
                }
                
                break;
            }
            case 44: {
                Service.pet_process(conn, m);
                break;
            }
            case 45: {
                Service.pet_eat(conn, m);
                break;
            }
            case 35: {
                conn.p.friend_process(m);
                break;
            }
            case 68: {
                conn.p.moithachdau_process(conn.p, m);

                break;
            }
            case 34: {
                Service.chat_tab(conn, m);
                break;
            }
            case 22: {
                conn.p.plus_point(m);
                break;
            }
            case -32: {
                Process_Yes_no_box.process(conn, m);
                break;
            }
            case -106: {
                Service.send_item7_template(conn.p, m);

                break;
            }
            case -97: {
                conn.p.down_mount(m);
                break;
            }
            case 28: {
                Service.send_in4_item(conn, m);
                break;
            }
            case 31: {
                // if (conn.p.map.map_id == 48) {
                // conn.p.dungeon.request_livefromdie(conn, m);
                // } else {
                // conn.p.map.request_livefromdie(conn, m);
                // }
                MapService.request_livefromdie(conn.p.map, conn, m);
                break;
            }
            case -31: {
                TextFromClient.process(conn, m);
                break;
            }
            case -53: {
                TextFromClient_2.process(conn, m);
                break;
            }
            case 21: {
                Service.send_param_item_wear(conn, m);
                break;
            }
            case 51: {
                conn.p.change_zone(conn, m);
                break;
            }
            case 42: {
                MapService.change_flag(conn.p.map, conn.p, m.reader().readByte());
                Service.send_char_main_in4(conn.p);
                break;
            }

            case 49: {
                Service.send_view_other_player_in4(conn, m);
                break;
            }
            case 71: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt, hãy kích hoạt");
                    return;
                }
                Service.chat_KTG(conn, m);
                if (conn.p.nv_tinh_tu[0] == 20 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
                    conn.p.nv_tinh_tu[1]++;
                }
                break;
            }
            case -30: {
                MenuController.processmenu(conn, m);
                break;
            }
            case 23: {
                MenuController.request_menu(conn, m);
                break;
            }
            case 27: {
                MapService.send_chat(conn.p.map, conn, m);
                break;
            }
            case 12: {
                conn.p.is_changemap = false;

                if (Map.is_map_chien_truong(conn.p.map.map_id)) {
                    ChienTruong.gI().send_info(conn.p);
                    //
                    Message m22 = new Message(4);
                    for (int i = 0; i < ChienTruong.gI().list_ai.size(); i++) {
                        LinhCanh p0 = ChienTruong.gI().list_ai.get(i);
                        if (!p0.isdie && p0.map.equals(conn.p.map)) {
                            m22.writer().writeByte(0);
                            m22.writer().writeShort(0);
                            m22.writer().writeShort(p0.id);
                            m22.writer().writeShort(p0.x);
                            m22.writer().writeShort(p0.y);
                            m22.writer().writeByte(-1);
                        }
                    }
                    if (m22.writer().size() > 0) {
                        for (int i = 0; i < conn.p.map.players.size(); i++) {
                            Player p0 = conn.p.map.players.get(i);
                            p0.conn.addmsg(m22);
                        }
                    }
                    m22.cleanup();
                }
                if (conn.p.map.map_id == 48) {
                    // weather map dungeon
                    Message mw = new Message(76);
                    mw.writer().writeByte(4);
                    mw.writer().writeShort(-1);
                    mw.writer().writeShort(-1);
                    conn.addmsg(mw);
                    mw.cleanup();
                }
//
//                m = new Message(76);
//                m.writer().writeByte(2);
//                m.writer().writeBoolean(true);
//                m.writer().writeShort(250); // Số lượng hạt
//                m.writer().writeShort(-1); // Thời gian tồn tại (ms)
//                conn.addmsg(m);
//                m.cleanup();

                break;
            }
            case -44: {
                Dungeon d = DungeonManager.get_list(conn.p.name);
                if (d != null) {
                    d.send_in4_npc(conn, m);
                }
                break;
            }
            case 5: {
                int id = m.reader().readShort();
                Leothap d = LeothapManager.get_list(conn.p.name);

                // Kiểm tra nếu id thuộc phạm vi MobAI
                if (id >= -1000 && id < 0) {
                    for (MobAi temp : conn.p.map.Ai_entrys) {
                        if (temp != null && temp.index == id) {
                            temp.send_in4(conn.p);
                            return;
                        }
                    }
                    id = Short.toUnsignedInt((short) id);
                }

                // Kiểm tra nếu id thuộc danh sách Player trong map
                Player targetPlayer = null;
                for (Player player : conn.p.map.players) {
                    if (player.index == id) {
                        targetPlayer = player;
                        break;
                    }
                }

                if (targetPlayer != null) {
                    // Gửi thông tin của Player
                    MapService.send_in4_other_char(conn.p.map, conn.p, targetPlayer);
                } else {
                    // Kiểm tra trong danh sách NhanBan
                    NhanBan targetNhanBan = null;
                    for (NhanBan nhanban : Manager.gI().list_nhanban) {
                        if (nhanban.index == id) {
                            targetNhanBan = nhanban;
                            break;
                        }
                    }

                    if (targetNhanBan != null) {
                        try {
                            // Gửi thông tin của NhanBan
                            targetNhanBan.send_in4(conn.p);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Kiểm tra trong danh sách CreatNb
                        Nbxx nb1 = null;
                        for (Nbxx nb : Manager.gI().list_nbxx) {
                            if (nb.index == id) {
                                nb1 = nb;
                                break;
                            }
                        }
                        Nbtd nb2 = null;
                        for (Nbtd nbz : Manager.gI().list_nbtd) {
                            if (nbz.index == id) {
                                nb2 = nbz;
                                break;
                            }
                        }

                        if (nb1 != null) {
                            try {
                                // Gửi thông tin của CreatNb
                                nb1.send_in4(conn.p);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (nb2 != null && conn.p.map.map_id == 126) {
                            try {
                                // Gửi thông tin của CreatNb
                                nb2.send_in4(conn.p);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (d != null) {
                            // Nếu thuộc về tháp Leothap
                            d.send_in4(conn.p, id);
                        } else if (Map.is_map_chien_truong(conn.p.map.map_id)) {
                            // Nếu thuộc về map chiến trường
                            ChienTruong.gI().get_ai(conn.p, id);
                        } else {
                            // Gửi thông báo nếu không tìm thấy
                            Message m3 = new Message(8);
                            m3.writer().writeShort(id);
                            conn.addmsg(m3);
                            m3.cleanup();
                        }
                    }
                }
                break;
            }

            case 7: {
                int n = Short.toUnsignedInt(m.reader().readShort());
                if (n >= 30_000 && n < 31_000)//mob event
                {
                    return;
                }
                if (n > 10_000 && n < 11_000) {//mob boss
                    conn.p.map.BossIn4(conn, n);
                    return;
                }
                Dungeon d = DungeonManager.get_list(conn.p.name);
                if (d != null) {
                    d.send_mob_in4(conn, n);
                } else {
                    Service.mob_in4(conn.p, n);
                }
                break;
            }
            case 4: {
                // if (conn.p.map.map_id == 48) {
                // conn.p.dungeon.send_move(conn.p, m);
                // } else {
                // conn.p.map.send_move(conn.p, m);
                // }
                MapService.send_move(conn.p.map, conn.p, m);
                break;
            }
            case -51: {
                Service.send_icon(conn, m);
                break;
            }

            case -52: {
                try {
                    byte type = m.reader().readByte();
                    short id = m.reader().readShort();
                    Message m2 = new Message(-52);
                    m2.writer().writeByte(type);
                    m2.writer().writeShort(id);
                    byte[] arrData = Util.loadfile("data/part_char/imgver/x" + conn.zoomlv + "/Data/" + (type + "_" + id));
                    byte[] arrImg = Util.loadfile("data/part_char/imgver/x" + conn.zoomlv + "/Img/" + (type + "_" + id) + ".png");
                    m2.writer().writeInt(arrImg.length);
                    m2.writer().write(arrImg);
                    m2.writer().write(arrData);
                    conn.addmsg(m2);
                    m2.cleanup();
                } catch (IOException e) {
                }
                break;
            }

            /*case -52: {
    try {
        // Đọc type và id từ Message
        byte type = m.reader().readByte();
        short id = m.reader().readShort();

        // Tạo đường dẫn cho dữ liệu và hình ảnh
        String dataPath = "data/part_char/imgver/x" + conn.zoomlv + "/Data/" + (type + "_" + id);
        String imgPath = "data/part_char/imgver/x" + conn.zoomlv + "/Img/" + (type + "_" + id) + ".png";

        // Log đường dẫn
        System.out.println("Đang tải file dữ liệu từ: " + dataPath);
        System.out.println("Đang tải file hình ảnh từ: " + imgPath);

        // Tải dữ liệu
        byte[] arrData = Util.loadfile(dataPath);
        byte[] arrImg = Util.loadfile(imgPath);

        // Log nếu tải thành công
        System.out.println("Tải file dữ liệu thành công: " + dataPath);
        System.out.println("Tải file hình ảnh thành công: " + imgPath);

        // Gửi thông điệp
        Message m2 = new Message(-52);
        m2.writer().writeByte(type);
        m2.writer().writeShort(id);
        m2.writer().writeInt(arrImg.length);
        m2.writer().write(arrImg);
        m2.writer().write(arrData);
        conn.addmsg(m2);
        m2.cleanup();

    } catch (IOException e) {
        // Log lỗi nếu xảy ra lỗi
       // System.err.println("Lỗi khi tải file với type: " + type + ", id: " + id);
        //System.err.println("Đường dẫn file dữ liệu: " + "data/part_char/imgver/x" + conn.zoomlv + "/Data/" + (type + "_" + id));
        //System.err.println("Đường dẫn file hình ảnh: " + "data/part_char/imgver/x" + conn.zoomlv + "/Img/" + (type + "_" + id) + ".png");
        e.printStackTrace();
    }
    break;
}*/
            //case 52:{
            // process(conn.p,m);
            //break;
            //}
            case 55: {
                Service.save_rms(conn, m);
                break;
            }
            case 59: {
                Service.send_health(conn.p);
                break;
            }
            case 13: {
                try {
                    login(m);
                } catch (Exception e) {
                    if (Manager.logErrorLogin) {
                        e.printStackTrace();
                    }
                    conn.close();
                }
                break;
            }
            case 14: {
                conn.char_create(m);
                break;
            }
            case 1: {
                if (!conn.get_in4) {
                    conn.getclientin4(m);
                }
                break;
            }
            case 61: {
                Service.send_msg_data(conn, 61, Manager.gI().msg_61);
                Service.send_item_template(conn);
                Service.send_msg_data(conn, 26, Manager.gI().msg_26);
                break;
            }
            case -103: { // click mob event
                try {
                    byte b = m.reader().readByte();
                    if (b != 0) {
                        break; // Thoát nếu b không hợp lệ
                    }
                    short id = (short) (m.reader().readShort() - 1000);

                    // Lấy đối tượng Mob dựa trên ID
                    MobCay mobCay = Event_2.getMob(id);
                    MobMiNuong mobMiNuong = Event_4.getMob(id);
                    MobFarm mobFarm = Farm.getMob(id, conn.p.index);
                    MobNpc mobNpc = Event_tet.getMob(id);

                    if (mobCay != null) {
                        // Xử lý menu cho MobCay
                        MenuController.send_menu_select(conn, id, new String[]{"Hái Quả"}, (byte) Manager.gI().event);
                    } else if (mobMiNuong != null) {
                        // Xử lý menu cho MobMiNuong
                        MenuController.send_menu_select(conn, id, new String[]{"Giải Cứu"}, (byte) Manager.gI().event);
                    } else if (mobFarm != null) {
                        // Xử lý menu cho MobFarm
                        handleMobFarmMenu(conn, mobFarm);
                    } else if (mobNpc != null) {
                        // Xử lý menu cho MobFarm
                        Menu_tet(conn, mobNpc);
                    } else {
                        // Kiểm tra nếu là Pet_mi_nuong
                        handlePetMiNuong(conn, id);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Service.send_notice_box(conn, "Đã xảy ra lỗi khi xử lý yêu cầu của bạn.");
                }
                break;
            }

            default: {
                System.out.println("default onRecieveMsg : " + m.cmd);
                break;
            }
        }
    }

    private void handleMobFarmMenu(Session conn, MobFarm mobFarm) throws IOException {
        if (mobFarm == null || mobFarm.nameOwner == null) {
            Service.send_notice_box(conn, "Ô đất này không khả dụng.");
            return;
        }

        if ("Đất Hoang".equals(mobFarm.nameOwner)) {

            MenuController.send_menu_select(conn, mobFarm.getId(), new String[]{"Mua Ô Đất"}, (byte) 1); // Mua Ô Đất
        } else if (mobFarm.name != null && mobFarm.name.startsWith("Cây")) {

            MenuController.send_menu_select(conn, mobFarm.getId(), new String[]{"Thu Hoạch"}, (byte) 3); // Thu Hoạch

        } else if ("Ô Đất".equals(mobFarm.name)) {

            MenuController.send_menu_select(conn, mobFarm.getId(), new String[]{"Trồng Cây"}, (byte) 2); // Trồng Cây
        } else if ("Gà".equals(mobFarm.chicken)) {
            if (mobFarm.hp < 10) {
                MenuController.send_menu_select(conn, mobFarm.getId(), new String[]{"Cho Ăn"}, (byte) 5); // cho ăn
            } else if (mobFarm.hp == 10 && mobFarm.level < 150) {
                MenuController.send_menu_select(conn, mobFarm.getId(), new String[]{"Nâng Cấp"}, (byte) 7); // nâng cấp
            }
        } else if ("Trứng".equals(mobFarm.chicken)) {
            MenuController.send_menu_select(conn, mobFarm.getId(), new String[]{"Thu Hoặch"}, (byte) 8); // Thu Hoạch
        } else {
            Service.send_notice_box(conn, "Bạn không sở hữu ô đất này...?");
        }
    }

    private void Menu_tet(Session conn, MobNpc mobNpc) throws IOException {
        if (mobNpc == null || mobNpc.nameOwner == null) {
            Service.send_notice_box(conn, "Npc Không Tồn tại.");
            return;
        }

        if ("Nồi Bánh".equals(mobNpc.nameOwner)) {
            MenuController.send_menu_select(conn, mobNpc.getId(), new String[]{"Thêm củi", "Hướng dẫn", "Thông Tin", "BXH Góp NL"}, (byte) 0);//
        } else if ("Cây Nêu".equals(mobNpc.nameOwner)) {
            MenuController.send_menu_select(conn, mobNpc.getId(), new String[]{"BXH Đốt Pháo", "BXH Mở Quà"}, (byte) 1);//
        } else if ("Cây Lì Xì".equals(mobNpc.nameOwner)) {
            MenuController.send_menu_select(conn, mobNpc.getId(), new String[]{"Đốt Pháo", "Hướng Dẫn"}, (byte) 2);//
        }

    }

    private void handlePetMiNuong(Session conn, short id) throws IOException {
        Pet_mi_nuong pet = Pet_mi_nuong_manager.check(id);
        if (conn.p.pet_mi_nuong != null) {
            if (conn.p.pet_mi_nuong.p.equals(conn.p)) {
                // Nếu là chủ nhân của Pet_mi_nuong
                MenuController.send_menu_select(conn, -13, new String[]{"Hôn Môi"}, (byte) Manager.gI().event);
            } else {
                // Nếu không phải chủ nhân
                Service.send_notice_box(conn, "Bạn không phải chủ nhân của Pet_mi_nuong này.");
            }
        } else {
            // Nếu Pet_mi_nuong không tồn tại
            Service.send_notice_box(conn, "Chúng Ta Không Thuộc Về Nhau");
        }
    }

    private void login(Message m) throws IOException, SQLException {
        if (conn.p == null) {
            m.reader().readByte(); // type login
            int id_player_login = m.reader().readInt();
            Player p0 = new Player(conn, id_player_login);

            if (p0 != null && p0.setup()) {
//                synchronized (Session.client_entrys) {
//                    
//                }
                for (int i = Session.client_entrys.size() - 1; i >= 0; i--) {
                    Session s = Session.client_entrys.get(i);
                    if (s == null || s.equals(conn) || s.user == null) {
                        continue;
                    }
                    if (s.get_in4 && s.id == conn.id && s.connected) {
                        try {
                            if (conn.socket.isConnected() && s.socket.isConnected()) {
                                System.out.println("-----errorLogin ----conn: " + conn.socket.getInetAddress() + "-----lastConnect: " + s.socket.getInetAddress());
                            } else {
                                System.out.println("+---- errorLogin ----+");
                            }
                        } catch (Exception e) {
                        }
                        conn.close();
                        s.close();
//                        synchronized (Session.client_entrys) {
//                            Session.client_entrys.remove(conn);
//                            if(Session.client_entrys.get(i).id == conn.id)
//                                Session.client_entrys.remove(i);
//                        }
                        return;
                    }
                }
                conn.p = p0;
                conn.p.set_in4();
                conn.SaveIP();
                MessageHandler.dataloginmap(conn);
            }
        }
    }

    public static void dataloginmap(Session conn) throws IOException, SQLException {
        Service.send_quest(conn);
        Service.send_auto_atk(conn);
        Service.send_char_main_in4(conn.p);
        Service.send_msg_data(conn, 1, Manager.gI().msg_1);
        Service.send_skill(conn.p);
        Service.send_login_rms(conn);
        Service.gui_sms(conn.p, 1);

        Service.send_notice_nobox_yellow(conn, ("Số người online : " + (Session.client_entrys.size() + 30)));
        send_notice_nobox_white(conn, ("Bang " + Manager.nameClanThue + " Đang Sở Hữu  Quyền Thu Thuế Trong Khu Mua Bán. " + "(" + " Thuế " + Manager.thue + " % " + ")"));
        Service.send_notice_nobox_yellow(conn, ("Bang " + Manager.nameClanThue + " - Đang Là Bang Hùng Mạnh Nhất Thế Giới Hiệp Sĩ"));
        if (Map.name_mo.equals(conn.p.name)) {
        }

        //  Service.send_notice_nobox_yellow(conn, ("Hiệp SĨ " + conn.p.name + " Hiện Tại Đang Là Người Hùng Mạnh Nhất Thế Giới Hiệp SĨ."));
        // add x2 xp
        conn.p.set_x2_xp(1);
        conn.p.time_k2 = 0;

        if (conn.p.map.zone_id == 1) {
            int max = conn.p.map.maxzone;
            int zone_random = (short) (Util.random(2, max--));
            conn.p.map = Map.get_map_by_id(conn.p.map.map_id)[zone_random];
            if (zone_random != 1 && zone_random != conn.p.map.maxzone) {
                MapService.enter(conn.p.map, conn.p);

            }
        }
        MapService.enter(conn.p.map, conn.p);

        //
        if (Map.name_mo.equals(conn.p.name)) {
            Manager.gI().chatKTGprocess("Chào Mừng Đại Hiệp Sĩ  " + conn.p.name + " Đã Đăng Nhập Vào Game");
        }

        if (conn.p.myclan != null && BXH.BXH_clan.indexOf(conn.p.myclan) < 1) {
            Manager.gI().chatKTGprocess("Chào Mừng Thủ lĩnh Bang " + (BXH.BXH_clan.indexOf(conn.p.myclan)) + conn.p.name + " Đăng Nhập Vào Game");
        }
    }

}
