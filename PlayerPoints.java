package ai;

import client.Player;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerPoints {

    public static final String TEMP_FILE_PATH = "player_points_temp.txt";

    // Phương thức lưu điểm của người chơi vào file tạm thời
    public static void savePlayerPointsToFile(Player pATK, int newPoints, boolean giftReceived) {
    File file = new File(PlayerPoints.TEMP_FILE_PATH);
    List<String> lines = new ArrayList<>();
    boolean playerFound = false;

    String giftStatus = giftReceived ? "Received" : "Not Received";

    // Đọc toàn bộ nội dung file và cập nhật điểm và trạng thái nhận quà của người chơi
    if (file.exists()) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 4) { // Giả sử file đã có ID, tên, điểm và trạng thái
                    int playerId = Integer.parseInt(data[0]);
                    if (playerId == pATK.index) {
                        lines.add(playerId + "," + pATK.name + "," + newPoints + "," + giftStatus);
                        playerFound = true;
                    } else {
                        lines.add(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Nếu người chơi chưa tồn tại trong file, thêm mới vào danh sách
    if (!playerFound) {
        lines.add(pATK.index + "," + pATK.name + "," + newPoints + "," + giftStatus);
    }

    // Ghi lại toàn bộ nội dung vào file, đảm bảo chỉ có điểm và trạng thái mới được lưu lại
    try (PrintWriter writer = new PrintWriter(file)) {
        for (String line : lines) {
            writer.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}




    // Phương thức tải lại điểm từ file tạm thời
public static int loadPlayerPointsFromFile(Player player) {
    File file = new File(TEMP_FILE_PATH);
    if (!file.exists()) {
        return 0; 
    }

    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length == 4 && Integer.parseInt(data[0]) == player.index) {
                return Integer.parseInt(data[2]); // Trả về số điểm của người chơi
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }

    return 0;  // Trả về 0 nếu không tìm thấy người chơi
}


public static boolean loadPlayerGiftStatus(Player player) {
    File file = new File(PlayerPoints.TEMP_FILE_PATH);
    if (!file.exists()) {
        return false; 
    }

    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length == 4 && Integer.parseInt(data[0]) == player.index) {
                return "Received".equals(data[3]); // Return true if the gift has been received
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }

    return false;  // Return false if the player is not found
}




    // Phương thức xóa file tạm thời
    public static void deleteTempFile() {
        File file = new File(TEMP_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}
