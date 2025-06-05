package map;

import event.EventManager;
import event.Event_1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import client.Player;
import core.Manager;
import core.Service;
import core.Util;
import event.Event_5;
import io.Message;
import io.Session;
import template.EffTemplate;
import template.ItemTemplate3;
import template.ItemTemplate4;
import template.ItemTemplate7;
import template.MainObject;
import template.Medal_Material;
import template.Option;
import template.*;

public class LeaveItemMap {

    public static List<Short> item0x = new ArrayList<>();
    public static List<Short> item1x = new ArrayList<>();
    public static List<Short> item2x = new ArrayList<>();
    public static List<Short> item3x = new ArrayList<>();
    public static List<Short> item4x = new ArrayList<>();
    public static List<Short> item5x = new ArrayList<>();
    public static List<Short> item6x = new ArrayList<>();
    public static List<Short> item7x = new ArrayList<>();
    public static List<Short> item8x = new ArrayList<>();
    public static List<Short> item9x = new ArrayList<>();
    public static List<Short> item10x = new ArrayList<>();
    public static List<Short> item11x = new ArrayList<>();
    public static List<Short> item12x = new ArrayList<>();
    public static List<Short> item13x = new ArrayList<>();
    public static List<Short> item14x = new ArrayList<>();
    public static List<Short> item15x = new ArrayList<>();

    public static void leave_vang(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            int index_item_map = map.get_item_map_index_able();
            if (index_item_map > -1) {
                //
                map.item_map[index_item_map] = new ItemMap();
                map.item_map[index_item_map].id_item = -1;
                map.item_map[index_item_map].color = 3;
                int vang_drop = Util.random(mob.level * 25, mob.level * 60);
                EffTemplate ef = p.get_EffDefault(52);
                if (ef != null) {
                    vang_drop += (vang_drop * (ef.param / 100)) / 100;
                }
                map.item_map[index_item_map].quantity = vang_drop;
                map.item_map[index_item_map].category = 4;
                map.item_map[index_item_map].idmaster = (short) p.index;
                map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
                map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
                String name = "vàng *" + map.item_map[index_item_map].quantity;
                // add in4 game scr
                Message mi = new Message(19);
                mi.writer().writeByte(4);
                mi.writer().writeShort(mob.index); // index mob die
                mi.writer().writeShort(0); // id icon (0 : vang , 10 : ngọc)
                mi.writer().writeShort(index_item_map); //
                mi.writer().writeUTF(name);
                mi.writer().writeByte(0); // color
                mi.writer().writeShort(p.index); // id player
                MapService.send_msg_player_inside(map, p, mi, true);
                mi.cleanup();
            }
        }
    }

    public static void leave_ngoc(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            int index_item_map = map.get_item_map_index_able();
            if (index_item_map > -1) {
                //
                map.item_map[index_item_map] = new ItemMap();
                map.item_map[index_item_map].id_item = -2;

                map.item_map[index_item_map].color = 3;
                //int ngoc_drop = Util.random(mob.level * 25, mob.level * 60);
                int ngoc_drop = 5;
                EffTemplate ef = p.get_EffDefault(52);
                if (ef != null) {
                    ngoc_drop += (ngoc_drop * (ef.param / 100)) / 100;
                }
                map.item_map[index_item_map].quantity = ngoc_drop;
                map.item_map[index_item_map].category = 4;
                map.item_map[index_item_map].idmaster = (short) p.index;
                map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
                map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 500L;
                String name = "Ngọc" + map.item_map[index_item_map].quantity;
                // add in4 game scr
                Message mi = new Message(19);
                mi.writer().writeByte(4);
                mi.writer().writeShort(mob.index); // index mob die
                mi.writer().writeShort(10); // id icon (0 : vang , 10 : ngọc)
                mi.writer().writeShort(index_item_map); //
                mi.writer().writeUTF(name);
                mi.writer().writeByte(3); // color
                mi.writer().writeShort(p.index); // id player
                MapService.send_msg_player_inside(map, p, mi, true);
                mi.cleanup();
            }
        }
    }

    public static void leave_vang1(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            int index_item_map = map.get_item_map_index_able();
            if (index_item_map > -1) {
                //
                map.item_map[index_item_map] = new ItemMap();
                map.item_map[index_item_map].id_item = -1;
                map.item_map[index_item_map].color = 5;
                int vang_drop = (p.level * 72) * 5;
                EffTemplate ef = p.get_EffDefault(52);
                if (ef != null) {
                    vang_drop += (vang_drop * (ef.param / 100)) / 100;
                }
                map.item_map[index_item_map].quantity = vang_drop;
                map.item_map[index_item_map].category = 4;
                map.item_map[index_item_map].idmaster = (short) p.index;
                map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
                map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 500L;
                String name = "Vàng" + map.item_map[index_item_map].quantity;
                // add in4 game scr
                Message mi = new Message(19);
                mi.writer().writeByte(4);
                mi.writer().writeShort(mob.index); // index mob die
                mi.writer().writeShort(132); // id icon (0 : vang , 10 : ngọc, 32 vàng x2)
                mi.writer().writeShort(index_item_map); //
                mi.writer().writeUTF(name);
                mi.writer().writeByte(5); // color
                mi.writer().writeShort(p.index); // id player
                MapService.send_msg_player_inside(map, p, mi, true);
                mi.cleanup();
            }
        }
    }

    public static void leave_item_3(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short id_item_can_drop = 0;
            // tỉ lệ rớt đồ màu
            byte color_ = 0;
            if (95 > Util.random(0, 200)) {
                color_ = 1;
            } else if (85 > Util.random(0, 275)) {
                color_ = 2;
            } else if (65 > Util.random(0, 350)) {
                color_ = 3;
            } else if (35 > Util.random(0, 500)) {
                color_ = 4;
            }

            if (mob.color_name != 0) {
                color_ = 3;
            }
            if (mob.level >= 1 && mob.level < 10 && item0x.size() > 0) {
                id_item_can_drop = item0x.get(Util.random(0, item0x.size()));
            } else if (mob.level >= 10 && mob.level < 20 && item1x.size() > 0) {
                id_item_can_drop = item1x.get(Util.random(0, item1x.size()));
            } else if (mob.level >= 20 && mob.level < 30 && item2x.size() > 0) {
                id_item_can_drop = item2x.get(Util.random(0, item2x.size()));
            } else if (mob.level >= 30 && mob.level < 40 && item3x.size() > 0) {
                id_item_can_drop = item3x.get(Util.random(0, item3x.size()));
            } else if (mob.level >= 40 && mob.level < 50 && item4x.size() > 0) {
                id_item_can_drop = item4x.get(Util.random(0, item4x.size()));
            } else if (mob.level >= 50 && mob.level < 60 && item5x.size() > 0) {
                id_item_can_drop = item5x.get(Util.random(0, item5x.size()));
            } else if (mob.level >= 60 && mob.level < 70 && item6x.size() > 0) {
                id_item_can_drop = item6x.get(Util.random(0, item6x.size()));
            } else if (mob.level >= 70 && mob.level < 80 && item7x.size() > 0) {
                id_item_can_drop = item7x.get(Util.random(0, item7x.size()));
            } else if (mob.level >= 80 && mob.level < 90 && item8x.size() > 0) {
                id_item_can_drop = item8x.get(Util.random(0, item8x.size()));
            } else if (mob.level >= 90 && mob.level < 100 && item9x.size() > 0) {
                id_item_can_drop = item9x.get(Util.random(0, item9x.size()));
            } else if (mob.level >= 100 && mob.level < 110 && item10x.size() > 0) {
                id_item_can_drop = item10x.get(Util.random(0, item10x.size()));
            } else if (mob.level >= 110 && mob.level < 120 && item11x.size() > 0) {
                id_item_can_drop = item11x.get(Util.random(0, item11x.size()));
            } else if (mob.level >= 120 && mob.level < 130 && item12x.size() > 0) {
                id_item_can_drop = item12x.get(Util.random(0, item12x.size()));
            } else if (mob.level >= 130 && item13x.size() > 0) {
                id_item_can_drop = item13x.get(Util.random(0, item13x.size()));
            }
            String name = ItemTemplate3.item.get(id_item_can_drop).getName();
            short index_real = 0;
            if (id_item_can_drop < 20) {
                for (int i = 0; i < 20; i++) {
                    if (ItemTemplate3.item.get(i).getName().equals(name) && ItemTemplate3.item.get(i).getColor() == color_) {
                        index_real = (short) i;
                        break;
                    }
                }
            } else {
                for (int i = id_item_can_drop - 5; i < id_item_can_drop + 5; i++) {
                    if (ItemTemplate3.item.get(i).getName().equals(name) && ItemTemplate3.item.get(i).getColor() == color_) {
                        index_real = (short) i;
                        break;
                    }
                }
            }
            //
            leave_item_by_type3(map, index_real, color_, p, name, mob.index);
        }
    }

    public static void leave_item_by_type3(Map map, int index_real, int color_, Player p_master, String name, int index)
            throws IOException {
        int index_item_map = map.get_item_map_index_able();
        if (index_item_map > -1) {
            //
            map.item_map[index_item_map] = new ItemMap();
            map.item_map[index_item_map].id_item = (short) index_real;
            map.item_map[index_item_map].color = (byte) color_;
            map.item_map[index_item_map].quantity = 1;
            map.item_map[index_item_map].category = 3;
            map.item_map[index_item_map].idmaster = (short) p_master.index;
            List<Option> opnew = new ArrayList<Option>();
            for (Option op_old : ItemTemplate3.item.get(index_real).getOp()) {
                Option temp = new Option(1, 1, (short) 0);
                temp.id = op_old.id;
                if (temp.id != 37 && temp.id != 38) {
                    if (op_old.getParam(0) < 10) {
                        temp.setParam(Util.random(0, 10));
                    } else {
                        temp.setParam(Util.random((9 * op_old.getParam(0)) / 10, op_old.getParam(0)));
                    }
                } else {
                    temp.setParam(1);
                }
                opnew.add(temp);
            }
            map.item_map[index_item_map].op = new ArrayList<>();
            map.item_map[index_item_map].op.addAll(opnew);
            map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
            map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
            // add in4 game scr
            Message mi = new Message(19);
            mi.writer().writeByte(3);
            mi.writer().writeShort(index); // index mob die
            mi.writer().writeShort(ItemTemplate3.item.get(map.item_map[index_item_map].id_item).getIcon());
            mi.writer().writeShort(index_item_map); //
            mi.writer().writeUTF(name);
            mi.writer().writeByte(color_); // color
            mi.writer().writeShort(-1); // id player
            MapService.send_msg_player_inside(map, p_master, mi, true);
            mi.cleanup();
        }
    }

    public static void leave_item_4(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short index_real = (short) Util.random(0, 6);

            // if (mob.level < 0 && mob.level <2 && 100 > Util.random(100)) {
            // index_real = 103;
            // }
            //if (mob.template.mob_id == 0&& 100 > Util.random(100)) {
            //    index_real = 103;
            //  }
            // if (mob.isdie) {
            // index_real = 103;
            // }
            // if (map.map_id== 0 && 1000000000>Util.random(1000000000)) { 
            // //index_real = 103;
            // p.update_vang(50000);
            // p.update_ngoc(15);
            // p.item.char_inventory(5);
            // }
            leave_item_by_type4(map, index_real, p, mob.index);
        }
    }

    public static void leave_item_by_type4(Map map, short id_item, Player p_master, int index_mob) throws IOException {
        int index_item_map = map.get_item_map_index_able();
        if (index_item_map > -1) {
            //
            map.item_map[index_item_map] = new ItemMap();
            map.item_map[index_item_map].id_item = id_item;
            map.item_map[index_item_map].color = 0;
            map.item_map[index_item_map].quantity = 1;
            map.item_map[index_item_map].category = 4;
            map.item_map[index_item_map].idmaster = (short) p_master.index;
            map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
            map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
            // add in4 game scr
            Message mi = new Message(19);
            mi.writer().writeByte(4);
            mi.writer().writeShort(index_mob); // id mob die
            mi.writer().writeShort(ItemTemplate4.item.get(map.item_map[index_item_map].id_item).getIcon());
            mi.writer().writeShort(index_item_map); //
            mi.writer().writeUTF(ItemTemplate4.item.get(map.item_map[index_item_map].id_item).getName());
            mi.writer().writeByte(0); // color
            mi.writer().writeShort(-1); // id player
            MapService.send_msg_player_inside(map, p_master, mi, true);
            mi.cleanup();
        }
    }

    public static void leave_item_7(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short index_real = (short) Util.random(0, 4);
            //
            leave_item_by_type7(map, index_real, p, mob.index);
        }
    }

    private static void leave_item_by_type7(Map map, short id_it, Player p_master, int indexmob) throws IOException {
        if (p_master != null && !p_master.isDropMaterialMedal && id_it >= 46 && id_it <= 345) {
            return;
        }
        int index_item_map = map.get_item_map_index_able();
        if (index_item_map > -1) {
            //
            map.item_map[index_item_map] = new ItemMap();
            map.item_map[index_item_map].id_item = id_it;
            if (ItemTemplate7.item.get(map.item_map[index_item_map].id_item).getColor() == 21) {
                map.item_map[index_item_map].color = 1;
            } else {
                map.item_map[index_item_map].color = 0;
            }
            map.item_map[index_item_map].quantity = 1;
            map.item_map[index_item_map].category = 7;
            map.item_map[index_item_map].idmaster = (short) p_master.index;
            map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
            map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
            // add in4 game scr
            Message mi = new Message(19);
            mi.writer().writeByte(7);
            mi.writer().writeShort(indexmob); // id mob die
            mi.writer().writeShort(ItemTemplate7.item.get(map.item_map[index_item_map].id_item).getIcon());
            mi.writer().writeShort(index_item_map); //
            mi.writer().writeUTF(ItemTemplate7.item.get(map.item_map[index_item_map].id_item).getName());
            mi.writer().writeByte(map.item_map[index_item_map].color); // color
            mi.writer().writeShort(-1); // id player
            MapService.send_msg_player_inside(map, p_master, mi, true);
            mi.cleanup();
        }
    }

    public static void leave_item_boss(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null && mob.isBoss()) {
            // roi do boss co dinh
            short[] id_item_leave3 = new short[]{};
            short[] id_item_leave4 = new short[]{};
            short[] id_item_leave7 = new short[]{};
            //short id_medal_material = -1;
            short sizeRandomMedal = 0;
            switch (mob.template.mob_id) {
                case 101: { // xa nu
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 53};
                    id_item_leave7 = new short[]{0, 4, 14, 0, 4, 12, 2, 2, 1, 1, 10, 10};
                    //  id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    sizeRandomMedal = (short) (30);

                    break;
                }

                case 84: { // de vang
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 54, 27, 27};
                    id_item_leave7 = new short[]{8, 9, 10, 13, 14, 0, 4, 0, 4};
                    //  id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    sizeRandomMedal = (short) (35);

                    break;
                }
                case 83: { // de bac
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 53};
                    id_item_leave7 = new short[]{0, 4, 0, 4, 11, 12, 14, 2, 3, 2, 3};
                    //id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    sizeRandomMedal = (short) (45);

                    break;
                }
                case 103: { // bo cap chua
                    //id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 48, 50, 18, 9, 48, 50, 18, 9, 2, 5, 2, 5, 2, 5, 2, 5};
                    //id_item_leave7 = new short[]{0, 0, 0};
                    // id_item_leave7 = new short[]{(short) Util.random(125, 136)};

                    sizeRandomMedal = (short) (20);
                    break;
                }
                case 104: { // quy 1 mat
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 10, 10};
                    id_item_leave7 = new short[]{2, 3, 2, 3, 12, 12, 8, 9, 10, 8, 9, 10};
                    //id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    sizeRandomMedal = (short) (25);
                    break;
                }
                case 105: { // quy dau bo
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 54, 49, 49};
                    id_item_leave7 = new short[]{11, 0, 4, 0, 4, 13, 14, 2, 3, 2, 3};
                    //  id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    sizeRandomMedal = (short) (40);
                    break;
                }
                case 106: { // ky sy dia nguc
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 54, 53, 18};
                    id_item_leave7 = new short[]{11, 13, 2, 3, 2, 3, 14, 494};
                    // id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    if (Util.random(20) < 20) {
                        id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    sizeRandomMedal = (short) (50);
                    break;
                }

                case 149: { // nhen chua
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 54, 53, 18};
                    id_item_leave7 = new short[]{11, 13, 2, 3, 2, 3, 14, 494};
                    //id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    if (Util.random(100) < 25) {
                        id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    sizeRandomMedal = (short) (55);
                    break;
                }
                case 155: { // giant skeleton
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 54, 53, 18};
                    id_item_leave7 = new short[]{11, 13, 2, 3, 2, 3, 14, 494};
                    //  id_item_leave7 = new short[]{(short) Util.random(125, 136)};
                    if (Util.random(100) < 30) {
                        id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    sizeRandomMedal = (short) (60);
                    break;
                }
                case 173: { //tho tuyet
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 273, 274, 251, 319, 320, 321, 322};
                    id_item_leave7 = new short[]{14, 494};

                    if (Util.random(1) < 1) {
                        //     id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    // sizeRandomMedal = (short) (60);
                    break;
                }
                case 195: { // Godzila
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 273, 274, 251, 319, 320, 321, 322};
                    id_item_leave7 = new short[]{14, 494};

                    if (Util.random(1) < 1) {
                        //     id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    // sizeRandomMedal = (short) (60);
                    break;
                }
                case 196: { // King kong
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 273, 274, 251, 319, 320, 321, 322};
                    id_item_leave7 = new short[]{14, 494};

                    if (Util.random(1) < 1) {
                        //     id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    // sizeRandomMedal = (short) (60);
                    break;
                }
                case 197: { // ga trong
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 273, 274, 251, 319, 320, 321, 322};
                    id_item_leave7 = new short[]{14, 494};

                    if (Util.random(1) < 1) {
                        //     id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    // sizeRandomMedal = (short) (60);
                    break;
                }
                case 186: { // Người tuyết nhỏ
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 273, 274, 251, 319, 320, 321, 322};
                    id_item_leave7 = new short[]{14, 494};

                    if (Util.random(1) < 1) {
                        //     id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    // sizeRandomMedal = (short) (60);
                    break;
                }
                case 187: { // Lính rìu nhỏ
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 273, 274, 251, 319, 320, 321, 322};
                    id_item_leave7 = new short[]{14, 494};

                    if (Util.random(1) < 1) {
                        //     id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    // sizeRandomMedal = (short) (60);
                    break;
                }

                case 188: { //Lão trọc
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 273, 274, 251, 319, 320, 321, 322};
                    id_item_leave7 = new short[]{14, 494};

                    if (Util.random(1) < 1) {
                        //    id_item_leave3 = new short[]{(short) Util.random(4577, 4585)};
                    }
                    // sizeRandomMedal = (short) (60);
                    break;
                }

                case 198: { // Chó đá
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1};
                    id_item_leave7 = new short[]{14, 495};

                    int coin_ = Util.random(1000, 5000);
                    p.update_coin(coin_);
                    p.item.char_inventory(5);
                    Service.send_notice_nobox_white(p.conn, "Hạ gục chó đá nhận " + coin_ + " coin,");

                    if (Util.random(100) < 100) { // 100% chance to drop
                        for (int i = 0; i < 5; i++) {
                            short randomItem7Id = (short) Util.ngaunhien(496, 500);
                            leave_item_by_type7(map, randomItem7Id, p, mob.index, p.index);
                        }
                    }
                    break;
                }

                case 199: { //Khói Ma
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1};
                    id_item_leave7 = new short[]{14, 495};

                    int coin_ = Util.random(1000, 5000);
                    p.update_coin(coin_);
                    p.item.char_inventory(5);
                    Service.send_notice_nobox_white(p.conn, "Hạ gục chó đá nhận " + coin_ + " coin,");

                    if (Util.random(100) < 100) { // 100% chance to drop
                        for (int i = 0; i < 5; i++) {
                            short randomItem7Id = (short) Util.ngaunhien(496, 500);
                            leave_item_by_type7(map, randomItem7Id, p, mob.index, p.index);
                        }
                    }
                    break;
                }

                case 200: { //Nấm Xanh
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1};
                    id_item_leave7 = new short[]{14, 495};

                    int coin_ = Util.random(1000, 5000);
                    p.update_coin(coin_);
                    p.item.char_inventory(5);
                    Service.send_notice_nobox_white(p.conn, "Hạ gục chó đá nhận " + coin_ + " coin,");

                    if (Util.random(100) < 100) { // 100% chance to drop
                        for (int i = 0; i < 5; i++) {
                            short randomItem7Id = (short) Util.ngaunhien(496, 500);
                            leave_item_by_type7(map, randomItem7Id, p, mob.index, p.index);
                        }
                    }
                    break;
                }

                case 201: { //cs 300-500
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1};
                    id_item_leave7 = new short[]{14, 495};

                    int coin_ = Util.random(1000, 5000);
                    p.update_coin(coin_);
                    p.item.char_inventory(5);
                    Service.send_notice_nobox_white(p.conn, "Hạ gục chó đá nhận " + coin_ + " coin,");

                    if (Util.random(100) < 100) { // 100% chance to drop
                        for (int i = 0; i < 5; i++) {
                            short randomItem7Id = (short) Util.ngaunhien(496, 500);
                            leave_item_by_type7(map, randomItem7Id, p, mob.index, p.index);
                        }
                    }
                    break;
                }

                case 202: { //cs 500-1000
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1};
                    id_item_leave7 = new short[]{14, 495};

                    int coin_ = Util.random(1000, 5000);
                    p.update_coin(coin_);
                    p.item.char_inventory(5);
                    Service.send_notice_nobox_white(p.conn, "Hạ gục chó đá nhận " + coin_ + " coin,");

                    if (Util.random(100) < 100) { // 100% chance to drop
                        for (int i = 0; i < 5; i++) {
                            short randomItem7Id = (short) Util.ngaunhien(496, 500);
                            leave_item_by_type7(map, randomItem7Id, p, mob.index, p.index);
                        }
                    }
                    break;
                }

            }
            for (short id : id_item_leave3) {
                ItemTemplate3 temp = ItemTemplate3.item.get(id);
                leave_item_by_type3(map, id, temp.getColor(), p, temp.getName(), mob.index);
            }
            for (int i = 0; i < 3; i++) {
                for (short id : id_item_leave4) {
                    if (id == -1) {
                        leave_vang(map, mob, p);
                    } else {
                        leave_item_by_type4(map, id, p, mob.index, p.index);
                    }
                }
            }
            for (int i = 0; i < 5; i++) {
                for (short id : id_item_leave7) {
                    leave_item_by_type7(map, id, p, mob.index, p.index);
                }
            }
            for (int l = 0; l < sizeRandomMedal; l++) {
                leave_item_by_type7(map, (short) Util.random(136, 146), p, mob.index, p.index);
            }
        }
    }

    public static void leave_material(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short index_real = -1;
            switch (mob.level) {
                case 1:
                case 2:
                case 3:
                case 4: {
                    index_real = Medal_Material.m_white[0][Util.random(0, 3)];
                    break;
                }
                case 5: {
                    index_real = Medal_Material.m_white[0][Util.random(3, 6)];
                    break;
                }
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17: {
                    index_real = Medal_Material.m_white[0][Util.random(6, 10)];
                    break;
                }
                case 19: {
                    index_real = Medal_Material.m_white[1][Util.random(0, 3)];
                    break;
                }
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26: {
                    index_real = Medal_Material.m_white[1][Util.random(3, 6)];
                    break;
                }
                case 28:
                case 29: {
                    index_real = Medal_Material.m_white[1][Util.random(6, 9)];
                    break;
                }
                case 31:
                case 32:
                case 33:
                case 34:
                case 35: {
                    index_real = Medal_Material.m_white[1][9];
                    break;
                }
                case 37: {
                    index_real = Medal_Material.m_white[2][Util.random(0, 3)];
                    break;
                }
                case 39:
                case 40:
                case 41:
                case 42:
                case 43: {
                    index_real = Medal_Material.m_white[2][Util.random(3, 6)];
                    break;
                }
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54: {
                    index_real = Medal_Material.m_white[2][Util.random(6, 10)];
                    break;
                }
                case 55: {
                    index_real = Medal_Material.m_white[3][Util.random(0, 3)];
                    break;
                }
                case 57:
                case 58:
                case 59: {
                    index_real = Medal_Material.m_white[3][Util.random(3, 6)];
                    break;
                }
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69: {
                    index_real = Medal_Material.m_white[3][Util.random(6, 10)];
                    break;
                }
                case 71:
                case 72:
                case 73:
                case 74: {
                    index_real = Medal_Material.m_white[4][Util.random(0, 3)];
                    break;
                }
                case 76:
                case 77: {
                    index_real = Medal_Material.m_white[4][Util.random(3, 6)];
                    break;
                }
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89: {
                    index_real = Medal_Material.m_white[4][Util.random(6, 10)];
                    break;
                }
                case 90:
                case 91:
                case 92: {
                    index_real = Medal_Material.m_white[5][Util.random(0, 3)];
                    break;
                }
                case 93:
                case 94:
                case 95: {
                    index_real = Medal_Material.m_white[5][Util.random(3, 6)];
                    break;
                }
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107: {
                    index_real = Medal_Material.m_white[5][Util.random(6, 10)];
                    break;
                }
                case 109:
                case 110: {
                    index_real = Medal_Material.m_white[6][Util.random(0, 3)];
                    break;
                }
                case 112:
                case 113: {
                    index_real = Medal_Material.m_white[6][Util.random(3, 6)];
                    break;
                }
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123: {
                    index_real = Medal_Material.m_white[6][Util.random(6, 10)];
                    break;
                }
                case 125:
                case 126:
                case 127:
                case 128:
                case 129, 130, 131, 132, 133, 134: {
                    index_real = Medal_Material.m_white[0][Util.random(6, 10)];
                    break;
                }
            }
            //
            if (index_real > -1) {
                //
                leave_item_by_type7(map, index_real, p, mob.index);
            }
            if (25 > Util.random(0, 100)) {
                index_real = Medal_Material.m_yellow[Util.random(0, 10)];
                //
                leave_item_by_type7(map, index_real, p, mob.index);
            }
            if (25 > Util.random(0, 100)) {
                index_real = (short) ((15 > Util.random(0, 120)) ? 11
                        : ((35 > Util.random(0, 120)) ? 10 : ((50 > Util.random(0, 120)) ? 9 : 8)));
                //
                leave_item_by_type7(map, index_real, p, mob.index);
            }
        }
    }

    public static void leave_item_event(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short index_real = -1; // Khởi tạo giá trị mặc định
            switch (Manager.gI().event) {
                case 1:
                    index_real = EventManager.item_leave[0][Util.random(EventManager.item_leave[0].length)];
                    if (!Event_1.check(p.name) && index_real >= 153 && index_real <= 156) {
                        return;
                    }
                    break;
                case 5: // Xử lý sự kiện 5
                    index_real = EventManager.item_leave[4][Util.random(EventManager.item_leave[4].length)];
                    if (!Event_5.check(p.name)) { // Chỉ cần kiểm tra điều kiện Event_5
                        return;
                    }
                    break;
                // Các case khác cho các sự kiện khác (nếu có)
            }

            if (index_real != -1) { // Kiểm tra xem có vật phẩm nào được chọn hay không
                leave_item_by_type4(map, index_real, p, mob.index);
            }
        }
    }

    public static void leave_material_ngockham(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short index_real = -1;
            //
            if (25 > Util.random(120)) {
                switch (mob.template.mob_id) {
                    case 167: {
                        index_real = 362;
                        break;
                    }
                    case 168: {
                        index_real = 372;
                        break;
                    }
                    case 169: {
                        index_real = 367;
                        break;
                    }
                    case 170: {
                        index_real = 357;
                        break;
                    }
                    case 171: {
                        index_real = 377;
                        break;
                    }
                    case 172: {
                        index_real = 352;
                        break;
                    }
                }
            }
            if (index_real != -1) {
                leave_item_by_type7(map, index_real, p, mob.index);
            }
        }
    }

    public static void leave_dan(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short index_real = -1;
            //
            // if (25 > Util.random(120)) {

            if (map.map_id == 118 && 25 > Util.random(250)) {
                index_real = (short) Util.ngaunhien(326, 328);

                // if (p.get_kinhmach() ==12) {
                // p.update_exptt(1);
                // }
                // p.update_ngoc(15);
                p.item.char_inventory(5);

            }

            if (map.map_id == 118 && 250 > Util.random(250)) {

                //exp tu tiên            
                if (p.get_kinhmach() == 12) {
                    p.update_exptt(2);
                }

                p.item.char_inventory(5);

                // Rớt ngọc             
                if (p.get_tutien() == 12 && 30 > Util.random(100)) {
                    for (int i = 0; i < 5; i++) {
                        leave_ngoc(map, mob, p);
                    }
                    p.item.char_inventory(5);
                } else if (p.get_tutien() >= 8 && 30 > Util.random(100)) {
                    for (int i = 0; i < 4; i++) {
                        leave_ngoc(map, mob, p);
                    }
                    p.item.char_inventory(5);
                } else if (p.get_tutien() >= 4 && 30 > Util.random(100)) {
                    for (int i = 0; i < 3; i++) {
                        leave_ngoc(map, mob, p);
                    }
                    p.item.char_inventory(5);
                } else if ((p.get_kinhmach() == 12 && p.get_tutien() < 4) && 30 > Util.random(100)) {
                    for (int i = 0; i < 2; i++) {
                        leave_ngoc(map, mob, p);
                    }
                    p.item.char_inventory(5);
                } else if ((p.get_luyenthe() == 8 && p.get_kinhmach() < 12) && 30 > Util.random(100)) {
                    for (int i = 0; i < 1; i++) {
                        leave_ngoc(map, mob, p);
                    }
                    p.item.char_inventory(5);
                }

            }

            if (index_real != -1) {
                leave_item_by_type4(map, index_real, p, mob.index);
            }
        }
    }

    public static void leave_tientai(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            short index_real = -1;
            //
            // if (25 > Util.random(120)) {

            if (map.map_id == 117 && 250 > Util.random(250)) {

                for (int i = 0; i < 1; i++) {

                    leave_ngoc(map, mob, p);

                }

                for (int i = 0; i < 1; i++) {

                    leave_vang1(map, mob, p);

                }
                // p.update_vang(50000);
                // p.update_ngoc(15);
                p.item.char_inventory(5);

            }

            //   }
            if (index_real != -1) {
                leave_item_by_type4(map, index_real, p, mob.index);
            }
        }
    }

    public static void leave_vang(Map map, Mob_in_map mob, int id_mater) throws IOException {
        if (mob != null) {
            int index_item_map = map.get_item_map_index_able();
            if (index_item_map > -1) {
                //
                map.item_map[index_item_map] = new ItemMap();
                map.item_map[index_item_map].id_item = -1;
                map.item_map[index_item_map].color = 0;
                int vang_drop = Util.random(mob.level * 25, mob.level * 60);
                map.item_map[index_item_map].quantity = vang_drop;
                map.item_map[index_item_map].category = 4;
                map.item_map[index_item_map].idmaster = (short) id_mater;
                map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
                map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
                String name = "vàng *" + map.item_map[index_item_map].quantity;
                // add in4 game scr
                Message mi = new Message(19);
                mi.writer().writeByte(4);
                mi.writer().writeShort(mob.index); // index mob die
                mi.writer().writeShort(0); // id icon (0 : vang)
                mi.writer().writeShort(index_item_map); //
                mi.writer().writeUTF(name);
                mi.writer().writeByte(0); // color
                mi.writer().writeShort(-1); // id player
                MapService.send_msg_player_inside(map, mob, mi, true);
                mi.cleanup();
            }
        }
    }

    public static void leave_item_by_type3(Map map, int index_real, int color_, Player p_master, String name, int index, int idP)
            throws IOException {
        int index_item_map = map.get_item_map_index_able();
        if (index_item_map > -1) {
            //
            map.item_map[index_item_map] = new ItemMap();
            map.item_map[index_item_map].id_item = (short) index_real;
            map.item_map[index_item_map].color = (byte) color_;
            map.item_map[index_item_map].quantity = 1;
            map.item_map[index_item_map].category = 3;
            map.item_map[index_item_map].idmaster = (short) idP;
            List<Option> opnew = new ArrayList<>();
            for (Option op_old : ItemTemplate3.item.get(index_real).getOp()) {
                Option temp = new Option(1, 1, (short) 0);
                temp.id = op_old.id;
                if (temp.id != 37 && temp.id != 38) {
                    if (op_old.getParam(0) < 10) {
                        temp.setParam(Util.random(0, 10));
                    } else {
                        temp.setParam(Util.random((9 * op_old.getParam(0)) / 10, op_old.getParam(0)));
                    }
                } else {
                    temp.setParam(1);
                }
                opnew.add(temp);
            }
            map.item_map[index_item_map].op = new ArrayList<>();
            map.item_map[index_item_map].op.addAll(opnew);
            map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
            map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
            // add in4 game scr
            Message mi = new Message(19);
            mi.writer().writeByte(3);
            mi.writer().writeShort(index); // index mob die
            mi.writer().writeShort(ItemTemplate3.item.get(map.item_map[index_item_map].id_item).getIcon());
            mi.writer().writeShort(index_item_map); //
            mi.writer().writeUTF(name);
            mi.writer().writeByte(color_); // color
            mi.writer().writeShort(-1); // id player
            MapService.send_msg_player_inside(map, p_master, mi, true);
            mi.cleanup();
        }
    }

    public static void leave_item_by_type4(Map map, short index_real, Player p_master, int index, int idp) throws IOException {
        int index_item_map = map.get_item_map_index_able();
        if (index_item_map > -1) {
            //
            map.item_map[index_item_map] = new ItemMap();
            map.item_map[index_item_map].id_item = index_real;
            map.item_map[index_item_map].color = 0;
            map.item_map[index_item_map].quantity = 1;
            map.item_map[index_item_map].category = 4;
            map.item_map[index_item_map].idmaster = (short) idp;
            map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
            map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
            // add in4 game scr
            Message mi = new Message(19);
            mi.writer().writeByte(4);
            mi.writer().writeShort(index); // id mob die
            mi.writer().writeShort(ItemTemplate4.item.get(map.item_map[index_item_map].id_item).getIcon());
            mi.writer().writeShort(index_item_map); //
            mi.writer().writeUTF(ItemTemplate4.item.get(map.item_map[index_item_map].id_item).getName());
            mi.writer().writeByte(0); // color
            mi.writer().writeShort(-1); // id player
            MapService.send_msg_player_inside(map, p_master, mi, true);
            mi.cleanup();
        }
    }

    public static void leave_item_by_type7(Map map, short id_it, Player p_master, int index, int idp) throws IOException {
        if (p_master != null && !p_master.isDropMaterialMedal && id_it >= 46 && id_it <= 345) {
            return;
        }
        int index_item_map = map.get_item_map_index_able();
        if (index_item_map > -1) {
            //
            map.item_map[index_item_map] = new ItemMap();
            map.item_map[index_item_map].id_item = id_it;
            if (ItemTemplate7.item.get(map.item_map[index_item_map].id_item).getColor() == 21) {
                map.item_map[index_item_map].color = 1;
            } else {
                map.item_map[index_item_map].color = 0;
            }
            map.item_map[index_item_map].quantity = 1;
            map.item_map[index_item_map].category = 7;
            map.item_map[index_item_map].idmaster = (short) idp;
            map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L;
            map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;
            // add in4 game scr
            Message mi = new Message(19);
            mi.writer().writeByte(7);
            mi.writer().writeShort(index); // id mob die
            mi.writer().writeShort(ItemTemplate7.item.get(map.item_map[index_item_map].id_item).getIcon());
            mi.writer().writeShort(index_item_map); //
            mi.writer().writeUTF(ItemTemplate7.item.get(map.item_map[index_item_map].id_item).getName());
            mi.writer().writeByte(map.item_map[index_item_map].color); // color
            mi.writer().writeShort(p_master.index); // id player
            MapService.send_msg_player_inside(map, p_master, mi, true);
            mi.cleanup();
        }
    }

    public static void leave_item5(Map map, Mob_in_map mob, Player p, int id, int quantity) throws IOException {
        if (mob != null) {
            int index_item_map = map.get_item_map_index_able(); // Kiểm tra vị trí trống trên bản đồ
            if (index_item_map > -1) {
                // Khởi tạo ItemMap cho mỗi item rơi
                map.item_map[index_item_map] = new ItemMap();
                map.item_map[index_item_map].id_item = (byte) id;  // ID item5 cần rơi (ở đây là id = 0)
                map.item_map[index_item_map].color = 5;    // Màu sắc item (nếu cần)
                map.item_map[index_item_map].quantity = quantity; // Số lượng item5 rơi

                // Thiết lập thuộc tính của item
                map.item_map[index_item_map].category = 5;
                map.item_map[index_item_map].idmaster = (short) p.index;
                map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 15_000L; // Tồn tại 60 giây
                map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;   // Có thể nhặt sau 1.5 giây

                // Lấy tên item từ ItemTemplate5
                String name = ItemTemplate5.items.get(id).name;
                Message mi = new Message(19);
                mi.writer().writeByte(5);  // Loại item (5 đại diện cho Item5)
                mi.writer().writeShort(mob.index); // Mob ID
                mi.writer().writeShort(id); // ID item
                mi.writer().writeShort(index_item_map); // Vị trí trên bản đồ
                mi.writer().writeUTF(name);  // Tên item
                mi.writer().writeByte(5);    // Màu sắc
                mi.writer().writeShort(p.index);  // Người chơi nhặt

                // Gửi thông báo tới tất cả người chơi trong bản đồ
                MapService.send_msg_player_inside(map, p, mi, true);
                mi.cleanup();
            }
        }
    }

}
