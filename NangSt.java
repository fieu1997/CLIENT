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
import template.ItemTemplate7;
import template.Option;

public class NangSt {
    public static short[] Ratio_UpgradeItemStar = new short[]{7500, 5500, 4500, 3500, 2500, 2000, 1500, 3000, 1000,/**/ 5500, 3500, 2500, 1350, 1300, 1250, 1200, 1150, 1100};

    public static void ActionSieuThan(Session conn, Message m) throws IOException {
        if (conn.p.time_speed_rebuild > System.currentTimeMillis()) {
            Service.send_notice_box(conn, "Chậm thôi!");
            return;
        }
        conn.p.time_speed_rebuild = System.currentTimeMillis() + 2000;
        byte type = m.reader().readByte();
        short id = -1;
        byte tem = -1;
        try {
            id = m.reader().readShort();
            tem = m.reader().readByte();
        } catch (IOException e) {
        }
        switch (type) {
            case 0: {
                if (tem != 3) {
                    Service.send_notice_box(conn, "Trang bị không phù hợp!");
                    return;
                }
                if (id >= conn.p.item.bag3.length) {
                    return;
                }
                Item3 temp = conn.p.item.bag3[id];
                if (!(temp.id >= 4656 && temp.id <= 4675)) {
                    Service.send_notice_box(conn, "Trang bị không phù hợp!");
                    return;
                }
                if (temp.tierStar < 9) { 
                    Service.send_notice_box(conn, "Trang bị Tinh Tú Cấp 9 trở lên!");
                    return;
                }
                if (temp != null
                        && (temp.id >= 4656 && temp.id <= 4675)
                        && temp.tierStar < 18) {
                    conn.p.TypeItemStarCreate = Helps.ItemStar.ConvertType(temp.type);
                    Message m_send = new Message(-105);
                    m_send.writer().writeByte(4);
                    m_send.writer().writeByte(5);
                    if (conn.p.NLsieuthan == null || conn.p.NLsieuthan.length < 5) {
                        conn.p.SetNLsieuthan();
                    }
                    for (int i = conn.p.TypeItemStarCreate * 5; i < conn.p.TypeItemStarCreate * 5 + 5; i++) {
                        m_send.writer().writeShort(conn.p.NLsieuthan[i]);
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
                    Service.send_notice_box(conn, "Lỗi hãy thử lại!");
                }
                conn.p.time_speed_rebuild = 0;
                break;
            }
            
            case 4: { // nâng cấp tbtt
                if (id >= conn.p.item.bag3.length || id < 0) {
                    return;
                }
                Item3 temp = conn.p.item.bag3[id];
                if (temp == null || !(temp.id >= 4656 && temp.id <= 4675)) {
                    Service.send_notice_box(conn, "Trang bị không phù hợp!");
                    return;
                }
                if (temp.tierStar < 9) { 
                    Service.send_notice_box(conn, "Trang bị Tinh Tú Cấp 9 trở lên!");
                    return;
                }
                for (int i = conn.p.TypeItemStarCreate * 5; i < conn.p.TypeItemStarCreate * 5 + 5; i++) {
                    if (conn.p.item.total_item_by_id(7, conn.p.NLsieuthan[i]) < 10 && (conn.ac_admin < 4 || !Manager.BuffAdminMaterial)) {
                        Service.send_notice_box(conn, "Không đủ " + ItemTemplate7.item.get(conn.p.NLsieuthan[i]).getName() + "!");
                        return;
                    }
                }

                if (temp.tierStar >= Ratio_UpgradeItemStar.length) {
                    Service.send_notice_box(conn, "Trang bị đã đạt cấp tối đa!");
                    return;
                }
                
                boolean suc = Ratio_UpgradeItemStar[temp.tierStar] + (tem == 1 ? 500 : 0) > Util.random(10000) || (conn.ac_admin > 3 && Manager.BuffAdmin);
                if (suc) {
                    for (int i = 0; i < temp.op.size(); i++) {
                        Option op = temp.op.get(i);
                        if (op.id >= 0 && op.id <= 99) {
                            op.setParam(op.getParamSt(4));
                        }
                        if (op != null && op.id >= -128 && op.id <= -80 || (op.id == 99)) {
                            op.setParam(op.getParamSt(0) + 100);
                        }
                    }
                    conn.p.SetNLsieuthan();
                    temp.tierStar++;
                    temp.UpdateName();
                    
                }
                // xóa nl
                for (int i = conn.p.TypeItemStarCreate * 5; i < conn.p.TypeItemStarCreate * 5 + 5; i++)
                    conn.p.item.remove(7, conn.p.NLsieuthan[i], 10);
                if (tem == 1)
                    conn.p.item.remove(7, 471, 1);
                if (suc && (temp.tierStar + 1) % 3 == 0)
                    conn.p.ChangeMaterialItemStar(conn.p.TypeItemStarCreate);
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);
                Message m_send = new Message(-105);
                m_send.writer().writeByte(3);
                if (suc) {
                    m_send.writer().writeByte(3);
                    m_send.writer().writeUTF("Thành công!");
                } else {
                    m_send.writer().writeByte(4);
                    m_send.writer().writeUTF("Thất bại!");
                }
                m_send.writer().writeByte(3);
                m_send.writer().writeUTF(temp.name);
                m_send.writer().writeByte(temp.clazz);
                m_send.writer().writeShort(temp.id);
                m_send.writer().writeByte(temp.type);
                m_send.writer().writeShort(temp.icon);
                m_send.writer().writeByte(temp.tier); // tier
                m_send.writer().writeShort(1); // level required
                m_send.writer().writeByte(temp.color); // color
                m_send.writer().writeByte(0); // can sell
                m_send.writer().writeByte(0); // can trade
                m_send.writer().writeByte(temp.op.size());
                for (int i = 0; i < temp.op.size(); i++) {
                    m_send.writer().writeByte(temp.op.get(i).id);
                    m_send.writer().writeInt(temp.op.get(i).getParam(0));
                }
                m_send.writer().writeInt(0); // time use
                m_send.writer().writeByte(0);
                m_send.writer().writeByte(0);
                m_send.writer().writeByte(0);
                conn.addmsg(m_send);
                m_send.cleanup();
                if (temp.tierStar < 18) {
                    m_send = new Message(-105);
                    m_send.writer().writeByte(5);
                    if (suc) {
                        m_send.writer().writeByte(3);
                        m_send.writer().writeUTF("Thành công, xin chúc mừng :)");
                    } else {
                        m_send.writer().writeByte(4);
                        m_send.writer().writeUTF("Thất bại rồi :(");
                    }
                    m_send.writer().writeShort(id);
                    conn.addmsg(m_send);
                    m_send.cleanup();
                }

                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng!");
                return;
            }
        }
    }
}
