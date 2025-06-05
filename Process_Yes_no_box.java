package client;

import LeothapWeek.Leothap;
import LeothapWeek.LeothapManager;
import ai.Fusion;
import core.*;
import ev_he.Farm;
import ev_he.Farm.MobFarm;
import event.Event_5;
import java.io.IOException;
import event_daily.ChiemThanhManager;
import event_daily.CongNap;
import event_daily.Wedding;
import io.Message;
import io.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import map.Dungeon;
import map.DungeonManager;
import map.LeaveItemMap;
import map.Map;
import map.MapService;
import map.Vgo;
import template.Clan_mems;
import template.EffTemplate;
import template.Item3;
import template.Item47;
import template.ItemTemplate3;
import template.ItemTemplate4;
import template.ItemTemplate7;
import template.Level;
import template.Option;
import template.box_item_template;
import event_daily.*;
import java.util.HashMap;
import map.Mob_in_map;
import template.Mob;

public class Process_Yes_no_box {

    public Map map;

    public static void process(Session conn, Message m) throws IOException, InterruptedException {
        short id = m.reader().readShort(); // id
        if (id != conn.p.index) {
            return;

        }
        byte type = m.reader().readByte(); // type
        byte value = m.reader().readByte(); // value
        if (value != 1) {
            switch (type) {
                case 110: {
                    Player p0 = Map.get_player_by_name(conn.p.in4_wedding[1]);
                    Service.send_notice_box(p0.conn, "rất tiếc " + conn.p.name + " đã từ chối lời cầu hôn của bạn");
                    conn.p.in4_wedding = null;
                    break;
                }

                case 115: {
                    conn.p.id_remove_time_use = -1;
                    break;
                }
                case 70: {
                    Service.send_notice_box(conn, "Cần 20k ngọc!");
                    break;
                }
                case 126: {
                    conn.p.id_buffer_126 = -1;
                    conn.p.id_index_126 = -1;
                    break;
                }
                case 114: {
                    conn.p.id_wing_split = -1;
                    break;
                }
                case 113: {
                    conn.p.name_mem_clan_to_appoint = "";
                    break;
                }

                case 108:
                case 109: {
                    conn.p.it_change_op = null;
                    conn.p.it_change_op_index = -1;
                    break;
                }
            }
        } else {
            switch (type) {

                case 107: {
                    if (conn.p.nv_tinh_tu[3] < 10) {
                        Service.send_notice_box(conn,
                                "Bạn mới hoàn thành " + conn.p.nv_tinh_tu[3] + " / 10 nhiệm vụ tinh tú hôm nay");
                        return;
                    }
                    if (CongNap.CAT[CongNap.NV_CONG_NAP] == 4 && CongNap.ID[CongNap.NV_CONG_NAP] == -1) {
                        if (conn.p.get_vang() < 1_000_000) {
                            Service.send_notice_box(conn, "Không đủ 1tr vàng");
                            return;
                        }
                        conn.p.update_vang(-1_000_000);
                        List<Short> it_ = new ArrayList<>();
                        if (conn.p.level < 30) {
                            it_.addAll(LeaveItemMap.item2x);
                        } else if (conn.p.level < 40) {
                            it_.addAll(LeaveItemMap.item3x);
                        } else if (conn.p.level < 50) {
                            it_.addAll(LeaveItemMap.item4x);
                        } else if (conn.p.level < 60) {
                            it_.addAll(LeaveItemMap.item5x);
                        } else if (conn.p.level < 70) {
                            it_.addAll(LeaveItemMap.item6x);
                        } else if (conn.p.level < 80) {
                            it_.addAll(LeaveItemMap.item7x);
                        } else if (conn.p.level < 90) {
                            it_.addAll(LeaveItemMap.item8x);
                        } else if (conn.p.level < 100) {
                            it_.addAll(LeaveItemMap.item9x);
                        } else if (conn.p.level < 110) {
                            it_.addAll(LeaveItemMap.item10x);
                        } else if (conn.p.level < 120) {
                            it_.addAll(LeaveItemMap.item11x);
                        } else if (conn.p.level < 130) {
                            it_.addAll(LeaveItemMap.item12x);
                        } else if (conn.p.level < 140) {
                            it_.addAll(LeaveItemMap.item13x);
                        }
                        if (it_.size() < 1) {
                            return;
                        }
                        int id_item_can_drop = it_.get(Util.random(it_.size()));
                        int dem = 0;
                        if (50 > Util.random(120)) {
                            while (dem < 50 && it_.size() > 2 && conn.p.level > 0
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 3)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 4)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 5)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 6)) {
                                id_item_can_drop = it_.get(Util.random(it_.size()));
                                dem++;
                            }
                        } else {
                            while (dem < 50 && it_.size() > 2 && conn.p.level > 0
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 2
                                    && ItemTemplate3.item.get(id_item_can_drop).getClazz() == conn.p.clazz)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 0
                                    && ItemTemplate3.item.get(id_item_can_drop).getClazz() == conn.p.clazz)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 1
                                    && ItemTemplate3.item.get(id_item_can_drop).getClazz() == conn.p.clazz)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 8
                                    && ItemTemplate3.item.get(id_item_can_drop).getClazz() == conn.p.clazz)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 9
                                    && ItemTemplate3.item.get(id_item_can_drop).getClazz() == conn.p.clazz)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 10
                                    && ItemTemplate3.item.get(id_item_can_drop).getClazz() == conn.p.clazz)
                                    && !(ItemTemplate3.item.get(id_item_can_drop).getType() == 11
                                    && ItemTemplate3.item.get(id_item_can_drop).getClazz() == conn.p.clazz)) {
                                id_item_can_drop = it_.get(Util.random(it_.size()));
                                dem++;
                            }
                        }
                        if (dem >= 50) {
                            return;
                        }
                        byte color_ = 4;
                        byte tier_ = (byte) 0;
                        //
                        short index_real = 0;
                        String name = ItemTemplate3.item.get(id_item_can_drop).getName();
                        for (int i = id_item_can_drop - 5; i < id_item_can_drop + 5; i++) {
                            if (ItemTemplate3.item.get(i).getName().equals(name)
                                    && ItemTemplate3.item.get(i).getColor() == color_) {
                                index_real = (short) i;
                                break;
                            }
                        }
                        ItemTemplate3 item = ItemTemplate3.item.get(index_real);
                        //
                        // Message m = new Message(78);
                        // if (id == 207) {
                        // m.writer().writeUTF("Rương tím");
                        // } else if (id == 205) {
                        // m.writer().writeUTF("Rương đỏ");
                        // }
                        // m.writer().writeByte(1); // size
                        // for (int i = 0; i < 1; i++) {
                        // m.writer().writeUTF(item.getName()); // name
                        // m.writer().writeShort(item.getIcon()); // icon
                        // m.writer().writeInt(1); // quantity
                        // m.writer().writeByte(3); // type in bag
                        // m.writer().writeByte(tier_); // tier
                        // m.writer().writeByte(color_); // color
                        // }
                        // m.writer().writeUTF("");
                        // m.writer().writeByte(1);
                        // m.writer().writeByte(0);
                        // conn.addmsg(m);
                        // m.cleanup();
                        //
                        Item3 itbag = new Item3();
                        itbag.id = item.getId();
                        itbag.name = item.getName();
                        itbag.clazz = item.getClazz();
                        itbag.type = item.getType();
                        itbag.level = item.getLevel();
                        itbag.icon = item.getIcon();
                        itbag.op = new ArrayList<>();
                        itbag.op.addAll(item.getOp());
                        itbag.color = item.getColor();
                        itbag.part = item.getPart();
                        itbag.tier = tier_;
                        itbag.islock = false;
                        itbag.time_use = 0;
                        conn.p.item.add_item_bag3(itbag);
                        Service.send_notice_box(conn, "Nhận được " + itbag.name);
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);
                        conn.p.item.char_inventory(3);
                    } else if (CongNap.CAT[CongNap.NV_CONG_NAP] == 4 && CongNap.ID[CongNap.NV_CONG_NAP] == -2) {
                        if (conn.p.get_ngoc() < 5) {
                            Service.send_notice_box(conn, "Không đủ 5 ngọc");
                            return;
                        }
                        conn.p.update_ngoc(-5);
                        Item47 itbag = new Item47();
                        itbag.id = 459;
                        itbag.quantity = 1;
                        itbag.category = 7;
                        conn.p.item.add_item_bag47(7, itbag);
                        Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate7.item.get(itbag.id).getName());
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);
                        conn.p.item.char_inventory(3);
                    } else {
                        if (CongNap.CAT[CongNap.NV_CONG_NAP] == 4) {
                            if (conn.p.item.total_item_by_id(CongNap.CAT[CongNap.NV_CONG_NAP],
                                    CongNap.ID[CongNap.NV_CONG_NAP]) < CongNap.NUM[CongNap.NV_CONG_NAP]) {
                                Service.send_notice_box(conn, "Không đủ " + CongNap.NUM[CongNap.NV_CONG_NAP] + " "
                                        + ItemTemplate4.item.get(CongNap.ID[CongNap.NV_CONG_NAP]).getName());
                                return;
                            }
                        } else {
                            if (conn.p.item.total_item_by_id(CongNap.CAT[CongNap.NV_CONG_NAP],
                                    CongNap.ID[CongNap.NV_CONG_NAP]) < CongNap.NUM[CongNap.NV_CONG_NAP]) {
                                Service.send_notice_box(conn, "Không đủ " + CongNap.NUM[CongNap.NV_CONG_NAP] + " "
                                        + ItemTemplate7.item.get(CongNap.ID[CongNap.NV_CONG_NAP]).getName());
                                return;
                            }
                        }
                        conn.p.item.remove(CongNap.CAT[CongNap.NV_CONG_NAP], CongNap.ID[CongNap.NV_CONG_NAP],
                                CongNap.NUM[CongNap.NV_CONG_NAP]);
                        switch (CongNap.NV_CONG_NAP) {
                            case 1: {
                                conn.p.update_vang(100_000);
                                Service.send_notice_box(conn, "Nhận 100k vàng");
                                break;
                            }
                            case 2: {
                                Item47 itbag = new Item47();
                                itbag.id = 463;
                                itbag.quantity = 1;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 4: {
                                Item47 itbag = new Item47();
                                itbag.id = 346;
                                itbag.quantity = 1;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 5: {
                                Item47 itbag = new Item47();
                                itbag.id = 14;
                                itbag.quantity = 2;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 2 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 6: {
                                Item47 itbag = new Item47();
                                itbag.id = 251;
                                itbag.quantity = 20;
                                itbag.category = 4;
                                conn.p.item.add_item_bag47(4, itbag);
                                Service.send_notice_box(conn, "Nhận 20 " + ItemTemplate4.item.get(itbag.id).getName());
                                break;
                            }
                            case 7: {
                                Item47 itbag = new Item47();
                                itbag.id = 3;
                                itbag.quantity = 100;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 100 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 8: {
                                Item47 itbag = new Item47();
                                itbag.id = 131;
                                itbag.quantity = 1;
                                itbag.category = 4;
                                conn.p.item.add_item_bag47(4, itbag);
                                Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate4.item.get(itbag.id).getName());
                                break;
                            }
                            case 10: {
                                Item47 itbag = new Item47();
                                itbag.id = 462;
                                itbag.quantity = 1;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 11: {
                                Item47 itbag = new Item47();
                                itbag.id = 457;
                                itbag.quantity = 1;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 12: {
                                Item47 itbag = new Item47();
                                itbag.id = 9;
                                itbag.quantity = 10;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 10 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 13: {
                                Item47 itbag = new Item47();
                                itbag.id = 10;
                                itbag.quantity = 10;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 10 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 14: {
                                Item47 itbag = new Item47();
                                itbag.id = 11;
                                itbag.quantity = 10;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 10 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 15: {
                                Item47 itbag = new Item47();
                                itbag.id = 461;
                                itbag.quantity = 1;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                            case 16: {
                                Item47 itbag = new Item47();
                                itbag.id = 460;
                                itbag.quantity = 1;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                Service.send_notice_box(conn, "Nhận 1 " + ItemTemplate7.item.get(itbag.id).getName());
                                break;
                            }
                        }
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);
                        conn.p.item.char_inventory(3);
                    }
                    break;
                }

                case 108:
                case 109: {
                    for (int i = 0; i < conn.p.item.wear.length; i++) {
                        if (conn.p.item.wear[i] != null && conn.p.it_change_op != null
                                && conn.p.item.wear[i].id == conn.p.it_change_op.id) {
                            switch (i) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23: // case 24:
                                // case 25:
                                // case 26:
                                // case 27:
                                // case 28:
                                // case 29:
                                // case 30:
                                {
                                    if (type == 108) {
                                        if (conn.p.get_ngoc() < 10_000) {
                                            Service.send_notice_box(conn, "Không đủ 10k ngọc");
                                            return;
                                        }
                                        if (conn.p.get_vang() < 50_000_000) {
                                            Service.send_notice_box(conn, "Không đủ 50tr vàng");
                                            return;
                                        }
                                        conn.p.update_ngoc(-10_000);
                                        conn.p.update_vang(-50_000_000);
                                    } else {
                                        if (conn.p.get_ngoc() < 10_000) {
                                            Service.send_notice_box(conn, "Không đủ 10k ngọc");
                                            return;
                                        }
                                        if (conn.p.get_vang() < 50_000_000) {
                                            Service.send_notice_box(conn, "Không đủ 50tr vàng");
                                            return;
                                        }
                                        conn.p.update_ngoc(-10_000);
                                        conn.p.update_vang(-50_000_000);
                                    }
                                    break;
                                }

                                default: {
                                    conn.p.item.wear[i] = conn.p.it_change_op;
                                    conn.p.item.char_inventory(5);
                                    Service.send_notice_box(conn, "Đổi thành công!");
                                    break;
                                }
                            }
                            conn.p.item.wear[i] = conn.p.it_change_op;
                            conn.p.item.char_inventory(5);
                            Service.send_notice_box(conn, "Đổi thành công!");
                            break;
                        }
                    }

                    conn.p.it_change_op = null;
                    conn.p.it_change_op_index = -1;
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                    break;
                }

                case -122: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    if (conn.p.get_ngoc() > 5) {
                        if ((conn.p.item.total_item_by_id(7, 472) > 50 && conn.p.item.total_item_by_id(7, 473) > 50
                                && conn.p.item.total_item_by_id(7, 474) > 50 && conn.p.item.total_item_by_id(7, 475) > 50) || conn.ac_admin > 2) {
                            short[] id_ma_phap = new short[]{4578, 4579, 4581, 4583};
                            ItemTemplate3 temp3 = ItemTemplate3.item.get(id_ma_phap[Util.random(id_ma_phap.length)]);
                            Item3 it = new Item3();
                            it.id = temp3.getId();
                            it.name = temp3.getName();
                            it.clazz = temp3.getClazz();
                            it.type = temp3.getType();
                            it.level = temp3.getLevel();
                            it.icon = temp3.getIcon();
                            it.op = temp3.getOp();
                            it.op.add(new Option((byte) 61, 0));
                            it.color = 3;
                            it.islock = true;
                            it.part = temp3.getPart();
                            conn.p.item.add_item_bag3(it);
                            it.op.clear();
                            conn.p.item.remove(7, 472, 50);
                            conn.p.item.remove(7, 473, 50);
                            conn.p.item.remove(7, 474, 50);
                            conn.p.item.remove(7, 475, 50);
                            conn.p.item.char_inventory(3);
                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.update_ngoc(-5);

                            Service.send_notice_box(conn, "Ghép thành công");
                        } else {
                            Service.send_notice_box(conn, "Bạn cần có 50 mảnh (Mảnh sách đỏ 1, Mảnh sách đỏ 2,"
                                    + " Mảnh sách đỏ 3, Mảnh sách đỏ 4)");
                        }
                    } else {
                        Service.send_notice_box(conn, "Không đủ ngọc");
                    }
                    break;
                }
                case -123: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    if (conn.p.get_ngoc() >= 10) {
                        if ((conn.p.item.total_item_by_id(7, 476) > 50 && conn.p.item.total_item_by_id(7, 477) > 50
                                && conn.p.item.total_item_by_id(7, 478) > 50 && conn.p.item.total_item_by_id(7, 479) > 50) || conn.ac_admin > 2) {
                            short[] id_vat_ly = new short[]{4577, 4580, 4582, 4584};
                            ItemTemplate3 temp3 = ItemTemplate3.item.get(id_vat_ly[Util.random(id_vat_ly.length)]);
                            Item3 it = new Item3();
                            it.id = temp3.getId();
                            it.name = temp3.getName();
                            it.clazz = temp3.getClazz();
                            it.type = temp3.getType();
                            it.level = temp3.getLevel();
                            it.icon = temp3.getIcon();
                            it.op = temp3.getOp();
                            it.op.add(new Option((byte) 61, 0));
                            it.color = temp3.getColor();
                            it.islock = true;
                            it.part = temp3.getPart();
                            conn.p.item.add_item_bag3(it);
                            it.op.clear();
                            conn.p.item.remove(7, 476, 50);
                            conn.p.item.remove(7, 477, 50);
                            conn.p.item.remove(7, 478, 50);
                            conn.p.item.remove(7, 479, 50);
                            conn.p.item.char_inventory(3);
                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.update_ngoc(-10);

                            Service.send_notice_box(conn, "Ghép thành công");
                        } else {
                            Service.send_notice_box(conn, "Bạn cần có 50 mảnh (Mảnh sách xanh 1, Mảnh sách xanh 2,"
                                    + " Mảnh sách xanh 3, Mảnh sách xanh 4)");
                        }
                    } else {
                        Service.send_notice_box(conn, "Không đủ ngọc");
                    }
                    break;
                }
                case -121: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    int level = conn.p.skill_110[conn.p.id_index_temp];
                    if (conn.p.skill_110[conn.p.id_index_temp] >= 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Kỹ năng được nâng cấp tối đa");
                        return;
                    }
                    int id_book = -1;
                    if (conn.p.id_index_temp == 1) {
                        id_book = switch (conn.p.clazz) {
                            case 0 ->
                                4578;
                            case 1 ->
                                4580;
                            case 2 ->
                                4582;
                            case 3 ->
                                4584;
                            default ->
                                id_book;
                        };
                    } else if (conn.p.id_index_temp == 0) {
                        id_book = switch (conn.p.clazz) {
                            case 0 ->
                                4577;
                            case 1 ->
                                4579;
                            case 2 ->
                                4581;
                            case 3 ->
                                4583;
                            default ->
                                id_book;
                        };
                    }
                    if (conn.p.get_ngoc() < level * 5 + 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Không đủ ngọc");
                        return;
                    }
                    if (conn.p.item.total_item_book_skill(id_book) >= (level + 1)) {
                        if (Util.nextInt(100) < 20 - level || level == 0) {
                            conn.p.skill_110[conn.p.id_index_temp] += 1;
                            Service.send_notice_box(conn, "Nâng cấp thành công");
                            conn.p.item.remove_item_book_skill(id_book, (level + 1));
                            conn.p.load_skill();
                            Service.send_skill(conn.p);
                        } else {
                            Service.send_notice_box(conn, "Thất bại rồi");
                            conn.p.item.remove_item_book_skill(id_book, 1);
                        }
                        //conn.p.item.remove_item_book_skill(id_book, (level + 1));
                        conn.p.item.char_inventory(3);
                        conn.p.id_index_temp = -1;
                        conn.p.update_ngoc(-(level * 5 + 10));
                    } else {
                        Service.send_notice_box(conn, "Không đủ sách");
                    }
                    break;
                }
                case -120: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    int level = conn.p.skill_110[conn.p.id_index_temp];
                    if (conn.p.skill_110[conn.p.id_index_temp] >= 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Kỹ năng được nâng cấp tối đa");
                        return;
                    }
                    int id_book = -1;
                    int type_book = -1;
                    if (conn.p.id_index_temp == 1) {
                        id_book = switch (conn.p.clazz) {
                            case 0 ->
                                4578;
                            case 1 ->
                                4580;
                            case 2 ->
                                4582;
                            case 3 ->
                                4584;
                            default ->
                                id_book;
                        };
                    } else if (conn.p.id_index_temp == 0) {
                        id_book = switch (conn.p.clazz) {
                            case 0 ->
                                4577;
                            case 1 ->
                                4579;
                            case 2 ->
                                4581;
                            case 3 ->
                                4583;
                            default ->
                                id_book;
                        };
                    }
                    if (conn.p.get_ngoc() < level * 5 + 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Không đủ ngọc");
                        return;
                    }
                    if (conn.p.item.total_item_book(type_book, id_book) >= (level + 1)) {
                        if (Util.nextInt(100) < 20 - level || level == 0) {
                            conn.p.skill_110[conn.p.id_index_temp] += 1;
                            Service.send_notice_box(conn, "Nâng cấp thành công");
                            conn.p.load_skill();
                            conn.p.item.remove_item_book_skill(id_book, (level + 1));
                            Service.send_skill(conn.p);
                        } else {
                            Service.send_notice_box(conn, "Thất bại rồi");
                            conn.p.item.remove_item_book_skill(id_book, 1);
                        }
                        conn.p.id_index_temp = -1;
                        //conn.p.item.remove_item_book_skill(id_book, (level + 1));
                        conn.p.item.char_inventory(3);
                        conn.p.update_ngoc(-(level * 5 + 10));
                    } else {
                        Service.send_notice_box(conn, "Không đủ sách");
                    }
                    break;
                }

                case 112: {
                    Wedding temp = Wedding.get_obj(conn.p.name);
                    if (temp.exp < Level.entrys.get(temp.it.tier).exp) {
                        Service.send_notice_box(conn, "chưa đủ 100% exp!");
                        return;
                    }
                    long vang_req = (3 * (temp.it.tier + 1)) * 1_000_000L;
                    int ngoc_req = (3 * (temp.it.tier + 1)) * 1_000;
                    if (conn.p.get_vang() < vang_req) {
                        Service.send_notice_box(conn, "chưa đủ " + vang_req + " vàng!");
                        return;
                    }
                    if (conn.p.get_ngoc() < ngoc_req) {
                        Service.send_notice_box(conn, "chưa đủ " + ngoc_req + " ngọc!");
                        return;
                    }
                    conn.p.update_vang(-vang_req);
                    conn.p.update_ngoc(-ngoc_req);
                    conn.p.item.char_inventory(5);
                    boolean suc = 80 > Util.random(100);
                    if (suc) {
                        temp.exp -= Level.entrys.get(temp.it.tier).exp;
                        temp.it.tier++;
                        Service.send_notice_box(conn, "nâng cấp thành công lên +" + temp.it.tier);
                        conn.p.item.wear[23] = temp.it;
                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        //
                        Player p0 = Map.get_player_by_name(temp.name_1.equals(conn.p.name) ? temp.name_2 : temp.name_1);
                        if (p0 != null) {
                            p0.item.wear[23] = temp.it;
                            Service.send_wear(p0);
                            Service.send_char_main_in4(p0);
                            MapService.update_in4_2_other_inside(p0.map, p0);
                        }
                    } else {
                        Service.send_notice_box(conn, "nâng cấp thất bại!");
                    }
                    break;
                }
                case 111: {
                    Wedding temp = Wedding.get_obj(conn.p.name);
                    conn.p.item.wear[23] = null;
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                    MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                    Service.send_notice_box(conn, "Ly hôn thành công");
                    conn.p.it_wedding = null;
                    Player p0 = Map.get_player_by_name(temp.name_1.equals(conn.p.name) ? temp.name_2 : temp.name_1);
                    if (p0 != null) {
                        p0.item.wear[23] = null;
                        Service.send_wear(p0);
                        Service.send_char_main_in4(p0);
                        MapService.update_in4_2_other_inside(p0.map, p0);
                        Service.send_notice_box(p0.conn, conn.p.name + " đã rời xa bạn");
                        p0.it_wedding = null;
                    }
                    Wedding.remove_wed(temp);
                    break;
                }
                case 110: {
                    Player p0 = Map.get_player_by_name(conn.p.in4_wedding[1]);
                    Wedding.add_new(Integer.parseInt(conn.p.in4_wedding[0]), p0, conn.p);
                    conn.p.in4_wedding = null;
                    Service.send_notice_box(p0.conn, "chúc mừng " + conn.p.name + " trở thành bạn đời của bạn");
                    Service.send_notice_box(conn, "chúc mừng " + p0.name + " trở thành bạn đời của bạn");
                    break;
                }
                case -127: {

                    if (!conn.p.isOwner) {
                        return;
                    }

                    if (conn.p.get_ngoc() < 1000) {
                        Service.send_notice_box(conn, "Không đủ ngọc, Hãy kiếm thêm đi");
                        return;
                    }
                    if (conn.p.level < 10) {
                        Service.send_notice_box(conn, "Yêu cầu level trên 10");
                        return;
                    }
                    if (conn.p.squire == null) {
                        Squire.create(conn.p);
                        conn.p.squire = new Squire(conn, conn.p.index);
                        conn.p.squire.load();
                        conn.p.update_ngoc(-1000);
                        Service.send_notice_box(conn, "Nhận thành công đệ tử");
                        Squire.callSquire(conn);
                    }
                    break;
                }
                case -124: {
                    Fusion fusion = new Fusion();
                    if (fusion.isFusion(conn.p) == true) {
                        Service.send_notice_box(conn, "Tách Hợp thể Trước");

                        return;
                    }
                    if (conn.p.squire != null && conn.p.isOwner) {
                        try (Connection connnect = SQL.gI().getConnection(); PreparedStatement ps = connnect.prepareStatement("DELETE FROM `squire` WHERE `id` = ?;")) {
                            ps.setInt(1, conn.p.squire.index);
                            ps.executeUpdate();
                            connnect.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        if (conn.p.isLiveSquire) {
                            Squire.squireLeaveMap(conn.p);
                        }
                        conn.p.isLiveSquire = false;
                        conn.p.squire = null;
                        Service.send_notice_box(conn, "Đã huỷ đệ tử");
                    } else {
                        Service.send_notice_box(conn, "Chưa có đệ tử");
                    }
                    break;
                }
                case 97: {
                    conn.p.Store_Sell_ToPL = "no name";
                    Service.send_box_input_text(conn, 20, "Bán riêng cho nhân vật", new String[]{"Tên nhân vật"});
                    break;
                }
                case 113: {
                    if (conn.p.name_mem_clan_to_appoint.isEmpty()) {
                        return;
                    }
                    if (conn.p.myclan != null && conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        boolean suc = false;
                        for (int i = 1; i < conn.p.myclan.mems.size(); i++) {
                            if (conn.p.myclan.mems.get(i).name.equals(conn.p.name_mem_clan_to_appoint)) {
                                Clan_mems temp = conn.p.myclan.mems.get(0);
                                //
                                conn.p.myclan.mems.get(i).mem_type = 127;
                                conn.p.myclan.mems.get(0).mem_type = 122;
                                //
                                conn.p.myclan.mems.set(0, conn.p.myclan.mems.get(i));
                                conn.p.myclan.mems.set(i, temp);

                                //
                                MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                                MapService.send_in4_other_char(conn.p.map, conn.p, conn.p);
                                Service.send_char_main_in4(conn.p);

                                Player p0 = Map.get_player_by_name(conn.p.myclan.mems.get(0).name);
                                if (p0 != null) {
                                    MapService.update_in4_2_other_inside(p0.map, p0);
                                    MapService.send_in4_other_char(p0.map, p0, p0);
                                    Service.send_char_main_in4(p0);
                                }
                                //
                                suc = true;
                                break;
                            }
                        }
                        if (suc) {
                            Service.send_notice_box(conn, "Thành công!");
                        } else {
                            Service.send_notice_box(conn, "Tên không tồn tại");
                        }
                    } else {
                        Service.send_notice_box(conn, "Đã xảy ra lỗi");
                    }
                    break;
                }
                case 114: {
                    Item3 item = null;
                    int count = 0;
                    for (int i = 0; i < conn.p.item.bag3.length; i++) {
                        Item3 it = conn.p.item.bag3[i];
                        if (it != null && it.type == 7 && it.tier > 0) {
                            if (count == conn.p.id_wing_split) {
                                item = it;
                                break;
                            }
                            count++;
                        }
                    }
                    if (item != null) {

                        int quant1 = 40;
                        int quant2 = 10;
                        int quant3 = 50;
                        for (int i = 0; i < item.tier; i++) {
                            quant1 += GameSrc.wing_upgrade_material_long_khuc_xuong[i];
                            quant2 += GameSrc.wing_upgrade_material_kim_loai[i];
                            quant3 += GameSrc.wing_upgrade_material_da_cuong_hoa[i];
                            if ((i + 1) == 10 || (i + 1) == 20 || (i + 1) == 30) {
                                item.part--;
                            }
                        }
                        if (item.tier > 15) {
                            quant1 /= 2;
                            quant2 /= 2;
                            quant3 /= 2;
                        } else {
                            quant1 /= 3;
                            quant2 /= 3;
                            quant3 /= 3;
                        }
                        short[] id_ = new short[]{8, 9, 10, 11, 3, 0};
                        int[] quant_ = new int[]{quant1, quant1, quant1, quant1, quant2, quant3};
                        for (int i = 0; i < id_.length; i++) {
                            Item47 it = new Item47();
                            it.category = 7;
                            it.id = id_[i];
                            it.quantity = (short) quant_[i];
                            conn.p.item.add_item_bag47(7, it);
                        }
                        //
//                                                item = null;
                        count = 0;
                        for (int i = 0; i < conn.p.item.bag3.length; i++) {

                            Item3 it = conn.p.item.bag3[i];
                            if (it != null && it.type == 7 && it.tier > 0) {
                                if (count == conn.p.id_wing_split) {
                                    conn.p.item.bag3[i] = null;
                                    break;
                                }
                                count++;
                            }
                        }
                        conn.p.id_wing_split = -1;
//                                                for (int i = 0; i < item.op.size(); i++) {
//                                                if ((item.op.get(i).id > 26 || item.op.get(i).id < 23)
//							      && (item.op.get(i).id != 41 && item.op.get(i).id != 42)) {
//                                                    item.op.remove(i--);
//                                                }
//                                            }
                        //
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);
                        conn.p.item.char_inventory(3);
                        Service.send_notice_box(conn, "Thành công");
                    } else {
                        Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại!");
                        conn.p.id_wing_split = -1;
                    }
                    break;
                }
                case 9: {
                    if (conn.p.map.isMapChienTruong()) {

                    } else if (conn.p.map.isMapChiemThanh()) {
                        ChiemThanhManager.ActionHoiSinh(conn.p.map, conn.p);
                    } else {
                        if (conn.p.get_ngoc() >= 5) {
                            conn.p.isdie = false;
                            conn.p.hp = conn.p.body.get_HpMax();
                            conn.p.mp = conn.p.body.get_MpMax();
                            conn.p.update_ngoc(-5);
                            //conn.p.item.char_inventory(5);
                            Service.send_char_main_in4(conn.p);
                            // chest in4
                            Service.send_combo(conn);
                            Service.usepotion(conn.p, 0, conn.p.body.get_HpMax());
                            Service.usepotion(conn.p, 1, conn.p.body.get_MpMax());
                        } else {
                            Service.send_notice_box(conn, "Không đủ ngọc để thực hiện");
                        }
                    }
                    break;
                }

                case 85: {
                    Manager.gI().tx.send_in4(conn.p);
                    break;
                }
                case 86: {
                    Manager.gI().vxmm.send_in4(conn.p);
                    break;
                }

                case 87: {
                    Manager.gI().vxkc.send_in4(conn.p);
                    break;
                }
                case 94: {
                    GameSrc.ChangeCS_Medal(conn, 94);
                    break;
                }
                case 98: {
                    GameSrc.ChangeCS_Medal(conn, 98);
                    break;
                }

                case 115: {
                    if (conn.p.id_remove_time_use != -1) {
                        Item3 it = conn.p.item.bag3[conn.p.id_remove_time_use];
                        if (it != null && it.time_use > 0) {
                            int ngoc_ = conn.p.get_ngoc();
                            if (ngoc_ > 4) {
                                long price = it.time_use - System.currentTimeMillis();
                                price /= 30_600_000;
                                price = (price > 4) ? (price + 1) : 5;
                                boolean ch = false;
                                if (ngoc_ >= price) {
                                    ch = true;
                                } else {
                                    price = ngoc_;
                                }
                                it.time_use -= (price * 30_600_000);
                                conn.p.update_ngoc(-price);
                                conn.p.item.char_inventory(4);
                                conn.p.item.char_inventory(7);
                                conn.p.item.char_inventory(3);
                                conn.p.id_remove_time_use = -1;
                                if (ch) {
                                    Service.send_notice_box(conn, "Nhận được " + it.name + " +" + it.tier + "!");
                                }
                            } else {
                                Service.send_notice_box(conn, "Tối thiểu 5 ngọc!");
                            }
                        }
                    }
                    break;
                }
                case 116: {
                    if (conn.p.myclan != null && conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        conn.p.myclan.remove_all_mem();
                        conn.p.myclan.remove_mem(conn.p.name);
                        conn.p.myclan = null;
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        MapService.send_in4_other_char(conn.p.map, conn.p, conn.p);
                        Service.send_char_main_in4(conn.p);
                        Service.send_notice_box(conn, "Hủy bang thành công");
                    }
                    break;
                }
                case 117: {
                    if (conn.p.myclan != null) {
                        conn.p.myclan.remove_mem(conn.p.name);
                        conn.p.myclan = null;
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        MapService.send_in4_other_char(conn.p.map, conn.p, conn.p);
                        Service.send_char_main_in4(conn.p);
                        Service.send_notice_box(conn, "Rời bang thành công");
                    }
                    break;
                }
                case 118: {
                    if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        if ((Clan.vang_upgrade[1] * conn.p.myclan.level) > conn.p.myclan.get_vang()) {
                            Service.send_notice_box(conn, "Không đủ vàng để thực hiện");
                            return;
                        }
                        if ((Clan.ngoc_upgrade[1] * conn.p.myclan.level) > conn.p.myclan.get_ngoc()) {
                            Service.send_notice_box(conn, "Không đủ ngọc để thực hiện");
                            return;
                        }
                        conn.p.myclan.update_vang(-Clan.vang_upgrade[1] * conn.p.myclan.level);
                        conn.p.myclan.update_ngoc(-Clan.ngoc_upgrade[1] * conn.p.myclan.level);
                        conn.p.myclan.level++;
                        conn.p.myclan.exp = 0;
                        if (conn.p.myclan.max_mem < 45 && conn.p.myclan.level % 5 == 0) {
                            conn.p.myclan.max_mem += 5;
                        }
                        Service.send_notice_box(conn, "Nâng bang lên cấp " + conn.p.myclan.level + " thành công");
                    }
                    break;
                }
                /*case 119: {
                    if (conn.p.party == null || conn.p.party.leader != conn.p) {  // Kiểm tra trưởng nhóm
                        Service.send_notice_box(conn, "Bạn cần phải là trưởng nhóm để vào phó bản!");
                        return;
                    }

                    Party party = conn.p.party;  // Lấy thông tin nhóm
                    List<Player> partyMembers = party.get_mems();  // Danh sách thành viên trong nhóm

                    // Kiểm tra tài nguyên (ngọc) của tất cả thành viên
                    for (Player member : partyMembers) {
                        if (member.get_ngoc() < 30) {
                            Service.send_notice_box(member.conn, member.name + ", bạn không đủ ngọc để tham gia!");
                            return;
                        }
                    }

                    // Trừ ngọc và đưa tất cả thành viên vào phó bản
                    Dungeon d = DungeonManager.get_list(conn.p.name);  // Kiểm tra phó bản đã tồn tại hay chưa
                    if (d == null) {
                        try {
                            d = new Dungeon();  // Tạo phó bản mới
                        } catch (IOException e) {
                            e.printStackTrace();
                            Service.send_notice_box(conn, "Lỗi, hãy thử lại sau!");
                            return;
                        }

                        // Trừ ngọc cho tất cả thành viên và di chuyển họ vào phó bản
                        for (Player member : partyMembers) {
                            member.update_ngoc(-30);  // Trừ ngọc
                            MapService.leave(member.map, member);
                            member.map = d.template;
                            member.x = 584;
                            member.y = 672;
                            //d.template.players.add(conn.p);
                           // d.template.players.add(member); // Thêm tất cả thành viên vào danh sách players
                            MapService.enter(d.template, member);

                        }

                        // Cấu hình phó bản và thêm vào DungeonManager
                        d.name_party = conn.p.name;
                        d.setMode(0);

                        DungeonManager.add_list(d);

                        // Gửi thông tin phó bản đến tất cả thành viên
                        for (Player member : partyMembers) {
                           // d.template.players.add(member);
                            d.send_map_data(member);
                        }
                    } else {
                        // Nếu phó bản đã tồn tại, chỉ cần di chuyển các thành viên vào đó
                        for (Player member : partyMembers) {
                            MapService.leave(member.map, member);
                            member.map = d.template;
                           // d.template.players.add(member);
                            MapService.enter(d.template, member);
                            d.send_map_data(member);
                        }
                    }
                    break;
                }*/

                case 119: {
                    // Nếu người chơi có nhóm
                    if (conn.p.party != null) {
                        if (conn.p.party.leader != conn.p) { // Kiểm tra nếu không phải trưởng nhóm
                            Service.send_notice_box(conn, "Chỉ trưởng nhóm mới có thể vào phó bản!");
                            return;
                        }

                        Party party = conn.p.party;  // Lấy thông tin nhóm
                        List<Player> partyMembers = party.get_mems();  // Danh sách thành viên trong nhóm

                        // Kiểm tra tài nguyên (ngọc) và point_active của tất cả thành viên
                        for (Player member : partyMembers) {
                            if (member.get_ngoc() < 30) {
                                // Gửi thông báo cho thành viên không đủ ngọc
                                Service.send_notice_box(member.conn, member.name + ", bạn không đủ ngọc để tham gia!");
                                // Gửi thông báo đến trưởng nhóm
                                Service.send_notice_box(conn, "Thành viên " + member.name + " không đủ ngọc để tham gia!");
                                return;
                            }
                            if (member.point_active[0] <= 0) {
                                // Gửi thông báo cho thành viên không đủ point_active
                                Service.send_notice_box(member.conn, member.name + ", bạn không đủ điểm hoạt động để tham gia!");
                                // Gửi thông báo đến trưởng nhóm
                                Service.send_notice_box(conn, "Thành viên " + member.name + " không đủ điểm hoạt động để tham gia!");
                                return;
                            }
                        }

                        // Xử lý logic cho cả nhóm
                        Dungeon d = DungeonManager.get_list(conn.p.party.getLeader().name);  // Kiểm tra phó bản đã tồn tại hay chưa
                        if (d == null) {
                            try {
                                d = new Dungeon();  // Tạo phó bản mới
                            } catch (IOException e) {
                                e.printStackTrace();
                                Service.send_notice_box(conn, "Lỗi, hãy thử lại sau!");
                                return;
                            }

                            for (Player member : partyMembers) {
                                member.update_ngoc(-30);  // Trừ ngọc
                                member.point_active[0]--; // Trừ điểm hoạt động

                                // Cập nhật nhiệm vụ Tinh Tú nếu đang trong trạng thái hoàn thành
                                if (member.nv_tinh_tu[0] == 12 && member.nv_tinh_tu[1] < member.nv_tinh_tu[2]) {
                                    member.nv_tinh_tu[1]++;
                                }
                                if (member.nv_tinh_tu[0] == 13 && member.nv_tinh_tu[1] < member.nv_tinh_tu[2]) {
                                    member.nv_tinh_tu[1]++;
                                }

                                // Di chuyển thành viên vào phó bản
                                MapService.leave(member.map, member);
                                member.map = d.template;
                                member.x = 584;
                                member.y = 672;
                                MapService.enter(d.template, member);
                            }

                            d.name_party = conn.p.name;
                            d.setMode(0);
                            DungeonManager.add_list(d);

                            for (Player member : partyMembers) {
                                d.send_map_data(member);
                            }
                        } else {
                            for (Player member : partyMembers) {
                                MapService.leave(member.map, member);
                                member.map = d.template;
                                MapService.enter(d.template, member);
                                d.send_map_data(member);
                            }
                        }
                    } else { // Nếu người chơi không có nhóm
                        if (conn.p.point_active[0] != 10) {
                            if (conn.p.get_ngoc() < 30) {
                                Service.send_notice_box(conn, "Bạn không đủ ngọc để tham gia!");
                                return;
                            }
                            if (conn.p.point_active[0] <= 0) {
                                Service.send_notice_box(conn, "Bạn không đủ điểm hoạt động để tham gia!");
                                return;
                            }
                            conn.p.update_ngoc(-30);
                            conn.p.point_active[0]--;
                            conn.p.item.char_chest(5);
                        }

                        Dungeon d = DungeonManager.get_list(conn.p.name);
                        if (d == null) {
                            try {
                                d = new Dungeon();
                            } catch (IOException e) {
                                e.printStackTrace();
                                Service.send_notice_box(conn, "Lỗi, hãy thử lại sau!");
                                return;
                            }

                            if (conn.p.point_active[0] <= 0 && !(conn.ac_admin < 3)) {
                                Service.send_notice_box(conn, "Hãy quay lại vào ngày hôm sau!");
                                return;
                            } else {
                                d.name_party = conn.p.name;
                                d.setMode(0);

                                MapService.leave(conn.p.map, conn.p);
                                conn.p.map = d.template;
                                conn.p.x = 584;
                                conn.p.y = 672;
                                MapService.enter(conn.p.map, conn.p);
                                d.send_map_data(conn.p);

                                DungeonManager.add_list(d);

                                if (conn.p.nv_tinh_tu[0] == 12 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
                                    conn.p.nv_tinh_tu[1]++;
                                }
                                if (conn.p.nv_tinh_tu[0] == 13 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
                                    conn.p.nv_tinh_tu[1]++;
                                }
                            }
                        } else {
                            MapService.leave(conn.p.map, conn.p);
                            conn.p.map = d.template;
                            MapService.enter(conn.p.map, conn.p);
                            d.send_map_data(conn.p);
                            d.send_mob_move_when_exit(conn.p);
                        }
                    }
                    break;
                }

                case 120: {

                    break;
                }

                case -10: {
                    if (conn.p.chon_item3_index != -1) { // Kiểm tra xem có mục nào được chọn không
                        Item3 it = conn.p.item.bag3[conn.p.chon_item3_index];
                        if (it != null) {
                            it.islock = false; // Mở khóa trang bị
                            it.name = ItemTemplate3.item.get(it.id).getName() + ""; // Cập nhật tên trang bị
                            it.UpdateName(); // Cập nhật lại tên trong túi đồ
                            conn.p.update_ngoc(-50000);
                            conn.p.item.remove(4, 330, 1);
                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.item.char_inventory(3);
                            Service.send_notice_box(conn, "Đã mở khóa " + it.name + "");
                            conn.p.chon_item3_index = -1; // Đặt lại chỉ số đã chọn
                        }
                    }
                    break;
                }

                // thap
                case -38: {

                    Leothap d = LeothapManager.get_list(conn.p.name);
                    if (d == null) {
                        try {
                            d = new Leothap();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (d != null) {

                            d.name_party = conn.p.name;
                            //
                            MapService.leave(conn.p.map, conn.p);
                            conn.p.map = d.template;
                            conn.p.x = 550;
                            conn.p.y = 400;
                            MapService.enter(conn.p.map, conn.p);
                            //
                            LeothapManager.add_list(d);
                            d.SetDie(d.template, conn.p);
                            Service.send_char_main_in4(conn.p);
                        } else {
                            Service.send_notice_box(conn, "Lỗi, hãy thử lại sau!");
                        }
                    } else {
                        MapService.leave(conn.p.map, conn.p);
                        conn.p.map = d.template;
                        MapService.enter(conn.p.map, conn.p);
                    }
                    break;
                }

                case 70: {
                    if (conn.p.get_ngoc() < 20000) {
                        Service.send_notice_box(conn, "20k ngọc còn không có thì không xứng đáng làm anh hùng!");
                        return;
                    }
                    Service.send_box_input_text(conn, 23, "Bang hội", new String[]{"Tên (4-20 ký tự) :", "Tên viết tắt (3 ký tự) :"});
//                    Message m12 = new Message(-53);
//                    m12.writer().writeShort(0);
//                    String[] txt = new String[]{"Tên (4-20 ký tự) :", "Tên viết tắt (3 ký tự) :"};
//                    m12.writer().writeByte(txt.length);
//                    for (String string : txt) {
//                        m12.writer().writeUTF(string);
//                    }
//                    m12.writer().writeUTF("Đăng ký bang");
//                    m12.writer().writeUTF("Bang hội");
//                    conn.addmsg(m12);
//                    m12.cleanup();
                    break;
                }
                case 121: {
                    if (conn.p.get_ngoc() < 1000) {
                        Service.send_notice_box(conn, "Không đủ 1000 ngọc!");
                        return;
                    }
                    conn.p.update_ngoc(-1000);
                    conn.p.item.char_inventory(5);
                    EffTemplate tempp = conn.p.get_EffDefault(-126);
                    if (tempp != null) {
                        long time_extra = (tempp.time - System.currentTimeMillis()) + (1000 * 60 * 60 * 2);
                        if (time_extra > (1000 * 60 * 60 * 24 * 3)) {
                            time_extra = 1000 * 60 * 60 * 24 * 3;
                        }
                        conn.p.add_EffDefault(-126, 99, (int) time_extra);
                    } else {
                        conn.p.add_EffDefault(-126, 99, (1000 * 60 * 60 * 2));
                    }
                    Service.send_notice_box(conn, "Đăng ký thành công");
                    break;
                }
                case 122: {
//                    if((conn.p.item.bag3[conn.p.item_replace].id >= 4587 && conn.p.item.bag3[conn.p.item_replace].id<= 4590) || 
//                            (conn.p.item.bag3[conn.p.item_replace2].id >= 4587 && conn.p.item.bag3[conn.p.item_replace2].id<= 4590))
//                    {
//                        Service.send_notice_box(conn, "Trang bị không phù hợp!");
//                        return;a
//                    }
                    int fee = 100 * conn.p.item.bag3[conn.p.item_replace].tier;
                    if (conn.p.get_ngoc() < fee) {
                        Service.send_notice_box(conn, "Không đủ " + fee + " ngọc!");
                        return;
                    }
                    conn.p.item.bag3[conn.p.item_replace2].tier = conn.p.item.bag3[conn.p.item_replace].tier;
                    conn.p.item.bag3[conn.p.item_replace].tier = 0;
//                    if (conn.p.item.bag3[conn.p.item_replace2].type == 5
//                            && conn.p.item.bag3[conn.p.item_replace2].tier >= 9) {
//                        for (Option op_ : conn.p.item.bag3[conn.p.item_replace2].op) {
//                            if (op_.id == 37 && op_.getParam(conn.p.item.bag3[conn.p.item_replace2].tier) > 1) {
//                                op_.setParam(op_.getParam(conn.p.item.bag3[conn.p.item_replace2].tier));
//                            }
//                        }
//                    }
                    conn.p.update_ngoc(-fee);
                    conn.p.item.char_inventory(3);
                    Service.send_notice_box(conn, "Chuyển hóa thành công!");
                    //
                    Message m3 = new Message(73);
                    m3.writer().writeByte(0);
                    m3.writer().writeShort(conn.p.item_replace2);
                    m3.writer().writeByte(0);
                    conn.addmsg(m3);
                    m3.cleanup();
                    //
                    m3 = new Message(73);
                    m3.writer().writeByte(0);
                    m3.writer().writeShort(conn.p.item_replace);
                    m3.writer().writeByte(1);
                    conn.addmsg(m3);
                    m3.cleanup();
                    //
                    break;
                }
                case 123: {
                    int fee = 100 * conn.p.item.bag3[conn.p.item_replace].tier;
                    if (conn.p.get_ngoc() < fee) {
                        Service.send_notice_box(conn, "Không đủ " + fee + " ngọc!");
                        return;
                    }
                    Item3 pr = conn.p.item.bag3[conn.p.item_replace];
                    conn.p.item.bag3[conn.p.item_replace2].tier = conn.p.item.bag3[conn.p.item_replace].tier;
                    conn.p.item.remove(3, conn.p.item_replace, 1);

                    // Nhân đôi tham số của mỗi tùy chọn trong item_replace2
                    for (Option op_ : conn.p.item.bag3[conn.p.item_replace2].op) {
                        op_.setParam(op_.getParam(0) * 2);
                    }

                    conn.p.item.bag3[conn.p.item_replace2].isHopdo = 1; // Đánh dấu trang bị đã chuyển hóa (bị khóa)

                    conn.p.update_ngoc(-fee);
                    conn.p.item.char_inventory(3);
                    Service.send_notice_box(conn, "Chuyển hóa thành công!");

                    Message m3 = new Message(73);
                    m3.writer().writeByte(0);
                    m3.writer().writeShort(conn.p.item_replace2);
                    m3.writer().writeByte(0);
                    conn.addmsg(m3);
                    m3.cleanup();

                    m3 = new Message(73);
                    m3.writer().writeByte(0);
                    m3.writer().writeShort(conn.p.item_replace);
                    m3.writer().writeByte(1);
                    conn.addmsg(m3);
                    m3.cleanup();

                    break;
                }

                case 124: {
                    conn.p.rest_skill_point();

                    conn.p.item.remove(4, 7, 1);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Tẩy điểm kỹ năng thành công");
                    break;
                }
                case 125: {
                    conn.p.rest_potential_point();

                    conn.p.item.remove(4, 6, 1);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Tẩy điểm tiềm năng thành công");
                    break;
                }
                case 126: {
                    if (conn.p.id_buffer_126 != -1) {
                        Item3 temp3 = conn.p.item.bag3[conn.p.id_buffer_126];
                        temp3.islock = true;
                        switch (temp3.type) {
                            case 0: // coat
                            case 1: // pant
                            case 2: // crown
                            case 3: // grove
                            case 4: // ring
                            case 5: // chain
                            case 6: // shoes
                            case 7: // wing
                            case 15:
                            case 8:
                            case 9:
                            case 10:
                            case 16:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 11: { // weapon
                                conn.p.player_wear(conn, temp3, conn.p.id_buffer_126, conn.p.id_index_126);
                                break;
                            }
                            default: {
                                Service.send_notice_nobox_white(conn, "Ấn 2 lần mới có thể sử dụng");
                                break;
                            }
                        }
                    }
                    conn.p.id_buffer_126 = -1;
                    conn.p.id_index_126 = -1;
                    break;
                }

                case 89: {
                    if (conn.p.get_ngoc() < 5000) {
                        Service.send_notice_box(conn, "Cần 5.000 Ngọc");
                        return;
                    }
                    if (conn.p.get_chuyensinh() < 20) {
                        Service.send_notice_box(conn, "Bạn Không đủ 20 điểm chuyển sinh!");
                        break;

                    } else {
                        int i = -20;
                        conn.p.update_ngoc(-5_000);
                        conn.p.update_chuyensinh(i);
                        //conn.p.chuyensinh = (short) (conn.p.get_chuyensinh()-20);
                        conn.p.level = 1;
                        conn.p.exp = 0;
                        conn.p.tiemnang = (short) (5 + Level.get_tiemnang_by_level(conn.p.level - 1));
                        conn.p.kynang = (short) (1 + Level.get_kynang_by_level(conn.p.level - 1));
                        conn.p.point1 = (short) (4 + conn.p.level);
                        conn.p.point2 = (short) (4 + conn.p.level);
                        conn.p.point3 = (short) (4 + conn.p.level);
                        conn.p.point4 = (short) (4 + conn.p.level);
                        conn.p.skill_point = new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

                        short iditem = (short) Util.random(0, 4675);
                        Item3 itbag = new Item3();
                        itbag.id = iditem;
                        itbag.name = ItemTemplate3.item.get(iditem).getName();
                        itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                        itbag.clazz = conn.p.clazz;
                        itbag.type = ItemTemplate3.item.get(iditem).getType();
                        itbag.level = 1;
                        itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                        itbag.op = new ArrayList<>();
                        itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                        itbag.color = 5;
                        itbag.part = ItemTemplate3.item.get(iditem).getPart();
                        itbag.op = ItemTemplate3.item.get(iditem).getOp();
                        itbag.tier = 0;
                        itbag.islock = false;
                        itbag.time_use = 0;

                        conn.p.item.add_item_bag3(itbag);
                        conn.p.item.char_inventory(3);

                        List<box_item_template> ids = new ArrayList<>();
                        ids.add(new box_item_template(iditem, (short) 1, (byte) 3));

                        Service.send_notice_box(conn, "Đổi Thành Công\n Nhận Được :" + ItemTemplate3.item.get(iditem).getName());
                        Manager.gI().chatKTGprocess("Chúc Mừng  " + conn.p.name + "  Nhận được  " + ItemTemplate3.item.get(iditem).getName());
                        conn.p.update_Exp(1, false);

                        Service.send_char_main_in4(conn.p);
                        Player p = conn.p;

                    }
                    break;
                }
                case 127: {
                    if (conn.p.get_ngoc() > 10000) {
                        Map map = conn.p.map;
                        Player p = (Player) conn.p;
                        type = 0;
                        ai.khu2.khu2_a(map, conn);
                        conn.p.update_ngoc(-10000);
                    } else {
                        Service.send_notice_box(conn, "Không đủ 10k ngọc");
                    }
                    break;

                }
                case (byte) 128: {
                    int plotIndex = -1; // Xác định ô đất cần mở khóa
                    List<Farm.MobFarm> playerMobs = Farm.playerMobFarms.get(conn.p.index);

                    // Tìm ô đất "Đất Hoang"
                    if (playerMobs != null) {
                        for (int i = 0; i < playerMobs.size(); i++) {
                            Farm.MobFarm mob = playerMobs.get(i);
                            if ("Đất Hoang".equals(mob.nameOwner)) {
                                plotIndex = i;
                                break;
                            }
                        }
                    }

                    if (plotIndex == -1) {
                        Service.send_notice_box(conn, "Không tìm thấy ô đất khả dụng để mua.");
                        return;
                    }

                    Farm.MobFarm mobToBuy = playerMobs.get(plotIndex);

                    // Tính giá mở khóa
                    long price = 5_000_000; // Giá gốc
                    for (int i = 0; i < plotIndex; i++) {
                        price *= 2; // Nhân đôi giá cho mỗi ô đất đã mở khóa
                    }
                    // Kiểm tra vàng
                    if (conn.p.get_vang() < price) {
                        Service.send_notice_box(conn, "Bạn không đủ vàng để mở khóa ô đất. Cần " + price + " vàng.");
                        return;
                    }

                    // Trừ vàng và cập nhật trạng thái ô đất
                    conn.p.update_vang(-price);
                    mobToBuy.nameOwner = " ";
                    mobToBuy.name = "Ô Đất";
                    mobToBuy.currentEff = 221;
                    Farm.remob(conn, mobToBuy.getId());

                    // Mở khóa ô đất tiếp theo
                    boolean allPlotsUnlocked = true; // Kiểm tra tất cả ô đất
                    for (Farm.MobFarm mob : playerMobs) {
                        if ("Hidden".equals(mob.nameOwner)) {
                            mob.nameOwner = "Đất Hoang";
                            mob.currentEff = 220;
                            mob.SendMob(conn.p);
                            allPlotsUnlocked = false; // Vẫn còn ô đất chưa mở khóa
                            break;
                        }
                    }

                    // Nếu tất cả ô đất đã được mở khóa
                    if (allPlotsUnlocked) {
                        boolean allOwned = true;
                        for (Farm.MobFarm mob : playerMobs) {
                            if (!" ".equals(mob.nameOwner)) {
                                allOwned = false;
                                break;
                            }
                        }
                        if (allOwned) {
                            Farm.MobChicken(conn.p); // Gọi mobchicken nếu đã mở khóa toàn bộ ô đất
                        }
                    }

                    Farm.SaveData(conn.p);
                    Service.send_notice_box(conn, "Bạn đã mở khóa ô đất thành công với giá " + price + " vàng.");
                    break;
                }

                case (byte) 130: { // Xử lý xác nhận trồng cây
                    // Lấy thông tin ô đất từ `conn.p`
                    int idmob = conn.p.chon_odat; // Cần lưu ID ô đất đã chọn trước đó
                    Farm.MobFarm mobFarm = Farm.getMob(idmob, conn.p.index);
                    if (mobFarm == null) {
                        Service.send_notice_box(conn, "Không tìm thấy ô đất.");
                        return;
                    }

                    HashMap<Integer, Integer> cropPrices = new HashMap<>();
                    cropPrices.put(0, 5_000); // Cây Lúa Mạch
                    cropPrices.put(1, 15_000); // Cây Ngô
                    cropPrices.put(2, 300); // Hoa TuLip
                    cropPrices.put(3, 5_000); // Cà tím
                    cropPrices.put(4, 25_000_000); // bí đỏ
                    cropPrices.put(5, 7500); // Đào Tiên
                    int price = cropPrices.get(conn.p.chon_cay);

                    String loaitiencay = conn.p.loaitiencay; // Lấy loại tiền tệ đã lưu
                    if (loaitiencay.equals("vàng") && conn.p.get_vang() < price) {
                        Service.send_notice_box(conn, "Không đủ " + price + " vàng để trồng cây.");
                        return;
                    } else if (loaitiencay.equals("ngọc") && conn.p.get_ngoc() < price) {
                        Service.send_notice_box(conn, "Không đủ " + price + " ngọc để trồng cây.");
                        return;
                    }
                    switch (conn.p.chon_cay) { // `selectedCropIndex` lưu loại cây đã chọn
                        case 0:
                            mobFarm.name = "Cây Lúa Mạch";
                            mobFarm.timeUpdate = System.currentTimeMillis();
                            mobFarm.currentEff = 223;
                            break;
                        case 1:
                            mobFarm.name = "Cây Ngô";
                            mobFarm.timeUpdate = System.currentTimeMillis();
                            mobFarm.currentEff = 225;
                            break;
                        case 2:
                            mobFarm.name = "Cây Hoa TuLip";
                            mobFarm.timeUpdate = System.currentTimeMillis();
                            mobFarm.currentEff = 227;
                            break;
                        case 3:
                            mobFarm.name = "Cây Cà Tím";
                            mobFarm.timeUpdate = System.currentTimeMillis();
                            mobFarm.currentEff = 229;
                            break;
                        case 4:
                            mobFarm.name = "Cây Bí Đỏ";
                            mobFarm.timeUpdate = System.currentTimeMillis();
                            mobFarm.currentEff = 231;
                            break;
                        case 5:
                            mobFarm.name = "Cây Đào Tiên";
                            mobFarm.timeUpdate = System.currentTimeMillis();
                            mobFarm.currentEff = 233;
                            break;
                        default:
                            Service.send_notice_box(conn, "Loại cây không hợp lệ.");
                            return;
                    }

                    switch (loaitiencay) {
                        case "vàng":
                            conn.p.update_vang(-price);
                            break;
                        case "ngọc":
                            conn.p.update_ngoc(-price);
                            break;
                    }
                    // Lưu dữ liệu và cập nhật giao diện
                    Farm.remob(conn, idmob);
                    Farm.SaveData(conn.p);
                    Service.send_notice_box(conn, "Bạn đã trồng cây thành công.");
                    break;
                }

                case (byte) 131: { // Nhận thưởng từ số lượng trứng
    int idmob = conn.p.chon_odat;
    Farm.MobFarm mobFarm = Farm.getMob(idmob, conn.p.index);

    if (!"Trứng".equals(mobFarm.chicken)) {
        Service.send_notice_box(conn, "Đây không phải là ổ trứng.");
        return;
    }

    if (mobFarm.eggCount <= 0) {
        Service.send_notice_box(conn, "Không có trứng để nhận thưởng.");
        return;
    }

    boolean hasHighLevelChicken = false;
    List<Farm.MobFarm> playerMobs1 = Farm.playerMobFarms.get(conn.p.index);
    if (playerMobs1 != null) {
        for (Farm.MobFarm mob : playerMobs1) {
            if ("Gà".equals(mob.chicken) && mob.level >= 5) {
                hasHighLevelChicken = true;
                break;
            }
        }
    }

    if (hasHighLevelChicken) {
        int reward = 0;
        boolean isGoldReward = false; // Biến để kiểm tra loại phần thưởng
        for (Farm.MobFarm mob : playerMobs1) {
            if ("Gà".equals(mob.chicken)) {
                if (mob.level >= 5 && mob.level < 15) {
                    reward += mobFarm.eggCount * 500000;
                    isGoldReward = true; // Phần thưởng là vàng
                } else if (mob.level >= 15 && mob.level < 20) {
                    reward += mobFarm.eggCount * 1000;
                } else if (mob.level >= 20 && mob.level < 25) {
                    reward += mobFarm.eggCount * 2000;
                } else if (mob.level >= 25 && mob.level < 30) {
                    reward += mobFarm.eggCount * 4000;
                } else if (mob.level >= 30 && mob.level < 35) {
                    reward += mobFarm.eggCount * 6000;
                } else if (mob.level >= 35 && mob.level < 40) {
                    reward += mobFarm.eggCount * 8000;
                } else if (mob.level >= 40 && mob.level < 45) {
                    reward += mobFarm.eggCount * 10000;
                } else if (mob.level >= 45 && mob.level < 50) {
                    reward += mobFarm.eggCount * 12000;
                } else if (mob.level >= 50 && mob.level < 100) {
                    reward += mobFarm.eggCount * 15000;
                } else if (mob.level >= 100 && mob.level < 149) {
                    reward += mobFarm.eggCount * 25000;
                } else if (mob.level >= 149 && mob.level < 150) {
                    reward += mobFarm.eggCount * 50000;
                } else if (mob.level >= 150) {
                    reward += mobFarm.eggCount * 100000;
                }
            }
        }

        if (reward > 0) {
            if (isGoldReward) { // Kiểm tra loại phần thưởng
                conn.p.update_vang(reward);
                Service.send_notice_box(conn, "Bạn đã nhận được " + reward + " vàng từ " + mobFarm.eggCount + " trứng.");
            } else {
                conn.p.update_ngoc(reward);
                Service.send_notice_box(conn, "Bạn đã nhận được " + reward + " ngọc từ " + mobFarm.eggCount + " trứng.");
            }
        }

    } else {
        Service.send_notice_box(conn, "Bạn không có gà đủ cấp độ để nhận thưởng.");
    }

    mobFarm.eggCount = 0;
    Farm.SaveData(conn.p);
    break;
}
                case (byte) 200: {
                    int idmob = conn.p.chon_odat;
                    Farm.MobFarm mobFarm = Farm.getMob(idmob, conn.p.index);
                    if (mobFarm == null) {
                        Service.send_notice_box(conn, "Không tìm thấy ô đất.");
                        return;
                    }

                    if (conn.p.index != mobFarm.Owner.index) {
                        Service.send_notice_box(conn, "Bạn không sở hữu ô đất này.");
                        return;
                    }

                    long vang = 0;
                    int ngoc = 0;
                    int chuyencan = 0;

                    if (mobFarm.level < 5) {
                        vang = 25_000_000;
                    } else if (mobFarm.level >= 5 && mobFarm.level < 15) {
                        vang = 50_000_000;
                    } else if (mobFarm.level >= 15 && mobFarm.level < 20) {
                        vang = 50_000_000;
                        ngoc = 50_000;
                        chuyencan = 1;
                    } else if (mobFarm.level >= 20 && mobFarm.level < 25) {
                        vang = 100_000_000;
                        ngoc = 100_000;
                        chuyencan = 2;
                    } else if (mobFarm.level >= 25 && mobFarm.level < 30) {
                        vang = 150_000_000;
                        ngoc = 150_000;
                        chuyencan = 3;
                    } else if (mobFarm.level >= 30 && mobFarm.level < 35) {
                        vang = 200_000_000;
                        ngoc = 200_000;
                        chuyencan = 4;
                    } else if (mobFarm.level >= 35 && mobFarm.level < 40) {
                        vang = 250_000_000;
                        ngoc = 250_000;
                        chuyencan = 5;
                    } else if (mobFarm.level >= 40 && mobFarm.level < 45) {
                        vang = 300_000_000;
                        ngoc = 300_000;
                        chuyencan = 6;
                    } else if (mobFarm.level >= 45 && mobFarm.level < 50) {
                        vang = 350_000_000;
                        ngoc = 350_000;
                        chuyencan = 7;
                    } else if (mobFarm.level >= 50 && mobFarm.level < 100) {
                        vang = 500_000_000;
                        ngoc = 500_000;
                        chuyencan = 10;
                    } else if (mobFarm.level >= 100 && mobFarm.level < 150) {
                        vang = 1_000_000_000;
                        ngoc = 1_000_000;
                        chuyencan = 15;
                    } else {
                        Service.send_notice_box(conn, "Không thể nâng cấp gà.");
                        return;
                    }

                    // if (conn.p.get_vang() < price || conn.p.get_ngoc() < ngoc || conn.p.chuyencan < chuyencan) {
                    // Service.send_notice_box(conn, "Bạn không đủ tài nguyên để nâng cấp gà.");
                    // return;
                    // }
                    List<String> messages = new ArrayList<>();
                    if (conn.p.get_vang() < vang) {
                        messages.add("Bạn không đủ vàng để nâng cấp gà. Cần thêm " + (vang - conn.p.get_vang()) + " vàng.");
                    }
                    if (conn.p.get_ngoc() < ngoc) {
                        messages.add("Bạn không đủ ngọc để nâng cấp gà. Cần thêm " + (ngoc - conn.p.get_ngoc()) + " ngọc.");
                    }
                    if (conn.p.chuyencan < chuyencan) {
                        messages.add("Bạn không đủ điểm chuyên cần để nâng cấp gà. Cần thêm " + (chuyencan - conn.p.chuyencan) + " điểm chuyên cần.");
                    }

                    if (!messages.isEmpty()) {
                        Service.send_notice_box(conn, String.join("\n", messages));
                        return;
                    }

                    if (mobFarm.level == 4) {
                        mobFarm.currentEff = 236;
                        mobFarm.nameOwner = "Gà Mái";
                    } else if (mobFarm.level == 14) {
                        mobFarm.currentEff = 237;
                        mobFarm.nameOwner = "Phượng hoàng";
                    }

                    conn.p.update_vang(-vang);
                    conn.p.update_ngoc(-ngoc);
                    conn.p.chuyencan -= chuyencan;
                    mobFarm.level += 1;
                    mobFarm.hp = 1;

                    List<Farm.MobFarm> mob_player = Farm.playerMobFarms.get(conn.p.index);
                    if (mob_player != null) {
                        for (Farm.MobFarm mob : mob_player) {
                            if ("Trứng".equals(mob.chicken)) {
                                if (mobFarm.level == 5) {
                                    mob.currentEff = 239;
                                } else if (mobFarm.level == 15) {
                                    mob.currentEff = 240;
                                    mob.eggCount = 0;
                                    Service.send_notice_box(conn, "Trứng trong ổ đã được xóa sạch do nâng cấp lên Phượng Hoàng");
                                }
                                Farm.remob(conn, mob.getId());
                                break;
                            }
                        }
                    }

                    Farm.remob(conn, idmob);
                    Farm.SaveData(conn.p);
                    Service.send_notice_box(conn, "Bạn đã nâng cấp thành công");
                    break;
                }

                case (byte) 201: { // Xử lý cho gà ăn
                    // Lấy thông tin mobFarm từ conn.p.chon_mob
                    MobFarm mobFarm = Farm.getMob(conn.p.chon_odat, conn.p.index);
                    if (mobFarm == null) {
                        Service.send_notice_box(conn, "Không tìm thấy ô đất.");
                        return;
                    }

                    // Kiểm tra xem người chơi có phải chủ sở hữu
                    if (conn.p.index != mobFarm.Owner.index) {
                        Service.send_notice_box(conn, "Bạn không sở hữu ô đất này.");
                        return;
                    }

                    // Kiểm tra loại cám và trừ vàng tương ứng
                    int vang = 0;
                    int ngoc = 0;
                    int coin = 0;
                    int hp = 0; // Biến tạm để lưu lượng HP cần cộng thêm
                    switch (conn.p.chon_cam) {
                        case 0:
                            vang = 5_000_000;
                            hp = 1; // Thóc cộng 1 HP
                            break;
                        case 1:
                            ngoc = 10_000;
                            hp = 2; // Cám gà cộng 2 HP
                            break;
                        case 2:
                            coin = 5000;
                            hp = 3; // Cám tiên cộng 3 HP
                            break;
                        case 3:
                            coin = 50_000;
                            hp = 10; // Cám tiên cộng 3 HP
                            break;
                        default:
                            Service.send_notice_box(conn, "Thức ăn không hợp lệ.");
                            return;
                    }

                    if (conn.p.get_vang() < vang) {
                        Service.send_notice_box(conn, "Không đủ vàng");
                        return;
                    }
                    if (conn.p.get_ngoc() < ngoc) {
                        Service.send_notice_box(conn, "Không đủ ngọc");
                        return;
                    }
                    if (conn.p.get_coin() < coin) {
                        Service.send_notice_box(conn, "Không đủ coin");
                        return;
                    }
                    conn.p.update_vang(-vang);
                    conn.p.update_ngoc(-ngoc);
                    conn.p.update_coin(-coin);
                    // Cộng HP cho gà, đảm bảo không vượt quá giới hạn 10
                    mobFarm.hp += hp;
                    if (mobFarm.hp > 10) {
                        mobFarm.hp = 10;
                    }
                    mobFarm.lastFeedTime = System.currentTimeMillis(); // Cập nhật thời gian cho ăn cuối cùng

                    // Lưu dữ liệu và gửi thông báo
                    Farm.SaveData(conn.p);
                    Service.send_notice_box(conn, "Bạn đã cho gà ăn thành công.");

                    break;
                }
                
                case (byte) 202:{
                Event_5.add_naubanh(conn.p.name, 0);
                Service.send_notice_box(conn, "Đăng ký thành công, có thể góp nguyên liệu rồi");
                break;
                 }
                case 88: {
                    if (conn.ac_admin < 10) {
                        Service.send_notice_box(conn, "Bạn chưa đủ quyền để thực hiện!");
                        return;
                    }
                    ServerManager.gI().close();
                    System.out.println("Close server is processing....");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SaveData.process();
                            for (int k = Session.client_entrys.size() - 1; k >= 0; k--) {

                                try {
                                    Session.client_entrys.get(k).p = null;
                                    Session.client_entrys.get(k).close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            Manager.gI().close();
                        }
                    }).start();
                    break;
                }

            }
        }
    }

}
