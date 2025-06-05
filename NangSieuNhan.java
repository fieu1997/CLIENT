package Helps;

import core.Manager;
import core.MenuController;
import core.Service;
import core.Util;
import io.Message;
import io.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import template.Item3;
import template.ItemTemplate3;
import template.ItemTemplate7;
import template.Option;

public class NangSieuNhan {

    public static final int[] quantity_update_armor = new int[]{1000, 2000, 4000, 8000, 300, 600, 900, 1200, 1500, 2000};
    public static final short[] material_update_armor = new short[]{481, 481, 481, 481, 485, 485, 485, 489, 489, 489};
    public static final short[] gems_update_armor = new short[]{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
    public static short[] ratio_upgrade_armor = new short[]{11000, 10000, 9000, 8000, 5000, 4000, 3500, 3000, 2500, 2000};
    public static byte[] option1 = new byte[]{(byte) 171, (byte) 173, (byte) 175, 99, 91, 92, 93, 94, 27, 28, 29, 30};
    public static byte[] option2 = new byte[]{(byte) 185, (byte) 186, 89, 38, 37, 23, 24, 25, 26};

    public static void NangSieuNhan(Session conn, Message m) {
        try {
            boolean admin = conn.ac_admin >= 10;
            if (!admin && conn.p.time_speed_rebuild > System.currentTimeMillis()) {
                Service.send_notice_box(conn, "Thao tác quá nhanh.");
                return;
            }
            conn.p.time_speed_rebuild = System.currentTimeMillis() + 2000;

            byte type = m.reader().readByte();
            short id = -1;
            byte cat = -1;
            if (type != 3) {
                id = m.reader().readShort();
                cat = m.reader().readByte();
            } else {
                if (conn.p.type_sieunhan_create == -1 || conn.p.id_sieunhan_create == -1) {
                    return;
                }
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
                    if (item != null) {
                        if (item.type == 28) {
                            if (item.tier < 10) {

                                Message m_send = new Message(-105);
                                m_send.writer().writeByte(4);
                                m_send.writer().writeByte(1);
                                short id_material = (short) (material_update_armor[item.tier] + item.id - 4784);
                                m_send.writer().writeShort(id_material);
                                if (conn.version >= 270) {
                                    m_send.writer().writeShort(100);
                                } else {
                                    m_send.writer().writeByte(100);
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
                        Service.send_notice_box(conn, "Vui lòng chọn giáp siêu nhân để nâng cấp");
                    }
                    break;
                }
                case 3: {// tạo trang bị

                    int id_material = 481 + conn.p.id_sieunhan_create;
                    if (!admin && conn.p.item.total_item_by_id(7, id_material) < 100) {
                        conn.p.type_sieunhan_create = -1;
                        conn.p.id_sieunhan_create = -1;
                        conn.p.isSieuNhan = false;
                        Service.send_notice_box(conn, "Không đủ nguyên liệu");
                        return;
                    }
                    if (!admin && conn.p.get_vang() < 2000000) {
                        conn.p.type_sieunhan_create = -1;
                        conn.p.id_sieunhan_create = -1;
                        conn.p.isSieuNhan = false;
                        Service.send_notice_box(conn, "Không đủ 2,000,000 vàng");
                        return;
                    }

                    Item3 itbag = new Item3();
                    short iditem = (short) (4784 + conn.p.id_sieunhan_create);
                    ItemTemplate3 temp = ItemTemplate3.item.get(iditem);
                    itbag.id = iditem;
                    itbag.name = temp.getName();
                    itbag.clazz = temp.getClazz();
                    itbag.type = temp.getType();
                    itbag.level = temp.getLevel();
                    itbag.icon = temp.getIcon();
                    itbag.op = new ArrayList<>();

                    itbag.op.add(new Option(Util.ngaunhien(7, 11), 1000, itbag.id));
                    itbag.op.add(new Option(15, 100, itbag.id));
                    itbag.op.add(new Option(17 + conn.p.type_sieunhan_create, 100, itbag.id));
                    itbag.op.add(new Option(96, 5, itbag.id));

                    itbag.color = temp.getColor();
                    itbag.part = temp.getPart();
                    itbag.tier = 0;
                    itbag.islock = false;
                    itbag.time_use = 0;
                    itbag.expiry_date = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(7);
                    conn.p.type_sieunhan_create = -1;
                    conn.p.id_sieunhan_create = -1;
                    conn.p.isSieuNhan = false;

                    m.cleanup();
                    conn.p.item.char_inventory(3);
                    m = new Message(-105);
                    m.writer().writeByte(3);
                    m.writer().writeByte(3);
                    m.writer().writeUTF("Chúc mừng bạn đã nhận được " + temp.getName());
                    m.writer().writeByte(3);
                    m.writer().writeUTF(temp.getName());
                    m.writer().writeByte(temp.getClazz());
                    m.writer().writeShort(temp.getId());
                    m.writer().writeByte(temp.getType());
                    m.writer().writeShort(temp.getIcon());
                    m.writer().writeByte(0); // tier
                    m.writer().writeShort(1); // level required
                    m.writer().writeByte(temp.getColor()); // color
                    m.writer().writeByte(0); // can sell
                    m.writer().writeByte(0); // can trade
                    m.writer().writeByte(temp.getOp().size());
                    for (int i = 0; i < temp.getOp().size(); i++) {
                        m.writer().writeByte(temp.getOp().get(i).id);
                        m.writer().writeInt(temp.getOp().get(i).getParam(0));
                    }
                    m.writer().writeInt(0); // time use
                    m.writer().writeByte(0);
                    m.writer().writeByte(0);
                    m.writer().writeByte(0);
                    conn.addmsg(m);
                    m.cleanup();
                    conn.p.update_vang(-2000000);
                    conn.p.item.remove(7, id_material, 100);

                    break;
                }
                case 4: { // nâng cấp

                    if (cat != 3) {
                        return;
                    }
                    if (id >= conn.p.item.bag3.length) {
                        return;
                    }
                    Item3 item = conn.p.item.bag3[id];
                    if (item != null && item.type == 28 && item.tier < 10) {
                        short id_material = (short) (material_update_armor[item.tier] + item.id - 4784);
                        System.out.println(id_material);
                        //int quantity = quantity_update_armor[item.tier];
                        int quantity = 100; // sl
                        int gems = gems_update_armor[item.tier];

                        if (conn.p.get_ngoc() < gems) {
                            Service.send_notice_box(conn, "Không đủ " + gems + " ngọc");
                            return;
                        }
                        if (conn.p.item.total_item_by_id(7, id_material) >= quantity || admin) {
                            boolean suc = ratio_upgrade_armor[item.tier] > Util.random(11000);
                            conn.p.update_ngoc(-gems);
                            if (suc) {
                                item.tier++;

                                Option option96 = null;
                                for (int i = 0; i < item.op.size(); i++) {
                                    if (item.op.get(i).id == 96) {
                                        option96 = item.op.get(i);
                                        break;
                                    }
                                }

                                if (option96 != null && option96.param > 0) {
                                    List<Short> danhsach_id = new ArrayList<>();

                                    int param = 0;
                                    for (short i = 0; i <= 6; i++) {
                                        danhsach_id.add(i);
                                        param = Util.ngaunhien(100, 200);
                                    }
                                    for (short i = 7; i <= 11; i++) {
                                        danhsach_id.add(i);
                                        param = Util.ngaunhien(300, 500);
                                    }
                                    for (short i = 15; i <= 19; i++) {
                                        danhsach_id.add(i);
                                        param = Util.ngaunhien(500, 700);
                                    }
                                    short[] mang_ds = new short[danhsach_id.size()];
                                    for (int i = 0; i < danhsach_id.size(); i++) {
                                        mang_ds[i] = danhsach_id.get(i);
                                    }

                                    // ngẫu nhiên 1 id trong mảng
                                    int randomIndex = Util.ngaunhien(0, mang_ds.length - 1);
                                    short id_ = mang_ds[randomIndex];

                                    item.op.add(new Option(id_, param, item.id));
                                    option96.param -= 1;
                                    if (option96.param <= 0) {
                                        item.op.remove(option96);
                                    }
                                }

                                conn.p.item.remove(7, id_material, quantity);
                                conn.p.item.bag3[id] = item;
                            } else {
                                if (item.tier < 4) {
                                    conn.p.item.remove(7, id_material, quantity);
                                } else if (item.tier < 8) {
                                    conn.p.item.remove(7, id_material, (quantity / 2));
                                } else if (item.tier < 10) {
                                    conn.p.item.remove(7, id_material, (quantity / 3));
                                }
                            }

                            m.cleanup();
                            m = new Message(-105);
                            m.writer().writeByte(3);
                            if (suc) {
                                m.writer().writeByte(3);
                            } else {
                                m.writer().writeByte(4);
                            }
                            ItemTemplate3 temp = ItemTemplate3.item.get(item.id);
                            if (suc) {
                                m.writer().writeUTF("Thành công!");
                            } else {
                                m.writer().writeUTF("Thất bại!");
                            }
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
                            //
                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.item.char_inventory(3);

                            m = new Message(-105);
                            m.writer().writeByte(5);
                            if (suc) {
                                m.writer().writeByte(3);
                            } else {
                                m.writer().writeByte(4);
                            }
                            if (suc) {
                                m.writer().writeUTF("Thành công!");
                            } else {
                                m.writer().writeUTF("Thất bại!");
                            }
                            m.writer().writeShort(id);
                            conn.addmsg(m);
                            m.cleanup();

                        } else {
                            Service.send_notice_box(conn, "Không đủ nguyên liệu");
                        }
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
