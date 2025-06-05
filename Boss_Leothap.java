/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeothapWeek;

import client.Clan;
import client.Player;
import core.Manager;
import core.SQL;
import core.Service;
import io.Message;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import template.Item3;
import template.MainObject;
import template.Part_player;

/**
 *
 * @author BERU
 */
public class Boss_Leothap extends MainObject {

    public List<Part_player> part_p;//
    public byte head;//
    public byte eye;//

    public byte part_ao;//
    public byte part_type_ao;//
    public byte part_quan;//
    public byte part_type_quan;//
    public byte part_vk;//
    public byte part_type_vk;//
    public byte part_non;//
    public byte part_type_non;//
    
    public byte hair;//
    public int pointpk;//
    public short clan_icon = -1;
    public int clan_id = -1;
    public String clan_name_clan_shorted;
    public byte clan_mem_type;
    public byte[] fashion;//
    public short mat_na;//
    public short phi_phong;//
    public short danh_hieu;
    public short weapon;//
    public short id_horse;//
    public short id_hair;//
    public short id_wing = 4707;//
    public short id_img_mob = -1;//
    public byte type_use_mount;//
    public long act_time;
    public boolean is_move;//
    public Player p_target;
    public int p_skill_id;//
    public int hpmax;
    public long timeATK;
    public long time_hp_buff;
    public int pierce;
    public int crit;
    public Leothap map;
    public int id;
    public int nedon;
    public int phandon;
    public int critDMG;
    public int[] phukien; // 0,1 type part canh-- 2 la canh thoi trang-- 3 la ao choang -- 4 vu khi thoi trang
    public int id_index_temp;
    public int[] skill_110;
    public Boss_Leothap() {
    }

    public Boss_Leothap(byte idx, int mapid, int id, String name, int x, int y, int clzz, int head, int eye, int hair, int lv, int hpMax, int pk, byte[] fashions, int mount, int matna,
            int phiphong, int weapon, int id_horse, int id_hair, int id_wing, int danhhieu, int dame, int def, short crit, List<Part_player> part_p, int id_img_mob, int skill_110) {
        this.skill_110 = new int[2];
        this.map_id = map_id;
        this.index = id;
        this.id = idx;
        this.name = name;
        this.x = x_old = (short) 650;
        this.y = y_old = (short) 400;
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

    public int changeid(int id) {
        return this.id = id; // Trả về giá trị mới của id
    }

    public void setup(Player p0) {
        String query = "SELECT * FROM `boss_leothap` WHERE `id` = '" + this.id + "' LIMIT 1;";
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            if (!rs.next()) {
                return;
            }
            
            this.name = rs.getString("name");
            this.dame = rs.getInt("dame");
            this.hp = rs.getInt("hp");
            this.hp_max = rs.getInt("hp_max");
            this.clazz = rs.getByte("clazz");
            this.crit = rs.getInt("crit");
            this.nedon = rs.getInt("nedon");
            this.pierce = rs.getInt("pierce");
            this.def = rs.getInt("def");
            this.phandon = rs.getInt("phandon");
            this.critDMG = rs.getInt("critdmg");
            
            JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("hear"));
            if (jsar == null) {
                return ;
            }
            head = Byte.parseByte(jsar.get(0).toString());
            eye = Byte.parseByte(jsar.get(1).toString());
            hair = Byte.parseByte(jsar.get(2).toString());
            jsar.clear();
            

            jsar = (JSONArray) JSONValue.parse(rs.getString("phukien"));
            if (jsar == null) {
                return;
            }
            phukien = new int[jsar.size()];
            for (int i = 0; i < jsar.size(); i++) {
                phukien[i] = Integer.parseInt(jsar.get(i).toString());
            }

            jsar.clear();
            
            jsar = (JSONArray) JSONValue.parse(rs.getString("itemwear_ao"));
            if (jsar == null) {
                return;
            }
            this.part_type_ao = Byte.parseByte(jsar.get(0).toString());
            this.part_ao = Byte.parseByte(jsar.get(1).toString());
            jsar.clear();

            jsar = (JSONArray) JSONValue.parse(rs.getString("itemwear_quan"));
            if (jsar == null) {
                return;
            }
            this.part_type_quan = Byte.parseByte(jsar.get(0).toString());
            this.part_quan = Byte.parseByte(jsar.get(1).toString());
            jsar.clear();

            jsar = (JSONArray) JSONValue.parse(rs.getString("itemwear_vk"));
            if (jsar == null) {
                return;
            }
            this.part_type_vk = Byte.parseByte(jsar.get(0).toString());
            this.part_vk = Byte.parseByte(jsar.get(1).toString());
            jsar.clear();

            jsar = (JSONArray) JSONValue.parse(rs.getString("itemwear_non"));
            if (jsar == null) {
                return;
            }
            this.part_type_non = Byte.parseByte(jsar.get(0).toString());
            this.part_non = Byte.parseByte(jsar.get(1).toString());
            jsar.clear();

            this.index = Short.toUnsignedInt((short) Manager.gI().get_index_mob_new());
            this.x = 650;
            this.y = 400;
            this.part_p = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Part_player temp_add = new Part_player();
                if (i != 0 && i != 1 && i != 6 && i != 7 && i != 10 ) {
                    continue;
                }
//                Item3 temp = p0.item.wear[i];
//                if (temp != null ) {
//                    temp_add.type = temp.type;
                    switch (i) {
                        case 10:
                            temp_add.type = (byte)phukien[0];
                            temp_add.part = (byte)phukien[1];
                            break;
                        case 0:
                            temp_add.type = this.part_type_vk;
                            temp_add.part = this.part_vk;
                            break;
                        case 1:
                            temp_add.type = this.part_type_ao;
                            temp_add.part = this.part_ao;
                            break;
                        case 6:
                            temp_add.type = this.part_type_non;
                            temp_add.part = this.part_non;
                            break;
                        case 7:
                            temp_add.type = this.part_type_quan;
                            temp_add.part = this.part_quan;
                            break;
                        default:
//                            temp_add.part = temp.part;
                            break;
//                    }
                }

                this.part_p.add(temp_add);
            }
//        this.name = "Nhân bản - " + p0.name;
        this.clazz = p0.clazz;
            this.head = p0.head;
            this.eye = p0.eye;
            this.hair = p0.hair;
            this.level = (short) id;
            this.hp += (p0.hp / 1000 * p0.level) + (hp * p0.levellt * p0.typelt *p0.chuyensinh);
            this.hp_max += (p0.hp / 1000 * p0.level) + (hp_max * p0.levellt * p0.typelt * p0.chuyensinh);
           this.pointpk = p0.pointpk;
            if (p0.myclan != null) {
                this.clan_icon = p0.myclan.icon;
                this.clan_id = Clan.get_id_clan(p0.myclan);
                this.clan_name_clan_shorted = p0.myclan.name_clan_shorted;
                this.clan_mem_type = p0.myclan.get_mem_type(p0.name);
            }
            this.fashion = new byte[]{-1, -1, -1, -1, -1, -1, -1};
           // this.mat_na = -1;
          this.mat_na = Service.get_id_mat_na(p0);
          //  this.phi_phong = (short) (phukien[3] + 41);
            this.phi_phong = Service.get_id_phiphong(p0);
      //      this.weapon = (short) (phukien[4] + 41);
            this.weapon = Service.get_id_weapon(p0);
            this.id_horse = p0.id_horse;
          //  this.id_horse = -1;
       //     this.id_hair = -1;
            this.id_hair = Service.get_id_hair(p0);
            this.id_wing = Service.get_id_wing(p0);
            //this.danh_hieu =-1;
            this.danh_hieu = Service.get_id_danhhieu(p0);
            this.type_use_mount = p0.type_use_mount;
            this.type_use_mount = -1;
            this.dame += (p0.body.get_DameProp(dame));
            this.map_id = p0.map.map_id;
            this.is_move = true;
            this.typepk = -1;
            this.mp = 100000;
            this.mp_max = 100000;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        m.writer().writeByte(-1); // type pk
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
        if (p.myclan != null) {
            m.writer().writeShort(this.clan_icon);
            if (clan_icon > -1) {
                m.writer().writeInt(this.clan_id);
                m.writer().writeUTF(this.clan_name_clan_shorted);
                m.writer().writeByte(this.clan_mem_type);
            }
        }
        m.writer().writeByte(-1); // pet
        m.writer().writeByte(this.fashion.length);
        for (int i = 0; i < this.fashion.length; i++) {
            m.writer().writeByte(this.fashion[i]);
        }
        //
        m.writer().writeShort(id_img_mob);//id_img_mob
        m.writer().writeByte(this.type_use_mount);
        m.writer().writeBoolean(false);
        m.writer().writeByte(1);
        m.writer().writeByte(0);
        m.writer().writeShort(this.mat_na); // mat na
        m.writer().writeByte(1); // paint mat na trc sau
        m.writer().writeShort(this.phi_phong); // phi phong
        m.writer().writeShort(this.weapon); // weapon
        m.writer().writeShort(this.id_horse);
        m.writer().writeShort(this.id_hair); // hair
        m.writer().writeShort(this.id_wing); // wing
        m.writer().writeShort(-1); // body
        m.writer().writeShort(-1); // leg
        m.writer().writeShort(-1); // bienhinh
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

    @Override
    public boolean isbolt() {
        return true;
    }

    @Override
    public int get_Crit() {
        return this.crit;
    }

    @Override
    public int get_Pierce() {//xuyên giáp
        return this.pierce;
    }

    @Override
    public int get_Miss() {//xuyên giáp
        return this.nedon;
    }
    @Override
    public int get_PhanDame() {
        return this.phandon;
    }
    @Override
    public int get_CritDMG() {
        return this.critDMG;
    }
}
