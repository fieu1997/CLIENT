package map;

import History.His_DelItem;
import LeothapWeek.Boss_Leothap;
import LeothapWeek.Leothap;
import ai.MobAi;
import ai.NhanBan;
import ai.LinhCanh;
import ai.LoanDau;
import ai.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import client.Party;
import client.Pet;
import client.Player;
import client.Squire;
import core.Manager;
import core.Service;
import core.Util;
import ev_he.MobCay;
import ev_he.MobMiNuong;
import ev_he.*;
import ev_he.Farm.MobFarm;

//import event_daily.LoiDai;
import event_daily.LoiDai2;
import event_daily.UseItemArena;
import event_daily.ChienTruong;
//import event_daily.ChienTruong1;
import io.Message;
import io.Session;
import java.util.concurrent.CopyOnWriteArrayList;
import template.Item3;
import template.Item47;
import template.Item5;
import template.ItemTemplate3;
import template.ItemTemplate4;
import template.ItemTemplate7;
import template.MainObject;
import template.Mob_MoTaiNguyen;
import template.Option_pet;
import template.StrucEff;
import template.TaskTemplate;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Map implements Runnable {

    public static final List<Map[]> entrys = new ArrayList<>();
    public final List<Player> players;
    public long time_use_item_arena = System.currentTimeMillis();
    public final byte map_id;
    public final byte zone_id;
    public final ItemMap[] item_map;
    private final Thread mapthread;
    public Mob_in_map[] mobs;
    public static short head;
    public static short eye;
    public static short hair;
    public static short weapon;
    public static short body;
    public static short leg;
    public static short hat;
    public static short wing;
    public static String name_mo = "";
    public final String[] npc_name_data;
    public final String name;
    public final List<Vgo> vgos;
    public final byte typemap;
    public final boolean ismaplang;
    public final boolean showhs;
    public final short maxplayer;
    public final byte maxzone;
    private final byte[] map_data;
    private boolean running;
    public int num_mob_super;
    public Dungeon d;
    public Leothap lt; // thap
    public ThachDau td; // thap
    public ThachDau_Nb td_nb; // thap
    public static khu2 k2; // thap
    //public LoiDai ld;
    public LoiDai2 ld2;
    public short mapW;
    public short mapH;
    public long time_ct;
    public long time_chat;
    public long time_ld;
    public CopyOnWriteArrayList<MobCay> mobEvens = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<MobMiNuong> mobEvent4 = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Event_tet.MobNpc> mobnpc = new CopyOnWriteArrayList<>();

    public final CopyOnWriteArrayList<Mob_in_map> Boss_entrys = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<MobAi> Ai_entrys;
    // public CopyOnWriteArrayList<MobNpc> mobnpc = new CopyOnWriteArrayList<>();

    public UseItemArena Arena;
    ArrayList<MainObject> objects; // Khai báo biến
    public Nbxx nbxx;

    public Map(int id, int zone, String[] npc_name, String name, byte typemap, boolean ismaplang, boolean showhs,
            int maxplayer, int maxzone, List<Vgo> vgo) throws IOException {
        this.map_id = (byte) id;
        this.zone_id = (byte) zone;
        this.npc_name_data = npc_name;
        this.name = name;
        this.typemap = typemap;
        this.ismaplang = ismaplang;
        this.showhs = showhs;
        this.maxplayer = (short) maxplayer;
        this.maxzone = (byte) maxzone;
        this.item_map = new ItemMap[100];
        this.mapthread = new Thread(this);
        this.players = new ArrayList<>();
        this.vgos = vgo;
        this.running = false;
        this.num_mob_super = 0;
        this.map_data = Util.loadfile("data/mapnew/" + this.map_id);

        byte[] data = map_data; // Mảng byte chứa dữ liệu
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(data);
        java.io.DataInputStream dis = new java.io.DataInputStream(bais);

        short number = dis.readShort();
        String str = dis.readUTF();
        short num = dis.readShort();
        this.mapW = dis.readByte();
        this.mapH = dis.readByte();
        Ai_entrys = new CopyOnWriteArrayList<>();

        if (map_id == 54 || map_id == 56 || map_id == 58 || map_id == 60) {
            Arena = new UseItemArena();
        }
        objects = new ArrayList<>();
    }

    @Override
    public void run() {
        this.running = true;
        long time1 = 0;
        long time2 = 0;
        long time3 = 0;
        long lastNpcSpawnTime = System.currentTimeMillis(); // Thời gian lần cuối tạo NPC

        while (this.running) {
            try {
                time1 = System.currentTimeMillis();
                update();
                update_AI();

                if (this.time_chat < System.currentTimeMillis()) {
                    this.time_chat = System.currentTimeMillis() + 8000L;
                    auto_chat_npc();
                }
                // Chạy Time Ld
                LoanDau.update(this);

                if (Map.is_map_chiem_mo(this, true)) {
                    update_nhanban();

                }

               // update_nbxx();
                if (Manager.gI().list_nbxx != null && !Manager.gI().list_nbxx.isEmpty() && clan_null()) {
           update_nbxx();
          }

                if (this.map_id == 126) {
                    update_nbtd();
                }
                if (lt != null) {
                    update_blt();
                }

                if (this.map_id == 50) {
                    for (Player player : this.players) { // Duyệt qua tất cả người chơi trong map
                        if (player != null && player.conn != null && player.conn.connected) {
                            // Lấy danh sách MobFarm của người chơi hiện tại
                            List<MobFarm> playerMobs = Farm.playerMobFarms.get(player.index);
                            if (playerMobs != null) {
                                for (MobFarm mobFarm : playerMobs) {
                                    if (!"Hidden".equals(mobFarm.nameOwner)) { // Chỉ hiển thị Mob đã được mở khóa
                                        mobFarm.SendMob(player);
                                        mobFarm.mobMove();
                                    }
                                }
                                Farm.update_mobfarm(player); // Cập nhật trạng thái MobFarm
                            }
                        }
                    }
                }

                if (ChienTruong.gI().getStatus() == 2 && Map.is_map_chien_truong(this.map_id)) {
                    if (this.time_ct < System.currentTimeMillis()) {
                        this.time_ct = System.currentTimeMillis() + 5000L;
                        for (int i = 0; i < this.players.size(); i++) {
                            Player p0 = players.get(i);
                            ChienTruong.gI().send_info(p0);
                        }
                    }
                    LinhCanh.update(this);
                }

                if (this.map_id == 48 && d != null) {
                    d.update();
                }

                if (this.map_id == 46 && lt != null) {
                    for (int i = 0; i < this.players.size(); i++) {
                        Player p0 = players.get(i);
                        lt.update(p0);
                    }
                }
                if (this.map_id == 125 && td != null) {
                    for (int i = 0; i < this.players.size(); i++) {
                        Player p0 = players.get(i);
                        td.Update();
                    }
                }

                time2 = System.currentTimeMillis();
                time3 = (1_000L - (time2 - time1));
                if (time3 > 0) {
                    if (time3 < 20) {
                        System.err.println("map_id " + this.map_id + " - zone " + (this.zone_id + 1) + " overload...");
                    }
                    Thread.sleep(time3);
                }
            } catch (InterruptedException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void auto_chat_npc() {
        try {
            switch (this.map_id) {
                case 4: {
                    Npc.chat(this, Npc.CHAT_MR_BALLARD, -53);
                    break;
                }
                case 1: {
                    Npc.chat(this, Npc.CHAT_TOP, -49);
                    Npc.chat(this, Npc.CHAT_PHO_CHI_HUY, -37);
                    Npc.chat(this, Npc.CHAT_PHAP_SU, -36);
                    Npc.chat(this, Npc.CHAT_ZORO, -2);
                    Npc.chat(this, Npc.CHAT_AMAN, -7);
                    Npc.chat(this, Npc.CHAT_ODA, -81);
                    Npc.chat(this, Npc.CHAT_LISA, -3);
                    Npc.chat(this, Npc.CHAT_SOPHIA, -69);
                    Npc.chat(this, Npc.CHAT_HAMMER, -5);
                    Npc.chat(this, Npc.CHAT_ZULU, -8);
                    Npc.chat(this, Npc.CHAT_DOUBA, -4);
                    Npc.chat(this, Npc.CHAT_ANNA, -44);
                    Npc.chat(this, Npc.CHAT_BXH, -49);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isMapChiemThanh() {
        return map_id >= 83 && map_id <= 87;
    }

    public boolean isMapLoiDai() {
        return map_id == 100 && map_id == 102;
    }

    public void BossDie(Mob_in_map mob) {
        mob.isdie = true;
        mob.time_back = System.currentTimeMillis() + mob.timeBossRecive;
        synchronized (Boss_entrys) {
            Boss_entrys.remove(mob);
        }
    }

    public void BossIn4(Session conn, int idx) throws IOException {
        for (Mob_in_map temp : Boss_entrys) {
            if (temp.index == idx) {
                Message m = new Message(7);
                m.writer().writeShort(idx);
                m.writer().writeByte((byte) temp.level);
                m.writer().writeShort(temp.x);
                m.writer().writeShort(temp.y);
                m.writer().writeInt(temp.hp);
                m.writer().writeInt(temp.get_HpMax());
                m.writer().writeByte(20); // id skill monster (Spec: 32, ...)
                m.writer().writeInt(temp.timeBossRecive / 1000);
                m.writer().writeShort(-1); // clan monster
                m.writer().writeByte(0);
                m.writer().writeByte(2); // speed
                m.writer().writeByte(0);
                m.writer().writeUTF("");
                m.writer().writeLong(-11111);
                m.writer().writeByte(temp.color_name); // color name 1: blue, 2: yellow
                conn.addmsg(m);
                m.cleanup();
                return;
            }
        }
        Message m2 = new Message(17);
        m2.writer().writeShort(-1);
        m2.writer().writeShort(idx);
        conn.addmsg(m2);
        m2.cleanup();
    }

    public Mob_in_map GetBoss(int index) {
        for (Mob_in_map mob : Boss_entrys) {
            if (mob.index == index) {
                return mob;
            }
        }
        return null;
    }

    private void update_AI() {

    }

    private synchronized void update_nhanban() throws IOException {
        // update mo tai nguyen
        Mob_MoTaiNguyen mobtainguyen = Manager.gI().chiem_mo.get_mob_in_map(this);
        if (mobtainguyen != null) {
            if (mobtainguyen.hp <= 0) {
                mobtainguyen.Set_hpMax((mobtainguyen.get_HpMax() / 10) * 12);
                if (mobtainguyen.get_HpMax() > 20_000_000) {
                    mobtainguyen.Set_hpMax(20_000_000);
                }
                mobtainguyen.hp = mobtainguyen.get_HpMax();
                mobtainguyen.isbuff_hp = false;
            }
            if (!mobtainguyen.isbuff_hp && mobtainguyen.hp < mobtainguyen.get_HpMax() / 2) {
                mobtainguyen.Set_hpMax((mobtainguyen.get_HpMax() / 10) * 12);
                if (mobtainguyen.get_HpMax() > 20_000_000) {
                    mobtainguyen.Set_hpMax(20_000_000);
                }
                mobtainguyen.isbuff_hp = true;
            }
            if (mobtainguyen.isbuff_hp && mobtainguyen.time_buff < System.currentTimeMillis()) {
                mobtainguyen.time_buff = System.currentTimeMillis() + 2500L;
                int par = mobtainguyen.get_HpMax() / 20;
                mobtainguyen.hp += par;
                if (mobtainguyen.hp > mobtainguyen.get_HpMax()) {
                    mobtainguyen.hp = mobtainguyen.get_HpMax();
                    mobtainguyen.isbuff_hp = false;
                }
                Message m_hp = new Message(32);
                m_hp.writer().writeByte(1);
                m_hp.writer().writeShort(mobtainguyen.index);
                m_hp.writer().writeShort(-1); // id potion in bag
                m_hp.writer().writeByte(0);
                m_hp.writer().writeInt(mobtainguyen.get_HpMax()); // max hp
                m_hp.writer().writeInt(mobtainguyen.hp); // hp
                m_hp.writer().writeInt(par); // param use
                for (int i = 0; i < this.players.size(); i++) {
                    this.players.get(i).conn.addmsg(m_hp);
                }
                m_hp.cleanup();
            }
        }
        //
        NhanBan temp = null;
        for (int i = 0; i < Manager.gI().list_nhanban.size(); i++) {
            if (Manager.gI().list_nhanban.get(i).map_id == this.map_id) {
                temp = Manager.gI().list_nhanban.get(i);
                break;
            }
        }
        if (temp != null) {
            if (temp.time_hp_buff < System.currentTimeMillis()) {
                temp.time_hp_buff = System.currentTimeMillis() + 2500L;
                if (temp.hp < temp.get_HpMax()) {
                    int par = temp.get_HpMax() / 20;
                    temp.hp += par;
                    if (temp.hp > temp.get_HpMax()) {
                        temp.hp = temp.get_HpMax();
                    }
                    Message m_hp = new Message(32);
                    m_hp.writer().writeByte(0);
                    m_hp.writer().writeShort(temp.index);
                    m_hp.writer().writeShort(-1); // id potion in bag
                    m_hp.writer().writeByte(0);
                    m_hp.writer().writeInt(temp.get_HpMax()); // max hp
                    m_hp.writer().writeInt(temp.hp); // hp
                    m_hp.writer().writeInt(par); // param use
                    for (int i = 0; i < this.players.size(); i++) {
                        this.players.get(i).conn.addmsg(m_hp);
                    }
                    m_hp.cleanup();
                }
            }
            if (temp.is_move && temp.act_time < System.currentTimeMillis()) {
                temp.act_time = System.currentTimeMillis() + 2000L;
                int[] x_ = new int[]{444, 1068, 228, 804, 516, 684, 540, 612, 1020, 444, 228, 612, 540, 492, 492, 756};
                int[] y_ = new int[]{156, 348, 516, 972, 372, 588, 588, 204, 204, 108, 372, 708, 396, 612, 420, 300};
                int[] map_ = new int[]{3, 5, 8, 9, 11, 12, 15, 16, 19, 21, 22, 24, 26, 27, 37, 42};
                for (int i = 0; i < map_.length; i++) {
                    if (map_[i] == temp.map_id) {
                        int x_old = temp.x;
                        int y_old = temp.y;
                        temp.x = (short) Util.random(x_[i] - 50, x_[i] + 50);
                        temp.y = (short) Util.random(y_[i] - 50, y_[i] + 50);
                        double a = Math.sqrt(Math.pow((x_old - temp.x), 2) + Math.pow((y_old - temp.y), 2));
                        if (a < 50) {
                            temp.x = (short) x_old;
                            temp.y = (short) y_old;
                        }
                        break;
                    }
                }
                Message m12 = new Message(4);
                m12.writer().writeByte(0);
                m12.writer().writeShort(0);
                m12.writer().writeShort(temp.index);
                m12.writer().writeShort(temp.x);
                m12.writer().writeShort(temp.y);
                m12.writer().writeByte(-1);
                for (int i = 0; i < this.players.size(); i++) {
                    Player p0 = this.players.get(i);
                    if (p0.map.map_id == this.map_id) {
                        p0.conn.addmsg(m12);
                    }
                }
                m12.cleanup();
            } else if (temp.p_target != null) {
                if (temp.p_target.conn.connected && temp.p_target.map.map_id == temp.map_id
                        && temp.p_target.map.zone_id == 4
                        && (Math.abs(temp.x - temp.p_target.x) < 200 && Math.abs(temp.y - temp.p_target.y) < 200)
                        && !temp.p_target.isdie) {
                    MainObject.MainAttack(this, temp, temp.p_target, Util.random(new int[]{0, 1, 2, 5, 6, 9, 10, 13, 14, 18}), null, 2);

                } else {
                    temp.p_target = null;
                    temp.is_move = true;
                }
            }

            // Check for nearby players to attack
            for (Player p : this.players) {
                if (p.conn.connected && p.map.map_id == temp.map_id && !p.isdie
                        && Math.abs(temp.x - p.x) < 200 && Math.abs(temp.y - p.y) < 200) {
                    // Check if player is in a different clan
                    if (!(p instanceof Squire)) {
                        if (p.myclan != null && !p.myclan.name_clan.equals(temp.clan_name)) { // Compare clan names
                            // Attack the player
                            temp.p_target = p;
                            MainObject.MainAttack(this, temp, temp.p_target,
                                    Util.random(new int[]{0, 1, 2, 5, 6, 9, 10, 13, 14, 18}), null, 2);
                            break; // Only attack one player at a time
                        }
                    }
                }
            }
        }
    }

    private void update() {
        try {
            long _timec = System.currentTimeMillis();
            if (this.map_id >= 53 && this.map_id <= 60 && this.map_id % 2 == 1 && !vgos.isEmpty()) {
                Vgo v = vgos.get(0);
                for (int i1 = players.size() - 1; i1 >= 0 && v != null; i1--) {
                    Player p1 = players.get(i1);
                    if (p1 != null && _timec - p1.timeCantChangeMap > 15_000) {
                        p1.change_map(p1, v);
                    }
                }
            }

            //<editor-fold defaultstate="collapsed" desc="update Player       ...">  
            for (int i1 = players.size() - 1; i1 >= 0; i1--) {
                try {
                    Player p = players.get(i1);
                    if (p == null || p.conn == null || p.conn.socket == null || p.conn.socket.isClosed() || !p.conn.connected) {
                        players.remove(p);
                        if (p != null && p.conn != null) {
                            p.conn.close();
                        }
                        continue;
                    }
                    if (p != null && p.get_EffMe_Kham(StrucEff.TangHinh) != null) {
                        continue;
                    } else if (p != null && p.isTangHinh && p.get_EffMe_Kham(StrucEff.TangHinh) == null) {
                        p.isTangHinh = false;
                        //MapService.update_in4_2_other_inside(p.map, p);
                        Message m6 = new Message(4);
                        m6.writer().writeByte(0);
                        m6.writer().writeShort(0);
                        m6.writer().writeShort(p.index);
                        m6.writer().writeShort(p.x);
                        m6.writer().writeShort(p.y);
                        m6.writer().writeByte(-1);
                        MapService.send_msg_player_inside(p.map, p, m6, true);
                        m6.cleanup();
                    }

                    if (this.map_id == 50) { // pet_manager
                        long now_time = System.currentTimeMillis();
                        for (Pet temp : p.mypet) {
                            if (temp.expiry_date != 0 && temp.expiry_date < now_time) {
                                if (temp.is_follow) {
                                    p.pet_follow = -1;
                                }
                                p.mypet.remove(temp);
                                Service.send_wear(p);
                                Service.send_char_main_in4(p);
                                continue;
                            }
                            if (temp.is_hatch && temp.time_born < now_time) {
                                temp.is_hatch = false;
                                //
                                Message m = new Message(44);
                                //
                                m.writer().writeByte(28);
                                m.writer().writeByte(0);
                                m.writer().writeByte(3);
                                m.writer().writeByte(3);
                                int dem = 0;
                                for (Pet temp2 : p.mypet) {
                                    if (temp.is_hatch && temp2.time_born > now_time) {
                                        dem++;
                                    }
                                }
                                m.writer().writeByte(dem);
                                for (Pet temp2 : p.mypet) {
                                    if (temp.is_hatch && temp2.time_born > now_time) {
                                        int id_ = temp.get_id();
                                        m.writer().writeUTF(ItemTemplate3.item.get(id_).getName());
                                        m.writer().writeByte(4); // clazz
                                        m.writer().writeShort(id_);
                                        m.writer().writeByte(14); // type
                                        m.writer().writeShort(ItemTemplate3.item.get(id_).getIcon());
                                        m.writer().writeByte(0); // tier
                                        m.writer().writeShort(10); // level
                                        m.writer().writeByte(5); // color
                                        m.writer().writeByte(1);
                                        m.writer().writeByte(1);
                                        m.writer().writeByte(0); // op size
                                        long time2 = ((temp2.time_born - now_time) / 60000) + 1;
                                        m.writer().writeInt((int) time2);
                                        m.writer().writeByte(0);
                                    }
                                }
                                p.conn.addmsg(m);
                                m.cleanup();
                                //
                                m = new Message(44);
                                m.writer().writeByte(28);
                                m.writer().writeByte(1);
                                m.writer().writeByte(9);
                                m.writer().writeByte(9);
                                m.writer().writeUTF(temp.name);
                                m.writer().writeByte(temp.type);
                                m.writer().writeShort(p.mypet.indexOf(temp)); // id
                                m.writer().writeShort(temp.level);
                                m.writer().writeShort(temp.getlevelpercent()); // exp
                                m.writer().writeByte(temp.type);
                                m.writer().writeByte(temp.icon);
                                m.writer().writeByte(temp.nframe);
                                m.writer().writeByte(temp.color);
                                m.writer().writeInt(temp.get_age());
                                m.writer().writeShort(temp.grown);
                                m.writer().writeShort(temp.maxgrown);
                                m.writer().writeShort(temp.point1);
                                m.writer().writeShort(temp.point2);
                                m.writer().writeShort(temp.point3);
                                m.writer().writeShort(temp.point4);
                                m.writer().writeShort(temp.maxpoint);
                                m.writer().writeByte(temp.op.size());
                                for (int i2 = 0; i2 < temp.op.size(); i2++) {
                                    Option_pet temp2 = temp.op.get(i2);
                                    m.writer().writeByte(temp2.id);
                                    m.writer().writeInt(temp2.param);
                                    m.writer().writeInt(temp2.maxdam);
                                }
                                p.conn.addmsg(m);
                                m.cleanup();
                            }
                        }
                    }
                    if (p.squire != null && !p.isSquire) {
                        Squire.update(p);
                    }

                    /*if (p != null && p.squire != null && p.isLiveSquire) {
                        p.squire.autoAttack();
                    }*/
                    p.update_wings_time();
                    for (Pet pet : p.mypet) {
                        if (pet.grown > 0 && pet.time_eat < System.currentTimeMillis()) {
                            pet.time_eat = System.currentTimeMillis() + 180_000L;
                            pet.grown -= 1;
                            if (pet.is_follow) {
                                //                            Service.send_wear(p);
                            }
                        }
                    }
                    p.updateEff();
                    if (!p.isdie) {

                        // auto +hp,mp
                        p.update(this);
                        if (p.squire != null && p.squire.hp > 0 && p.isLiveSquire) {
                            p.squire.update(this);
                        }

                        // auto trừ hp, mp khi dính bỏng lửa, bỏng lạnh
                        // eff medal
                        Item3 it = p.item.wear[12];

                        if (it != null && it.tier >= 3 && p.time_eff_medal < System.currentTimeMillis()) {

                            p.time_eff_medal = System.currentTimeMillis() + 5_000L;
                            Message m = new Message(-49);
                            m.writer().writeByte(2);
                            m.writer().writeShort(0);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            if (p != null && !p.iseffMedal && it.id >= 4587 && it.id <= 4590) {
                                //Service.send_notice_box(p.conn, "Test");
                                return;
                            }
                            switch (it.id) {

                                case 4588: {
                                    byte eff_ = 0;

                                    if (it.tier >= 30) {
                                        eff_ = 82;
                                    } else if (it.tier >= 20) {
                                        eff_ = 81;
                                    } else if (it.tier == 15) {
                                        eff_ = 26;
                                    } else if (it.tier >= 12) {
                                        eff_ = 25;
                                    } else if (it.tier >= 9) {
                                        eff_ = 2;
                                    } else if (it.tier >= 6) {
                                        eff_ = 1;
                                    } else if (it.tier >= 3) {
                                        eff_ = 0;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                                case 4589: {
                                    byte eff_ = 9;
                                    if (it.tier >= 30) {
                                        eff_ = 82;
                                    } else if (it.tier >= 20) {
                                        eff_ = 81;
                                    } else if (it.tier == 15) {
                                        eff_ = 28;
                                    } else if (it.tier >= 12) {
                                        eff_ = 27;
                                    } else if (it.tier >= 9) {
                                        eff_ = 11;
                                    } else if (it.tier >= 6) {
                                        eff_ = 10;
                                    } else if (it.tier >= 3) {
                                        eff_ = 9;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                                case 4590: {
                                    byte eff_ = 6;
                                    if (it.tier >= 30) {
                                        eff_ = 82;
                                    } else if (it.tier >= 20) {
                                        eff_ = 81;
                                    } else if (it.tier == 15) {
                                        eff_ = 32;
                                    } else if (it.tier >= 12) {
                                        eff_ = 31;
                                    } else if (it.tier >= 9) {
                                        eff_ = 8;
                                    } else if (it.tier >= 6) {
                                        eff_ = 7;
                                    } else if (it.tier >= 3) {
                                        eff_ = 6;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                                default: { // 4587
                                    byte eff_ = 3;
                                    if (it.tier >= 30) {
                                        eff_ = 82;
                                    } else if (it.tier >= 20) {
                                        eff_ = 81;
                                    } else if (it.tier >= 15) {
                                        eff_ = 30;
                                    } else if (it.tier >= 12) {
                                        eff_ = 29;
                                    } else if (it.tier >= 9) {
                                        eff_ = 5;
                                    } else if (it.tier >= 6) {
                                        eff_ = 4;
                                    } else if (it.tier >= 3) {
                                        eff_ = 3;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                            }
                            m.writer().writeShort(p.index);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            m.writer().writeInt(10000);
                            MapService.send_msg_player_inside(this, p, m, true);
                            m.cleanup();
                        }

                        /*
                        // eff siêu nhân
                       it = p.item.wear[20];
                        if (it != null && p.time_eff_wear < System.currentTimeMillis()) {
                            p.time_eff_wear = System.currentTimeMillis() + 5000L;
                            Message m = new Message(-49);
                            m.writer().writeByte(2);
                            m.writer().writeShort(0);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            switch (it.id) {

                                case 4784: {
                                    byte eff_ = (65);
                                    
                                    if (it.tier == 15) {
                                        
                                        eff_ = 65;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                                case 4785: {
                                    byte eff_ = 66;
                                    if (it.tier == 15) {
                                        eff_ = 66;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                                case 4786: {
                                    byte eff_ = 64;
                                    if (it.tier == 15) {
                                        eff_ = 64;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                                case 4787: {
                                    byte eff_ = 63;
                                    if (it.tier == 15) {
                                        eff_ = 63;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                                default: {
                                    byte eff_ = 51;
                                    if (it.tier == 15) {
                                        eff_ = 51;
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }
                            }
                            m.writer().writeShort(p.index);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            m.writer().writeInt(5000);
                            MapService.send_msg_player_inside(this, p, m, true);
                            m.cleanup();

                        }
                         */
 /*
                        if (p.fusion == 1 && p.time_eff_fusion < System.currentTimeMillis()) {
                            p.time_eff_fusion = System.currentTimeMillis() + 5000L;
                            Message m = new Message(-49);
                            m.writer().writeByte(2); //loại
                            m.writer().writeShort(0);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);

                            m.writer().writeByte(62);
                            m.writer().writeShort(p.index);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            m.writer().writeInt(5000);

                            MapService.send_msg_player_inside(p.map, p, m, true);
                            m.cleanup();
                        }*/
                        //eff tu tieen
                        int tutien = p.get_tutien();
                        if (tutien >= 0 && p.time_eff_21 < System.currentTimeMillis()) {

                            p.time_eff_21 = System.currentTimeMillis() + 5000L;
                            Message m = new Message(-49);
                            m.writer().writeByte(2);
                            m.writer().writeShort(0);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            switch (tutien) {

                                case 4: {
                                    m.writer().writeByte(78);
                                    break;
                                }
                                case 5:
                                case 6:
                                case 7:
                                case 8: {
                                    m.writer().writeByte(79);
                                    break;
                                }
                                case 9:
                                case 10:
                                case 11:
                                case 12: {
                                    m.writer().writeByte(80);
                                    break;
                                }

                            }
                            m.writer().writeShort(p.index);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            m.writer().writeInt(5000);
                            MapService.send_msg_player_inside(this, p, m, true);
                            m.cleanup();

                        }
                        // kim sắc long bảo
                        // it = p.item.wear[21];
                        // if (it != null && p.time_eff_wear < System.currentTimeMillis()) {

                        // p.time_eff_wear = System.currentTimeMillis() + 5000L;
                        // Message m = new Message(-49);
                        // m.writer().writeByte(2);
                        // m.writer().writeShort(0);
                        // m.writer().writeByte(0);
                        // m.writer().writeByte(0);
                        // switch (it.id) {
                        // case 4812: {
                        // byte eff_ = (77);
                        // if (it.tier == 15) {
                        // eff_ = 77;
                        // }
                        // m.writer().writeByte(eff_);
                        // break;
                        // }
                        // }
                        // m.writer().writeShort(p.index);
                        // m.writer().writeByte(0);
                        // m.writer().writeByte(0);
                        // m.writer().writeInt(5000);
                        // MapService.send_msg_player_inside(this, p, m, true);
                        // m.cleanup();
                        // }
                        /*it = p.item.wear[22];
                        if (it != null && p.time_eff_22 < System.currentTimeMillis()) {

                            p.time_eff_22 = System.currentTimeMillis() + 6000L;
                            Message m = new Message(-49);
                            m.writer().writeByte(2);
                            m.writer().writeShort(0);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            switch (it.id) {

                                case 4813: {
                                    byte eff_ = (47);

                                    if (it.tier == 15) {

                                        eff_ = (47);
                                    }
                                    m.writer().writeByte(eff_);
                                    break;
                                }

                            }
                            m.writer().writeShort(p.index);
                            m.writer().writeByte(0);
                            m.writer().writeByte(0);
                            m.writer().writeInt(5000);
                            MapService.send_msg_player_inside(this, p, m, true);
                            m.cleanup();

                        }*/
                        it = p.item.wear[22];
                        if (it != null) {

                            // Tính toán thời gian hiệu ứng mới
                            p.time_eff_22 = System.currentTimeMillis() + 6000L;
                            
                            switch (it.id) {

                                case 4813: {
                                    Map.send_eff_vip(p, 37);
                                    break;
                                }
                            }
                        }

                        int vip = p.conn.vip;
                        if (vip > 0) {
                            p.time_eff_vip = System.currentTimeMillis() + 6000L;
                            switch (vip) {
                                case 1: {
                                    Map.send_eff_vip(p, 83);
                                    break;
                                }
                                case 2: {
                                    Map.send_eff_vip(p, 84);
                                    break;
                                }
                                case 3: {
                                    Map.send_eff_vip(p, 85);
                                    break;
                                }
                                case 4: {
                                    Map.send_eff_vip(p, 86);
                                    break;
                                }
                                case 5: {
                                    Map.send_eff_vip(p, 87);
                                    break;
                                }
                                case 6: {
                                    Map.send_eff_vip(p, 88);
                                    break;
                                }
                                case 7: {
                                    Map.send_eff_vip(p, 89);
                                    break;
                                }
                                case 8: {
                                    Map.send_eff_vip(p, 90);
                                    break;
                                }
                                case 9: {
                                    Map.send_eff_vip(p, 91);
                                    break;
                                }
                            }

                        }

                        //
                        if (p.item.total_item_by_id(3, 4820) > 0) {// sao vang
                            Map.Sen_eff_111(p, (byte) 72);
                        } else if (p.item.total_item_by_id(3, 4821) > 0) {// sao do
                            Map.Sen_eff_111(p, (byte) 73);
                        } else if (p.item.total_item_by_id(3, 4822) > 0) { // hoa dang
                            Map.Sen_eff_111(p, (byte) 81);
                        } else if (p.item.total_item_by_id(3, 4823) > 0) { // cá chep
                            Map.Sen_eff_111(p, (byte) 82);
                        } else if (p.item.total_item_by_id(3, 4824) > 0) {// buom bướm
                            Map.Sen_eff_111(p, (byte) 83);
                        } else if (p.item.total_item_by_id(3, 4825) > 0) {// mat trang
                            Map.Sen_eff_111(p, (byte) 84);
                        } else if (p.item.total_item_by_id(3, 4826) > 0) { // hh lôi dai
                            Map.Sen_eff_111(p, (byte) 98);
                        }
                        Fusion fusion = new Fusion();
                        boolean[] status = Fusion.getFusionStatus(p);
                        boolean Fusion = status[0];
                        if (Fusion == true) {
                            Message mm = new Message(75);
                mm.writer().writeByte(1);// id hiệu ứng
                mm.writer().writeByte(0);
                mm.writer().writeShort(p.index);
                mm.writer().writeShort(-1);
                mm.writer().writeByte(0);
                mm.writer().writeShort(p.index);
                for (int i = 0; i < p.map.players.size(); i++) {
                    p.map.players.get(i).conn.addmsg(mm);
                }
                mm.cleanup();
                        }
                        // Service.send_char_main_in4(p);
                        //

                    }
                } catch (Exception eee) {
                }

            }
            //</editor-fold>   update player 

            // mob
            //<editor-fold defaultstate="collapsed" desc="update mob, boss      ...">  
            for (Mob_in_map mob : this.mobs) {
                if ((mob.isdie && mob.template.mob_id >= 89 && mob.template.mob_id <= 92
                        && mob.time_back < System.currentTimeMillis())) {

                    Message m2 = new Message(17);
                    m2.writer().writeShort(-1);
                    m2.writer().writeShort(mob.index);
                    for (int i = 0; i < this.players.size(); i++) {
                        Player p0 = this.players.get(i);
                        p0.conn.addmsg(m2);
                    }
                    m2.cleanup();
                } else { // Only update other mobs
                    mob.update(this);
                }
            }
            for (Mob_in_map mob : this.Boss_entrys) {
                // mob fire
                mob.update(this);
            }
            //</editor-fold>    update mob, boss

        } catch (IOException e) {
            e.printStackTrace();
        }
        // update item map
        for (int i = 0; i < this.item_map.length; i++) {
            if (this.item_map[i] != null && this.item_map[i].idmaster != -1
                    && ((this.item_map[i].time_exist - System.currentTimeMillis()) < 15000L)) {
                this.item_map[i].idmaster = -1;
            }
            if (this.item_map[i] != null && this.item_map[i].time_exist < System.currentTimeMillis()) {
                this.item_map[i] = null;
            }
        }
    }

    public void start_map() {
        this.mapthread.start();
    }

    public void stop_map() {
        this.running = false;
        this.mapthread.interrupt();
    }

    public static Player get_player_by_name(String name) {
        for (Map[] maps : entrys) {
            for (Map map : maps) {
                for (Player p0 : map.players) {
                    if (p0.name.equals(name)) {
                        return p0;
                    }

                }
            }
        }
        return null;
    }

    public static Map[] get_map_by_id(int id) {
        for (Map[] temp : entrys) {
            if (temp[0].map_id == id) {
                return temp;
            }
        }
        return null;
    }

    public static byte[] modifyNpcData(byte[] data, int npcId, int newX, int newY, int newIcon) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);

        try {
            while (dis.available() > 0) {
                byte id = dis.readByte(); // Đọc ID NPC
                dos.writeByte(id);

                if (id == npcId) { // Nếu là NPC cần sửa
                    dis.readByte(); // Bỏ qua icon cũ
                    dos.writeByte(newIcon); // Cập nhật icon mới

                    dis.readShort(); // Bỏ qua X cũ
                    dis.readShort(); // Bỏ qua Y cũ
                    dos.writeShort(newX); // X mới
                    dos.writeShort(newY); // Y mới

                    while (dis.available() > 0) { // Ghi lại phần còn lại
                        dos.writeByte(dis.readByte());
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    public void send_map_data(Player p) throws IOException {
        if (p.x / 24 >= mapW || p.y / 24 >= mapH || p.x < 0 || p.y < 0) {
            Vgo vgo = new Vgo();
            vgo.id_map_go = 1;
            vgo.x_new = 432;
            vgo.y_new = 354;
            p.change_map(p, vgo);
            return;
        }
        Message m = new Message(12);
        m.writer().writeShort(this.map_id);
        m.writer().writeShort((short) (p.x / 24));
        m.writer().writeShort((short) (p.y / 24));
        m.writer().write(this.map_data);
        m.writer().writeByte(this.zone_id); // zone
        m.writer().writeByte(this.typemap);
        if (!(p.conn.ac_admin > 10)) {
            m.writer().writeBoolean(this.ismaplang);
        }
        m.writer().writeBoolean(this.showhs);
        p.conn.addmsg(m);
        m.cleanup();
        // send npc;
        String path = "data/npc/";
        if (Manager.gI().event == 1 && this.map_id == 1) {
            path = "data/npc/event" + Manager.gI().event + "/";
            Service.send_msg_data(p.conn, -49, "event1_1");
        }
        /* for (int i = 0; i < this.npc_name_data.length; i++) {
            m = new Message(-50);
            m.writer().write(Util.loadfile(path + this.npc_name_data[i]));
            p.conn.addmsg(m);
            m.cleanup();
        }*/
        for (int i = 0; i < this.npc_name_data.length; i++) {
            byte[] npcData = Util.loadfile(path + this.npc_name_data[i]); // Đọc file NPC

            if (npcData != null && npcData.length > 10) {  // Kiểm tra dữ liệu hợp lệ
                if (Manager.gI().event == 5 && this.map_id == 1) {
                    npcData = modifyNpcData(npcData, -32, 688, 429, 12); // Di chuyển NPC (-32) đến (500,600) và đổi icon thành 99
                    npcData = modifyNpcData(npcData, -10, 486, 432, 8); // Di chuyển NPC (-32) đến (500,600) và đổi icon thành 99

                }
            }

            m = new Message(-50);
            m.writer().write(npcData);
            p.conn.addmsg(m);
            m.cleanup();
        }

        // mob mo tai nguyen
        if (Map.is_map_chiem_mo(p.map, true)) {
            Mob_MoTaiNguyen mob_tainguyen = Manager.gI().chiem_mo.get_mob_in_map(p.map);
            m = new Message(4);
            m.writer().writeByte(1);
            m.writer().writeShort(64);
            m.writer().writeShort(mob_tainguyen.index);
            m.writer().writeShort(mob_tainguyen.x);
            m.writer().writeShort(mob_tainguyen.y);
            m.writer().writeByte(-1);
            if (mob_tainguyen.nhanban != null) {
                m.writer().writeByte(0);
                m.writer().writeShort(0);
                m.writer().writeShort(mob_tainguyen.nhanban.index);
                m.writer().writeShort(mob_tainguyen.nhanban.x);
                m.writer().writeShort(mob_tainguyen.nhanban.y);
                m.writer().writeByte(-1);
            }
            p.conn.addmsg(m);
            m.cleanup();

        }
        if (this.map_id == 52 && this.zone_id == this.maxzone) {
            m = new Message(-50);
            m.writer().writeByte(1);
            m.writer().writeUTF("Mr Dylan");
            m.writer().writeUTF("Mua bán");
            m.writer().writeByte(-57);
            m.writer().writeByte(34);
            m.writer().writeShort(384);
            m.writer().writeShort(432);
            m.writer().writeByte(1);
            m.writer().writeByte(1);
            m.writer().writeByte(2);
            m.writer().writeByte(26);
            m.writer().writeUTF("Ta chuyên bán các loại hàng hóa phục vụ cho việc đi buôn. Hân hạnh phục vụ quý khách");
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
        }
        // npc ad
        // if (this.map_id == 1 && p.conn.ac_admin > 10) {
        // m = new Message(-50);
        // m.writer().writeByte(1);
        // m.writer().writeUTF("ADMin");
        // m.writer().writeUTF("Giao Tiếp");
        // m.writer().writeByte(127);// id npc
        // m.writer().writeByte(50);   // icon 
        // m.writer().writeShort(690); // x
        // m.writer().writeShort(360); // y
        // m.writer().writeByte(1);
        // m.writer().writeByte(1);
        // m.writer().writeByte(2);
        // m.writer().writeByte(42); // icon 2
        // m.writer().writeUTF("Ta là Admin mi muốn gì");
        // m.writer().writeByte(1);
        // m.writer().writeByte(0);
        // p.conn.addmsg(m);
        // m.cleanup();
        // }
        sNPC(p);

        // npc ad
        if (this.map_id == 1) {
            m = new Message(-50);
            m.writer().writeByte(1);
            m.writer().writeUTF("Tiểu Long");
            m.writer().writeUTF("Giao Tiếp");
            m.writer().writeByte(-11);// id npc
            m.writer().writeByte(50);   // icon 
            m.writer().writeShort(750); // x
            m.writer().writeShort(444); // y
            m.writer().writeByte(1);
            m.writer().writeByte(1);
            m.writer().writeByte(2);
            m.writer().writeByte(42); // icon 2
            m.writer().writeUTF("Ta Là Tiểu Long, Bạn cần gì ở Tôi");
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
        }

        // npc tu tiên
        if (this.map_id == 2) {
            m = new Message(-50);
            m.writer().writeByte(1);
            m.writer().writeUTF("Tiểu Tiên Nữ");
            m.writer().writeUTF("Giao Tiếp");
            m.writer().writeByte(-12);// id npc
            m.writer().writeByte(52);   // icon 
            m.writer().writeShort(312); // x
            m.writer().writeShort(456); // y
            m.writer().writeByte(1);
            m.writer().writeByte(1);
            m.writer().writeByte(2);
            m.writer().writeByte(43); // icon 2
            m.writer().writeUTF("Con Đường tu tiên thật gian nan haizz.Cố lên tràng trai trẻ");
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
        }

        // npc tinh tú
      /*  if (this.map_id == 3) {
            m = new Message(-50);
            m.writer().writeByte(1);
            m.writer().writeUTF("Tinh Tú");
            m.writer().writeUTF("Giao Tiếp");
            m.writer().writeByte(-92);// id npc
            m.writer().writeByte(20);   // icon 
            m.writer().writeShort(158); // x
            m.writer().writeShort(333); // y
            m.writer().writeByte(1);
            m.writer().writeByte(1);
            m.writer().writeByte(2);
            m.writer().writeByte(18); // icon 2
            m.writer().writeUTF("Tích cực Quay tay Vận may sẽ tới...");
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
        }*/

        // monument
        if (this.map_id == 1) {
            m = new Message(-96);
            m.writer().writeShort(288);
            m.writer().writeShort(312);
            m.writer().writeShort(264);
            m.writer().writeShort(288);
            m.writer().writeByte(3);
            m.writer().writeByte(1);
            m.writer().writeByte(-1);
            m.writer().writeByte(-25);
            m.writer().writeByte(1);
            m.writer().writeUTF("Top Level");
            m.writer().writeUTF(Map.name_mo);
            m.writer().writeByte(-49);
            m.writer().writeByte(15);
            //
            m.writer().writeShort(Map.weapon); // weapon
            m.writer().writeShort(Map.body); // body
            m.writer().writeShort(-1);
            m.writer().writeShort(-1);
            m.writer().writeShort(-1);
            m.writer().writeShort(3); // pet
            m.writer().writeShort(Map.hat); // hat
            m.writer().writeShort(Map.leg); // leg
            m.writer().writeShort(-1);
            m.writer().writeShort(-1);
            m.writer().writeShort(Map.wing); // wing
            m.writer().writeShort(-1);
            m.writer().writeShort(Map.head); // head
            m.writer().writeShort(Map.eye); // eye
            m.writer().writeShort(Map.hair); // hair
            //
            m.writer().write(Util.loadfile("data/msg/msg_-96_x" + p.conn.zoomlv));
            p.conn.addmsg(m);
            m.cleanup();

        } else if (this.map_id == 50) { // map pet
            m = new Message(44);
            m.writer().writeByte(28);
            m.writer().writeByte(0);
            m.writer().writeByte(3);
            m.writer().writeByte(3);
            int dem = 0;
            long now_time = System.currentTimeMillis();
            for (Pet temp2 : p.mypet) {
                if (temp2.is_hatch && temp2.time_born > now_time) {
                    dem++;
                }
            }
            m.writer().writeByte(dem);
            for (Pet temp2 : p.mypet) {
                if (temp2.is_hatch && temp2.time_born > now_time) {
                    int id_ = temp2.get_id();
                    m.writer().writeUTF(ItemTemplate3.item.get(id_).getName());
                    m.writer().writeByte(4); // clazz
                    m.writer().writeShort(id_);
                    m.writer().writeByte(14); // type
                    m.writer().writeShort(ItemTemplate3.item.get(id_).getIcon());
                    m.writer().writeByte(0); // tier
                    m.writer().writeShort(10); // level
                    m.writer().writeByte(0); // color
                    m.writer().writeByte(1);
                    m.writer().writeByte(1);
                    m.writer().writeByte(0); // op size
                    long time2 = ((temp2.time_born - now_time) / 60000) + 1;
                    m.writer().writeInt((int) time2);
                    m.writer().writeByte(0);
                }
            }
            p.conn.addmsg(m);
            m.cleanup();
            //
            m = new Message(44);
            m.writer().writeByte(28);
            m.writer().writeByte(0);
            m.writer().writeByte(9);
            m.writer().writeByte(9);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
            //
            m = new Message(44);
            m.writer().writeByte(28);
            m.writer().writeByte(0);
            m.writer().writeByte(9);
            m.writer().writeByte(9);
            dem = 0;
            for (Pet temp : p.mypet) {
                if (!temp.is_follow && !temp.is_hatch) {
                    dem++;
                }
            }
            m.writer().writeByte(dem); // size pet
            //
            for (int i = 0; i < p.mypet.size(); i++) {
                if (!p.mypet.get(i).is_follow && !p.mypet.get(i).is_hatch) {
                    m.writer().writeUTF(p.mypet.get(i).name);
                    m.writer().writeByte(p.mypet.get(i).type);
                    m.writer().writeShort(i); // id
                    m.writer().writeShort(p.mypet.get(i).level);
                    m.writer().writeShort(p.mypet.get(i).getlevelpercent()); // exp
                    m.writer().writeByte(p.mypet.get(i).type);
                    m.writer().writeByte(p.mypet.get(i).icon);
                    m.writer().writeByte(p.mypet.get(i).nframe);
                    m.writer().writeByte(p.mypet.get(i).color);
                    m.writer().writeInt(p.mypet.get(i).get_age());
                    m.writer().writeShort(p.mypet.get(i).grown);
                    m.writer().writeShort(p.mypet.get(i).maxgrown);
                    m.writer().writeShort(p.mypet.get(i).point1);
                    m.writer().writeShort(p.mypet.get(i).point2);
                    m.writer().writeShort(p.mypet.get(i).point3);
                    m.writer().writeShort(p.mypet.get(i).point4);
                    m.writer().writeShort(p.mypet.get(i).maxpoint);
                    m.writer().writeByte(p.mypet.get(i).op.size());
                    for (int i2 = 0; i2 < p.mypet.get(i).op.size(); i2++) {
                        Option_pet temp = p.mypet.get(i).op.get(i2);
                        m.writer().writeByte(temp.id);
                        m.writer().writeInt(temp.param);
                        m.writer().writeInt(temp.maxdam);
                    }
                }
            }
            p.conn.addmsg(m);
            m.cleanup();
        }
    }

    private void sendNPCMessage(Player p, String npcName, int npcId, int icon, short x, short y, int icon2, String dialog) throws IOException {
        Message m = new Message(-50);
        m.writer().writeByte(1);
        m.writer().writeUTF(npcName);
        m.writer().writeUTF("Giao Tiếp");
        m.writer().writeByte(npcId);
        m.writer().writeByte(icon);
        m.writer().writeShort(x);
        m.writer().writeShort(y);
        m.writer().writeByte(1);
        m.writer().writeByte(1);
        m.writer().writeByte(2);
        m.writer().writeByte(icon2);
        m.writer().writeUTF(dialog);
        m.writer().writeByte(1);
        m.writer().writeByte(0);
        p.conn.addmsg(m);
        m.cleanup();
        if (npcId == -10) {
            m = new Message(-49);
            m.writer().writeByte(0);
            m.writer().writeShort(Manager.gI().msg_eff_109.length);
            m.writer().write(Manager.gI().msg_eff_109);

            m.writer().writeByte(0);
            m.writer().writeByte(1);
            m.writer().writeByte(109);

            m.writer().writeShort(npcId);
            m.writer().writeByte(1);//tem mob
            m.writer().writeByte(0);
            m.writer().writeShort(8000);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
        }
    }

    private void sNPC(Player p) throws IOException {
        if (this.map_id == 1 && p.conn.ac_admin >= 10) {
            sendNPCMessage(p, "ADMin", 127, 50, (short) 690, (short) 361, 42, "Ta là Admin mi muốn gì");
        }

        if (this.map_id == 7 && Manager.gI().event == 4) {
            sendNPCMessage(p, "Vua Hùng", -14, 40, (short) 222, (short) 240, 32, "Con cần cái vẹo gì ở ta ?");
        }

        if (this.map_id == 1) {
            sendNPCMessage(p, "Kai-Jin", 300, 53, (short) 243, (short) 395, 44, "Ta có Thể Giúp Gì Cho Cậu ?");
            if (Manager.gI().event == 5) {
                sendNPCMessage(p, "Ông Đồ", 301, 39, (short) 577, (short) 426, 31, "Chúc Mừng năm mới, An Khang Thịnh Vượng!");
            }
        }
    }

    public static Map get_map_dungeon(int id) {
        for (Map[] temp : entrys) {
            if (temp[0].map_id == id) {
                return temp[0];
            }
        }
        return null;
    }

    public synchronized void drop_item(Player p, byte type, short id) throws IOException {
        His_DelItem hist = new His_DelItem(p.name);
        hist.Logger = "Vứt";
        switch (type) {
            case 3: {
                Item3 temp = p.item.bag3[id];
                if (temp != null) {
                    if (temp.islock) {
                        Service.send_notice_box(p.conn, "Vật phẩm đã khóa");
                        return;
                    }
                    hist.tem3 = temp;
                    hist.Flus();
                    p.item.bag3[id] = null;
                }
                break;
            }
            case 4:
            case 7: {
                hist.tem47 = new Item47();
                hist.tem47.id = id;
                hist.tem47.category = type;
                hist.tem47.quantity = (short) p.item.total_item_by_id(type, id);
                hist.Flus();
                p.item.remove(type, id, p.item.total_item_by_id(type, id));
                break;
            }
        }
        p.item.char_inventory(4);
        p.item.char_inventory(7);
        p.item.char_inventory(3);
    }

    public void send_mount(Player p) throws IOException {
        Message m = new Message(-97);
        m.writer().writeByte(0);
        m.writer().writeByte(p.type_use_mount);
        m.writer().writeShort(p.index);
        MapService.send_msg_player_inside(this, p, m, true);
        m.cleanup();
        Service.send_char_main_in4(p);
    }

    public synchronized void pick_item(Session conn, Message m2) throws IOException {
        short id = m2.reader().readShort();
        byte type = m2.reader().readByte();

        if (item_map[id] == null) {
            Message m = new Message(20);
            m.writer().writeByte(type);
            m.writer().writeShort(id);
            m.writer().writeShort(conn.p.index);
            MapService.send_msg_player_inside(this, conn.p, m, true);
            m.cleanup();
            item_map[id] = null;
            return;
        }

        // Kiểm tra nếu vật phẩm rơi ra từ Map 124
        if (item_map[id].item3 != null && item_map[id].item3.map_124) {
            Item3 item = item_map[id].item3;  // Lấy vật phẩm từ bản đồ

            if (item != null) {  // Thêm vật phẩm vào hành trang nếu có chỗ
                if (item_map[id].idmaster != -1 && item_map[id].idmaster != conn.p.index
                        && (conn.p.squire == null || item_map[id].idmaster != conn.p.squire.index)) {
                    Service.send_notice_nobox_white(conn, "Vật phẩm của người khác");
                    return;
                }

                conn.p.item.add_item_bag3(item);
                conn.p.item.char_inventory(3);

                // Gửi thông điệp cập nhật cho các người chơi khác trong khu vực
                Message m = new Message(20);
                m.writer().writeByte(type);
                m.writer().writeShort(id);
                m.writer().writeShort(conn.p.index);
                MapService.send_msg_player_inside(this, conn.p, m, true);
                m.cleanup();

                // Xóa vật phẩm khỏi bản đồ sau khi nhặt
                item_map[id] = null;
            } else {
                Service.send_notice_nobox_white(conn, "Hành trang đã đầy");
            }
            return;
        }

        if (type == 4 && item_map[id].id_item == -2) {
            Message m = new Message(20);
            conn.p.update_ngoc(item_map[id].quantity);
            m.writer().writeByte(type);
            m.writer().writeShort(id);
            m.writer().writeShort(conn.p.index);
            MapService.send_msg_player_inside(this, conn.p, m, true);
            m.cleanup();
            item_map[id] = null;
            return;
        }

        if (type == 3 && item_map[id] != null
                && (item_map[id].id_item == 3590 || item_map[id].id_item == 3591 || item_map[id].id_item == 3592)) {
            if (item_map[id].idmaster != -1 && item_map[id].idmaster != conn.p.index
                    && (conn.p.squire == null || item_map[id].idmaster != conn.p.squire.index)) {
                Service.send_notice_nobox_white(conn, "Vật phẩm của người khác");
                return;
            }
            if (conn.p.pet_di_buon != null && conn.p.pet_di_buon.item.size() < 12) {
                conn.p.pet_di_buon.item.add(item_map[id].id_item);
                //
                Message m = new Message(20);
                m.writer().writeByte(type);
                m.writer().writeShort(id);
                m.writer().writeShort(conn.p.index);
                MapService.send_msg_player_inside(this, conn.p, m, true);
                m.cleanup();
                item_map[id] = null;
                //
            } else {
                Service.send_notice_nobox_white(conn, "Không thể nhặt!");
            }
            return;
        }

        type = item_map[id].category;

        if (conn.p.isdie) {
            return;
        }

        if (item_map[id].idmaster != -1 && item_map[id].idmaster != conn.p.index
                && (conn.p.squire == null || item_map[id].idmaster != conn.p.squire.index)) {
            Service.send_notice_nobox_white(conn, "Vật phẩm của người khác");
            return;
        }

        if (item_map[id] != null
                && (item_map[id].idmaster == -1
                || item_map[id].idmaster == conn.p.index
                || (conn.p.squire != null && item_map[id].idmaster == conn.p.squire.index))
                && (item_map[id].time_pick < System.currentTimeMillis())) {

            if (type == 5) {
                Item5 existingItem = conn.p.item.findItemById(conn.p.item.bag5, item_map[id].id_item);
                if (existingItem != null) {
                    // Nếu đã có item cùng loại, cộng dồn số lượng
                    existingItem.quantity += item_map[id].quantity;
                } else {
                    // Nếu chưa có, thêm mới vào túi đồ
                    Item5 newItem = new Item5(item_map[id].id_item, item_map[id].quantity);
                    conn.p.item.bag5.add(newItem);
                }
                /*for (TaskTemplate task : conn.p.taskDoing) {
                    if (task.typeItem == 0) {
                        conn.p.checkTask(item_map[id].id_item, (byte) 1);
                    }
                }*/
                // TaskTemplate task = new TaskTemplate();
                // if (task.typeItem == 0) {
                conn.p.checkTask(item_map[id].id_item, (byte) 0);
                // }
                // conn.p.checkTask(item_map[id].id_item, (byte) 1);
                conn.p.item.char_inventory(5);
                // Gửi thông báo nhặt item cho tất cả người chơi trong bản đồ
                Message m = new Message(20);
                m.writer().writeByte(type);
                m.writer().writeShort(id);
                m.writer().writeShort(conn.p.index);
                MapService.send_msg_player_inside(this, conn.p, m, true);
                m.cleanup();
                item_map[id] = null; // Xóa item khỏi bản đồ sau khi nhặt                
                return;
            }

            if (type == 4 && item_map[id].id_item == -1) { // vàng
                if (conn.p.in4_auto[5] == 0) {
                    conn.p.update_vang(item_map[id].quantity);
                    conn.p.item.char_inventory(5);
                    Message m = new Message(20);
                    m.writer().writeByte(type);
                    m.writer().writeShort(id);
                    m.writer().writeShort(conn.p.index);
                    MapService.send_msg_player_inside(this, conn.p, m, true);
                    m.cleanup();
                    item_map[id] = null;
                }
            } else if (item_map[id].id_item != -1 && item_map[id].id_item != -2) {
                if (conn.p.item.get_bag_able() > 0
                        || ((type == 4 || type == 7) && (conn.p.item.total_item_by_id(type, item_map[id].id_item) > 0))) {
                    switch (type) {
                        case 3: {
                            if (item_map[id].id_item < ItemTemplate3.item.size()) {
                                Short idadd = item_map[id].id_item;
                                Item3 itbag = new Item3();
                                itbag.id = idadd;
                                itbag.name = ItemTemplate3.item.get(idadd).getName();
                                itbag.clazz = ItemTemplate3.item.get(idadd).getClazz();
                                itbag.type = ItemTemplate3.item.get(idadd).getType();
                                itbag.level = ItemTemplate3.item.get(idadd).getLevel();
                                itbag.icon = ItemTemplate3.item.get(idadd).getIcon();
                                itbag.op = new ArrayList<>();
                                itbag.op.addAll(item_map[id].op);
                                itbag.color = ItemTemplate3.item.get(idadd).getColor();
                                itbag.part = ItemTemplate3.item.get(idadd).getPart();
                                itbag.tier = 0;
                                itbag.islock = false;
                                itbag.time_use = 0;
                                if (conn.p.in4_auto[4] > itbag.color) {
                                    return;
                                }
                                conn.p.item.add_item_bag3(itbag);
                                conn.p.item.char_inventory(3);
                            }
                            break;
                        }
                        case 4: {
                            if (item_map[id].id_item < ItemTemplate4.item.size()) {
                                Short idadd = item_map[id].id_item;
                                if (ItemTemplate4.item.get(idadd).getType() == 1 && conn.p.in4_auto[6] == 1) {
                                    return;
                                } else if (ItemTemplate4.item.get(idadd).getType() == 0 && conn.p.in4_auto[6] == 2) {
                                    return;
                                }
                                Item47 itbag = new Item47();
                                itbag.id = idadd;
                                itbag.quantity = (short) item_map[id].quantity;
                                itbag.category = 4;
                                conn.p.item.add_item_bag47(4, itbag);
                                conn.p.item.char_inventory(4);
                            }
                            break;
                        }
                        case 7: {
                            if (item_map[id].id_item < ItemTemplate7.item.size()) {
                                Short idadd = item_map[id].id_item;
                                Item47 itbag = new Item47();
                                itbag.id = idadd;
                                itbag.quantity = (short) item_map[id].quantity;
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                conn.p.item.char_inventory(7);
                            }
                            break;
                        }
                    }
                    Message m = new Message(20);
                    m.writer().writeByte(type);
                    m.writer().writeShort(id);
                    m.writer().writeShort(conn.p.index);
                    MapService.send_msg_player_inside(this, conn.p, m, true);
                    m.cleanup();
                    item_map[id] = null;
                }
            }
        }
    }

    public int get_item_map_index_able() {
        for (int i = 0; i < item_map.length; i++) {
            if (item_map[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void create_party(Session conn, Message m2) throws IOException {
        byte type = m2.reader().readByte();
        String name = "";
        Player p0 = null;
        if (type != 0 && type != 5 && type != 4) {
            name = m2.reader().readUTF();
            p0 = Map.get_player_by_name(name);
        }
        switch (type) {
            case 1: { // request party other
                if (p0 == null) {
                    Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại");
                    return;
                }
                if (p0.party != null) {
                    if (conn.p.party != null && conn.p.party.get_mems().contains(p0)) {
                        Service.send_notice_box(conn, "Đối phương đã ở trong đội");
                    } else {
                        Service.send_notice_box(conn, "Đối phương đang trong đội khác");
                    }
                    return;
                }
                if (conn.p.party != null) {
                    if (conn.p.party.get_mems().get(0).index != conn.p.index) {
                        Service.send_notice_box(conn, "Bạn éo phải đội trưởng, đừng có ra dẻ!!!");
                        return;
                    }
                    if (conn.p.party.get_mems().size() > 4) {
                        Service.send_notice_box(conn, "không thể rủ rê thêm thành viên");
                        return;
                    }
                }
                if (conn.p.party == null) {
                    conn.p.party = new Party(conn.p);
                    conn.p.party.add_mems(conn.p);
                    conn.p.party.sendin4();
                }
                //
                Message m = new Message(48);
                m.writer().writeByte(type);
                m.writer().writeUTF(conn.p.name);
                p0.conn.addmsg(m);
                m.cleanup();
                break;
            }
            case 2: { // accept
                if (conn.p.party != null) {
                    Service.send_notice_box(conn, "Bạn đã ở trong nhóm");
                    return;
                }
                if (p0 == null || (p0 != null && p0.party == null)) {
                    Service.send_notice_box(conn, "Nhóm không còn tồn tại");
                    return;
                }
                if (p0.party.get_mems().size() > 4) {
                    Service.send_notice_box(conn, "Nhóm đầy");
                    return;
                } else {
                    conn.p.party = p0.party;
                    p0.party.add_mems(conn.p);
                    p0.party.sendin4();
                    p0.party.send_txt_notice(conn.p.name + " vào nhóm");

                }
                break;
            }
            case 3: { // kick
                if (conn.p.party == null) {
                    Service.send_notice_box(conn, "Nhóm không tồn tại");
                    return;
                }
                Player p01 = null;
                for (int i = 0; i < conn.p.party.get_mems().size(); i++) {
                    if (conn.p.party.get_mems().get(i).name.equals(name)) {
                        p01 = conn.p.party.get_mems().get(i);
                        break;
                    }
                }
                if (p01 == null || name.equals("")) {
                    Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại");
                }
                p01.party.remove_mems(p01);
                p01.party.sendin4();
                p01.party = null;
                conn.p.party.send_txt_notice(p01.name + " đã bị đá khỏi đội");
                Service.send_notice_nobox_white(p01.conn, "Bạn đã bị đá khỏi đội ehehe");
                Message m22 = new Message(48);
                m22.writer().writeByte(5);
                p01.conn.addmsg(m22);
                m22.cleanup();
                break;
            }
            case 4: { // giai tan
                Message m = new Message(48);
                m.writer().writeByte(4);
                for (int i = 1; i < conn.p.party.get_mems().size(); i++) {
                    Player p02 = conn.p.party.get_mems().get(i);
                    p02.conn.addmsg(m);
                    p02.party = null;
                }
                conn.addmsg(m);
                conn.p.party.get_mems().clear();
                conn.p.party = null;
                m.cleanup();
                break;
            }
            case 5: { // leave
                if (conn.p.party.get_mems().get(0).index == conn.p.index) {
                    Service.send_notice_box(conn, "Là đội trưởng thì phải ra dáng, không đc bỏ nhóm!");
                    return;
                }
                conn.p.party.remove_mems(conn.p);
                conn.p.party.sendin4();
                conn.p.party.send_txt_notice(conn.p.name + " rời nhóm");
                conn.p.party = null;
                //
                Message m = new Message(48);
                m.writer().writeByte(5);
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    public static Player get_player_by_id(int id_player_login) {
        for (Map[] maps : entrys) {
            for (Map map : maps) {
                for (Player p0 : map.players) {
                    if (p0.index == id_player_login) {
                        return p0;
                    }
                }

            }
        }
        return null;
    }

    public static boolean is_map_cant_save_site(byte id) {
        return id == 48 || id == 88 || id == 89 || id == 90 || id == 91 || id == 82 || id == 102 || id == 100 || (id >= 83 && id <= 87) || (id >= 53 && id <= 61)
                || Map.is_map_chien_truong(id) || Map.is_map_chien_truong1(id) || id == 119 || id == 124 || id == 46 || id == 125 || id == 126;
    }

    public synchronized void add_item_map_leave(Map map, Player p_master, ItemMap temp, int mob_index)
            throws IOException {
        for (int i = 0; i < item_map.length; i++) {
            if (item_map[i] == null) {
                item_map[i] = temp;
                Message mi = new Message(19);
                mi.writer().writeByte(temp.category);
                mi.writer().writeShort(mob_index); // index mob die
                switch (temp.category) {
                    case 3: {
                        mi.writer().writeShort(ItemTemplate3.item.get(temp.id_item).getIcon());
                        mi.writer().writeShort(i); //
                        mi.writer().writeUTF(ItemTemplate3.item.get(temp.id_item).getName());
                        break;
                    }
                    case 4: {
                        mi.writer().writeShort(ItemTemplate4.item.get(temp.id_item).getIcon());
                        mi.writer().writeShort(i); //
                        mi.writer().writeUTF(ItemTemplate4.item.get(temp.id_item).getName());
                        break;
                    }
                    case 7: {
                        mi.writer().writeShort(ItemTemplate7.item.get(temp.id_item).getIcon());
                        mi.writer().writeShort(i); //
                        mi.writer().writeUTF(ItemTemplate7.item.get(temp.id_item).getName());
                        break;
                    }
                }
                mi.writer().writeByte(0); // color
                mi.writer().writeShort(-1); // id player
                MapService.send_msg_player_inside(map, p_master, mi, true);
                mi.cleanup();
                break;
            }
        }
    }

    public static boolean is_map_chiem_mo(Map map, boolean is_zone) {
        boolean is_map = false;
        int[] map_ = new int[]{3, 5, 8, 9, 11, 12, 15, 16, 19, 21, 22, 24, 26, 27, 37, 42};
        for (int i = 0; i < map_.length; i++) {
            if (map_[i] == map.map_id) {
                is_map = true;
                break;
            }
        }
        return (is_zone) ? (map.zone_id == 4 && is_map) : is_map;
    }

    public static boolean is_map__load_board_player(byte id) {
        return id == 102;
    }

    public static boolean is_map_chien_truong(byte id) {
        return id >= 53 && id <= 61;
    }

    public boolean isMapChienTruong() {
        return map_id >= 53 && map_id <= 61;
    }

    public static boolean is_map_chien_truong1(byte id) {
        return id >= 117 && id <= 117;
    }

    public boolean isMapChienTruong1() {
        return map_id >= 117 && map_id <= 117;
    }

    // thap
    private synchronized void update_blt() throws IOException {
        Boss_Leothap temp = null;

        for (int i = 0; i < lt.list_nhanban.size(); i++) {
            if (lt.list_nhanban.get(i).map_id == this.map_id) {
                temp = lt.list_nhanban.get(i);
                break;
            }
        }
        if (temp != null) {
            if (temp.time_hp_buff < System.currentTimeMillis()) {
                temp.time_hp_buff = System.currentTimeMillis() + 2500L;
                if (temp.hp < temp.get_HpMax()) {
                    int par = (temp.get_HpMax() / 20) + (temp.hp / 1000 * temp.level * temp.p_target.level);
                    temp.hp += par;
                    if (temp.hp > temp.get_HpMax()) {
                        temp.hp = temp.get_HpMax();
                    }
                    Message m_hp = new Message(32);
                    m_hp.writer().writeByte(0);
                    m_hp.writer().writeShort(temp.index);
                    m_hp.writer().writeShort(-1); // id potion in bag
                    m_hp.writer().writeByte(0);
                    m_hp.writer().writeInt(temp.get_HpMax()); // max hp
                    m_hp.writer().writeInt(temp.hp); // hp
                    m_hp.writer().writeInt(par); // param use
                    for (int i = 0; i < this.players.size(); i++) {
                        this.players.get(i).conn.addmsg(m_hp);
                    }
                    m_hp.cleanup();
                }
            }
            if (temp.is_move) {
                temp.act_time = System.currentTimeMillis() + 1000L;
                int[] x_ = new int[]{444, 1068, 228, 804, 516, 684, 540, 612, 1020, 444, 228, 612, 540, 492, 492, 756};
                int[] y_ = new int[]{156, 348, 516, 972, 372, 588, 588, 204, 204, 108, 372, 708, 396, 612, 420, 300};
                int[] map_ = new int[]{3, 5, 8, 9, 11, 12, 15, 16, 19, 21, 22, 24, 26, 27, 37, 42};
                for (int i = 0; i < map_.length; i++) {
                    if (map_[i] == temp.map_id) {
                        int x_old = temp.x;
                        int y_old = temp.y;
                        temp.x = (short) Util.random(x_[i] - 50, x_[i] + 50);
                        temp.y = (short) Util.random(y_[i] - 50, y_[i] + 50);
                        double a = Math.sqrt(Math.pow((x_old - temp.x), 2) + Math.pow((y_old - temp.y), 2));
                        if (a < 50) {
                            temp.x = (short) x_old;
                            temp.y = (short) y_old;
                        }
                        break;
                    }
                }
                Message m12 = new Message(4);
                m12.writer().writeByte(0);
                m12.writer().writeShort(0);
                m12.writer().writeShort(temp.index);
                m12.writer().writeShort(temp.x);
                m12.writer().writeShort(temp.y);
                m12.writer().writeByte(-1);
                for (int i = 0; i < this.players.size(); i++) {
                    Player p0 = this.players.get(i);
                    if (p0.map.map_id == this.map_id) {
                        p0.conn.addmsg(m12);
                    }
                }

                m12.cleanup();
            } else if (temp.p_target != null) {
                if (temp.p_target.conn.connected) {

                    int dame = Util.nextInt(0, 1000) * temp.p_target.levellt * temp.p_target.typelt * temp.p_target.chuyensinh;
                    temp.changeDame(dame);
                    MainObject.MainAttack(lt.template, temp, temp.p_target, Util.random(new int[]{0, 1, 2, 3, 10, 13, 14, 19, 20}), null, 2);

                    temp.changeDame_(dame);
                    dame = 0;
                } else {
                    temp.p_target = null;
                    temp.is_move = true;
                }
            }
        }
    }

    // Phương thức để thêm MainObject vào Map
    public void addObj(MainObject obj) {
        objects.add(obj);
    }

    // Phương thức để lấy MainObject theo index
    public MainObject GetObj(int index) {
        for (MainObject obj : this.objects) {
            if (obj.index == index) {
                return obj;
            }
        }
        return null;
    }

    public void spawnTieuLongNPC(Player p) {
        try {
            if (this.map_id == 0) {
                Message m = new Message(-50);
                m.writer().writeByte(1);
                m.writer().writeUTF("Tiểu Long");
                m.writer().writeUTF("Giao Tiếp");
                m.writer().writeByte(-11); // ID NPC
                m.writer().writeByte(50);  // Icon
                m.writer().writeShort(1145); // X tọa độ
                m.writer().writeShort(444); // Y tọa độ
                m.writer().writeByte(1);
                m.writer().writeByte(1);
                m.writer().writeByte(2);
                m.writer().writeByte(42); // Icon 2
                m.writer().writeUTF("Ta Là Tiểu Long, Bạn cần gì ở Tôi");
                m.writer().writeByte(1);
                m.writer().writeByte(0);
                p.conn.addmsg(m);
                m.cleanup();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send_eff_vip(Player p, int id_eff) {
        try {
            byte[] data = Util.loadfile("data/part_char/imgver/x" + p.conn.zoomlv + "/Data/" + (112 + "_" + id_eff));
            Message m = new Message(-49);
            m.writer().writeByte(2);
            m.writer().writeShort(data.length);
            m.writer().write(data);
            m.writer().writeByte(0); // b3
            m.writer().writeByte(0); // b4
            m.writer().writeByte(id_eff);// num4
            m.writer().writeShort(p.index); // iD2
            m.writer().writeByte(0); // tem2
            m.writer().writeByte(0); // b5
            m.writer().writeInt(1500); // num5

            MapService.send_msg_player_inside(p.map, p, m, true);
            m.cleanup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Sen_eff_111(Player p, byte id_eff) throws IOException {

        Message m = new Message(-49);
        byte[] data = Util.loadfile("data/part_char/imgver/x" + p.conn.zoomlv + "/Data/" + (111 + "_" + id_eff));
        m.writer().writeByte(0);
        m.writer().writeShort(data.length);
        m.writer().write(data);
        m.writer().writeByte(0);
        m.writer().writeByte(1);
        m.writer().writeByte(id_eff);// id part char
        m.writer().writeShort(p.index);
        m.writer().writeByte(0);//tem mob/ 0 player 1 mob
        m.writer().writeByte(0);
        m.writer().writeShort(5);
        m.writer().writeByte(0);
        MapService.send_msg_player_inside(p.map, p, m, true);
        p.conn.addmsg(m);
        m.cleanup();
    }

    private synchronized void update_nbxx() throws IOException {
    if (Manager.gI().list_nbxx == null || Manager.gI().list_nbxx.isEmpty() || this.players == null) {
        return;
    }

    List<Nbxx> toRemove = new ArrayList<>();
    
    for (Nbxx nb : new ArrayList<>(Manager.gI().list_nbxx)) { // Sao chép danh sách để tránh ConcurrentModificationException
          if (nb.master == null && nb.index < 0|| nb.master.map.zone_id != this.zone_id) {
            continue;
        }

        // Kiểm tra nếu chủ nhân mất kết nối, chết hoặc Nbxx hết thời gian tồn tại
        if (!nb.master.conn.connected || nb.master.isdie || nb.act_time < System.currentTimeMillis()) {
            toRemove.add(nb);
            Message m = new Message(8);
            m.writer().writeShort(nb.index);
            Squire.send_msg_player_inside(nb.master.map, nb.master, m, true);
            m.cleanup();
            System.out.println("Đã xóa Nbxx với index: " + nb.index);
            continue;
        }

        // Tự hồi máu mỗi 2.5 giây
        if (nb.time_hp_buff < System.currentTimeMillis()) {
            nb.time_hp_buff = System.currentTimeMillis() + 2500L;
            if (nb.hp < nb.get_HpMax()) {
                int healAmount = nb.get_HpMax() / 20;
                nb.hp = Math.min(nb.hp + healAmount, nb.get_HpMax());

                Message m_hp = new Message(32);
                m_hp.writer().writeByte(0);
                m_hp.writer().writeShort(nb.index);
                m_hp.writer().writeShort(-1);
                m_hp.writer().writeByte(0);
                m_hp.writer().writeInt(nb.get_HpMax());
                m_hp.writer().writeInt(nb.hp);
                m_hp.writer().writeInt(healAmount);

                for (Player p : this.players) {
                    p.conn.addmsg(m_hp);
                }
                m_hp.cleanup();
            }
        }

        // Di chuyển quanh chủ nhân nếu được bật
        if (nb.is_move) {
            int range = 25;
            nb.x = (short) (nb.master.x + Util.random(-range, range));
            nb.y = (short) (nb.master.y + Util.random(-range, range));

            Message m12 = new Message(4);
            m12.writer().writeByte(0);
            m12.writer().writeShort(0);
            m12.writer().writeShort(nb.index);
            m12.writer().writeShort(nb.x);
            m12.writer().writeShort(nb.y);
            m12.writer().writeByte(-1);

            for (Player p : this.players) {
                p.conn.addmsg(m12);
            }
            m12.cleanup();
        }

        // Tấn công mục tiêu
        if (nb.p_target != null) {
            if (nb.p_target.conn.connected && !nb.p_target.isdie &&
                Math.abs(nb.x - nb.p_target.x) < 150 &&
                Math.abs(nb.y - nb.p_target.y) < 150) {

                nb.lastAttackTime = System.currentTimeMillis();
                MainObject.MainAttack(this, nb, nb.p_target,
                    Util.random(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 19, 20}), null, 1);
            } else {
                nb.p_target = null;
            }
        } else {
            boolean foundTarget = false;

            // Tìm mục tiêu là người chơi, nhưng không đánh chủ nhân, người cùng clan hoặc cùng party
            for (Player p : this.players) {
                if (!p.isdie && Math.abs(nb.x - p.x) < 150 && Math.abs(nb.y - p.y) < 150) {
                    if (!(p instanceof Squire) &&
                        p != nb.master &&
                        (nb.master.myclan == null || !p.myclan.name_clan.equals(nb.master.myclan.name_clan)) &&
                        (nb.master.party == null || !nb.master.party.get_mems().contains(p))) {

                        nb.p_target = p;
                        foundTarget = true;
                        break;
                    }
                }
            }

            // Nếu không tìm thấy người chơi, tấn công quái
            if (!foundTarget) {
                for (Mob_in_map mob : this.mobs) {
                    if (!mob.isdie && Math.abs(nb.x - mob.x) < 150 && Math.abs(nb.y - mob.y) < 150) {
                        nb.mob_target = mob;
                        int damage = nb.dame;
                        int remainingHp = Math.max(mob.hp - damage, 0);
                        mob.hp = remainingHp;

                        Nbxx.Fire_Mob(this, nb, Util.random(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 19, 20}),
                            mob.index, damage, remainingHp, null, 0, 0);

                        if (System.currentTimeMillis() - nb.lastAttackTime >= Util.random(1000, 3000)) {
                            nb.lastAttackTime = System.currentTimeMillis();
                           // nb.master.update_Exp((int) (damage * 0.5), true);
                        }

                        if (remainingHp <= 0) {
                            mob.SetDie(this, nb);
                        }
                        break;
                    }
                }
            }
        }
    }

    // Xóa các Nbxx đã đánh dấu
    Manager.gI().list_nbxx.removeAll(toRemove);
}




    private synchronized void update_nbtd() throws IOException {
        // Kiểm tra danh sách Nbxx
        if (Manager.gI().list_nbtd == null || this.players == null) {
            return;
        }

        List<Nbtd> toRemove = new ArrayList<>();
        for (Nbtd nb : Manager.gI().list_nbtd) {
            if (nb.A != null && nb.A.map.zone_id == this.zone_id) {
                // Kiểm tra trạng thái của Nb và chủ nhân
                if (nb.A.startTime + ThachDau_Nb.DURATION < System.currentTimeMillis()
                        || nb.act_time < System.currentTimeMillis()
                        || nb.A.isdie || nb.isdie || nb.A.map.map_id != 126) {
                    toRemove.add(nb);
                    continue;
                }

                // Tự hồi máu
                if (nb.time_hp_buff < System.currentTimeMillis() && nb.hp > 0 && nb.hp < nb.get_HpMax()) {
                    nb.time_hp_buff = System.currentTimeMillis() + 2500L;
                    int par = nb.get_HpMax() / 20;
                    nb.hp = Math.min(nb.hp + par, nb.get_HpMax());

                    // Gửi thông báo cập nhật HP
                    Message m_hp = new Message(32);
                    m_hp.writer().writeByte(0);
                    m_hp.writer().writeShort(nb.index);
                    m_hp.writer().writeShort(-1);
                    m_hp.writer().writeByte(0);
                    m_hp.writer().writeInt(nb.get_HpMax());
                    m_hp.writer().writeInt(nb.hp);
                    m_hp.writer().writeInt(par);
                    for (Player p : this.players) {
                        p.conn.addmsg(m_hp);
                    }
                    m_hp.cleanup();
                }

                // Di chuyển quanh chủ nhân
                if (nb.is_move) {
                    int range = 25;
                    nb.x = (short) (nb.A.x + Util.random(-range, range));
                    nb.y = (short) (nb.A.y + Util.random(-range, range));
                    if (nb.A != null) {
                        Message m12 = new Message(4);
                        m12.writer().writeByte(0);
                        m12.writer().writeShort(0);
                        m12.writer().writeShort(nb.index);
                        m12.writer().writeShort(nb.x);
                        m12.writer().writeShort(nb.y);
                        m12.writer().writeByte(-1);
                        //for (Player p : this.players) {
                        nb.A.conn.addmsg(m12);
                        // }
                        m12.cleanup();
                    }
                }

                // Tấn công mục tiêu
                if (nb.A != null && nb.A.conn.connected && !nb.A.isdie
                        && Math.abs(nb.x - nb.A.x) < 150 && Math.abs(nb.y - nb.A.y) < 150) {
                    MainObject.MainAttack(this, nb, nb.A, Util.random(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 19, 20}), null, 1);
                }
            }
        }

        // Xử lý các Nbtd cần xóa
        for (Nbtd nb : toRemove) {
            if (nb.A != null) {
                if (nb.isdie && !nb.A.isdie) {
                    // Nếu Nbtd chết và chủ nhân không chết, cộng vàng cho chủ nhân
                    nb.A.td_nbtd++;
                    Service.send_notice_nobox_white(nb.A.conn, "Winer");
                } else if (nb.A.isdie) {
                    // Nếu chủ nhân chết, hồi máu và reset trạng thái
                    nb.A.hp += nb.A.body.get_HpMax();
                    nb.A.isdie = false;
                    Service.send_notice_nobox_white(nb.A.conn, "Loss");

                }
            }

            // Xóa Nbtd và di chuyển chủ nhân về map mặc định
            Map map = nb.A.map;
            Message m = new Message(8);
            m.writer().writeShort(nb.index);
            Squire.send_msg_player_inside(map, nb.A, m, true);
            m.cleanup();
            Manager.gI().list_nbtd.remove(nb);

            Map roimap = Map.get_map_by_id(1)[0];
            MapService.leave(nb.A.map, nb.A);
            nb.A.map = roimap;
            nb.A.x = 542; // Tọa độ mặc định trong map 1
            nb.A.y = 408;
            MapService.enter(roimap, nb.A);

            // Xóa trận đấu liên quan
            ThachDau_Nb battle = findBattleByPlayer(nb.A);
            if (battle != null) {
                ThachDau_Nb.Manager_td.removeBattle(battle);
            }

            m = new Message(-104);
            m.writer().writeByte(1);
            m.writer().writeShort(2);
            m.writer().writeByte(-1);
            m.writer().writeByte(0);
            nb.A.conn.addmsg(m);
            m.cleanup();

            System.out.println("Đã xóa Nbtd với index: " + nb.index);
        }
    }

    private ThachDau_Nb findBattleByPlayer(Player player) {
        for (ThachDau_Nb battle : ThachDau_Nb.Manager_td.gI().battles) {
            if (battle != null && (battle.A.equals(player) || battle.B.equals(player))) {
                return battle;
            }
        }
        return null;
    }

    public Mob_in_map getMob(int id) {
        for (Mob_in_map mob : mobs) {
            if (mob.index == id) {
                return mob;
            }
        }
        return null;
    }
    
private boolean clan_null() {
    for (Player p : this.players) {
        if (p.myclan == null) {
            return false; // Nếu có bất kỳ player nào có myclan là null, trả về false
        }
    }
    return true; // Tất cả player đều có myclan không phải là null
}

}
