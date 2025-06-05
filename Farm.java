package ev_he;

import client.Player;
import core.SQL;
import core.Service;
import core.Util;
import io.Message;
import io.Session;
import map.Map;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Farm {

    // Danh sách MobFarm riêng cho từng người chơi
    public static final HashMap<Integer, List<MobFarm>> playerMobFarms = new HashMap<>();

    public static final long time_lua = 1000 * 60 * 5;
    public static final long time_ngo = 1000 * 60 * 15;
    public static final long time_hoa =  1000 * 60 * 30;
    public static final long time_catim = 1000 * 60 * 60;
    public static final long time_bido = 1000 * 60 * 60 * 3;
    public static final long time_daotien = 1000 * 60 * 60 * 5; // 5 h
    public static final long cay_thoi = 30 * 60 * 1000; // 30p
   
    public static MobFarm getMob(int id, int playerIndex) {
        // Lấy danh sách MobFarm của người chơi hiện tại
        List<MobFarm> playerMobs = playerMobFarms.get(playerIndex);
        if (playerMobs != null) {
            for (MobFarm mob : playerMobs) {
                if (mob.getId() == id) {
                    return mob;
                }
            }
        }
        return null; // Không tìm thấy MobFarm với ID đã cho
    }

    // Tạo và thêm ô đất (MobFarm) cho người chơi
    public static void spawnEmptyPlots(Player player) {
        try {
            List<MobFarm> playerMobs = playerMobFarms.computeIfAbsent(player.index, k -> new ArrayList<>());
            Map map = player.map;

            for (int i = 0; i < 10; i++) {
                short index = (short) (2000 + i);
                MobFarm plot = new MobFarm(map, index);
                plot.Owner = player;

                // Set ô đất đầu tiên là "Đất Hoang", còn lại là Hidden
                if (i == 0) {
                    plot.nameOwner = "Đất Hoang";
                    plot.currentEff = 220;
                } else {
                    plot.nameOwner = "Hidden";
                    plot.currentEff = -1; // Không có hiệu ứng cho ô đất ẩn
                }

                plot.x = (short) (198 + (i % 5) * 50);
                plot.y = (short) (288 + (i / 5) * 62);

                playerMobs.add(plot);
                if (i == 0) {
                    plot.SendMob(player); // Chỉ gửi ô đất đầu tiên
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hiển thị MobFarm của người chơi khi vào map
    public static void showPlayerMobFarm(Player player) {
        try {
            List<MobFarm> playerMobs = playerMobFarms.get(player.index);
            if (playerMobs != null) {
                for (MobFarm mob : playerMobs) {
                    mob.SendMob(player);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void remob(Session conn, int idmob) throws IOException {
        Message m2 = new Message(17);
        m2.writer().writeShort(-1);
        m2.writer().writeShort(idmob);
        conn.addmsg(m2);
        m2.cleanup();
    }

    // Cập nhật MobFarm riêng của người chơi
    public static void update_mobfarm(Player p) {
        try {
            List<MobFarm> playerMobs = playerMobFarms.get(p.index);
            if (playerMobs == null) {
                return;
            }

            long currentTime = System.currentTimeMillis();
            for (MobFarm mobFarm : playerMobs) {

                if ("Cây Lúa Mạch".equals(mobFarm.name) && (currentTime - mobFarm.timeUpdate >= time_lua)) {
                    mobFarm.name = "Cây 1"; // Cập nhật trạng thái cây
                    mobFarm.timeUpdate = currentTime; // Cập nhật lại thời gian khi cây chín
                    mobFarm.currentEff = 224;
                    Farm.remob(p.conn, mobFarm.getId());
                    continue; // Chuyển sang cây tiếp theo
                } else if ("Cây Ngô".equals(mobFarm.name) && (currentTime - mobFarm.timeUpdate >= time_ngo)) {
                    mobFarm.name = "Cây 2"; // Cập nhật trạng thái cây
                    mobFarm.timeUpdate = currentTime;
                    mobFarm.currentEff = 226;
                    Farm.remob(p.conn, mobFarm.getId());
                    continue;
                } else if ("Cây Hoa TuLip".equals(mobFarm.name) && (currentTime - mobFarm.timeUpdate >= time_hoa)) {
                    mobFarm.name = "Cây 3";
                    mobFarm.timeUpdate = currentTime;
                    mobFarm.currentEff = 228;
                    Farm.remob(p.conn, mobFarm.getId());
                    continue;
                } else if ("Cây Cà Tím".equals(mobFarm.name) && (currentTime - mobFarm.timeUpdate >= time_catim)) {
                    mobFarm.name = "Cây 4";
                    mobFarm.timeUpdate = currentTime;
                    mobFarm.currentEff = 230;
                    Farm.remob(p.conn, mobFarm.getId());
                    continue;
                } else if ("Cây Bí Đỏ".equals(mobFarm.name) && (currentTime - mobFarm.timeUpdate >= time_bido)) {
                    mobFarm.name = "Cây 5";
                    mobFarm.timeUpdate = currentTime;
                    mobFarm.currentEff = 232;
                    Farm.remob(p.conn, mobFarm.getId());
                    continue;
                } else if ("Cây Đào Tiên".equals(mobFarm.name) && (currentTime - mobFarm.timeUpdate >= time_daotien)) {
                    mobFarm.name = "Cây 6";
                    mobFarm.timeUpdate = currentTime;
                    mobFarm.currentEff = 234;
                    Farm.remob(p.conn, mobFarm.getId());
                    continue;
                }

                // Cây Thối 
                if (("Cây 1".equals(mobFarm.name) || "Cây 2".equals(mobFarm.name) || "Cây 3".equals(mobFarm.name)
                        || "Cây 4".equals(mobFarm.name) || "Cây 5".equals(mobFarm.name) || "Cây 6".equals(mobFarm.name))
                        && (currentTime - mobFarm.timeUpdate >= cay_thoi)) {
                    mobFarm.name = "Cây Thối"; // Cập nhật trạng thái cây bị thối
                    mobFarm.currentEff = 222;
                    Farm.remob(p.conn, mobFarm.getId());
                    continue;
                }

                if ("Trứng".equals(mobFarm.chicken)) {
                    long cooldown = 1000 * 60 * 60; // Thời gian mặc định để sinh trứng
                    if (playerMobs != null) {
                        for (MobFarm mob : playerMobs) {
                            if ("Gà".equals(mob.chicken) && mob.level >= 5) {
                                int maxEggs = mob.level; // Số lượng trứng tối đa bằng level của gà mẹ

                                if (mob.level >= 15) {
                                    cooldown =1000 * 60 * 60; // Thời gian sinh trứng cho gà level 15+ là 30 giây
                                }

                                if (mobFarm.eggCount < maxEggs && (currentTime - mobFarm.timeUpdate >= cooldown)) {
                                    // Sinh trứng nếu HP của gà mẹ đủ lớn
                                    if (mob.hp > 1) {
                                        mobFarm.eggCount++; // Tăng số lượng trứng
                                        mobFarm.timeUpdate = currentTime; // Cập nhật lại thời gian sinh trứng

                                        SaveData(p); // Lưu dữ liệu qua SQL
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa tất cả MobFarm của người chơi khi họ thoát game
    public static void removePlayerMobs(Player player) {
        List<MobFarm> mobs = playerMobFarms.remove(player.index);
        if (mobs != null) {
            for (MobFarm mob : mobs) {
                try {
                    mob.MobLeave();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Lưu dữ liệu farm của người chơi vào SQL thay vì file
public static void SaveData(Player player) {
    List<MobFarm> playerMobs = playerMobFarms.get(player.index);
    if (playerMobs == null) {
        System.out.println("Không có mob farm để lưu cho player " + player.index);
        return;
    }
    // Xây dựng chuỗi trạng thái (mỗi dòng là một mob, các trường cách nhau dấu phẩy)
    StringBuilder sb = new StringBuilder();
    for (MobFarm mob : playerMobs) {
        sb.append(mob.getId()).append(",")
          .append(mob.name).append(",")
          .append(mob.currentEff).append(",")
          .append(mob.timeUpdate).append(",")
          .append(mob.x).append(",")
          .append(mob.y).append(",");
        // Nếu là Gà hoặc Trứng thì ghi thêm các thông tin liên quan
        if ("Gà".equals(mob.chicken) || "Trứng".equals(mob.chicken)) {
            sb.append(mob.hp).append(",")
              .append(mob.level).append(",")
              .append(mob.chicken).append(",")
              .append(mob.lastFeedTime).append(",")
              .append(mob.eggCount).append(",");
        }
        sb.append(mob.nameOwner).append("\n");
    }
    String farmState = sb.toString();
    System.out.println("Farm state to save for player " + player.index + ":");
    System.out.println(farmState);

    // Lưu vào CSDL
    try (Connection conn = SQL.gI().getConnection()) {
        // Nếu connection không tự commit, ta có thể thiết lập auto-commit = true
        if (!conn.getAutoCommit()) {
            conn.setAutoCommit(true);
        }
        String query = "INSERT INTO farm_data (player_id, farm_state) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE farm_state = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, player.index);
            ps.setString(2, farmState);
            ps.setString(3, farmState);
            int affected = ps.executeUpdate();
            System.out.println("Số dòng bị ảnh hưởng: " + affected);
        }
        // Nếu connection không auto-commit, bạn cần gọi commit
        // conn.commit();
    } catch (SQLException e) {
        System.err.println("Lỗi khi lưu dữ liệu farm:");
        e.printStackTrace();
    }
}



    // Tải dữ liệu farm của người chơi từ SQL thay vì file
    public static void LoadData(Player player, Map map) {
        try (Connection conn = SQL.gI().getConnection()) {
            String query = "SELECT farm_state FROM farm_data WHERE player_id = ?";
            String farmState = null;
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, player.index);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        farmState = rs.getString("farm_state");
                    }
                }
            }

            List<MobFarm> playerMobs = new ArrayList<>();
            if (farmState == null || farmState.isEmpty()) {
                // Nếu không có dữ liệu, tạo ô đất trống mặc định
                spawnEmptyPlots(player);
                return;
            }
            // Mỗi dòng tương ứng với một mob
            String[] lines = farmState.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length < 7) {
                    continue;
                }
                short id = Short.parseShort(parts[0]);
                String name = parts[1];
                short currentEff = Short.parseShort(parts[2]);
                long timeUpdate = Long.parseLong(parts[3]);
                short x = Short.parseShort(parts[4]);
                short y = Short.parseShort(parts[5]);
                String nameOwner = parts[parts.length - 1]; // Phần tử cuối cùng là nameOwner

                MobFarm mob = new MobFarm(map, id);
                mob.name = name;
                mob.currentEff = currentEff;
                mob.timeUpdate = timeUpdate;
                mob.x = x;
                mob.y = y;
                mob.nameOwner = nameOwner;

                // Nếu có đủ thông tin về Gà/Trứng (phần tử nhiều hơn 7)
                if (parts.length > 7) {
                    try {
                        int hp = Integer.parseInt(parts[6]);
                        int level = Integer.parseInt(parts[7]);
                        String chicken = parts[8];
                        long lastFeedTime = Long.parseLong(parts[9]);
                        int eggCount = Integer.parseInt(parts[10]);
                        mob.hp = hp;
                        mob.level = level;
                        mob.chicken = chicken;
                        mob.lastFeedTime = lastFeedTime;
                        mob.eggCount = eggCount;
                    } catch (Exception ex) {
                        // Nếu parse lỗi thì bỏ qua thông tin này
                    }
                }
                mob.Owner = player;
                playerMobs.add(mob);
            }
            playerMobFarms.put(player.index, playerMobs);
            showPlayerMobFarm(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void MobChicken(Player p) {
        try {
            List<MobFarm> listmob = playerMobFarms.get(p.index);
            Map[] maps = Map.get_map_by_id(50);
            Map map = maps[0];
            //
            MobFarm mob = new MobFarm(map, (short) (2000 + listmob.size()));
            mob.nameOwner = "Gà Con";
            mob.chicken = "Gà";
            mob.hp = 1;
            mob.level = 1;
            mob.Owner = p;
            mob.x = 222;
            mob.y = 504;
            mob.currentEff = 235;
            mob.lastFeedTime = 0;
            listmob.add(mob);
            mob.SendMob(p);
            //
            MobFarm mob1 = new MobFarm(map, (short) (2000 + listmob.size()));
            mob1.nameOwner = "Ổ Trứng";
            mob1.chicken = "Trứng";
            mob1.hp = 1;
            mob1.level = 1;
            mob1.Owner = p;
            mob1.x = 150;
            mob1.y = 570;
            mob1.currentEff = 238;
            mob1.eggCount = 0;
            listmob.add(mob1);
            // Gửi thông tin cho người chơi
            mob.SendMob(p);
            Farm.SaveData(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Class MobFarm 
    public static class MobFarm {

        public long timeUpdate;
        public int index;
        public String name = "";
        public String nameOwner = "";
        public Player Owner;
        public Map map;
        public short x, y;
        public short currentEff = 220;
        public int level = 10;
        public int hp = 10;
        public int hpmax = 10;
        public String chicken = "";
        public long lastFeedTime;
        public int eggCount = 0;
        public int maxEggCount = 0;
        public long lastEggTime = 0;

        public int getId() {
            return this.index;
        }

        public MobFarm(Map map, short idx) {
            this.timeUpdate = System.currentTimeMillis();
            this.map = map;
            this.index = idx;
            this.lastFeedTime = 0;
            this.nameOwner = "Ô Đất Trống";
        }

        // Gửi thông tin MobFarm cho người chơi
        public void SendMob(Player p) throws IOException {
            Message m = new Message(4);
            m.writer().writeByte(1);
            m.writer().writeShort(currentEff);
            m.writer().writeShort(index);
            m.writer().writeShort(x);
            m.writer().writeShort(y);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();

            m = new Message(7);
            m.writer().writeShort(index);
            m.writer().writeByte((int)level); // Level
            m.writer().writeShort(x);
            m.writer().writeShort(y);
            m.writer().writeInt(hp); // HP
            m.writer().writeInt(hpmax); // Max HP
            m.writer().writeByte(0);
            m.writer().writeInt(-2);
            m.writer().writeShort(-1);
            m.writer().writeByte(1);
            m.writer().writeByte(1);
            m.writer().writeByte(0);
            m.writer().writeUTF(nameOwner);
            m.writer().writeLong(-11111);
            m.writer().writeByte(5);
            p.conn.addmsg(m);
            m.cleanup();
        }

        public void SendEffMob(Session conn, byte id_eff) throws IOException {
            if (!conn.p.isShowMobEvents) {
                return;
            }
            Message m = new Message(-49);
            byte[] data = Util.loadfile("data/part_char/imgver/x" + conn.zoomlv + "/Data/" + (111 + "_" + id_eff));
            m.writer().writeByte(0);
            m.writer().writeShort(data.length);
            m.writer().write(data);

            m.writer().writeByte(0);
            m.writer().writeByte(1);
            m.writer().writeByte(id_eff); // id part char

            m.writer().writeShort(index);
            m.writer().writeByte(1); // tem mob
            m.writer().writeByte(0);
            m.writer().writeShort(8000);
            m.writer().writeByte(0);
            conn.addmsg(m);
            m.cleanup();
        }

        // Xóa MobFarm
        public void MobLeave() throws IOException {
            Message m = new Message(17);
            m.writer().writeShort(Owner == null ? -1 : Owner.index);
            m.writer().writeShort(index);
            for (Player player : map.players) {
                if (player != null && player.conn != null && player.conn.connected) {
                    player.conn.addmsg(m);
                }
            }
            m.cleanup();

            // Sửa lỗi logic: xóa khỏi danh sách của người chơi
            if (Owner != null) {
                List<MobFarm> playerMobs = playerMobFarms.get(Owner.index);
                if (playerMobs != null) {
                    playerMobs.remove(this);
                }
            }
        }

        public void mobMove() {
            try {
                if ("Gà".equals(this.chicken)) {
                    this.timeUpdate = System.currentTimeMillis();
                    int moveX = Util.random(-50, 50);
                    int moveY = Util.random(-50, 50);

                    // Cập nhật vị trí x, y của gà, đảm bảo không đi quá xa vị trí ban đầu
                    this.x = (short) Math.max(222 - 50, Math.min(222 + 50, 222 + moveX));
                    this.y = (short) Math.max(504 - 50, Math.min(504 + 50, 504 + moveY));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public long time_caychin() {
            switch (this.name) {
                case "Cây Lúa Mạch":
                    return Farm.time_lua;
                case "Cây Ngô":
                    return Farm.time_ngo;
                case "Cây Hoa TuLip":
                    return Farm.time_hoa;
                case "Cây Cà Tím":
                    return Farm.time_catim;
                case "Cây Bí Đỏ":
                    return Farm.time_bido;
                case "Cây Đào Tiên":
                    return Farm.time_daotien;
                default:
                    return 0; // trả về 0 nếu không xác định
            }
        }

        public void qitem(Player p) throws IOException {
            List<Short> IDs = new ArrayList<>();
            List<Integer> Quants = new ArrayList<>();
            List<Short> Types = new ArrayList<>();

            // Thêm 3 item với id 14
            IDs.add((short) 14);
            Quants.add(3);
            Types.add((short) 7); // Giả sử item 14 thuộc category 7
            p.item.add_item_bag47((short) 14, (short) 3, (byte) 7);

            // Thêm 5 item với id 8, 9, 10, 11
            for (short id : new short[]{8, 9, 10, 11}) {
                IDs.add(id);
                Quants.add(5);
                Types.add((short) 7);
                p.item.add_item_bag47(id, (short) 5, (byte) 7);
            }

            short[] ar_id = new short[IDs.size()];
            int[] ar_quant = new int[Quants.size()];
            short[] ar_type = new short[Types.size()];
            for (int i = 0; i < ar_id.length; i++) {
                ar_id[i] = IDs.get(i);
                ar_quant[i] = Quants.get(i);
                ar_type[i] = Types.get(i);
            }

            p.item.char_inventory(3);
            p.item.char_inventory(4);
            p.item.char_inventory(7);

            Service.Show_open_box_notice_item(p, "Bạn nhận được", ar_id, ar_quant, ar_type);
        }

        public void item_key(Player p) throws IOException {
            List<Short> IDs = new ArrayList<>();
            List<Integer> Quants = new ArrayList<>();
            List<Short> Types = new ArrayList<>();
            int ngoc_up = 10_000;
            // Kiểm tra tỉ lệ 5% để nhận item 330 sử dụng Util.random_ratio
            if (Util.random_ratio(10)) {
                IDs.add((short) 330);
                Quants.add(1);
                Types.add((short) 4);
                p.item.add_item_bag47((short) 330, (short) 1, (byte) 4);
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
            p.update_ngoc(ngoc_up);
            p.item.char_inventory(3);
            p.item.char_inventory(4);
            p.item.char_inventory(7);

            Service.Show_open_box_notice_item(p, "Bạn nhận được 5% exp", ar_id, ar_quant, ar_type);
        }
    }
}
