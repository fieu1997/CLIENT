package Helps;

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

public class NangSc {

    public static short[] ratio_upgrade_armor = new short[]{11000, 10000, 9000, 8000, 5000, 4000, 3500, 3000, 2500, 2000, 1500, 1200, 1000, 800, 600, /**/ 5500, 4400, 3300, 2200, 1100, 990, 880, 770, 660, 550, 440, 330, 220, 200, 110};

    public static void ActionSieuCap(Session conn, Message m) throws IOException {
    if (conn.p.time_speed_rebuild > System.currentTimeMillis()) {
        Service.send_notice_box(conn, "Chậm thôi!");
        return;
    }
    conn.p.time_speed_rebuild = System.currentTimeMillis() + 1000;
    byte type = m.reader().readByte();
    short id = -1;
    byte cat = -1;
    try {
        id = m.reader().readShort();
        cat = m.reader().readByte();
    } catch (IOException e) {
    }
    switch (type) {
        case 0: {
            if (cat != 3) {
                Service.send_notice_box(conn, "Trang bị không phù hợp!");
                return;
            }
            if (id >= conn.p.item.bag3.length) {
                return;
            }
            Item3 item = conn.p.item.bag3[id];
            if (item == null || item.tier < 15 || item.color < 4) {
                Service.send_notice_box(conn, "Mề Đay Cam + 15 trở Lên!");
                return;
            }
            if (item != null) {
                if (item.type == 16) {
                    if (item.tier < 30) {

                        Message m_send = new Message(-105);
                        m_send.writer().writeByte(4);
                        m_send.writer().writeByte(5);
                        for (short nl : conn.p.NLsieucap) {
                            m_send.writer().writeShort(nl);
                            //m_send.writer().writeByte(10);
                              if (conn.version >= 270) {
                          m_send.writer().writeShort(10);
                         }else{
                           m_send.writer().writeByte(10);
                          }
                        }
                        conn.addmsg(m_send);
                        m_send.cleanup();
                    } else {
                        Service.send_notice_box(conn, "Trang bị đã nâng tối đa");
                    }
                } else {
                    Service.send_notice_box(conn, "Vật phẩm không phù hợp");
                }
            } else {
                Service.send_notice_box(conn, "Vui lòng chọn Mề Đay để Nâng Cấp");
            }
            break;
        }
        case 4: {
    if (cat != 3) {
        return;
    }
    if (id >= conn.p.item.bag3.length) {
        return;
    }
    Item3 item = conn.p.item.bag3[id];

    if (item == null || item.tier < 15 || item.color < 4) {
        Service.send_notice_box(conn, "Mề Đay Cam + 15 trở Lên!");
        return;
    }

    if (item != null && item.type == 16 && item.tier < 30) {
        // Kiểm tra số lượng nguyên liệu
        for (int i = 0; i < 5; i++) {
            if (i < conn.p.NLsieucap.length) {
                int itemCount = conn.p.item.total_item_by_id(7, conn.p.NLsieucap[i]);
                if (itemCount < 10 && (conn.ac_admin < 4 || !Manager.BuffAdminMaterial)) {
                    Service.send_notice_box(conn, "Không đủ " + ItemTemplate7.item.get(conn.p.NLsieucap[i]).getName() + " (" + itemCount + "/10)!");
                    return;
                }
            }
        }

        // Nếu đủ nguyên liệu, tiến hành trừ
        for (int i = 0; i < 5; i++) {
            if (i < conn.p.NLsieucap.length) {
                conn.p.item.remove(7, conn.p.NLsieucap[i], 10);
            }
        }

        // Xác suất thành công
        boolean suc = Util.random(11000) < ratio_upgrade_armor[item.tier - 15] || (conn.ac_admin > 3 && Manager.BuffAdmin);

        if (suc) {
            item = Helps.medal.Upgare_Medal(item);
            item.color = 5;
            item.tier++;
            item.icon = 13188;
            item.UpdateName();
            conn.p.SetNLsieucap();
        }
                m.cleanup();
                m = new Message(-105);
                m.writer().writeByte(3);
                if (suc) {
                    m.writer().writeByte(3);
                    m.writer().writeUTF("Thành công!");
                } else {
                    m.writer().writeByte(4);
                    m.writer().writeUTF("Thất bại!");
                }
                // Record information about the upgraded equipment
                ItemTemplate3 temp = ItemTemplate3.item.get(item.id);
                m.writer().writeByte(3);
                m.writer().writeUTF(item.name);
                m.writer().writeByte(temp.getClazz());
                m.writer().writeShort(temp.getId());
                m.writer().writeByte(temp.getType());
                m.writer().writeShort(temp.getIcon());
                m.writer().writeByte(item.tier); // tier
                m.writer().writeShort(1); // level required
                m.writer().writeByte(item.color); // color
                m.writer().writeByte(0); // can sell
                m.writer().writeByte(0); // can trade
                m.writer().writeByte(item.op.size());
                for (int i = 0; i < item.op.size(); i++) {
                    m.writer().writeByte(item.op.get(i).id);
                    m.writer().writeInt(item.op.get(i).getParam(item.tier));
                }
                m.writer().writeInt(0); // time use
                m.writer().writeByte(0);
                m.writer().writeByte(0);
                m.writer().writeByte(0);
                conn.addmsg(m);
                m.cleanup();

                // Update character inventory
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);

                // Send upgrade result notice
                m = new Message(-105);
                m.writer().writeByte(5);
                if (suc) {
                    m.writer().writeByte(3);
                    m.writer().writeUTF("Thành công!");
                } else {
                    m.writer().writeByte(4);
                    m.writer().writeUTF("Thất bại!");
                }
                m.writer().writeShort(id);
                conn.addmsg(m);
                m.cleanup();
            } else {
                Service.send_notice_box(conn, "Trang Bị đã đạt cấp tối đa!");
            }
            break;
}
        
        
        ///
    }
}

}
