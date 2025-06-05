package ai;

import client.Player;
import core.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Fusion {

    // Lưu trạng thái hợp thể cho từng người chơi
    public static Map<Integer, boolean[]> playerFusionStatus = new HashMap<>();

    // Phương thức lưu trạng thái hợp thể của người chơi (fusion, anmess, isCase)
    public static void saveFusionStatus(Player player, Boolean fusion, Boolean anmess, Boolean isCase) {
        boolean[] status = new boolean[3];
        status[0] = fusion != null ? fusion : getFusionStatus(player)[0];
        status[1] = anmess != null ? anmess : getFusionStatus(player)[1];
        status[2] = isCase != null ? isCase : getFusionStatus(player)[2];

        // Lưu trạng thái cho người chơi cụ thể trong bộ nhớ
        playerFusionStatus.put(player.index, status);

        // Lưu trạng thái hợp thể vào CSDL
        saveFusionStatusToSQL(player, status);
    }

    // Phương thức tải trạng thái hợp thể của một người chơi
    public static boolean[] getFusionStatus(Player player) {
        // Nếu chưa có trong bộ nhớ thì thử tải từ SQL
        if (!playerFusionStatus.containsKey(player.index)) {
            loadFusionStatusFromSQL(player);
        }
        return playerFusionStatus.getOrDefault(player.index, new boolean[]{false, false, false});
    }

    public boolean isFusion(Player player) {
        return getFusionStatus(player)[0];
    }

    public boolean isAnmess(Player player) {
        return getFusionStatus(player)[1];
    }

    public boolean isCase(Player player) {
        return getFusionStatus(player)[2];
    }

    // Phương thức lưu trạng thái hợp thể của người chơi vào CSDL
    // Ở đây lưu dưới dạng chuỗi "true:false:true" (các giá trị cách nhau bởi dấu :)
    private static void saveFusionStatusToSQL(Player player, boolean[] status) {
        String fusionState = status[0] + ":" + status[1] + ":" + status[2];
        try (Connection conn = SQL.gI().getConnection()) {
            // Thiết lập auto-commit nếu cần
            if (!conn.getAutoCommit()) {
                conn.setAutoCommit(true);
            }
            String query = "INSERT INTO fusion_data (player_id, fusion_state) VALUES (?, ?) " +
                           "ON DUPLICATE KEY UPDATE fusion_state = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, player.index);
                ps.setString(2, fusionState);
                ps.setString(3, fusionState);
                int affected = ps.executeUpdate();
                System.out.println("Fusion data affected rows: " + affected);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lưu dữ liệu fusion cho player " + player.index);
            e.printStackTrace();
        }
    }

    // Phương thức tải trạng thái hợp thể của người chơi từ CSDL
    public static void loadFusionStatusFromSQL(Player player) {
        try (Connection conn = SQL.gI().getConnection()) {
            String query = "SELECT fusion_state FROM fusion_data WHERE player_id = ?";
            String fusionState = null;
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, player.index);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        fusionState = rs.getString("fusion_state");
                    }
                }
            }
            boolean[] status = new boolean[3];
            if (fusionState != null && !fusionState.isEmpty()) {
                String[] parts = fusionState.split(":");
                if (parts.length >= 3) {
                    status[0] = Boolean.parseBoolean(parts[0]);
                    status[1] = Boolean.parseBoolean(parts[1]);
                    status[2] = Boolean.parseBoolean(parts[2]);
                }
            } else {
                // Nếu không có dữ liệu, mặc định là false cho tất cả
                status[0] = false;
                status[1] = false;
                status[2] = false;
            }
            // Lưu trạng thái vào bộ nhớ
            playerFusionStatus.put(player.index, status);
        } catch (SQLException e) {
            System.err.println("Lỗi khi tải dữ liệu fusion cho player " + player.index);
            e.printStackTrace();
        }
    }

    // Phương thức xóa dữ liệu fusion của người chơi khỏi CSDL (nếu cần)
    public static void deleteFusionData(Player player) {
        try (Connection conn = SQL.gI().getConnection()) {
            String query = "DELETE FROM fusion_data WHERE player_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, player.index);
                int affected = ps.executeUpdate();
                System.out.println("Fusion data deleted rows: " + affected);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa dữ liệu fusion cho player " + player.index);
            e.printStackTrace();
        }
        playerFusionStatus.remove(player.index);
    }
}
