package ai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import client.Clan;
import client.Player;
import client.Squire;
import core.Manager;
import core.Service;
import core.Util;
import io.Message;
import java.util.Timer;
import java.util.TimerTask;
import map.Map;
import map.MapService;
import map.Mob_in_map;
import org.json.simple.JSONArray;
import template.Eff_TextFire;
import template.Item3;
import template.MainObject;
import template.Mob_MoTaiNguyen;
import template.Part_player;

public class Nbxx extends MainObject {

    public List<Part_player> part_p;//
    private byte head;//
    private byte eye;//
    private byte hair;//
    private int pointpk;//
    private short clan_icon = -1;
    private int clan_id = -1;
    private String clan_name_clan_shorted;
    private byte clan_mem_type;
    private byte[] fashion;//
    private short mat_na;//
    private short phi_phong;//
    private short danh_hieu;
    private short weapon;//
    private short id_horse;//
    private short id_hair;//
    private short id_wing;//
    private short id_img_mob = -1;//
    private byte type_use_mount;//
    public long act_time;
    public boolean is_move;//
    public Player p_target;
    public int p_skill_id;//

    public long timeATK;
    public long time_hp_buff;
    private int pierce;
    private int crit;
    public String clan_name;
    private long time_hs;
    private Timer respawnTimer;
    // Khai báo timer bên ngoài hàm
    private boolean respawnTimerRunning = false;
    // Theo dõi trạng thái của timer
    public Player master; // Biến đánh dấu chủ nhân
    public Mob_in_map mob_target;
    public long spawnTime;
    public long lastAttackTime;

    public Nbxx(Player p) {
        this.index = p.index;
        this.map_id = p.map.map_id;
        this.zone_id = p.map.zone_id;
        this.x = p.x;
        this.y = p.y;
    }

    public Nbxx(int mapid, int id, String name, int x, int y, int clzz, int head, int eye, int hair, int lv, int hpMax, int pk, byte[] fashions, int mount, int matna,
            int phiphong, int weapon, int id_horse, int id_hair, int id_wing, int danhhieu, int dame, int def, int crit, List<Part_player> part_p, int id_img_mob) {
        this.map_id = (byte) mapid;
        this.index = id;
        this.name = name;
        this.x = x_old = (short) x;
        this.y = y_old = (short) y;
        this.clazz = (byte) clzz;
        this.head = (byte) head;
        this.eye = (byte) eye;
        this.hair = (byte) hair;
        this.level = (short) lv;
        this.hp = this.hp_max = hpMax;
        this.pointpk = (byte) pk;
        if (fashions == null) {
            fashions = new byte[]{-1, -1, -1, -1, -1, -1, -1};
        }
        this.fashion = fashions;
        this.type_use_mount = (byte) mount;
        this.mat_na = (short) matna;
        this.phi_phong = (short) phiphong;
        this.weapon = (short) weapon;
        this.id_horse = (short) id_horse;
        this.id_hair = (short) id_hair;
        this.id_wing = (short) id_wing;
        this.danh_hieu = (short) danhhieu;
        is_move = true;
        this.pierce = 5000;
        this.dame = dame;
        this.def = def;
        this.crit = crit;
        clan_name_clan_shorted = "";
        this.part_p = part_p;
        this.id_img_mob = (short) id_img_mob;
    }

    public void setup(Player p0) {
        this.master = p0; // Gán chủ nhân cho Nbxx
        this.index = Short.toUnsignedInt((short) Manager.gI().get_index_mob_new());
        this.x = p0.x;
        this.y = p0.y;
        this.part_p = new ArrayList<>();
        for (int i = 0; i < p0.item.wear.length; i++) {
            Part_player temp_add = new Part_player();
            if (i != 0 && i != 1 && i != 6 && i != 7 && i != 10) {
                continue;
            }
            Item3 temp = p0.item.wear[i];
            if (temp != null) {
                temp_add.type = temp.type;
                if (i == 10 && p0.item.wear[14] != null && (p0.item.wear[14].id >= 4638 && p0.item.wear[14].id <= 4648)) {
                    temp_add.part = p0.item.wear[14].part;
                } else {
                    temp_add.part = temp.part;
                }
            }
            this.part_p.add(temp_add);
        }
        this.name = p0.name;
        this.clazz = p0.clazz;
        this.head = p0.head;
        this.eye = p0.eye;
        this.hair = p0.hair;
        this.level = p0.level;
        this.hp = p0.hp;
        this.hp_max = p0.body.get_HpMax();
        this.pointpk = p0.pointpk;
        
        // this.clan_icon = p0.myclan.icon;
        // this.clan_id = Clan.get_id_clan(p0.myclan);
        // this.clan_name_clan_shorted = p0.myclan.name_clan_shorted;
        // this.clan_mem_type = p0.myclan.get_mem_type(p0.name);
        if (p0.myclan != null) {
            this.clan_icon = 0;
            this.clan_id = p0.index;
            this.clan_name_clan_shorted = "Linh Thể";
            this.clan_mem_type =0;
            this.clan_name = "";
        } else {
            this.clan_icon = 0;
            this.clan_id = p0.index;
            this.clan_name_clan_shorted = "Linh Thể";
            this.clan_mem_type = 0;
            this.clan_name = "";
        }
        this.fashion = p0.fashion;
        this.mat_na = Service.get_id_mat_na(p0);
        this.phi_phong = Service.get_id_phiphong(p0);
        this.weapon = Service.get_id_weapon(p0);
        this.id_horse = p0.id_horse;
        this.id_hair = Service.get_id_hair(p0);
        this.id_wing = Service.get_id_wing(p0);
        this.danh_hieu = Service.get_id_danhhieu(p0);
        this.type_use_mount = p0.type_use_mount;
        this.dame = (p0.body.get_DameProp(0) + p0.body.get_DameProp(1) + p0.body.get_DameProp(2)
                + p0.body.get_DameProp(3) + p0.body.get_DameProp(4)) / 2;
        this.map_id = p0.map.map_id;
        this.crit = p0.body.get_Crit();
        this.def = p0.body.get_DefBase();
        this.pierce = p0.body.get_Pierce();
        if (this.pierce > 5000) {
            this.pierce = 5000;
        }
        this.is_move = true;
       // this.clan_name = p0.myclan.name_clan;
    }

   

    public void send_in4(Player p) throws IOException {
        Message m = new Message(5);
        m.writer().writeShort(this.index);
        m.writer().writeUTF(this.name);
        m.writer().writeShort(this.x);
        m.writer().writeShort(this.y);
        m.writer().writeByte(this.clazz);
        m.writer().writeByte(-1);
        m.writer().writeByte(this.head);
        m.writer().writeByte(this.eye);
        m.writer().writeByte(this.hair);
        m.writer().writeShort(this.level);
        m.writer().writeInt(this.hp);
        m.writer().writeInt(this.hp_max);
        m.writer().writeByte(0);
        // type pk
        m.writer().writeShort(this.pointpk);
        m.writer().writeByte(this.part_p.size());
        //
        for (int i = 0; i < this.part_p.size(); i++) {
            m.writer().writeByte(this.part_p.get(i).type);
            m.writer().writeByte(this.part_p.get(i).part);
            m.writer().writeByte(3);
            m.writer().writeShort(-1);
            m.writer().writeShort(-1);
            m.writer().writeShort(-1);
            m.writer().writeShort(-1); // eff
        }
        //
        m.writer().writeShort(this.clan_icon);
        if (clan_icon > -1) {
            m.writer().writeInt(this.clan_id);
            m.writer().writeUTF(this.clan_name_clan_shorted);
            m.writer().writeByte(this.clan_mem_type);
        }
        m.writer().writeByte(-1); // pet
         m.writer().writeByte(this.fashion.length);
        for (int i = 0; i < this.fashion.length; i++) {
            if (p.conn.version >= 280) {
                m.writer().writeShort(this.fashion[i]);
            } else {
                m.writer().writeByte(this.fashion[i]);
            }
        }
        //
        m.writer().writeShort(id_img_mob);//id_img_mob
        m.writer().writeByte(this.type_use_mount);
        m.writer().writeBoolean(false);
        m.writer().writeByte(1);
        m.writer().writeByte(0);
        m.writer().writeShort(this.mat_na); // mat na
        m.writer().writeByte(1);
        // paint mat na trc sau
        m.writer().writeShort(this.phi_phong);
        // phi phong
        m.writer().writeShort(this.weapon);
        // weapon
        m.writer().writeShort(this.id_horse);
        m.writer().writeShort(this.id_hair);
        // hair
        m.writer().writeShort(this.id_wing); // wing
        m.writer().writeShort(-1);
        // body
        m.writer().writeShort(-1); // leg
        m.writer().writeShort(-1);
        // bienhinh
        p.conn.addmsg(m);
        m.cleanup();
    }

    @Override
    public int get_TypeObj() {
        return 0;
    }

    @Override
    public int get_DefBase() {
        return def;
    }
    
    
    public static void Fire_Mob(Map map, Nbxx nbxx, int indexskill, int idMobTarget, int damage, int hpMobTarget, List<Eff_TextFire> listFireEffects, int idPlus, int damagePlus) throws IOException {
    Player p = nbxx.master; // Lấy người chơi sở hữu nbxx    
    Message m = new Message(9);
    m.writer().writeShort(nbxx.index);
    m.writer().writeByte(indexskill);
    m.writer().writeByte(1);
    m.writer().writeShort(idMobTarget);
    m.writer().writeInt(damage); // Damage gây ra
    m.writer().writeInt(hpMobTarget); // HP của mob sau khi nhận damage

    if (listFireEffects == null || listFireEffects.isEmpty()) {
        m.writer().writeByte(1);
        m.writer().writeByte(0); // 1: xuyên giáp, 2: hút HP, 3: hút MP, 4: chí mạng, 5: phản đòn
        m.writer().writeInt(damage);
    } else {
        m.writer().writeByte(listFireEffects.size());
        for (Eff_TextFire effect : listFireEffects) {
            if (effect == null) {
                m.writer().writeByte(0);
                m.writer().writeInt(damage);
            } else {
                m.writer().writeByte(effect.type);
                m.writer().writeInt(effect.dame);
            }
        }
    }
    m.writer().writeInt(nbxx.hp);
    m.writer().writeInt(nbxx.mp);
    m.writer().writeByte(idPlus);
    m.writer().writeInt(damagePlus);
    MapService.send_msg_player_inside(map, nbxx, m, true);
    m.cleanup();
}


}