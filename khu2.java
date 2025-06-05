/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai;

import client.Player;
import client.Squire;
import core.Service;
import core.Util;
import io.Message;
import io.Session;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.runner.Version.id;
import map.ItemMap;
import map.LeaveItemMap;
import static map.LeaveItemMap.leave_item_by_type3;
import static map.LeaveItemMap.leave_item_by_type4;

import map.Map;
import map.MapService;
import map.Mob_in_map;
import template.EffTemplate;
import template.Item3;
import template.ItemTemplate3;
import template.Option;

/**
 *
 * @author BERU
 */
public class khu2 {

    public final static HashMap<Integer, Mob_in_map> ENTRYS = new HashMap<>();
    public static Map map;
    public static Session conn;
    public static Player p;
    public static void khu2_a(Map map, Session conn) throws InterruptedException, IOException {
        map = Map.get_map_by_id(map.map_id)[1];
        // Rời máp hiện tại
        MapService.leave(conn.p.map, conn.p);
        // Cập nhật map mới
        conn.p.map = map;
        // Vào map
        if(conn.p.map.zone_id==1 && !khu2.isDont_khu2(map.map_id)){
        conn.p.typepk=-1;
        }
        MapService.enter(conn.p.map, conn.p);
        if (conn.p.time_khu2 <= 0) {
            conn.p.time_khu2 = 60 * 60 * 2;
        }
       
       
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            private Mob_in_map Mob_in_map;

            @Override
            public void run() {
                if (conn.p.map.zone_id == 1 && (!(conn.p.map.ismaplang))) {
                    try {
                        // Đếm Tg
                        conn.p.time_khu2--;

                        khu2.khu2_time_box(conn.p, (byte) 1, new int[]{conn.p.time_khu2}, new String[]{"Khu 2 "});

                    } catch (Exception e) {
                        System.err.println("Đã sảy ra lỗi: " + e.getMessage());
                    }
                }
                if (conn.p.time_khu2 <= 0 && conn.p.map.zone_id == 1) {
                    timer.cancel();
                    conn.p.time_khu2 = 0;

                    try {
                        // khi kết thúc thời gian 
                        Map map;// kết thúc đếm ngược

                        map = Map.get_map_by_id(conn.p.map.map_id)[0];
                        // Rời máp hiện tại
                        MapService.leave(conn.p.map, conn.p);

                        // Cập nhật map mới
                        conn.p.map = map;

                        // Vào map
                        MapService.enter(conn.p.map, conn.p);
                    } catch (Exception e) {
                        System.err.println("Đã sảy ra lỗi: " + e.getMessage());
                    }
                }
            }
        }, 0, 1000); // Chu kỳ 1 giây
    }

    public static void khu2_b(Map map, Session conn) throws InterruptedException, IOException {
        map = Map.get_map_by_id(map.map_id)[1];
        // Rời máp hiện tại
        MapService.leave(conn.p.map, conn.p);
        // Cập nhật map mới
        conn.p.map = map;
        // Vào map
        if(conn.p.map.zone_id==1 && !khu2.isDont_khu2(map.map_id)){
        conn.p.typepk=-1;
        }
        MapService.enter(conn.p.map, conn.p);
         
        //conn.p.time_khu2=30;     
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (conn.p.map.zone_id == 1 && (!(conn.p.map.ismaplang))) {
                    try {
                        // Đếm Tg

                    } catch (Exception e) {
                        System.err.println("Đã sảy ra lỗi: " + e.getMessage());
                    }
                }
                if (conn.p.time_khu2 <= 0 && conn.p.map.zone_id == 1) {
                    timer.cancel();
                    conn.p.time_khu2 = 0;
                    try {
                        // khi kết thúc thời gian 
                        Map map;

                        map = Map.get_map_by_id(conn.p.map.map_id)[0];
                        // Rời máp hiện tại
                        MapService.leave(conn.p.map, conn.p);

                        // Cập nhật map mới
                        conn.p.map = map;

                        // Vào map
                        MapService.enter(conn.p.map, conn.p);
                    } catch (Exception e) {
                        System.err.println("Đã sảy ra lỗi: " + e.getMessage());
                    }
                }
            }
        }, 0, 1000); // Chu kỳ 1 giây
    }

    public static void leave_item4_khu2(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            if (p instanceof Squire) { 
        return; 
    }
            short index_real = -1;

            if (map.zone_id == 1 && 5 > Util.random(100)) {
                index_real = (short) Util.ngaunhien(326, 328);
                p.item.char_inventory(4);
            }

            if (index_real != -1) {
                leave_item_by_type4(map, index_real, p, mob.index);
            }
        }
    }

    public static void leave_item3_khu2(Map map, Mob_in_map mob, Player p) throws IOException {
        short[] id_item_leave3 = new short[]{};
        short[] id_item_leave4 = new short[]{};
        short[] id_item_leave7 = new short[]{};
        if (mob != null) {
            //short id_item_can_drop = 0;
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

            if (5 > Util.random(100)) {
                id_item_leave3 = new short[]{(short) Util.ngaunhien(0, 19)};
            }

            if (Math.abs(mob.level - p.level) <= 5) {
                for (short id : id_item_leave3) {
                    ItemTemplate3 temp = ItemTemplate3.item.get(id);

                    khu2.leave_item_by_type3(map, id, temp.getColor(), p, temp.getName(), mob.index);

                }
            }
        }
    }

    public static void leave_item7_khu2(Map map, Mob_in_map mob, Player p) throws IOException {
        if (mob != null) {
            if (25 > Util.random(100)) {
                short index_real = (short) Util.ngaunhien(0, 3);

                LeaveItemMap.leave_item_by_type7(map, index_real, p, index_real, index_real);
            }
        }
    }

    // chien truong // chiếm thành // lôi đài //
    public static boolean isDont_khu2(byte id) throws IOException {

        Set<Integer> set = new HashSet<>(Arrays.asList(1, 33, 67, 50, 46, 48, 53, 54, 55, 56, 57, 58, 59, 60, 61, 83, 84, 85, 86, 87, 100, 102));

        return set.contains((int) id);
    }

    public static void khu2_yesno(Session conn, int type, String s) throws IOException {
        Message m2 = new Message(-32);
        m2.writer().writeShort(conn.p.index);
        m2.writer().writeByte(type);
        m2.writer().writeUTF(s);
        conn.addmsg(m2);
        m2.cleanup();
    }

    public static void khu2_box(Session conn, String s) throws IOException {
        Message m2 = new Message(37);
        m2.writer().writeUTF(s);
        m2.writer().writeUTF("");
        m2.writer().writeByte(15);
        conn.addmsg(m2);
        m2.cleanup();
    }

    public static void khu2_time_box(Player p, final byte size, final int[] time, final String[] tile) throws IOException {
        Message m = new Message(-104);
        m.writer().writeByte(1);
        m.writer().writeByte(size);
        if (size > 0) {
            for (int i = 0; i < size; i++) {

                m.writer().writeShort(time[i]);
                m.writer().writeUTF(tile[i]);
                p.conn.addmsg(m);
                m.cleanup();
            }
        }
    }

    public static void leave_item_by_type3(Map map, int index_real, int color_, Player p_master, String name, int index)
       throws IOException {
    int index_item_map = map.get_item_map_index_able();
    if (index_item_map > -1) {
        map.item_map[index_item_map] = new ItemMap();
        map.item_map[index_item_map].id_item = (short) index_real;
        map.item_map[index_item_map].color = (byte) color_;
        map.item_map[index_item_map].quantity = 1;
        map.item_map[index_item_map].category = 3;
        map.item_map[index_item_map].idmaster = (short) p_master.index;

        Item3 item3 = new Item3(ItemTemplate3.item.get(index_real));
        item3.color = (byte) color_;
        item3.map_124 = true; // Đánh dấu rằng vật phẩm này rơi ra từ khu2
        
        int param = switch (color_) {
            case 0 -> Util.random(250, 450);
            case 1 -> Util.random(450, 550);
            case 2 -> Util.random(550, 750);
            case 3 -> Util.random(750, 950);
            case 4 -> Util.random(950, 1250);
            default -> 0;
        };

        if (index_real >= 0 && index_real <= 4) {
            item3.op.add(new Option(2, param, (short) 0));
        } else if (index_real >= 5 && index_real <= 9) {
            item3.op.add(new Option(4, param, (short) 0));
        } else if (index_real >= 10 && index_real <= 14) {
            item3.op.add(new Option(1, param, (short) 0));
        } else if (index_real >= 15 && index_real <= 19) {
            item3.op.add(new Option(3, param, (short) 0));
        }
       
        item3.level = 1;
        item3.tier = (byte) Util.ngaunhien(0, 15);
        //item3.expiry_date = System.currentTimeMillis() + 5 * 60 * 1000;
        map.item_map[index_item_map].item3 = item3;

        //map.item_map[index_item_map].expiration_time = item3.expiry_date;
        map.item_map[index_item_map].time_exist = System.currentTimeMillis() + 60_000L;
        map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;

        map.item_map[index_item_map].op = new ArrayList<>(item3.op);

        Message mi = new Message(19);
        mi.writer().writeByte(3);
        mi.writer().writeShort(index);
        mi.writer().writeShort(item3.icon);
        mi.writer().writeShort(index_item_map);
        mi.writer().writeUTF(item3.name);
        mi.writer().writeByte(item3.color);
        mi.writer().writeShort(-1);
        MapService.send_msg_player_inside(map, p_master, mi, true);
        mi.cleanup();
    }
}



}
