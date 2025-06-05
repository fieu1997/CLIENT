package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import core.Service;
import io.Message;

public class Party {

    private List<Player> mems;
    Player leader;  // Trưởng nhóm
    

public Party(Player leader) {
    this.mems = new ArrayList<>();
    this.leader = leader;  // Đặt trưởng nhóm
    this.mems.add(leader);  // Thêm leader vào danh sách thành viên
}
public Player getLeader() {
    return this.leader;
}


    public void sendin4() throws IOException {
        synchronized (mems) {
            Message m = new Message(48);
            m.writer().writeByte(2);
            m.writer().writeByte(mems.size());
            for (int i = 0; i < mems.size(); i++) {
                m.writer().writeUTF(mems.get(i).name);
                m.writer().writeShort(mems.get(i).level);
//				if (mems.get(i).dungeon != null) {
//					m.writer().writeByte(48);
//					m.writer().writeByte(0);
//				} else {
                m.writer().writeByte(mems.get(i).map.map_id);
                m.writer().writeByte(mems.get(i).map.zone_id);
//				}
            }
            for (Player p1 : mems) {
                p1.conn.addmsg(m);
            }
            m.cleanup();
        }
    }

    public void send_txt_notice(String text) throws IOException {
        synchronized (mems) {
            for (Player p1 : mems) {
                Service.send_notice_nobox_white(p1.conn, text);
            }
        }
    }

    public List<Player> get_mems() {
        return this.mems;
    }

    public synchronized void add_mems(Player p) {
    if (!this.mems.contains(p)) {
        this.mems.add(p);
    }
}


    public synchronized void remove_mems(Player p) {
    this.mems.remove(p);
    if (p == this.leader && !this.mems.isEmpty()) {
        this.leader = this.mems.get(0);  // Chọn thành viên đầu tiên còn lại làm leader mới
    }
}

}
