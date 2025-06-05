package ai;

import client.Player;
import core.Service;
import io.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import map.Map;
import map.MapService;
import map.Mob_in_map;

public class ThachDau {

    public Player pl_1;
    public Player pl_2;
    private byte point1;
    private byte point2;

    public byte round;
    public Map map;
    public boolean isMapStart;
    public long timeSleep;
    private long timeOut;
    private long roundEndTime;   
    private int map_id1;
    private int map_id2;
    private short x1;
    private short y1;
    private short x2;
    private short y2;
    private byte zone_id1;
    private byte zone_id2;
    public int soVangCuoc;
    

    public ThachDau(Player p1, Player p2) throws IOException {
        pl_1 = p1;
        pl_2 = p2;
        // Lưu trữ thông tin map, khu và tọa độ trước khi vào map thách đấu
        this.map_id1 = p1.map.map_id;
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.zone_id1 = p1.map.zone_id;

        this.map_id2 = p2.map.map_id;
        this.x2 = p2.x;
        this.y2 = p2.y;
        this.zone_id2 = p2.map.zone_id;

        Map map_temp = Map.get_map_by_id(125)[0];
        map = new Map(125, 0, map_temp.npc_name_data, map_temp.name, map_temp.typemap, map_temp.ismaplang,
                map_temp.showhs, map_temp.maxplayer, map_temp.maxzone, map_temp.vgos);
        map.mobs = new Mob_in_map[0];
        map.start_map();
        map.td = this;

        round = 1; // Bắt đầu từ hiệp 1
        SetupNewRound();

    }

    private void SetupNewRound() throws IOException {
        if (pl_1 == null || pl_2 == null) {
            return;
        }

        timeSleep = System.currentTimeMillis() + 10_000L;
        roundEndTime = timeSleep + (5 * 60 * 1000L); // Hiệp kéo dài 5 phút kể từ khi bắt đầu

        resetPlayer(pl_1);
        resetPlayer(pl_2);

        MapService.leave(pl_1.map, pl_1);
        MapService.leave(pl_2.map, pl_2);
        pl_1.map = map;
        pl_2.map = map;
        MapService.enter(map, pl_1);
        MapService.enter(map, pl_2);

        // Thông báo hiệp đấu
        //Send_Notice_Map_Insider("Hiệp " + round + " bắt đầu sau 10 giây.");
        long timeht = System.currentTimeMillis();
        long time_run = timeSleep - timeht;
        ms_head(pl_1,(int) time_run, "Hiệp "+round+" bắt đầu sau", 0);
         ms_head(pl_2,(int) time_run, "Hiệp "+round+" bắt đầu sau", 0);
   
    } 

    private void resetPlayer(Player p) {
        p.isdie = false;
        p.hp = p.body.get_HpMax();
        p.mp = p.body.get_MpMax();
        p.x = (short) (p == pl_1 ? 280 : 440);
        p.y = 228;
        p.typepk = -1;
    }

    private void Hoiphuc(Player p) {
        p.isdie = false;
        p.hp = p.body.get_HpMax();
        p.mp = p.body.get_MpMax();
        p.typepk = -1;
    }

    private void InitATK() {
        if (pl_1 == null || pl_2 == null) {
            return;
        }
        if (pl_1.typepk == 0 || pl_2.typepk == 0) {
            return;
        }
        pl_1.typepk = 0;
        pl_2.typepk = 0;
        try {
            Message m = new Message(42);
            m.writer().writeShort(pl_1.index);
            m.writer().writeByte(0);
            MapService.send_msg_player_inside(map, pl_1, m, true);
            m.cleanup();

            m = new Message(42);
            m.writer().writeShort(pl_2.index);
            m.writer().writeByte(0);
            MapService.send_msg_player_inside(map, pl_2, m, true);
            m.cleanup();
            Service.send_notice_nobox_white(pl_1.conn, "Trận đấu đã bắt đầu");
            Service.send_notice_nobox_white(pl_2.conn, "Trận đấu đã bắt đầu");
            
                long time = System.currentTimeMillis();
                long timeLeft = roundEndTime - time; // Thời gian còn lại
                
                    long time_run = timeLeft;
                    ms_head(pl_1, (int) timeLeft, "Hiệp " + round + " còn lại", 0);
                    ms_head(pl_2, (int) timeLeft, "Hiệp " + round + " còn lại", 0);
                
            
        } catch (IOException e) {
        }
    }

    public void CloseATK() throws IOException {
        if (pl_1 == null || pl_2 == null) {
            return;
        }
        timeOut = System.currentTimeMillis() + 10_000L;
        if (pl_1.typepk != -1 || pl_2.typepk != -1) {
            pl_1.typepk = -1;
            pl_2.typepk = -1;
            try {
                Message m = new Message(42);
                m.writer().writeShort(pl_1.index);
                m.writer().writeByte(-1);
                MapService.send_msg_player_inside(map, pl_1, m, true);
                m.cleanup();

                m = new Message(42);
                m.writer().writeShort(pl_2.index);
                m.writer().writeByte(-1);
                MapService.send_msg_player_inside(map, pl_2, m, true);
                m.cleanup();
            } catch (IOException e) {
            }
        }

        
            SetReward();
        
    }
    
    public void ms_head(Player p,int time, String st, int type) throws IOException{
    if (type == 0){
            Message m = new Message(-104);
            m.writer().writeByte(1); // Loại thông báo
            m.writer().writeByte(2);
            m.writer().writeShort((int) (time / 1000));
            m.writer().writeUTF(st);
            m.writer().writeShort(0);
            m.writer().writeUTF("");
            p.conn.addmsg(m);
            m.cleanup();
            }
    if (type == 1){
         Message m = new Message(-104);
            m.writer().writeByte(1);
            m.writer().writeShort(2);
            m.writer().writeByte(-1);
            m.writer().writeByte(0);
            p.conn.addmsg(m);
            m.cleanup();
            }
        }

    private void SetReward() throws IOException {
        if (pl_1 == null || pl_2 == null) {
            return;
        }

        int p1 = point1;
        int p2 = point2;
        Player winner = null;

        if (p1 > p2) {
            winner = pl_1;
        } else if (p2 > p1) {
            winner = pl_2;
        }

        // Đưa người chơi về map gốc
        returnToOriginalMap(pl_1);
        returnToOriginalMap(pl_2);

        // Thông báo kết quả
        if (winner != null) {
        winner.update_vang(pl_1.vang_td + pl_2.vang_td);
            Service.send_notice_box(winner.conn, "Bạn đã thắng " + (pl_1.vang_td + pl_2.vang_td) + " vàng!");
            Send_Notice_Map_Insider(winner.name + " đã dành chiến thắng chung cuộc");
        } else {
            if (pl_1 != null) pl_1.update_vang(pl_1.vang_td);
            if (pl_2 != null) pl_2.update_vang(pl_2.vang_td);
            Send_Notice_Map_Insider("Kết quả chung cuộc: Hòa.");
        }

        // Đóng map
        CloseMap();
    }

    private void returnToOriginalMap(Player p) throws IOException {
        if (p == null) {
            return;
        }

        // Lấy map gốc dựa trên mapId đã lưu
        Map[] maps = Map.get_map_by_id(p == pl_1 ? map_id1 : map_id2);
        /*if (maps == null || maps.length == 0) {
            Service.send_notice_box(p.conn, "Không thể tìm thấy map gốc để chuyển người chơi.");
            return;
        }*/

        // Rời khỏi map hiện tại
        MapService.leave(p.map, p);

        // Khôi phục thông tin người chơi
        p.map = maps[0]; // Đặt map gốc
       // p.map_id =(byte) ((p == pl_1) ? map_id1 : map_id2);
        p.zone_id =(p == pl_1) ? zone_id1 : zone_id2;
        p.x = (p == pl_1) ? x1 : x2; // Tọa độ X
        p.y = (p == pl_1) ? y1 : y2; // Tọa độ Y
        p.hp = (p == pl_1) ? pl_1.body.get_HpMax() : pl_2.body.get_HpMax();
        p.mp = (p == pl_1) ? pl_1.body.get_MpMax() : pl_2.body.get_MpMax();
        p.isdie = (p == pl_1) ? false : false;
        // Thêm người chơi trở lại map gốc
        try {
            MapService.enter(p.map, p);
        } catch (IOException e) {
            e.printStackTrace();
            Service.send_notice_box(p.conn, "Có lỗi xảy ra khi đưa bạn về map gốc.");
        }
    }

    public void PlayerLeaveMap(Player p) {
        try {
            if (pl_1 != null && pl_1.index == p.index) {
                point2 = 2; // Người chơi 2 thắng
                Send_Notice_Map_Insider("Người chơi " + pl_1.name + " đã rời trận đấu. Người chơi " + pl_2.name + " chiến thắng!");
                returnToOriginalMap(pl_2);
                pl_2.update_vang(pl_1.vang_td + pl_2.vang_td);
                pl_1 = null;
            } else if (pl_2 != null && pl_2.index == p.index) {
                point1 = 2; // Người chơi 1 thắng
                Send_Notice_Map_Insider("Người chơi " + pl_2.name + " đã rời trận đấu. Người chơi " + pl_1.name + " chiến thắng!");
                returnToOriginalMap(pl_1);
                pl_1.update_vang(pl_1.vang_td + pl_2.vang_td);
                
                pl_2 = null;
            }

            // Nếu cả hai người chơi đều đã rời map
            if (pl_1 == null || pl_2 == null) {
                CloseMap();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        try {
            long time = System.currentTimeMillis();

            // Kiểm tra nếu một trong hai người chơi bị ngắt kết nối hoặc mất kết nối
            if (pl_1 != null && (!pl_1.conn.connected || pl_1.map.map_id != 125)) {
                PlayerLeaveMap(pl_1);
            }
            if (pl_2 != null && (!pl_2.conn.connected || pl_2.map.map_id != 125)) {
                PlayerLeaveMap(pl_2);
            }

            // Bắt đầu trận đấu nếu thời gian đếm ngược đã hết
            if (timeSleep < time && pl_1 != null && pl_2 != null) {
                InitATK();
            }
            
           
            // Kết thúc hiệp nếu thời gian hiệp đã hết
            if (roundEndTime > 0 && time > roundEndTime) {
                SetWinRound(null); // Không có người thắng do hết thời gian
            }
            
            // Đóng map nếu hết thời gian
            if (timeOut != 0 && timeOut < time) {
                CloseMap();
            }

            // Kiểm tra các lỗi liên quan
            CheckBug();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CheckBug() throws IOException {
        if (pl_1 == null && pl_2 == null) {
            return;
        }
        if (pl_1 != null && pl_2 == null) {
            SetWinRound(pl_1);
            return;
        }
        if (pl_2 != null && pl_1 == null) {
            SetWinRound(pl_2);
            return;
        }
        if (pl_2.hp <= 0 || pl_2.isdie) {
            SetWinRound(pl_1);
        } else if (pl_1.hp <= 0 || pl_1.isdie) {
            SetWinRound(pl_2);
        }
    }

    public void SetWinRound(Player p) throws IOException {
    if (timeOut > System.currentTimeMillis()) {
        return;
    }

    // Tăng điểm cho người thắng hiệp
    if (p != null) {
        if (p.index == pl_1.index) {
            point1++;
        } else if (p.index == pl_2.index) {
            point2++;
        }
        Send_Notice_Map_Insider("Người chơi " + p.name + " thắng hiệp " + round + "!");
    } else {
        // Hết thời gian hiệp mà không có người thắng
        Send_Notice_Map_Insider("Hiệp " + round + " kết thúc do hết thời gian!");
    }

    // Kiểm tra nếu một trong hai người chơi đạt đủ 2 điểm
    if (point1 == 2 || point2 == 2) {
        Player winner = (point1 == 2) ? pl_1 : pl_2;
        Send_Notice_Map_Insider("Người chơi " + winner.name + " đã chiến thắng trận đấu!");
        CloseATK(); // Kết thúc trận đấu
        return;
    }

    // Nếu chưa đạt 2 điểm, chuyển sang hiệp tiếp theo
    round++;
    if (round <= 3) {
        SetupNewRound();
    } else {
        CloseATK(); // Kết thúc nếu hết hiệp mà chưa có người đạt đủ điểm
    }
}


    public void CloseMap() throws IOException {
        if (pl_1 != null) {
            returnToOriginalMap(pl_1);
            pl_1 = null;
        }
        if (pl_2 != null) {
            returnToOriginalMap(pl_2);
            pl_2 = null;
        }

        for (int i = map.players.size() - 1; i >= 0; i--) {
            Player p = map.players.get(i);
            if (p != null) {
                returnToOriginalMap(p);
            }
        }
        map.stop_map();
        Manager.removeBattle(this);
    }

    public void Send_Notice_Map_Insider(String msg) throws IOException {
        Message m = new Message(53);
        m.writer().writeUTF(msg);
        m.writer().writeByte(0);
        for (Player p : map.players) {
            if (p != null && p.conn != null && p.conn.connected) {
                p.conn.addmsg(m);
            }
        }
        m.cleanup();
    }

    public void send_msg_inside(Message m) {
        for (Player p0 : map.players) {
            if (p0 != null && p0.conn != null && p0.conn.connected) {
                p0.conn.addmsg(m);
            }
        }
    }

    public static class Manager {

        private static Manager instance;
        public static List<ThachDau> battles = new ArrayList<>();

        public static Manager gI() {
            if (instance == null) {
                instance = new Manager();
            }
            return instance;
        }

        public static void addBattle(ThachDau battle) {
            if (battle != null) {
                battles.add(battle);
            }
        }

        public static void removeBattle(ThachDau battle) {
            if (battle != null) {
                try {
                    if (battle.pl_1 != null) {
                        battle.returnToOriginalMap(battle.pl_1);
                    }
                    if (battle.pl_2 != null) {
                        battle.returnToOriginalMap(battle.pl_2);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                battles.remove(battle);
            }
        }

        public static boolean isPlayerInBattle(Player p) {
            for (ThachDau battle : battles) {
                if ((battle.pl_1 != null && battle.pl_1.equals(p)) || (battle.pl_2 != null && battle.pl_2.equals(p))) {
                    return true;
                }
            }
            return false;
        }
    }
}
