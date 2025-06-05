package map;

import BossHDL.BossManager;
import ai.LoanDau;
import ai.Nbxx;
import ai.khu2;
import client.Party;
import java.util.ArrayList;
import java.util.List;
import client.Player;
import core.Manager;
import core.Service;
import core.Util;
import event_daily.ChiemThanhManager;
import event_daily.ChienTruong;
import event_daily.DailyQuest;
import io.Message;
import io.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import static map.LeaveItemMap.leave_item_by_type7;
import template.MainObject;
import template.Mob;
import template.Part_player;
import template.TaskTemplate;

public class Mob_in_map extends MainObject {

    public final static HashMap<Integer, Mob_in_map> ENTRYS = new HashMap<>();
    public int time_refresh = 3;
    private boolean is_boss;
    public long time_back;
    public final List<Player> list_fight = new ArrayList<>();
    public long time_fight;
    public boolean is_boss_active;
    public int timeBossRecive = 1000 * 60 * 60 * 8;
    public final HashMap<String, Long> top_dame = new HashMap<>();
    private long delay_chat;
    public List<Part_player> part_p;
    public int nedon;
    public int deff;
    public int phandame;
    public int damebase;
    public int chimang;
    public int xuyengiap;
    public int callerPlayerId;
    public int callerId;
    public String callerName;
    // Lưu Máp
    public int bossMapId;
    public int bossZoneId;
    public int bossX;
    public int bossY;
    // case 53
    public boolean isCase53Boss;
    public boolean isBoss_124;
    public boolean isExpAdded = false;

    public void Reset() {
        hp = get_HpMax();
        isdie = false;
        synchronized (list_fight) {
            list_fight.clear();
        }
        synchronized (top_dame) {
            top_dame.clear();
        }
        isExpAdded = false;
    }
    // đánh dấu boss 
    private boolean isSpecialBoss;

    public void setSpecialBoss(boolean isSpecialBoss) {
        this.isSpecialBoss = isSpecialBoss;
    }

    public boolean isSpecialBoss() {
        return isSpecialBoss;
    }

    public void Set_isBoss(boolean isBoss) {
        is_boss = isBoss;
    }

    @Override
    public boolean isBoss() {
        return is_boss;
    }

    @Override
    public boolean isMobCTruongHouse() {
        return template.mob_id >= 89 && template.mob_id <= 92;
    }

    @Override
    public boolean isMob() {
        return true;
    }

    @Override
    public int get_DameBase() {
        if (dame <= 0) {
            dame = level * 75;
        }

        int dmo = Util.random((int) (this.dame * 0.95), (int) (this.dame * 1.05));
        if (this.level > 30 && this.level <= 50) {
            dmo = (dmo * 13) / 10;
        } else if (this.level > 50 && this.level <= 70) {
            dmo = (dmo * 16) / 10;
        } else if (this.level > 70 && this.level <= 100) {
            dmo = (dmo * 19) / 10;
        } else if (this.level > 100 && this.level <= 600) {
            dmo = (dmo * 21) / 10;
        }

        if (this.is_boss) {
            if (this.isSpecialBoss()) {
                return this.damebase;  // Xử lý boss đặc biệt
            } else {
                dmo = (int) (dmo * this.level * 0.03);  // Boss thông thường
            }
        }

        if (this.color_name != 0 && (this.template.mob_id < 89 || this.template.mob_id > 92)) {
            dmo *= 2;
        }

        return dmo;
    }

    // @Override
    //public int get_Miss() {
    // return 800;
    // }
    // @Override
    // public int get_DameBase() {
    // return this.damebase;
    // }
    @Override
    public int get_Miss() {//xuyên giáp
        return this.nedon;
    }

    @Override
    public int get_DefBase() {//xuyên giáp
        return this.def;
    }

    @Override
    public int get_PhanDame() {
        return this.phandame;
    }

    @Override
    public int get_Crit() {
        return this.chimang;
    }

    @Override
    public int get_Pierce() {//xuyên giáp
        return this.xuyengiap;
    }

    @Override
    public int get_DameProp(int type) {
        return this.damebase;
    }

@Override
public void SetDie(Map map, MainObject mainAtk) throws IOException {
    hp = 0;
    isdie = true;

    Mob_in_map mob = (Mob_in_map) this;

    // Kiểm tra kiểu đối tượng của mainAtk
    if (mainAtk instanceof Player) {
        Player p = (Player) mainAtk;

        if (p.hieuchien > 0 && Math.abs(mainAtk.level - mob.level) <= 5) {
            p.hieuchien--;
        }
        if (mob.template.mob_id == 152) {
            ChiemThanhManager.SetOwner(p);
        }

        p.checkTask(this.template.mob_id, (byte) 1);
        p.checkQuestAndDropItem(map, mob, p); // Rơi item5

        if (mob.isBoss()) {
            map.BossDie(mob);
            String p_name = "";
            long top_dame = 0;
            for (java.util.Map.Entry<String, Long> en : mob.top_dame.entrySet()) {
                if (en.getValue() > top_dame) {
                    top_dame = en.getValue();
                    p_name = en.getKey();
                }
            }
            mob.is_boss_active = false;
            if (!Map.is_map_cant_save_site(mob.map_id)) {
                Manager.gI().chatKTGprocess(mainAtk.name + " Đã Tiêu Diệt " + mob.template.name);
                Manager.gI().chatKTGprocess(top_dame + " Đã Nhận Quà 1 Top Sát Thương Đánh " + mob.template.name);
                Manager.gI().chatKTGprocess(mainAtk.name + " Chạy Xin Boss Nhé Mấy Cưng !!!");
            }

            if (mob.template.mob_id == 174) {
                BossManager.DropItemBossEvent(map, mob, p);
            } else {
                LeaveItemMap.leave_item_boss(map, mob, p);
            }

            if (mob.isCase53Boss) {
                distributeRewards(mob);
            }

            if (mob.isBoss_124) {
                LoanDau.leave_item3_124(map, mob, p);
            }
        }
        
if (p.quest_daily[0] == this.template.mob_id) {  
    p.quest_daily[2]++;  // Tăng số lượng quái vật đã tiêu diệt
    
    // Kiểm tra xem nhiệm vụ đã hoàn thành chưa
    if (p.quest_daily[2] >= p.quest_daily[3]) {  
        // Nếu nhiệm vụ đã hoàn thành, thông báo hoàn thành
        Service.send_notice_nobox_white(p.conn, "Nhiệm vụ hoàn thành!");
        
        // Nếu nhiệm vụ đã hoàn thành, vẫn tiếp tục hiển thị thông báo cho người chơi nếu tiếp tục đánh quái
        if (p.quest_daily[2] == p.quest_daily[3]) {
            Service.send_notice_nobox_white(p.conn, "Nhiệm vụ đã hoàn thành!");
        }
        
       // DailyQuest.finish_quest(p);  
    } else {  
        // Nếu chưa hoàn thành, thông báo tiến độ
        Service.send_notice_nobox_white(p.conn, String.format("Tiến độ: %d/%d ", p.quest_daily[2], p.quest_daily[3]));  
    }  
}

        // Xử lý nhiệm vụ tinh tú
        if (mob.template.mob_id == 23 || mob.template.mob_id == 17) {
            if (p.nv_tinh_tu[0] == 7 && p.nv_tinh_tu[1] < p.nv_tinh_tu[2]) {
                p.nv_tinh_tu[1]++;
            }
            if (p.nv_tinh_tu[0] == 8 && p.nv_tinh_tu[1] < p.nv_tinh_tu[2]) {
                p.nv_tinh_tu[1]++;
            }
        }
        if (Math.abs(mob.level - p.level) <= 5 && !p.isSquire) {
            if (p.nv_tinh_tu[0] == 16 && p.nv_tinh_tu[1] < p.nv_tinh_tu[2]) {
                p.nv_tinh_tu[1]++;
                Service.send_notice_nobox_white(p.conn, "Tiến Độ " + p.nv_tinh_tu[1] + "/" + p.nv_tinh_tu[2]);
            }
        }
    } else if (mainAtk instanceof Nbxx) {
        Nbxx nb = (Nbxx) mainAtk;

    }

    boolean check_mob_roi_ngoc_kham = mob.template.mob_id >= 167 && mob.template.mob_id <= 172;
    boolean check_mob_roi_dan = map.map_id == 118;
    boolean check_item_khu2 = map.zone_id == 1;
    boolean check_tientai = map.map_id == 117;

    if (mainAtk instanceof Player) {
        Player p = (Player) mainAtk;

        if (Math.abs(mob.level - mainAtk.level) <= 10 && !check_mob_roi_ngoc_kham && !check_mob_roi_dan && !check_tientai) {
            if (Math.abs(mob.level - mainAtk.level) <= 5 && Manager.gI().event == 3 && Util.random_ratio(10)) {
                ev_he.Event_3.LeaveItemMap(map, this, mainAtk);
            } else if (mob.level >= 133) {
                ev_he.Event_3.LeaveItemMap(map, this, mainAtk);
            }

            if (15 > Util.random(0, 300) || mob.color_name != 0) {
                LeaveItemMap.leave_item_3(map, mob, p);
            }
            if (20 > Util.random(0, 300)) {
                LeaveItemMap.leave_item_4(map, mob, p);
            }
            if (20 > Util.random(0, 300)) {
                LeaveItemMap.leave_item_7(map, mob, p);
            }
            if (30 > Util.random(0, 300)) {
                LeaveItemMap.leave_vang(map, mob, p);
            }
            //
            int Tyle = 30;
            if (p.conn.vip >= 6) {
            Tyle += 10;
            }
            if (Tyle > Util.random(0, 300)) {
            LeaveItemMap.leave_material(map, mob, p);
            }
            //
            if (Manager.gI().event != 0 && 30 > Util.random(0, 100) && Math.abs(mob.level - mainAtk.level) <= 5) {
                LeaveItemMap.leave_item_event(map, mob, p);
            }
        }

        if (check_mob_roi_ngoc_kham) {
            LeaveItemMap.leave_material_ngockham(map, mob, p);
        }

        if (check_item_khu2) {
            khu2.leave_item4_khu2(map, mob, p);
            khu2.leave_item3_khu2(map, mob, p);
            khu2.leave_item7_khu2(map, mob, p);
        }

        if (check_mob_roi_dan) {
            LeaveItemMap.leave_dan(map, mob, p);
        }

        if (check_tientai) {
            LeaveItemMap.leave_tientai(map, mob, p);
        }

        if (mob.color_name != 0) {
            map.num_mob_super--;
        }
    }
}

    @Override
    public void update(Map map) {
        try {
            if (this.isdie && this.ishs && this.time_back < System.currentTimeMillis()) {
                this.isdie = false;
                this.Reset();
                this.hp = this.get_HpMax();
                if (this.isBoss()) {
                    this.color_name = 3;
                } else if (5 > Util.random(200) && map.num_mob_super < 2 && this.level > 50) {
                    this.color_name = (new byte[]{1, 2, 4, 5})[Util.random(4)];
                    map.num_mob_super++;
                } else {
                    this.color_name = 0;
                }
                for (int j = 0; j < map.players.size(); j++) {
                    Player pp = map.players.get(j);
                    if ((Math.abs(pp.x - this.x) < 200) && (Math.abs(pp.y - this.y) < 200)) {
                        if (!pp.other_mob_inside.containsKey(this.index)) {
                            pp.other_mob_inside.put(this.index, true);
                        }
                        if (pp.other_mob_inside.get(this.index)) {
                            Message mm = new Message(4);
                            mm.writer().writeByte(1);
                            mm.writer().writeShort(this.template.mob_id);
                            mm.writer().writeShort(this.index);
                            mm.writer().writeShort(this.x);
                            mm.writer().writeShort(this.y);
                            mm.writer().writeByte(-1);
                            pp.conn.addmsg(mm);
                            mm.cleanup();
                            pp.other_mob_inside.replace(this.index, true, false);
                        } else {
                            Service.mob_in4(pp, this.index);
                        }
                    }
                }
            } else if (!this.isdie && this.isATK && this.time_fight < System.currentTimeMillis()) {
                if ((this.template.mob_id == 151 || this.template.mob_id == 152 || this.template.mob_id == 154)) {
                    for (Player p0 : this.list_fight) {
                        if (p0 != null && !p0.isdie && p0.map.map_id == this.map_id && p0.map.zone_id == this.zone_id
                                && Math.abs(this.x - p0.x) < 200 && Math.abs(this.y - p0.y) < 200) {
                            MainObject.MainAttack(map, this, p0, 0, null, 2);
                        }
//                                MapService.mob_fire(this, mob, p0);
                    }
                    this.time_fight = System.currentTimeMillis() + 3500L;
                } else if (this.list_fight.size() > 0) {
                    Player p0 = this.list_fight.get(Util.random(this.list_fight.size()));
                    if (p0 != null && !p0.isdie && p0.map.map_id == this.map_id && p0.map.zone_id == this.zone_id) {
                        if (Math.abs(this.x - p0.x) < 200 && Math.abs(this.y - p0.y) < 200) {
                            if (this.time_fight < System.currentTimeMillis()) {
                                this.time_fight = System.currentTimeMillis() + 1200L;
                                MainObject.MainAttack(map, this, p0, 0, null, 2);
//                                    MapService.mob_fire(this, mob, p0);
                            }
                        } else {
                            this.list_fight.remove(p0);
                            //
                            Message m = new Message(10);
                            m.writer().writeByte(0);
                            m.writer().writeShort(this.index);
                            MapService.send_msg_player_inside(map, p0, m, true);
                            m.cleanup();
                        }
                    }
                    if (p0.isdie) {
                        this.list_fight.remove(p0);
                        //
                        Message m = new Message(10);
                        m.writer().writeByte(0);
                        m.writer().writeShort(this.index);
                        MapService.send_msg_player_inside(map, p0, m, true);
                        m.cleanup();
                    }
                    if (this.list_fight.contains(p0) && !(p0.map.map_id == this.map_id && p0.map.zone_id == this.zone_id)) {
                        this.list_fight.remove(p0);
                    }
                }
            }

        } catch (Exception e) {
        }
    }

    private static void distributeRewards(Mob_in_map boss) throws IOException {
        int baseReward = 1000; // Phần thưởng cơ bản
        Set<String> rewardedIPs = new HashSet<>(); // Biến lưu trữ IP đã nhận thưởng

        // Kiểm tra nếu boss là từ case 53 và có người chơi gọi boss
        if (boss.isCase53Boss && boss.callerId != -1) {
            Player caller = Map.get_player_by_id(boss.callerId);
            if (caller != null && caller.party != null) {
                List<Player> partyMembers = caller.party.get_mems();
                List<Player> eligibleMembers = new ArrayList<>();

                // Lọc các thành viên đã gây dame lên boss
                for (Player member : partyMembers) {
                    if (boss.top_dame.containsKey(member.name)) {
                        eligibleMembers.add(member);
                    }
                }

                int totalReward = baseReward * eligibleMembers.size(); // thưởng Nhóm

                for (Player member : eligibleMembers) {
                    String memberIP = member.conn.ip; // Lấy IP của người chơi

                    // Kiểm tra nếu IP đã nhận thưởng
                    if (rewardedIPs.contains(memberIP)) {
                        Service.send_notice_box(member.conn, "IP của bạn đã nhận thưởng rồi!");
                    } else {
                        member.addReward(totalReward);
                        Service.send_notice_box(member.conn, "Bạn nhận được " + totalReward + " Ngọc vì đã tham gia đánh boss!");
                        member.item.char_inventory(5);

                        // Thêm IP vào danh sách đã nhận thưởng
                        rewardedIPs.add(memberIP);

                        Map map = member.map;
                        if (Util.random(100) < 100) { // 100% tỷ lệ rơi đồ
                            for (int i = 0; i < 5; i++) {
                                short randomItem7Id = (short) Util.ngaunhien(496, 500);
                                leave_item_by_type7(map, randomItem7Id, member, boss.index, member.index);
                            }
                        }
                    }
                }

                // Thông báo cho các thành viên không gây dame
                for (Player member : partyMembers) {
                    if (!eligibleMembers.contains(member)) {
                        Service.send_notice_box(member.conn, "Bạn không nhận được phần thưởng vì không gây dame lên boss.");
                    }
                }

                // Nếu không có thành viên đủ điều kiện, thưởng cơ bản cho người gọi nếu họ đã gây dame
                if (eligibleMembers.isEmpty() && boss.top_dame.containsKey(caller.name)) {
                    String callerIP = caller.conn.ip; // Lấy IP của người gọi

                    // Kiểm tra nếu IP đã nhận thưởng
                    if (rewardedIPs.contains(callerIP)) {
                        Service.send_notice_box(caller.conn, "IP của bạn đã nhận thưởng rồi!");
                    } else {
                        caller.addReward(baseReward);
                        Service.send_notice_box(caller.conn, "Nhận được " + baseReward + " Ngọc vì đã tham gia đánh boss!");
                        caller.item.char_inventory(5);

                        // Thêm IP vào danh sách đã nhận thưởng
                        rewardedIPs.add(callerIP);

                        Map map = caller.map;
                        if (Util.random(100) < 100) { // 100% tỷ lệ rơi đồ
                            for (int i = 0; i < 5; i++) {
                                short randomItem7Id = (short) Util.ngaunhien(496, 500);
                                leave_item_by_type7(map, randomItem7Id, caller, boss.index, caller.index);
                            }
                        }
                    }
                }
            } else {
                // Nếu không có tổ đội, thưởng trực tiếp cho người gọi nếu người gọi gây dame
                if (boss.top_dame.containsKey(caller.name)) {
                    String callerIP = caller.conn.ip; // Lấy IP của người gọi

                    // Kiểm tra nếu IP đã nhận thưởng
                    if (rewardedIPs.contains(callerIP)) {
                        Service.send_notice_box(caller.conn, "IP của bạn đã nhận thưởng rồi!");
                    } else {
                        caller.addReward(baseReward);
                        Service.send_notice_box(caller.conn, "Nhận được " + baseReward + " Ngọc vì đã tham gia đánh boss!");
                        caller.item.char_inventory(5);

                        // Thêm IP vào danh sách đã nhận thưởng
                        rewardedIPs.add(callerIP);

                        Map map = caller.map;
                        if (Util.random(100) < 100) { // 100% tỷ lệ rơi đồ
                            for (int i = 0; i < 5; i++) {
                                short randomItem7Id = (short) Util.ngaunhien(496, 500);
                                leave_item_by_type7(map, randomItem7Id, caller, boss.index, caller.index);
                            }
                        }
                    }
                } else {
                    Service.send_notice_box(caller.conn, "Bạn không nhận được phần thưởng vì không gây dame lên boss.");
                }
            }
        } else {
            // Xử lý các logic phân phối phần thưởng khác nếu cần
        }
    }

}
