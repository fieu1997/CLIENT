package ai;

import client.Player;
import core.Manager;
import core.Service;
import io.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import map.Map;
import map.MapService;
import map.Mob_in_map;
import ai.khu2;
import client.Squire;
import core.Util;
import template.MainObject;

public class ThachDau_Nb {

    public final Player A; // Người chơi thách đấu
    public final Player B; // Đối tượng AI của người bị thách đấu
    private final Nbtd nbtd; // Đối tượng AI của người bị thách đấu

    private final Map map; // Bản đồ thách đấu
    private boolean isBattleActive; // Trạng thái trận đấu
    //public long startTime; // Thời gian bắt đầu trận đấu
    public static final long DURATION = 5 * 60 * 1000; // 15 giây

    public ThachDau_Nb(Player A, Player B, Nbtd nbtd) throws IOException {
        this.A = A;
        this.B = B;
        this.nbtd = nbtd;

        // Tạo map thách đấu (ID = 126)
        Map mapTemplate = Map.get_map_by_id(126)[0];
        this.map = new Map(126, 0, mapTemplate.npc_name_data, mapTemplate.name, mapTemplate.typemap,
                mapTemplate.ismaplang, mapTemplate.showhs, mapTemplate.maxplayer, mapTemplate.maxzone, mapTemplate.vgos);
        this.map.mobs = new Mob_in_map[0];
        this.map.start_map();
        A.startTime = System.currentTimeMillis() + DURATION;
        // Đưa map vào Manager để quản lý
        Manager_td.gI().addBattle(this);

        // Đưa người chơi và Nbtd vào map
        movePlayersToMap();
        sendNoticeToMap("Bắt Đầu Trận Đấu");
    }

    private void movePlayersToMap() throws IOException {
        // Đưa người chơi A vào map
        MapService.leave(A.map, A);
        A.map = map;
        A.x = 360; // Vị trí của người chơi
        A.y = 222;
        MapService.enter(map, A);

        Nbtd nb = new Nbtd(A, B);
        nb.setup(B);
        nb.act_time = System.currentTimeMillis() + 5 * 60 * 1000;
        Manager.gI().add_list_nbtd(nb);
        Message m12 = new Message(4);
        m12.writer().writeByte(0);
        m12.writer().writeShort(0);
        m12.writer().writeShort(nb.index);
        m12.writer().writeShort(nb.x);
        m12.writer().writeShort(nb.y);
        m12.writer().writeByte(-1);
        MapService.send_msg_player_inside(map, A, m12, true);
        m12.cleanup();

        long currentTime = System.currentTimeMillis();
        long timeRemaining = A.startTime - currentTime;
        if (map.map_id == 126) {
            Message m = new Message(-104);
            m.writer().writeByte(1); // Loại thông báo
            m.writer().writeByte(2); // ID cây (nếu có)
            m.writer().writeShort((int) (timeRemaining / 1000)); // Thời gian còn lại tính bằng giây
            m.writer().writeUTF("Kết Thúc Sau"); // Tiêu đề thông báo
            m.writer().writeShort(0); // Không có phần thưởng
            m.writer().writeUTF(""); // Không có thông tin thêm
            A.conn.addmsg(m);
            m.cleanup();
        }

    }

    private void sendNoticeToMap(String message) {
        try {
            Message m = new Message(53);
            m.writer().writeUTF(message);
            for (Player p : map.players) {
                if (p != null && p.conn != null && p.conn.connected) {
                    p.conn.addmsg(m);
                }
            }
            m.cleanup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Manager_td {

        private static Manager_td instance;
        public List<ThachDau_Nb> battles = new ArrayList<>();

        public static Manager_td gI() {
            if (instance == null) {
                instance = new Manager_td();
            }
            return instance;
        }

        public void addBattle(ThachDau_Nb battle) {
            if (battle != null) {
                battles.add(battle);
            }
        }

        public static void removeBattle(ThachDau_Nb battle) {
    if (battle != null) {
        Manager_td.gI().battles.remove(battle); // Tham chi?u danh sách qua instance
    }
}


       
    }
}
