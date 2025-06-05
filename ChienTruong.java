package event_daily;

import BossHDL.BossManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import ai.LinhCanh;
import client.Player;
import core.Manager;
import core.Service;
import core.Util;
import io.Message;
import map.LeaveItemMap;
import static map.LeaveItemMap.leave_vang;
import map.Map;
import map.MapService;
import map.Mob_in_map;
import map.Vgo;
import template.ItemTemplate3;
import template.MainObject;
import template.Member_ChienTruong;

public class ChienTruong {

    private static ChienTruong instance;
    private HashMap<String, Member_ChienTruong> list;
    private List<Member_ChienTruong> BXH;
    private int status; // 0 sleep, 1 : register, 2 : start
    private int time;
    public int[] info_house;
    public List<LinhCanh> list_ai;
    public List<Mob_in_map> boss;
    public long vang;
    public long ngoc;

    public int getStatus() {
        return status;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public static ChienTruong gI() {
        if (instance == null) {
            instance = new ChienTruong();
            instance.init();
        }
        return instance;
    }

    private void init() {
        this.list = new HashMap<>();
        this.BXH = new ArrayList<>();
        this.status = 0;
        this.time = 0;
        this.vang = 0;
        this.ngoc = 0;
        list_ai = LinhCanh.init();
        this.boss = new ArrayList<>();
        //
    }

    public synchronized void update() {
        try {
            if (this.status == 1) {
                this.time--;
                if (this.time < 0) {
                    this.start();
                }
            } else if (this.status == 2) {
                this.time--;
                // event
                if (this.time == 60 * 58) {
                   for (int khu = 0; khu <= 4; khu++) {
                        BossManager.callBossToMap(61, khu, 101, 534, 513,10, 250_000_000, 50000,100000,1,1000*60*5,0);
                    }
                } else if (this.time == 60 * 50) {
                    for (int khu = 0; khu <= 4; khu++) {
                        BossManager.callBossToMap(61, khu, 101, 534, 513,10, 500_000_000, 50000,100000,1,1000*60*5,0);
                     }
                }
                //
                if (this.time <= 0) {
                    this.finish();
                }
            }
        } catch (IOException e) {
        }
    }

    private void create_boss(int i) {
        if (i == 20) {
            Mob_in_map m = null;
            for (int j = 0; j < boss.size(); j++) {
                if (boss.get(j).is_boss_active) {
                    m = boss.get(j);
                    break;
                }
            }
            if (m == null) {
                int index = Util.random(boss.size());
                if (!boss.get(index).is_boss_active && boss.get(index).level == 10) {
                    boss.get(index).level = 100;
                    boss.get(index).is_boss_active = true;
                }
                try {
                    Manager.gI().chatKTGprocess("@Server : Xà nữ xuất hiện tại chiến trường.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                for (int j = 0; j < boss.size(); j++) {
                    if (!boss.get(j).equals(m) && boss.get(j).zone_id == m.zone_id) {
                        boss.get(j).level = 100;
                        boss.get(j).is_boss_active = true;
                        break;
                    }
                }
                try {
                    Manager.gI().chatKTGprocess("@Server : Xà nữ xuất hiện tại chiến trường.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            int index = Util.random(boss.size());
            if (!boss.get(index).is_boss_active && boss.get(index).level == 10) {
                boss.get(index).level = 50;
                boss.get(index).is_boss_active = true;
            }
            try {
                Manager.gI().chatKTGprocess("@Server : Xà nữ xuất hiện tại chiến trường.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void start() throws IOException {
        if (this.status == 1) {
            Manager.gI().chatKTGprocess("Chiến trường bắt đầu");
            this.BXH.clear();
            this.status = 2;
            this.time = 60 * 60; // thời gian diễn ra
            int init_house = this.list.size() / 40;
            init_house = init_house > 0 ? init_house : 1;
            this.info_house = new int[]{init_house, init_house, init_house, init_house
            // Map.get_map_by_id(56)[0].maxzone, Map.get_map_by_id(60)[0].maxzone,
            // Map.get_map_by_id(58)[0].maxzone, Map.get_map_by_id(54)[0].maxzone
            };
            //
            List<Member_ChienTruong> list = new ArrayList<>();
            for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
                list.add(en.getValue());
            }
            Collections.shuffle(list);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).village = ((i % 4) + 2);
            }
            if (list.size() == 1) {
                list.get(0).village = Util.random(4) + 2;
            }
            if (list.size() < 4) {
                for (int i = 0; i < list.size(); i++) {
                    this.info_house[list.get(i).village - 2]++;
                }
                for (int i = 0; i < this.info_house.length; i++) {
                    this.info_house[i]--;
                }
            }
            // for (int mem : this.info_p) {
            // System.out.print(mem + " ");
            // }
            // System.out.println();
            list.clear();
            //
            byte[] id_map = new byte[]{54, 56, 58, 60};
            for (int i = 0; i < id_map.length; i++) {
                Map[] mapp = Map.get_map_by_id(id_map[i]);
                for (Map map : mapp) {
                    for (Mob_in_map mobb : map.mobs) {
                        mobb.isdie = false;
                        mobb.hp = mobb.hp_max;
                    }
                }
            }
            for (LinhCanh temp : this.list_ai) {
                temp.isdie = false;
                temp.hp = temp.hp_max;
            }
            //
            for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
                // System.out.println(en.getKey() + " " + en.getValue().village);
                Player p0 = Map.get_player_by_name(en.getKey());
                if (p0 != null) {
                    Vgo vgo = new Vgo();
                    switch (en.getValue().village) {
                        case 2: { // lang gio
                            vgo.id_map_go = 55;
                            vgo.x_new = 224;
                            vgo.y_new = 256;
                            MapService.change_flag(p0.map, p0, 2);
                            break;
                        }
                        case 3: { // lang lua
                            vgo.id_map_go = 59;
                            vgo.x_new = 240;
                            vgo.y_new = 224;
                            MapService.change_flag(p0.map, p0, 1);
                            break;
                        }
                        case 4: { // lang set
                            vgo.id_map_go = 57;
                            vgo.x_new = 264;
                            vgo.y_new = 272;
                            MapService.change_flag(p0.map, p0, 4);
                            break;
                        }
                        default: { // 5 lang anh sang
                            vgo.id_map_go = 53;
                            vgo.x_new = 276;
                            vgo.y_new = 246;
                            MapService.change_flag(p0.map, p0, 5);
                            break;
                        }
                    }
                    p0.change_map(p0, vgo);
                }
            }
        }
    }

    public synchronized void update_house_die(short id) throws IOException {
        switch (id) {
            case 89: { // nha set type 4
                if (this.info_house[2] > 0) {
                    this.info_house[2]--;
                }
                break;
            }
            case 90: { // nha gio type 2
                if (this.info_house[0] > 0) {
                    this.info_house[0]--;
                }
                break;
            }
            case 91: { // nha anh sang type 5
                if (this.info_house[3] > 0) {
                    this.info_house[3]--;
                }
                break;
            }
            case 92: { // nha lua type 3
                if (this.info_house[1] > 0) {
                    this.info_house[1]--;
                }
                break;
            }
        }
        for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
            Player p0 = Map.get_player_by_name(en.getKey());
            if (p0 != null) {
                ChienTruong.gI().send_info(p0);
            }
        }
        int dem = 4;
        for (int i = 0; i < info_house.length; i++) {
            if (info_house[i] < 0) {
                finish_house(i + 2);
                dem--;
            }
        }
        if (dem <= 1) {
            this.time = 5;
            for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
                Player p0 = Map.get_player_by_name(en.getKey());
                if (p0 != null && Map.is_map_chien_truong(p0.map.map_id)) {
                    p0.update_point_arena(100);
                    ChienTruong.gI().send_info(p0);
                    this.update_time(p0);
                }
            }
            // try {
            // this.finish();
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
        }
    }

    private void finish_house(int i) {
        try {
            List<String> list_remove = new ArrayList<>();
            for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
                if (en.getValue().village == i) {
                    list_remove.add(en.getKey());
                    Player p0 = Map.get_player_by_name(en.getKey());
                    if (p0 != null) {
                        Vgo vgo = new Vgo();
                        vgo.id_map_go = 1;
                        vgo.x_new = 432;
                        vgo.y_new = 354;
                        p0.change_map(p0, vgo);
                        MapService.change_flag(p0.map, p0, -1);
                    }
                }
            }
            list_remove.forEach(l -> {
                this.list.remove(l);
            });
            for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
                Player p0 = Map.get_player_by_name(en.getKey());
                if (p0 != null && Map.is_map_chien_truong(p0.map.map_id)) {
                    ChienTruong.gI().send_info(p0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void finish() throws IOException {
    if (this.status != 2) return;

    // Thông báo sự kiện kết thúc
    Manager.gI().chatKTGprocess("Chiến trường kết thúc");

    // Danh sách người chơi nhận thưởng
    List<Player> list_receiv = new ArrayList<>();
    for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
        Player p0 = Map.get_player_by_name(en.getKey());
        if (p0 != null && Map.is_map_chien_truong(p0.map.map_id)) {
            list_receiv.add(p0);
        }
    }

    // Tính toán phần thưởng vàng và ngọc cho mỗi người chơi
    long vang_re = this.vang / (list_receiv.size() <= 0 ? 1 : list_receiv.size());
    long ngoc_re = this.ngoc / (list_receiv.size() <= 0 ? 1 : list_receiv.size());

    // Cập nhật phần thưởng cho người chơi
    list_receiv.forEach(p -> {
        if (p.conn != null) {
            p.update_vang(vang_re);
            p.update_ngoc(ngoc_re);
            try {
                p.item.char_inventory(5);  // Cập nhật vật phẩm
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    // Xóa hết thông tin vàng và ngọc
    this.vang = 0;
    this.ngoc = 0;
    list_receiv.clear();

    // Di chuyển tất cả người chơi về bản đồ chính sau sự kiện
    for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
        Player p0 = Map.get_player_by_name(en.getKey());
        if (p0 != null) {
            Vgo vgo = new Vgo();
            vgo.id_map_go = 1;  // Bản đồ chính
            vgo.x_new = 432;    // Tọa độ điểm đến
            vgo.y_new = 354;
            p0.change_map(p0, vgo);  // Di chuyển người chơi
            MapService.change_flag(p0.map, p0, -1);  // Xóa cờ chiến trường
        }
    }

    // Dọn dẹp boss và mob trong chiến trường
    for (Mob_in_map bossMob : this.boss) {
        bossMob.level = 10;
        bossMob.hp = 0;
        bossMob.is_boss_active = false;
        bossMob.isdie = true;
    }

    // Cập nhật bảng xếp hạng
    this.BXH.clear();
    for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
        this.BXH.add(en.getValue());
    }
    this.BXH.sort(Comparator.comparingInt(o -> -o.point));  // Sắp xếp theo điểm giảm dần

    // Kết thúc sự kiện và reset trạng thái
    this.list.clear();
    this.status = 0;  // Đặt lại trạng thái sự kiện
    this.time = 0;  // Đặt lại thời gian
    this.info_house = null;
}



    public synchronized void register(Player p) throws IOException {
        if (this.list.containsKey(p.name)) {
            Service.send_notice_box(p.conn, "Đã đăng ký rồi");
        } else {
            Member_ChienTruong temp = new Member_ChienTruong();
            temp.name = p.name;
            temp.point = 0;
            temp.village = 0;
            temp.received = false;
            this.list.put(p.name, temp);
            Service.send_notice_box(p.conn, "Đăng ký thành công");
        }
    }

    public synchronized void open_register() throws IOException {
        if (this.status == 0) {
            Manager.gI().chatKTGprocess("Chiến trường mở đăng ký");
            this.status = 1;
            this.time = 60 * 5; // thời gian chờ vào map
            this.vang = 0;
            this.ngoc = 0;
        }
    }

    public void send_info(Player p) throws IOException {
        this.update_time(p);
        for (int i = 2; i < 6; i++) {
            Message m = new Message(-94);
            m.writer().writeByte(i); //
            m.writer().writeByte(this.info_house[i - 2]); // total house
            m.writer().writeShort(total_p_of_house(i)); // total p
            m.writer().writeByte(1);
            p.conn.addmsg(m);
            m.cleanup();
        }
    }

    private int total_p_of_house(int i) {
        int result = 0;
        for (Entry<String, Member_ChienTruong> en : this.list.entrySet()) {
            if (en.getValue().village == i) {
                Player p0 = Map.get_player_by_name(en.getKey());
                if (p0 != null && Map.is_map_chien_truong(p0.map.map_id)) {
                    result++;
                }
            }
        }
        return result;
    }

    private void update_time(Player p) throws IOException {
        Message m = new Message(-94);
        m.writer().writeByte(-1); //
        m.writer().writeByte(0);
        m.writer().writeShort(0);
        m.writer().writeByte(0);
        m.writer().writeLong(System.currentTimeMillis() - (60 * 60 - this.time) * 1000L);
        p.conn.addmsg(m);
        m.cleanup();
    }

    public void get_ai(Player p, int id) throws IOException {
        for (int i = 0; i < this.list_ai.size(); i++) {
            LinhCanh temp = this.list_ai.get(i);
            if (temp.id == ((short) id)) {
                Message m = new Message(5);
                m.writer().writeShort(temp.id);
                m.writer().writeUTF("Lính canh");
                m.writer().writeShort(temp.x);
                m.writer().writeShort(temp.y);
                m.writer().writeByte(1); // clazz
                m.writer().writeByte(-1);
                m.writer().writeByte(0); // head
                m.writer().writeByte(8); // eye
                m.writer().writeByte(8); // hair
                m.writer().writeShort(50); // level
                m.writer().writeInt(temp.hp); // hp
                m.writer().writeInt(temp.hp_max); // hp max
                m.writer().writeByte(0); // type
                m.writer().writeShort(0); // point pk
                m.writer().writeByte(3); // size part
                //
                byte[] part_ = new byte[]{8, 0, 1};
                for (int j = 0; j < 3; j++) {
                    m.writer().writeByte(part_[j]);
                    m.writer().writeByte(0);
                    m.writer().writeByte(3);
                    m.writer().writeShort(-1);
                    m.writer().writeShort(-1);
                    m.writer().writeShort(-1);
                    m.writer().writeShort(-1); // eff
                }
                //
                m.writer().writeShort(-1); // clan
                m.writer().writeByte(-1); // pet
                m.writer().writeByte(7);
                for (int i1 = 0; i1 < 7; i1++) {
					if (p.conn.version >= 280) {
						m.writer().writeShort(-1);
					} else {
						m.writer().writeByte(-1);
					}
				}
                //
                m.writer().writeShort(-1);
                m.writer().writeByte(-1); // type use mount
                m.writer().writeBoolean(false);
                m.writer().writeByte(1);
                m.writer().writeByte(0);
                m.writer().writeShort(-1); // mat na
                m.writer().writeByte(1); // paint mat na trc sau
                m.writer().writeShort(-1); // phi phong
                m.writer().writeShort(-1); // weapon
                m.writer().writeShort(-1);
                m.writer().writeShort(-1); // hair
                m.writer().writeShort(-1); // wing
                m.writer().writeShort(-1); // body
                m.writer().writeShort(-1); // leg
                m.writer().writeShort(-1); // bienhinh
                p.conn.addmsg(m);
                m.cleanup();
                break;
            }
        }
    }

    public Member_ChienTruong get_infor_register(String name) {
        return this.list.get(name);
    }

    public Member_ChienTruong get_bxh(String name) {
        for (int i = 0; i < this.BXH.size(); i++) {
            if (this.BXH.get(i).name.equals(name)) {
                if (i < 10) {
                    return this.BXH.get(i);
                }
            }
        }
        return null;
    }

    public int get_index_bxh(Member_ChienTruong temp) {
        return this.BXH.indexOf(temp);
    }
    
    public static void Obj_Die(Map map, MainObject mainAtk, MainObject focus)throws IOException{
        if(!mainAtk.isPlayer() || !focus.isMob())return;
        Player p = (Player)mainAtk;
        Mob_in_map mob = (Mob_in_map)focus;
        if (mob != null) {
            // roi do boss co dinh
            short[] id_item_leave3 = new short[]{};
            short[] id_item_leave4 = new short[]{};
            short[] id_item_leave7 = new short[]{};
            //short id_medal_material = -1;
            short sizeRandomMedal = 0;
            switch (mob.template.mob_id) {
                case 101: { 
                    id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 54, 53, 18};
                    id_item_leave7 = new short[]{11, 13, 2, 3, 2, 3, 14};
                    if(Util.random(100)<100)
                        id_item_leave3 = new short[]{(short) Util.ngaunhien(4577, 4584)};
                    sizeRandomMedal = (short) (50);
                    break;
                }
                // case 152: { 
                    // id_item_leave4 = new short[]{-1, -1, -1, -1, -1, -1, 54, 53, 18};
                    // id_item_leave7 = new short[]{11, 13, 2, 3, 2, 3, 14};
                    // if(Util.random(100)<20)
                        // id_item_leave3 = new short[]{(short) Util.random(4577, 4584)};
                    // sizeRandomMedal = (short) (60);
                    // break;
                // }
            }
            for (short id : id_item_leave3) {
                ItemTemplate3 temp = ItemTemplate3.item.get(id);
                LeaveItemMap.leave_item_by_type3(map, id, temp.getColor(), p, temp.getName(), mob.index);
            }
            for (int i = 0; i < 3; i++) {
                for (short id : id_item_leave4) {
                    if (id == -1) {
                        leave_vang(map, mob, p);
                    } else {
                        LeaveItemMap.leave_item_by_type4(map, id, p, mob.index,p.index);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (short id : id_item_leave7) {
                    LeaveItemMap.leave_item_by_type7(map, id, p, mob.index,p.index);
                }
            }
            for (int l = 0; l < sizeRandomMedal; l++) {
                LeaveItemMap.leave_item_by_type7(map, (short) Util.random(136, 146), p, mob.index,p.index);
            }
        }
    }
}
