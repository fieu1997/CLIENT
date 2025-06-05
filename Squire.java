package client;

import ai.MobAi;
import ai.LinhCanh;
import core.Manager;
import core.SQL;
import core.Service;
import core.Util;
import event_daily.ChiemThanhManager;
import io.Message;
import io.Session;
import map.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import template.*;

import java.io.IOException;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Squire extends Player {

    private long delay_move;
    private long delay_chat;
    private int targetIndex = -1;
    private long delay_attack = 0;
    public boolean onefire;
    public long timedie = 0;
    public long vang_;
    public int kimcuong_;

    public Squire(Session session, int id) {
        super(session, -10000 - id);
      //  this.item = new Item(this); // Khởi tạo hành trang riêng
        // Khởi tạo các mảng và danh sách hành trang
//        this.item.bag3 = new Item3[maxbag]; // Ví dụ: giới hạn 20 slot cho bag3
//        this.item.box3 = new Item3[maxbox]; // Giới hạn 20 slot cho box3
//        this.item.tui3 = new Item3[maxtui]; // Giới hạn 20 slot cho tui3
//        this.item.bag47 = new ArrayList<>();
//        this.item.box47 = new ArrayList<>();
//        this.item.tui47 = new ArrayList<>();
//        this.item.bag5 = new ArrayList<>();
//        this.item.box5 = new ArrayList<>();
//        this.item.wear = new Item3[30];
//        for (int i = 0; i < 30; i++) {
//            this.item.wear[i] = null;
//        }
    }

    public void switchToSquire(Player owner) {
        try {
            owner.flush();
            if (owner.party != null && owner.party.get_mems().size() > 1) {
                owner.party.remove_mems(owner);
                owner.party.sendin4();
                owner.party.send_txt_notice(owner.name + " rời nhóm");
                owner.party = null;
            }
            if (owner.isLiveSquire) {
                Squire.squireLeaveMap(owner);
            }
            owner.isLiveSquire = false;
            this.maxbag = owner.maxbag; // ??ng b? maxbag t? owner
            this.maxbox = owner.maxbox; // ??ng b? maxbox t? owner
            this.maxtui = owner.maxtui; // ??ng b? maxtui t? owner
            this.item.tui3 = this.item.tui3;
            this.item.tui47 = this.item.tui47;
            this.item.box3 = this.item.box3;
            this.item.box47 = this.item.box47;
            this.item.bag3 = this.item.bag3;
            this.item.bag47 = this.item.bag47;
            this.kimcuong_ = kimcuong_;
            this.vang_ = vang_;
            this.isOwner = false;// đánh dấu không phải người chơi 
            this.isSquire = false;
            this.isdie = false;

            this.isLiveSquire = false;

            this.x = owner.x;
            this.y = owner.y;
            this.map = owner.map;
            conn.p = this;
            this.owner = owner;
            this.squire = this;
            setInfo();
            this.load();
            this.item.char_inventory(3);
            this.item.char_inventory(4);
            this.item.char_inventory(5);
            this.item.char_inventory(7);
            MapService.leave(owner.map, owner);
            MessageHandler.dataloginmap(conn);
            removeClan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setInfo() throws IOException {
        this.skill_110 = new int[2];
        if (this.skill_point == null) {
            this.skill_point = new byte[21];
        }
        if (this.time_delay_skill == null) {
            this.time_delay_skill = new long[21];
        }
        skill_point[0] = (skill_point[0] > 0) ? skill_point[0] : 1;

        id_henshin = -1;
        this.already_setup = true;
        time_use_item_arena = System.currentTimeMillis() + 250_000L;
        load_skill();
        CheckSkillPoint();

        suckhoe = 30000;
        typepk = -1;
        pointpk = 0;
        hp = body.get_HpMax();
        mp = body.get_MpMax();
        fashion = Part_fashion.get_part(this);
        type_use_mount = -1;
        id_item_rebuild = -1;
        is_use_mayman = false;
        id_use_mayman = -1;
        item_replace = -1;
        item_replace2 = -1;
        id_buffer_126 = -1;
        id_index_126 = -1;
        id_medal_is_created = -1;
        fusion_material_medal_id = -1;
        id_remove_time_use = -1;
        id_horse = -1;
        is_create_wing = false;
        id_wing_split = -1;
        in4_auto = new byte[]{0, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0};
        my_store = new ArrayList<>();
        my_store_name = "";
        id_select_mo_ly = -1;
        id_hop_ngoc = -1;
        id_name = -1;
        list_thao_kham_ngoc = new ArrayList<>();
        myclan = null;

    }

    public void removeClan() {
        try {
            Message msg = new Message(69);
            msg.writer().writeByte(19);
            msg.writer().writeShort(this.index);
            msg.writer().writeUTF(this.name);
            msg.writer().writeInt(-1);
            conn.addmsg(msg);
            msg.cleanup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Squire load() {
        long _time = System.currentTimeMillis();
        String query = "SELECT * FROM `squire` WHERE `id` = '" + this.index + "' LIMIT 1;";
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            if (!rs.next()) {
                return null;
            }
            //
            //this.skill_110 = new int[2];
            this.kham = new Kham_template();
            this.name = rs.getString("name") + "_dt";
            this.timeBlockCTG = rs.getLong("time_block_ctg");
            JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("body"));
            if (jsar == null) {
                return null;
            }
            head = Byte.parseByte(jsar.get(0).toString());
            eye = Byte.parseByte(jsar.get(1).toString());
            hair = Byte.parseByte(jsar.get(2).toString());
            other_player_inside = new HashMap<>();
            other_mob_inside = new HashMap<>();
            other_mob_inside_update = new HashMap<>();
            jsar.clear();
            jsar = (JSONArray) JSONValue.parse(rs.getString("eff"));
            if (jsar == null) {
                return null;
            }
            for (Object o : jsar) {
                JSONArray jsar2 = (JSONArray) JSONValue.parse(o.toString());
                if (jsar2 == null) {
                    return null;
                }
                this.body.add_EffDefault(Integer.parseInt(jsar2.get(0).toString()), Integer.parseInt(jsar2.get(1).toString()),
                        (System.currentTimeMillis() + Long.parseLong(jsar2.get(2).toString())));
            }
            jsar.clear();
            date = Util.getDate(rs.getString("date"));
            hieuchien = rs.getInt("hieuchien");
            time_khu2 = rs.getInt("time_khu2");
            type_exp = rs.getByte("typeexp");
            clazz = rs.getByte("clazz");
            level = rs.getShort("level");
            exp = rs.getLong("exp");
            //
            if (level > Manager.gI().lvmax) {
                level = (short) Manager.gI().lvmax;
                if (exp >= Level.entrys.get(this.level - 1).exp) {
                    exp = Level.entrys.get(this.level - 1).exp - 1;

                }
            }
            isdie = false;
            vang_ = rs.getLong("vang_");
            kimcuong_ = rs.getInt("kimcuong_");
            tiemnang = rs.getInt("tiemnang");
            kynang = rs.getInt("kynang");
            point1 = rs.getInt("point1");
            point2 = rs.getInt("point2");
            point3 = rs.getInt("point3");
            point4 = rs.getInt("point4");
            skill_point = new byte[21];
            time_delay_skill = new long[21];
            jsar = (JSONArray) JSONValue.parse(rs.getString("skill"));
            if (jsar == null) {
                return null;
            }
            for (int i = 0; i < 21; i++) {
                skill_point[i] = Byte.parseByte(jsar.get(i).toString());
                time_delay_skill[i] = 0;
            }
            jsar.clear();

            this.item = new Item(this);
            this.item.bag3 = new Item3[maxbag]; // Kích thước túi có thể tùy chỉnh
            this.item.box3 = new Item3[maxbox];
            this.item.tui3 = new Item3[maxtui];
            this.item.bag47 = new ArrayList<>();
            this.item.box47 = new ArrayList<>();
            this.item.tui47 = new ArrayList<>();
            this.item.bag5 = new ArrayList<>();
            this.item.box5 = new ArrayList<>();
            this.item.wear = new Item3[30];
            for (int i = 0; i < 30; i++) {
                this.item.wear[i] = null;
            }
            //

            // Tải item3 (túi đồ)
            jsar = (JSONArray) JSONValue.parse(rs.getString("item3_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size() && i < maxbag; i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item3 temp = new Item3();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.clazz = Byte.parseByte(jsar2.get(1).toString());
                    temp.type = Byte.parseByte(jsar2.get(2).toString());
                    temp.level = Short.parseShort(jsar2.get(3).toString());
                    temp.icon = Short.parseShort(jsar2.get(4).toString());
                    temp.color = Byte.parseByte(jsar2.get(5).toString());
                    temp.part = Byte.parseByte(jsar2.get(6).toString());
                    temp.islock = Byte.parseByte(jsar2.get(7).toString()) == 1;
                    temp.name = ItemTemplate3.item.get(temp.id).getName();
                    if (temp.islock) {
                        temp.name += " [Khóa]";
                    }
                    temp.tier = Byte.parseByte(jsar2.get(8).toString());
                    JSONArray jsar3 = (JSONArray) JSONValue.parse(jsar2.get(9).toString());
                    temp.op = new ArrayList<>();
                    for (int j = 0; j < jsar3.size(); j++) {
                        JSONArray jsar4 = (JSONArray) JSONValue.parse(jsar3.get(j).toString());
                        temp.op.add(new Option(Byte.parseByte(jsar4.get(0).toString()), Integer.parseInt(jsar4.get(1).toString()), temp.id));
                    }
                    if (jsar2.size() >= 11) {
                        temp.tierStar = Byte.parseByte(jsar2.get(10).toString());
                    }
                    if (jsar2.size() >= 12) {
                        temp.time_use = Long.parseLong(jsar2.get(11).toString());
                    }
                    if (jsar2.size() >= 13) {
                        temp.expiry_date = Long.parseLong(jsar2.get(12).toString());
                    }
                    if (jsar2.size() >= 14) {
                        temp.isHopdo = Byte.parseByte(jsar2.get(13).toString());
                    }
                    temp.UpdateName();
                    if (temp.expiry_date == 0 || temp.expiry_date > _time) {
                        item.bag3[i] = temp;
                    }
                }
                jsar.clear();
            }

            // Tải item4 (túi đồ)
            jsar = (JSONArray) JSONValue.parse(rs.getString("item4_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 4;
                    if (temp.quantity > 0) {
                        item.bag47.add(temp);
                    }
                }
                jsar.clear();
            }

            // Tải item7 (túi đồ)
            jsar = (JSONArray) JSONValue.parse(rs.getString("item7_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 7;
                    if (temp.quantity > 0) {
                        item.bag47.add(temp);
                    }
                }
                jsar.clear();
            }

            // Tải itembox3 (rương)
            jsar = (JSONArray) JSONValue.parse(rs.getString("itembox3_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size() && i < maxbox; i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item3 temp = new Item3();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.clazz = Byte.parseByte(jsar2.get(1).toString());
                    temp.type = Byte.parseByte(jsar2.get(2).toString());
                    temp.level = Short.parseShort(jsar2.get(3).toString());
                    temp.icon = Short.parseShort(jsar2.get(4).toString());
                    temp.color = Byte.parseByte(jsar2.get(5).toString());
                    temp.part = Byte.parseByte(jsar2.get(6).toString());
                    temp.islock = Byte.parseByte(jsar2.get(7).toString()) == 1;
                    temp.name = ItemTemplate3.item.get(temp.id).getName();
                    if (temp.islock) {
                        temp.name += " [Khóa]";
                    }
                    temp.tier = Byte.parseByte(jsar2.get(8).toString());
                    JSONArray jsar3 = (JSONArray) JSONValue.parse(jsar2.get(9).toString());
                    temp.op = new ArrayList<>();
                    for (int j = 0; j < jsar3.size(); j++) {
                        JSONArray jsar4 = (JSONArray) JSONValue.parse(jsar3.get(j).toString());
                        temp.op.add(new Option(Byte.parseByte(jsar4.get(0).toString()), Integer.parseInt(jsar4.get(1).toString()), temp.id));
                    }
                    if (jsar2.size() >= 11) {
                        temp.tierStar = Byte.parseByte(jsar2.get(10).toString());
                    }
                    if (jsar2.size() >= 12) {
                        temp.time_use = Long.parseLong(jsar2.get(11).toString());
                    }
                    if (jsar2.size() >= 13) {
                        temp.expiry_date = Long.parseLong(jsar2.get(12).toString());
                    }
                    if (jsar2.size() >= 14) {
                        temp.isHopdo = Byte.parseByte(jsar2.get(13).toString());
                    }
                    temp.UpdateName();
                    if (temp.expiry_date == 0 || temp.expiry_date > _time) {
                        item.box3[i] = temp;
                    }
                }
                jsar.clear();
            }

            // Tải itembox4 (rương)
            jsar = (JSONArray) JSONValue.parse(rs.getString("itembox4_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 4;
                    if (temp.quantity > 0) {
                        item.box47.add(temp);
                    }
                }
                jsar.clear();
            }

            // Tải itembox7 (rương)
            jsar = (JSONArray) JSONValue.parse(rs.getString("itembox7_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 7;
                    if (temp.quantity > 0) {
                        item.box47.add(temp);
                    }
                }
                jsar.clear();
            }

            // Tải itemtui3 (túi phụ)
            jsar = (JSONArray) JSONValue.parse(rs.getString("itemtui3_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size() && i < maxtui; i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item3 temp = new Item3();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.clazz = Byte.parseByte(jsar2.get(1).toString());
                    temp.type = Byte.parseByte(jsar2.get(2).toString());
                    temp.level = Short.parseShort(jsar2.get(3).toString());
                    temp.icon = Short.parseShort(jsar2.get(4).toString());
                    temp.color = Byte.parseByte(jsar2.get(5).toString());
                    temp.part = Byte.parseByte(jsar2.get(6).toString());
                    temp.islock = Byte.parseByte(jsar2.get(7).toString()) == 1;
                    temp.name = ItemTemplate3.item.get(temp.id).getName();
                    if (temp.islock) {
                        temp.name += " [Khóa]";
                    }
                    temp.tier = Byte.parseByte(jsar2.get(8).toString());
                    JSONArray jsar3 = (JSONArray) JSONValue.parse(jsar2.get(9).toString());
                    temp.op = new ArrayList<>();
                    for (int j = 0; j < jsar3.size(); j++) {
                        JSONArray jsar4 = (JSONArray) JSONValue.parse(jsar3.get(j).toString());
                        temp.op.add(new Option(Byte.parseByte(jsar4.get(0).toString()), Integer.parseInt(jsar4.get(1).toString()), temp.id));
                    }
                    if (jsar2.size() >= 11) {
                        temp.tierStar = Byte.parseByte(jsar2.get(10).toString());
                    }
                    if (jsar2.size() >= 12) {
                        temp.time_use = Long.parseLong(jsar2.get(11).toString());
                    }
                    if (jsar2.size() >= 13) {
                        temp.expiry_date = Long.parseLong(jsar2.get(12).toString());
                    }
                    if (jsar2.size() >= 14) {
                        temp.isHopdo = Byte.parseByte(jsar2.get(13).toString());
                    }
                    temp.UpdateName();
                    if (temp.expiry_date == 0 || temp.expiry_date > _time) {
                        item.tui3[i] = temp;
                    }
                }
                jsar.clear();
            }

            // Tải itemtui4 (túi phụ)
            jsar = (JSONArray) JSONValue.parse(rs.getString("itemtui4_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 4;
                    if (temp.quantity > 0) {
                        item.tui47.add(temp);
                    }
                }
                jsar.clear();
            }

            // Tải itemtui7 (túi phụ)
            jsar = (JSONArray) JSONValue.parse(rs.getString("itemtui7_"));
            if (jsar != null) {
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 7;
                    if (temp.quantity > 0) {
                        item.tui47.add(temp);
                    }
                }
                jsar.clear();
            }
            //
            jsar = (JSONArray) JSONValue.parse(rs.getString("itemwear"));
            if (jsar == null) {
                return null;
            }
            for (Object o : jsar) {
                JSONArray jsar2 = (JSONArray) JSONValue.parse(o.toString());
                if (jsar2 == null) {
                    return null;
                }
                Item3 temp = new Item3();
                temp.id = Short.parseShort(jsar2.get(0).toString());
                temp.name = ItemTemplate3.item.get(temp.id).getName() + " [Khóa]";
                temp.clazz = Byte.parseByte(jsar2.get(1).toString());
                temp.type = Byte.parseByte(jsar2.get(2).toString());
                temp.level = Short.parseShort(jsar2.get(3).toString());
                temp.icon = Short.parseShort(jsar2.get(4).toString());
                temp.color = Byte.parseByte(jsar2.get(5).toString());
                temp.part = Byte.parseByte(jsar2.get(6).toString());
                temp.tier = Byte.parseByte(jsar2.get(7).toString());
                // if (temp.type == 15) {
                // temp.tier = 0;
                // }
                temp.islock = true;
                JSONArray jsar3 = (JSONArray) JSONValue.parse(jsar2.get(8).toString());
                temp.op = new ArrayList<>();
                for (int j = 0; j < jsar3.size(); j++) {
                    JSONArray jsar4 = (JSONArray) JSONValue.parse(jsar3.get(j).toString());
                    if (jsar4 == null) {
                        return null;
                    }
                    temp.op.add(
                            new Option(Byte.parseByte(jsar4.get(0).toString()), Integer.parseInt(jsar4.get(1).toString()), temp.id));
                }
                Byte idx = Byte.parseByte(jsar2.get(9).toString());
                if (jsar2.size() >= 11) {
                    temp.tierStar = Byte.parseByte(jsar2.get(10).toString());
                }
                if (jsar2.size() >= 12) {
                    temp.time_use = Long.parseLong(jsar2.get(11).toString());
                }
                if (jsar2.size() >= 13) {
                    temp.expiry_date = Long.parseLong(jsar2.get(12).toString());
                }
                if (jsar2.size() >= 14) {
                    temp.isHopdo = Byte.parseByte(jsar2.get(13).toString());
                }
                temp.time_use = 0;
                temp.UpdateName();
                if (temp.expiry_date == 0 || temp.expiry_date > _time) {
                    item.wear[idx] = temp;
                }
            }

            jsar.clear();
            jsar = (JSONArray) JSONValue.parse(rs.getString("rms_save"));
            if (jsar == null) {
                return null;
            }
            rms_save = new byte[jsar.size()][];
            for (int i = 0; i < rms_save.length; i++) {
                JSONArray js = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                rms_save[i] = new byte[js.size()];
                for (int j = 0; j < rms_save[i].length; j++) {
                    rms_save[i][j] = Byte.parseByte(js.get(j).toString());
                }
            }
            jsar.clear();
            //
            mypet = new ArrayList<>();
            pet_follow = -1;
            jsar = (JSONArray) JSONValue.parse(rs.getString("pet"));
            long t_off = 0;
            if (jsar == null) {
                return null;
            }
            for (int i = 0; i < jsar.size(); i++) {
                JSONArray js = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                Pet temp = new Pet();
                temp.setup(js);
                temp.update_grown(t_off);
                if (temp.is_follow) {
                    pet_follow = temp.get_id();
                }
                if (temp.expiry_date == 0 || _time < temp.expiry_date) {
                    mypet.add(temp);
                }
            }
            jsar.clear();
            list_friend = new ArrayList<>();
            jsar = (JSONArray) JSONValue.parse(rs.getString("friend"));
            if (jsar == null) {
                return null;
            }
            for (Object o : jsar) {
                JSONArray js12 = (JSONArray) JSONValue.parse(o.toString());
                Friend temp = new Friend();
                temp.name = js12.get(0).toString();
                temp.level = Short.parseShort(js12.get(1).toString());
                temp.head = Byte.parseByte(js12.get(2).toString());
                temp.hair = Byte.parseByte(js12.get(3).toString());
                temp.eye = Byte.parseByte(js12.get(4).toString());
                temp.itemwear = new ArrayList<>();
                JSONArray js2 = (JSONArray) JSONValue.parse(js12.get(5).toString());
                for (Object object : js2) {
                    JSONArray js3 = (JSONArray) JSONValue.parse(object.toString());
                    Part_player part = new Part_player();
                    part.type = Byte.parseByte(js3.get(0).toString());
                    part.part = Byte.parseByte(js3.get(1).toString());
                    temp.itemwear.add(part);
                }
                list_friend.add(temp);
            }
            jsar.clear();
            list_enemies = new ArrayList<>();
            jsar = (JSONArray) JSONValue.parse(rs.getString("enemies"));
            if (jsar == null) {
                return null;
            }
            for (Object o : jsar) {
                String n = o.toString();
                if (!list_enemies.contains(n)) {
                    list_enemies.add(n);
                }
            }
            jsar.clear();
            jsar = (JSONArray) JSONValue.parse(rs.getString("medal_create_material"));
            if (jsar == null) {
                return null;
            }
            medal_create_material = new short[jsar.size()];
            for (int i = 0; i < jsar.size(); i++) {
                medal_create_material[i] = Short.parseShort(jsar.get(i).toString());
            }
            jsar.clear();

            jsar = (JSONArray) JSONValue.parse(rs.getString("item_star_material"));
            if (jsar == null) {
                return null;
            }
            MaterialItemStar = new short[jsar.size()];
            for (int i = 0; i < jsar.size(); i++) {
                MaterialItemStar[i] = Short.parseShort(jsar.get(i).toString());
            }
            if (MaterialItemStar == null || MaterialItemStar.length < 40) {
                SetMaterialItemStar();
            }
            jsar.clear();
            setInfo();
            //
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return null;
        }
        //
        already_setup = true;
        return this;
    }

    public void flushSquire() {
        if (!already_setup) {
            return;
        }

        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement()) {
            // Đệ tử
            if (!isOwner) {
                String a = "`level` = " + level;
                a += ",`exp` = " + exp;
                JSONArray jsar = new JSONArray();
                jsar.add(head);
                jsar.add(eye);
                jsar.add(hair);
                a += ",`body` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                for (int i = 0; i < MainEff.size(); i++) {
                    EffTemplate temp = MainEff.get(i);
                    if (temp.id != -126 && temp.id != -125) {
                        continue;
                    }
                    JSONArray jsar21 = new JSONArray();
                    jsar21.add(temp.id);
                    jsar21.add(temp.param);
                    long time = temp.time - System.currentTimeMillis();
                    jsar21.add(time);
                    jsar.add(jsar21);
                }
                a += ",`eff` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                for (int i = 0; i < list_friend.size(); i++) {
                    JSONArray js12 = new JSONArray();
                    Friend temp = list_friend.get(i);
                    js12.add(temp.name);
                    js12.add(temp.level);
                    js12.add(temp.head);
                    js12.add(temp.hair);
                    js12.add(temp.eye);
                    JSONArray js = new JSONArray();
                    for (Part_player part : temp.itemwear) {
                        JSONArray js2 = new JSONArray();
                        js2.add(part.type);
                        js2.add(part.part);
                        js.add(js2);
                    }
                    js12.add(js);
                    jsar.add(js12);
                }
                a += ",`friend` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                for (int i = 0; i < 21; i++) {
                    jsar.add(skill_point[i]);
                }
                a += ",`skill` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                long _time = System.currentTimeMillis();
                JSONArray jsarItemWear = new JSONArray();

                for (int i = 0; i < item.wear.length; i++) {
                    Item3 temp = item.wear[i];
                    if (temp != null) {
                        if (temp.expiry_date != 0 && _time > temp.expiry_date) {
                            // Nếu trang bị đã hết hạn sử dụng, tháo trang bị và cập nhật thông tin
                            item.wear[i] = null;
                            try {
                                item.char_inventory(3);
                                fashion = Part_fashion.get_part(this);
                                Service.send_wear(this);
                                Service.send_char_main_in4(this);
                                MapService.update_in4_2_other_inside(this.map, this);
                            } catch (IOException eee) {
                                eee.printStackTrace();
                            }
                        } else {
                            // Thêm thông tin về trang bị vào JSON để lưu trữ, bao gồm expiry_date
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(temp.id);
                            jsar2.add(temp.clazz);
                            jsar2.add(temp.type);
                            jsar2.add(temp.level);
                            jsar2.add(temp.icon);
                            jsar2.add(temp.color);
                            jsar2.add(temp.part);
                            jsar2.add(temp.tier);
                            JSONArray jsar3 = new JSONArray();
                            for (int j = 0; j < temp.op.size(); j++) {
                                JSONArray jsar4 = new JSONArray();
                                jsar4.add(temp.op.get(j).id);
                                jsar4.add(temp.op.get(j).getParam(0));
                                jsar3.add(jsar4);
                            }
                            jsar2.add(jsar3);
                            jsar2.add(i);
                            jsar2.add(temp.tierStar);
                            jsar2.add(temp.time_use);
                            jsar2.add(temp.expiry_date);  // Đảm bảo expiry_date được lưu lại
                            jsar2.add(temp.isHopdo);
                            jsarItemWear.add(jsar2);
                        }
                    }
                }

                a += ",`itemwear` = '" + jsarItemWear.toJSONString() + "'";
                jsarItemWear.clear();
                for (int i = 0; i < list_enemies.size(); i++) {
                    jsar.add(list_enemies.get(i));
                }
                a += ",`enemies` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                for (int i = 0; i < rms_save.length; i++) {
                    JSONArray js = new JSONArray();
                    for (int i1 = 0; i1 < rms_save[i].length; i1++) {
                        js.add(rms_save[i][i1]);
                    }
                    jsar.add(js);
                }
                a += ",`rms_save` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                //
                for (int i = 0; i < mypet.size(); i++) {
                    JSONArray js1 = new JSONArray();
                    js1.add(mypet.get(i).level);
                    js1.add(mypet.get(i).type);
                    js1.add(mypet.get(i).icon);
                    js1.add(mypet.get(i).nframe);
                    js1.add(mypet.get(i).color);
                    js1.add(mypet.get(i).grown);
                    js1.add(mypet.get(i).maxgrown);
                    js1.add(mypet.get(i).point1);
                    js1.add(mypet.get(i).point2);
                    js1.add(mypet.get(i).point3);
                    js1.add(mypet.get(i).point4);
                    js1.add(mypet.get(i).maxpoint);
                    js1.add(mypet.get(i).exp);
                    js1.add(mypet.get(i).is_follow ? 1 : 0);
                    js1.add(mypet.get(i).is_hatch ? 1 : 0);
                    js1.add(mypet.get(i).time_born);
                    JSONArray js2 = new JSONArray();
                    for (int i2 = 0; i2 < mypet.get(i).op.size(); i2++) {
                        JSONArray js3 = new JSONArray();
                        js3.add(mypet.get(i).op.get(i2).id);
                        js3.add(mypet.get(i).op.get(i2).param);
                        js3.add(mypet.get(i).op.get(i2).maxdam);
                        js2.add(js3);
                    }
                    js1.add(js2);
                    js1.add(mypet.get(i).expiry_date);
                    jsar.add(js1);
                }
                a += ",`pet` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                //
                for (int i = 0; i < medal_create_material.length; i++) {
                    jsar.add(medal_create_material[i]);
                }
                a += ",`medal_create_material` = '" + jsar.toJSONString() + "'";
                jsar.clear();

                //
                for (int i = 0; i < MaterialItemStar.length; i++) {
                    jsar.add(MaterialItemStar[i]);
                }
                a += ",`item_star_material` = '" + jsar.toJSONString() + "'";
                jsar.clear();
                a += ",`tiemnang` = " + tiemnang;
                a += ",`kynang` = " + kynang;
                a += ",`hieuchien` = " + hieuchien;
                a += ",`typeexp` = " + type_exp;
                a += ",`date` = '" + date.toString() + "'";
                a += ",`point1` = " + point1;
                a += ",`point2` = " + point2;
                a += ",`point3` = " + point3;
                a += ",`point4` = " + point4;
                a += ",`point_arena` = " + pointarena;
                a += ",`time_khu2` = " + time_khu2;

                a += ",`vang_` = " + vang_;
                a += ",`kimcuong_` = " + kimcuong_;

                // Lưu item3 (túi đồ)
                JSONArray jsarBag3 = new JSONArray();
                for (int i = 0; i < item.bag3.length; i++) {
                    Item3 temp = item.bag3[i];
                    if (temp != null) {
                        JSONArray jsar2 = new JSONArray();
                        jsar2.add(temp.id);
                        jsar2.add(temp.clazz);
                        jsar2.add(temp.type);
                        jsar2.add(temp.level);
                        jsar2.add(temp.icon);
                        jsar2.add(temp.color);
                        jsar2.add(temp.part);
                        jsar2.add(temp.islock ? 1 : 0);
                        jsar2.add(temp.tier);
                        JSONArray jsar3 = new JSONArray();
                        for (Option op : temp.op) {
                            JSONArray jsar4 = new JSONArray();
                            jsar4.add(op.id);
                            jsar4.add(op.getParam(0));
                            jsar3.add(jsar4);
                        }
                        jsar2.add(jsar3);
                        jsar2.add(temp.tierStar);
                        jsar2.add(temp.time_use);
                        jsar2.add(temp.expiry_date);
                        jsar2.add(temp.isHopdo);
                        jsarBag3.add(jsar2);
                    }
                }
                a += ",`item3_` = '" + jsarBag3.toJSONString() + "'";

                // Lưu item4 và item7 (túi đồ)
                JSONArray jsarBag47_4 = new JSONArray();
                JSONArray jsarBag47_7 = new JSONArray();
                for (Item47 temp : item.bag47) {
                    JSONArray jsar2 = new JSONArray();
                    jsar2.add(temp.id);
                    jsar2.add(temp.quantity);
                    if (temp.category == 4) {
                        jsarBag47_4.add(jsar2);
                    } else if (temp.category == 7) {
                        jsarBag47_7.add(jsar2);
                    }
                }
                a += ",`item4_` = '" + jsarBag47_4.toJSONString() + "'";
                a += ",`item7_` = '" + jsarBag47_7.toJSONString() + "'";

                // Lưu itembox3 (rương)
                JSONArray jsarBox3 = new JSONArray();
                for (int i = 0; i < item.box3.length; i++) {
                    Item3 temp = item.box3[i];
                    if (temp != null) {
                        JSONArray jsar2 = new JSONArray();
                        jsar2.add(temp.id);
                        jsar2.add(temp.clazz);
                        jsar2.add(temp.type);
                        jsar2.add(temp.level);
                        jsar2.add(temp.icon);
                        jsar2.add(temp.color);
                        jsar2.add(temp.part);
                        jsar2.add(temp.islock ? 1 : 0);
                        jsar2.add(temp.tier);
                        JSONArray jsar3 = new JSONArray();
                        for (Option op : temp.op) {
                            JSONArray jsar4 = new JSONArray();
                            jsar4.add(op.id);
                            jsar4.add(op.getParam(0));
                            jsar3.add(jsar4);
                        }
                        jsar2.add(jsar3);
                        jsar2.add(temp.tierStar);
                        jsar2.add(temp.time_use);
                        jsar2.add(temp.expiry_date);
                        jsar2.add(temp.isHopdo);
                        jsarBox3.add(jsar2);
                    }
                }
                a += ",`itembox3_` = '" + jsarBox3.toJSONString() + "'";

                // Lưu itembox4 và itembox7 (rương)
                JSONArray jsarBox47_4 = new JSONArray();
                JSONArray jsarBox47_7 = new JSONArray();
                for (Item47 temp : item.box47) {
                    JSONArray jsar2 = new JSONArray();
                    jsar2.add(temp.id);
                    jsar2.add(temp.quantity);
                    if (temp.category == 4) {
                        jsarBox47_4.add(jsar2);
                    } else if (temp.category == 7) {
                        jsarBox47_7.add(jsar2);
                    }
                }
                a += ",`itembox4_` = '" + jsarBox47_4.toJSONString() + "'";
                a += ",`itembox7_` = '" + jsarBox47_7.toJSONString() + "'";

                // Lưu itemtui3 (túi phụ)
                JSONArray jsarTui3 = new JSONArray();
                for (int i = 0; i < item.tui3.length; i++) {
                    Item3 temp = item.tui3[i];
                    if (temp != null) {
                        JSONArray jsar2 = new JSONArray();
                        jsar2.add(temp.id);
                        jsar2.add(temp.clazz);
                        jsar2.add(temp.type);
                        jsar2.add(temp.level);
                        jsar2.add(temp.icon);
                        jsar2.add(temp.color);
                        jsar2.add(temp.part);
                        jsar2.add(temp.islock ? 1 : 0);
                        jsar2.add(temp.tier);
                        JSONArray jsar3 = new JSONArray();
                        for (Option op : temp.op) {
                            JSONArray jsar4 = new JSONArray();
                            jsar4.add(op.id);
                            jsar4.add(op.getParam(0));
                            jsar3.add(jsar4);
                        }
                        jsar2.add(jsar3);
                        jsar2.add(temp.tierStar);
                        jsar2.add(temp.time_use);
                        jsar2.add(temp.expiry_date);
                        jsar2.add(temp.isHopdo);
                        jsarTui3.add(jsar2);
                    }
                }
                a += ",`itemtui3_` = '" + jsarTui3.toJSONString() + "'";

                // Lưu itemtui4 và itemtui7 (túi phụ)
                JSONArray jsarTui47_4 = new JSONArray();
                JSONArray jsarTui47_7 = new JSONArray();
                for (Item47 temp : item.tui47) {
                    JSONArray jsar2 = new JSONArray();
                    jsar2.add(temp.id);
                    jsar2.add(temp.quantity);
                    if (temp.category == 4) {
                        jsarTui47_4.add(jsar2);
                    } else if (temp.category == 7) {
                        jsarTui47_7.add(jsar2);
                    }
                }
                a += ",`itemtui4_` = '" + jsarTui47_4.toJSONString() + "'";
                a += ",`itemtui7_` = '" + jsarTui47_7.toJSONString() + "'";

                if (ps.executeUpdate("UPDATE `squire` SET " + a + " WHERE `id` = " + this.index + ";") > 0) {
                    connection.commit();
                }
                if (connection != null) {
                    ps.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sendMove(Player p) throws IOException {
        if (delay_move < System.currentTimeMillis()) {
            if (Point.Distance(this.x, this.y, p.x, p.y) < 150) {
                Point point = Point.getPoint(p.x, p.y, 100);
                this.x = (short) point.x;
                this.y = (short) point.y;
            } else {
                this.x = p.x;
                this.y = p.y;
            }

            Message m12 = new Message(4);
            m12.writer().writeByte(0);
            m12.writer().writeShort(0);
            m12.writer().writeShort(this.index);
            m12.writer().writeShort(this.x);
            m12.writer().writeShort(this.y);
            m12.writer().writeByte(-1);
            Squire.send_msg_player_inside(map, this, m12, true);
            m12.cleanup();
        }
    }

    public static void squireEnterMap(Player p) {
        try {
            if (p.squire != null) {
                Map map = p.map;
                p.squire.map = map;
                if (!map.players.contains(p.squire)) {
                    map.players.add(p.squire);
                }
                Squire s = p.squire;
                s.isdie = false;
                s.hp = s.body.get_HpMax();
                s.timedie = 0;
                // Đặt lại vị trí của Squire trùng với vị trí của người chơi
                s.x = p.x;
                s.y = p.y;
                // MapService.update_in4_2_other_inside(p.map, s);

                MapService.update_in4_2_other_inside(map, p.squire);
            } else {
                Service.send_notice_box(p.conn, "Chưa có đệ tử, hãy đến NPC Oda để đổi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void squireLeaveMap(Player p) {
        try {
            if (p.squire != null) {
                Map map = p.map;
                map.players.remove(p.squire);
                Message m = new Message(8);
                m.writer().writeShort(p.squire.index);
                Squire.send_msg_player_inside(map, p.squire, m, true);
                m.cleanup();
                p.squire.map = null;
                p.squire.isdie = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] chat = new String[]{"Sư phụ, đợi con với!", "Sư phụ, con đói quá!", "Sư phụ, mình đi đâu thế?", "Sư phụ, nguy hiểm quá!"};

    public static void update(Player p) {
        try {
            if (p.squire != null && p.isLiveSquire) { // Kiểm tra xem người chơi có Squire và Squire đã được gọi ra hay chưa
                if (p.typepk != p.squire.typepk) {
                    MapService.change_flag(p.map, p.squire, p.typepk);
                }
                Squire s = p.squire;

                if (s.isdie) { // Kiểm tra xem Squire có đang chết không
                    if (s.timedie == 0) { // Nếu Squire vừa mới chết, lưu thời gian chết
                        s.timedie = System.currentTimeMillis();
                    } else if (System.currentTimeMillis() - s.timedie >= 30_000) { //
                        // Hồi sinh Squire
                        s.isdie = false;
                        s.hp = s.body.get_HpMax();
                        s.timedie = 0;
                        // Đặt lại vị trí của Squire trùng với vị trí của người chơi
                        s.x = p.x;
                        s.y = p.y;
                        MapService.update_in4_2_other_inside(p.map, s);
                        MapService.SendChat(p.map, s, "Con đây nè sư phụ", false);
                    }
                } else {
                    s.sendMove(p);
                    if (s.delay_chat < System.currentTimeMillis()) {
                        s.delay_chat = System.currentTimeMillis() + 15000L;
                        MapService.SendChat(p.map, s, chat[Util.random(chat.length)], false);
                    }
                    s.autoAttack();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Byte> get_skill_can_use() {
        ArrayList<Byte> skills = new ArrayList<>();
        byte[] id_skill = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 19, 20};
        for (int i = 0; i < id_skill.length; i++) {
            if (this.skill_point[id_skill[i]] > 0) {
                skills.add(id_skill[i]);
            }
        }
        return skills;
    }

    public void use_skill(Map map, Session conn, int n, int ObjAtk, short n3, int type_atk) {
        try {
            ArrayList<Byte> id_skill = get_skill_can_use();
            long time_ = System.currentTimeMillis();
            byte index_skill = 0;

            if (id_skill.size() > 1) {
                index_skill = id_skill.get(Util.random(id_skill.size() - 1));
            } else if (id_skill.size() == 1) {
                index_skill = id_skill.get(0);
            }

            while (time_ < this.time_delay_skill[index_skill] && this.skill_point[index_skill] < 1) {
                index_skill = id_skill.get(Util.random(id_skill.size() - 1));
            }

            int sk_point1 = this.skill_point[index_skill];
            if (sk_point1 < 1) {
                return;
            }

            if (this.item.wear[0] == null) {
                return;
            }

            LvSkill _skill = this.skills[index_skill].mLvSkill[sk_point1 - 1];
            while (sk_point1 > 1 && _skill.LvRe > this.level) {
                sk_point1--;
                _skill = this.skills[index_skill].mLvSkill[sk_point1 - 1];
            }

            if (_skill.LvRe > this.level) {
                return;
            }

            int sk_pointPlus = this.get_skill_point_plus(index_skill);
            if (sk_point1 + sk_pointPlus <= 15) {
                _skill = this.skills[index_skill].mLvSkill[(sk_point1 + sk_pointPlus) - 1];
            } else {
                _skill = this.skills[index_skill].mLvSkill[14];
            }

            if (this.mp + _skill.mpLost < 0) {
                return;
            }

            // Bắt đầu tính dame
            this.mp += _skill.mpLost;
            n = (_skill.nTarget < n) ? _skill.nTarget : n;
            this.time_delay_skill[index_skill] = (long) (time_ + _skill.delay * 0.99);
            byte type = 0;
            List<Integer> ListATK = new ArrayList<>();

            // Kiểm tra xem kỹ năng có phải là kỹ năng đánh lan không
            if (_skill.range_lan > 0) { // Nếu kỹ năng có phạm vi lan
                // Tìm tất cả các mục tiêu trong phạm vi
                List<MainObject> targets = findTargetsInRange(map, this.x, this.y, _skill.range_lan);
                for (MainObject target : targets) {
                    if (target != null && !target.isdie) {
                        //  Squire.SquireAttack(map, this, target, index_skill, _skill, type);
                        MainObject.MainAttack(map, this, target, index_skill, _skill, 1);
                        ListATK.add(target.index); // Thêm mục tiêu vào danh sách tấn công
                    }
                }
            } else {
                // Nếu không phải là kỹ năng đánh lan, thực hiện tấn công như bình thường
                if (type_atk == 0) {
                    for (int i = 0; i < n; ++i) {
                        Mob_in_map mob_target = MapService.get_mob_by_index(map, ObjAtk);
                        if (mob_target == null) {
                            mob_target = map.GetBoss(ObjAtk);
                        }
                        if (map.zone_id == 5 && !map.isMapChiemThanh() && !map.isMapLoiDai()) {
                            Pet_di_buon pet_di_buon = Pet_di_buon_manager.check(ObjAtk);
                            if (pet_di_buon != null) {
                                if (!pet_di_buon.equals(conn.p.pet_di_buon)) {
                                    Squire.SquireAttack(map, this, pet_di_buon, index_skill, _skill, type);
                                }
                            }
                        } else if (mob_target != null) {
                            //Squire.SquireAttack(map, this, mob_target, index_skill, _skill, type);
                            MainObject.MainAttack(map, this, mob_target, index_skill, _skill, 1);
                        } else if (ObjAtk > 10000 && ObjAtk < 11000) { // mob boss
                            Message m2 = new Message(17);
                            m2.writer().writeShort(-1);
                            m2.writer().writeShort(ObjAtk);
                            conn.addmsg(m2);
                            m2.cleanup();
                        } else if (conn.p.map.map_id == 48) {
                            Dungeon d = DungeonManager.get_list(conn.p.name);
                            if (d != null) {
                                Mob_Dungeon mod_target_dungeon = d.get_mob(ObjAtk);
                                if (mod_target_dungeon != null) {
                                    Squire.SquireAttack(map, this, mod_target_dungeon, index_skill, _skill, type);
                                }
                            }
                        } else if (Map.is_map_chiem_mo(conn.p.map, true) && conn.p.myclan != null) {
                            Mob_MoTaiNguyen temp_mob = conn.p.myclan.get_mo_tai_nguyen(conn.p.map.map_id);
                            if (temp_mob == null) {
                                temp_mob = Manager.gI().chiem_mo.get_mob_in_map(map);
                                Squire.SquireAttack(map, this, temp_mob, index_skill, _skill, type);
                            }
                        }
                        if (mob_target != null && mob_target.isBoss()) {
                            ListATK.add(mob_target.index);
                        }
                    }
                } else if (type_atk == 1) {
                    for (int i = 0; i < n; ++i) {
                        int n2 = Short.toUnsignedInt(n3);
                        Player p_target = null;
                        if ((p_target = MapService.get_player_by_id(map, n2)) != null) {
                            // đánh người chơi
                            Squire.SquireAttack(map, this, p_target, index_skill, _skill, type);
                            ListATK.add(p_target.index);
                        } else if (Map.is_map_chiem_mo(conn.p.map, true) && conn.p.myclan != null) {
                            // đánh nhân bản
                            Mob_MoTaiNguyen temp_mob = conn.p.myclan.get_mo_tai_nguyen(conn.p.map.map_id);
                            if (temp_mob == null) {
                                temp_mob = Manager.gI().chiem_mo.get_mob_in_map(conn.p.map);
                                if (temp_mob.nhanban != null && temp_mob.nhanban.index == n2) {
                                    ListATK.add(temp_mob.nhanban.index);
                                    Squire.SquireAttack(map, this, temp_mob.nhanban, index_skill, _skill, type);
                                }
                            }
                        } else {
                            if (n3 >= -1000 && n3 < 0) {
                                for (MobAi ai : map.Ai_entrys) {
                                    if (ai != null && ai.index == n3) {
                                        try {
                                            Squire.SquireAttack(map, this, ai, index_skill, _skill, type);
                                            ListATK.add(ai.index);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    }
                                }
                            } else {
                                // LinhCanh.atk1(map, this, n2, index_skill, (int) 3000);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// Phương thức tìm các mục tiêu trong phạm vi
    private List<MainObject> findTargetsInRange(Map map, int x, int y, int range) {
        List<MainObject> targets = new ArrayList<>();
        for (Mob_in_map mob : map.mobs) {
            if (!mob.isdie && Point.Distance(x, y, mob.x, mob.y) <= range) {
                targets.add(mob);
            }
        }
        for (Player player : map.players) {
            if (!player.isdie && Point.Distance(x, y, player.x, player.y) <= range) {
                targets.add(player);
            }
        }
        return targets;
    }

    public static void SquireAttack(Map map, MainObject ObjAtk, MainObject focus, int idxSkill, LvSkill temp, int type) throws IOException {
        // pvp, pve, mob chiến trường, mob chiếm thành, nhân bản boss, (không đánh mob đi buôn)

        //<editor-fold defaultstate="collapsed" desc="... không thể tấn công    ...">
        if (ObjAtk == null || focus == null || ObjAtk.equals(focus) || ObjAtk.isdie || ObjAtk.isStunes(true)) {
            return;
        }
        if (ObjAtk.isPlayer() && focus.isPlayer() && !map.isMapChiemThanh() && (map.ismaplang || ObjAtk.level < 10 || focus.level < 11
                || (ObjAtk.typepk != 0 && ObjAtk.typepk == focus.typepk) || ObjAtk.hieuchien > 32_000)) {
            return;
        }
        if (focus.isMob() && focus.template.mob_id == 152 && !ChiemThanhManager.isDameTruChinh(map)) {
            return;
        }
        // if (focus.isMob() && focus.isBoss() && Math.abs(focus.level - ObjAtk.level) > 5) {
        // return;
        // }
        if (ObjAtk.isStunes(true)) {
            return;
        }
        if (focus.isPlayer() && focus.get_EffMe_Kham(StrucEff.TangHinh) != null) {
            return;
        }
        if (ObjAtk.isPlayer() && ObjAtk.get_EffMe_Kham(StrucEff.LuLan) != null) {
            return;
        }
        if (focus.isdie || focus.hp <= 0 && ObjAtk.isPlayer()) {
            if (focus.isPlayer()) {
                MapService.Player_Die(map, (Player) focus, ObjAtk, false);
            } else {
                MapService.MainObj_Die(map, ((Player) ObjAtk).conn, focus, false);
            }
            return;
        }
        if (ObjAtk.isPlayer() && focus.isPlayer() && focus.typepk == -1)// đồ sát
        {
            if (((Player) focus).pet_follow == 4708) {
                return;
            }
        }
        if (focus.get_Miss() > Util.random(10_000)) {
            if (ObjAtk.isPlayer()) {
                MapService.Fire_Player(map, ((Player) ObjAtk).conn, idxSkill, focus.index, 0, focus.hp, new ArrayList<>());
            }
            return;
        }
        //</editor-fold>
        Player p = ObjAtk.isPlayer() ? (Player) ObjAtk : null;
        EffTemplate ef;
        long dame = ObjAtk.get_DameBase() * 3L;
        int hutHP = 0;
        float ptCrit = 0;
        float DamePlus = 0;
        float GiamDame = 0;
        boolean xuyengiap = ObjAtk.get_Pierce() > Util.random(10_000);

        //<editor-fold defaultstate="collapsed" desc="Get Dame default...">
        if (type == 0) {
            int tempDameProp = ObjAtk.get_DameProp(0);
            int dameProp = tempDameProp - (int) (xuyengiap ? 0 : tempDameProp * 0.0001 * focus.get_PercentDefProp(16));
            dame += dameProp < 0 ? 0 : dameProp;
        } else if (type == 1) {
            switch (ObjAtk.clazz) {
                case 0: {
                    int tempDameProp = ObjAtk.get_DameProp(2);
                    int dameProp = tempDameProp - (int) (xuyengiap ? 0 : tempDameProp * 0.0001 * focus.get_PercentDefProp(18));
                    dame += dameProp < 0 ? 0 : dameProp;
                    break;
                }
                case 1: {
                    int tempDameProp = ObjAtk.get_DameProp(4);
                    int dameProp = tempDameProp - (int) (xuyengiap ? 0 : tempDameProp * 0.0001 * focus.get_PercentDefProp(20));
                    dame += dameProp < 0 ? 0 : dameProp;
                    break;
                }
                case 2: {
                    int tempDameProp = ObjAtk.get_DameProp(1);
                    int dameProp = tempDameProp - (int) (xuyengiap ? 0 : tempDameProp * 0.0001 * focus.get_PercentDefProp(17));
                    dame += dameProp < 0 ? 0 : dameProp;
                    break;
                }
                case 3: {
                    int tempDameProp = ObjAtk.get_DameProp(3);
                    int dameProp = tempDameProp - (int) (xuyengiap ? 0 : tempDameProp * 0.0001 * focus.get_PercentDefProp(19));
                    dame += dameProp < 0 ? 0 : dameProp;
                    break;
                }
            }
        } else {
            dame += ObjAtk.get_DameProp(0);
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Skill...">
        if (ObjAtk.isPlayer()) {
            if (idxSkill == 19 && ObjAtk.clazz == 1) {
                for (Option op : temp.minfo) {
                    if (op.id == 4) {
                        dame += op.getParam(0);
                    }
                    if (op.id == 11) {
                        dame += dame * (op.getParam(0) / 100) / 100;
                    }
                }
            } else {
                for (int i = temp.minfo.length - 1; i >= 0; i--) {
                    Option op = temp.minfo[i];
                    if (type == 0) {
                        if (op.id == 0) {
                            dame += op.getParam(0);
                        }
                        if (op.id == 7) {
                            dame += dame * (op.getParam(0) / 100) / 100;
                        }
                    } else {
                        if (op.id == 1 || op.id == 2 || op.id == 3 || op.id == 4) {
                            dame += op.getParam(0);
                        }
                        if (op.id == 9 || op.id == 10 || op.id == 11 || op.id == 8) {
                            dame += dame * (op.getParam(0) / 100) / 100;
                        }
                    }
                }
            }
        }

        //</editor-fold>
        List<Float> giamdame = new ArrayList<>();
        ef = ObjAtk.get_EffDefault(3);
        if (ef != null) {
            giamdame.add((float) 0.2);
            GiamDame += 0.2;
//            DamePlus -= 0.2;
//            dame = (dame / 10) * 8;
        }
        if (ObjAtk.isPlayer() && p.getlevelpercent() < 0) {
            giamdame.add((float) 0.5);
            GiamDame += 0.5;
        }

        ef = ObjAtk.get_EffDefault(53);
        int hpmax = ObjAtk.get_HpMax();
        int HoiHP = 0;
        if (ef != null && ObjAtk.hp < hpmax) {
            HoiHP += hpmax / 100;
        }

        //<editor-fold defaultstate="collapsed" desc="Tác dụng mề...">
        boolean isEffKhaiHoan = focus.isPlayer() && focus.get_EffMe_Kham(StrucEff.NgocKhaiHoan) != null;
        int prMeday = 0;
        if (focus.isPlayer()) {
            giamdame.add((float) (((Player) focus).total_item_param(80) * 0.0001));
        }
//        GiamDame += focus.isPlayer() ? (float) (((Player) focus).total_item_param(80) * 0.0001) : 0;//giáp hắc ám
        if (ObjAtk.isPlayer()) {
            if ((ef = ObjAtk.get_EffMe_Kham(StrucEff.TangHinh)) == null && ObjAtk.total_item_param(82) > Util.random(10_000)) {
                ObjAtk.add_EffMe_Kham(StrucEff.TangHinh, 0, System.currentTimeMillis() + (prMeday = ObjAtk.total_item_param(81)));
                Eff_special_skill.send_eff_TangHinh(p, 81, prMeday);
            } else if ((ef = ObjAtk.get_EffMe_Kham(StrucEff.KhienMaThuat)) == null && ObjAtk.total_item_param(85) > Util.random(10_000)) {
                ObjAtk.add_EffMe_Kham(StrucEff.KhienMaThuat, 0, System.currentTimeMillis() + (prMeday = ObjAtk.total_item_param(86)));
                Eff_special_skill.send_eff_Meday(p, 86, prMeday);
            }
        }
        if (focus.isPlayer() && !isEffKhaiHoan) {
            if (focus.get_EffMe_Kham(StrucEff.BongLua) == null && ObjAtk.total_item_param(76) > Util.random(10_000)) {
                focus.add_EffMe_Kham(StrucEff.BongLua, 0, System.currentTimeMillis() + (prMeday = ObjAtk.total_item_param(77)));
                Eff_special_skill.send_eff_Meday((Player) focus, 77, prMeday);
            } else if (focus.get_EffMe_Kham(StrucEff.BongLanh) == null && ObjAtk.total_item_param(78) > Util.random(10_000)) {
                focus.add_EffMe_Kham(StrucEff.BongLanh, 0, System.currentTimeMillis() + (prMeday = ObjAtk.total_item_param(79)));
                Eff_special_skill.send_eff_Meday((Player) focus, 79, prMeday);
            } else if (focus.get_EffMe_Kham(StrucEff.LuLan) == null && ObjAtk.total_item_param(87) > Util.random(10_000)) {
                focus.add_EffMe_Kham(StrucEff.LuLan, 0, System.currentTimeMillis() + (prMeday = ObjAtk.total_item_param(88)));
                Eff_special_skill.send_eff_Meday((Player) focus, 88, prMeday);
            }
            if (focus.get_EffMe_Kham(StrucEff.KhienMaThuat) != null) {
                GiamDame += 0.5;
                giamdame.add((float) 0.5);
            }
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Tác dụng khảm...">
        int prKham = 0;
        if (focus.isPlayer() && (ObjAtk.isBoss() || ObjAtk.get_TypeObj() == 0)) {
            if (!isEffKhaiHoan && (prKham = focus.total_item_param(101)) > 0) {
                if (focus.kham.idAtk_KH == ObjAtk.index) {
                    focus.kham.CountAtk_KH++;
                } else {
                    focus.kham.idAtk_KH = ObjAtk.index;
                    focus.kham.CountAtk_KH = 1;
                }

                if (focus.kham.CountAtk_KH >= prKham) {
                    focus.kham.idAtk_KH = 0;
                    focus.kham.CountAtk_KH = 0;
                    focus.add_EffMe_Kham(StrucEff.NgocKhaiHoan, 0, System.currentTimeMillis() + 3000);
                    Eff_special_skill.send_eff_kham((Player) focus, StrucEff.NgocKhaiHoan, 3000);
                }
            }

            if ((ef = focus.get_EffMe_Kham(StrucEff.NgocLucBao)) != null) {
                hutHP += (int) (dame * 0.1);
            } else if ((prKham = focus.total_item_param(102)) > Util.random(10000)) {
                focus.add_EffMe_Kham(StrucEff.NgocLucBao, prKham, System.currentTimeMillis() + 3000);
                Eff_special_skill.send_eff_kham((Player) focus, StrucEff.NgocLucBao, 3000);
            }
        }

        if (ObjAtk.isPlayer()) {
            if ((focus.isBoss() || focus.get_TypeObj() == 0)) {
                if (ObjAtk.get_EffMe_Kham(StrucEff.NgocHonNguyen) != null) {
                    DamePlus += 1;
                }
            }

            double ptHP = (ObjAtk.hp / ObjAtk.get_HpMax()) * 100;
            if ((ef = ObjAtk.get_EffMe_Kham(StrucEff.NgocPhongMa)) != null) {
                HoiHP += (int) (hpmax * ef.param * 0.0001);
            } else if (ptHP < ObjAtk.total_item_param(104) / 100 && (prKham = ObjAtk.total_item_param(103)) > Util.random(10_000)) {
                ObjAtk.add_EffMe_Kham(StrucEff.NgocPhongMa, prKham, System.currentTimeMillis() + 5000);
                Eff_special_skill.send_eff_kham(p, StrucEff.NgocPhongMa, 5000);
            }

            if (focus.isBoss() && (ef = ObjAtk.get_EffMe_Kham(StrucEff.NgocSinhMenh)) != null) {
                DamePlus += 0.5;
//                dame += (long)(dame * 0.5);
            } else if (focus.isBoss() && (prKham = ObjAtk.total_item_param(106)) > Util.random(10_000)) {
                ObjAtk.add_EffMe_Kham(StrucEff.NgocSinhMenh, prKham, System.currentTimeMillis() + 3000);
                Eff_special_skill.send_eff_kham(p, StrucEff.NgocSinhMenh, 3000);
            }
            ptCrit += ObjAtk.total_item_param(107) * 0.0001;
        }
        //</editor-fold>

        dame += (long) (dame * DamePlus);

        int def = focus.get_DefBase();

        if (dame > 2_000_000_000) {
            dame = 2_000_000_000;
        }
        dame -= (long) (dame * 0.35);
        dame -= (xuyengiap ? 0 : def);
        if (!giamdame.isEmpty()) {
            for (float f : giamdame) {
                dame -= (long) (dame * f);
            }
        }

        if (ObjAtk.isPlayer() && focus.isMob()) {
            boolean check_mob_roi_ngoc_kham = focus.template.mob_id >= 167 && focus.template.mob_id <= 172;
            if (check_mob_roi_ngoc_kham) {
                if (50 > Util.random(100)) {
                    dame = 0;
                } else {
                    dame = 1;
                }
            }
            boolean check = dame < 0
                    || (focus.isBoss() && Math.abs(focus.level - ObjAtk.level) >= 5 && focus.level < 120 && focus.template.mob_id != 174 && !Map.is_map_cant_save_site(focus.map_id))
                    || (focus.isBoss() && focus.template.mob_id == 174 && map.zone_id == 0 && ObjAtk.level > 89)
                    || (focus.isBoss() && focus.template.mob_id == 174 && map.zone_id == 2 && !(ObjAtk.level >= 90 && ObjAtk.level < 110))
                    || (focus.isBoss() && focus.template.mob_id == 174 && map.zone_id == 3 && ObjAtk.level < 110);

            if (check) {
                dame = 0;
            }
        }
        if (focus.isMoTaiNguyen() && ObjAtk.isPlayer()) {
            Mob_MoTaiNguyen mo = (Mob_MoTaiNguyen) focus;
            if (!mo.is_atk) {
                dame = 0;
            } else if (mo.nhanban != null && !mo.nhanban.isdie) {
                mo.nhanban.p_target = (Player) ObjAtk;
                mo.nhanban.is_move = false;
            }
        }

        if (ObjAtk.isPlayer() && HoiHP > 0) {
            Service.usepotion(p, 0, HoiHP);
        }
        if (idxSkill == 17 && ObjAtk.isPlayer() && focus.isPlayer()) {
            MapService.add_eff_skill(map, p, (Player) focus, (byte) idxSkill);
        }

        //<editor-fold defaultstate="collapsed" desc="Hiệu ứng Crit vv       ...">
        List<Eff_TextFire> ListEf = new ArrayList<>();

        if (hutHP > 0) {
            ListEf.add(new Eff_TextFire(0, (int) dame));
            ListEf.add(new Eff_TextFire(2, hutHP));
            focus.hp += hutHP;
            if (focus.hp > focus.get_HpMax()) {
                focus.hp = focus.get_HpMax();
            }
        }
        if (xuyengiap) {
            ListEf.add(new Eff_TextFire(1, (int) dame));
        } else if (ObjAtk.get_Crit() > Util.random(10_000)) {
            //       dame *= 2;
            dame += (long) (dame * (ptCrit + 1));
            if (dame > 2_000_000_000) {
                dame = 2_000_000_000;
            }
            ListEf.add(new Eff_TextFire(4, (int) dame));
        }

        //<editor-fold defaultstate="collapsed" desc="Phản Dame       ...">
        if (focus.get_PhanDame() > Util.random(10_000)) {
            int DAMEpst = (int) (dame * 0.5);
            DAMEpst -= ObjAtk.get_DefBase();
            if (type == 1) {
                if (ObjAtk.clazz == 0) {
                    DAMEpst -= (int) (DAMEpst * 0.0001 * ObjAtk.get_PercentDefProp(18));
                } else if (ObjAtk.clazz == 1) {
                    DAMEpst -= (int) (DAMEpst * 0.0001 * ObjAtk.get_PercentDefProp(20));
                } else if (ObjAtk.clazz == 2) {
                    DAMEpst -= (int) (DAMEpst * 0.0001 * ObjAtk.get_PercentDefProp(17));
                } else if (ObjAtk.clazz == 3) {
                    DAMEpst -= (int) (DAMEpst * 0.0001 * ObjAtk.get_PercentDefProp(19));
                }
            } else {
                DAMEpst -= (int) (DAMEpst * 0.0001 * ObjAtk.get_PercentDefProp(16));
            }
            if (DAMEpst <= 0) {
                DAMEpst = 1;
            }

            ListEf.add(new Eff_TextFire(5, DAMEpst));
            ObjAtk.hp -= DAMEpst;
            if (ObjAtk.hp <= 0) {
                ObjAtk.hp = 5;
            }
        }
        //</editor-fold> Phản Dame

        //</editor-fold>    hiệu ứng crit vv
        //<editor-fold defaultstate="collapsed" desc="Set hp       ...">
        // xả item chiến trường
        long time = System.currentTimeMillis();
        if (ObjAtk.isMobCTruong() && map.Arena != null && map.Arena.timeCnNha > time) {
            dame *= 2;
        } else if (!ObjAtk.isPlayer() && ObjAtk.get_TypeObj() == 0 && map.Arena != null && map.Arena.timeCnLinh > time) {
            dame *= 2;
        }
        if (dame > 2_000_000_000) {
            dame = 2_000_000_000;
        } else if (dame <= 0) {
            dame = 1;
        }
        float ptHP = ((float) focus.hp / focus.get_HpMax()) * 100;
        if (focus.isMobDiBuon()) {
            dame = focus.get_HpMax() * 5L / 100;
        }
        int damePlus = 0;
        int idPlus = 12;
        if ((damePlus = p.getDameBt()) > 0) {
            idPlus = 11;
        } else if ((damePlus = p.getDameAs()) > 0) {
            idPlus = 10;
        }
        if (map.map_id == 124 && (focus.isBoss() || focus.isPlayer())) {
            dame = 1;
            damePlus = 0;
        }
        focus.hp -= damePlus;
        focus.hp -= (int) dame;

        if (focus.hp <= 0) {
            if (focus.isPlayer() && ptHP > 70) {
                focus.hp = 5;
            } else {
                if (map.isMapChiemThanh()) {
                    ChiemThanhManager.Obj_Die(map, ObjAtk, focus);
                }
                focus.SetDie(map, ObjAtk);
                if (focus.isPlayer()) {
                    MapService.Player_Die(map, focus, ObjAtk, true);
                } else {
                    MapService.MainObj_Die(map, null, focus, true);
                }

            }
        }

        if (ObjAtk.isPlayer() && (focus.isPlayer() || focus.get_TypeObj() == 0)) {
            Squire.Fire_Player(map, (Squire) ObjAtk, idxSkill, focus.index, (int) dame, focus.hp, ListEf);
        } else if (ObjAtk.isPlayer() && focus.get_TypeObj() == 1) {
            if (!map.isMapChienTruong()) {
                Squire.Fire_Mob(map, (Squire) ObjAtk, idxSkill, focus.index, (int) dame, focus.hp, ListEf, idPlus, damePlus);
            }
        } else if (ObjAtk.get_TypeObj() == 1 && focus.isPlayer()) {
            MapService.mob_fire(map, (Mob_in_map) ObjAtk, (Player) focus, (int) dame);
        } else if (ObjAtk.get_TypeObj() == 0 && focus.isPlayer()) {
            MapService.MainObj_Fire_Player(map, (Player) focus, ObjAtk, idxSkill, (int) dame, ListEf);
        }
    }

    public static void Fire_Mob(Map map, Squire squire, int indexskill, int idPTaget, int dame, int hpPtaget, List<Eff_TextFire> ListFire, int idPlus, int damePlus) throws IOException {

        Message m = new Message(9);
        m.writer().writeShort(squire.index);
        m.writer().writeByte(indexskill);
        m.writer().writeByte(1);
        m.writer().writeShort(idPTaget);
        m.writer().writeInt(dame); // dame
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
        }
        m.writer().writeInt(squire.hp);
        m.writer().writeInt(squire.mp);
        m.writer().writeByte(idPlus);
        m.writer().writeInt(damePlus);
        Squire.send_msg_player_inside(map, squire, m, true);
        m.cleanup();
    }

    public static void Fire_Player(Map map, Squire squire, int indexskill, int idPTaget, int dame, int hpPtaget, List<Eff_TextFire> ListFire) throws IOException {
        Message m = new Message(6);
        m.writer().writeShort(squire.index);
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
        m.writer().writeInt(squire.hp);
        m.writer().writeInt(squire.mp);
        m.writer().writeByte(11);
        m.writer().writeInt(0);
        Squire.send_msg_player_inside(map, squire, m, true);
        m.cleanup();
    }

    public static void send_msg_player_inside(Map map, MainObject mainObj, Message m, boolean included) {
        for (int i = 0; i < map.players.size(); i++) {
            Player p0 = map.players.get(i);
            if (p0 != null && ((Math.abs(p0.x - mainObj.x) < 1000 && Math.abs(p0.y - mainObj.y) < 1000)
                    || Map.is_map__load_board_player(map.map_id)) && (included || (mainObj.index != p0.index))) {
                p0.conn.addmsg(m);
            }
        }
    }

    public static void create(Player p) throws IOException {
        try (Connection connnect = SQL.gI().getConnection(); PreparedStatement ps = connnect.prepareStatement(
                "INSERT INTO `squire` (`name`, `body`, `clazz`, `site`, `tiemnang`, `kynang`, "
                + "`point1`, `point2`, `point3`, `point4`, `itemwear`, `rms_save`, `date`, "
                + "`skill`, `typeexp`, `medal_create_material`,`count_dungeon`, `id`, `friend`, `eff`, `enemies`, `pet`, `vang_`, `kimcuong_`) "
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")) {
            ps.setNString(1, p.name);
            byte clazz = (byte) Util.random(4);
            byte[] body = randomBody(clazz);
            JSONArray jsar = new JSONArray();
            jsar.add(body[0]);
            jsar.add(body[1]);
            jsar.add(body[2]);
            ps.setNString(2, jsar.toJSONString());
            jsar.clear();
            ps.setByte(3, clazz);
            ps.setNString(4, "[]");
            ps.setShort(5, (short) 45);
            ps.setShort(6, (short) 9);
            ps.setShort(7, (short) 5);
            ps.setShort(8, (short) 5);
            ps.setShort(9, (short) 5);
            ps.setShort(10, (short) 5);
            switch (clazz) {
                case 0: {
                    ps.setNString(11,
                            "[[0,0,8,1,0,0,0,0,[[0,54],[40,120]],0],[80,0,0,1,16,0,0,0,[[14,52],[16,100]],1],[120,0,1,1,24,0,0,0,[[14,18],[25,3]],7]]");
                    break;
                }
                case 1: {
                    ps.setNString(11,
                            "[[5,1,9,1,1,0,0,0,[[0,54],[40,120]],0],[105,1,0,1,21,0,1,0,[[14,52],[20,100]],1],[145,1,1,1,29,0,1,0,[[14,18],[24,3]],7]]");
                    break;
                }
                case 2: {
                    ps.setNString(11,
                            "[[10,2,11,1,2,0,0,0,[[0,50],[40,120]],0],[90,2,0,1,18,0,2,0,[[14,42],[16,200]],1],[50,2,2,1,10,0,2,0,[[7,200],[14,12]],6],[130,2,1,1,26,0,2,0,[[14,12],[26,4]],7]]");
                    break;
                }
                default: {
                    ps.setNString(11,
                            "[[15,3,10,1,3,0,0,0,[[0,50],[40,120]],0],[95,3,0,1,19,0,3,0,[[14,44],[16,200]],1],[55,3,2,1,11,0,3,0,[[7,200],[14,14]],6],[135,3,1,1,27,0,3,0,[[14,14],[24,4]],7]]");
                    break;
                }
            }
            ps.setNString(12, "[[],[]]");
            ps.setNString(13, java.util.Date.from(Instant.now()).toString());
            jsar.add(1);
            for (int i = 0; i < 20; i++) {
                jsar.add(0);
            }
            ps.setNString(14, jsar.toJSONString());

            ps.setInt(15, 1);
            ps.setNString(16, "[295,261,318,328,341,249,285,321,329,344,284,280,316,327,344,288,280,317,327,342]");
            ps.setInt(17, 10);
            ps.setInt(18, (-10000 - p.index));
            ps.setNString(19, "[]");
            ps.setNString(20, "[]");
            ps.setNString(21, "[]");
            ps.setNString(22, "[]");
            ps.setLong(23, 5000000L); // vang_
            ps.setInt(24, 100000);   // kimcuong_
            jsar.clear();
            if (!ps.execute()) {
                connnect.commit();
            }
            p.flush();
        } catch (SQLException e) {
            e.printStackTrace();
            Service.send_notice_box(p.conn, "Có lỗi xảy ra");
        }
    }

    public static byte[] randomBody(byte clazz) {
        byte[] bytes = new byte[3];
        switch (clazz) {
            case 0, 1: { // cb st
                bytes[0] = (byte) Util.random(0, 2);
                bytes[1] = (byte) Util.random(8, 10);
                bytes[2] = clazz;
            }
            case 2, 3: { // ps xt
                bytes[0] = (byte) Util.random(0, 2);
                bytes[1] = (byte) Util.random(10, 12);
                bytes[2] = clazz;
            }
        }
        return bytes;
    }

    /*public static void callSquire(Session conn) {
        conn.p.isLiveSquire = true;
        Map map = conn.p.map;
        conn.p.squire.x = conn.p.x;
        conn.p.squire.y = conn.p.y;
        conn.p.squire.map = map;
        conn.p.squire.isSquire = true;       
        Squire.squireEnterMap(conn.p);
    }*/
    public static void callSquire(Session conn) {

        // Kích hoạt trạng thái follow cho cả người chơi và Squire
        conn.p.isLiveSquire = true;
        conn.p.squire.isLiveSquire = true;
        // Đảm bảo Squire không được coi là chủ nhân để flushSquire() cập nhật dữ liệu
        conn.p.squire.isOwner = false;

        Map map = conn.p.map;
        // Đồng bộ vị trí giữa người chơi và Squire
        conn.p.squire.x = conn.p.x;
        conn.p.squire.y = conn.p.y;
        conn.p.squire.map = map;
        conn.p.squire.isSquire = true;

        // Thêm Squire vào bản đồ
        Squire.squireEnterMap(conn.p);
    }

    public void autoAttack() {
        try {
            // Kiểm tra thời gian hồi chiêu trước khi tấn công
            if (System.currentTimeMillis() < delay_attack) {
                return; // Nếu chưa hết thời gian hồi chiêu, không tấn công
            }

            // Kiểm tra xem có mục tiêu hiện tại hay không
            if (targetIndex != -1) {
                MainObject target = this.map.GetObj(targetIndex);
                if (target != null && target.hp > 0) {
                    // Nếu mục tiêu còn sống, tiếp tục tấn công mục tiêu
                    attackTarget(target);
                    return;
                } else {
                    targetIndex = -1;
                }
            }

            if (this.hp <= 0) {
                return;
            }

            MainObject newTarget = findClosestTarget(this.map, this.x, this.y, 250);
            if (newTarget != null) {
                targetIndex = newTarget.index;
                attackTarget(newTarget);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Byte> getUsableSkills() {
        ArrayList<Byte> usableSkills = new ArrayList<>();
        byte[] id_skill = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 19, 20}; // Danh sách các ID chiêu thức

        long currentTime = System.currentTimeMillis(); // Lấy thời gian hiện tại

        for (byte skillId : id_skill) {
            this.skill_point[0] = 1;
            if (this.skill_point[skillId] > 0) { // Kiểm tra skill_point
                LvSkill skill = this.skills[skillId].mLvSkill[this.skill_point[skillId] - 1];
                if (skill.range_lan > 0 && currentTime >= this.time_delay_skill[skillId]) { // Kiểm tra range_lan và thời gian hồi chiêu
                    usableSkills.add(skillId);
                }
            }
        }
        return usableSkills;
    }

    private void attackTarget(MainObject target) {
        try {
            if (target != null && !target.isdie) {
                // Lấy danh sách các chiêu thức có thể sử dụng
                ArrayList<Byte> skills = getUsableSkills();
                byte skillIndex;

                if (!skills.isEmpty()) {
                    // Chọn ngẫu nhiên một chiêu thức từ danh sách
                    skillIndex = skills.get(Util.random(0, skills.size())); // Sử dụng 0 và skills.size() làm tham số
                } else {
                    // Nếu không có chiêu thức nào khả dụng, kiểm tra chiêu thức ID 0
                    if (System.currentTimeMillis() >= this.time_delay_skill[0]) { // Kiểm tra thời gian hồi chiêu cho chiêu thức ID 0
                        skillIndex = 0; // Sử dụng chiêu thức ID 0
                    } else {
                        return; // Nếu chiêu thức ID 0 cũng chưa hồi chiêu, không làm gì cả
                    }
                }

                // Sử dụng kỹ năng đã chọn vào mục tiêu
                if (target.isMob()) {
                    this.use_skill(this.map, this.conn, 1, target.index, (short) target.index, 0);
                    long dame = calculateDame(this, target, skillIndex);

                    //conn.p.owner.update_Exp((int) dame, true);
                    //update_Exp((int) dame, true);
                } else if (target.isPlayer()) {
                    this.use_skill(this.map, this.conn, 1, target.index, (short) target.index, 1);
                }

                // Đặt thời gian hồi chiêu cho đòn tấn công tiếp theo
                LvSkill skill = this.skills[skillIndex].mLvSkill[this.skill_point[skillIndex] - 1];
                this.time_delay_skill[skillIndex] = System.currentTimeMillis() + skill.delay; // Cập nhật thời gian hồi chiêu

                // Nếu sử dụng chiêu thức ID 0, đặt thời gian hồi chiêu là 1,5 giây
                if (skillIndex == 0) {
                    this.time_delay_skill[0] = System.currentTimeMillis() + 500; // 1,5 giây
                }

                delay_attack = System.currentTimeMillis() + Util.ngaunhien(500, 2500); // Thời gian hồi chiêu 350ms đến 1000ms
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// Hàm trợ giúp để tìm mục tiêu gần nhất (cả boss và mob)
    private MainObject findClosestTarget(Map map, int x, int y, int radius) {
        MainObject closestTarget = null;
        int closestDistance = Integer.MAX_VALUE;

        // Tìm mob gần nhất
        for (Mob_in_map mob : map.mobs) {
            if (!mob.isdie) {
                int distance = (int) Point.Distance(x, y, mob.x, mob.y);
                if (distance < radius && distance < closestDistance) {
                    closestTarget = mob;
                    closestDistance = distance;
                }
            }
        }

        // Tìm boss gần nhất
        for (Mob_in_map mob : map.Boss_entrys) {
            if (!mob.isdie && mob.isBoss()) {
                int distance = (int) Point.Distance(x, y, mob.x, mob.y);
                if (distance < radius && distance < closestDistance) {
                    closestTarget = mob;
                    closestDistance = distance;
                }
            }
        }

        return closestTarget;
    }

    public void resetTarget() {
        targetIndex = -1;
    }

    private long calculateDame(Squire attacker, MainObject target, int skillIndex) {
        // Lấy dame cơ bản của Squire
        long dame = attacker.get_DameBase();

        // Lấy kỹ năng hiện tại dựa trên skillIndex
        LvSkill skill = attacker.skills[skillIndex].mLvSkill[attacker.skill_point[skillIndex] - 1];

        // Thêm dame từ kỹ năng
        dame += skill.range_lan;

        // Tính toán bạo kích
        boolean isCriticalHit = attacker.get_Crit() > Util.random(10_000);
        if (isCriticalHit) {
            dame *= 2; // Nhân đôi sát thương nếu bạo kích
        }

        // Tính toán xuyên giáp (pierce)
        boolean isPierce = attacker.get_Pierce() > Util.random(10_000);
        if (isPierce) {

        } else {
            // Nếu không xuyên giáp, trừ giáp của mục tiêu
            dame -= target.get_DefBase();
        }

        // Đảm bảo dame không âm
        if (dame < 0) {
            dame = 1;
        }
        return dame;
    }

    @Override
    public void update_Exp(long expup, boolean expmulti) throws IOException {
        long dame_exp = expup;

        if (expmulti && this.getlevelpercent() >= 0) {
            dame_exp *= Manager.gI().exp;
        }

        if (type_use_mount == 4) {
            dame_exp += ((dame_exp * 5) / 100);
        }

        if ((type_exp == 0 && this.typepk != 0) || this.getlevelpercent() < (-500)) {
            return;
        }

        // if (!isOwner && owner.level <= level) {
        // level = owner.level;
        // return;
        // }
        if (level >= Manager.gI().lvmax || type_exp == 0) {
            return;
        }

        if (this.getlevelpercent() < 0) {
            if (dame_exp > 0) {
                dame_exp /= 5;
            } else {
                dame_exp *= 2;
            }
        }

        exp += dame_exp;

        if (this.getlevelpercent() < (-500)) {
            exp = -(Level.entrys.get(level - 1).exp * 15) / 10;
        }

        int exp_as_int = 0;

        if (dame_exp > 2_000_000_000L) {
            exp_as_int = 1_999_999_999;
        } else {
            exp_as_int = (int) dame_exp;
        }

        if (exp >= Level.entrys.get(level - 1).exp) {
            while (exp >= Level.entrys.get(level - 1).exp && level < Manager.gI().lvmax) {
                exp -= Level.entrys.get(level - 1).exp;
                level++;

                if ((tiemnang + point1 + point2 + point3 + point4) < 2_000_000_000) {
                    point1++;
                    point2++;
                    point3++;
                    point4++;

                    if (kynang < 10000) {
                        kynang += Level.entrys.get(level - 1).kynang;
                    }

                    tiemnang += Level.entrys.get(level - 1).tiemnang;
                }
            }

            if (level == Manager.gI().lvmax) {
                if (!Manager.gI().rankedPlayers.contains(this.name)) { //
                    Manager.gI().rankedPlayers.add(this.name); //

                    int rankIndex = Manager.gI().rankedPlayers.indexOf(this.name); //
                    float reductionFactor = 0.010f - rankIndex * 0.001f;
                    reductionFactor = Math.max(reductionFactor, 0.001f);
                    exp = (long) (Level.entrys.get(level - 1).exp * reductionFactor);
                }
            }

            hp = body.get_HpMax();
            mp = body.get_MpMax();

            Message m = new Message(33);
            m.writer().writeShort(index);
            m.writer().writeByte(level);
            MapService.send_msg_player_inside(map, this, m, true);
            m.cleanup();
            //Service.send_char_main_in4(this);
            // MapService.update_in4_2_other_inside(map, this);

            if (party != null) {
                party.sendin4();
            }
        } else if (level == Manager.gI().lvmax) {
            exp = Math.min(exp, Level.entrys.get(level - 1).exp);
        }

        Message m = new Message(30);
        m.writer().writeShort(index);
        m.writer().writeShort(getlevelpercent());
        m.writer().writeInt(exp_as_int);
        conn.addmsg(m);
        m.cleanup();
    }

}
