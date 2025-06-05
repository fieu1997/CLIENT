package client;

import ai.Nbtd;
import ai.Nbxx;
import ai.ThachDau;
import ai.khu2;
import ai.NhanBan;
import ai.ThachDau_Nb;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import core.Log;
import core.Manager;
import core.MenuController;
import core.SQL;
import core.Service;
import core.Util;
import event_daily.ArenaTemplate;
import event_daily.ChienTruong;
import event_daily.Wedding;
import io.Message;
import io.Session;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import map.Dungeon;
import map.Map;
import map.MapService;
import map.Vgo;
import org.json.simple.parser.JSONParser;
import java.util.Iterator;
import template.*;
import map.*;
import java.util.*;

public class Player extends Body2 {

    public List<EffTemplate> list_eff = new ArrayList<>();
    ;
    public boolean is_nhanban;
    public final Session conn;
//    public final int index;
    public boolean already_setup;
    //   public String name;
    public Map map;
    public boolean is_changemap;
    public long timeCantChangeMap;

//    public short x;
//    public short y;
//    public short x_old;
//    public short y_old;
    public byte head;
    public byte eye;
    public byte hair;
//    public List<EffTemplate> list_eff;
    public Date date;
    public byte diemdanh;
    public byte chucphuc;
    //public int hieuchien;
    //public int chuyensinh;
    private int exptt;
    public int mm_cs;
    public int luyenthe;
    public int kinhmach;
    public int tutien;
    public byte type_exp;
    public Item3 it_change_op;

    public byte it_change_op_index = -1;

//    public byte clazz;
    //public short level;
//    public long exp;
    public long vang;
    public int kimcuong;
    private int exp_tutien;
    public int chuyensinh;
    public int time_khu2;
    private int tongnap;
    private int tiennap;
    private int point_nap;
    public int task_point;

//    public boolean isdie;
    public long tiemnang;
    public int kynang;
    public long point1;
    public long point2;
    public long point3;
    public long point4;
    public int suckhoe;
    public int pointarena;
//    public byte typepk;
    public int pointpk;
    public byte[] skill_point;
    public long[] time_delay_skill;
    public Body2 body;
    public int maxbag;
    public byte maxbox;
    public Item item;
    public List<String> giftcode;
    public byte[][] rms_save;
    public List<Pet> mypet;
    public short pet_follow = -1;
    public List<Friend> list_friend;
    public List<String> list_enemies;
//    public int hp;
//    public int mp;

    public byte[] fashion;
    public Skill[] skills;
    public byte item_color_can_pick;
    public byte hp_mp_can_pick;
    public HashMap<Integer, Boolean> other_player_inside;
    public HashMap<Integer, Boolean> other_mob_inside;
    public HashMap<Integer, Boolean> other_mob_inside_update;
    public byte type_use_mount;
    public short id_item_rebuild;
    public boolean is_use_mayman;
    public short id_use_mayman;
    public short item_replace;
    public short item_replace2;
    public short id_buffer_126;
    public byte id_index_126;
    public Party party;
    public long time_use_poition_hp;
    public long time_use_poition_mp;
    public byte enough_time_disconnect;
    public int dame_affect_special_sk;

    public Squire squire;
    public Player owner;
    public boolean isOwner = true;
    public boolean isSquire;
    public boolean isLiveSquire;
    
    public int hp_restore;

    public long time_buff_hp;
    public long time_buff_mp;
    public long time_affect_special_sk;
    public long time_speed_rebuild;
    public String name_trade;

    public String name_td; // thách đấu
    public int vang_td;
    public long startTime;
    public int td_nbtd;

    public short[] list_item_trade;
    public boolean lock_trade;
    public boolean accept_trade;
    public int money_trade;
//    public Dungeon dungeon;
    public Clan myclan;
    public byte id_medal_is_created;
    public short[] medal_create_material;
    public short fusion_material_medal_id;
    public long pet_atk_speed;
    public long time_eff_medal;

    public long time_eff_wear;
    public long time_eff_21;
    public long time_eff_22;
    public long time_eff_vip;
    public long time_eff_fusion;
    public int[] point_active;
    public short id_horse;
    public boolean is_create_wing;
    public short id_remove_time_use;
    public byte id_wing_split;
    public byte[] in4_auto;
    public List<Player_store> my_store;
    public String my_store_name;
    public String Store_Sell_ToPL = "";
    public Pet_di_buon pet_di_buon;
    public Pet_mi_nuong pet_mi_nuong;
    public short id_name;
    public String name_mem_clan_to_appoint = "";
    public byte id_select_mo_ly;
    public short id_hop_ngoc;
    public List<Item3> list_thao_kham_ngoc;
    public int time_atk_ngoc_hon_nguyen = 0;
    public short id_ngoc_tinh_luyen = -1;
    public long timeBlockCTG;
    public Wedding it_wedding;
    public String[] in4_wedding;
    public int[] quest_daily;
    public int chuyencan;
    public int jointx;
    public boolean tai;
    public boolean xiu;
    public String taixiu = "Bạn chưa đặt cược.";
    public int status;
    public int levellt;
    public int typelt;
    public int point_lt;
    public int id_index_temp;
    public int[] skill_110;
    public int[] skill_new;
    public int[] diem_danh;// điểm danh = 0, like = 1, dd Vip = 2, dd Ngày=3, gh x4 = 4
    public int[] tu_tien;// 0 Lt, 1 Km, 2 tt, 3 exp
    public int[] nv_tinh_tu;
    public long time_k2;
    public List<Part_player> part_p;
    public boolean isDead;
    public boolean isAlive;

    public List<TaskTemplate> taskNext = new ArrayList<>();
    public List<TaskTemplate> taskFinish = new ArrayList<>();
    public List<TaskTemplate> taskDoing = new ArrayList<>();
    public int chon_mob;
    public float point_lden;
    public boolean type_process_chest = false;
    public byte maxtui;
    
    public void datatx() {
        if (this.tai == true) {
            this.taixiu = "Tài";
        }
        if (this.xiu == true) {
            this.taixiu = "Xỉu";
        }
        if (!this.tai && !this.xiu) {
            this.taixiu = "Bạn chưa đặt cược.";
        }
    }

    // kĩ năng mề
    public boolean isTangHinh;
    public long time_move;

    public boolean isDropMaterialMedal = true;
    public boolean iseffMedal = true;
    public boolean isShowMobEvents = true;
    public ArenaTemplate PointArena;

    //kĩ năng khảm
    public Kham_template kham;
    //create item star
    public boolean isCreateItemStar = false;
    public boolean isSieuThan = false;
    public boolean isSieuCap = false;
    public boolean hopdo = false;
    // siêu nhân
    public boolean isSieuNhan = false;
    public byte type_sieunhan_create = -1;
    public byte id_sieunhan_create = -1;
    
    public boolean shopthuong = false;
    public boolean shopcoin = false;
    public boolean shopvang = false;
    public boolean shoptinhtu = false;
    public boolean shopitem7 = false;
    public boolean isCheckHopThe = false;
    public boolean isCheckcase = false;
    public boolean ismap124 = false;
    public byte ClazzItemStar = -1;
    public byte TypeItemStarCreate = -1;
    public short[] MaterialItemStar;
    public short[] NLsieuthan;
    public short[] NLsieucap;
    public int id_Upgrade_Medal_Star = -1;

    //biến heo chiến trường
    public long timeBienHeo;
    public long time_use_item_arena;
    public long time_henshin;
    public int id_henshin;

    /* public Player(int maxHp) {
        this.hp_max = maxHp;
        this.hp = maxHp;
        this.isDead = false;
    }*/
    // clan
    public int selectedClanIndex = -1;
    public Clan selectedClan = null;

    // đổi chỉ số
    public Item3 chon_item3; // Item đã chọn
    public int chon_option = -1; // option đã chọn
    public int chon_item3_index = -1;

    public int chon_odat = -1;
    public int chon_cay = -1;
    public String loaitiencay;
    public int chon_cam = -1;
    // time gọi boss cá nhân
    public long lastCallTime;

    public boolean an_wear = false; //

    public void addReward(int reward) throws IOException {
        // Giả sử player có thuộc tính "points" hoặc "gold"
        this.kimcuong += reward;
        Service.send_char_main_in4(conn.p);
        item.char_inventory(5);

    }

    public Player(Session conn, int id) {
        this.conn = conn;
        this.index = id;
        this.hp_max = hp_max;
        this.hp = hp_max;
        this.isDead = false;
        this.isAlive = true;
        this.body = this;
        SetPlayer(this);
        this.point_active = new int[2];
        this.quest_daily = new int[5];
        this.nv_tinh_tu = new int[4];
        this.skill_new = new int[2];
        this.diem_danh = new int[5];
        this.tu_tien = new int[4];

    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void takeDamage(int damage) {
        if (isAlive()) {
            hp -= damage;
            if (hp <= 0) {
                hp = 0;
                isDead = true;
            }
        } else {

            isDead = true;
        }
    }

    public void ResetShop() {
        shopthuong = false;
        shopcoin = false;
        shopvang = false;
        shoptinhtu = false;
        shopitem7 = false;
        ResetCreateItemStar();
    }

    public void ResetCreateItemStar() {
        isCreateItemStar = false;
        isSieuThan = false;
        isSieuCap = false;
        
        isSieuNhan = false;
       
        
        hopdo = false;
        ClazzItemStar = -1;
        TypeItemStarCreate = -1;
    }

    public EffTemplate get_eff(int id) {
        for (int i = 0; i < list_eff.size(); i++) {
            EffTemplate temp = list_eff.get(i);
            if (temp.id == id) {
                return temp;
            }
        }
        return null;
    }

    public void update_point_arena(int i) throws IOException {
        Member_ChienTruong temp = ChienTruong.gI().get_infor_register(this.name);
        if (temp != null) {
            temp.point += i;
            this.pointarena += i;
            Service.send_health(this);
            Message m = new Message(-95);
            m.writer().writeByte(0);
            m.writer().writeShort(this.index);
            m.writer().writeShort(this.pointarena);
            this.conn.addmsg(m);
            m.cleanup();
        }
    }

    public void SetMaterialItemStar() {
        MaterialItemStar = new short[]{
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),
            (short) Util.random(417, 437), (short) Util.random(437, 457), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464),};
    }

    public void SetNLsieuthan() {
        short[] baseValues = new short[]{(short) Util.random(496, 501), (short) Util.random(316, 326), (short) Util.random(326, 336), (short) Util.random(336, 346), (short) Util.random(457, 464)};
        NLsieuthan = new short[baseValues.length * 8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(baseValues, 0, NLsieuthan, i * baseValues.length, baseValues.length);
        }
    }

    public void SetNLsieucap() {
        short[] baseValues = {
            (short) Util.random(464, 471),
            (short) Util.random(316, 326),
            (short) Util.random(326, 336),
            (short) Util.random(336, 346),
            (short) Util.random(457, 464)
        };
        NLsieucap = new short[baseValues.length * 8];
        for (int i = 0; i < NLsieucap.length; i++) {
            NLsieucap[i] = baseValues[i % baseValues.length];
        }
    }

    public void ChangeMaterialItemStar(byte type) {
        if (type >= 8) {
            return;
        }
        MaterialItemStar[type * 5] = (short) Util.random(417, 437);
        MaterialItemStar[type * 5 + 1] = (short) Util.random(437, 457);

        MaterialItemStar[type * 5 + 2] = (short) Util.random(326, 336);
        MaterialItemStar[type * 5 + 3] = (short) Util.random(336, 346);

        MaterialItemStar[type * 5 + 4] = (short) Util.random(457, 464);
    }

    public void CheckSkillPoint() {
        for (int i = 0; i < skill_point.length; i++) {
            if (skill_point[i] <= 0) {
                continue;
            }
            LvSkill temp = skills[i].mLvSkill[skill_point[i] - 1];
            // Chỉ giảm điểm kỹ năng nếu cấp độ của người chơi đủ cao
            if (skill_point[i] > 0 && temp.LvRe <= level) {
                while (skill_point[i] > 0 && temp.LvRe > level) {
                    temp = skills[i].mLvSkill[(--skill_point[i]) - 1];
                    kynang++;
                }
            }
        }
    }

    public boolean setup() throws IOException {
        try {
            long _time = System.currentTimeMillis();
            String query = "SELECT * FROM `player` WHERE `id` = '" + this.index + "' LIMIT 1;";
            try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
                if (!rs.next()) {
                    return false;
                }
                //
                this.kham = new Kham_template();
                this.name = rs.getString("name");
                this.timeBlockCTG = rs.getLong("time_block_ctg");
                JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("body"));
                if (jsar == null) {
                    return false;
                }
                head = Byte.parseByte(jsar.get(0).toString());
                eye = Byte.parseByte(jsar.get(1).toString());
                hair = Byte.parseByte(jsar.get(2).toString());
                jsar.clear();

                jsar = (JSONArray) JSONValue.parse(rs.getString("dquest"));
                quest_daily = new int[5];
                for (int i = 0; i < quest_daily.length; i++) {
                    quest_daily[i] = Integer.parseInt(jsar.get(i).toString());
                }
                jsar.clear();

                jsar = (JSONArray) JSONValue.parse(rs.getString("site"));
                if (jsar == null) {
                    return false;
                }
                Map[] map_enter = Map.get_map_by_id(Byte.parseByte(jsar.get(0).toString()));
                if (map_enter != null) {
                    x = Short.parseShort(jsar.get(1).toString());
                    y = Short.parseShort(jsar.get(2).toString());
                } else {
                    map_enter = Map.entrys.get(1);
                    x = 432;
                    y = 354;
                }
                map = map_enter[0];
                other_player_inside = new HashMap<>();
                other_mob_inside = new HashMap<>();
                other_mob_inside_update = new HashMap<>();
                jsar.clear();
                //nv tinh tú
                jsar = (JSONArray) JSONValue.parse(rs.getString("nvtt"));
                if (jsar == null) {
                    return false;
                }
                nv_tinh_tu = new int[]{-1, 0, 0, 0};
                for (int i = 0; i < nv_tinh_tu.length; i++) {
                    nv_tinh_tu[i] = Integer.parseInt(jsar.get(i).toString());
                }
                jsar.clear();

                jsar = (JSONArray) JSONValue.parse(rs.getString("eff"));
                if (jsar == null) {
                    return false;
                }
//            list_eff = new ArrayList<>();
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    if (jsar2 == null) {
                        return false;
                    }
                    this.body.add_EffDefault(Integer.parseInt(jsar2.get(0).toString()), Integer.parseInt(jsar2.get(1).toString()),
                            (System.currentTimeMillis() + Long.parseLong(jsar2.get(2).toString())));
//                list_eff.add(
//                        new EffTemplate(Integer.parseInt(jsar2.get(0).toString()), Integer.parseInt(jsar2.get(1).toString()),
//                                (System.currentTimeMillis() + Long.parseLong(jsar2.get(2).toString()))));
                }
                jsar.clear();
                date = Util.getDate(rs.getString("date"));
                diemdanh = rs.getByte("diemdanh");
                chucphuc = rs.getByte("chucphuc");
                hieuchien = rs.getInt("hieuchien");
                chuyencan = rs.getInt("chuyencan");
                type_exp = rs.getByte("typeexp");
                clazz = rs.getByte("clazz");
                level = rs.getShort("level");
                levellt = rs.getInt("levellt");
                typelt = rs.getInt("typelt");
                point_lt = rs.getInt("point_lt");
                chuyensinh = rs.getInt("chuyensinh");
                task_point = rs.getInt("task_point");
                time_khu2 = rs.getInt("time_khu2");
                mm_cs = rs.getInt("mm_cs");
                luyenthe = rs.getInt("luyenthe");
                kinhmach = rs.getInt("kinhmach");
                tutien = rs.getInt("tutien");
                exp = rs.getLong("exp");
                td_nbtd = rs.getInt("td_nbtd");
                //
                if (level > Manager.gI().lvmax) {
                    level = (short) Manager.gI().lvmax;
                    if (exp >= Level.entrys.get(level - 1).exp) {
                        exp = Level.entrys.get(level - 1).exp - 1;
                    }
                }
                //
                vang = rs.getLong("vang");
                kimcuong = rs.getInt("kimcuong");
                exp_tutien = rs.getInt("exptt");

                isdie = false;
                tiemnang = rs.getLong("tiemnang");
                kynang = rs.getInt("kynang");
                point1 = rs.getLong("point1");
                point2 = rs.getLong("point2");
                point3 = rs.getLong("point3");
                point4 = rs.getLong("point4");
                pointarena = rs.getInt("point_arena");
                short it_name_ = rs.getShort("id_name");
                if (it_name_ != -1) {
                    id_name = (short) (ItemTemplate3.item.get(it_name_).getPart() + 41);
                    id_name
                            = (short) (((it_name_ >= 4720 && it_name_ <= 4727) || (it_name_ >= 4765 && it_name_ <= 4767)) ? id_name
                                    : 78);
                } else {
                    id_name = -1;
                }
                skill_point = new byte[21];
                time_delay_skill = new long[21];
                jsar = (JSONArray) JSONValue.parse(rs.getString("skill"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < 21; i++) {
                    skill_point[i] = Byte.parseByte(jsar.get(i).toString());
                    time_delay_skill[i] = 0;
                }
                jsar.clear();
                // load item

                maxbag = rs.getInt("maxbag");
                maxbox = 126;
                maxtui = 126;
                item = new Item(this);
                item.bag3 = new Item3[maxbag];
                item.box3 = new Item3[maxbox];
                item.tui3 = new Item3[maxtui];
                item.wear = new Item3[24];
                skill_110 = new int[2];
                item.bag47 = new ArrayList<>();
                item.box47 = new ArrayList<>();
                item.tui47 = new ArrayList<>();
                item.bag5 = new ArrayList<>();
                item.box5 = new ArrayList<>();
                for (int i = 0; i < 24; i++) {
                    item.wear[i] = null;
                }
                for (int i = 0; i < maxbag; i++) {
                    item.bag3[i] = null;
                    item.box3[i] = null;
                }
                jsar = (JSONArray) JSONValue.parse(rs.getString("item4"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    if (temp.id > ItemTemplate4.item.size()) {
                        continue;
                    }
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 4;
                    if (temp.quantity > 0) {
                        item.bag47.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                jsar = (JSONArray) JSONValue.parse(rs.getString("item7"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 7;
                    if (temp.quantity > 0) {
                        item.bag47.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                jsar = (JSONArray) JSONValue.parse(rs.getString("item5"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    int ID = Short.parseShort(jsar2.get(0).toString());
                    int quantity = Short.parseShort(jsar2.get(1).toString());
                    if (ID >= ItemTemplate5.items.size()) {
                        continue;
                    }
                    Item5 temp = new Item5(ID, quantity);
                    if (temp.quantity > 0) {
                        item.bag5.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                //
                jsar = (JSONArray) JSONValue.parse(rs.getString("item3"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {

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
                    if (!jsar2.get(8).toString().matches("\\d+")) {
                        jsar2.add(8, "0");
                    }
                    temp.tier = Byte.parseByte(jsar2.get(8).toString());

                    JSONArray jsar3 = (JSONArray) JSONValue.parse(jsar2.get(9).toString());
                    temp.op = new ArrayList<>();
                    for (int j = 0; j < jsar3.size(); j++) {
                        JSONArray jsar4 = (JSONArray) JSONValue.parse(jsar3.get(j).toString());
                        temp.op.add(
                                new Option(Byte.parseByte(jsar4.get(0).toString()), Integer.parseInt(jsar4.get(1).toString()), temp.id));
                    }
                    temp.time_use = 0;
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
                jsar = (JSONArray) JSONValue.parse(rs.getString("itemwear"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    try {
                        JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                        if (jsar2 == null) {
                            return false;
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
                                return false;
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
                    } catch (Exception eee) {
                        eee.printStackTrace();
                    }
                }
                jsar.clear();

                jsar = (JSONArray) JSONValue.parse(rs.getString("giftcode"));
                if (jsar == null) {
                    return false;
                }
                giftcode = new ArrayList<>();
                for (int i = 0; i < jsar.size(); i++) {
                    giftcode.add(jsar.get(i).toString());
                }
                jsar.clear();

                jsar = (JSONArray) JSONValue.parse(rs.getString("skill_110"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < 2; i++) {
                    skill_110[i] = Byte.parseByte(jsar.get(i).toString());
                }
                jsar.clear();

                // box
                jsar = (JSONArray) JSONValue.parse(rs.getString("itembox4"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    if (jsar2 == null) {
                        return false;
                    }
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 4;
                    if (temp.quantity > 0) {
                        item.box47.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                jsar = (JSONArray) JSONValue.parse(rs.getString("itembox7"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    if (jsar2 == null) {
                        return false;
                    }
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 7;
                    if (temp.quantity > 0) {
                        item.box47.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                jsar = (JSONArray) JSONValue.parse(rs.getString("itembox5"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    int ID = Short.parseShort(jsar2.get(0).toString());
                    int quantity = Short.parseShort(jsar2.get(1).toString());
                    if (ID >= ItemTemplate5.items.size()) {
                        continue;
                    }
                    Item5 temp = new Item5(ID, quantity);
                    if (temp.quantity > 0) {
                        item.box5.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                //
                jsar = (JSONArray) JSONValue.parse(rs.getString("itembox3"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {

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
                    if (jsar2.get(8).toString().length() >= 3) {
                        jsar2.add(8, "0");
                    }
                    temp.tier = Byte.parseByte(jsar2.get(8).toString());

                    JSONArray jsar3 = (JSONArray) JSONValue.parse(jsar2.get(9).toString());
                    temp.op = new ArrayList<>();
                    for (int j = 0; j < jsar3.size(); j++) {
                        JSONArray jsar4 = (JSONArray) JSONValue.parse(jsar3.get(j).toString());
                        temp.op.add(
                                new Option(Byte.parseByte(jsar4.get(0).toString()), Integer.parseInt(jsar4.get(1).toString()), temp.id));
                    }
                    temp.time_use = 0;
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
                //item tui3
                 jsar = (JSONArray) JSONValue.parse(rs.getString("itemtui3"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {

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
                    if (jsar2.get(8).toString().length() >= 3) {
                        jsar2.add(8, "0");
                    }
                    temp.tier = Byte.parseByte(jsar2.get(8).toString());

                    JSONArray jsar3 = (JSONArray) JSONValue.parse(jsar2.get(9).toString());
                    temp.op = new ArrayList<>();
                    for (int j = 0; j < jsar3.size(); j++) {
                        JSONArray jsar4 = (JSONArray) JSONValue.parse(jsar3.get(j).toString());
                        temp.op.add(
                                new Option(Byte.parseByte(jsar4.get(0).toString()), Integer.parseInt(jsar4.get(1).toString()), temp.id));
                    }
                    temp.time_use = 0;
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
                
                //
                
                // box
                jsar = (JSONArray) JSONValue.parse(rs.getString("itemtui4"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    if (jsar2 == null) {
                        return false;
                    }
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 4;
                    if (temp.quantity > 0) {
                        item.tui47.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                jsar = (JSONArray) JSONValue.parse(rs.getString("itemtui7"));
                if (jsar == null) {
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    if (jsar2 == null) {
                        return false;
                    }
                    Item47 temp = new Item47();
                    temp.id = Short.parseShort(jsar2.get(0).toString());
                    temp.quantity = Short.parseShort(jsar2.get(1).toString());
                    temp.category = 7;
                    if (temp.quantity > 0) {
                        item.tui47.add(temp);
                    }
                    jsar2.clear();
                }
                jsar.clear();
                
                //
                jsar = (JSONArray) JSONValue.parse(rs.getString("rms_save"));
                if (jsar == null) {
                    return false;
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
                    return false;
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
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    JSONArray js12 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                    Friend temp = new Friend();
                    temp.name = js12.get(0).toString();
                    temp.level = Short.parseShort(js12.get(1).toString());
                    temp.head = Byte.parseByte(js12.get(2).toString());
                    temp.hair = Byte.parseByte(js12.get(3).toString());
                    temp.eye = Byte.parseByte(js12.get(4).toString());
                    temp.itemwear = new ArrayList<>();
                    JSONArray js2 = (JSONArray) JSONValue.parse(js12.get(5).toString());
                    for (int j = 0; j < js2.size(); j++) {
                        JSONArray js3 = (JSONArray) JSONValue.parse(js2.get(j).toString());
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
                    return false;
                }
                for (int i = 0; i < jsar.size(); i++) {
                    String n = jsar.get(i).toString();
                    if (!list_enemies.contains(n)) {
                        list_enemies.add(n);
                    }
                }
                jsar.clear();
                jsar = (JSONArray) JSONValue.parse(rs.getString("medal_create_material"));
                if (jsar == null) {
                    return false;
                }
                medal_create_material = new short[jsar.size()];
                for (int i = 0; i < jsar.size(); i++) {
                    medal_create_material[i] = Short.parseShort(jsar.get(i).toString());
                }
                jsar.clear();

                jsar = (JSONArray) JSONValue.parse(rs.getString("item_star_material"));
                if (jsar == null) {
                    return false;
                }
                MaterialItemStar = new short[jsar.size()];
                for (int i = 0; i < jsar.size(); i++) {
                    MaterialItemStar[i] = Short.parseShort(jsar.get(i).toString());
                }
                if (MaterialItemStar == null || MaterialItemStar.length < 40) {
                    SetMaterialItemStar();
                }
                jsar.clear();
                //sieuthan
                jsar = (JSONArray) JSONValue.parse(rs.getString("item_star_sieuthan"));
                if (jsar == null) {
                    return false;
                }
                NLsieuthan = new short[jsar.size()];
                for (int i = 0; i < jsar.size(); i++) {
                    NLsieuthan[i] = Short.parseShort(jsar.get(i).toString());
                }
                if (NLsieuthan == null || NLsieuthan.length < 40) {
                    SetNLsieuthan();
                }
                jsar.clear();

                //sieucap
                jsar = (JSONArray) JSONValue.parse(rs.getString("item_star_sieucap"));
                if (jsar == null) {
                    return false;
                }
                NLsieucap = new short[jsar.size()];
                for (int i = 0; i < jsar.size(); i++) {
                    NLsieucap[i] = Short.parseShort(jsar.get(i).toString());
                }
                if (NLsieuthan == null || NLsieucap.length < 40) {
                    SetNLsieucap();
                }
                jsar.clear();

                jsar = (JSONArray) JSONValue.parse(rs.getString("point_active"));
                if (jsar == null) {
                    return false;
                }
                point_active = new int[jsar.size()];
                for (int i = 0; i < jsar.size(); i++) {
                    point_active[i] = Integer.parseInt(jsar.get(i).toString());
                }
                jsar.clear();
                //Skill mới
                jsar = (JSONArray) JSONValue.parse(rs.getString("skill_new"));
                if (jsar == null) {
                    return false;
                }
                skill_new = new int[]{0, 0};
                // skill_new = new int[jsar.size()];
                for (int i = 0; i < jsar.size(); i++) {
                    skill_new[i] = Integer.parseInt(jsar.get(i).toString());
                }
                jsar.clear();
                // diem danh mới
                jsar = (JSONArray) JSONValue.parse(rs.getString("diem_danh"));
                if (jsar == null) {
                    return false;
                }
                diem_danh = new int[]{0, 0, 0, 0, 0};
                for (int i = 0; i < jsar.size(); i++) {
                    diem_danh[i] = Integer.parseInt(jsar.get(i).toString());
                }
                jsar.clear();
                // tu tien moi
                jsar = (JSONArray) JSONValue.parse(rs.getString("tu_tien"));
                if (jsar == null) {
                    return false;
                }
                tu_tien = new int[]{0, 0, 0, 0};
                for (int i = 0; i < jsar.size(); i++) {
                    tu_tien[i] = Integer.parseInt(jsar.get(i).toString());
                }
                jsar.clear();
                //
                myclan = Clan.get_clan_of_player(this.name);

                String taskNextJson = rs.getString("task_next");
                String taskFinishJson = rs.getString("task_finish");
                String taskDoingJson = rs.getString("task_doing");
                ObjectMapper objectMapper = new ObjectMapper();
                List<TaskTemplate> taskNextList = objectMapper.readValue(taskNextJson,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, TaskTemplate.class));

                List<TaskTemplate> taskFinishList = objectMapper.readValue(taskFinishJson,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, TaskTemplate.class));

                List<TaskTemplate> taskDoingList = objectMapper.readValue(taskDoingJson,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, TaskTemplate.class));
                this.taskNext = taskNextList;
                this.taskFinish = taskFinishList;
                this.taskDoing = taskDoingList;
                //
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            //
            already_setup = true;
            return true;
        } catch (Exception eee) {
            eee.printStackTrace();
        }
        return false;
    }

    public void load_skill() throws IOException {
        ByteArrayInputStream bais = null;
        DataInputStream dis = null;
        try {
            switch (clazz) {
                case 0: { // chien binh
                    bais = new ByteArrayInputStream(Manager.gI().msg_29_chienbinh);

                    break;
                }
                case 1: { // sat thu
                    bais = new ByteArrayInputStream(Manager.gI().msg_29_satthu);
                    break;
                }
                case 2: { // phap su
                    bais = new ByteArrayInputStream(Manager.gI().msg_29_phapsu);
                    break;
                }
                case 3: { // xa thu
                    bais = new ByteArrayInputStream(Manager.gI().msg_29_xathu);
                    break;
                }
            }
            dis = new DataInputStream(bais);
            int size = dis.readByte();
            skills = new Skill[size];
            for (int i = 0; i < size; i++) {
                Skill skill = new Skill();
                skill.id = dis.readByte();
                skill.iconid = dis.readByte();
                skill.name = dis.readUTF();
                if (skill.id == 19 && skill_110[0] >= 1) {
                    skill.name += " [" + skill_110[0] + "]";
                } else if (skill.id == 20 && skill_110[1] >= 1) {
                    skill.name += " [" + skill_110[1] + "]";
                }

                skill.type = dis.readByte();
                skill.range = dis.readShort();
                skill.detail = dis.readUTF();
                skill.typeBuff = dis.readByte();
                skill.subEff = dis.readByte();
                byte b2 = dis.readByte();
                skill.mLvSkill = new LvSkill[(int) b2];
                for (int j = 0; j < (int) b2; j++) {
                    skill.mLvSkill[j] = new LvSkill();
                    skill.mLvSkill[j].mpLost = dis.readShort();
                    skill.mLvSkill[j].LvRe = dis.readShort();
                    skill.mLvSkill[j].delay = dis.readInt();
                    skill.mLvSkill[j].timeBuff = dis.readInt();
                    skill.mLvSkill[j].per_Sub_Eff = dis.readByte();
                    skill.mLvSkill[j].time_Sub_Eff = dis.readShort();
                    skill.mLvSkill[j].plus_Hp = dis.readShort();
                    skill.mLvSkill[j].plus_Mp = dis.readShort();
                    byte b3 = dis.readByte();
                    skill.mLvSkill[j].minfo = new Option[(int) b3];
                    for (int k = 0; k < (int) b3; k++) {
                        skill.mLvSkill[j].minfo[k] = new Option(dis.readUnsignedByte(), dis.readInt(), (short) 0);
                        if (skill.id == 19 && skill_110[0] > 1 && skill.mLvSkill[j].minfo[k].id >= 7 && skill.mLvSkill[j].minfo[k].id <= 11) {
                            skill.mLvSkill[j].minfo[k].param += 800 + skill_110[0] * 300;
                        } else if (skill.id == 20 && skill_110[1] > 1 && skill.mLvSkill[j].minfo[k].id >= 7 && skill.mLvSkill[j].minfo[k].id <= 11) {
                            skill.mLvSkill[j].minfo[k].param += 800 + skill_110[1] * 300;
                        }
                    }
                    skill.mLvSkill[j].nTarget = dis.readByte();
                    skill.mLvSkill[j].range_lan = dis.readShort();
                    // if (skill.id == 18) {
                    // skill.mLvSkill[j].delay = 0;
                    // }
                }
                skill.performDur = dis.readShort();
                skill.typePaint = dis.readByte();
                skills[skill.id] = skill;
                if (skill.id == 18 && p.skill_new[0] >= 1) {
                    skill.iconid = 84;
                    skill.name = "Triệu Hồi Linh";
                    skill.type = 1;
                    skill.range = 140;
                    skill.detail = "Triệu Hồi Linh Thể Trong vòng 15s \n buff tất cả chỉ số lên 10% Áp dụng cho party";
                    skill.typeBuff = 1;
                    skill.subEff = 6;
                    skill.typePaint = 0;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                dis.close();
            }
            if (bais != null) {
                bais.close();
            }
        }
    }
    // public EffTemplate get_EffDefault(int id) {
    // for (int i = 0; i < list_eff.size(); i++) {
    // EffTemplate temp = list_eff.get(i);
    // if (temp.id == id) {
    // return temp;
    // }
    // }
    // return null;
    // }

    public synchronized long get_vang() {
    if (!isOwner) {// phủ định true tức là false nếu nó được gán truê trước đó và ngược lại
        return this.squire.vang_;
        }else{
        return this.vang;
        }
    }

    public synchronized int get_ngoc() {
    if (!isOwner) {
        return this.squire.kimcuong_;
        }else{
        return this.kimcuong;
    }
    }

    public synchronized int get_exptt() {
        return this.exp_tutien;
    }

    public synchronized int get_mm_cs() {
        return this.mm_cs;
    }

    public synchronized int get_chuyensinh() {
        return this.chuyensinh;
    }

    public synchronized int get_luyenthe() {
        return this.luyenthe;
    }

    public synchronized int get_kinhmach() {
        return this.kinhmach;
    }

    public synchronized int get_tutien() {
        return this.tutien;
    }

    public synchronized void update_vang(long i) {
    if (!isOwner) {
        if ((i + this.squire.vang_) > 2__000_000_000_000_000L) {
            this.squire.vang_ = 2__000_000_000_000_000L;
        } else {
            this.squire.vang_ += i;
        }
        }else{
        if ((i + vang) > 2__000_000_000_000_000L) {
            vang = 2__000_000_000_000_000L;
        } else {
            vang += i;
        }
        if (i < 0 && conn.p.nv_tinh_tu[0] == 9 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
            if (i < -30_000) {
                i = -30_000;
            }
            conn.p.nv_tinh_tu[1] -= i;
        }}
        try {
            Message m = new Message(16);
            m.writer().writeByte(0);
            m.writer().writeByte(5);
            m.writer().writeLong(this.get_vang());
            m.writer().writeInt(this.get_ngoc());
            m.writer().writeByte(5);
            m.writer().writeByte(0); // size item quest
            conn.addmsg(m);
            m.cleanup();
        } catch (Exception e) {
        }
    }

    public synchronized void update_ngoc(long i) {
    if (!isOwner) {
        if ((i + this.squire.kimcuong_) > 2_000_000_000L) {
            this.squire.kimcuong_ = 2_000_000_000;
        } else {
            this.squire.kimcuong_ += i;
        }
        }else{
        if ((i + kimcuong) > 2_000_000_000L) {
            kimcuong = 2_000_000_000;
        } else {
            kimcuong += i;
        }
        if (i < 0 && conn.p.nv_tinh_tu[0] == 10 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
            conn.p.nv_tinh_tu[1]++;
        }
       }
        try {
            Message m = new Message(16);
            m.writer().writeByte(0);
            m.writer().writeByte(5);
            m.writer().writeLong(this.get_vang());
            m.writer().writeInt(this.get_ngoc());
            m.writer().writeByte(5);
            m.writer().writeByte(0); // size item quest
            conn.addmsg(m);
            m.cleanup();
        } catch (Exception e) {
        }

    }

    public synchronized void update_exptt(long i) {
        // if ((i + exptt) > 2_000_000_000L) {
        // exptt = 2_000_000_000;
        // } else {
        exp_tutien += i;
        //  }
        try {
            Message m = new Message(16);
            m.writer().writeByte(0);
            m.writer().writeByte(5);
            m.writer().writeLong(this.get_vang());
            m.writer().writeInt(this.get_ngoc());
            m.writer().writeByte(5);
            m.writer().writeByte(0); // size item quest
            conn.addmsg(m);
            m.cleanup();
        } catch (Exception e) {
        }

    }

    public synchronized void update_chuyensinh(long i) {
        // if ((i + chuyensinh) > 2_000_000_000L) {
        // chuyensinh = 2_000_000_000;
        // } else {
        chuyensinh += i;
        //  }
        try {
            Message m = new Message(16);
            m.writer().writeByte(0);
            m.writer().writeByte(5);
            m.writer().writeLong(this.get_vang());
            m.writer().writeInt(this.get_ngoc());
            m.writer().writeByte(5);
            m.writer().writeByte(0); // size item quest
            conn.addmsg(m);
            m.cleanup();
        } catch (Exception e) {
        }

    }

    public synchronized void update_mm_cs(long i) {
        // if ((i + chuyensinh) > 2_000_000_000L) {
        // chuyensinh = 2_000_000_000;
        // } else {
        mm_cs += i;
        //  }
        try {
            Message m = new Message(16);
            m.writer().writeByte(0);
            m.writer().writeByte(5);
            m.writer().writeLong(this.get_vang());
            m.writer().writeInt(this.get_ngoc());
            m.writer().writeByte(5);
            m.writer().writeByte(0); // size item quest
            conn.addmsg(m);
            m.cleanup();
        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    public void flush() {
        try {
            if (!already_setup) {
                return;
            }
            //if (isSquire) {
            //   return;
            //}
            if (this.squire != null && this.isLiveSquire) {
                this.squire.flushSquire();
            }
            try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement()) {
                if (isOwner) {
                    String a = "`level` = " + level;
                    a += ",`exp` = " + exp;
                    JSONArray jsar = new JSONArray();
                    if (isdie || Map.is_map_cant_save_site(map.map_id)) {
                        jsar.add(1);
                        jsar.add(432);
                        jsar.add(354);
                    } else {
                        jsar.add(map.map_id);
                        jsar.add(x);
                        jsar.add(y);
                    }
                    a += ",`site` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    jsar.add(head);
                    jsar.add(eye);
                    jsar.add(hair);
                    a += ",`body` = '" + jsar.toJSONString() + "'";
                    jsar.clear();

                    //nvhn
                    for (int i = 0; i < quest_daily.length; i++) {
                        jsar.add(quest_daily[i]);
                    }
                    a += ",`dquest` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //nv tinh tu
                    for (int i = 0; i < nv_tinh_tu.length; i++) {
                        jsar.add(nv_tinh_tu[i]);
                    }
                    a += ",`nvtt` = '" + jsar.toJSONString() + "'";
                    jsar.clear();

                    for (int i = 0; i < MainEff.size(); i++) {
                        EffTemplate temp = MainEff.get(i);
                        if (temp.id != -126 && temp.id != -125 && temp.id != -127 && temp.id != -128) {
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

                    for (int i = 0; i < 2; i++) {
                        jsar.add(skill_110[i]);
                    }
                    a += ",`skill_110` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    for (Item47 it : item.bag47) {
                        if (it.category == 4) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(it.id);
                            jsar2.add(it.quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`item4` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    for (Item47 it : item.bag47) {
                        if (it.category == 7) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(it.id);
                            jsar2.add(it.quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`item7` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    for (int i = 0; i < item.bag5.size(); i++) {
                        if (item.bag5.get(i) != null) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(item.bag5.get(i).ID);
                            //jsar2.add(item.bag5.get(i).name);
                            jsar2.add(item.bag5.get(i).quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`item5` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    long _time = System.currentTimeMillis();
                    for (int i = 0; i < item.bag3.length; i++) {
                        Item3 temp = item.bag3[i];
                        if (temp != null) {
                            if (temp.expiry_date != 0 && _time > temp.expiry_date) {
                                item.bag3[i] = null;
                                try {
                                    conn.p.item.char_inventory(3);
                                } catch (IOException eee) {
                                }
                                continue;
                            }
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
                            for (int j = 0; j < temp.op.size(); j++) {
                                JSONArray jsar4 = new JSONArray();
                                jsar4.add(temp.op.get(j).id);
                                jsar4.add(temp.op.get(j).getParam(0));
                                jsar3.add(jsar4);
                            }
                            jsar2.add(jsar3);
                            jsar2.add(temp.tierStar);
                            jsar2.add(temp.time_use);
                            jsar2.add(temp.expiry_date);
                            jsar2.add(temp.isHopdo);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`item3` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    for (int i = 0; i < item.wear.length; i++) {
                        Item3 temp = item.wear[i];
                        if (temp != null) {
                            if (temp.expiry_date != 0 && _time > temp.expiry_date) {
                                item.wear[i] = null;
                                try {
                                    item.char_inventory(3);
                                    fashion = Part_fashion.get_part(this);
                                    Service.send_wear(this);
                                    Service.send_char_main_in4(this);
                                    MapService.update_in4_2_other_inside(this.map, this);
                                } catch (IOException eee) {
                                }
                                continue;
                            }
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
                            jsar2.add(temp.expiry_date);
                            jsar2.add(temp.isHopdo);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itemwear` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    for (int i = 0; i < giftcode.size(); i++) {
                        jsar.add(giftcode.get(i));
                    }
                    a += ",`giftcode` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
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
                    for (int i = 0; i < item.box47.size(); i++) {
                        if (item.box47.get(i).category == 4) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(item.box47.get(i).id);
                            jsar2.add(item.box47.get(i).quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itembox4` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    for (int i = 0; i < item.box47.size(); i++) {
                        if (item.box47.get(i).category == 7) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(item.box47.get(i).id);
                            jsar2.add(item.box47.get(i).quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itembox7` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    for (int i = 0; i < item.box5.size(); i++) {
                        if (item.box5.get(i) != null) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(item.box5.get(i).ID);
                            //jsar2.add(item.box5.get(i).name);
                            jsar2.add(item.box5.get(i).quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itembox5` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    for (int i = 0; i < item.box3.length; i++) {
                        Item3 temp = item.box3[i];
                        if (temp != null) {
                            if (temp.expiry_date != 0 && _time > temp.expiry_date) {
                                item.box3[i] = null;
                                try {
                                    conn.p.item.char_chest(3);
                                } catch (IOException eee) {
                                }
                                continue;
                            }
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
                            for (int j = 0; j < temp.op.size(); j++) {
                                JSONArray jsar4 = new JSONArray();
                                jsar4.add(temp.op.get(j).id);
                                jsar4.add(temp.op.get(j).getParam(0));
                                jsar3.add(jsar4);
                            }
                            jsar2.add(jsar3);
                            jsar2.add(temp.tierStar);
                            jsar2.add(temp.time_use);
                            jsar2.add(temp.expiry_date);
                            jsar2.add(temp.isHopdo);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itembox3` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //tui3
                    for (int i = 0; i < item.tui3.length; i++) {
                        Item3 temp = item.tui3[i];
                        if (temp != null) {
                            if (temp.expiry_date != 0 && _time > temp.expiry_date) {
                                item.tui3[i] = null;
                                try {
                                    conn.p.item.char_tui(3);
                                } catch (IOException eee) {
                                }
                                continue;
                            }
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
                            for (int j = 0; j < temp.op.size(); j++) {
                                JSONArray jsar4 = new JSONArray();
                                jsar4.add(temp.op.get(j).id);
                                jsar4.add(temp.op.get(j).getParam(0));
                                jsar3.add(jsar4);
                            }
                            jsar2.add(jsar3);
                            jsar2.add(temp.tierStar);
                            jsar2.add(temp.time_use);
                            jsar2.add(temp.expiry_date);
                            jsar2.add(temp.isHopdo);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itemtui3` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    
                    //
                     //
                    for (int i = 0; i < item.tui47.size(); i++) {
                        if (item.tui47.get(i).category == 4) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(item.tui47.get(i).id);
                            jsar2.add(item.tui47.get(i).quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itemtui4` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    for (int i = 0; i < item.tui47.size(); i++) {
                        if (item.tui47.get(i).category == 7) {
                            JSONArray jsar2 = new JSONArray();
                            jsar2.add(item.tui47.get(i).id);
                            jsar2.add(item.tui47.get(i).quantity);
                            jsar.add(jsar2);
                        }
                    }
                    a += ",`itemtui7` = '" + jsar.toJSONString() + "'";
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

                    //sieuthan
                    for (int i = 0; i < NLsieuthan.length; i++) {
                        jsar.add(NLsieuthan[i]);
                    }
                    a += ",`item_star_sieuthan` = '" + jsar.toJSONString() + "'";
                    jsar.clear();

                    //sieucap
                    for (int i = 0; i < NLsieucap.length; i++) {
                        jsar.add(NLsieucap[i]);
                    }
                    a += ",`item_star_sieucap` = '" + jsar.toJSONString() + "'";
                    jsar.clear();

                    for (int i = 0; i < point_active.length; i++) {
                        jsar.add(point_active[i]);
                    }
                    a += ",`point_active` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    // skill new
                    for (int i = 0; i < skill_new.length; i++) {
                        jsar.add(skill_new[i]);
                    }
                    a += ",`skill_new` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    // diem danh moi
                    for (int i = 0; i < diem_danh.length; i++) {
                        jsar.add(diem_danh[i]);
                    }
                    a += ",`diem_danh` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    // tu tien
                    for (int i = 0; i < tu_tien.length; i++) {
                        jsar.add(tu_tien[i]);
                    }
                    a += ",`tu_tien` = '" + jsar.toJSONString() + "'";
                    jsar.clear();
                    //
                    a += ",`vang` = " + vang;
                    a += ",`kimcuong` = " + kimcuong;
                    a += ",`exptt` = " + exp_tutien;

                    a += ",`tiemnang` = " + tiemnang;
                    a += ",`kynang` = " + kynang;
                    a += ",`diemdanh` = " + diemdanh;
                    a += ",`chucphuc` = " + chucphuc;
                    a += ",`hieuchien` = " + hieuchien;
                    a += ",`chuyensinh` = " + chuyensinh;
                    a += ",`time_khu2` = " + time_khu2;
                    a += ",`mm_cs` = " + mm_cs;
                    a += ",`luyenthe` = " + luyenthe;
                    a += ",`kinhmach` = " + kinhmach;
                    a += ",`tutien` = " + tutien;
                    a += ",`chuyencan` = " + chuyencan;
                    a += ",`typeexp` = " + type_exp;
                    a += ",`date` = '" + date.toString() + "'";
                    a += ",`point1` = " + point1;
                    a += ",`point2` = " + point2;
                    a += ",`point3` = " + point3;
                    a += ",`point4` = " + point4;
                    a += ",`point_arena` = " + pointarena;
                    a += ",`levellt` = " + levellt;
                    a += ",`typelt` = " + typelt;
                    a += ",`point_lt` = " + point_lt;
                    a += ",`task_point` = " + task_point;
                    a += ",`td_nbtd` = " + td_nbtd;

                    ObjectMapper objectMapper = new ObjectMapper();
                    String taskNextJson = objectMapper.writeValueAsString(taskNext);
                    String taskFinishJson = objectMapper.writeValueAsString(taskFinish);
                    String taskDoingJson = objectMapper.writeValueAsString(taskDoing);

                    a += ",`task_next` = '" + taskNextJson.replace("'", "''") + "'";
                    a += ",`task_finish` = '" + taskFinishJson.replace("'", "''") + "'";
                    a += ",`task_doing` = '" + taskDoingJson.replace("'", "''") + "'";

                    if (ps.executeUpdate("UPDATE `player` SET " + a + " WHERE `id` = " + this.index + ";") > 0) {
                        connection.commit();
                    }
                    if (connection != null) {
                        ps.close();
                        connection.close();
                    }
                } else {
                this.squire.flushSquire();
                }
                
                
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }

//        System.out.println("flush " + this.conn.user);
    }

    public void change_new_date() throws IOException {
        if (!Util.is_same_day(Date.from(Instant.now()), date) && isOwner) {
        if (map.isMapChienTruong()) {
            return;
        }
        // diem danh
        diem_danh[0] = 0; // dd
        diem_danh[1] = 0; // like
        diem_danh[2] = 0; // dd vip
        diem_danh[3] = 0; //dd_ngay
        diem_danh[4] = 0; // dd x4
        if (conn.vip >= 7) {
            point_active[0] = 25;
            point_active[1] = 0;
            quest_daily[4] = 40;
        } else {
            point_active[0] = 5;
            point_active[1] = 0;
            quest_daily[4] = 20;
        }
        levellt = 1;
        if (map.map_id == 1) {
            this.qua_ngay(this);
        }

        date = Date.from(Instant.now());
  }
    }

    public void set_x2_xp(int type) throws IOException {
        switch (type) {
            case 0: {
                Message m = new Message(62);
                m.writer().writeByte(0);
                m.writer().writeShort(0);
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            case 1: {
                EffTemplate tempp = conn.p.get_EffDefault(-125);
                if (tempp != null) {
                    long time_eff = tempp.time - System.currentTimeMillis();
                    Message m = new Message(62);
                    m.writer().writeByte(1);
                    m.writer().writeShort((short) (time_eff / 60000L));
                    conn.addmsg(m);
                    m.cleanup();
                    //add_EffDefault(-125, 5000, (int) time_eff);
                }
                break;
            }
        }
    }

    public void add_EffDefault(int id, int param, int time) {
        this.body.add_EffDefault(id, param, System.currentTimeMillis() + time);
        // synchronized (list_eff) {
        // if (param == 0) {
        // return;
        // }
        // EffTemplate temp_test = get_EffDefault(id);
        // while (temp_test != null) {
        // list_eff.remove(temp_test);
        // temp_test = get_EffDefault(id);
        // }
        // EffTemplate temp = new EffTemplate(id, param, (System.currentTimeMillis() + time));
        // list_eff.add(temp);
        // }
    }

    public void add_eff(int id, int param, int time) {
        synchronized (list_eff) {
            if (param == 0) {
                return;
            }
            EffTemplate temp_test = get_eff(id);
            while (temp_test != null) {
                list_eff.remove(temp_test);
                temp_test = get_eff(id);
            }
            EffTemplate temp = new EffTemplate(id, param, (System.currentTimeMillis() + time));
            list_eff.add(temp);
        }
    }

    public int getlevelpercent() {
        return (int) ((exp * 1000) / Level.entrys.get(level - 1).exp);
    }

    public void load_in4_autoplayer(byte[] num) {
        this.in4_auto = num;
        // System.out.println(hp_mp_can_pick);
        // num[0]; on off auto use poition (0 = off)
        // num[1]; %hp use poition
        // num[2]; %mp use poition
        // num[3]; on off pick item (0 = off)
        // num[4];(0 = all, 1 ->)
        // num[5]; (0 = all, 1 = non)
        // num[6]; (0 = all, 1 = hp, 2 = mp, 3 = non)
    }

    public void change_map(Player p, Vgo vgo) throws IOException {

        if (map.map_id == 0) {
            Message m = new Message(55);
            m.writer().writeByte(1);
            m.writer().writeShort(2);
            m.writer().writeByte(-1);
            m.writer().writeByte(0);
            conn.addmsg(m);
            m.cleanup();
        }
        // if (p.map.map_id == 1 && !this.isOwner) {
        // // Kiểm tra xem id_map_go có nằm trong khoảng từ 0 đến 126 và không phải là 1
        // if (vgo.id_map_go >= 0 && vgo.id_map_go <= 126 && vgo.id_map_go != 1) {
        // // Đưa người chơi về tọa độ an toàn
        // p.x = 731;
        // p.y = 228;
        // Service.send_notice_nobox_white(p.conn, "Đệ Tử chỉ có thể ở làng!");
        // return;
        // }
        // }

        if (p.map.map_id == 0 && vgo.id_map_go == 1 && p.task_point <= 1) {
            // Nếu không đủ điều kiện task_point, đẩy người chơi ra tọa độ an toàn
            p.x = 1192;
            p.y = 126;
            Service.send_notice_nobox_white(p.conn, "Chưa hoàn thành nhiệm vụ!");
            return;
        }

        if (p.map.map_id == 124) {
            p.ismap124 = true;
        }

        Message m = new Message(-104);
        m.writer().writeByte(1);
        m.writer().writeShort(2);
        m.writer().writeByte(-1);
        m.writer().writeByte(0);
        conn.addmsg(m);
        m.cleanup();

        p.is_changemap = false;
        p.x_old = vgo.x_old;
        p.y_old = vgo.y_old;
        Map[] mbuffer = Map.get_map_by_id(vgo.id_map_go);
        if (mbuffer != null) {
            Map mbuffer2 = null;
            if (party != null) {
                for (int i = 0; i < party.get_mems().size(); i++) {
                    Player p0 = party.get_mems().get(i);
                    if (p0.map.map_id == mbuffer[0].map_id) {
                        mbuffer2 = p0.map;
                    }
                }
            }
            if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593
                    || conn.p.item.wear[11].id == 3596)) {
                mbuffer2 = mbuffer[mbuffer[0].maxzone];
            } else {
                if (mbuffer2 == null) {
                    for (Map mapp : mbuffer) {

                        //Map zon = Map.get_map_by_id(vgo.id_map_go)[0];
                        if (mapp.players.size() < mapp.maxplayer) {

                            mbuffer2 = mapp;
                            break;
                        }
                        if (mapp.players.size() >= mapp.maxplayer) {
                            int max = mapp.maxzone;
                            int zone_random = (short) (Util.random(2, max--));
                            Map zon = Map.get_map_by_id(vgo.id_map_go)[zone_random];
                            if (zone_random != 1 && zone_random != mapp.maxzone) {
                                mbuffer2 = zon;

                            }
                            break;
                        }

                    }
                }
            }

            if (mbuffer2 == null) {
                Service.send_notice_box(p.conn, "Có lỗi xảy ra khi chuyển map hoặc đã đầy, hãy thử lại sau");
                return;
            }
            // di buon
            boolean tele = true;
            for (Vgo item : p.map.vgos) {
                if (item.id_map_go == mbuffer2.map_id) {
                    tele = false;
                    break;
                }
            }
            if (p.pet_di_buon != null && !tele
                    && (Math.abs(p.pet_di_buon.x - p.x) < 125 && Math.abs(p.pet_di_buon.y - p.y) < 125)) {
                Message mout = new Message(8);
                mout.writer().writeShort(p.pet_di_buon.index);
                for (int i = 0; i < map.players.size(); i++) {
                    Player p0 = map.players.get(i);
                    if (p0 != null) {
                        p0.conn.addmsg(mout);
                    }
                }
                mout.cleanup();
                p.pet_di_buon.x = vgo.x_new;
                p.pet_di_buon.y = vgo.y_new;
                p.pet_di_buon.id_map = mbuffer2.map_id;
                Message m22 = new Message(4);
                m22.writer().writeByte(1);
                m22.writer().writeShort(131);
                m22.writer().writeShort(conn.p.pet_di_buon.index);
                m22.writer().writeShort(conn.p.pet_di_buon.x);
                m22.writer().writeShort(conn.p.pet_di_buon.y);
                m22.writer().writeByte(-1);
                conn.addmsg(m22);
                m22.cleanup();
            }
            // Mị
            if (p.pet_mi_nuong != null && !tele
                    && (Math.abs(p.pet_mi_nuong.x - p.x) < 125 && Math.abs(p.pet_mi_nuong.y - p.y) < 125)) {
                Message mout = new Message(8);
                mout.writer().writeShort(p.pet_mi_nuong.index);
                for (int i = 0; i < map.players.size(); i++) {
                    Player p0 = map.players.get(i);
                    if (p0 != null) {
                        p0.conn.addmsg(mout);
                    }
                }
                mout.cleanup();
                p.pet_mi_nuong.x = vgo.x_new;
                p.pet_mi_nuong.y = vgo.y_new;
                p.pet_mi_nuong.id_map = mbuffer2.map_id;
                Message m22 = new Message(4);
                m22.writer().writeByte(1);
                m22.writer().writeShort(150);
                m22.writer().writeShort(conn.p.pet_mi_nuong.index);
                m22.writer().writeShort(conn.p.pet_mi_nuong.x);
                m22.writer().writeShort(conn.p.pet_mi_nuong.y);
                m22.writer().writeByte(-1);
                conn.addmsg(m22);
                m22.cleanup();
            }
            //
            MapService.leave(p.map, p);
            p.map = mbuffer2;
            p.x = vgo.x_new;
            p.y = vgo.y_new;
            p.x_old = p.x;
            p.y_old = p.y;
            if (conn.p != null && conn.p.squire != null && conn.p.isLiveSquire) {
                if (this.squire != null) {
                    //this.squire.resetTarget();
                } else {
                    // X? lý tr??ng h?p this.squire là null
                    System.out.println("Lỗi: this.squire là null");
                }
            }

            MapService.enter(p.map, p);
        } else {
            Service.send_notice_box(p.conn, "Có lỗi xảy ra khi chuyển map");
        }
    }

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
            Service.send_char_main_in4(this);
            MapService.update_in4_2_other_inside(map, this);

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

    /* public void update_Exp(long expup, boolean expmulti) throws IOException {
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
        if (!isOwner && owner.level <= level) {
            level = owner.level;
            return;
        }
        if (level >= Manager.gI().lvmax || type_exp == 0) {
            return;
        }
        Message m;
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
            if (level == Manager.gI().lvmax && exp >= Level.entrys.get(level - 1).exp) {
                exp = Level.entrys.get(level - 1).exp - 1;
            }
            hp = body.get_HpMax();
            mp = body.get_MpMax();
            m = new Message(33);
            m.writer().writeShort(index);
            m.writer().writeByte(level);
            MapService.send_msg_player_inside(map, this, m, true);
            m.cleanup();
            Service.send_char_main_in4(this);
            MapService.update_in4_2_other_inside(map, this);
            if (party != null) {
                party.sendin4();
            }
        }
        m = new Message(30);
        m.writer().writeShort(index);
        m.writer().writeShort(getlevelpercent());
        m.writer().writeInt(exp_as_int);
        conn.addmsg(m);
        m.cleanup();
    }*/
    public void change_zone(Session conn2, Message m2) throws IOException, InterruptedException {
        // Kiểm tra nếu map hiện tại là map 0
        if (this.map.map_id == 0) {
            Message m = new Message(55);
            m.writer().writeByte(1);
            m.writer().writeShort(2);
            m.writer().writeByte(-1);
            m.writer().writeByte(0);
            conn.addmsg(m);
            m.cleanup();
        }

        Message m = new Message(-104);
        m.writer().writeByte(1);
        m.writer().writeShort(2);
        m.writer().writeByte(-1);
        m.writer().writeByte(0);
        conn.addmsg(m);
        m.cleanup();

        // Đọc khu vực mới từ tin nhắn
        byte zone = m2.reader().readByte();

        // Kiểm tra nếu khu vực mới nhỏ hơn số khu vực tối đa của map hiện tại
        // hoặc nếu người chơi đang mặc một số vật phẩm đặc biệt
        if (zone < this.map.maxzone || (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599
                || conn.p.item.wear[11].id == 3593 || conn.p.item.wear[11].id == 3596))) {
            // Kiểm tra nếu khu vực mới khác với khu vực hiện tại
            if (zone != this.map.zone_id) {
                // Lấy thông tin map mới từ map_id và zone
                Map map = Map.get_map_by_id(this.map.map_id)[zone];

                if (zone == 1 && (!(khu2.isDont_khu2(this.map.map_id))) && (!(this.time_khu2 > 0))) {
                    Service.send_box_input_yesno(conn, 127, "Bạn Có Muốn Vào Khu 2 Với Giá 10k Ngọc ?");

                    return;
                }

                if (zone == 1 && this.time_khu2 > 0) {

                    if (this.time_k2 == 0) {
                        time_k2 = 1;
                        khu2.khu2_a(map, conn);
                    }
                    if (this.time_k2 == 1) {
                        khu2.khu2_b(map, conn);
                    }
                    return;
                }

                // Kiểm tra nếu map mới đã đầy người chơi
                if (map.players.size() >= map.maxplayer) {
                    // Nếu map đã đầy và không mặc item 4711 -> Cấm vào  
                    if (conn.p.item.wear[11] == null || conn.p.item.wear[11].id != 4711) {
                        Service.send_notice_box(conn, "Khu đã đầy, hoặc lỗi!");
                        return;
                    }
                }

                int zon = map.maxplayer;
                //zon = 50;
                if (map.zone_id == 0 && map.players.size() >= zon) {
                    // Nếu khu đã đầy và không mặc item 4711 -> Chặn  
                    if (conn.p.item.wear[11] == null || conn.p.item.wear[11].id != 4711) {
                        Service.send_notice_box(conn, "Khu Đầy");
                        return;
                    }
                }

                if (map.map_id == 119) {
                    Service.send_notice_box(conn, "Không Thể Đổi Khu Trong Map Này");
                    return;
                }

                // Rời khỏi map hiện tại
                MapService.leave(this.map, this);

                // Cập nhật map mới
                this.map = map;

                // Nhập cảnh vào map mới
                if (conn.p != null && conn.p.squire != null && conn.p.isLiveSquire) {
                    //this.squire.resetTarget();
                }
                //this.squire.resetTarget();
                MapService.enter(this.map, this);
            } else {
                Service.send_notice_box(conn, "Bạn đang ở khu vực này!");
            }
        }

    }

    public synchronized boolean update_coin(long coin_exchange) throws IOException {
        String query = "SELECT `coin` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        long coin_old = 0;
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            coin_old = rs.getLong("coin");
            if (coin_old + coin_exchange < 0) {
                Service.send_notice_box(conn, "Không đủ coin");
                return false;
            }
            coin_old += coin_exchange;
            if (ps.executeUpdate(
                    "UPDATE `account` SET `coin` = " + coin_old + " WHERE `user` = '" + conn.user + "'") == 1) {
                connection.commit();
            }
        } catch (SQLException e) {
            Service.send_notice_box(conn, "Đã xảy ra lỗi");
        }
        return true;
    }

    public synchronized boolean update_tongnap(int tongnap_exchange) throws IOException {
        String query = "SELECT `tongnap` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        int tongnap_old = 0;
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            tongnap_old = rs.getInt("tongnap");
            if (tongnap_old + tongnap_exchange < 0) {
                Service.send_notice_box(conn, "Không đủ Điểm Nạp");
                return false;
            }
            tongnap_old += tongnap_exchange;
            if (ps.executeUpdate(
                    "UPDATE `account` SET `tongnap` = " + tongnap_old + " WHERE `user` = '" + conn.user + "'") == 1) {
                connection.commit();
            }
        } catch (SQLException e) {
            Service.send_notice_box(conn, "Đã xảy ra lỗi");
        }
        return true;
    }

    public synchronized boolean update_tiennap(int tiennap_exchange) throws IOException {
        String query = "SELECT `tiennap` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        int tiennap_old = 0;
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            tiennap_old = rs.getInt("tiennap");
            if (tiennap_old + tiennap_exchange < 0) {
                Service.send_notice_box(conn, "Không đủ Điểm Nạp");
                return false;
            }
            tiennap_old += tiennap_exchange;
            if (ps.executeUpdate(
                    "UPDATE `account` SET `tiennap` = " + tiennap_old + " WHERE `user` = '" + conn.user + "'") == 1) {
                connection.commit();
            }
        } catch (SQLException e) {
            Service.send_notice_box(conn, "Đã xảy ra lỗi");
        }
        return true;
    }

    public synchronized boolean update_point_nap(int point_nap_exchange) throws IOException {
        String query = "SELECT `point_nap` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        int point_nap_old = 0;
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            point_nap_old = rs.getInt("point_nap");
            if (point_nap_old + point_nap_exchange < 0) {
                Service.send_notice_box(conn, "Không đủ Điểm Nạp");
                return false;
            }
            point_nap_old += point_nap_exchange;
            if (ps.executeUpdate(
                    "UPDATE `account` SET `point_nap` = " + point_nap_old + " WHERE `user` = '" + conn.user + "'") == 1) {
                connection.commit();
            }
        } catch (SQLException e) {
            Service.send_notice_box(conn, "Đã xảy ra lỗi");
        }
        return true;
    }

    public synchronized long get_coin() throws IOException {
        long result = 0;
        String query = "SELECT `coin` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            result = rs.getLong("coin");
        } catch (SQLException e) {
            result = 0;
        }
        return result;
    }

    public synchronized int get_tongnap() throws IOException {
        int result = 0;
        String query = "SELECT `tongnap` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            result = rs.getInt("tongnap");
        } catch (SQLException e) {
            result = 0;
        }
        return result;
    }

    public synchronized int get_tiennap() throws IOException {
        int result = 0;
        String query = "SELECT `tiennap` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            result = rs.getInt("tiennap");
        } catch (SQLException e) {
            result = 0;
        }
        return result;
    }

    public synchronized int get_point_nap() throws IOException {
        int result = 0;
        String query = "SELECT `point_nap` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            result = rs.getInt("point_nap");
        } catch (SQLException e) {
            result = 0;
        }
        return result;
    }

    public boolean check_moc_nap(int i) {
        return conn.moc_nap.contains(i + "");
    }

    public synchronized boolean history_coin(int coin_exchange, String log) throws IOException {
        String query
                = "INSERT INTO `history_coin` (`user_id`, `user_name`, `name_player` , `coin_change`, `logger`) VALUES ('"
                + this.conn.id + "', '" + this.conn.user + "', '" + this.name + "', '" + coin_exchange + "', '" + log + "')";
        try (Connection connection = SQL.gI().getConnection(); Statement statement = connection.createStatement();) {
            if (statement.executeUpdate(query) > 0) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void down_mount(Message m2) throws IOException {
        byte type = m2.reader().readByte();
        if (type == -1) {
            Message m = new Message(-97);
            m.writer().writeByte(0);
            m.writer().writeByte(-1);
            m.writer().writeShort(this.index);
            MapService.send_msg_player_inside(this.map, this, m, true);
            m.cleanup();
            this.type_use_mount = -1;
            this.id_horse = -1;
            MapService.update_in4_2_other_inside(this.map, this);
            Service.send_char_main_in4(this);
        }
    }

    public void rest_skill_point() throws IOException {
//        for (int i = 0; i < skill_point.length - 2; i++) {
//            if (skill_point[i] > 0) {
//                kynang += skill_point[i];
//            }
//        }
        short sk_110 = 0;
        for (int i = 0; i < skill_point.length; i++) {
            if (skill_point.length - i <= 2) {
                sk_110 += skill_point[i];
            } else if (skill_point[i] > 0) {
                skill_point[i] = 0;
            }
        }
        skill_point[0] = 1;
//        kynang -= 1;
        kynang = (short) (1 + Level.get_kynang_by_level(level - 1));
        kynang -= sk_110;
        hp = body.get_HpMax();
        mp = body.get_MpMax();
        Service.send_char_main_in4(this);
        for (int i = 0; i < map.players.size(); i++) {
            Player p0 = map.players.get(i);
            if (p0.index != this.index && ((Math.abs(p0.x - this.x) < 200 && Math.abs(p0.y - this.y) < 200)
                    || Map.is_map__load_board_player(map.map_id))) {
                MapService.send_in4_other_char(p0.map, p0, this);
            }
        }
    }

    // exp nhân
    public void rest_potential_point() throws IOException {
        tiemnang += (conn.p.point1 + conn.p.point2 + conn.p.point3 + conn.p.point4);
        point1 = (short) (4 + level);
        point2 = (short) (4 + level);
        point3 = (short) (4 + level);
        point4 = (short) (4 + level);
        tiemnang -= (conn.p.point1 + conn.p.point2 + conn.p.point3 + conn.p.point4);
        hp = body.get_HpMax();
        mp = body.get_MpMax();
        Service.send_char_main_in4(this);
        for (int i = 0; i < map.players.size(); i++) {
            Player p0 = map.players.get(i);
            if (p0.index != this.index && ((Math.abs(p0.x - this.x) < 200 && Math.abs(p0.y - this.y) < 200)
                    || Map.is_map__load_board_player(map.map_id))) {
                MapService.send_in4_other_char(p0.map, p0, this);
            }
        }
    }

    public void checkFullSetTT() {
        if (item.wear[1] != null && item.wear[7] != null && item.wear[6] != null) {
            if (item.wear[1].isTT() && item.wear[7].isTT() && item.wear[6].isTT()) {
                item.wear[1].UpdateOption();
                item.wear[7].UpdateOption();
                item.wear[6].UpdateOption();
            }

        }
        if (item.wear[0] != null && item.wear[3] != null && item.wear[9] != null) {
            if (item.wear[0].isTT() && item.wear[3].isTT() && item.wear[9].isTT()) {
                item.wear[0].UpdateOption();
                item.wear[3].UpdateOption();
                item.wear[9].UpdateOption();
            }

        }
        if (item.wear[8] != null && item.wear[4] != null && item.wear[2] != null && item.wear[8].isTT() && item.wear[4].isTT() && item.wear[2].isTT()) {
            if (item.wear[8].isTT() && item.wear[4].isTT() && item.wear[2].isTT()) {
                item.wear[8].UpdateOption();
                item.wear[4].UpdateOption();
                item.wear[2].UpdateOption();
            }
        }
        if (item.wear[1] != null && item.wear[7] != null && item.wear[6] != null) {
            if (!item.wear[1].isTT() || !item.wear[7].isTT() || !item.wear[6].isTT()) {
                item.wear[1].ReUpdateOption();
                item.wear[7].ReUpdateOption();
                item.wear[6].ReUpdateOption();
            }
        }
        if (item.wear[0] != null && item.wear[3] != null && item.wear[9] != null) {
            if (!item.wear[0].isTT() || !item.wear[3].isTT() || !item.wear[9].isTT()) {
                item.wear[0].ReUpdateOption();
                item.wear[3].ReUpdateOption();
                item.wear[9].ReUpdateOption();
            }
        }
        if (item.wear[8] != null && item.wear[4] != null && item.wear[2] != null) {
            if (!item.wear[8].isTT() || !item.wear[4].isTT() || !item.wear[2].isTT()) {
                item.wear[8].ReUpdateOption();
                item.wear[4].ReUpdateOption();
                item.wear[2].ReUpdateOption();
            }
        }
    }

    public void player_wear(Session conn2, Item3 temp3, int index_bag, byte index_wear) throws IOException {
        byte b = -1;
        switch (temp3.type) {
            case 0: {// coat
                b = 1;
                break;
            }
            case 1: {// pant
                b = 7;
                break;
            }
            case 2: {// crown
                b = 6;
                break;
            }
            case 3: {// grove
                b = 2;
                break;
            }
            case 4: {// ring
                if (index_wear == 3 || index_wear == 9) {
                    b = index_wear;
                } else {
                    b = 3;
                }
                break;
            }
            case 5: {// chain
                b = 4;
                break;
            }
            case 6: {// shoes
                b = 8;
                break;
            }
            case 7: {// wing
                b = 10;
                break;
            }
            case 8:
            case 9:
            case 10:
            case 11: { // weapon
                b = 0;
                break;
            }
            case 15: {
                b = 11;
                break;
            }
            case 16: {
                b = 12;
                break;
            }
            case 21: {
                b = 13;
                break;
            }
            case 22: {
                b = 14;
                break;
            }
            case 23: {
                b = 15;
                break;
            }
            case 24: {
                b = 17;
                break;
            }
            case 25: {
                b = 16;
                break;
            }
            case 26: {
                b = 18;
                break;
            }
            case 27: {
                b = 19;
                break;
            }
            case 28: {
                b = 20;
                break;
            }

            case 29: {
                b = 21;
                break;
            }

            case 30: {
                b = 22;
                break;
            }
        }
        if (b == -1) {
            Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại");
            return;
        }
        if (item.wear[b] == null) {
            temp3.name = ItemTemplate3.item.get(temp3.id).getName() + " [Khóa]";
            temp3.UpdateName();
            item.wear[b] = temp3;
            checkFullSetTT();
            item.remove(3, index_bag, 1);
        } else {
            Item3 buffer = item.wear[b];
            temp3.name = ItemTemplate3.item.get(temp3.id).getName() + " [Khóa]";
            temp3.UpdateName();
            item.wear[b] = temp3;
            checkFullSetTT();
            item.remove(3, index_bag, 1);
            if (buffer.id != 3593 && buffer.id != 3599 && buffer.id != 3596) {
                buffer.ReUpdateOption();
                item.add_item_bag3(buffer);
            }
        }
        if (b == 11) {
            fashion = Part_fashion.get_part(this);
        }

        item.char_inventory(4);
        item.char_inventory(7);
        item.char_inventory(3);
        Service.send_wear(this);
        Service.send_char_main_in4(conn.p);
        MapService.update_in4_2_other_inside(this.map, this);
    }

    public void plus_point(Message m) throws IOException {
        byte type = m.reader().readByte();
        byte index = m.reader().readByte();
        short value = 1;
        try {
            value = m.reader().readShort();
        } catch (IOException e) {
        }
        if (isdie || value < 0) {
            return;
        }
        if (type == 1) { // Loại 1: Tăng điểm kỹ năng
            if (kynang >= value) { // Kiểm tra có đủ lượng kỹ năng để tăng không
                if (skill_point[index] == 0 && skills[index].mLvSkill[0].LvRe > this.level) {
                    Service.send_notice_box(conn, "Level quá thấp!"); // Nếu level quá thấp, thông báo và kết thúc
                    return;
                }
                if (skill_point[index] == 0 && (index == 19 || index == 20)) {
                    boolean consumedBook = false; // Đánh dấu xem đã tiêu thụ sách kỹ năng chưa

                    // Xác định ID sách kỹ năng dựa vào class và index
                    int bookId = 0;
                    switch (clazz) {
                        case 0:
                            bookId = (index == 19) ? 4577 : 4578;
                            break;
                        case 1:
                            bookId = (index == 19) ? 4579 : 4580;
                            break;
                        case 2:
                            bookId = (index == 19) ? 4581 : 4582;
                            break;
                        case 3:
                            bookId = (index == 19) ? 4583 : 4584;
                            break;
                    }

                    // Thử tiêu thụ một cuốn sách
                    for (int i = 0; i < item.bag3.length; i++) {
                        if (item.bag3[i] != null && item.bag3[i].id == bookId) {
                            item.bag3[i] = null; // Tiêu thụ cuốn sách
                            consumedBook = true; // Đánh dấu là đã tiêu thụ sách
                            break; // Thoát khỏi vòng lặp sau khi tiêu thụ sách
                        }
                    }

                    // Nếu chưa tiêu thụ sách và không phải admin, thông báo và kết thúc
                    if (!consumedBook && conn.ac_admin < 3) {
                        Service.send_notice_box(conn, "Chưa có sách kỹ năng để học!");
                        return;
                    }

                    item.char_inventory(3); // Cập nhật lại kho đồ của nhân vật sau khi tiêu thụ sách
                }

                // Tăng điểm kỹ năng và điều chỉnh lại lượng kỹ năng còn lại
                if (skill_point[index] + value > skills[index].mLvSkill.length - 5) {
                    value = (short) (skills[index].mLvSkill.length - 5 - skill_point[index]);
                    kynang -= value;
                    skill_point[index] = (byte) (skills[index].mLvSkill.length - 5);
                } else {
                    kynang -= value;
                    skill_point[index] += value;
                }

                // Kiểm tra và điều chỉnh lại số điểm kỹ năng nếu vượt quá level cho phép
                while (skill_point[index] > 1 && this.level < (skills[index].mLvSkill[skill_point[index] - 1].LvRe - 1)) {
                    kynang += 1;
                    skill_point[index] -= 1;
                }

                // Cập nhật lại thông tin trên bản đồ và gửi lại thông tin nhân vật
                MapService.update_in4_2_other_inside(this.map, this);
                Service.send_char_main_in4(this);
            }
        } else if (type == 0) { // Loại 0: Tăng điểm tiềm năng
            if (tiemnang >= value) { // Kiểm tra có đủ lượng tiềm năng để tăng không
                switch (index) {
                    case 0: {
                        if ((point1 + value) <= 2_000_000_000) {
                            point1 += value;
                            tiemnang -= value;
                        }
                        break;
                    }
                    case 1: {
                        if ((point2 + value) <= 2_000_000_000) {
                            point2 += value;
                            tiemnang -= value;
                        }
                        break;
                    }
                    case 2: {
                        if ((point3 + value) <= 2_000_000_000) {
                            point3 += value;
                            tiemnang -= value;
                        }
                        break;
                    }
                    case 3: {
                        if ((point4 + value) <= 2_000_000_000) {
                            point4 += value;
                            tiemnang -= value;
                        }
                        break;
                    }
                }

                // Cập nhật lại thông tin trên bản đồ và gửi lại thông tin nhân vật
                MapService.update_in4_2_other_inside(this.map, this);
                Service.send_char_main_in4(this);
            }
        } else if (type == 2) { // Loại 2: Tăng cấp kỹ năng 110
            if (index == 19 || index == 20) {
                if (conn.p.skill_point[index] != 10) {
                    conn.p.id_index_temp = -1;
                    Service.send_notice_box(conn, "Kỹ năng chưa được cộng tối đa");
                    return;
                }
                if (conn.p.skill_110[index - 19] >= 10) {
                    conn.p.id_index_temp = -1;
                    Service.send_notice_box(conn, "Kỹ năng được nâng cấp tối đa");
                    return;
                }
                this.id_index_temp = (byte) (index - 19);
                MenuController.send_menu_select(conn, -128, new String[]{"Nâng cấp bằng sách", "Nâng cấp bằng sách ghép"});
            }
        }
    }

    public void friend_process(Message m2) throws IOException {
        byte type = m2.reader().readByte();
        String name = m2.reader().readUTF();
        switch (type) {
            case 0: { // request friend
                for (Friend name0 : list_friend) {
                    if (name0.name.equals(name)) {
                        Service.send_notice_box(conn, (name + " đã có trong danh sách bạn bè!"));
                        return;
                    }
                }
                Player p0 = Map.get_player_by_name(name);
                if (p0 == null) {
                    Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại!");
                } else {
                    if (!p0.isOwner) {
                        return;

                    }
                    Message m = new Message(35);
                    m.writer().writeByte(0);
                    m.writer().writeUTF(this.name);
                    p0.conn.addmsg(m);
                    m.cleanup();
                    if (conn.p.nv_tinh_tu[0] == 33 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
                        conn.p.nv_tinh_tu[1]++;
                        Service.send_notice_nobox_white(conn, "Tiến Độ " + conn.p.nv_tinh_tu[1] + "/" + conn.p.nv_tinh_tu[2]);
                    }
                }
                break;
            }
            case 1: { // accept
                Player p0 = Map.get_player_by_name(name);
                if (p0 == null) {
                    Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại!");
                } else {
                    boolean is_fr = false;
                    for (int i = 0; i < list_friend.size(); i++) {
                        if (list_friend.get(i).name.equals(name)) {
                            is_fr = true;
                            break;
                        }
                    }
                    if (!is_fr) {
                        Friend temp = new Friend();
                        temp.name = p0.name;
                        temp.level = p0.level;
                        temp.head = p0.head;
                        temp.hair = p0.hair;
                        temp.eye = p0.eye;
                        temp.itemwear = new ArrayList<>();
                        for (int i = 0; i < p0.item.wear.length; i++) {
                            Item3 it = p0.item.wear[i];
                            if (it != null && (i == 0 || i == 1 || i == 6 || i == 7 || i == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        list_friend.add(temp);
                        //
                        Message m = new Message(35);
                        m.writer().writeByte(1);
                        m.writer().writeUTF(temp.name);
                        m.writer().writeByte(temp.head);
                        m.writer().writeByte(temp.eye);
                        m.writer().writeByte(temp.hair);
                        m.writer().writeShort(temp.level);
                        m.writer().writeByte(temp.itemwear.size()); // part
                        for (Part_player part : temp.itemwear) {
                            m.writer().writeByte(part.part);
                            m.writer().writeByte(part.type);
                        }
                        m.writer().writeByte(1); // type onl
                        if (p0.myclan != null) {
                            m.writer().writeShort(p0.myclan.icon);
                            m.writer().writeUTF(p0.myclan.name_clan_shorted);
                            m.writer().writeByte(p0.myclan.get_mem_type(p0.name));
                        } else {
                            m.writer().writeShort(-1); // clan
                        }
                        conn.addmsg(m);
                        m.cleanup();
                        // //
                        temp = new Friend();
                        temp.name = this.name;
                        temp.level = level;
                        temp.head = head;
                        temp.hair = hair;
                        temp.eye = eye;
                        temp.itemwear = new ArrayList<>();
                        for (int i = 0; i < item.wear.length; i++) {
                            Item3 it = item.wear[i];
                            if (it != null && (i == 0 || i == 1 || i == 6 || i == 7 || i == 10)) {
                                Part_player part = new Part_player();
                                part.type = it.type;
                                part.part = it.part;
                                temp.itemwear.add(part);
                            }
                        }
                        //
                        p0.list_friend.add(temp);

                        //
                        m = new Message(35);
                        m.writer().writeByte(1);
                        m.writer().writeUTF(temp.name);
                        m.writer().writeByte(temp.head);
                        m.writer().writeByte(temp.eye);
                        m.writer().writeByte(temp.hair);
                        m.writer().writeShort(temp.level);
                        m.writer().writeByte(temp.itemwear.size()); // part
                        for (Part_player part : temp.itemwear) {
                            m.writer().writeByte(part.part);
                            m.writer().writeByte(part.type);
                        }
                        m.writer().writeByte(1); // type onl
                        if (this.myclan != null) {
                            m.writer().writeShort(this.myclan.icon);
                            m.writer().writeUTF(this.myclan.name_clan_shorted);
                            m.writer().writeByte(this.myclan.get_mem_type(this.name));
                        } else {
                            m.writer().writeShort(-1); // clan
                        }
                        p0.conn.addmsg(m);
                        m.cleanup();
                    } else {
                        Service.send_notice_box(conn, name + " đã là bạn");
                    }
                }
                break;
            }
            case 2: {
                Player p0 = Map.get_player_by_name(name);
                if (p0 == null) {
                    Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại!");
                } else {
                    Service.send_notice_box(p0.conn, (conn.p.name + " cự tuyệt lời mời kết bạn của bạn kkk!"));
                }
                break;
            }
            case 3: { // remove friend
                for (int i = 0; i < list_friend.size(); i++) {
                    Friend temp = list_friend.get(i);
                    if (temp.name.equals(name)) {
                        list_friend.remove(temp);
                        break;
                    }
                }
                break;
            }
            case 4: {
                Friend.send_list_friend(this);
                break;
            }
        }
    }

    public void moithachdau_process(Player p1, Message m) throws IOException {
        byte type = m.reader().readByte(); // Loại yêu cầu (0: gửi, 1: chấp nhận, 2: từ chối)
        String name = m.reader().readUTF(); // Tên người chơi mục tiêu

        switch (type) {
            case 0: { // Gửi lời mời thách đấu
                // Player p0 = Map.get_player_by_name(name);

                // m = new Message(68); // Mã lệnh 68
                // m.writer().writeByte(0); // Loại yêu cầu: Gửi lời mời
                // m.writer().writeUTF(p.name);  // Tên người gửi
                // m.writer().writeShort(5000); // Gửi mức cược là 5000 ngọc
                // p0.conn.addmsg(m);
                // m.cleanup(); // Dọn dẹp
                MenuController.send_menu_select(p.conn, 610, new String[]{"5000 vàng", "15000 vàng", "30000 vàng"});
                p.name_td = name;
                break;
            }

            case 1: { // Chấp nhận lời mời thách đấu
                Player p0 = Map.get_player_by_name(name); // Lấy người gửi lời mời
                if (p0 == null || p0.conn == null) {
                    Service.send_notice_box(p.conn, "Người chơi không tồn tại hoặc không online.");
                    break;
                }

                // Kiểm tra nếu người chơi đã tham gia một trận đấu
                if (ThachDau.Manager.isPlayerInBattle(p0)) {
                    Service.send_notice_box(p.conn, "Người chơi " + p0.name + " hiện đang trong một trận đấu khác.");
                    break;
                }

                if (ThachDau.Manager.isPlayerInBattle(p)) {
                    Service.send_notice_box(p.conn, "Bạn hiện đang trong một trận đấu khác.");
                    break;
                }
                //int soVangCuoc = p.soVangCuoc;
                System.out.println("Số vàng cược của " + p1.name + ": " + p1.vang_td);
                System.out.println("Số vàng cược của " + p0.name + ": " + p0.vang_td);
                p1.update_vang(-p1.vang_td);
                p0.update_vang(-p0.vang_td);
                p1.item.char_inventory(5);
                p0.item.char_inventory(5);
                try {
                    // Tạo trận đấu mới
                    ThachDau battle = new ThachDau(p0, p1);
                    //battle.soVangCuoc = soVangCuoc; // Lưu số vàng cược vào trận đấu
                    ThachDau.Manager.addBattle(battle);

                    // Đưa người chơi gửi lời mời vào map thách đấu
                    if (p0.map != null) {
                        MapService.leave(p0.map, p0);
                    }
                    p0.map = battle.map;
                    p0.x = 280; // Tọa độ của người chơi 1 trong map thách đấu
                    p0.y = 228;
                    MapService.enter(battle.map, p0);

                    // Đưa người chơi chấp nhận lời mời vào map thách đấu
                    if (p.map != null) {
                        MapService.leave(p1.map, p1);
                    }
                    p1.map = battle.map;
                    p1.x = 440; // Tọa độ của người chơi 2 trong map thách đấu
                    p1.y = 228;
                    MapService.enter(battle.map, p1);

                } catch (IOException e) {
                    e.printStackTrace();
                    Service.send_notice_box(p1.conn, "Lỗi khi bắt đầu trận đấu.");
                }
                break;
            }

            case 2: { // Từ chối lời mời thách đấu
                Player p0 = Map.get_player_by_name(name);
                if (p0 != null && p0.conn != null) {
                    Message rejectMsg = new Message(68); // Mã lệnh 68
                    rejectMsg.writer().writeByte(2); // Loại yêu cầu: Từ chối
                    rejectMsg.writer().writeUTF(p.name); // Người từ chối
                    p0.conn.addmsg(rejectMsg);
                    rejectMsg.cleanup(); // Dọn dẹp
                }

                Service.send_notice_box(p.conn, "Bạn đã từ chối lời mời thách đấu.");
                break;
            }

            default: {
                System.out.println("không có : " + type);
                break;
            }
        }
    }

    /* public void moithachdau1_process(Player p, Message m) throws IOException {
    byte type = m.reader().readByte(); // Loại yêu cầu (0: gửi, 1: chấp nhận, 2: từ chối)
    String name = m.reader().readUTF(); // Tên người chơi mục tiêu

    switch (type) {
        case 0: { // Gửi lời mời thách đấu
            Player p0 = Map.get_player_by_name(name);
            break;
        }
        default: {
            System.out.println("Không có loại yêu cầu: " + type);
            break;
        }
    }
}*/
    public void moithachdau1_process(Player A, Message m) throws IOException {
        byte type = m.reader().readByte();
        String name = m.reader().readUTF();

        switch (type) {
            case 0: { // Gửi lời mời thách đấu
                Player B = Map.get_player_by_name(name);
                if (B != null && B != A) {
                    if (!B.conn.connected || !A.conn.connected) {
                        Service.send_notice_nobox_white(A.conn, "Người chơi không sẵn sàng để thách đấu.");
                        return;
                    }

                    // Tạo đối tượng Nbtd
                    Nbtd nbtd = new Nbtd(A, B);
                    nbtd.setup(B);

                    // Tạo trận đấu thách đấu (ThachDau_Nb)
                    new ThachDau_Nb(A, B, nbtd);

                    // Gửi thông báo cho người chơi
                    Service.send_notice_nobox_white(A.conn, "Trận đấu thách đấu đã bắt đầu!");
                } else {
                    Service.send_notice_nobox_white(A.conn, "Không thể thách đấu người chơi này!");
                }
                break;
            }

            default: {
                System.out.println("Không có loại yêu cầu: " + type);
                break;
            }
        }
    }

    public int get_pramskill_byid(byte index_skill, byte id_param) {
        int param = 0;
        for (Option temp : skills[index_skill].mLvSkill[body.get_skill_point(index_skill) - 1].minfo) {
            if (temp.id == id_param) {
                param += temp.getParam(0);
            }
        }
        return param;
    }

    public void set_in4() throws IOException {
        id_henshin = -1;
        this.already_setup = true;
        time_use_item_arena = System.currentTimeMillis() + 250_000L;
        load_skill();
//        try{
//            CheckSkillPoint();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        CheckSkillPoint();
        suckhoe = 30000;
        typepk = -1;
        pointpk = hieuchien;
        hp = body.get_HpMax();
        mp = body.get_MpMax();

        fashion = Part_fashion.get_part(this);//Part_fashion.get_part(this);

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
        list_thao_kham_ngoc = new ArrayList<>();
        this.it_wedding = Wedding.get_obj(this.name);
        if (this.it_wedding != null) {
            this.item.wear[23] = this.it_wedding.it;
        }

        //
        Map[] map_enter = Map.get_map_by_id(map.map_id);
        int d = 0;
        while ((d < (map_enter[d].maxzone - 1)) && map_enter[d].players.size() >= map_enter[d].maxplayer) {
            d++;
        }
        map = map_enter[d];
        //
        this.is_changemap = false;
        this.x_old = this.x;
        this.y_old = this.y;
        //
        HashMap<Short, Integer> hm = new HashMap<>();
        for (Item47 it : item.bag47) {
            if (it.category == 7) {
                if (!hm.containsKey(it.id)) {
                    hm.put(it.id, (int) it.quantity);
                } else {
                    int quant = hm.get(it.id);
                    hm.replace(it.id, quant, quant + it.quantity);
                }
            }
        }
        HashMap<Short, Integer> hm2 = new HashMap<>();
        for (Item47 it : item.bag47) {
            if (it.category == 4) {
                if (!hm2.containsKey(it.id)) {
                    hm2.put(it.id, (int) it.quantity);
                } else {
                    int quant = hm2.get(it.id);
                    hm2.replace(it.id, quant, quant + it.quantity);
                }
            }
        }
        item.bag47.clear();
        for (Entry<Short, Integer> entry : hm.entrySet()) {
            Item47 temp = new Item47();
            temp.category = 7;
            temp.id = entry.getKey();
            int quant_ = entry.getValue();
            temp.quantity = (short) quant_;
            item.bag47.add(temp);
        }
        for (Entry<Short, Integer> entry : hm2.entrySet()) {
            Item47 temp = new Item47();
            temp.category = 4;
            temp.id = entry.getKey();
            int quant_ = entry.getValue();
            temp.quantity = (short) quant_;
            item.bag47.add(temp);
        }
        //
        item.char_inventory(4);
        item.char_chest(4);
        item.char_inventory(7);
        item.char_chest(7);
        item.char_inventory(3);
        item.char_chest(3);
        item.char_inventory(5);
        item.char_chest(5);
        // item.char_tui(3);
        // item.char_tui(4);
        // item.char_tui(7);
        isOwner = true;
        owner = this;
        squire = new Squire(this.conn, this.index);
        squire = squire.load();
        if (this.level == 1 && this.taskNext.isEmpty() && this.taskDoing.isEmpty() && this.taskFinish.isEmpty()) {
            TaskTemplate task = TaskTemplate.getTask(TaskTemplate.tasks, 0, false);
            this.taskNext.add(task);
        }

        Log.gI().add_log(this.name,
                "Login : [Vàng] : " + Util.number_format(this.vang) + " : [Ngọc] : " + Util.number_format(this.kimcuong));
    }

    public void update_wings_time() throws IOException {
        boolean check = false;
        for (int i = 0; i < item.bag3.length; i++) {
            Item3 it = item.bag3[i];
            if (it != null && it.type == 7 && it.time_use != 0) {
                if ((it.time_use - System.currentTimeMillis()) <= 0) {
                    it.time_use = 0;
                    check = true;
                }
            }
        }
        if (check) {
            item.char_inventory(4);
            item.char_inventory(7);
            item.char_inventory(3);
        }
    }

    public void change_map_di_buon(Player p) throws IOException {
        p.is_changemap = false;
        Map[] mbuffer = Map.get_map_by_id(p.map.map_id);
        if (mbuffer != null) {
            MapService.leave(p.map, p);
            p.map = mbuffer[p.map.maxzone];
            MapService.enter(p.map, p);
            if (p.pet_di_buon != null) {
                Message mout = new Message(8);
                mout.writer().writeShort(p.pet_di_buon.index);
                for (int i = 0; i < p.map.players.size(); i++) {
                    Player p0 = p.map.players.get(i);
                    if (p0 != null) {
                        p0.conn.addmsg(mout);
                    }
                }
                mout.cleanup();
                //
                Pet_di_buon_manager.remove(p.pet_di_buon.name);
                p.pet_di_buon = null;
            }
        } else {
            Service.send_notice_box(p.conn, "Có lỗi xảy ra khi chuyển map");
        }
    }

    public void show_eff_p(int id_eff, int time) throws IOException {
        Message m = new Message(-49);
        m.writer().writeByte(2);
        m.writer().writeShort(0);
        m.writer().writeByte(0);
        m.writer().writeByte(0);
        m.writer().writeByte(id_eff);
        m.writer().writeShort(this.index);
        m.writer().writeByte(0);
        m.writer().writeByte(0);
        m.writer().writeInt(time);
        MapService.send_msg_player_inside(this.map, this, m, true);
        m.cleanup();
    }

    public synchronized boolean update_naptuan(int naptuan_exchange) throws IOException {
        String query = "SELECT `naptuan` FROM `account` WHERE `user` = '" + conn.user + "' LIMIT 1;";
        int naptuan_old = 0;
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            naptuan_old = rs.getInt("naptuan");
            if (naptuan_old + naptuan_exchange < 0) {
                Service.send_notice_box(conn, "");
                return false;
            }
            naptuan_old += naptuan_exchange;
            if (ps.executeUpdate(
                    "UPDATE `account` SET `naptuan` = " + naptuan_old + " WHERE `user` = '" + conn.user + "'") == 1) {
                connection.commit();
            }
        } catch (SQLException e) {
            Service.send_notice_box(conn, "Đã xảy ra lỗi");
        }
        return true;
    }

    public synchronized static void update_coin(String name, long coin_exchange) throws IOException {
        String query = "SELECT `coin` FROM `account` WHERE `user` = '" + name + "' LIMIT 1;";
        long coin_old = 0;
        try (Connection connection = SQL.gI().getConnection(); Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {
            rs.next();
            coin_old = rs.getLong("coin");
            if (coin_old + coin_exchange < 0) {
                return;
            }
            coin_old += coin_exchange;
            if (ps.executeUpdate("UPDATE `account` SET `coin` = " + coin_old + " WHERE `user` = '" + name + "'") == 1) {
                connection.commit();
            }
        } catch (SQLException e) {
        }
    }

    public synchronized void up_quai_rot_ngoc(long i) {
        if ((i + kimcuong) > 2_000_000_000L) {
            kimcuong = 2_000_000_000;
        } else {
            kimcuong += i;
        }
    }

    public int get_id_eff_skill(int type) {
        int id = 0;
        switch (this.clazz) {
            case 0:
                if (type == 19) {
                    id = 56;
                } else if (type == 20) {
                    id = 53;
                }
                break;
            case 1:
                if (type == 19) {
                    id = 59; // 59
                } else if (type == 20) {
                    id = 76;
                }
                break;
            case 2:
                if (type == 19) {
                    id = 49;
                } else if (type == 20) {
                    id = 56;
                }
                break;
            case 3:
                if (type == 19) {
                    id = 49;
                } else if (type == 20) {
                    id = 77;
                }
                break;
        }
        return id;
    }

    public static void receiveTask(Session conn, short ID, byte main_sub) {
    try {
        // Chỉ nhận nhiệm vụ nếu là nhiệm vụ chính hoặc phụ (main_sub == 0 hoặc 1)
        TaskTemplate task1 = new TaskTemplate();
        if (main_sub == 0 || main_sub == 1) {
            TaskTemplate task = TaskTemplate.getTask(conn.p.taskNext, ID, task1.isMain); // Tìm nhiệm vụ theo ID

            if (task != null) {
                // Nếu typeItem == 2, nhiệm vụ hoàn thành ngay, thêm vào taskFinish
                if (task.typeItem == 2) {
                    conn.p.taskFinish.add(task);  // Thêm nhiệm vụ vào danh sách hoàn thành
                } else {
                    // Nếu typeItem == 1, nhiệm vụ sẽ được bắt đầu, thêm vào taskDoing
                    conn.p.taskDoing.add(task);
                    // Reset số lượng làm nhiệm vụ (arrQuest) nếu nhiệm vụ yêu cầu tiêu diệt quái vật
                    for (int i = 0; i < task.arrQuest.length; i++) {
                        task.arrQuest[i][1] = 0;  // Reset số lượng đã làm về 0
                    }
                }

                // Loại bỏ nhiệm vụ khỏi danh sách nhiệm vụ tiếp theo (taskNext)
                conn.p.removeQuest(conn.p.taskNext, ID, task1.isMain);

                // Cập nhật lại các danh sách nhiệm vụ
                Service.sendQuestFinish(conn);
                Service.sendQuestDoing(conn);
                Service.sendQuestList(conn);

                // Gửi thông báo cho người chơi
                Service.send_notice_nobox_white(conn, "Đã nhận nhiệm vụ: " + task.name);
            }
        } else {
            // Gửi thông báo nếu cố gắng nhận nhiệm vụ chính (main quest)
            Service.send_notice_nobox_white(conn, "Không thể nhận nhiệm vụ.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void finishTask(Session conn, short ID, byte main_sub) {
        try {
            // Lấy task hoàn thành
            TaskTemplate task = new TaskTemplate();

            if (ID == 0) {
                TaskTemplate task1 = TaskTemplate.getTask(TaskTemplate.tasks, 1, task.isMain);
                if (task1 != null) {
                    conn.p.taskNext.add(task1);
                }
            }
            if (ID == 1) {
                TaskTemplate task2 = TaskTemplate.getTask(TaskTemplate.tasks, 2, task.isMain);
                TaskTemplate task3 = TaskTemplate.getTask(TaskTemplate.tasks, 3, task.isMain);
                TaskTemplate task4 = TaskTemplate.getTask(TaskTemplate.tasks, 4, task.isMain);
                if (task2 != null) {
                    conn.p.taskNext.add(task2);
                }
                if (task3 != null) {
                    conn.p.taskNext.add(task3);
                }
                if (task4 != null) {
                    conn.p.taskNext.add(task4);
                }
            }
            if (ID >= 4) {
                TaskTemplate task5 = TaskTemplate.getTask(TaskTemplate.tasks, ID + 1, task.isMain);
                if (task5 != null) {
                    conn.p.taskNext.add(task5);
                }
            }
            remove5(conn.p);
            conn.p.removeQuest(conn.p.taskFinish, ID, task.isMain);
            //Service.send_notice_nobox_white(conn, "test");
            conn.p.task_point += 1;

            if (task.isMain == true) {
                int coin = 2000;
                conn.p.update_coin(coin);
                conn.p.update_vang(ID * 50_000);
                conn.p.update_ngoc(ID * 5_000);
                Service.send_notice_nobox_white(conn, "Hoàn Thành, Nhận " + coin + " Coin");
            } else {
                int coin = 1000;
                conn.p.update_coin(coin);
                conn.p.update_vang(ID * 25_000);
                conn.p.update_ngoc(ID * 2_000);
                Service.send_notice_nobox_white(conn, "Hoàn Thành, Nhận " + coin + " coin");
            }
            Service.sendQuestFinish(conn);
            Service.sendQuestList(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void remove5(Player p) throws IOException {
        for (TaskTemplate task : p.taskFinish) {
            if (task.typeItem == 0) { // Ki?m tra typeItem c?a nhi?m v? (linh ho?t theo lo?i nhi?m v?)
                short[][] arrQuest = task.arrQuest;

                // Ki?m tra xem arrQuest có t?n t?i và có thông tin nhi?m v? không
                if (arrQuest != null && arrQuest.length > 0) {
                    for (short[] questDetail : arrQuest) {
                        short id = questDetail[0]; // ID mob c?n tiêu di?t
                        int sl = questDetail[2]; // S? l??ng c?n nh?t
                        p.item.remove(5, id, sl);
                        p.item.char_inventory(5);
                    }
                }
            }
        }

    }

    public static void cancelTask(Session conn, short ID, byte main_sub) {
        try {
            TaskTemplate task1 = new TaskTemplate();

            TaskTemplate task = TaskTemplate.getTask(TaskTemplate.tasks, ID, false);
            conn.p.removeQuest(conn.p.taskDoing, ID, task1.isMain);
            conn.p.taskNext.add(task);

            Service.sendQuestFinish(conn);
            Service.sendQuestDoing(conn);
            Service.sendQuestList(conn);
            Service.send_notice_nobox_white(conn, "Đã huỷ nhiệm vụ " + task.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeQuest(List<TaskTemplate> tasks, int ID, boolean isMain) {
        TaskTemplate task1 = new TaskTemplate();
        tasks.removeIf(task -> task.ID == ID && isMain == task1.isMain);
    }

    public void checkTask(short ID, byte type) throws IOException {
        if (!taskDoing.isEmpty()) {
            TaskTemplate taskToComplete = null;

            for (TaskTemplate task : taskDoing) {
                boolean allConditionsMet = true; // Biến cờ để theo dõi trạng thái các điều kiện

                for (int i = 0; i < task.arrQuest.length; i++) {
                    // Kiểm tra nếu loại nhiệm vụ trùng khớp và điều kiện của nhiệm vụ được đáp ứng
                    if (type == task.typeItem && task.arrQuest[i][0] == ID) {
                        if (task.arrQuest[i][1] < task.arrQuest[i][2]) {
                            task.arrQuest[i][1]++;  // Tăng tiến trình nếu chưa hoàn thành
                        }
                    }

                    // Kiểm tra nếu điều kiện chưa được thỏa mãn
                    if (task.arrQuest[i][1] < task.arrQuest[i][2]) {
                        allConditionsMet = false;
                    }
                }

                // Đánh dấu nhiệm vụ hoàn thành chỉ khi tất cả các điều kiện đã được thỏa mãn
                if (allConditionsMet) {
                    taskToComplete = task;
                }
            }

            // Nếu nhiệm vụ hoàn thành, chuyển sang danh sách nhiệm vụ hoàn thành và gửi thông báo
            if (taskToComplete != null) {
                taskDoing.remove(taskToComplete);
                taskFinish.add(taskToComplete);
                Service.sendQuestFinish(conn);
                Service.send_notice_nobox_white(conn, "Hoàn thành nhiệm vụ");
                Service.sendQuestDoing(conn);
            }
        }
    }

    public void checkQuestAndDropItem(Map map, Mob_in_map mob, Player player) throws IOException {
        for (TaskTemplate task : player.taskDoing) {
            if (task.typeItem == 0) { // Kiểm tra typeItem của nhiệm vụ (linh hoạt theo loại nhiệm vụ)
                short[][] arrQuest = task.arrQuest;

                // Kiểm tra xem arrQuest có tồn tại và có thông tin nhiệm vụ không
                if (arrQuest != null && arrQuest.length > 0) {
                    for (short[] questDetail : arrQuest) {
                        short id = questDetail[0]; // ID item5
                        short mobs = questDetail[3]; // ID mob cần tiêu diệt

                        // Kiểm tra xem mob bị tiêu diệt có trùng với mob của nhiệm vụ không
                        if (mob.template.mob_id == mobs) {
                            // Gọi hàm rơi vật phẩm với id và số lượng từ nhiệm vụ
                            if (Util.random(100) < 45) {
                                LeaveItemMap.leave_item5(map, mob, player, id, 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void phan_tram_exp(float phantram) throws IOException {
        // Kiểm tra nếu không tính EXP hoặc đã đạt cấp tối đa
        if (type_exp == 0 || level >= Manager.gI().lvmax) {

            return;
        }

        // Lấy EXP yêu cầu để lên cấp hiện tại
        long currentLevelExp = Level.entrys.get(level - 1).exp;

        // Tính lượng EXP cộng thêm dựa trên phần trăm
        long expToAdd = (long) (currentLevelExp * (phantram / 100.0f));

        // Thêm EXP cho người chơi
        exp += expToAdd;

        // Kiểm tra nếu đã đủ để lên cấp
        boolean leveledUp = false;
        while (exp >= currentLevelExp) {
            // Nếu đã đạt cấp độ tối đa
            if (level >= Manager.gI().lvmax) {
                exp = 0; // Đặt exp về 0 ngay lập tức
                break;
            }

            // Tăng cấp và xử lý các thông tin liên quan
            exp -= currentLevelExp;
            level++;
            leveledUp = true;

            // Lấy thông tin cấp độ mới
            currentLevelExp = Level.entrys.get(level - 1).exp;

            // Cộng điểm kỹ năng và tiềm năng
            point1++;
            point2++;
            point3++;
            point4++;
            if (kynang < 10000) {
                kynang += Level.entrys.get(level - 1).kynang;
            }
            tiemnang += Level.entrys.get(level - 1).tiemnang;

            // Cập nhật thông tin người chơi
            hp = body.get_HpMax();
            mp = body.get_MpMax();
        }

        if (level == Manager.gI().lvmax) {
            if (!Manager.gI().rankedPlayers.contains(this.name)) { // Thay this bằng this.name
                Manager.gI().rankedPlayers.add(this.name); // Thay this bằng this.name

                int rankIndex = Manager.gI().rankedPlayers.indexOf(this.name); // Thay this bằng this.name
                float reductionFactor = 0.010f - rankIndex * 0.001f;
                reductionFactor = Math.max(reductionFactor, 0.001f);
                exp = (long) (Level.entrys.get(level - 1).exp * reductionFactor);
            }
        }

        // Gửi cập nhật EXP cho client
        Message m = new Message(30);
        m.writer().writeShort(index);
        m.writer().writeShort(getlevelpercent());
        m.writer().writeInt((int) expToAdd);
        conn.addmsg(m);
        m.cleanup();

        // Gửi cập nhật cấp độ nếu người chơi lên cấp
        if (leveledUp) {
            Message levelMessage = new Message(33);
            levelMessage.writer().writeShort(index);
            levelMessage.writer().writeByte(level);
            MapService.send_msg_player_inside(map, this, levelMessage, true);
            levelMessage.cleanup();

            // Cập nhật thông tin nhân vật
            Service.send_char_main_in4(this);
            MapService.update_in4_2_other_inside(map, this);

            // Nếu người chơi ở trong nhóm, gửi cập nhật cho nhóm
            if (party != null) {
                party.sendin4();
            }
        }
    }

    public void bienroombi(short transformationId) {

        // // Duyệt qua danh sách các phần trong Part_fashion để tìm phần ứng với ID mong muốn
        // for (Part_fashion part : Part_fashion.entrys) {
        // if (part.id == transformationId) {
        // this.fashion = part.part; // Cập nhật ngoại hình của người chơi
        // try {
        // // Phát tín hiệu cập nhật ngoại hình cho các người chơi khác
        // Service.send_char_main_in4(this);
        // MapService.update_in4_2_other_inside(this.map, this);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // // Lên lịch một nhiệm vụ để khôi phục lại ngoại hình ban đầu sau 10 giây (10.000 mili giây)
        // Timer timer = new Timer();
        // timer.schedule(new TimerTask() {
        // @Override
        // public void run() {
        // // Khôi phục ngoại hình về part ban đầu
        // for (Part_fashion part : Part_fashion.entrys) {
        // if (part.id == p.item.wear[11].id) {
        // fashion = part.part;
        // break;
        // }
        // }
        // try {
        // // Gửi tín hiệu cập nhật ngoại hình để thông báo cho các người chơi khác
        // Service.send_char_main_in4(Player.this);
        // MapService.update_in4_2_other_inside(map, Player.this);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // }
        // }, 10000); // Thời gian delay là 10 giây
        // break;
        // }
        // }
    }

    public void qua_ngay(Player p) throws IOException {
        List<Short> IDs = new ArrayList<>();
        List<Integer> Quants = new ArrayList<>();
        List<Short> Types = new ArrayList<>();
        int ngoc_up = Util.ngaunhien(2500, 5000);

        // Danh sách các item có thể nhận được (using int values)
        List<Integer> possibleItems = new ArrayList<>(Arrays.asList(52, 135, 62, 63, 64, 65, 61, 124, 222, 246, 269, 271, 275, 279, 294, 299, 323));

        // Xáo trộn danh sách using Util.random
        List<Integer> shuffledItems = new ArrayList<>();
        for (int i = 0; i < possibleItems.size(); i++) {
            shuffledItems.add(Util.random(possibleItems, shuffledItems));
        }

        // Lấy 3 item đầu tiên
        List<Integer> receivedItems = shuffledItems.subList(0, 3);

        // Thêm các item vào danh sách quà
        for (int id : receivedItems) {
            IDs.add((short) id);
            Quants.add(Util.ngaunhien(1, 10));
            Types.add((short) 4);
            p.item.add_item_bag47((short) id, (short) 1, (byte) 4);
        }

        if (ngoc_up != 0) {
            IDs.add((short) -2);
            Quants.add((int) (ngoc_up > 2_000_000_000 ? 2_000_000_000 : ngoc_up));
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
        if (conn.vip >= 9) {
            // int vang_ =50000;
            int tiennap = 50000;
            int coin = 50000;
            Service.Show_open_box_notice_item(p, "Vip 9 Nhận được 50k nap + coin", ar_id, ar_quant, ar_type);
            p.update_tiennap(tiennap);
            p.update_coin(coin);
        } else {
            Service.Show_open_box_notice_item(p, "Nhận được", ar_id, ar_quant, ar_type);
        }
        p.diem_danh[3] = 1;
        p.update_ngoc(ngoc_up);

        p.item.char_inventory(3);
        p.item.char_inventory(4);
        p.item.char_inventory(7);

    }

//  void x4_exp() throws IOException {
//   }
    
  
    
}
