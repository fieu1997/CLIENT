package BossHDL;

import client.Player;
import core.Manager;
import core.Service;
import core.Util;
import io.Message;
import io.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import map.LeaveItemMap;
import static map.LeaveItemMap.leave_item_by_type3;
import map.Mob_in_map;
import template.Mob;
import map.Map;
import map.MapService;
import template.Eff_TextFire;
import template.ItemTemplate3;

public class BossManager {

    public static List<Mob_in_map> entrys = new ArrayList<>();
    private static HashMap<String, Long> lastBossCallTime = new HashMap<>();

    // public static final CopyOnWriteArrayList<Mob_in_map> entrys = new CopyOnWriteArrayList<>();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // Kiểm tra thời gian gọi boss cuối cùng
    public static boolean canCallBoss(int mapId, int zoneId) {
        String key = mapId + "_" + zoneId;
        Long lastCallTime = lastBossCallTime.get(key);
        if (lastCallTime == null) {
            return true;
        }
        long currentTime = System.currentTimeMillis();
        return (currentTime - lastCallTime) >= 15_000; // 30 giây
    }

    // Lấy thời gian còn lại trước khi có thể gọi boss tiếp
    public static long getTimeLeftForBossCall(int mapId, int zoneId) {
        String key = mapId + "_" + zoneId;
        Long lastCallTime = lastBossCallTime.get(key);
        if (lastCallTime == null) {
            return 0;
        }
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - lastCallTime;
        return Math.max(0, 15_000 - timePassed);
    }

    // Cập nhật thời gian gọi boss cuối cùng
    public static void updateLastBossCallTime(int mapId, int zoneId) {
        String key = mapId + "_" + zoneId;
        lastBossCallTime.put(key, System.currentTimeMillis());
    }

    private static byte GetIdMap(int idboss) {
        switch (idboss) {
            //case = mod - Return = map

            case 103:
                return 7;
            case 104:
                return 15;
            case 101:
                return 25;
            case 84:
                return 37;
            case 105:
                return 45;

            case 83:
                return 51;
            case 106:
                return 62;
            case 149:
                return 76;
            case 155:
                return 79;
            case 174:
                return 26;
            case 173:
                return 113;
            case 195:
                return 112;
            case 196:
                return 115;
            case 197:
                return 114;
            case 186:
                return 109;
            case 187:
                return 110;
            case 188:
                return 111;
            // case 198, 203:
            // return 119; // boss cs dưới 50
            // case 199:
            // return 120; // cs 50 - 150
            // case 200:
            // return 121; // cs 150 - 300
            // case 201:
            // return 122; // cs 300 - 500
            // case 202:
            // return 123; // cs 500 - 1000

            default:
                throw new AssertionError();
        }
    }

    private static short[] GetSite(int idboss) {
        switch (idboss) {
            //mod + vị trí 

            case 103:
                return new short[]{432, 512};
            case 104:
                return new short[]{530, 213};
            case 101:
                return new short[]{204, 284};
            case 84:
                return new short[]{160, 224};
            case 105:
                return new short[]{816, 1064};

            case 83:
                return new short[]{320, 1520};
            case 106:
                return new short[]{468, 498};
            case 149:
                return new short[]{204, 762};
            case 155:
                return new short[]{534, 732};
            case 174:
                return new short[]{550, 250};
            case 173:
                return new short[]{450, 432};
            case 195:
                return new short[]{450, 432};
            case 196:
                return new short[]{450, 432};
            case 197:
                return new short[]{450, 432};
            case 186:
                return new short[]{450, 432};
            case 187:
                return new short[]{450, 432};
            case 188:
                return new short[]{450, 432};

            // case 198:
            // return new short[]{529, 365};
            // case 199:
            // return new short[]{529, 365};
            // case 200:
            // return new short[]{529, 365};
            // case 201:
            // return new short[]{529, 365};
            // case 202:
            // return new short[]{529, 365};
            // case 203:
            // return new short[]{529, 365};
            default:
                throw new AssertionError();
        }
    }

    public static void init() {
    lastBossSpawnTime = 0;
        int idx = 10_000;
        int[] ids = new int[]{101, 84, 83, 103, 104, 105, 106, 149, 155, 174, 173, 195, 196, 197, 186, 187, 188, /*198, 199, 200, 201, 202, 203*/};
        for (int id : ids) {
            for (int i = 0; i < 5; i++) {

                if (id == 174) {
                    if (Manager.gI().event != 1) {
                        continue;
                    }
                }

                Mob m = Mob.entrys.get(id);
                Mob_in_map temp = new Mob_in_map();
                temp.template = m;
                temp.x = GetSite(id)[0];
                temp.y = GetSite(id)[1];
                temp.level = id == 174 ? 50 : m.level;
                temp.color_name = 5;

                temp.Set_isBoss(true);
                temp.hp = temp.Set_hpMax(id == 174 ? (500_000_000 * (i + 1)) : m.hpmax);

                if (id == 174) {
                    temp.timeBossRecive = 1000 * 60 * 60 * 3;
                } else {
                    temp.timeBossRecive = 1000 * 60 * 60 * 3;
                }
                temp.map_id = GetIdMap(id);

                temp.zone_id = (byte) i;
                temp.index = idx++;
                entrys.add(temp);

                //map[i].Boss_entrys.add(temp);
            }
        }

        // Gọi BossManager.callBosToMap một lần cho mỗi khu
        //for (int khu = 0; khu <= 4; khu++) {      
        int[][] bossParams = {
            {119, 0, 198, 516, 342, 150, 500_000_000, 5_000_000, 100_000, 1, 1000 * 60 * 60 * 3}, // > 50
            {119, 2, 199, 516, 342, 160, 700_000_000, 7_000_000, 300_000, 1, 1000 * 60 * 60 * 3}, // 50 - 150
            {119, 3, 200, 516, 342, 170, 1_000_000_000, 10_000_000, 500_000, 1, 1000 * 60 * 60 * 3}, // 150 - 300
            {119, 4, 201, 516, 342, 180, 1_500_000_000, 15_000_000, 700_000, 1, 1000 * 60 * 60 * 3}, // 300 - 500
            {119, 5, 202, 516, 342, 200, 1_000_000_000, 10_000_000, 500_000, 1, 1000 * 60 * 60 * 3} // 500 - 1000
        };
        for (int[] params : bossParams) {
            for (int j = 0; j < 5; j++) {
                BossManager.callBossToMap(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8], params[9], params[10], 0);
            }
        }

        //}
    }

    public static String GetInfoBoss(int idMob) {
        String s = null;
        long currentTimeMillis = System.currentTimeMillis();

        long time = System.currentTimeMillis();
        for (Mob_in_map mob : entrys) {
            if (mob.template.mob_id == idMob) {
                if (s == null) {
                    Map[] m = Map.get_map_by_id(mob.map_id);
                    if (m == null) {
                        continue;
                    }
                    s = "Map: " + m[0].name;
                }
                s += "\nkhu: " + (mob.zone_id + 1) + (mob.time_back > time ? (" Hồi sinh vào lúc: " + Helps._Time.ConvertTime(mob.time_back) + "") : " Còn sống");
            }
        }
        return s;
    }
    public static long lastBossSpawnTime = System.currentTimeMillis(); // Biến lưu thời gian xuất hiện boss cuối cùng
    private static int lastMapId = -1; // Biến lưu ID của map vừa sử dụng

    public static void Update() {
    try {
        long currentTime = System.currentTimeMillis();

        // Kiểm tra nếu đây là lần đầu chạy
        if (lastBossSpawnTime == 0) {
            // Gọi boss ID 219 vào map ngẫu nhiên ngay khi khởi động
            int mapId;
            Set<Integer> excludedMapIds = Set.of(1, 46, 48, 50);
            do {
                mapId = Util.random(0, 5);
            } while (excludedMapIds.contains(mapId));

            Map[] map = Map.get_map_by_id(mapId);
            if (map == null || map.length == 0) {
                System.out.println("Không tìm thấy map hợp lệ khi khởi động. mapId: " + mapId);
                return;
            }

            short x = (short) ((map[0].mapW * 24) * 0.2 + (map[0].mapW * 24) * 0.6 / 2);
            short y = (short) ((map[0].mapH * 24) * 0.2 + (map[0].mapH * 24) * 0.6 / 2);
            Mob_in_map newBoss = BossManager.callBossToMap(mapId, 0, 219, x, y, 150, 1_000_000, 500, 10_000, 1, 60 * 1000, 0);
            if (newBoss != null) {
                System.out.println("[" + currentTime + "] Boss ID 219 đã xuất hiện tại map: " + map[0].name + ", tọa độ: (" + x + ", " + y + ")");
            }

            // Đặt lastBossSpawnTime sau khi gọi boss để bắt đầu tính thời gian
            lastBossSpawnTime = currentTime;
            System.out.println("lastBossSpawnTime đã được cập nhật: " + lastBossSpawnTime);
        }

        // Kiểm tra nếu đã đủ thời gian (1 phút) để xuất hiện lại boss ID 219
        if (currentTime - lastBossSpawnTime >= 30 * 60 * 1000) {
            System.out.println("Đã đủ thời gian để kiểm tra boss mới.");

            // Xóa boss ID 219 cũ nếu tồn tại
            if (entrys == null || entrys.isEmpty()) {
                System.out.println("Danh sách entrys trống hoặc chưa được khởi tạo.");
            } else {
                for (Iterator<Mob_in_map> iterator = entrys.iterator(); iterator.hasNext();) {
                    Mob_in_map mob = iterator.next();
                    if (mob == null || mob.template == null) {
                        System.out.println("Mob hoặc template của mob bị null.");
                        continue;
                    }
                    if (mob.template.mob_id == 219 && mob.is_boss_active) {
                        Map[] map = Map.get_map_by_id(mob.map_id);
                        if (map != null && map.length > mob.zone_id) {
                            mob.is_boss_active = false;
                            mob.isdie = true;
                            mob.hp = 0;
                            map[mob.zone_id].Boss_entrys.remove(mob);
                            iterator.remove(); // Sử dụng iterator để xóa boss
                            System.out.println("[" + currentTime + "] Boss ID 219 đã bị xóa khỏi map: " + map[mob.zone_id].name);
                            lastMapId = mob.map_id; // Lưu lại ID của map vừa xóa
                        }
                    }
                }
            }

            // Gọi boss ID 219 mới vào map ngẫu nhiên
            int mapId;
            Set<Integer> excludedMapIds = Set.of(1, 46, 48, 50);
            int attempts = 0;
            do {
                mapId = Util.random(0, 50);
                attempts++;
                System.out.println("Đã thử chọn mapId: " + mapId);
                if (attempts > 10) {
                    System.out.println("Không thể chọn map hợp lệ sau 10 lần thử.");
                    return;
                }
            } while (mapId == lastMapId || excludedMapIds.contains(mapId));

            Map[] map = Map.get_map_by_id(mapId);
            if (map == null || map.length == 0) {
                System.out.println("Không tìm thấy map hợp lệ với mapId: " + mapId);
                return;
            }

            String mapName = map[0].name;
            short x = (short) ((map[0].mapW * 24) * 0.2 + (map[0].mapW * 24) * 0.6 / 2);
            short y = (short) ((map[0].mapH * 24) * 0.2 + (map[0].mapH * 24) * 0.6 / 2);
            System.out.println("Tọa độ được tính cho boss: x = " + x + ", y = " + y);

            Mob_in_map newBoss = BossManager.callBossToMap(mapId, 0, 219, x, y, 100, 1_000_000, 500, 10_000, 1, 60 * 1000, 0);
            if (newBoss == null) {
                System.out.println("Không thể tạo boss ID 219 tại mapId: " + mapId);
            } else {
                System.out.println("[" + currentTime + "] Boss ID 219 đã xuất hiện tại map: " + mapName + ", tọa độ: (" + x + ", " + y + ")");
            }

            lastBossSpawnTime = currentTime;
            System.out.println("lastBossSpawnTime đã được cập nhật: " + lastBossSpawnTime);
        }

        // Duyệt qua tất cả các boss trong danh sách để cập nhật trạng thái
        if (entrys != null) {
            for (Mob_in_map mob : entrys) {
                if ((!mob.is_boss_active || mob.isdie) && currentTime > mob.time_back) {
                    Map[] map = Map.get_map_by_id(mob.map_id);
                    if (map == null || map.length <= mob.zone_id) {
                        System.out.println("Map không hợp lệ hoặc zone_id vượt quá giới hạn.");
                        continue;
                    }
                    mob.isdie = false;
                    mob.is_boss_active = true;
                    mob.hp = mob.get_HpMax();
                    map[mob.zone_id].Boss_entrys.remove(mob);
                    map[mob.zone_id].Boss_entrys.add(mob);
                    Manager.gI().chatKTGprocess("" + mob.template.name + " Đã Xuất Hiện Tại " + map[mob.zone_id].name);
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Lỗi xảy ra trong Update(): " + e.getMessage());
    }
}


    public static void DropItemBossEvent(Map map, Mob_in_map mob, Player p) throws IOException {
        if (Manager.gI().event == 1) {
            int[] it4 = new int[]{48, 49, 50, 51, 52, 5, 26, 131, 132, 24, 10};
            int[] it7 = new int[]{346, 349, 33, 34, 12, 13};
            int[] it3 = new int[]{4577, 4578, 4579, 4580, 4581, 4582, 4583, 4584};

            for (int i = 0; i < 15; i++) {
                LeaveItemMap.leave_vang(map, mob, -1);
            }
            for (int i = 0; i < 40; i++) {
                int ran = Util.random(100);
                if (ran < 10) {
                    LeaveItemMap.leave_item_by_type7(map, (short) Util.random(it7), p, mob.index, p.index);
                }
                if (ran < 40) {
                    LeaveItemMap.leave_item_by_type4(map, (short) Util.random(it4), p, mob.index, -1);
                } else {
                    LeaveItemMap.leave_item_by_type7(map, (short) Util.random(417, 464), p, mob.index, -1);
                }
            }
            int rate = Util.random(100);
            if (rate < 20) {
                int id = Util.random(it3);
                ItemTemplate3 temp = ItemTemplate3.item.get(id);
                LeaveItemMap.leave_item_by_type3(map, id, temp.getColor(), p, temp.getName(), mob.index);
            }
        }
    }

    public static Mob_in_map callBossToMap(int map_id, int zone_id, int boss_id, int x, int y, int level, int hp, int def, int dame, int type, int timehs, int playerId) {
        Mob m = Mob.entrys.get(boss_id);
        Mob_in_map temp = new Mob_in_map();
        temp.template = m;
        temp.x = (short) x;
        temp.y = (short) y;
        temp.level = (short) level;
        temp.color_name = 5;
        temp.Set_isBoss(true);
        temp.hp = temp.Set_hpMax(hp);
        temp.deff = def;
        if (map_id != 124) {// ẩn với map 124
            temp.phandame = 10000;
            temp.nedon = 5000;
        }
        temp.damebase = dame;
        temp.chimang = 10000;
        temp.xuyengiap = 10000;

        if (type == 1) {
            temp.timeBossRecive = timehs;
        }

        temp.map_id = (byte) map_id;
        temp.zone_id = (byte) zone_id;
        temp.index = 10_000 + entrys.size();
        temp.setSpecialBoss(true);
        if (type != 1) {// ! ẩn code đối với type 1
            temp.callerId = playerId; // Lưu ID của người chơi
            temp.callerName = ""; // gán tên
            // Lưu vị trí 
            temp.bossMapId = map_id;
            temp.bossZoneId = zone_id + 1;
            temp.bossX = x;
            temp.bossY = y;
        }
        entrys.add(temp);
        if (map_id != 124) {
            scheduleBossHpRegen(temp);
            scheduleBossDamage(temp);
        }
        if (type != 1) {
            scheduleBossRemoval(temp);
        }

        return temp; // Trả về đối tượng Mob_in_map
    }

    // Hồi máu boss
    private static void scheduleBossHpRegen(Mob_in_map boss) {
        scheduler.scheduleAtFixedRate(() -> {
            if (boss.is_boss_active && !boss.isdie) {
                synchronized (boss) {
                    boss.hp = Math.min(boss.get_HpMax(), boss.hp + 100_000 * boss.level);

                }
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    // Tính Dame hút máu
    private static void scheduleBossDamage(Mob_in_map boss) {
        scheduler.scheduleAtFixedRate(() -> {
            if (boss.is_boss_active && !boss.isdie) {
                Map[] maps = Map.get_map_by_id(boss.map_id);
                if (maps == null || maps.length <= boss.zone_id) {
                    return;
                }
                Map map = maps[boss.zone_id];

                for (Player player : map.players) {
                    if (player != null && player.isAlive() && player.hp > 0) {
                        double distance = Math.sqrt(Math.pow(player.x - boss.x, 2) + Math.pow(player.y - boss.y, 2));

                        if (distance <= 200) {
                            int dame = (int) (0.1 * player.hp);
                            player.takeDamage(dame);

                            Session conn = player.conn;
                            byte indexskill = (byte) Util.random(0, 4);
                            int idPTaget = player.index;
                            int hpPtaget = player.hp;
                            List<Eff_TextFire> listFire = new ArrayList<>();

                            try {
                                Message m = createDamageMessage(conn, indexskill, idPTaget, dame, hpPtaget, listFire);
                                MapService.send_msg_player_inside(map, conn.p, m, true);
                                m.cleanup();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            if (player.hp <= 0) {
                                break;
                            }
                        }
                    }
                }
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    private static Message createDamageMessage(Session conn, byte indexskill, int idPTaget, int damage, int hpPtaget, List<Eff_TextFire> listFire) throws IOException {
        Service.send_notice_nobox_white(conn, "Bị boss hút " + damage + " Máu");
        Message m = new Message(6);
        m.writer().writeShort(conn.p.index);
        m.writer().writeByte(indexskill);
        m.writer().writeByte(1);
        m.writer().writeShort(idPTaget);
        m.writer().writeInt(damage);
        m.writer().writeInt(hpPtaget);
        m.writer().writeByte(listFire.size());

        for (Eff_TextFire ef : listFire) {
            if (ef != null) {
                m.writer().writeByte(ef.type);
                m.writer().writeInt(ef.dame);
            }
        }

        m.writer().writeInt(conn.p.hp);
        m.writer().writeInt(conn.p.mp);
        m.writer().writeByte(11);
        m.writer().writeInt(0);

        return m;
    }

    // sau time sẽ xoá boss khỏi map
    private static void scheduleBossRemoval(Mob_in_map boss) {
        scheduler.schedule(() -> {
            boss.is_boss_active = false;
            boss.isdie = true;
            boss.hp = 0;

            Map map = Map.get_map_by_id(boss.map_id)[boss.zone_id];
            if (map != null) {
                map.Boss_entrys.remove(boss);
            }
            entrys.remove(boss);

        }, 60 * 15, TimeUnit.SECONDS);
    }

    public static boolean checkBossInMap(int map_id, int zone_id) {
        for (Mob_in_map mob : entrys) {
            if (mob.map_id == map_id && mob.zone_id == zone_id && mob.is_boss_active && !mob.isdie) {
                return true; // Boss được tìm thấy
            }
        }
        return false; // Không tìm thấy boss
    }

}
