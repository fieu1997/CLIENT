package Helps;

import client.Player;
import core.Manager;
import core.MenuController;
import core.Service;
import core.Util;
import io.Message;
import io.Session;
import java.io.IOException;
import java.util.List;
import template.Item3;
import template.ItemTemplate3;
import template.ItemTemplate7;
import template.Option;
import template.Part_fashion;

public class HopDo {

    public static short[] ratio_upgrade_armor = new short[]{11000, 10000, 9000, 8000, 5000, 4000, 3500, 3000, 2500, 2000, 1500, 1200, 1000, 800, 600, /**/ 5500, 4400, 3300, 2200, 1100, 990, 880, 770, 660, 550, 440, 330, 220, 200, 110};

    public static void hop_trang_bi(Player p, Message m2) throws IOException {
    byte type = m2.reader().readByte();
    short id = m2.reader().readShort();
    if (type == 0) {
        if (p.item.bag3[id] != null && Part_fashion.fashions.contains(p.item.bag3[id].id)) {
            Service.send_notice_box(p.conn, "Trang bị không phù hợp!");
            return;
        }
        if (p.item_replace == -1) {
            if (p.item.bag3[id] != null && Helps.CheckItem.isMeDay(p.item.bag3[id].id)) {
                Service.send_notice_box(p.conn, "Trang bị không phù hợp!");
                return;
            }
            p.item_replace = id;
        } else if (p.item_replace2 == -1) {
            if (p.item.bag3[id].isHopdo == 1) { // Kiểm tra nếu trang bị đã bị khóa (chỉ định đã chuyển hóa)
                Service.send_notice_box(p.conn, "Trang bị đã được chuyển hóa, không thể chuyển hóa lần 2!");
                return;
            }
            p.item_replace2 = id;
        } else {
            Service.send_notice_box(p.conn, "Lỗi, hãy thử lại");
            return;
        }
        Message m = new Message(73);
        m.writer().writeByte(0);
        m.writer().writeShort(id);
        if (p.item_replace2 == -1) {
            m.writer().writeByte(1);
        } else {
            m.writer().writeByte(0);
        }
        p.conn.addmsg(m);
        m.cleanup();
    } else if (type == 1) {
        if (p.item.bag3[p.item_replace].tier < p.item.bag3[p.item_replace2].tier) {
            Service.send_notice_box(p.conn, "Đã chuyển hóa xong rồi!!");
            return;
        }
        if (!p.item.bag3[p.item_replace2].islock) {
            p.item.bag3[p.item_replace2].islock = true;
            p.item.bag3[p.item_replace2].name
                    = ItemTemplate3.item.get(p.item.bag3[p.item_replace2].id).getName() + " [Khóa]";
            p.item.bag3[p.item_replace2].UpdateName();
            p.item.char_inventory(4);
            p.item.char_inventory(7);
            p.item.char_inventory(3);
        }
        int fee = 100 * p.item.bag3[p.item_replace].tier;
        Service.send_box_input_yesno(p.conn, 123,
                "Chuyển hóa sẽ mất phí " + fee + " ngọc, bạn có chắc chắn muốn chuyển hóa?");
    }
}


}
