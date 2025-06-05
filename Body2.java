package client;

import LeothapWeek.Leothap;
import LeothapWeek.LeothapManager;
import ai.Fusion;
import ai.LoanDau;
import ai.PlayerPoints;
import ai.ThachDau;
import core.Manager;
import core.Service;
import core.Util;
import event_daily.ChiemThanhManager;
import io.Message;
import io.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import map.Eff_special_skill;
import map.Map;
import map.MapService;
import map.Mob_in_map;
import template.EffTemplate;
import template.Eff_TextFire;
import template.Item3;
import template.Kham_template;
import template.LvSkill;
import template.MainObject;
import template.Option;
import template.Option_pet;
import template.Part_fashion;
import template.StrucEff;

public class Body2 extends MainObject {

    Player p;
    private Fusion fusion;

    public Body2() {
        this.fusion = new Fusion(); // Khởi tạo đối tượng Fusion
    }

    protected void SetPlayer(Player p) {
        if (this.p != null) {
            return;
        }
        this.p = p;
        kham = new Kham_template();
        MainEff = new ArrayList<>();
        Eff_me_kham = new ArrayList<>();
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    private int get_point(int i) {
        long point = 0;

        switch (i) {
            case 1: {
                point += p.point1 + get_plus_point(23);

                break;
            }
            case 2: {
                point += p.point2 + get_plus_point(24);

                break;
            }
            case 3: {
                point += p.point3 + get_plus_point(25);

                break; 
            }
            case 4: {
                point += p.point4 + get_plus_point(26);

                break;
            }
        }

        // Giới hạn giá trị điểm tối đa
        if (point > 2_000_000_000) {
            point = 2_000_000_000;
        }

        return (int) point;
    }

    public int get_plus_point(int i) {
        long param = 0;
        switch (i) {
            case 23: {
                param += total_item_param(i);
                EffTemplate ef = p.get_EffDefault(23);
                if (ef != null) {
                    param += (p.point1 * (ef.param / 100)) / 100;
                }
                for (Pet temp : p.mypet) {
                    if (temp.is_follow) {
                        for (Option_pet op : temp.op) {
                            if (op.id == 23) {
                                param += op.param;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case 24: {
                param += total_item_param(i);
                for (Pet temp : p.mypet) {
                    if (temp.is_follow) {
                        for (Option_pet op : temp.op) {
                            if (op.id == 24) {
                                param += op.param;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case 25: {
                param += total_item_param(i);
                for (Pet temp : p.mypet) {
                    if (temp.is_follow) {
                        for (Option_pet op : temp.op) {
                            if (op.id == 25) {
                                param += op.param;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case 26: {
                param += total_item_param(i);
                for (Pet temp : p.mypet) {
                    if (temp.is_follow) {
                        for (Option_pet op : temp.op) {
                            if (op.id == 26) {
                                param += op.param;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return (int) param;
    }

    @Override
    public int total_item_param(int id) {
        long param = 0;
        // cấm id
        if (map124() && (id == 29 || id == 87 || id == 88)) {
            return 0;
        }
        for (int i = 0; i < p.item.wear.length; i++) {
            Item3 temp = p.item.wear[i];
            if (temp != null) {
                // if (p.level < temp.level) {
                // continue;
                // }
                for (Option op : temp.op) {
                    if (op.id == id) {
                        param += op.getParam(temp.tier);
                        param += op.getParam(temp.tierStar);
                    }
                }
            }
        }
        if (param > 2_000_000_000) {
            param = 2_000_000_000;
        }
        return (int) param;
    }

    @Override
    public int get_HpMax() {
        long hpm = (int) (2500 * Manager.ratio_hp);
        switch (p.clazz) {
            case 0: {
                hpm += (550 + get_point(3) * 320);
                break;
            }
            case 1: {
                hpm += (get_point(3) * 300);
                break;
            }
            case 2: {
                hpm += (50 + get_point(3) * 310);
                break;
            }
            case 3: {
                hpm += (120 + get_point(3) * 300);
                break;
            }
        }
        hpm += (p.get_luyenthe() * 20);
        //Hợp Thể + hp
        hpm += hpm * p.point_lden;
        if (fusion.isFusion(p) == true && p.squire != null) {
            hpm += (p.squire.body.get_HpMax() * 1)/10;
        }

        int percent = total_item_param(27);
        if (p.skill_point[9] > 0) {
            for (Option op : p.skills[9].mLvSkill[p.skill_point[9] - 1].minfo) {
                if (op.id == 27) {
                    percent += op.getParam(0);
                    break;
                }
            }
        }
        percent += ((p.kinhmach - 1) * 5 + p.kinhmach) * 100;
        hpm += ((hpm * (percent / 100)) / 100);
        if (p.type_use_mount == 11 || p.type_use_mount == 12 || p.type_use_mount == 13
                || (p.type_use_mount == 20 && (p.id_horse == 114 || p.id_horse == 121))) {
            hpm += (hpm / 10);
        }
        EffTemplate ef = p.get_EffDefault(2);
        if (ef != null) {
            hpm = (hpm * 8) / 10;
        }

        if (hpm > 2_000_000_000) {
            hpm = 2_000_000_000;
        }

        if (map124()) {
            hpm = (long) (9 - Manager.ratio_hp);
        } else if (p.ismap124) {
            p.hp = (int) (hpm * Manager.ratio_hp);
            p.typepk = -1;
            p.isdie = false;
            p.ismap124 = false;
        }

        return (int) (hpm * Manager.ratio_hp);
    }

    @Override
    public int get_MpMax() {
        long mpm = 250;
        switch (p.clazz) {
            case 0:
            case 1: {
                mpm += get_point(4) * 10;
                break;
            }
            case 2: {
                mpm += 10 + get_point(3) + get_point(4) * 11;
                break;
            }
            case 3: {
                mpm += 5 + get_point(3) + get_point(4) * 11;
                break;
            }
        }
        //Hợp Thể + mp
        if (fusion.isFusion(p) == true && p.squire != null) {
            mpm += (p.squire.body.get_MpMax() * 1)/10;
        }
        mpm += mpm * p.point_lden;
        int percent = total_item_param(28);
        if (p.skill_point[10] > 0) {
            for (Option op : p.skills[10].mLvSkill[p.skill_point[10] - 1].minfo) {
                if (op.id == 28) {
                    percent += op.getParam(0);
                    break;
                }
            }
        }
        mpm += ((mpm * (percent / 100)) / 100);
        EffTemplate ef = p.get_EffDefault(2);
        if (ef != null) {
            mpm = (mpm * 8) / 10;
        }
        if (mpm > 2_000_000_000) {
            mpm = 2_000_000_000;
        }
        return (int) mpm;
    }

    @Override
    public int total_skill_param(int id) {
        long param = 0;
        for (int i = 0; i < p.skill_point.length; i++) {
            if (p.skill_point[i] > 0) {
                Option[] temp = p.skills[i].mLvSkill[get_skill_point(i) - 1].minfo;
                for (Option op : temp) {
                    if (op.id == id) {
                        param += op.getParam(0);
                    }
                }
            }
        }
        return (int) param;
    }

    @Override
    public int get_Pierce() { // xuyên giáp 
        long pie = total_item_param(36) + total_skill_param(36);
        pie += get_point(4) * 2;
        EffTemplate ef = get_EffDefault(36);
        if (ef != null) {
            pie += ef.param;
        }
        int tile_pie = (int) (pie / 2.1);
        if (tile_pie > 15000) {
            tile_pie = 15000;
        }
        //Hợp Thể + xg
        if (fusion.isFusion(p) == true && p.squire != null) {
            pie += (p.squire.body.get_Pierce() * 1)/10;
        }
        return tile_pie;
    }

    @Override
    public int get_PhanDame() {
        long param = 2 * get_point(3);
        param += total_item_param(35);
        EffTemplate ef = get_EffDefault(35);
        if (ef != null) {
            param += ef.param;
        }
        int tile_phan = (int) (param / 2.1);
        if (tile_phan > 10000) {
            tile_phan = 10000;
        }
        //Hợp Thể + phan
        if (fusion.isFusion(p) == true && p.squire != null) {
            param += (p.squire.body.get_PhanDame() * 1)/10;
        }
        return tile_phan;
    }

    @Override
    public int get_Miss() { // né
        long param = 2 * get_point(2);
        param += total_item_param(34);
        EffTemplate ef = get_EffDefault(34);
        if (ef != null) {
            param += ef.param;
        }
        if (fusion.isFusion(p) == true && p.squire != null) {
            param += (p.squire.body.get_Miss() * 1)/10;
        }
        int tile_ne = (int) (param / 1.8);
        if (tile_ne > 7000) {
            tile_ne = 7000;
        }
        return tile_ne;
    }

    @Override
    public int get_Crit() { // chí mạng
        long crit = total_item_param(33) + total_skill_param(33);
        crit += get_point(1) * 2;
        EffTemplate ef = get_EffDefault(33);
        if (ef != null) {
            crit += ef.param;
        }
        int tile_crit = (int) (crit / 2.1);
        if (tile_crit > 15000) {
            tile_crit = 15000;
        }
        //Hợp Thể + cm
        if (fusion.isFusion(p) == true && p.squire != null) {
            crit += (p.squire.body.get_Crit() * 1)/10;
        }
        return tile_crit;
    }

    public int get_skill_point(int i) {
        if (p.skill_point[i] > 0) {
            int par_ = p.skill_point[i] + get_skill_point_plus(i);
            return (par_ > 15 ? 15 : par_);
        }
        return 0;
    }

    @Override
    public int get_PercentDefBase() { // Deff %
        long def = total_item_param(15);
        def += get_point(2) * 10;
        if (get_skill_point(15) > 0) {
            for (Option op : p.skills[15].mLvSkill[get_skill_point(15) - 1].minfo) {
                if (op.id == 15) {
                    def += op.getParam(0);
                    break;
                }
            }
        }
        //Hợp Thể + deff
        if (fusion.isFusion(p) == true && p.squire != null) {
            def += (p.squire.body.get_PercentDefBase() * 1)/10;
        }
        EffTemplate ef = p.get_EffDefault(24);
        if (ef != null) {
            def += ef.param;
        }

        if (def > 2_000_000_000) {
            def = 2_000_000_000;
        }
        return (int) def;
    }

    @Override
    public int get_DefBase() {// deff chỉ số
        long def = total_item_param(14);
        switch (p.clazz) {
            case 0: {
                def += get_point(2) * 20;
                break;
            }
            case 1: {
                def += get_point(2) * 22;
                break;
            }
            case 2: {
                def += get_point(2) * 20;
                break;
            }
            case 3: {
                def += get_point(2) * 22;
                break;
            }
        }
//Hợp Thể + deff
        if (fusion.isFusion(p) == true && p.squire != null) {
            def += (p.squire.body.get_DefBase() * 1)/10;
        }
        def += ((def * (get_PercentDefBase() / 100)) / 100);

        if (def > 2_000_000_000) {
            def = 2_000_000_000;
        }

        if (p.type_use_mount == 2 || (p.type_use_mount == 15 && p.id_horse == 106)) {
            def += ((def * 2) / 10);
        } else if (p.type_use_mount == 3 || p.type_use_mount == 5 || (p.type_use_mount == 17 && p.id_horse == 111)
                || (p.type_use_mount == 20 && p.id_horse == 115)) {
            def += ((def * 1) / 10);
        } else if ((p.type_use_mount == 22 && p.id_horse == 117)
                || (p.type_use_mount == 20 && (p.id_horse == 114 || p.id_horse == 116))) {
            def += ((def * 15) / 100);
        }
        EffTemplate ef = p.get_EffDefault(0);
        if (ef != null) {
            def = (def * 8) / 10;
        }
        ef = p.get_EffDefault(15);
        if (ef != null) {
            def += (def * (ef.param / 100)) / 100;
        }
        return (int) (def * 0.8);
    }

    @Override
    public int get_PercentDameProp(int type) {
        if (type == 0) {
            long percent = total_item_param(7);
            switch (p.clazz) {
                case 0:
                case 1: {
                    percent += get_point(1) * 20;
                    break;
                }
                case 2:
                case 3: {
                    percent += get_point(1) * 20 + get_point(4) * 18;
                    break;
                }
            }
            if (get_skill_point(11) > 0) {
                for (Option op : p.skills[11].mLvSkill[get_skill_point(11) - 1].minfo) {
                    if (op.id == 7) {
                        percent += op.getParam(0);
                        break;
                    }
                }
            }
            EffTemplate eff = get_EffDefault(StrucEff.BuffSTVL);
            if (eff != null) {
                percent += eff.param;
            }
            return (int) percent;
        }
        int perct = 0;
        switch (p.clazz) {
            case 0: {
                if (type == 9 || type == 2) {
                    perct += get_point(1) * 20;
                    perct += total_item_param(9);
                    if (get_skill_point(12) > 0) {
                        for (Option op : p.skills[12].mLvSkill[get_skill_point(12) - 1].minfo) {
                            if (op.id == 9) {
                                perct += op.getParam(0);
                                break;
                            }
                        }
                    }
                }
                EffTemplate eff = get_EffDefault(StrucEff.BuffSTLua);
                if (eff != null) {
                    perct += eff.param;
                }
                break;
            }
            case 1: {
                if (type == 11 || type == 4) {
                    perct += get_point(1) * 20;
                    perct += total_item_param(11);
                    if (get_skill_point(12) > 0) {
                        for (Option op : p.skills[12].mLvSkill[get_skill_point(12) - 1].minfo) {
                            if (op.id == 11) {
                                perct += op.getParam(0);
                                break;
                            }
                        }
                    }
                }
                EffTemplate eff = get_EffDefault(StrucEff.BuffSTDoc);
                if (eff != null) {
                    perct += eff.param;
                }
                break;
            }
            case 2: {
                if (type == 8 || type == 1) {
                    perct += get_point(1) * 20 + get_point(4) * 18;
                    perct += total_item_param(8);
                    if (get_skill_point(12) > 0) {
                        for (Option op : p.skills[12].mLvSkill[get_skill_point(12) - 1].minfo) {
                            if (op.id == 8) {
                                perct += op.getParam(0);
                                break;
                            }
                        }
                    }
                }
                EffTemplate eff = get_EffDefault(StrucEff.BuffSTBang);
                if (eff != null) {
                    perct += eff.param;
                }
                break;
            }
            case 3: {
                if (type == 10 || type == 3) {
                    perct += get_point(1) * 20 + get_point(4) * 18;
                    perct += total_item_param(10);
                    if (get_skill_point(12) > 0) {
                        for (Option op : p.skills[12].mLvSkill[get_skill_point(12) - 1].minfo) {
                            if (op.id == 10) {
                                perct += op.getParam(0);
                                break;
                            }
                        }
                    }
                }
                EffTemplate eff = get_EffDefault(StrucEff.BuffSTDien);
                if (eff != null) {
                    perct += eff.param;
                }
                break;
            }
        }
        return perct;
    }

    @Override
    public int get_DameBase() {
       int dameBase = get_param_view_in4(40);       
        return dameBase ;
      
    }

    @Override
    public int get_DameProp(int type) {
        if (type == 0) {
            long dame = total_item_param(0);
            switch (p.clazz) {
                case 0: {
                    dame += get_point(1) * 4;
                    if (fusion.isFusion(p) == true && p.squire != null) {
                        dame += (p.squire.body.get_point(1) * 1)/10;
                    }
                    break;
                }
                case 1: {
                    dame += get_point(1) * 4;
                    if (fusion.isFusion(p) == true && p.squire != null) {
                        dame += (p.squire.body.get_point(1) * 1)/10;
                    }
                    break;
                }
                case 2: {
                    dame += get_point(4) * 4;
                    if (fusion.isFusion(p) == true && p.squire != null) {
                        dame += (p.squire.body.get_point(4) * 1)/10;
                    }
                    break;
                }
                case 3: {
                    dame += get_point(4) * 4;
                    if (fusion.isFusion(p) == true && p.squire != null) {
                        dame += (p.squire.body.get_point(4) * 1)/10;
                    }
                    break;
                }
            }
            if (fusion.isFusion(p) == true && p.squire != null) {
            dame += (p.squire.body.get_PercentDameProp(0) * 1 /10);
             }
            dame += ((dame * (get_PercentDameProp(0) / 100)) / 100);
     
            if (dame > 2_000_000_000) {
                dame = 2_000_000_000;
            }
            return (int) dame;
        }
        long dprop = 0;
        switch (p.clazz) {
            case 0: {
                if (type == 2) {
                    dprop += get_point(1) * 4;
                    dprop += total_item_param(2);
                }
                break;
            }
            case 1: {
                if (type == 4) {
                    dprop += get_point(1) * 4;
                    dprop += total_item_param(4);
                }
                break;
            }
            case 2: {
                if (type == 1) {
                    dprop += get_point(4) * 4;
                    dprop += total_item_param(1);
                }
                break;
            }
            case 3: {
                if (type == 3) {
                    dprop += get_point(4) * 4;
                    dprop += total_item_param(3);
                }
                break;
            }
        }
        //Hợp Thể + dame
        if (fusion.isFusion(p) == true && p.squire != null) {
            dprop +=(p.squire.body.get_DameProp(type) * 1)/10;
        }
        dprop += ((dprop * (get_PercentDameProp(type) / 100)) / 100);
        if (dprop > 2_000_000_000) {
            dprop = 2_000_000_000;
        }
        return (int) dprop;
    }

    public int get_skill_point_plus(int i) {
        long par = 0;
        if (i >= 1 && i <= 8 || i == 19 || i == 20 || i == 17) {
            par = total_item_param(37);
        }
        if ((i >= 9 && i <= 16) || i == 18) {
            par = total_item_param(38);
        }
        return (int) ((par > 5) ? 5 : par);
    }

    @Override
    public int get_PercentDefProp(int type) {
        long param = total_item_param(type) + total_skill_param(type);
        EffTemplate ef = p.get_EffDefault(4);
        if (ef != null) {
            param -= 1000;
        }
        if (param < 0) {
            param = 0;
        }
        return (int) param;
    }

    public int getDameAs() {
        return Math.max(0, total_item_param(6) / 100 * (100 + total_item_param(13) / 100));
    }

    public int getDameBt() {
        return Math.max(0, total_item_param(5) / 100 * (100 + total_item_param(12) / 100));
    }

    @Override
    public void SetDie(Map map, MainObject mainAtk) throws IOException {
        if (map.map_id == 87) {
            ChiemThanhManager.PlayerDie(p);
        }
        p.dame_affect_special_sk = 0;
        p.hp = 0;
        p.isdie = true;
        p.type_use_mount = -1;
        Player pATK = mainAtk.isPlayer() ? (Player) mainAtk : null;
        Service.send_char_main_in4(p);

        if (p.item.bag47 != null && p.hp <= 0 && p.item.total_item_by_id(4, 61) > 0) {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(new Runnable() {
                @Override
                public void run() {
                    try {
                        p.isdie = false;
                        p.hp = p.body.get_HpMax();
                        p.mp = p.body.get_MpMax();

                        p.item.remove(4, 61, 1);
                        p.item.char_inventory(4);
                        p.item.char_inventory(5);
                        Service.send_char_main_in4(p);
                        // chest in4
                        Service.send_combo(p.conn);
                        Service.usepotion(p, 0, p.body.get_HpMax());
                        Service.usepotion(p, 1, p.body.get_MpMax());
                        Service.send_notice_nobox_white(p.conn, "Bạn đã dùng vé hồi sinh");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, 5, TimeUnit.SECONDS);
        } else {
        }

        if (pATK != null) {
            if (map.map_id == 124) {
                // Thêm điểm
                int currentPoints = PlayerPoints.loadPlayerPointsFromFile(pATK);
                int newPoints = currentPoints + 1;
                PlayerPoints.savePlayerPointsToFile(pATK, newPoints, false);  // L?u ?i?m vào file t?m th?i

                System.out.println("Player " + pATK.name + " +1 point, total: " + newPoints);

            } else { // Nếu không ở map 124
                if (pATK.typepk == 0) {
                    pATK.hieuchien++;
                }
                if (map.zone_id == map.maxzone && pATK.item.wear[11].id == 3596) {
                    pATK.hieuchien++;
                }
            }
        }

        //pATK.hieuchien++;
        //MapService.SendChat(map, pATK, "Chết đi em iu", true);
        /* if (p.isLiveSquire) {
            Squire.squireLeaveMap(p);
            p.isLiveSquire = false;
        }*/
        if (pATK != null) {
            if (pATK.list_enemies.contains(this.name)) {
                pATK.list_enemies.remove(this.name);
                MapService.SendChat(map, pATK, "Này Thì Cắn :v", true);
            } else if (p.typepk == -1) {
                if (!p.list_enemies.contains(pATK.name)) {
                    p.list_enemies.add(pATK.name);
                    if (p.list_enemies.size() > 20) {
                        p.list_enemies.remove(0);
                    }
                }
                MapService.SendChat(map, p, "Thằng ranh con này tí bố online bố sút cho không trượt phát nào ><", true);
            }
        }

        //
        //
    }

    @Override
    public int get_TypeObj() {
        return 0;
    }

    @Override
    public void update(Map map) {
        try {
            if (isdie) {
                return;
            }

            //<editor-fold defaultstate="collapsed" desc="auto +hp,mp       ...">  
            int percent = p.body.total_skill_param(29) + p.body.total_item_param(29);
            if (p.time_buff_hp < System.currentTimeMillis()) {
                p.time_buff_hp = System.currentTimeMillis() + 5000L;
                if (percent > 0 && p.hp < p.body.get_HpMax()) {
                    long param = (((long) p.body.get_HpMax()) * (percent / 100)) / 100;
                    Service.usepotion(p, 0, param);
                }
            }
            percent = p.body.total_skill_param(30) + p.body.total_item_param(30);
            if (p.time_buff_mp < System.currentTimeMillis()) {
                p.time_buff_mp = System.currentTimeMillis() + 5000L;
                if (percent > 0 && p.mp < p.body.get_MpMax()) {
                    long param = (((long) p.body.get_MpMax()) * (percent / 100)) / 100;
                    Service.usepotion(p, 1, param);
                }
            }
            //</editor-fold>    auto +hp,mp

            //<editor-fold defaultstate="collapsed" desc="eff Player       ...">  
            long _time = System.currentTimeMillis();
            if (get_EffMe_Kham(StrucEff.BongLua) != null && !p.isdie) {
                Service.usepotion(p, 0, (int) -(p.hp * Util.random(5, 10) * 0.01));
                if (p.hp <= 0) {
                    p.hp = 1;
                }
            }
            if (get_EffMe_Kham(StrucEff.BongLanh) != null) {
                Service.usepotion(p, 1, (int) -(p.mp * Util.random(5, 10) * 0.01));
            }
            if (p.hp <= 0 && !p.isdie) {
                p.hp = 0;
                p.isdie = true;
            }

            // Tách hợp thể đệ
            Session conn = p.conn;
            EffTemplate time = get_EffDefault(-127);
            //
            boolean[] status = Fusion.getFusionStatus(conn.p);
            boolean isFusion = status[0];
            boolean anmess = status[1];
            boolean isCase = status[2];

            // Tải trạng thái hợp thể 
            if (!fusion.isFusion(p)) {
                Fusion.loadFusionStatusFromSQL(p);
            }

            if (time == null && isFusion && !isCase) {
                if (!anmess) {
                    // Triệu hồi đệ và lưu trạng thái hợp thể
                    // Squire.callSquire(conn);
                    fusion.saveFusionStatus(conn.p, false, true, null);
                    conn.p.add_EffDefault(-128, 1000, (1000 * 60 * 5)); // Thời gian chờ 5 phút
                    conn.p.fashion = Part_fashion.get_part(conn.p);
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                    MapService.update_in4_2_other_inside(conn.p.map, conn.p);

                    Message m2 = new Message(-49);
                    m2.writer().writeByte(2); // loại hiệu ứng
                    m2.writer().writeShort(0);
                    m2.writer().writeByte(0);
                    m2.writer().writeByte(0);
                    m2.writer().writeByte(44); // Mã hiệu ứng hợp thể
                    m2.writer().writeShort(conn.p.index);
                    m2.writer().writeByte(0);
                    m2.writer().writeByte(0);
                    m2.writer().writeInt(500);

                    MapService.send_msg_player_inside(conn.p.map, conn.p, m2, true);
                    m2.cleanup();
                }
            }

            //
            if (!(p instanceof Squire)) {
                if (p.item != null && lantern()) {
                    p.point_lden = 0.1f;
                } else {
                    p.point_lden = 0;
                }
            }

            //</editor-fold>    eff Player
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean map124() {
        return p.map != null && p.map.map_id == 124;
    }

    private boolean lantern() {
        int[] itemIds = {4820, 4821, 4822, 4823, 4824, 4825, 4826};
        for (int itemId : itemIds) {
            if (p.item.total_item_by_id(3, itemId) > 0) {
                return true;
            }
        }
        return false;
    }

}
