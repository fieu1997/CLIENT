package map;

import BossHDL.BossManager;
import LeothapWeek.Boss_Leothap;
import LeothapWeek.Leothap;
import LeothapWeek.LeothapManager;
import ai.Fusion;
import ai.MobAi;
import ai.NhanBan;
import ai.LinhCanh;
import ai.LoanDau;
import ai.Nbtd;
import ai.Nbxx;
import ai.PlayerPoints;
import ai.khu2;
import client.Body2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import client.Clan;
import client.Pet;
import client.Player;
import client.Squire;
import core.BXH;
import core.Manager;
import core.MenuController;
import core.Service;
import core.Util;
import core.tools;
import ev_he.Event_tet;
import ev_he.Farm;
import ev_he.Farm.MobFarm;
import event_daily.ChiemMo;
import event_daily.ChiemThanhManager;
import event_daily.LoiDaiManager;
import event_daily.ChienTruong;
import event_daily.ChienTruong1;
import event_daily.CongNap;
//import event_daily.LoiDai;
import io.Message;
import io.Session;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import template.EffTemplate;
import template.Eff_TextFire;
import template.Item3;
import template.Level;
import template.LvSkill;
import template.MainObject;
import template.Mob_Dungeon;
import template.Mob_MoTaiNguyen;
import template.Option;
import template.Option_pet;
import template.Part_fashion;
import template.Part_player;
import template.Pet_di_buon;
import template.Pet_di_buon_manager;
import template.Pet_mi_nuong;
import template.StrucEff;

public class MapService {

    public int time_lc;
    public NhanBan nhanban;
    public NhanBan nhanban_save;

    public static void enter(Map map, Player p) throws IOException {

//        synchronized (map) {
//            if (!map.players.contains(p)) {
//            map.players.add(p);
//        }
//        }
        if (map.map_id == 50 && p.conn.vip >= 1) {// vip1
            List<MobFarm> playerMobs = Farm.playerMobFarms.get(p.index);
            if (playerMobs == null || playerMobs.isEmpty()) {
                Farm.LoadData(p, map);
            }
           
        }

        if (!map.players.contains(p)) {
            map.players.add(p);
        }
        if (p.isLiveSquire && p.squire != null) {
            Squire.squireEnterMap(p);
        }
         p.change_new_date();
        //
        if (p.isOwner) {
      if(p.diem_danh[3] == 0 && p.map.map_id == 1){
       new Thread(() -> {
        try {
            Thread.sleep(5000); // Sleep for 3 seconds
            if (p.item.get_bag_able() < 3) {
                    Service.send_notice_nobox_white(p.conn, "Cần 3 ô trống!");
                    return;
                } 
            p.qua_ngay(p);      
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }).start();
      }}
        //
        try {
            // if (map.map_id != 48) {
            if (map.zone_id == map.maxzone && !map.isMapLoiDai() && !map.isMapChiemThanh()) {
                MapService.change_flag(map, p, -1);
            }

            Service.sendQuestFinish(p.conn);
            Service.sendQuestDoing(p.conn);
            Service.sendQuestList(p.conn);

            map.send_map_data(p);
            Service.send_char_main_in4(p);
            Service.send_combo(p.conn);
            Service.send_point_pk(p);
            Service.send_health(p);
            Service.send_wear(p);

            List<Integer> defaul = new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            List<Integer> pks = new ArrayList<>();
            if (Map.is_map_chiem_mo(map, true) && Manager.gI().chiem_mo.isRunning()) {
                int typepk = -1;
                for (Player pl : map.players) {
                    if (pl.index == p.index || pl.typepk == -1 || pl.is_nhanban) {
                        continue;
                    }
                    if (p.myclan != null && pl.myclan != null) {
                        if (pl.myclan.name_clan.equals(p.myclan.name_clan)) {
                            typepk = pl.typepk;
                            break;
                        }
                    }

                    pks.add((int) pl.typepk);
                }
                if (typepk == -1) {
                    Integer t = Util.random(defaul, pks);
                    if (t != null) {
                        typepk = t;
                    } else {
                        typepk = Util.random(1, 10);
                    }
                }
                Message m = new Message(42);
                m.writer().writeShort(p.index);
                m.writer().writeByte(typepk);
                p.typepk = (byte) typepk;
                MapService.send_msg_player_inside(map, p, m, true);
                m.cleanup();
            }
            // }
            if (p.party != null) {
                p.party.sendin4();
            }
            long _time = System.currentTimeMillis();
            if (map.ld2 != null && !map.ld2.isMapStart && (map.ld2.namePlayerWin == null || map.ld2.namePlayerWin.equals(""))) {
                Message m = new Message(-104);
                m.writer().writeByte(1);
                m.writer().writeByte(2);
                m.writer().writeShort((int) ((LoiDaiManager.timeTurn - _time) / 1000));
                m.writer().writeUTF("Lôi đài");
                m.writer().writeShort((int) ((map.ld2.timeSleep - _time) / 1000) + 1);
                m.writer().writeUTF("Trận đấu sẽ bắt đầu sau");
                p.conn.addmsg(m);
                m.cleanup();
            }
            if (map.isMapChiemThanh()) {
                ChiemThanhManager.SenDataTime(p.conn);
            }

            // thap
            if (map.lt != null && map.lt.time_lt > 0) {
                Message m = new Message(-104);
                m.writer().writeByte(1);
                m.writer().writeByte(2);
                m.writer().writeShort((int) ((map.lt.time_lt - _time) / 1000));
                m.writer().writeUTF("Leo Tháp");
                m.writer().writeShort(-1);
                m.writer().writeUTF("");
                p.conn.addmsg(m);
                m.cleanup();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        p.other_player_inside.clear();
        p.other_mob_inside.clear();
        p.other_mob_inside_update.clear();
    }

    public static void leave_by_loidai(Map map, Player p) {
        if (map.players.contains(p)) {
            map.players.remove(p);
        }
        try {
            Message m = new Message(8);
            m.writer().writeShort(p.index);
            send_msg_player_inside(map, p, m, false);
            m.cleanup();
            m = new Message(-104);
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leave(Map map, Player p) {
        // Kiểm tra nếu người chơi có trong danh sách người chơi của bản đồ và loại bỏ họ
        if (map.players.contains(p)) {
            map.players.remove(p);
        }

        // Nếu người chơi có Squire đi theo, đảm bảo Squire cũng được loại bỏ khỏi bản đồ
        if (p.isLiveSquire && p.squire != null) {
            Squire.squireLeaveMap(p);  // Gọi hàm để loại bỏ Squire khỏi map
        }

        // Xử lý các hiệu ứng hoặc trạng thái khác khi người chơi rời khỏi bản đồ
        try {
            if (map.map_id == 87) {
                ChiemThanhManager.PlayerDie(p);  // Xử lý nếu người chơi chết trong bản đồ chiếm thành
            }

            if (map.ld2 != null) {
                // Xử lý khi người chơi rời khỏi map có đấu trường lôi đài
                map.ld2.PlayerLeaveMap(p);
                Message m = new Message(8);
                m.writer().writeShort(p.index);
                send_msg_player_inside(map, p, m, false);  // Thông báo tới các người chơi khác trong bản đồ
                m.cleanup();
                m = new Message(-104);
                m.writer().writeByte(1);
                m.writer().writeByte(0);
                p.conn.addmsg(m);
                m.cleanup();
            } else {
                // Thông báo cho các người chơi khác trong bản đồ về việc người chơi đã rời đi
                Message m = new Message(8);
                m.writer().writeShort(p.index);
                send_msg_player_inside(map, p, m, false);
                m.cleanup();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send_msg_player_inside(Map map, MainObject mainObj, Message m, boolean included) {
        for (int i = 0; i < map.players.size(); i++) {
            Player p0 = map.players.get(i);
            if (p0 != null && !p0.isSquire && ((Math.abs(p0.x - mainObj.x) < 1500 && Math.abs(p0.y - mainObj.y) < 1500)
                    || Map.is_map__load_board_player(map.map_id)) && (included || (mainObj.index != p0.index))) {
                p0.conn.addmsg(m);
            }
        }
    }

    public static void update_in4_2_other_inside(Map map, Player p) throws IOException {
        long _time = System.currentTimeMillis();
        if (p.get_EffMe_Kham(StrucEff.TangHinh) != null) {
            return;
        }
        for (int i = 0; i < map.players.size(); i++) {
            Player p0 = map.players.get(i);
            if (p0.index != p.index && !p0.isSquire && ((Math.abs(p0.x - p.x) < 1500 && Math.abs(p0.y - p.y) < 1500)
                    || Map.is_map__load_board_player(map.map_id))) {
                MapService.send_in4_other_char(map, p0, p);
            }
        }
    }

public static Mob_in_map findNearestMob(Map map, Player player) {
        Mob_in_map nearest = null;
        int minDistance = 200; // Phạm vi tìm kiếm

        for (Mob_in_map mob : map.mobs) {
            if (!mob.isdie) {
                int distance = Math.abs(mob.x - player.x) + Math.abs(mob.y - player.y);
                if (distance < minDistance) {
                    nearest = mob;
                    minDistance = distance;
                }
            }
        }

        return nearest;
    }
    public static void send_move(Map map, Player p, Message m2) throws IOException {

        short mx = m2.reader().readShort();
        short my = m2.reader().readShort();
        boolean changeee = false;
        Session conn = p.conn;
        
        
        if (p.isOwner && conn.p.nv_tinh_tu[0] == 17 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
            conn.p.nv_tinh_tu[1] += (Math.abs(mx - p.y) + Math.abs(my - p.x));

            return;
        }
        // Loan dau
        LoanDau.LoanDau_map(p);
//
       
        //
        if (p.is_changemap && (!map.isMapChiemThanh() || ChiemThanhManager.isChangeMap(map))) {
            for (Vgo vgo : map.vgos) {
                if (Math.abs(vgo.x_old - p.x) < 40 && Math.abs(vgo.y_old - p.y) < 40) {
                    boolean ch = true;
                    if (Map.is_map_chien_truong(map.map_id)) {
                        switch (map.map_id) {
                            case 54: {
                                if (vgo.id_map_go == 53 && p.typepk != 5) {
                                    ch = false;
                                }
                                break;
                            }
                            case 56: {
                                if (vgo.id_map_go == 55 && p.typepk != 2) {
                                    ch = false;
                                }
                                break;
                            }
                            case 58: {
                                if (vgo.id_map_go == 57 && p.typepk != 4) {
                                    ch = false;
                                }
                                break;
                            }
                            case 60: {
                                if (vgo.id_map_go == 59 && p.typepk != 1) {
                                    ch = false;
                                }
                                break;
                            }
                        }
                    }
                    if (ch) {
                        p.change_map(p, vgo);
                        changeee = true;
                    }
                    return;
                }
            }
        }
        long _time = System.currentTimeMillis();
        if (Math.abs(p.x - mx) > (300) || Math.abs(p.y - my) > 300) {
            Message m = new Message(4);
            m.writer().writeByte(0);
            m.writer().writeShort(0);
            m.writer().writeShort(p.index);
            m.writer().writeShort(p.x);
            m.writer().writeShort(p.y);
            m.writer().writeByte(-1);
            p.conn.addmsg(m);
            m.cleanup();
            return;
        }
        p.time_move = _time;
        p.x = mx;
        p.y = my;
        if (p.is_changemap && p.timeCantChangeMap < _time && (map.map_id < 83 || map.map_id > 86)) {
            for (Vgo vgo : map.vgos) {
                if (Math.abs(vgo.x_old - p.x) < 40 && Math.abs(vgo.y_old - p.y) < 40) {
                    p.change_map(p, vgo);
                    return;
                }
            }
        } else if (!(Math.abs(p.x_old - p.x) < 45 && Math.abs(p.y_old - p.y) < 45)) {
            p.is_changemap = true;
        }
        //
        if (map.map_id != 50) {
            Message m = new Message(4);
            m.writer().writeByte(0);
            m.writer().writeShort(0);
            m.writer().writeShort(p.index);
            m.writer().writeShort(p.x);
            m.writer().writeShort(p.y);
            m.writer().writeByte(-1);
            //
            MapService.update_inside_player(map, m, p);
            //
            m.cleanup();
        }

        if (p.pet_di_buon != null && p.pet_di_buon.id_map == p.map.map_id && p.map.zone_id == p.map.maxzone) {
            if (p.pet_di_buon.time_move < System.currentTimeMillis()) {
                p.pet_di_buon.time_move = System.currentTimeMillis() + 1000L;
                if (Math.abs(p.pet_di_buon.x - p.x) < (85 * p.pet_di_buon.speed)
                        && Math.abs(p.pet_di_buon.y - p.y) < (85 * p.pet_di_buon.speed)) {
                    p.pet_di_buon.x = p.x;
                    p.pet_di_buon.y = p.y;
                    if (p.pet_di_buon.speed != 1 && p.pet_di_buon.time_skill < System.currentTimeMillis()) {
                        p.pet_di_buon.speed = 1;
                        //
                        System.out.println("map.MapService.send_move()111");
                        Message mm = new Message(7);
                        mm.writer().writeShort(p.pet_di_buon.index);
                        mm.writer().writeByte((byte) 120);
                        mm.writer().writeShort(p.pet_di_buon.x);
                        mm.writer().writeShort(p.pet_di_buon.y);
                        mm.writer().writeInt(p.pet_di_buon.hp);
                        mm.writer().writeInt(p.pet_di_buon.get_HpMax());
                        mm.writer().writeByte(0);
                        mm.writer().writeInt(-1);
                        mm.writer().writeShort(-1);
                        mm.writer().writeByte(1);
                        mm.writer().writeByte(p.pet_di_buon.speed);
                        mm.writer().writeByte(0);
                        mm.writer().writeUTF(p.pet_di_buon.name);
                        mm.writer().writeLong(-11111);
                        mm.writer().writeByte(4);
                        for (int i = 0; i < map.players.size(); i++) {
                            Player p0 = map.players.get(i);
                            if (p0 != null) {
                                p0.conn.addmsg(mm);
                            }
                        }
                        mm.cleanup();
                    }
                }
                Message m22 = new Message(4);
                m22.writer().writeByte(1);
                m22.writer().writeShort(131);
                m22.writer().writeShort(p.pet_di_buon.index);
                m22.writer().writeShort(p.pet_di_buon.x);
                m22.writer().writeShort(p.pet_di_buon.y);
                m22.writer().writeByte(-1);
                for (int i = 0; i < map.players.size(); i++) {
                    Player p0 = map.players.get(i);
                    if (p0 != null) {
                        p0.conn.addmsg(m22);
                    }
                }
                m22.cleanup();
            }
        }
        // Mị

        if (p.pet_mi_nuong != null && p.pet_mi_nuong.id_map == p.map.map_id) {
            if (p.pet_mi_nuong.time_move < System.currentTimeMillis()) {
                p.pet_mi_nuong.time_move = System.currentTimeMillis() + 1000L;
                if (Math.abs(p.pet_mi_nuong.x - p.x) < (85 * p.pet_mi_nuong.speed)
                        && Math.abs(p.pet_mi_nuong.y - p.y) < (85 * p.pet_mi_nuong.speed)) {
                    p.pet_mi_nuong.x = p.x;
                    p.pet_mi_nuong.y = p.y;
                    if (p.pet_mi_nuong.speed != 1 && p.pet_mi_nuong.time_skill < System.currentTimeMillis()) {
                        p.pet_mi_nuong.speed = 1;
                        //
                        System.out.println("map.MapService.send_move()111");
                        Message mm = new Message(7);
                        mm.writer().writeShort(p.pet_mi_nuong.index);
                        mm.writer().writeByte((byte) 120);
                        mm.writer().writeShort(p.pet_mi_nuong.x);
                        mm.writer().writeShort(p.pet_mi_nuong.y);
                        mm.writer().writeInt(p.pet_mi_nuong.hp);
                        mm.writer().writeInt(p.pet_mi_nuong.get_HpMax());
                        mm.writer().writeByte(0);
                        mm.writer().writeInt(-1);
                        mm.writer().writeShort(-1);
                        mm.writer().writeByte(1);
                        mm.writer().writeByte(p.pet_mi_nuong.speed);
                        mm.writer().writeByte(0);
                        mm.writer().writeUTF(p.pet_mi_nuong.name);
                        mm.writer().writeLong(-11111);
                        mm.writer().writeByte(4);
                        for (int i = 0; i < map.players.size(); i++) {
                            Player p0 = map.players.get(i);
                            if (p0 != null) {
                                p0.conn.addmsg(mm);
                            }
                        }
                        mm.cleanup();
                    }
                }
                Message m22 = new Message(4);
                m22.writer().writeByte(1);
                m22.writer().writeShort(150);
                m22.writer().writeShort(p.pet_mi_nuong.index);
                m22.writer().writeShort(p.pet_mi_nuong.x);
                m22.writer().writeShort(p.pet_mi_nuong.y);
                m22.writer().writeByte(-1);
                for (int i = 0; i < map.players.size(); i++) {
                    Player p0 = map.players.get(i);
                    if (p0 != null) {
                        p0.conn.addmsg(m22);
                    }
                }
                m22.cleanup();

            }
        }
        //
    }

    public static void update_inside_player(Map map, Message m, Player p) throws IOException {
        Message m4 = new Message(4);
        for (ev_he.MobCay temp : map.mobEvens) {
            if ((Math.abs(temp.x - p.x) < 300 && Math.abs(temp.y - p.y) < 300) || Map.is_map__load_board_player(map.map_id)) {

                if (!p.other_mob_inside.containsKey((int) temp.index)) {
                    p.other_mob_inside.put((int) temp.index, true);
                }
                if (!p.other_mob_inside_update.containsKey((int) temp.index)) {
                    p.other_mob_inside_update.put((int) temp.index, false);
                }
                if (p.other_mob_inside.get((int) temp.index)) {
                    temp.SendMob(p.conn);
                    p.other_mob_inside.replace((int) temp.index, true, false);
                }
            }
        }
        //
        for (Event_tet.MobNpc temp : map.mobnpc) {
        if ((Math.abs(temp.x - p.x) < 300 && Math.abs(temp.y - p.y) < 300) || Map.is_map__load_board_player(map.map_id)) {
            if (!p.other_mob_inside.containsKey((int) temp.index)) {
                p.other_mob_inside.put((int) temp.index, true);
            }
            if (!p.other_mob_inside_update.containsKey((int) temp.index)) {
                p.other_mob_inside_update.put((int) temp.index, false);
            } 
            if (p.other_mob_inside.get((int) temp.index)) {
                temp.SendMob(p.conn);
                p.other_mob_inside.replace((int) temp.index, true, false);
            }
        }
    }
        //
        for (ev_he.MobMiNuong temp : map.mobEvent4) {
            if ((Math.abs(temp.x - p.x) < 300 && Math.abs(temp.y - p.y) < 300) || Map.is_map__load_board_player(map.map_id)) {

                if (!p.other_mob_inside.containsKey((int) temp.index)) {
                    p.other_mob_inside.put((int) temp.index, true);
                }
                if (!p.other_mob_inside_update.containsKey((int) temp.index)) {
                    p.other_mob_inside_update.put((int) temp.index, false);
                }
                if (p.other_mob_inside.get((int) temp.index)) {
                    temp.SendMob(p.conn);
                    p.other_mob_inside.replace((int) temp.index, true, false);
                }
            }
        }
        //

        //
        for (Mob_in_map temp : map.Boss_entrys) {
            if (temp.isdie) {
                continue;
            }
            if ((Math.abs(temp.x - p.x) < 200 && Math.abs(temp.y - p.y) < 200)
                    || Map.is_map__load_board_player(map.map_id)) {
                if (!temp.list_fight.contains(p)
                        && ((temp.template.mob_id == 151 || temp.template.mob_id == 152 || temp.template.mob_id == 154) || temp.isBoss()
                        || ((Math.abs(temp.x - p.x) < 50) && (Math.abs(temp.y - p.y) < 50)))) {
                    temp.list_fight.add(p);
                }
                if (!p.other_mob_inside.containsKey(temp.index)) {
                    p.other_mob_inside.put(temp.index, true);
                }
                if (!p.other_mob_inside_update.containsKey(temp.index)) {
                    p.other_mob_inside_update.put(temp.index, false);
                }
                if (p.other_mob_inside.get(temp.index)) {
                    m4.writer().writeByte(1);
                    m4.writer().writeShort(temp.template.mob_id);
                    m4.writer().writeShort(temp.index);
                    m4.writer().writeShort(temp.x);
                    m4.writer().writeShort(temp.y);
                    m4.writer().writeByte(-1);
                    p.other_mob_inside.replace(temp.index, true, false);
                } else if (p.other_mob_inside_update.get(temp.index)) {
                    //
                    map.BossIn4(p.conn, temp.index);
                    //Service.mob_in4(p, temp.index);
                    p.other_mob_inside_update.replace(temp.index, true, false);
                }
            } else if (p.other_mob_inside_update.containsKey(temp.index) && !p.other_mob_inside_update.get(temp.index)) {
                p.other_mob_inside_update.replace(temp.index, false, true);
            }
        }

        for (Mob_in_map temp : map.mobs) {
            if (temp.isdie && !(temp.template.mob_id >= 89 && temp.template.mob_id <= 92)) {
                continue;
            }
            // Ngọc

            if ((Math.abs(temp.x - p.x) < 200 && Math.abs(temp.y - p.y) < 200)
                    || Map.is_map__load_board_player(map.map_id)) {
                if (!temp.list_fight.contains(p)
                        && ((temp.template.mob_id == 151 || temp.template.mob_id == 152 || temp.template.mob_id == 154) || temp.isBoss()
                        || ((Math.abs(temp.x - p.x) < 50) && (Math.abs(temp.y - p.y) < 50)))) {
                    temp.list_fight.add(p);
                }
                if (!p.other_mob_inside.containsKey(temp.index)) {

                    p.other_mob_inside.put(temp.index, true);
                }
                if (!p.other_mob_inside_update.containsKey(temp.index)) {

                    p.other_mob_inside_update.put(temp.index, false);
                }
                if (p.other_mob_inside.get(temp.index)) {
                    m4.writer().writeByte(1);
                    m4.writer().writeShort(temp.template.mob_id);
                    m4.writer().writeShort(temp.index);
                    m4.writer().writeShort(temp.x);
                    m4.writer().writeShort(temp.y);
                    m4.writer().writeByte(-1);

                    p.other_mob_inside.replace(temp.index, true, false);
                } else if (p.other_mob_inside_update.get(temp.index)) {

                    Service.mob_in4(p, temp.index);
                    p.other_mob_inside_update.replace(temp.index, true, false);
                }
            } else if (p.other_mob_inside_update.containsKey(temp.index) && !p.other_mob_inside_update.get(temp.index)) {

                p.other_mob_inside_update.replace(temp.index, false, true);
            }
        }

        
        long _time = System.currentTimeMillis();
        boolean isth = p.get_EffMe_Kham(StrucEff.TangHinh) != null;
        for (int i = 0; i < map.players.size() && !isth; i++) {
            Player p0 = map.players.get(i);
            if (p0.index == p.index) {
                continue;
            }
            if (p0.isSquire) {
                continue;
            }
           if ((Math.abs(p0.x - p.x) < 200 && Math.abs(p0.y - p.y) < 200) || Map.is_map__load_board_player(map.map_id)) {
    // Kiểm tra điều kiện hiển thị hai chiều
    boolean pSeesP0 = false; // p thấy p0
    boolean p0SeesP = false; // p0 thấy p

    // Trường hợp 1: Cả hai đều là Squire ở chế độ người chơi (isOwner = false)
    if (!p.isOwner && !p0.isOwner) {
        pSeesP0 = true;
        p0SeesP = true; // Hai Squire ở chế độ người chơi thấy nhau
    }
    // Trường hợp 2: p là Player (isOwner = true) và p0 là Squire đi theo của p (isOwner = false)
    else if (p.isOwner && !p0.isOwner && p0.conn.p == p && p.isLiveSquire) {
        pSeesP0 = true; // Player thấy Squire đi theo
        p0SeesP = true; // Squire đi theo thấy Player
    }
    // Trường hợp 3: p0 là Player (isOwner = true) và p là Squire đi theo của p0 (isOwner = false)
    else if (!p.isOwner && p0.isOwner && p.conn.p == p0 && p0.isLiveSquire) {
        pSeesP0 = true; // Squire đi theo thấy Player
        p0SeesP = true; // Player thấy Squire đi theo
    }
    // Trường hợp 4: Cả hai đều là Player (isOwner = true)
    else if (p.isOwner && p0.isOwner) {
        pSeesP0 = true;
        p0SeesP = true; // Hai Player thấy nhau
    }

    // Xử lý hiển thị
    if (p0SeesP) {
        p0.conn.addmsg(m); // Gửi thông tin di chuyển của p tới p0
    }
    if (pSeesP0) {
        if (!p.other_player_inside.containsKey(p0.index)) {
            p.other_player_inside.put(p0.index, true);
        }
        if (p.other_player_inside.get(p0.index)) {
            m4.writer().writeByte(0);
            m4.writer().writeShort(0);
            m4.writer().writeShort(p0.index);
            m4.writer().writeShort(p0.x);
            m4.writer().writeShort(p0.y);
            m4.writer().writeByte(-1);
            p.other_player_inside.replace(p0.index, true, false);
        }
    }
}
            else 
            
            if (p.other_player_inside.containsKey(p0.index)) {
                Message m3 = new Message(8);
                m3.writer().writeShort(p.index);
                p0.conn.addmsg(m3);
                m3.cleanup();
                m3 = new Message(8);
                m3.writer().writeShort(p0.index);
                p.conn.addmsg(m3);
                m3.cleanup();
                p.other_player_inside.remove(p0.index);
            }
        }
        if (m4.writer().size() > 0) {
            p.conn.addmsg(m4);
        }
        m4.cleanup();
    }

    public static Mob_in_map get_mob_by_index(Map map, int n) {
        if (map != null) {
            for (Mob_in_map m : map.mobs) {
                if (m.index == n) {
                    return m;
                }
            }
        }
        return null;
    }

// quái tấn công người chơi
    public static void mob_fire(Map map, Mob_in_map mob, Player p_target, int dame) throws IOException {
        //Service.send_notice_nobox_white(p_target.conn, "test 4");
        if (mob.template.mob_id >= 89 && mob.template.mob_id <= 92) {
            return;
        }

        if (mob.template.mob_id == 0) {
            p_target.bienroombi((short) 4740);
        }

        // Tấn công Player hoặc Squire (nếu p_target là Squire)
        Message m = new Message(10);
        m.writer().writeByte(1);
        m.writer().writeShort(mob.index);
        m.writer().writeInt(mob.hp);
        m.writer().writeByte(0);
        m.writer().writeByte(1);
        m.writer().writeShort(p_target.index);
        m.writer().writeInt(dame); // dame gây ra bởi mob
        m.writer().writeInt(p_target.hp);
        m.writer().writeByte(2); // id skill mob
        m.writer().writeByte(0);
        MapService.send_msg_player_inside(map, p_target, m, true);
        m.cleanup();

        // Logic kỹ năng đặc biệt của boss (gây choáng)
        int percent_stun = 0;
        int time_stun = 0;
        if (mob.isBoss()) {
            int sizelv = p_target.level - mob.level;
            if (mob.template.mob_id == 174 || mob.level >= 120) {
                sizelv = 0;
            } else if (Map.is_map_cant_save_site(mob.map_id)) {
                sizelv = 0;
            }
            switch (sizelv) {
                case 5:
                case 4:
                case 3:
                case 2:
                case 1:
                case 0: {
                    percent_stun = 15;
                    time_stun = 2;
                    break;
                }
                default: {
                    dame *= 50;
                    percent_stun = 50;
                    time_stun = 5;
                    break;
                }
            }
        }

        // Kiểm tra hiệu ứng Ngọc Khải Hoàn của Player
        if (p_target.get_EffMe_Kham(StrucEff.NgocKhaiHoan) != null) {
            return;
        }

        // Áp dụng hiệu ứng choáng nếu là Boss và có tỷ lệ choáng
        if (mob.isBoss() && (percent_stun > Util.random(0, 100))) {
            if (!p_target.isStunes(false)) {
                MapService.add_eff_stun(map, mob, p_target, time_stun, Util.random(4, 8));
            }
        }

        // Nếu Player có đệ tử đang đi theo (isLiveSquire)
        if (p_target.isLiveSquire && p_target.squire != null) {
            Squire squire = p_target.squire;
            squire.hp -= dame;
            // Tấn công đệ tử (Squire đi theo)
            Message m2 = new Message(10);
            m2.writer().writeByte(1);
            m2.writer().writeShort(mob.index);
            m2.writer().writeInt(mob.hp);
            m2.writer().writeByte(0);
            m2.writer().writeByte(1);
            m2.writer().writeShort(squire.index);  // Đánh vào Squire đi theo
            m2.writer().writeInt(dame); // dame mob gây ra cho Squire đi theo
            m2.writer().writeInt(squire.hp);
            m2.writer().writeByte(2); // id skill mob
            m2.writer().writeByte(0);
            if (p_target.squire.hp > 0) {
                MapService.send_msg_player_inside(map, p_target.squire, m2, true);
            } // Kiểm tra nếu HP <= 0 và chưa gọi tin nhắn "chết" (onefire = false)
            else if (!squire.onefire && p_target.squire.hp <= 0) {
                // Gọi tin nhắn một lần duy nhất khi Squire chết
                MapService.send_msg_player_inside(map, p_target.squire, m2, true);
                squire.onefire = true; // Đánh dấu đã gửi tin nhắn "chết"
            }

            m2.cleanup();

            // Áp dụng hiệu ứng choáng cho Squire đi theo nếu là Boss
            if (mob.isBoss() && (percent_stun > Util.random(0, 100))) {
                if (!squire.isStunes(false)) {
                    MapService.add_eff_stun(map, mob, squire, time_stun, Util.random(4, 8));
                }
            }
        }

        // Nếu Player mục tiêu cũng là Squire (Player Squire)
        if (p_target instanceof Squire) {
            // Thực hiện logic tấn công đặc biệt nếu Player là Squire
            Squire playerSquire = (Squire) p_target;

            // Áp dụng logic riêng cho Squire nếu cần (tương tự như với Player)
            Message m3 = new Message(10);
            m3.writer().writeByte(1);
            m3.writer().writeShort(mob.index);
            m3.writer().writeInt(mob.hp);
            m3.writer().writeByte(0);
            m3.writer().writeByte(1);
            m3.writer().writeShort(playerSquire.index);  // Đánh vào Player Squire
            m3.writer().writeInt(dame); // dame mob gây ra cho Player Squire
            m3.writer().writeInt(playerSquire.hp);
            m3.writer().writeByte(2); // id skill mob
            m3.writer().writeByte(0);
            MapService.send_msg_player_inside(map, playerSquire, m3, true);
            m3.cleanup();

            // Áp dụng choáng cho Player Squire nếu là Boss
            if (mob.isBoss() && (percent_stun > Util.random(0, 100))) {
                if (!playerSquire.isStunes(false)) {
                    MapService.add_eff_stun(map, mob, playerSquire, time_stun, Util.random(4, 8));
                }
            }
        }

    }

    private static void add_eff_stun(Map map, MainObject mainObj, MainObject focus, int time, int type)
            throws IOException {
        if (focus == null) {
            return;
        }
        Message m = new Message(75);
        m.writer().writeByte(type);
        m.writer().writeByte(focus.get_TypeObj());
        m.writer().writeShort(focus.index);
        m.writer().writeShort(time);
        m.writer().writeByte(0);
        m.writer().writeShort(mainObj.index);
        MapService.send_msg_player_inside(map, focus, m, true);
        m.cleanup();
        //
        int time_ = 1000 * time;
        switch (type) {
            case 7: {
                focus.add_EffDefault(-124, 1000, time_);
                break;
            }
            case 4: {
                focus.add_EffDefault(-123, 1000, time_);
                break;
            }
            case 5: {
                focus.add_EffDefault(-122, 1000, time_);
                break;
            }
            case 6: {
                focus.add_EffDefault(-121, 1000, time_);
                break;
            }
        }
    }

    public static void change_flag(Map map, Player p_target, int type) throws IOException {

        if (map.map_id == 124 || map.map_id == 125) {
            if (type != 0) { // If attempting to change to any type other than 0
                Service.send_notice_box(p_target.conn, "Không Thể Đổi ở Máp này!");
               // type = 0; // Force type to 0 regardless of the input
            }
            //type = 0;
            // Set the flag type to 0 and send a message
            Message m = new Message(42);
            m.writer().writeShort(p_target.index);
            m.writer().writeByte(type);
            p_target.typepk = (byte) type;
            MapService.send_msg_player_inside(map, p_target, m, true);
            m.cleanup();
            return; // Prevent any other flag changes in map 118
        }
        if ((map.zone_id == map.maxzone && type != -1 && p_target.item.wear[11] != null && p_target.item.wear[11].id != 3593)
                || map.isMapLoiDai() || map.isMapChiemThanh()) {
            Service.send_notice_box(p_target.conn, "Không thể thực hiện!");
            return;
        }
        if (!khu2.isDont_khu2(map.map_id) && map.zone_id == 1) {
            if (!p_target.isSquire) {
            Service.send_notice_box(p_target.conn, "Không thể thực hiện ở khu 2!");
            }
            return;
        }
        if (Map.is_map_chien_truong(map.map_id)) {
            return;
        }
        if ((Map.is_map_chiem_mo(map, true) && Manager.gI().chiem_mo.isRunning()) || map.ld2 != null) {
            if (!p_target.isSquire) { // Chỉ cấm khi không phải đệ tử
                Service.send_notice_box(p_target.conn, "Bạn không thể thực hiện hành động này!");
                return;
            }
        }
        if (map.map_id != 52 && map.zone_id == map.maxzone) {
            if (p_target.item.wear[11] != null && p_target.item.wear[11].id != 3593) {
                type = 11;
            } else if (p_target.item.wear[11] != null && p_target.item.wear[11].id != 3599) {
                type = 12;
            }
        }
        Message m = new Message(42);
        m.writer().writeShort(p_target.index);
        m.writer().writeByte(type);
        p_target.typepk = (byte) type;
        MapService.send_msg_player_inside(map, p_target, m, true);
        m.cleanup();
    }

    @SuppressWarnings("unused")
    public static void buff_skill(Map map, Session conn, Message m2) throws IOException {
        byte type = m2.reader().readByte();
        byte tem = m2.reader().readByte();
        byte size_buff = m2.reader().readByte();
        // System.out.println(type);
        // System.out.println(tem);
        // System.out.println(size_buff);
        MapService.add_eff_skill(map, conn.p, null, type);
        for (int i = 0; i < size_buff; i++) {
            int id = Short.toUnsignedInt(m2.reader().readShort());
            // System.out.println(id);
        }
    }

    public static void add_eff_skill(Map map, Player p, Player p2, byte index_skill) throws IOException {
        int sk_point = p.body.get_skill_point(index_skill);
        if (sk_point < 1) {
            return;
        }
        int time_buff = p.skills[index_skill].mLvSkill[sk_point - 1].timeBuff;
        int range = p.skills[index_skill].mLvSkill[sk_point - 1].range_lan;
        int n_target = p.skills[index_skill].mLvSkill[sk_point - 1].nTarget - 1;
        switch (p.clazz) {
            case 0: {

                if (index_skill == 18) {
                    if (p.skill_new[0] <= 0) {
                        p.add_EffDefault(23, 1000, 60_000);
                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();
                        MapService.send_eff_other(p.map, p, 23);
                        Service.send_char_main_in4(p);
                    } else if (p.skill_new[0] >= 1) {
                        MapService.callNbxx(map, p);

                        for (int i = 23; i <= 26; i++) {
                            p.add_EffDefault(i, 1000, 60_000);
                            MapService.send_eff_other(p.map, p, i);
                        }

                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();

                        Service.send_char_main_in4(p);
                    }
                } else if (index_skill == 13) {
                    byte[] id_sk = new byte[]{15, 35};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 14) {
                    byte[] id_sk = new byte[]{33, 9, 7};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1]), p.get_pramskill_byid(index_skill, id_sk[2])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 17 && p2 != null) {
                    // 7 choáng , 6 ru ngủ , 5 đóng băng, 4 khóa chân
                    MapService.add_eff_stun(map, p, p2, 5, 4);
                } else if (index_skill == 1) {
                    Service.send_notice_nobox_white(p.conn, "test555");
                }
                break;
            }
            case 1: {
                if (index_skill == 18) {
                    if (p.skill_new[0] <= 0) {
                        p.add_EffDefault(24, 1000, 60_000);
                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();
                        MapService.send_eff_other(map, p, 24);
                        Service.send_char_main_in4(p);
                    } else if (p.skill_new[0] >= 1) {
                        MapService.callNbxx(map, p);

                        for (int i = 23; i <= 26; i++) {
                            p.add_EffDefault(i, 1000, 60_000);
                            MapService.send_eff_other(p.map, p, i);
                        }

                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();

                        Service.send_char_main_in4(p);
                    }
                } else if (index_skill == 13) {
                    byte[] id_sk = new byte[]{15, 34};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 14) {
                    byte[] id_sk = new byte[]{33, 11, 7};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1]), p.get_pramskill_byid(index_skill, id_sk[2])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 17 && p2 != null) {
                    MapService.add_eff_stun(map, p, p2, 10, 4);
                }
                break;
            }
            case 2: {
                if (index_skill == 18) {
                    if (p.skill_new[0] <= 0) {
                        p.add_EffDefault(52, 1000, 60_000);
                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();
                        MapService.send_eff_other(map, p, 52);
                    } else if (p.skill_new[0] >= 1) {
                        MapService.callNbxx(map, p);

                        for (int i = 23; i <= 26; i++) {
                            p.add_EffDefault(i, 1000, 60_000);
                            MapService.send_eff_other(p.map, p, i);
                        }

                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();

                        Service.send_char_main_in4(p);
                    }
                } else if (index_skill == 13) {
                    byte[] id_sk = new byte[]{15, 35};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 14) {
                    byte[] id_sk = new byte[]{36, 8, 7};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1]), p.get_pramskill_byid(index_skill, id_sk[2])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 17 && p2 != null) {
                    MapService.add_eff_stun(map, p, p2, 10, 5);
                }
                break;
            }
            case 3: {
                if (index_skill == 18) {
                    if (p.skill_new[0] <= 0) {
                        p.add_EffDefault(53, 1000, 60_000);
                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();
                        MapService.send_eff_other(map, p, 53);
                    } else if (p.skill_new[0] >= 1) {
                        MapService.callNbxx(map, p);

                        for (int i = 23; i <= 26; i++) {
                            p.add_EffDefault(i, 1000, 60_000);
                            MapService.send_eff_other(p.map, p, i);
                        }

                        Message m = new Message(75);
                        m.writer().writeByte(12);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        m.writer().writeShort(60);
                        m.writer().writeByte(0);
                        m.writer().writeShort(p.index);
                        p.conn.addmsg(m);
                        m.cleanup();

                        Service.send_char_main_in4(p);
                    }
                } else if (index_skill == 13) {
                    byte[] id_sk = new byte[]{15, 34};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 14) {
                    byte[] id_sk = new byte[]{36, 10, 7};
                    int[] param_sk = new int[]{p.get_pramskill_byid(index_skill, id_sk[0]),
                        p.get_pramskill_byid(index_skill, id_sk[1]), p.get_pramskill_byid(index_skill, id_sk[2])};
                    for (int i = 0; i < p.map.players.size(); i++) {
                        if (n_target < 1) {
                            continue;
                        }
                        Player p0 = p.map.players.get(i);
                        if (p0 != null && p0.index != p.index && !p0.isdie && Math.abs(p0.x - p.x) < range
                                && Math.abs(p0.y - p.y) < range && p0.typepk != 0 && p.typepk == p0.typepk) {
                            for (int j = 0; j < id_sk.length; j++) {
                                p0.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                            }
                            MapService.add_eff_skill_msg(map, p, p0, index_skill, time_buff, id_sk, param_sk);
                            n_target--;
                        }
                    }
                    for (int j = 0; j < id_sk.length; j++) {
                        p.add_EffDefault(id_sk[j], param_sk[j], time_buff);
                    }
                    MapService.add_eff_skill_msg(map, p, p, index_skill, time_buff, id_sk, param_sk);
                } else if (index_skill == 17 && p2 != null) {
                    MapService.add_eff_stun(map, p, p2, 10, 6);
                }
                break;
            }
        }
    }

    private static void add_eff_skill_msg(Map map, Player p, Player p0, byte index_skill, int time_buff, byte[] id_sk,
            int[] param_sk) throws IOException {
        int index_skill2 = 0;
        switch (p.clazz) {
            case 0: {
               index_skill2 = index_skill;
             
                break;
            }
            case 1: {
                if (index_skill == 13) {
                    index_skill2 = 30;
                } else {
                    index_skill2 = 31;
                }
                break;
            }
            case 2: {
                index_skill2 = index_skill;
                break;
            }
            case 3: {
                if (index_skill == 13) {
                    index_skill2 = 30;
                } else {
                    index_skill2 = 31;
                }
                break;
            }
        }
        Message m = new Message(40);
        m.writer().writeByte(1);
        m.writer().writeByte(1);
        m.writer().writeShort(p.index);
        m.writer().writeByte(index_skill);
        m.writer().writeInt(time_buff);
        m.writer().writeShort(p0.index);
        m.writer().writeByte(0);
        m.writer().writeByte(index_skill2);
        if (index_skill == 13) {
            int index = -1;
            m.writer().writeByte(id_sk.length + 1);
            for (int i = 0; i < id_sk.length; i++) {
                m.writer().writeByte(id_sk[i]);
                m.writer().writeInt(param_sk[i]);
                if (id_sk[i] == 15) {
                    index = i;
                }
            }
            int param;
            if (index == -1) {
                param = 0;
            } else {
                param = param_sk[index];
            }
            m.writer().writeByte(14);
            m.writer().writeInt(p0.body.get_DefBase() * (param / 100) / 100);
        } else if (index_skill == 14) {
            int index = -1;
            int index1 = -1;
            int index2 = -1;
            int index3 = -1;
            int index4 = -1;
            m.writer().writeByte(id_sk.length + 5);
            for (int i = 0; i < id_sk.length; i++) {
                m.writer().writeByte(id_sk[i]);
                m.writer().writeInt(param_sk[i]);
                if (id_sk[i] == 7) {
                    index = i;
                }
                if (id_sk[i] == 8) {
                    index1 = i;
                }
                if (id_sk[i] == 9) {
                    index2 = i;
                }
                if (id_sk[i] == 10) {
                    index3 = i;
                }
                if (id_sk[i] == 11) {
                    index4 = i;
                }
            }
            int pr0, pr1, pr2, pr3, pr4;
            if (index == -1) {
                pr0 = 0;
            } else {
                pr0 = param_sk[index];
            }
            if (index1 == -1) {
                pr1 = 0;
            } else {
                pr1 = param_sk[index1];
            }
            if (index2 == -1) {
                pr2 = 0;
            } else {
                pr2 = param_sk[index2];
            }
            if (index3 == -1) {
                pr3 = 0;
            } else {
                pr3 = param_sk[index3];
            }
            if (index4 == -1) {
                pr4 = 0;
            } else {
                pr4 = param_sk[index4];
            }
            m.writer().writeByte(0);
            m.writer().writeInt((p0.body.get_DameProp(0) * (pr0 / 100)) / 100);
            m.writer().writeByte(1);
            m.writer().writeInt((p0.body.get_DameProp(1) * (pr1 / 100)) / 100);
            m.writer().writeByte(2);
            m.writer().writeInt((p0.body.get_DameProp(2) * (pr2 / 100)) / 100);
            m.writer().writeByte(3);
            m.writer().writeInt((p0.body.get_DameProp(3) * (pr3 / 100)) / 100);
            m.writer().writeByte(4);
            m.writer().writeInt((p0.body.get_DameProp(4) * (pr4 / 100)) / 100);
        } else {
            m.writer().writeByte(0);
        }
        p0.conn.addmsg(m);
        m.cleanup();
        if (p0.index != p.index) {
            m = new Message(40);
            m.writer().writeByte(1);
            m.writer().writeByte(1);
            m.writer().writeShort(p.index);
            m.writer().writeByte(index_skill);
            m.writer().writeInt(time_buff);
            m.writer().writeShort(p0.index);
            m.writer().writeByte(0);
            m.writer().writeByte(index_skill2);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
        }
        //
        m = new Message(40);
        m.writer().writeByte(0);
        m.writer().writeByte(1);
        m.writer().writeShort(p.index);
        m.writer().writeByte(index_skill);
        m.writer().writeInt(time_buff);
        m.writer().writeShort(p0.index);
        m.writer().writeByte(0);
        m.writer().writeByte(index_skill2);
        if (index_skill == 13) {
            int index = -1;
            m.writer().writeByte(id_sk.length + 1);
            for (int i = 0; i < id_sk.length; i++) {
                m.writer().writeByte(id_sk[i]);
                m.writer().writeInt(param_sk[i]);
                if (id_sk[i] == 15) {
                    index = i;
                }
            }
            int param;
            if (index == -1) {
                param = 0;
            } else {
                param = param_sk[index];
            }
            m.writer().writeByte(14);
            m.writer().writeInt(p0.body.get_DefBase() * (param / 100) / 100);
        } else if (index_skill == 14) {
            int index = -1;
            int index1 = -1;
            int index2 = -1;
            int index3 = -1;
            int index4 = -1;
            m.writer().writeByte(id_sk.length + 5);
            for (int i = 0; i < id_sk.length; i++) {
                m.writer().writeByte(id_sk[i]);
                m.writer().writeInt(param_sk[i]);
                if (id_sk[i] == 7) {
                    index = i;
                }
                if (id_sk[i] == 8) {
                    index1 = i;
                }
                if (id_sk[i] == 9) {
                    index2 = i;
                }
                if (id_sk[i] == 10) {
                    index3 = i;
                }
                if (id_sk[i] == 11) {
                    index4 = i;
                }
            }
            int pr0, pr1, pr2, pr3, pr4;
            if (index == -1) {
                pr0 = 0;
            } else {
                pr0 = param_sk[index];
            }
            if (index1 == -1) {
                pr1 = 0;
            } else {
                pr1 = param_sk[index1];
            }
            if (index2 == -1) {
                pr2 = 0;
            } else {
                pr2 = param_sk[index2];
            }
            if (index3 == -1) {
                pr3 = 0;
            } else {
                pr3 = param_sk[index3];
            }
            if (index4 == -1) {
                pr4 = 0;
            } else {
                pr4 = param_sk[index4];
            }
            m.writer().writeByte(0);
            m.writer().writeInt((p0.body.get_DameProp(0) * (pr0 / 100)) / 100);
            m.writer().writeByte(1);
            m.writer().writeInt((p0.body.get_DameProp(1) * (pr1 / 100)) / 100);
            m.writer().writeByte(2);
            m.writer().writeInt((p0.body.get_DameProp(2) * (pr2 / 100)) / 100);
            m.writer().writeByte(3);
            m.writer().writeInt((p0.body.get_DameProp(3) * (pr3 / 100)) / 100);
            m.writer().writeByte(4);
            m.writer().writeInt((p0.body.get_DameProp(4) * (pr4 / 100)) / 100);
        } else {
            m.writer().writeByte(0);
        }
        p0.conn.addmsg(m);
        m.cleanup();

    }

    private static void send_eff_other(Map map, Player p, int id) throws IOException {
        EffTemplate temp = p.get_EffDefault(id);
        if (temp != null) {
            switch (id) {
                case -121: {
                    Message m = new Message(75);
                    m.writer().writeByte(6);
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    long time_exist = temp.time - System.currentTimeMillis();
                    if (time_exist < 1000) {
                        return;
                    }
                    m.writer().writeShort((short) (time_exist / 1000));
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    MapService.send_msg_player_inside(map, p, m, false);
                    m.cleanup();
                    break;
                }
                case -122: {
                    Message m = new Message(75);
                    m.writer().writeByte(5);
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    long time_exist = temp.time - System.currentTimeMillis();
                    if (time_exist < 1000) {
                        return;
                    }
                    m.writer().writeShort((short) (time_exist / 1000));
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    MapService.send_msg_player_inside(map, p, m, false);
                    m.cleanup();
                    break;
                }
                case -123: {
                    Message m = new Message(75);
                    m.writer().writeByte(4);
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    long time_exist = temp.time - System.currentTimeMillis();
                    if (time_exist < 1000) {
                        return;
                    }
                    m.writer().writeShort((short) (time_exist / 1000));
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    MapService.send_msg_player_inside(map, p, m, false);
                    m.cleanup();
                    break;
                }
                case -124: {
                    Message m = new Message(75);
                    m.writer().writeByte(7);
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    long time_exist = temp.time - System.currentTimeMillis();
                    if (time_exist < 1000) {
                        return;
                    }
                    m.writer().writeShort((short) (time_exist / 1000));
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    MapService.send_msg_player_inside(map, p, m, false);
                    m.cleanup();
                    break;
                }
                case 23:
                case 24:
                case 52:
                case 53: {
                    Message m = new Message(75);
                    m.writer().writeByte(12);
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    long time_exist = temp.time - System.currentTimeMillis();
                    if (time_exist < 1000) {
                        return;
                    }
                    m.writer().writeShort((short) (time_exist / 1000));
                    m.writer().writeByte(0);
                    m.writer().writeShort(p.index);
                    MapService.send_msg_player_inside(map, p, m, false);
                    m.cleanup();
                    break;
                }
            }
        }
    }

    public static void send_chat(Map map, Session conn, Message m2) throws IOException, InterruptedException {
        String chat = m2.reader().readUTF();
//        if(conn.ac_admin >0 && chat.indexOf("t")==0)
//        {
//            int t =Integer.parseInt(chat.substring(1));
//            Service.idxDame = t;
////            send_in4_other_char(map, conn.p, conn.p, t);
////            ChienTruongManager.SendEffBienHinh(map, conn.p);
//            Message m = new Message(50);
//            m.writer().writeByte(0);
//            m.writer().writeShort(conn.p.index);
//            m.writer().writeByte(t);
//            m.writer().writeByte(1);
//            conn.addmsg(m);
//            m.cleanup();
//            //Service.send_char_main_in4(conn.p, t);
////            Message m = new Message(75);
////            m.writer().writeByte(t);
////            m.writer().writeByte(0);
////            m.writer().writeShort(conn.p.id);
////            m.writer().writeShort(3);
////            m.writer().writeByte(0);
////            m.writer().writeShort(conn.p.id);
////            MapService.send_msg_player_inside(map, conn.p, m, true);
////            m.cleanup();
////            Message m = new Message(-94);
////            m.writer().writeByte(t);
////            m.writer().writeByte(100);
////            m.writer().writeShort(1000);
////            m.writer().writeByte(0);
////            m.writer().writeLong(0);
////            conn.addmsg(m);
////            m.cleanup();
//            return;
//        }
//////
////        if(conn.ac_admin >0 && chat.indexOf("go")==0)
////        {
////            int t =Integer.parseInt(chat.substring(2));
////            Vgo v = new Vgo();
////            v.id_map_go = (byte)t;
////            v.x_new = 300;
////            v.y_new = 200;
////            conn.p.change_map(conn.p, v);
////            return;
////        }
//        if(conn.ac_admin >0 && chat.equals("end")){
////            synchronized (map) {
////                while (true) {  
////                    try{
////                        Thread.sleep(100);
////                    }catch(Exception e){}
////                    
////                }
////            }
//            Message m = new Message(-49);
//            m.writer().writeByte(0);
//            m.writer().writeShort(Manager.gI().msg_eff_105.length);
//            m.writer().write(Manager.gI().msg_eff_105);
//
//            m.writer().writeByte(0);
//            m.writer().writeByte(1);
//            m.writer().writeByte(105);
//
//            m.writer().writeShort(conn.p.index);
//            m.writer().writeByte(0);//tem mob
//            m.writer().writeByte(0);
//            m.writer().writeShort(8);
//            m.writer().writeByte(0);
//            conn.addmsg(m);
//            m.cleanup();
//            return;
//        }
//        if (conn.ac_admin > 3 && chat.equals("gg")){
//            try{
//                List<String[]> abc = new ArrayList<>();
//                abc.add(new String[]{"dhaj",null,"8888"});
//                abc.add(null);
//                for(String[] mm : abc){
//                    for(String mr : mm){
//
//                        System.out.println("map.MapService.send_chat()"+mr);
//                    }
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }
        if (conn.ac_admin > 3 && chat.equals("onmap")) {
            Manager.isMap = !Manager.isMap;
            String status = Manager.isMap ? "Bật" : "Tắt";
            Service.send_notice_box(conn, "Map Loạn Đấu: " + status);

            if (Manager.isMap) {
                // bật
                LoanDau.startEvent();
            } else {
                // Tắt
                LoanDau.endEvent();
            }
        }

        // if (chat.equals("nb")) {
            // callNbxx(map, conn.p);

        // }
        // if (chat.equals("exp")) {
            // conn.p.phan_tram_exp(35);

        // }

        // if (conn.ac_admin > 3 && chat.equals("vip")) {
            // Service.send_notice_box(conn, "Vip: " + (conn.vip + 1));

            // conn.up_vip(1);

        // }

        if (chat.equals("hopthe")) {
            if (conn.p.squire != null) {
                // Kiểm tra nếu người chơi đang ở trong các map không cho phép hợp thể
                if (conn.p.map.map_id == 46 || conn.p.map.map_id == 48 || conn.p.map.map_id == 124) {
                    Service.send_notice_box(conn, "Không thể sử dụng trong map này!");
                    return;
                }

                // Kiểm tra nếu người chơi đang có hiệu ứng (-128) và phải chờ thời gian
                EffTemplate tempp1 = conn.p.get_EffDefault(-128);
                if (tempp1 != null && tempp1.time > System.currentTimeMillis()) {
                    Service.send_notice_box(conn,
                            "Đợi Sau " + Util.getTime((int) (tempp1.time - System.currentTimeMillis()) / 1000) + " S");
                    return;
                }

                // Kiểm tra nếu người chơi không phải chủ nhân (isOwner)
                if (!conn.p.isOwner) {
                    Service.send_notice_box(conn, "Mày chỉ là đệ không thể thao tác");
                    return;
                }

                // Tạo đối tượng Fusion
                Fusion fusion = new Fusion();

                // Kiểm tra nếu người chơi chưa ở trạng thái hợp thể
                if (!fusion.isFusion(conn.p)) {
                    conn.p.isLiveSquire = false;
                    Squire.squireLeaveMap(conn.p);

                    // Lưu trạng thái hợp thể: đã hợp thể (true), không có tin nhắn (false), không phải "case" (false)
                    fusion.saveFusionStatus(conn.p, true, false, false);

                    // Thêm hiệu ứng hợp thể (-127) với thời gian hợp thể là 10 phút
                    conn.p.add_EffDefault(-127, 1000, (1000 * 60 * 10));

                    // Cập nhật ngoại hình của người chơi sau hợp thể
                    conn.p.fashion = Part_fashion.get_part(conn.p);
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                    MapService.update_in4_2_other_inside(conn.p.map, conn.p);

                    // Gửi thông báo hiệu ứng hợp thể cho tất cả người chơi trong map
                    m2 = new Message(-49);
                    m2.writer().writeByte(2); // loại hiệu ứng
                    m2.writer().writeShort(0);
                    m2.writer().writeByte(0);
                    m2.writer().writeByte(0);
                    m2.writer().writeByte(44); // Mã hiệu ứng hợp thể
                    m2.writer().writeShort(conn.p.index);
                    m2.writer().writeByte(0);
                    m2.writer().writeByte(0);
                    m2.writer().writeInt(500);

                    // Gửi tin nhắn cho tất cả người chơi trong map
                    MapService.send_msg_player_inside(conn.p.map, conn.p, m2, true);
                    m2.cleanup();

                } else {
                    // Kiểm tra thời gian hợp thể còn lại và thông báo cho người chơi nếu vẫn đang trong thời gian hợp thể
                    EffTemplate tempp = conn.p.get_EffDefault(-127);
                    if (tempp != null && tempp.time > System.currentTimeMillis()) {
                        Service.send_notice_box(conn,
                                "Đợi " + Util.getTime((int) (tempp.time - System.currentTimeMillis()) / 1000));
                    }
                }
            } else {
                // Nếu người chơi chưa có đệ tử
                Service.send_notice_box(conn, "chưa có đệ tử");
            }
        }

        if (conn.ac_admin > 10 && chat.equals("dktt")) {
            ChienTruong1.gI().open_register();
        }
        if (chat.equals("up")) {
            if(conn.p.level < 140){
            conn.p.level += 140;
            Service.send_char_main_in4(conn.p);
        }}
        
         if (conn.ac_admin > 10 && chat.equals("newday")) {// qua ngày mới
          conn.p.change_new_date();
          Service.send_notice_nobox_white(conn, "Reset day");
        }

        if (conn.ac_admin > 3 && chat.equals("pk")) {
            Service.send_notice_box(conn, "" + conn.p.typepk + "");

        }

        if (conn.ac_admin > 3 && chat.equals("tt")) {
            Manager.gI().ip_create_char.clear();
            CongNap.NV_CONG_NAP = (byte) Util.random(16);

        }

        if (chat.equals("id")) {
            Service.send_notice_box(conn, "" + conn.id + "");

        }

        if (conn.ac_admin > 10 && chat.equals("kh")) {
            Service.send_box_input_text(conn, 33, "Kích Hoạt Tài Khoản",
                    new String[]{"id"});
        }

        if (conn.ac_admin > 10 && chat.equals("nap")) {
            Service.send_box_input_text(conn, 34, "Nạp Tiền",
                    new String[]{"id", "Số Tiền", "Số Coin"});
        }

        if (chat.equals("venha")) {

            conn.p.isLiveSquire = false;
            Squire.squireLeaveMap(conn.p);

        }

        if (chat.equals("thoatket")) {
            if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593
                    || conn.p.item.wear[11].id == 3596)) {
                return;
            }
            if (Pet_mi_nuong.checkMy(conn)) {
                return;
            }
            if (!conn.p.my_store_name.isEmpty()) {
                Service.send_notice_box(conn, "Đang Bán Đi đâu em");
                return;
            }

            Vgo vgo = new Vgo();
            vgo.id_map_go = 1;
            vgo.x_new = 432;
            vgo.y_new = 354;
            conn.p.change_map(conn.p, vgo);
            // } else if (chat.substring(0, 1).equals("t")) {
            // int n = Integer.parseInt(chat.substring(1, chat.length()));
            // conn.p.type_use_mount = (byte) n;
            // this.send_mount(conn.p);
            // Message m = new Message(-49);
            // m.writer().writeByte(2);
            // m.writer().writeShort(0);
            // m.writer().writeByte(0);
            // m.writer().writeByte(0);
            // m.writer().writeByte(n);
            // m.writer().writeShort(conn.p.id);
            // m.writer().writeByte(0);
            // m.writer().writeByte(0);
            // m.writer().writeInt(3000);
            // send_msg_player_inside(conn.p, m, true);
            // m.cleanup();
        }

        //member
        if (chat.equals("exptt")) {
            Service.send_notice_box(conn, "Exp Tu Iên : " + conn.p.get_exptt() + "");

        } else if (chat.equals("dc1")) {//14
            MenuController.send_menu_select(conn, 10, new String[]{"Cửa Biển ", "Đồi Cát", "Hố tử thần", "Rừng chết", "Thung lũng đá", "Hầm mộ Tầng 2", "Con đường Hiểm Trở", "Núi cầu vòng", "Đèo hoang sơ", "Cây cầu ma ám", "Đồi xác chết", "Cổng thiên đàng", "Cổng địa ngục", "Địa ngục tầng 1"});
        } else if (chat.equals("dc2")) {//11
            MenuController.send_menu_select(conn, 11, new String[]{"Rừng medusa ", "Rừng Chimera ", "Rừng quái vật", "Thác reo", "Rừng Chuột", "Rừng hoa đỏ", "Vịnh caribe", "Mê cung tầng 1", "Mê cung tầng 2", "Mê cung tầng 4", "Mê cung tầng cuối"});

        }

        if (conn.ac_admin >= 10 && chat.equals("admin")) {
            Message m = new Message(7);
            m.writer().writeShort(30109);
            m.writer().writeShort(40);
            m.writer().writeShort(conn.p.x);
            m.writer().writeShort(conn.p.y);
            m.writer().writeInt(1000);
            m.writer().writeInt(1000);
            m.writer().writeByte(0);
            m.writer().writeInt(1);
            m.writer().writeShort(-1);
            m.writer().writeByte(1);
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            m.writer().writeLong(-11111);
            m.writer().writeByte(0);
            conn.addmsg(m);
            m.cleanup();
            MenuController.send_menu_select(conn, 126, new String[]{"Bảo trì", "Cộng vàng x1.000.000.000",
                "Cộng ngọc x1.000.000", "Update data", "Lấy item", "Up level", "Set Xp", "Khóa mõm", "Gỡ khóa mõm", "Khóa vòng quay", "Khóa GD", "Khóa KMB", "Ấp trứng nhanh",
                "Buff Admin", "Buff Nguyên liệu", "Mở chiếm mỏ", "Đóng chiếm mỏ", (LoiDaiManager.isRegister ? "Đóng" : "Mở") + " đăng kí Lôi Đài", "Reset mob events",
                (ChiemThanhManager.isRegister ? "Đóng" : "Mở") + " đăng kí chiếm thành", "Mở đăng kí chiến trường", "Dịch map", "loadconfig",
                (Manager.logErrorLogin ? "tắt" : "bật") + " log bug", "disconnect client", "check bug", "fix bug"});
        } //        else if (conn.ac_admin >=10 && chat.equals("xoa")){
        //            //tools.loadacc();
        //        }
        else if (conn.ac_admin >= 10 && chat.equals("lock")) {

            MenuController.send_menu_select(conn, 127, new String[]{(Manager.isNgocCoin ? "Đóng" : "Mở") + " Đổi Ngọc Ra Coin", (Manager.isShopVang ? "Đóng" : "Mở") + " Shop vang", (Manager.isLockKC ? "Đóng" : "Mở") + " Vòng Quay Ngọc", (Manager.isLockTaiXiu ? "Đóng" : "Mở") + " Tài Xỉu", (Manager.isPk ? "Đóng" : "Mở") + " Chống Đồ Sát", "Kích Hoạt Tài Khoản", " Nạp Tiền", "---------------------------", "Reset Nạp Tuần", "---------------------------", "Reset Account Status 2"});
        } // MenuController.send_menu_select(conn, 127, new String[]{(Manager.isNgocCoin? "Đóng" : "Mở") + " Đổi Ngọc Ra Coin",(Manager.isShopVang? "Đóng" : "Mở") + " Shop vang"},(Manager.isLockKC? "Đóng" : "Mở") + " Vòng Quay Ngọc",(Manager.isLockTaiXiu? "Đóng" : "Mở") + " Tài Xỉu");
        //      }
        else if (conn.ac_admin > 3 && chat.equals("xem")) {
            int num = 0;
            int count = 0;
            for (Map[] mm : Map.entrys) {
                for (Map map0 : mm) {
                    if (map0.mobEvens != null) {
                        for (int i = 0; i < map0.mobEvens.size(); i++) {
                            count++;
                        }
                    }
                }
            }
            for (Map[] maps : Map.entrys) {
                for (Map map_ : maps) {
                    num += map_.players.size();
                }
            }
            Service.send_notice_box(conn,
                    "Vị Trí " + conn.p.x + " - " + conn.p.y + "\n Map id : " + map.map_id + "\n Zone : " + map.zone_id
                    + "\n Số Người kết nối : " + Session.client_entrys.size() + "\n Số Người online : " + num
                    + "\nmob event: " + ev_he.Event_2.entrys.size() + " / " + count);
        } else if (conn.ac_admin > 3 && chat.equals("nap99")) {
            Service.send_box_input_text(conn, 99, "Nhập thông tin",
                    new String[]{"Tên nhân vật", "Số Tiền", "Coin"});
        } else {
            SendChat(map, conn.p, chat, false);
//            Message m = new Message(27);
//            m.writer().writeShort(conn.p.id);
//            m.writer().writeByte(0);
//            m.writer().writeUTF(chat);
//            MapService.send_msg_player_inside(map, conn.p, m, false);
//            m.cleanup();
        }
    }

    public static void SendChat(Map map, Player p, String chat, boolean include) throws IOException {
        Message m = new Message(27);
        m.writer().writeShort(p.index);
        m.writer().writeByte(0);
        m.writer().writeUTF(chat);
        MapService.send_msg_player_inside(map, p, m, include);
        m.cleanup();
    }

    public static void send_in4_other_char(Map map, Player p, Player p0) throws IOException {
        int dem = 0;
        for (int i = 0; i < 11; i++) {
            if (i != 0 && i != 1 && i != 6 && i != 7 && i != 10) {
                continue;
            }
            if (p0.item.wear[i] != null) {
                dem++;
            }
        }
        Message m = new Message(5);
        m.writer().writeShort(p0.index);
        m.writer().writeUTF(new String(p0.name.getBytes(), StandardCharsets.UTF_8));
        m.writer().writeShort(p0.x);
        m.writer().writeShort(p0.y);
        m.writer().writeByte(p0.clazz);
        m.writer().writeByte(-1);
        m.writer().writeByte(p0.head);
        m.writer().writeByte(p0.eye);
        m.writer().writeByte(p0.hair);
        m.writer().writeShort(p0.level);
        m.writer().writeInt(p0.hp);
        m.writer().writeInt(p0.body.get_HpMax());
        m.writer().writeByte(p0.typepk);
        m.writer().writeShort(p0.pointpk);
        m.writer().writeByte(dem);
        //
        for (int i = 0; i < p0.item.wear.length; i++) {
            if (i != 0 && i != 1 && i != 6 && i != 7 && i != 10) {
                continue;
            }
            Item3 temp = p0.item.wear[i];
            if (temp != null) {
                m.writer().writeByte(temp.type);

                if (i == 10 && p0.item.wear[14] != null && (p0.item.wear[14].id >= 4638 && p0.item.wear[14].id <= 4648)) {
                    m.writer().writeByte(p0.item.wear[14].part);
                } else {
                    m.writer().writeByte(temp.part);
                }
                m.writer().writeByte(3);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1); // eff
            }
        }
        //
        if (p0.myclan != null) {
            m.writer().writeShort(p0.myclan.icon);
            m.writer().writeInt(Clan.get_id_clan(p0.myclan));
            m.writer().writeUTF(p0.myclan.name_clan_shorted);
            m.writer().writeByte(p0.myclan.get_mem_type(p0.name));
        } else {
            m.writer().writeShort(-1); // clan
        }
        if (p0.pet_follow != -1) {
            for (Pet temp : p0.mypet) {
                if (temp.is_follow) {
                    m.writer().writeByte(temp.type); // type
                    m.writer().writeByte(temp.icon); // icon
                    m.writer().writeByte(temp.nframe); // nframe
                    break;
                }
            }
        } else {
            m.writer().writeByte(-1); // pet
        }
       m.writer().writeByte(p0.fashion.length);
        for (int i = 0; i < p0.fashion.length; i++) {
            if (p.conn.version >= 280) {
                m.writer().writeShort(p0.fashion[i]);
            } else {
                m.writer().writeByte(p0.fashion[i]);
            }
        }
        //
        m.writer().writeShort(-1);
        m.writer().writeByte(p0.type_use_mount);
        m.writer().writeBoolean(false);
        m.writer().writeByte(1);
        if (map.isMapChiemThanh() && p.myclan != null && p0.myclan != null && !p.myclan.equals(p0.myclan)) {
            m.writer().writeByte(1);
        } else {
            m.writer().writeByte(0);
        }
        m.writer().writeShort(Service.get_id_mat_na(p0)); // mat na
        m.writer().writeByte(1); // paint mat na trc sau
        m.writer().writeShort(Service.get_id_phiphong(p0)); // phi phong
        m.writer().writeShort(Service.get_id_weapon(p0)); // weapon
        m.writer().writeShort(p0.id_horse);
        m.writer().writeShort(Service.get_id_hair(p0)); // hair
        m.writer().writeShort(Service.get_id_wing(p0)); // wing
        m.writer().writeShort(Service.get_id_danhhieu(p0)); // phi phong
        m.writer().writeShort(p0.id_name); // body
        m.writer().writeShort(-1); // leg
        m.writer().writeShort(-1); // bienhinh
        p.conn.addmsg(m);
        m.cleanup();
        if (p.index != p0.index && !p0.my_store_name.isEmpty()) {
            m = new Message(-102);
            m.writer().writeByte(1);
            m.writer().writeShort(p0.index);
            m.writer().writeUTF(p0.my_store_name);
            p.conn.addmsg(m);
            m.cleanup();
        }
    }

    public static void send_in4_other_char(Map map, Player p, Player p0, int bienhinh) throws IOException {
        int dem = 0;
        for (int i = 0; i < 11; i++) {
            if (i != 0 && i != 1 && i != 6 && i != 7 && i != 10) {
                continue;
            }
            if (p0.item.wear[i] != null) {
                dem++;
            }
        }
        Message m = new Message(5);
        m.writer().writeShort(p0.index);
        m.writer().writeUTF(new String(p0.name.getBytes(), StandardCharsets.UTF_8) + "Víp");

        m.writer().writeShort(p0.x);
        m.writer().writeShort(p0.y);
        m.writer().writeByte(p0.clazz);
        m.writer().writeByte(-1);
        m.writer().writeByte(p0.head);
        m.writer().writeByte(p0.eye);
        m.writer().writeByte(p0.hair);
        m.writer().writeShort(p0.level);
        m.writer().writeInt(p0.hp);
        m.writer().writeInt(p0.body.get_HpMax());
        m.writer().writeByte(p0.typepk);
        m.writer().writeShort(p0.pointpk);
        m.writer().writeByte(dem);
        //
        for (int i = 0; i < p0.item.wear.length; i++) {
            if (i != 0 && i != 1 && i != 6 && i != 7 && i != 10) {
                continue;
            }
            Item3 temp = p0.item.wear[i];
            if (temp != null) {
                m.writer().writeByte(temp.type);

                if (i == 10 && p0.item.wear[14] != null && (p0.item.wear[14].id >= 4638 && p0.item.wear[14].id <= 4648)) {
                    m.writer().writeByte(p0.item.wear[14].part);
                } else {
                    m.writer().writeByte(temp.part);
                }
                m.writer().writeByte(3);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1); // eff
            }
        }
        //
        if (p0.myclan != null) {
            m.writer().writeShort(p0.myclan.icon);
            m.writer().writeInt(Clan.get_id_clan(p0.myclan));
            m.writer().writeUTF(p0.myclan.name_clan_shorted);
            m.writer().writeByte(p0.myclan.get_mem_type(p0.name));
        } else {
            m.writer().writeShort(-1); // clan
        }
        if (p0.pet_follow != -1) {
            for (Pet temp : p0.mypet) {
                if (temp.is_follow) {
                    m.writer().writeByte(temp.type); // type
                    m.writer().writeByte(temp.icon); // icon
                    m.writer().writeByte(temp.nframe); // nframe
                    break;
                }
            }
        } else {
            m.writer().writeByte(-1); // pet
        }
         m.writer().writeByte(p0.fashion.length);
        for (int i = 0; i < p0.fashion.length; i++) {
            if (p.conn.version >= 280) {
                m.writer().writeShort(p0.fashion[i]);
            } else {
                m.writer().writeByte(p0.fashion[i]);
            }
        }
        //
        m.writer().writeShort(110);
        m.writer().writeByte(p0.type_use_mount);
        m.writer().writeBoolean(false);
        m.writer().writeByte(1);
        m.writer().writeByte(map.map_id >= 83 && map.map_id <= 87 ? 1 : 0);
        m.writer().writeShort(Service.get_id_mat_na(p0)); // mat na
        m.writer().writeByte(1); // paint mat na trc sau
        m.writer().writeShort(Service.get_id_phiphong(p0)); // phi phong
        m.writer().writeShort(Service.get_id_weapon(p0)); // weapon
        m.writer().writeShort(p0.id_horse);
        m.writer().writeShort(Service.get_id_hair(p0)); // hair
        m.writer().writeShort(Service.get_id_wing(p0)); // wing
        m.writer().writeShort(Service.get_id_danhhieu(p0)); // phi phong
        m.writer().writeShort(p0.id_name); // body
        m.writer().writeShort(-1); // leg
        m.writer().writeShort(bienhinh); // bienhinh
        p.conn.addmsg(m);
        m.cleanup();
        if (p.index != p0.index && !p0.my_store_name.isEmpty()) {
            m = new Message(-102);
            m.writer().writeByte(1);
            m.writer().writeShort(p0.index);
            m.writer().writeUTF(p0.my_store_name);
            p.conn.addmsg(m);
            m.cleanup();
        }
    }

    public static void request_livefromdie(Map map, Session conn, Message m) throws IOException {
        byte type = m.reader().readByte();
        if (map.ld2 != null) {
            return;
        }

        if (map.isMapChiemThanh()) {
            ChiemThanhManager.request_livefromdie(map, conn, type);
        } else {
            if (type == 1) { // hsl
                Service.send_box_input_yesno(conn, 9, "Cần 5 ngọc cho mỗi lần hồi sinh tại chỗ ?");
            } else if (type == -1) {
                if (conn.p.get_ngoc() >= 5) {
                    conn.p.isdie = false;
                    conn.p.hp = conn.p.body.get_HpMax();
                    conn.p.mp = conn.p.body.get_MpMax();
                    conn.p.update_ngoc(-5);
                    conn.p.item.char_inventory(5);
                    Service.send_char_main_in4(conn.p);
                    // chest in4
                    Service.send_combo(conn);
                    Service.usepotion(conn.p, 0, conn.p.body.get_HpMax());
                    Service.usepotion(conn.p, 1, conn.p.body.get_MpMax());
                } else {
                    Service.send_notice_box(conn, "Không đủ ngọc để thực hiện");
                }
            } else if (type == 0) { // ve lang
                conn.p.isdie = false;
                conn.p.hp = conn.p.body.get_HpMax();
                conn.p.mp = conn.p.body.get_MpMax();
                Vgo vgo = new Vgo();
                if (Map.is_map_chien_truong(map.map_id)) {
                    System.out.println(conn.p.typepk);
                    switch (conn.p.typepk) {
                        case 1: {
                            vgo.id_map_go = 59;
                            vgo.x_new = 240;
                            vgo.y_new = 224;
                            break;
                        }
                        case 2: {
                            vgo.id_map_go = 55;
                            vgo.x_new = 224;
                            vgo.y_new = 256;
                            break;
                        }
                        case 4: {
                            vgo.id_map_go = 57;
                            vgo.x_new = 264;
                            vgo.y_new = 272;
                            break;
                        }
                        case 5: {
                            vgo.id_map_go = 53;
                            vgo.x_new = 276;
                            vgo.y_new = 246;
                            break;
                        }
                    }
                } else {
                    vgo.id_map_go = 1;
                    vgo.x_new = (short) 528;
                    vgo.y_new = (short) 480;
                }
                conn.p.change_map(conn.p, vgo);
                Service.usepotion(conn.p, 0, conn.p.body.get_HpMax());
                Service.usepotion(conn.p, 1, conn.p.body.get_MpMax());
            }
        }
    }

    public static Player get_player_by_id(Map map, int n2) throws IOException {
        // Duyệt qua danh sách người chơi trong bản đồ
        for (Player p0 : map.players) {
            // Kiểm tra nếu n2 khớp với chỉ số của Player
            if (p0.index == n2) {
                Service.send_notice_nobox_white(p0.conn, "cccc1");
                return p0; // Trả về Player nếu chỉ số khớp
            }

            // Kiểm tra nếu Player có Squire
            /* if (p0.isLiveSquire && p0.squire != null) {
                // Nếu n2 khớp với chỉ số của Squire
                if (p0.squire.index == n2) {
                    Service.send_notice_nobox_white(p0.conn, "cccc2");
                    return p0.squire; // Trả về Squire nếu chỉ số khớp
                }
            }*/
        }

        // Không tìm thấy đối tượng nào
        return null;
    }

    public static void Player_Die(Map map, MainObject p, MainObject Obj, boolean include) throws IOException {

        Message m = new Message(41);
        m.writer().writeShort(p.index);
        m.writer().writeShort(Obj.index);
        m.writer().writeShort(Obj.typepk); // point pk
        m.writer().writeByte(Obj.get_TypeObj()); // type main object
        if (!include) {
            ((Player) p).conn.addmsg(m);
        } else {
            MapService.send_msg_player_inside(map, Obj, m, true);
        }
        m.cleanup();
    }

    public static void MainObj_Die(Map map, Session conn, MainObject mob, boolean include) throws IOException {
        Message m2 = null;
        if (mob.get_TypeObj() == 0 || mob.isMobDiBuon()) {
            m2 = new Message(8);
            m2.writer().writeShort(mob.index);
        } else {
            m2 = new Message(17);
            m2.writer().writeShort(conn != null ? conn.p.index : mob.index);
            m2.writer().writeShort(mob.index);
        }
        if (!include && conn != null) {
            conn.addmsg(m2);
        } else {
            MapService.send_msg_player_inside(map, mob, m2, true);
        }
        m2.cleanup();
    }

    public static void MainObj_Fire_Player(Map map, Player p, MainObject mainAttack, int indexskill, int dame, List<Eff_TextFire> ListFire) throws IOException {
        
        Message m = new Message(6);
        m.writer().writeShort(mainAttack.index);
        m.writer().writeByte(indexskill);
        m.writer().writeByte(1);
        m.writer().writeShort(p.index);
        m.writer().writeInt(dame); // dame
        m.writer().writeInt(p.hp); // hp after
        m.writer().writeByte(ListFire.size());
        for (int i = 0; i < ListFire.size(); i++) {
            Eff_TextFire ef = ListFire.get(i);
            if (ef == null) {
                continue;
            }
            m.writer().writeByte(ef.type); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
            m.writer().writeInt(ef.dame); // par
        }
        m.writer().writeInt(mainAttack.hp);
        m.writer().writeInt(mainAttack.mp);
        m.writer().writeByte(11);
        m.writer().writeInt(0);
        MapService.send_msg_player_inside(map, mainAttack, m, true);
        m.cleanup();

    }
// người chơi tấn công mob

    public static void Fire_Mob(Map map, Session conn, int indexskill, int idPTaget, int dame, int hpPtaget, List<Eff_TextFire> ListFire, int mobid, int idPlus, int damePlus) throws IOException {

        Message m = new Message(9);
        m.writer().writeShort(conn.p.index);
        m.writer().writeByte(indexskill);
        m.writer().writeByte(1);
        m.writer().writeShort(idPTaget);
        m.writer().writeInt((int) dame); // dame
        m.writer().writeInt(hpPtaget); // hp mob after
        if (ListFire == null || ListFire.isEmpty()) {
            m.writer().writeByte(1);
            m.writer().writeByte(0); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
            m.writer().writeInt(dame);
        } else {
            m.writer().writeByte(ListFire.size());
            for (int i = 0; i < ListFire.size(); i++) {
                Eff_TextFire ef = ListFire.get(i);
                if (ef == null) {
                    m.writer().writeByte(0); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
                    m.writer().writeInt(dame);
                } else {
                    m.writer().writeByte(ef.type); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
                    m.writer().writeInt(ef.dame); // par
                }
            }

            for (int i = 0; i < ChienTruong.gI().list_ai.size(); i++) {
                LinhCanh temp = ChienTruong.gI().list_ai.get(i);
                if (!temp.isdie && temp.map.equals(map) && temp.time_change_target < System.currentTimeMillis()) {
                    temp.time_change_target = System.currentTimeMillis() + 5000L;
                    temp.target = conn.p.index;
                }
            }
            if (map.isMapChienTruong()) {
                switch (mobid) {
                    case 89: {
                        break;
                    }
                    case 90: {
                        break;
                    }
                    case 91: {
                        break;
                    }
                    case 92: {
                        break;
                    }
                }
            }

        }
        m.writer().writeInt(conn.p.hp);
        m.writer().writeInt(conn.p.mp);
        m.writer().writeByte(idPlus);
        m.writer().writeInt(damePlus);
        MapService.send_msg_player_inside(map, conn.p, m, true);
        m.cleanup();
    }
     public static void Fire_Mob(Map map, MainObject ObjAtk, int indexskill, int idPTaget, int dame, int hpPtaget, List<Eff_TextFire> ListFire, int mobid, int idPlus, int damePlus) throws IOException {

        Message m = new Message(9);
        m.writer().writeShort(ObjAtk.index);
        m.writer().writeByte(indexskill);
        m.writer().writeByte(1);
        m.writer().writeShort(idPTaget);
        m.writer().writeInt((int) dame); // dame
        m.writer().writeInt(hpPtaget); // hp mob after
        if (ListFire == null || ListFire.isEmpty()) {
            m.writer().writeByte(1);
            m.writer().writeByte(0); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
            m.writer().writeInt(dame);
        } else {
            m.writer().writeByte(ListFire.size());
            for (int i = 0; i < ListFire.size(); i++) {
                Eff_TextFire ef = ListFire.get(i);
                if (ef == null) {
                    m.writer().writeByte(0); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
                    m.writer().writeInt(dame);
                } else {
                    m.writer().writeByte(ef.type); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
                    m.writer().writeInt(ef.dame); // par
                }
            }

            for (int i = 0; i < ChienTruong.gI().list_ai.size(); i++) {
                LinhCanh temp = ChienTruong.gI().list_ai.get(i);
                if (!temp.isdie && temp.map.equals(map) && temp.time_change_target < System.currentTimeMillis()) {
                    temp.time_change_target = System.currentTimeMillis() + 5000L;
                    temp.target = ObjAtk.index;
                }
            }
            if (map.isMapChienTruong()) {
                switch (mobid) {
                    case 89: {
                        break;
                    }
                    case 90: {
                        break;
                    }
                    case 91: {
                        break;
                    }
                    case 92: {
                        break;
                    }
                }
            }

        }
        m.writer().writeInt(ObjAtk.hp);
        m.writer().writeInt(ObjAtk.mp);
        m.writer().writeByte(idPlus);
        m.writer().writeInt(damePlus);
        MapService.send_msg_player_inside(map, ObjAtk, m, true);
        m.cleanup();
    }
    
   
// người chơi tấn công người chơi 
    public static void Fire_Player(Map map, Session conn, int indexskill, int idPTaget, int dame, int hpPtaget, List<Eff_TextFire> ListFire) throws IOException {
        if (Map.is_map_chien_truong(map.map_id)) {
            conn.p.update_point_arena(1);
        }
        Message m = new Message(6);
        m.writer().writeShort(conn.p.index);
        m.writer().writeByte(indexskill);
        m.writer().writeByte(1);
        m.writer().writeShort(idPTaget);
        m.writer().writeInt(dame); // dame
        m.writer().writeInt(hpPtaget); // hp after
        m.writer().writeByte(ListFire.size());
        for (int i = 0; i < ListFire.size(); i++) {
            Eff_TextFire ef = ListFire.get(i);
            if (ef == null) {
                continue;
            }
            m.writer().writeByte(ef.type); // 1: xuyen giap, 2:hut hp, 3: hut mp, 4: chi mang, 5: phan don
            m.writer().writeInt(ef.dame); // par
        }
        m.writer().writeInt(conn.p.hp);
        m.writer().writeInt(conn.p.mp);
        m.writer().writeByte(11);
        m.writer().writeInt(0);
        MapService.send_msg_player_inside(map, conn.p, m, true);
        //MapService.update_in4_2_other_inside(map, conn.p.squire);
        m.cleanup();
        // }
    }

    public static void use_skill(Map map, Session conn, Message m, int type_atk) throws IOException {
        try {
            long time_ = System.currentTimeMillis();
            byte index_skill = m.reader().readByte();
            int n = m.reader().readByte();
            int ObjAtk = 0;
            short n3 = 0;
            int sk_point1 = conn.p.skill_point[index_skill];
            if (sk_point1 < 1) {
                return;
            }

            if (conn.p.item.wear[0] == null) {
                Service.send_notice_nobox_white(conn, "Chưa có vũ khí");
                return;
            }

            LvSkill _skill = conn.p.skills[index_skill].mLvSkill[sk_point1 - 1];
            while (sk_point1 > 1 && _skill.LvRe > conn.p.level) {
                sk_point1--;
                _skill = conn.p.skills[index_skill].mLvSkill[sk_point1 - 1];
            }
            if (_skill.LvRe > conn.p.level) {
                Service.send_notice_nobox_white(conn, "LV không đủ " + _skill.LvRe);
                return;
            }

            int sk_pointPlus = conn.p.get_skill_point_plus(index_skill);
            if (sk_point1 + sk_pointPlus <= 15) {
                _skill = conn.p.skills[index_skill].mLvSkill[(sk_point1 + sk_pointPlus) - 1];
            } else {
                _skill = conn.p.skills[index_skill].mLvSkill[14];
            }
            if (conn.p.mp - _skill.mpLost < 0) {
                Service.send_notice_nobox_white(conn, "Không đủ mp");
                return;
            }

            if (conn.p.isStunes(true)) {
                return;
            }
            if (conn.p.time_delay_skill[index_skill] > time_) {
                if (++conn.p.enough_time_disconnect > 5) {
                    conn.close();
                }
                return;
            }
            conn.p.mp -= _skill.mpLost;
            n = (_skill.nTarget < n) ? _skill.nTarget : n;
            conn.p.time_delay_skill[index_skill] = (long) (time_ + _skill.delay * 0.97);
            conn.p.enough_time_disconnect = 0;
            byte type = 0;
            if (index_skill == 2 || index_skill == 4 || index_skill == 6 || index_skill == 8 || index_skill == 19 || index_skill == 20) {
                type = index_skill == 20 && (conn.p.clazz == 2 || conn.p.clazz == 1)
                        || index_skill == 19 && (conn.p.clazz == 0 || conn.p.clazz == 3) ? (byte) 0 : 1;
            }
            if (index_skill == 0) {
                type = 2;
            }
            List<Integer> ListATK = new ArrayList<>();
            if (type_atk == 0) {
                for (int i = 0; i < n; ++i) {
                    ObjAtk = Short.toUnsignedInt(m.reader().readShort());
                    Mob_in_map mob_target = MapService.get_mob_by_index(map, ObjAtk);
                    if (mob_target == null) {
                        mob_target = map.GetBoss(ObjAtk);
                    }
                    // Gọi hàm handleAttack để kiểm tra quyền tấn công
                    if (mob_target != null && mob_target.isBoss() && !handleAttack(conn.p, mob_target)) {
                        //Service.send_notice_box(conn, "Bạn không có quyền tấn công boss này.");
                        continue;
                    }

                    if (map.isMapChienTruong()) {
                        if (conn.p.typepk == 1 && mob_target.template.mob_id == 92
                                || conn.p.typepk == 2 && mob_target.template.mob_id == 90
                                || conn.p.typepk == 4 && mob_target.template.mob_id == 89
                                || conn.p.typepk == 5 && mob_target.template.mob_id == 91) {
                            Service.send_notice_nobox_white(conn, "Định tự đốt nhà à");
                            return;
                        }

                    }
                    if (map.zone_id == map.maxzone && !map.isMapChiemThanh() && !map.isMapLoiDai()) {
                        Pet_di_buon pet_di_buon = Pet_di_buon_manager.check(ObjAtk);
                        if (pet_di_buon != null) {
                            if (!pet_di_buon.equals(conn.p.pet_di_buon)) {
                                MainObject.MainAttack(map, conn.p, pet_di_buon, index_skill, _skill, type);
                            }
                        }
                    } else if (mob_target != null) {
                        MainObject.MainAttack(map, conn.p, mob_target, index_skill, _skill, type);
                    } else if (ObjAtk > 10000 && ObjAtk < 11000) {
                        Message m2 = new Message(17);
                        m2.writer().writeShort(-1);
                        m2.writer().writeShort(ObjAtk);
                        conn.addmsg(m2);
                        m2.cleanup();
                    } else if (conn.p.map.map_id == 48) {
                        Dungeon d = null;

                        // Nếu người chơi có party và có Dungeon của leader
                        if (conn.p.party != null) {
                            d = DungeonManager.get_list(conn.p.party.getLeader().name); // Dungeon của leader
                        } else {
                            d = DungeonManager.get_list(conn.p.name); // Dungeon của cá nhân
                        }

                        // Nếu Dungeon tồn tại
                        if (d != null) {
                            Mob_Dungeon mod_target_dungeon = d.get_mob(ObjAtk); // Lấy mob trong Dungeon
                            if (mod_target_dungeon != null) {
                                // Gọi hàm tấn công
                                //Service.send_notice_nobox_white(conn, "duge");
                                MainObject.MainAttack(map, conn.p, mod_target_dungeon, index_skill, _skill, type);
                            }
                        } else {
                            // Trường hợp không có Dungeon phù hợp
                            Service.send_notice_nobox_white(conn, "Không tìm thấy Dungeon!");
                        }
                    } else if (Map.is_map_chiem_mo(conn.p.map, true) && conn.p.myclan != null) {
                        //Mob_MoTaiNguyen temp_mob = conn.p.myclan.get_mo_tai_nguyen(ObjAtk);
                        conn.p.chon_mob = ObjAtk; // Gán ID c?a mob m? cho chon_mob        
                        Mob_MoTaiNguyen temp_mob = conn.p.myclan.get_mo_tai_nguyen(conn.p.chon_mob);
                        if (temp_mob == null) { // Đánh mỏ

                            temp_mob = Manager.gI().chiem_mo.get_mob_in_map(map);
                            if (temp_mob.nhanban == null) {
                                MainObject.MainAttack(map, conn.p, temp_mob, index_skill, _skill, type);
                            } else {
                                Service.send_notice_nobox_white(conn, "Không thể Khi Nb còn Sống");

                            } 
                        } else {
                            if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                                MenuController.send_menu_select(conn, 611, new String[]{"Thu Hoạch", "Thông Tin"});
                            }
                            if (conn.p.myclan.mems.get(0).name.equals(conn.p.name) && conn.p.myclan.kimcuong >= 100
                                    && temp_mob.nhanban_save != null && temp_mob.nhanban == null) {
                                conn.p.myclan.kimcuong -= 100;
                                temp_mob.nhanban_save.hp = temp_mob.nhanban_save.get_HpMax();
                                temp_mob.nhanban = temp_mob.nhanban_save;
                                Manager.gI().add_list_nhanbban(temp_mob.nhanban);
                                Message m12 = new Message(4);
                                m12.writer().writeByte(0);
                                m12.writer().writeShort(0);
                                m12.writer().writeShort(temp_mob.nhanban.index);
                                m12.writer().writeShort(temp_mob.nhanban.x);
                                m12.writer().writeShort(temp_mob.nhanban.y);
                                m12.writer().writeByte(-1);
                                MapService.send_msg_player_inside(map, conn.p, m12, true);
                                m12.cleanup();
                            }
                        }
                    }

                    if (mob_target != null && mob_target.isBoss()) {
                        ListATK.add(mob_target.index);
                    }
                }
            } else if (type_atk == 1) {
                Leothap lt = LeothapManager.get_list(conn.p.name);

                for (int i = 0; i < n; ++i) {
                    n3 = m.reader().readShort();
                    int n2 = Short.toUnsignedInt(n3);
                    Player p_target = MapService.get_player_by_id(map, n2);
                    //Squire s_target = MapService.get_squire_by_id(map, n3);
                    MainObject s_target = MapService.get_squire_by_id(map, n3);
                    if (p_target != null) {
                        MainObject.MainAttack(map, conn.p, p_target, index_skill, _skill, type);
                        ListATK.add(p_target.index);
                    } else if (s_target != null) {
                        attackSquire(map, conn, index_skill, (Squire) s_target);
                        ListATK.add(s_target.index);
                    } else if (Map.is_map_chiem_mo(conn.p.map, true) && conn.p.myclan != null) {
                        Mob_MoTaiNguyen temp_mob = conn.p.myclan.get_mo_tai_nguyen(n2);
                        if (temp_mob == null) {
                            temp_mob = Manager.gI().chiem_mo.get_mob_in_map(conn.p.map);
                            if (temp_mob.nhanban != null && temp_mob.nhanban.index == n2) {
                                ListATK.add(temp_mob.nhanban.index);
                                MainObject.MainAttack(map, conn.p, temp_mob.nhanban, index_skill, _skill, type);
                            }
                        }
                    } else if (lt != null) {
                        Boss_Leothap temp_mob = lt.get_mob(n2);
                        if (temp_mob != null && temp_mob.index == n2) {
                            ListATK.add(temp_mob.index);
                            MainObject.MainAttack(map, conn.p, temp_mob, index_skill, _skill, type);
                        }
                    } else if (n2 >= 0 && !Map.is_map_chien_truong(map.map_id)) {
                        Nbxx nb = Manager.gI().getCreatNb(n2);
                        Nbtd nb1 = Manager.gI().Get_index(n2);

                        if (nb != null && nb.map_id == map.map_id) {
                            MainObject.MainAttack(map, conn.p, nb, index_skill, _skill, type);
                            ListATK.add(nb.index);
                        } else if (nb1 != null) {
                            MainObject.MainAttack(map, conn.p, nb1, index_skill, _skill, type);
                            ListATK.add(nb1.index);
                        }
                    } else if (n2 >= 0 && Map.is_map_chien_truong(map.map_id)) {
                        for (LinhCanh guard : ChienTruong.gI().list_ai) {
                            if (guard.id == n3) {
                                LinhCanh.atk1(map, conn.p, n3, index_skill, type);
                                ListATK.add(guard.id);
                                break;
                            }
                        }
                    } else if (n3 >= -1000 && n3 < 0) {
                        for (MobAi ai : map.Ai_entrys) {
                            if (ai != null && ai.index == n3) {
                                try {
                                    MainObject.MainAttack(map, conn.p, ai, index_skill, _skill, type);
                                    //Service.send_notice_nobox_white(conn, "test5");
                                    ListATK.add(ai.index);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                        }

                        //
                        /*if (map.isMapChienTruong()) {
                            for (LinhCanh guard : ChienTruong.gI().list_ai) {
                                if (guard.id == n3) {
                                    LinhCanh.atk1(map, conn.p, n3, index_skill, type);
                                    ListATK.add(guard.id);
                                    break;
                                }
                            }
                        }*/
                        //
                    }
                    //
                }

            }
            if (!ListATK.isEmpty()) {
                int prKham = 0;
                if ((prKham = conn.p.total_item_param(100)) > 0) {
                    if (ListATK.contains(conn.p.kham.idAtk_HN)) {
                        conn.p.kham.CountAtk_HN++;
                    } else {
                        conn.p.kham.idAtk_HN = ListATK.get(Util.random(ListATK.size()));
                        conn.p.kham.CountAtk_HN = 1;
                    }
                    if (prKham > 0 && conn.p.kham.CountAtk_HN >= prKham) {
                        conn.p.kham.idAtk_HN = 0;
                        conn.p.kham.CountAtk_HN = 0;
                        conn.p.add_EffMe_Kham(StrucEff.NgocHonNguyen, 0, System.currentTimeMillis() + 3000);
                        Eff_special_skill.send_eff_kham(conn.p, StrucEff.NgocHonNguyen, 3000);
                    }
                }
            }

            Pet.get_pet(n3, time_);

            if (conn.p.squire != null && conn.p.isLiveSquire) {
                conn.p.squire.use_skill(map, conn, n, ObjAtk, n3, type_atk);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Fire_Mob_DiBuon(Map map, Session conn, Pet_di_buon pet_di_buon, int index_skill, int dameBase) throws IOException {
        if (dameBase < 0) {
            dameBase = 0;
        }
        if (pet_di_buon != null) {

            int damePlus = 0;
            int idPlus = 12;
            if ((damePlus = conn.p.getDameBt()) > 0) {
                idPlus = 11;
            } else if ((damePlus = conn.p.getDameAs()) > 0) {
                idPlus = 10;
            }
            pet_di_buon.hp -= damePlus;

            pet_di_buon.hp -= dameBase;
            if (pet_di_buon.hp <= 0) {
                pet_di_buon.hp = 0;
                Message mout = new Message(8);
                mout.writer().writeShort(pet_di_buon.index);
                for (int i1 = 0; i1 < map.players.size(); i1++) {
                    Player p0 = map.players.get(i1);
                    if (p0 != null) {
                        p0.conn.addmsg(mout);
                    }
                }
                mout.cleanup();
                Pet_di_buon_manager.remove(pet_di_buon.name);
                pet_di_buon.p.pet_di_buon = null;
                for (int j = 0; j < pet_di_buon.item.size(); j++) {
                    ItemMap it_leave = new ItemMap();
                    it_leave.id_item = (short) pet_di_buon.item.get(j);
                    it_leave.color = (byte) 0;
                    it_leave.quantity = 1;
                    it_leave.category = 3;
                    it_leave.idmaster = (short) pet_di_buon.p.index;
                    it_leave.op = new ArrayList<>();
                    it_leave.time_exist = System.currentTimeMillis() + 60_000L;
                    it_leave.time_pick = System.currentTimeMillis() + 1_500L;
                    map.add_item_map_leave(map, conn.p, it_leave, pet_di_buon.index);
                }
            }
            Message m_atk = new Message(9);
            m_atk.writer().writeShort(conn.p.index);
            m_atk.writer().writeByte(index_skill);
            m_atk.writer().writeByte(1);
            m_atk.writer().writeShort(pet_di_buon.index);
            m_atk.writer().writeInt((int) dameBase); // dame
            m_atk.writer().writeInt(pet_di_buon.hp); // hp mob after
            m_atk.writer().writeByte(0);
            m_atk.writer().writeInt(conn.p.hp);
            m_atk.writer().writeInt(conn.p.mp);
            m_atk.writer().writeByte(idPlus); // 1: green, 5: small white 9: big white, 10: st dien, 11: st bang
            m_atk.writer().writeInt(damePlus); // dame plus
            MapService.send_msg_player_inside(map, conn.p, m_atk, true);
            m_atk.cleanup();
            pet_di_buon.update_all(conn.p);
        }
    }

    public static void use_item_arena(Map map, Player p, short id) throws IOException {
        if (Map.is_map_chien_truong(map.map_id)) {
            if (p.time_use_item_arena < System.currentTimeMillis()) {
                if (map.time_use_item_arena < System.currentTimeMillis()) {
                    boolean ch = false;
                    switch (map.map_id) {
                        case 54: {
                            if (p.typepk == 5) {
                                ch = true;
                            }
                            break;
                        }
                        case 56: {
                            if (p.typepk == 2) {
                                ch = true;
                            }
                            break;
                        }
                        case 58: {
                            if (p.typepk == 4) {
                                ch = true;
                            }
                            break;
                        }
                        case 60: {
                            if (p.typepk == 1) {
                                ch = true;
                            }
                            break;
                        }
                    }
                    if (ch) {
                        switch (id) {
                            case 57: {
                                break;
                            }
                            case 58: {
                                for (int i2 = 0; i2 < map.players.size(); i2++) {
                                    Player p0 = map.players.get(i2);
                                    if (p0.typepk != p.typepk) {
                                        // Message m = new Message(6);
                                        // m.writer().writeByte(1);
                                        // m.writer().writeShort(102);
                                        // m.writer().writeShort(p0.id);
                                        // for (int i = 0; i < map.players.size(); i++) {
                                        // Player p01 = map.players.get(i);
                                        // p01.conn.addmsg(m);
                                        // }
                                        // m.cleanup();
                                        p0.id_henshin = 102;
                                        p0.time_henshin = System.currentTimeMillis() + 6_000L;
                                        for (int i = 0; i < map.players.size(); i++) {
                                            Player p01 = map.players.get(i);
                                            MapService.send_in4_other_char(map, p01, p0);
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        p.item.remove(4, id, 1);
                        p.update_point_arena(10);
                        map.time_use_item_arena = System.currentTimeMillis() + 250_000L;
                        p.time_use_item_arena = System.currentTimeMillis() + 250_000L;
                    }
                } else {
                    Service.send_notice_box(p.conn,
                            "Sử dụng sau " + (map.time_use_item_arena - System.currentTimeMillis()) / 1000 + " s");
                }
            } else {
                Service.send_notice_box(p.conn,
                        "Sử dụng sau " + (p.time_use_item_arena - System.currentTimeMillis()) / 1000 + " s");
            }
        }
    }

    public static boolean handleAttack(Player p, Mob_in_map boss) throws IOException {
        // case 53
        if (boss.isCase53Boss) {
            // xem boss của ai
            if (boss.callerId != p.index) {
                // party
                Player bossCaller = Map.get_player_by_id(boss.callerId);
                if (bossCaller.party != null && bossCaller.party.get_mems().contains(p)) {
                    return true; // mem attack
                } else {
                    Service.send_notice_nobox_white(p.conn, "Boss này của " + boss.callerName + "!");
                    return false;
                }
            }
        }
        return true;
    }

     public static void callNbxx(Map map, Player p) throws IOException {
//        if (p instanceof Squire) {
//        Service.send_notice_nobox_white(p.conn, "mày chỉ là đệ");
//        return;
//    }
//         if (p.myclan == null) {
//        Service.send_notice_nobox_white(p.conn, "Hãy Gia nhập Clan");
//       return; 
//    }
//        Nbxx nb = new Nbxx(p);
//        nb.setup(p);
//        nb.act_time = System.currentTimeMillis() + 15000; // Thi?t l?p th?i gian t?n t?i 15 giây
//        Manager.gI().add_list_nbxx(nb);
//        Message m12 = new Message(4);
//        m12.writer().writeByte(0);
//        m12.writer().writeShort(0);
//        m12.writer().writeShort(nb.index);
//        m12.writer().writeShort(nb.x);
//        m12.writer().writeShort(nb.y);
//        m12.writer().writeByte(-1);
//        MapService.send_msg_player_inside(map, p, m12, true);
//        m12.cleanup();
    }

    /*public static Squire get_squire_by_id(Map map, int id) {
        for (Squire squire : map.squires) {
            if (squire.index == id) {
                return squire;
            }
        }
        return null;
    }*/
    public static MainObject get_squire_by_id(Map map, int id) {
        // Duyệt qua danh sách người chơi
        for (Player p : map.players) {
            if (p.index == id) {
                return p; // Trả về Player nếu chỉ số khớp
            }

            // Nếu người chơi có đệ tử (Squire) và id khớp với Squire
            if (p.isLiveSquire && p.squire != null && p.squire.index == id) {
                return p.squire; // Trả về Squire nếu tìm thấy
            }
        }
        return null; // Không tìm thấy Player hoặc Squire
    }

    public static void attackSquire(Map map, Session conn, int index_skill, Squire s_target) throws IOException {
        int dame = conn.p.get_DameProp(
                switch (conn.p.clazz) {
            case 0 ->
                2;
            case 1 ->
                4;
            case 2 ->
                1;
            case 3 ->
                3;
            default ->
                -1;
        }
        );

        if (dame == -1) {
            dame = conn.p.get_DameBase();
        }
        s_target.hp -= dame;

        if (s_target.hp <= 0) {
            s_target.isdie = true;
            s_target.hp = 0;  // Đảm bảo HP không âm
        }

        // Gửi thông điệp tới tất cả người chơi trong map rằng s_target đã bị tấn công
        Message m = new Message(6);
        m.writer().writeShort(conn.p.index);    // Chỉ số người tấn công
        m.writer().writeByte(index_skill);      // Chỉ số kỹ năng
        m.writer().writeByte(1);                // Loại tấn công
        m.writer().writeShort(s_target.index);  // Chỉ số của s_target (mục tiêu)
        m.writer().writeInt(dame);             // Lượng sát thương gây ra
        m.writer().writeInt(s_target.hp);       // HP còn lại của s_target
        m.writer().writeByte(0);                // Số hiệu ứng

        m.writer().writeInt(conn.p.hp);         // HP của người tấn công sau khi tấn công
        m.writer().writeInt(conn.p.mp);         // MP của người tấn công sau khi tấn công
        m.writer().writeByte(11);               // Thông tin bổ sung
        m.writer().writeInt(0);                 // Thông tin bổ sung khác
        MapService.send_msg_player_inside(map, s_target, m, true);  // Gửi thông điệp tới người chơi
        m.cleanup();
        MapService.update_in4_2_other_inside(map, s_target);
    }

}
