/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeothapWeek;

import client.Player;
import core.Service;
import core.Util;
import io.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import map.Map;
import map.MapService;
import map.Mob_in_map;
import template.Item47;

/**
 *
 * @author BERU
 */
public class Leothap {

    public String name_party;
    public Map template;
    public List<Boss_Leothap> list_nhanban;
    public Player pl_1;
    public Boss_Leothap pl_2;
    public long time_lt;

    public Leothap() throws IOException {
        init();
    }

    private void init() throws IOException {
        Map temp = Map.get_map_dungeon(46);
        template = new Map(46, 0, temp.npc_name_data, temp.name, temp.typemap, temp.ismaplang, temp.showhs,
                temp.maxplayer, temp.maxzone, temp.vgos);
         template.mobs = new Mob_in_map[0];
        //Mob_in_map mob = new Mob_in_map();
        template.start_map();
        template.lt = this;
        list_nhanban = new ArrayList<>();
        time_lt = System.currentTimeMillis() + (1000 * 60 * 5);
    }

    public Boss_Leothap get_mob(int id) {
        for (int i = 0; i < list_nhanban.size(); i++) {
            if (this.list_nhanban.get(i).index == id) {
                return this.list_nhanban.get(i);
            }
        }
        return null;
    }

    public void send_in4(Player p, int index) throws IOException {
        for (int i = 0; i < this.list_nhanban.size(); i++) {
            Boss_Leothap temp = list_nhanban.get(i);
            Message m = new Message(5);
            m.writer().writeShort(temp.index);
            m.writer().writeUTF(temp.name);
            m.writer().writeShort(temp.x);
            m.writer().writeShort(temp.y);
            m.writer().writeByte(temp.clazz);
            m.writer().writeByte(-1);
            m.writer().writeByte(temp.head);
            m.writer().writeByte(temp.eye);
            m.writer().writeByte(temp.hair);
            m.writer().writeShort(temp.level);
            m.writer().writeInt(temp.hp);
            m.writer().writeInt(temp.hp_max);
            m.writer().writeByte(0); // type pk
            m.writer().writeShort(temp.pointpk);
            m.writer().writeByte(temp.part_p.size());
            //
            for (int z = 0; z < temp.part_p.size(); z++) {
                m.writer().writeByte(temp.part_p.get(z).type);
                m.writer().writeByte(temp.part_p.get(z).part);
                m.writer().writeByte(3);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1);
                m.writer().writeShort(-1); // eff
            }
            //
            m.writer().writeShort(temp.clan_icon);
            if (temp.clan_icon > -1) {
                m.writer().writeInt(temp.clan_id);
                m.writer().writeUTF(temp.clan_name_clan_shorted);
                m.writer().writeByte(temp.clan_mem_type);
            }
            m.writer().writeByte(-1); // pet
            m.writer().writeByte(temp.fashion.length);
            for (int j = 0; j < temp.fashion.length; j++) {
                m.writer().writeByte(temp.fashion[j]);
            }
            //
            m.writer().writeShort(temp.id_img_mob);//id_img_mob
            m.writer().writeByte(temp.type_use_mount);
            m.writer().writeBoolean(false);
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            m.writer().writeShort(temp.mat_na); // mat na
            m.writer().writeByte(1); // paint mat na trc sau
            m.writer().writeShort(temp.phi_phong); // phi phong
            m.writer().writeShort(temp.weapon); // weapon
            m.writer().writeShort(temp.id_horse);
            m.writer().writeShort(temp.id_hair); // hair
            m.writer().writeShort(temp.id_wing); // wing
            m.writer().writeShort(-1); // body
            m.writer().writeShort(-1); // leg
            m.writer().writeShort(-1); // bienhinh
            p.conn.addmsg(m);
            m.cleanup();
        }

    }

    public void update(Player p) {
       // try {
            long _time = System.currentTimeMillis();
//            Message m = new Message(-104);
//            m.writer().writeByte(1);
//            m.writer().writeByte(2);
//            m.writer().writeShort((int) ((time_lt - _time) / 1000));
//            m.writer().writeUTF("Leo Tháp");
//            m.writer().writeShort(-1);
//            m.writer().writeUTF("");
//            p.conn.addmsg(m);
//            m.cleanup();

            for (int i = 0; i < this.list_nhanban.size(); i++) {
                Boss_Leothap temp = list_nhanban.get(i);
                    temp.p_target = p;
                    temp.is_move = false;
            }
            if (time_lt < _time) {
                this.Updatesetlose(p);
                
            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void SetDie(Map map, Player p) throws IOException {
        Boss_Leothap blt = new Boss_Leothap();
        blt.changeid(p.levellt);
        blt.setup(p);
        blt.p_skill_id = 1;
        list_nhanban.add(blt);
        Message m12 = new Message(4);
        m12.writer().writeByte(0);
        m12.writer().writeShort(0);
        m12.writer().writeShort(blt.index);
        m12.writer().writeShort(blt.x);
        m12.writer().writeShort(blt.y);
        m12.writer().writeByte(-1);
       
        //MapService.SendChat(map, p, "Chết đi em iu", true);
        MapService.send_msg_player_inside(map, p, m12, true);
        m12.cleanup();
        update(p);
        System.out.print(""+blt.map_id+""+blt.name);
    }

    public void Updatesetlose(Player p) {
        try {
            
            for (int i = 0; i < template.players.size(); i++) {
                Player p0 = template.players.get(i);
                p0.x = 432;
                p0.y = 354;
                Map[] map_enter = Map.get_map_by_id(1);
                int d = 0;
                while ((d < (map_enter[d].maxzone - 1)) && map_enter[d].players.size() >= map_enter[d].maxplayer) {
                    d++;
                }
                p0.map = map_enter[d];
                //
                p0.is_changemap = false;
                p0.x_old = p0.x;
                p0.y_old = p0.y;
                MapService.enter(p0.map, p0);
                this.time_lt = 0;
            }
            this.template.stop_map();
            this.template.d = null;
            LeothapManager.remove_list(this);
            this.time_lt = 0;
            list_nhanban.clear();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Updatesetwin(Player p) throws IOException {
        // Tăng điểm và cấp độ
        p.point_lt += 1;
        p.levellt += 1;
        qitem(p);

        // Dừng các hoạt động map hiện tại
        time_lt = 0;
        template.stop_map();
        template.d = null;
        LeothapManager.remove_list(Leothap.this);
        list_nhanban.clear();

        // Gửi tin nhắn đến người chơi
        Message m = new Message(-104);
        m.writer().writeByte(1);
        m.writer().writeShort(2);
        m.writer().writeByte(-1);
        m.writer().writeByte(0);
        p.conn.addmsg(m);
        m.cleanup();
MapService.update_in4_2_other_inside(p.map, p);
        // Kiểm tra và thực hiện hành động cho từng trường hợp cấp độ
        if (p.levellt > 15) {
            roimap(p); // Thực hiện hành động B cho cấp độ lớn hơn 15
        } else {
            // Thực hiện đếm ngược và thay đổi map cho cấp độ nhỏ hơn hoặc bằng 15
            Timer countdownTimer = new Timer();
            countdownTimer.scheduleAtFixedRate(new TimerTask() {
                int i = 10;

                @Override
                public void run() {
                    if (i > 0) {
                        try {
                            Service.send_notice_nobox_white(p.conn, "Sau " + i-- + " giây Nữa Sẽ Lên Tầng " + p.levellt + "");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        cancel(); // Dừng timer khi i <= 0
                        try {
                            vaomap(p); // Thực hiện hành động sau đếm ngược
                        } catch (IOException ex) {
                        }
                    }
                }
            }, 0, 1000); // Lặp lại mỗi 1000ms (1 giây)
        }
    }

    private void roimap(Player p) throws IOException {
        Timer actionBTimer = new Timer();
        actionBTimer.scheduleAtFixedRate(new TimerTask() {
            int i = 10;

            @Override
            public void run() {
                if (i > 0) {
                    try {
                        Service.send_notice_nobox_white(p.conn, "Sau " + i-- + " giây Nữa Sẽ rời Map");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    // Thực hiện hành động B khi kết thúc đếm ngược
                    try {
                        Updatesetlose(p);
                        //System.out.println("Kết thúc đếm ngược, thực hiện hành động B.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    cancel(); // Dừng timer sau khi thực hiện hành động B
                }
            }
        }, 0, 1000); // Lặp lại mỗi 1000ms (1 giây)
    }

    private void vaomap(Player p) throws IOException {

        Leothap d = LeothapManager.get_list(p.name);
        if (d == null) {
            try {
                d = new Leothap();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (d != null) {
                d.name_party = p.name;
                MapService.leave(p.map, p);
                p.map = d.template;
                p.x = 550;
                p.y = 400;
                MapService.enter(p.map, p);
                LeothapManager.add_list(d);
                d.SetDie(d.template, p);
                Service.send_char_main_in4(p);
            } else {
                Service.send_notice_box(p.conn, "Lỗi, hãy thử lại sau!");
            }
        } else {
            MapService.leave(p.map, p);
            p.map = d.template;
            MapService.enter(p.map, p);
        }

    }

    private void qitem(Player p) throws IOException {
        List<Short> IDs = new ArrayList<>();
        List<Integer> Quants = new ArrayList<>();
        List<Short> Types = new ArrayList<>();
        int vang_up = Util.ngaunhien(700_000, 1_000_000);
        int ngoc_up = Util.ngaunhien(700, 2000);
        int coin_up = Util.ngaunhien(350, 500) * p.levellt;
        short id_ngocrong = (short) Util.ngaunhien(464, 470);
        if (p.item.get_bag_able() > 3) {
            Item47 itbag = new Item47();
            itbag.id = id_ngocrong; // id item
            itbag.quantity = (short) Util.random(1, 5); // số lượng
            itbag.category = 7; // loại item

            IDs.add(itbag.id);
            Quants.add((int) itbag.quantity);
            Types.add((short) itbag.category);
            p.item.add_item_bag47(7, itbag);
        }
        
                            if (vang_up != 0) {
                                IDs.add((short) -1);
                                Quants.add((int) (vang_up > 2_000_000_000 ? 2_000_000_000 : vang_up));
                                Types.add((short) 4);
                            }

                            if (ngoc_up != 0) {
                                IDs.add((short) -2);
                                Quants.add((int) (ngoc_up > 2_000_000_000 ? 2_000_000_000 : ngoc_up));
                                Types.add((short) 4);
                            }
                            if (coin_up != 0) {
                                IDs.add((short) -3);
                                Quants.add((int) (coin_up > 2_000_000_000 ? 2_000_000_000 : coin_up));
                                Types.add((short) 4);
                            }

        short[] ar_id = new short[IDs.size()];
        int[] ar_quant = new int[Quants.size()];
        short[] ar_type = new short[Types.size()];
        for (int i = 0; i < ar_id.length; i++) {
            ar_id[i] = IDs.get(i);
            ar_quant[i] = Quants.get(i);
            ar_type[i] = Types.get(i);
        }
        
        p.update_vang(vang_up);
        p.update_ngoc(ngoc_up);
        p.update_coin(coin_up);
        p.item.char_inventory(3);
        p.item.char_inventory(4);
        p.item.char_inventory(7);

        Service.Show_open_box_notice_item(p, "Bạn nhận được", ar_id, ar_quant, ar_type);
    }
}
