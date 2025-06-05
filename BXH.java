package core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import client.Clan;
import client.Player;
import io.Message;
import io.Session;
import java.util.Collections;
import java.util.Comparator;
import map.Map;
import template.Item3;
import template.Level;
import template.Part_player;

public class BXH {

    public static final List<Memin4> BXH_level = new ArrayList<>();
    public static final List<Memin4> BXH_naptuan = new ArrayList<>();
    public static final List<Memin4> BXH_chuyensinh = new ArrayList<>();
    public static final List<Memin4> BXH_tutien = new ArrayList<>();
    public static final List<Memin4> BXH_hieuchien = new ArrayList<>();
    public static final List<Memin4> BXH_vang = new ArrayList<>();
    public static final List<Memin4> BXH_thap = new ArrayList<>();
    public static final List<Memin4> BXH_td_nbtd = new ArrayList<>();
    public static final List<Clan> BXH_clan = new ArrayList<>();    
    public static final List<Clan> BXH_clan_vang = new ArrayList<>();
    public static final List<Clan> BXH_clan_ngoc = new ArrayList<>();
    public static List<Memin4> entry0 = new ArrayList<>();
    private static int test5 = -10;
    public static void send(Session conn, int b) throws IOException {
        switch (b) {
            case 0: {
            
               // Message m = new Message(56);
               Message m = new Message(56);
                m.writer().writeByte(1);
                m.writer().writeUTF("BXH LEVEL");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_level.size()); // num2
                for (int i = 0; i < BXH.BXH_level.size(); i++) {
                    Memin4 temp = BXH.BXH_level.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            
            case 1: {
                Message m = new Message(56);
                m.writer().writeByte(1);
                m.writer().writeUTF("BXH Đại Gia");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_naptuan.size()); // num2
                for (int i = 0; i < BXH.BXH_naptuan.size(); i++) {
                    Memin4 temp = BXH.BXH_naptuan.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            
            case 2: {
                Message m = new Message(56);
                m.writer().writeByte(1);
                m.writer().writeUTF("BXH Chuyển Sinh");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_chuyensinh.size()); // num2
                for (int i = 0; i < BXH.BXH_chuyensinh.size(); i++) {
                    Memin4 temp = BXH.BXH_chuyensinh.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            
            
            case 3: {
                Message m = new Message(56);
                m.writer().writeByte(1);
                m.writer().writeUTF("BXH Tu Tiên");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_tutien.size()); // num2
                for (int i = 0; i < BXH.BXH_tutien.size(); i++) {
                    Memin4 temp = BXH.BXH_tutien.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            
            
            case 4: {
                Message m = new Message(56);
                m.writer().writeByte(1);
                m.writer().writeUTF("BXH Đồ Sát");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_hieuchien.size()); // num2
                for (int i = 0; i < BXH.BXH_hieuchien.size(); i++) {
                    Memin4 temp = BXH.BXH_hieuchien.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            
            
            case 5: {
                Message m = new Message(56);
                m.writer().writeByte(1);
                m.writer().writeUTF("BXH Giàu Có");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_vang.size()); // num2
                for (int i = 0; i < BXH.BXH_vang.size(); i++) {
                    Memin4 temp = BXH.BXH_vang.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            
            case 6: {
                Message m = new Message(56);
                m.writer().writeByte(1);
                m.writer().writeUTF("BXH Leo Tháp");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_thap.size()); // num2
                for (int i = 0; i < BXH.BXH_thap.size(); i++) {
                    Memin4 temp = BXH.BXH_thap.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            case 7: {
            Message m = new Message(56);
                m.writer().writeByte(6);
                m.writer().writeUTF("BXH Thach Đấu");
                m.writer().writeByte(99); // page
                m.writer().writeInt(0); // my index in bxh
                m.writer().writeByte(BXH.BXH_td_nbtd.size()); // num2
                for (int i = 0; i < BXH.BXH_td_nbtd.size(); i++) {
                    Memin4 temp = BXH.BXH_td_nbtd.get(i);
                    Player p0 = Map.get_player_by_name(temp.name);
                    if (p0 != null) {
                        temp.head = p0.head;
                        temp.eye = p0.eye;
                        temp.hair = p0.hair;
                        temp.level = p0.level;
                        temp.itemwear.clear();
                        for (int i1 = 0; i1 < p0.item.wear.length; i1++) {
                            Item3 it = p0.item.wear[i1];
                            if (it != null && (i1 == 0 || i1 == 1 || i1 == 6 || i1 == 7 || i1 == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        temp.clan = p0.myclan;
                    }
                    m.writer().writeUTF(temp.name);
                    m.writer().writeByte(temp.head);
                    m.writer().writeByte(temp.eye);
                    m.writer().writeByte(temp.hair);
                    m.writer().writeShort(temp.level);
                    m.writer().writeByte(temp.itemwear.size());
                    for (Part_player it : temp.itemwear) {
                        m.writer().writeByte(it.part);
                        m.writer().writeByte(it.type);
                    }
                    m.writer().writeByte((p0 != null) ? (byte) 1 : (byte) 0); // type online
                    m.writer().writeUTF(temp.info);
                    if (temp.clan != null) {
                        m.writer().writeShort(temp.clan.icon);
                        m.writer().writeUTF(temp.clan.name_clan_shorted);
                        m.writer().writeByte(temp.clan.get_mem_type(temp.name));
                    } else {
                        m.writer().writeShort(-1);
                    }
                }
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            
            
        }
    }
    
    public static void init() {
        try {

            Connection conn = SQL.gI().getConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(
                    "SELECT `id`, `level`, `exp`, `name`, `body`, `itemwear` FROM `player` WHERE `level` > 10 ORDER BY `level` DESC, exp DESC LIMIT 20;");

            entry0.clear();
            while (rs.next()) {
                Memin4 temp = new Memin4();
                temp.id = rs.getShort("id");
                temp.level = rs.getShort("level");
                temp.exp = rs.getLong("exp");
                temp.name = rs.getString("name");
                JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("body"));
                if (jsar == null) {
                    continue;
                }
                temp.head = Byte.parseByte(jsar.get(0).toString());
                temp.hair = Byte.parseByte(jsar.get(2).toString());
                temp.eye = Byte.parseByte(jsar.get(1).toString());
                jsar.clear();
                jsar = (JSONArray) JSONValue.parse(rs.getString("itemwear"));
                temp.itemwear = new ArrayList<>();
                for (int i3 = 0; i3 < jsar.size(); i3++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i3).toString());
                    if (jsar2 == null) {
                        continue;
                    }
                    byte index_wear = Byte.parseByte(jsar2.get(9).toString());
                    if (index_wear != 0 && index_wear != 1 && index_wear != 6 && index_wear != 7 && index_wear != 10) {
                        continue;
                    }
                    Part_player temp2 = new Part_player();
                    temp2.type = Byte.parseByte(jsar2.get(2).toString());
                    temp2.part = Byte.parseByte(jsar2.get(6).toString());
                    temp.itemwear.add(temp2);
                }
                entry0.add(temp);
            }
            rs.close();
            //
            Map.head = -1;
            Map.eye = -1;
            Map.hair = -1;
            Map.weapon = -1;
            Map.body = -1;
            Map.leg = -1;
            Map.hat = -1;
            Map.wing = -1;
            Map.name_mo = "";
            rs = ps.executeQuery("SELECT * FROM `player` ORDER BY `hieuchien` DESC, `id` LIMIT 1");
            if (rs.next()) {
                System.out.println("123123");
                Map.name_mo = rs.getString("name");
                JSONArray js = (JSONArray) JSONValue.parse(rs.getString("body"));
                Map.head = Short.parseShort(js.get(0).toString());
                Map.eye = Short.parseShort(js.get(1).toString());
                Map.hair = Short.parseShort(js.get(2).toString());
                js.clear();
                js = (JSONArray) JSONValue.parse(rs.getString("itemwear"));
                for (int i3 = 0; i3 < js.size(); i3++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(js.get(i3).toString());
                    if (jsar2 == null) {
                        return;
                    }
                    byte index_wear = Byte.parseByte(jsar2.get(9).toString());
                    if (index_wear != 0 && index_wear != 1 && index_wear != 2 && index_wear != 7 && index_wear != 10) {
                        continue;
                    }
                    
                    Part_player temp = new Part_player();
                    temp.type = Byte.parseByte(jsar2.get(2).toString());
                    temp.part = Byte.parseByte(jsar2.get(6).toString());
                    if (temp.type == 2) {
                        Map.hat = temp.part;
                    }
                    if (temp.type == 0) {
                        Map.body = temp.part;
                    }
                    if (temp.type == 1) {
                        Map.leg = temp.part;
                    }
                    if (temp.type == 7) {
                        Map.wing = temp.part;
                    }
                    if (temp.type == 10) {
                        Map.weapon = temp.part;
                    }
                }
                
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class Memin4 {

        public short level;
        public long exp;
        public int point_arena;
        public int naptuan;
        public int chuyensinh;
        public int tutien;
        public int hieuchien;
        public String name;
        public byte head;
        public byte eye;
        public byte hair;
        public List<Part_player> itemwear;
        public Clan clan;
        public String info;
        public short id;
        public long vang;
        public int ngoc;
        public int point_lt;
        public int td_nbtd;
    }

}
