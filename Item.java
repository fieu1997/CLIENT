package client;

import java.io.IOException;
import java.util.List;
import core.Service;
import io.Message;
import io.Session;
import java.util.ArrayList;
import template.Item3;
import template.Item47;
import template.Item5;
import template.ItemTemplate3;
import template.TaskTemplate;

public class Item {

    private Player p;
    public Item3[] bag3;
    public Item3[] box3;
    public Item3[] tui3;
    public Item3[] wear;
    public List<Item47> bag47;
    public List<Item47> box47;
    public List<Item47> tui47;
    public List<Item5> bag5;
    public List<Item5> box5;

    public Item(Player player) {
        this.p = player;
    }

    public void char_inventory(int type) throws IOException {
        switch (type) {
            case 3: {
                Item.send_inventory(p.conn, p);
                break;
            }
            case 5: {
                if (!p.isOwner) {
                    Message m = new Message(16);
                    m.writer().writeByte(0);
                    m.writer().writeByte(5);
                    m.writer().writeLong(p.get_vang());
                    m.writer().writeInt(p.get_ngoc());
                    m.writer().writeByte(5);
                    m.writer().writeByte(0); // size item quest
                    p.conn.addmsg(m);
                    m.cleanup();
                } else {
                    Message m = new Message(16);
                    m.writer().writeByte(0);
                    m.writer().writeByte(type);
                    m.writer().writeLong(p.get_vang());
                    m.writer().writeInt(p.get_ngoc());
                    m.writer().writeByte(type);
                    m.writer().writeByte(bag5.size());
                    for (int i = 0; i < bag5.size(); i++) {
                        Item5 temp = bag5.get(i);
                        if (temp == null) {
                            continue;
                        }
                        m.writer().writeShort(temp.ID);
                        m.writer().writeUTF(temp.name);
                        m.writer().writeShort(temp.quantity);
                        m.writer().writeByte(0); // can sell
                        m.writer().writeByte(0); // can trade
                    }
                    p.conn.addmsg(m);
                    m.cleanup();
                }
                break;
            }
            case 4:
            case 7: {
                Message m = new Message(16);
                m.writer().writeByte(0);
                m.writer().writeByte(type);
                m.writer().writeLong(p.get_vang());
                m.writer().writeInt(p.get_ngoc());
                m.writer().writeByte(type);
                m.writer().writeByte(total_item_by_type(type));
                for (int i = 0; i < bag47.size(); i++) {
                    Item47 temp = bag47.get(i);
                    if (temp == null) {
                        continue;
                    }
                    if (temp.category == type) {
                        m.writer().writeShort(temp.id);
                        m.writer().writeShort(temp.quantity);
                        m.writer().writeByte(1);
                        m.writer().writeByte(0);
                    }
                }
                p.conn.addmsg(m);
                m.cleanup();
                break;
            }
        }
    }

    public static void send_inventory(Session conn, Player p) throws IOException {
        Message m = new Message(16);
        m.writer().writeByte(0);
        m.writer().writeByte(3);
        m.writer().writeLong(p.get_vang());
        m.writer().writeInt(p.get_ngoc());
        m.writer().writeByte(3);

        // Hiển thị thông tin của bag3
        m.writer().writeByte(p.item.bag3.length);
        for (int i = 0; i < p.item.bag3.length; i++) {
            Item3 temp = p.item.bag3[i];
            if (temp != null) {
                m.writer().writeUTF(temp.name);
                m.writer().writeByte(temp.clazz); // item clazz
                m.writer().writeShort(i); // id : index
                m.writer().writeByte(temp.type); // type only
                m.writer().writeShort(temp.icon); // idicon
                m.writer().writeByte(temp.tier); // tier
                m.writer().writeShort(temp.level); // level
                m.writer().writeByte(temp.color); // color name
                m.writer().writeByte(1); // can sell
                m.writer().writeByte(temp.islock ? 0 : 1); // can trade
                m.writer().writeByte(temp.op.size()); // size
                for (int j = 0; j < temp.op.size(); j++) {
                    m.writer().writeByte(temp.op.get(j).id);
                    m.writer().writeInt(temp.op.get(j).getParam(temp.tier));
                }

                // Kiểm tra thời gian sử dụng và thời gian hết hạn
                if (temp.time_use != 0) {
                    long time_use = temp.time_use - System.currentTimeMillis();
                    time_use /= 60_000;
                    m.writer().writeInt((int) ((time_use > 0) ? time_use : 1)); // time use
                } else {
                    m.writer().writeInt(0); // time use
                }

                m.writer().writeByte(temp.islock ? (byte) 1 : (byte) 0); // islock

                if (temp.expiry_date <= 0) {
                    m.writer().writeByte(0); // b10
                } else {
                    m.writer().writeByte(1);
                    m.writer().writeInt(0);
                    m.writer().writeUTF("" + temp.expiry_date);
                }

                m.writer().writeByte(0); // canShell_notCanTrade
            }
        }

        conn.addmsg(m);
        m.cleanup();
    }

    public void char_chest(int type) throws IOException {
        switch (type) {
            case 3: {
                Message m = new Message(65);
                m.writer().writeByte((byte) p.maxbox);
                m.writer().writeByte(0);
                m.writer().writeByte(3);
                m.writer().writeByte(3);
                m.writer().writeByte(total_item_by_type_box(3));
                for (int i = 0; i < box3.length; i++) {
                    Item3 temp = box3[i];
                    if (temp != null) {
                        m.writer().writeUTF(temp.name);
                        m.writer().writeByte(temp.clazz); // item clazz
                        m.writer().writeShort(i); // id : index
                        m.writer().writeByte(temp.type); // type only
                        m.writer().writeShort(temp.icon); // idicon
                        m.writer().writeByte(temp.tier); // tier
                        m.writer().writeShort(temp.level); // level
                        m.writer().writeByte(temp.color); // color name
                        m.writer().writeByte(1); // can sell
                        m.writer().writeByte(temp.islock ? 0 : 1); // can trade
                        m.writer().writeByte(temp.op.size()); // size
                        for (int j = 0; j < temp.op.size(); j++) {
                            m.writer().writeByte(temp.op.get(j).id);
                            m.writer().writeInt(temp.op.get(j).getParam(temp.tier));
                        }
                        if (temp.time_use != 0) {
                            long time_use = temp.time_use - System.currentTimeMillis();
                            time_use /= 3_600_000;
                            m.writer().writeInt((int) ((time_use > 0) ? time_use : 1)); // time use
                        } else {
                            m.writer().writeInt(0); // time use
                        }
                        m.writer().writeByte(temp.islock ? (byte) 1 : (byte) 0); // islock
                        if (temp.expiry_date <= 0) {
                            m.writer().writeByte(0); // b10
                        } else {
                            m.writer().writeByte(1);
                            m.writer().writeInt(0);
                            m.writer().writeUTF("" + temp.expiry_date);
                        }
                        m.writer().writeByte(0); // canShell_notCanTrade
                    }
                }
                p.conn.addmsg(m);
                m.cleanup();
                break;
            }
            case 4:
            case 7: {
                Message m = new Message(65);
                m.writer().writeByte((byte) p.maxbox);
                m.writer().writeByte(0);
                m.writer().writeByte(type);
                m.writer().writeByte(type);
                m.writer().writeByte(total_item_by_type_box(type));
                for (int i = 0; i < box47.size(); i++) {
                    Item47 temp = box47.get(i);
                    if (temp == null) {
                        continue;
                    }
                    if (temp.category == type) {
                        m.writer().writeShort(temp.id);
                        m.writer().writeShort(temp.quantity);
                        m.writer().writeByte(1);
                        m.writer().writeByte(0);
                    }
                }
                p.conn.addmsg(m);
                m.cleanup();
                break;
            }
        }
    }

    private int total_item_by_type(int type) {
        int quantity = 0;
        switch (type) {
            case 3: {
                for (int i = 0; i < bag3.length; i++) {
                    if (bag3[i] != null) {
                        quantity++;
                    }
                }
                break;
            }
            case 4:
            case 7: {
                for (int i = 0; i < bag47.size(); i++) {
                    Item47 temp = bag47.get(i);
                    if (temp != null && temp.category == type) {
                        quantity++;
                    }
                }
                break;
            }
            case 5: {
                for (Item5 temp : bag5) {
                    if (temp != null && temp.quantity > 0) {
                        quantity++;
                    }
                }
                break;
            }
        }
        return quantity;
    }

    private int total_item_by_type_box(int type) {
        int quantity = 0;
        switch (type) {
            case 3: {
                for (int i = 0; i < box3.length; i++) {
                    if (box3[i] != null) {
                        quantity++;
                    }
                }
                break;
            }
            case 4:
            case 7: {
                for (int i = 0; i < box47.size(); i++) {
                    Item47 temp = box47.get(i);
                    if (temp != null && temp.category == type) {
                        quantity++;
                    }
                }
                break;
            }
        }
        return quantity;
    }

    public int get_bag_able() {
        int totalItems = total_item_by_type(3) + total_item_by_type(4) + 
                         total_item_by_type(7) + total_item_by_type(5);
        return p.maxbag - totalItems;
    }

    // public int get_box_able() {
        // int totalItems = total_item_by_type_box(3) + total_item_by_type_box(4) + 
                         // total_item_by_type_box(7);
        // return p.maxbox - totalItems;
    // }
    
    public int get_box_able() {
        return (p.maxbox - (total_item_by_type_tui(3) + total_item_by_type_tui(4) + total_item_by_type_tui(7)));
    }

    public void add_item_bag47(int type, Item47 item) {
        Item47 temp = new Item47(item);
        temp.category = (byte) type;
        switch (type) {
            case 4:
            case 7: {
                int size = temp.quantity;
                if (size > 0) {
                    for (int i = bag47.size() - 1; i >= 0; i--) {
                        Item47 t = bag47.get(i);
                        if (t == null) {
                            continue;
                        }
                        if (t.category == type && t.id == temp.id) {
                            size += t.quantity;
                            bag47.remove(i);
                        }
                    }
                    if (size > 32000) {
                        temp.quantity = 32000;
                    } else {
                        temp.quantity = (short) size;
                    }
                    bag47.add(temp);
                }
                break;
            }
        }
    }

    public void add_item_bag47(short id, short qt, byte cat) {
        Item47 temp = new Item47();
        temp.category = cat;
        temp.quantity = qt;
        temp.id = id;
        switch (cat) {
            case 4:
            case 7: {
                int size = temp.quantity;
                if (size > 0) {
                    for (int i = bag47.size() - 1; i >= 0; i--) {
                        Item47 t = bag47.get(i);
                        if (t == null) {
                            continue;
                        }
                        if (t.category == cat && t.id == id) {
                            size += t.quantity;
                            bag47.remove(i);
                        }
                    }
                    if (size > 32000) {
                        temp.quantity = 32000;
                    } else {
                        temp.quantity = (short) size;
                    }
                    bag47.add(temp);
                }
                break;
            }
        }
    }

    public int total_item_by_id(int type, int id) {
        int quantity = 0;
        switch (type) {
            case 3: {
                for (Item3 it : bag3) {
                    if (it != null && it.id == id) {
                        quantity += 1;
                    }
                }
                break;
            }
            case 4:
            case 7: {
                for (Item47 it : bag47) {
                    if (it != null && it.category == type && it.id == id) {
                        quantity += it.quantity;
                    }
                }
                break;
            }
        }
        return quantity;
    }

    public int total_item_by_id_box(int type, short id) {
        int quantity = 0;
        switch (type) {
            case 3: {
                for (Item3 it : box3) {
                    if (it != null && it.id == id) {
                        quantity += 1;
                    }
                }
                break;
            }
            case 4:
            case 7: {
                for (Item47 it : box47) {
                    if (it != null && it.category == type && it.id == id) {
                        quantity += it.quantity;
                    }
                }
                break;
            }
        }
        return quantity;
    }

    public void add_item_box47(int type, Item47 item) {
        Item47 temp = new Item47(item);
        temp.category = (byte) type;
        switch (type) {
            case 4:
            case 7: {
                int size = temp.quantity;
                if (size > 0) {
                    for (int i = box47.size() - 1; i >= 0; i--) {
                        Item47 t = box47.get(i);
                        if (t == null) {
                            continue;
                        }
                        if (t.category == type && t.id == temp.id) {
                            size += t.quantity;
                            box47.remove(i);
                        }
                    }
                    if (size > 32000) {
                        temp.quantity = 32000;
                    } else {
                        temp.quantity = (short) size;
                    }
                    box47.add(temp);
                }
                break;
            }
        }
    }

    public void add_item_box47(short id, short qt, byte cat) {
        Item47 temp = new Item47();
        temp.category = cat;
        temp.quantity = qt;
        temp.id = id;
        switch (cat) {
            case 4:
            case 7: {
                int size = temp.quantity;
                if (size > 0) {
                    for (int i = box47.size() - 1; i >= 0; i--) {
                        Item47 t = box47.get(i);
                        if (t == null) {
                            continue;
                        }
                        if (t.category == cat && t.id == id) {
                            size += t.quantity;
                            box47.remove(i);
                        }
                    }
                    if (size > 32000) {
                        temp.quantity = 32000;
                    } else {
                        temp.quantity = (short) size;
                    }
                    box47.add(temp);
                }
                break;
            }
        }
    }

    public void add_item_bag3(Item3 buffer) {
        for (int j = 0; j < bag3.length; j++) {
            if (bag3[j] == null) {
                bag3[j] = new Item3(buffer);
                break;
            }
        }
    }

    public void add_item_bag3_default(short it, int date, boolean isLock) {
        Item3 itbag = new Item3();
        itbag.id = it;
        itbag.name = ItemTemplate3.item.get(it).getName();
        itbag.clazz = ItemTemplate3.item.get(it).getClazz();
        itbag.type = ItemTemplate3.item.get(it).getType();
        itbag.level = ItemTemplate3.item.get(it).getLevel();
        itbag.icon = ItemTemplate3.item.get(it).getIcon();
        itbag.op = new ArrayList<>();
        itbag.op.addAll(ItemTemplate3.item.get(it).getOp());
        itbag.color = ItemTemplate3.item.get(it).getColor();
        itbag.part = ItemTemplate3.item.get(it).getPart();
        itbag.tier = 0;
        itbag.time_use = 0;
        itbag.islock = isLock;
        if (date > 0) {
            itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * date;
        }
        add_item_bag3(itbag);
    }

    public void add_item_box3(Item3 buffer) {
        for (int j = 0; j < box3.length; j++) {
            if (box3[j] == null) {
                box3[j] = new Item3(buffer);
                break;
            }
        }
    }

    public void remove(int type, int id, int quantity) throws IOException {
        switch (type) {
            case 3: {
                bag3[id] = null;
                break;
            }
            case 5: {
                for (int j = bag5.size() - 1; j >= 0; j--) {
                    Item5 it = bag5.get(j);
                    if (it == null) {
                        continue;
                    }
                    if (it.ID == id) {
                        it.quantity -= quantity;
                        bag5.remove(j);
                        break;
                    }
                }
                break;
            }
            case 4:
            case 7: {
                for (int j = bag47.size() - 1; j >= 0; j--) {
                    Item47 it = bag47.get(j);
                    if (it == null) {
                        continue;
                    }
                    if (it.category == type && it.id == id && quantity > 0) {
                        if (it.quantity > quantity) {
                            bag47.get(j).quantity -= quantity;
                            break;
                        } else {
                            quantity -= bag47.get(j).quantity;
                            bag47.remove(j);
                            continue;
                        }
                    }
                    if (bag47.get(j).quantity <= 0) {
                        bag47.remove(j);
                    }
                }
                break;
            }
        }
    }

    private void removeItem5(int id, int quantity, List<Item5> items) {
        System.out.println("Xóa Item5 - ID: " + id + ", Số lượng: " + quantity);
        for (int i = items.size() - 1; i >= 0; i--) {
            Item5 item = items.get(i);
            if (item != null && item.ID == id) {
                System.out.println("Tìm thấy Item5 - Số lượng hiện tại: " + item.quantity);
                if (item.quantity > quantity) {
                    item.quantity -= quantity;
                    System.out.println("Đã giảm số lượng Item5 còn lại: " + item.quantity);
                    break;
                } else {
                    quantity -= item.quantity;
                    items.remove(i);
                    System.out.println("Đã xóa hoàn toàn Item5. Số lượng còn lại cần xóa: " + quantity);
                    if (quantity <= 0) {
                        break;
                    }
                }
            }
        }
    }

    public void remove_box(int type, short id, int quantity) {
        switch (type) {
            case 3: {
                box3[id] = null;
                break;
            }
            case 4:
            case 7: {
                for (int j = box47.size() - 1; j >= 0; j--) {
                    Item47 it = box47.get(j);
                    if (it == null) {
                        continue;
                    }
                    if (it.category == type && it.id == id && quantity > 0) {
                        if (it.quantity > quantity) {
                            box47.get(j).quantity -= quantity;
                            break;
                        } else {
                            quantity -= box47.get(j).quantity;
                            box47.remove(j);
                            continue;
                        }
                    }
                    if (box47.get(j).quantity <= 0) {
                        box47.remove(j);
                    }
                }
                break;
            }
        }
    }

    public void box_process(Message m2) throws IOException {
        byte type = m2.reader().readByte();
        short id = m2.reader().readShort();
        byte tem = m2.reader().readByte();
        short num = m2.reader().readShort();
        if (num <= 0) {
            return;
        }
        if (type == -1) {
            char_chest(3);
            char_chest(4);
            char_chest(7);
            return;
        }
        if (type == 1) { // Cất vào rương
            if ((get_box_able() < 1 && tem == 3) || 
                (get_box_able() < 1 && tem == 4 && total_item_by_id_box(4, id) < 1) || 
                (get_box_able() < 1 && tem == 7 && total_item_by_id_box(7, id) < 1)) {
                Service.send_notice_box(p.conn, "Rương Đầy!");
                return;
            }
            switch (tem) {
                case 3: {
                    if (id < 0 || id >= bag3.length || bag3[id] == null) {
                        Service.send_notice_box(p.conn, "Vật phẩm không tồn tại!");
                        return;
                    }
                    add_item_box3(bag3[id]);
                    remove(3, id, 1);
                    break;
                }
                case 4:
                case 7: {
                    if ((total_item_by_id(tem, id) + total_item_by_id_box(tem, id)) > 32000) {
                        Service.send_notice_box(p.conn, "Số lượng tổng lớn hơn 32k, không thể thực hiện!");
                        return;
                    }
                    int available = total_item_by_id(tem, id);
                    if (num > available) {
                        num = (short) available;
                    }
                    Item47 itbuffer = new Item47();
                    itbuffer.id = id;
                    itbuffer.quantity = num;
                    itbuffer.category = tem;
                    add_item_box47(tem, itbuffer);
                    remove(tem, id, num);
                    break;
                }
            }
            char_inventory(tem);
            char_chest(tem);
        } else { // Lấy ra từ rương
            if ((get_bag_able() < 1 && tem == 3) || 
                (get_bag_able() < 1 && tem == 4 && total_item_by_id(4, id) < 1) || 
                (get_bag_able() < 1 && tem == 7 && total_item_by_id(7, id) < 1)) {
                Service.send_notice_box(p.conn, "Hành trang đầy!");
                return;
            }
            switch (tem) {
                case 3: {
                    if (id < 0 || id >= box3.length || box3[id] == null) {
                        Service.send_notice_box(p.conn, "Vật phẩm không tồn tại trong rương!");
                        return;
                    }
                    add_item_bag3(box3[id]);
                    remove_box(3, id, 1);
                    break;
                }
                case 4:
                case 7: {
                    if ((total_item_by_id(tem, id) + total_item_by_id_box(tem, id)) > 32000) {
                        Service.send_notice_box(p.conn, "Số lượng tổng lớn hơn 32k, không thể thực hiện!");
                        return;
                    }
                    int available = total_item_by_id_box(tem, id);
                    if (num > available) {
                        num = (short) available;
                    }
                    Item47 itbuffer = new Item47();
                    itbuffer.id = id;
                    itbuffer.quantity = num;
                    itbuffer.category = tem;
                    add_item_bag47(tem, itbuffer);
                    remove_box(tem, id, num);
                    break;
                }
            }
            char_inventory(tem);
            char_chest(tem);
        }
        // Đồng bộ dữ liệu nếu là Squire
        if (p instanceof Squire) {
            ((Squire) p).flushSquire();
        }
    }

    public short[] check_kham_ngoc(Item3 it3) {
        short[] result = new short[]{-2, -2, -2};
        for (int i = 0; i < it3.op.size(); i++) {
            if (it3.op.get(i).id == 58) {
                result[0] = (short) it3.op.get(i).getParam(0);
            } else if (it3.op.get(i).id == 59) {
                result[1] = (short) it3.op.get(i).getParam(0);
            } else if (it3.op.get(i).id == 60) {
                result[2] = (short) it3.op.get(i).getParam(0);
            }
        }
        return result;
    }

    public int total_item_book(int color, int id) {
        int quantity = 0;
        for (Item3 it : bag3) {
            if (it != null && it.color == color && it.id == id && it.hasOption((byte) 61)) {
                quantity++;
            }
        }
        return quantity;
    }

    public int total_item_book_skill(int id) {
        int quantity = 0;
        for (Item3 it : bag3) {
            if (it != null && it.id == id && !it.hasOption((byte) 61)) {
                quantity++;
            }
        }
        return quantity;
    }

    public void remove_item_book(int id, int quantity) {
        int q = quantity;
        for (int i = 0; i < bag3.length; i++) {
            Item3 it = bag3[i];
            if (it == null) {
                continue;
            }
            if (it.id == id && it.hasOption((byte) 61) && q > 0) {
                bag3[i] = null;
                q--;
            }
        }
    }

    public void remove_item_book_skill(int id, int quantity) {
        int q = quantity;
        for (int i = 0; i < bag3.length; i++) {
            Item3 it = bag3[i];
            if (it == null) {
                continue;
            }
            if (it.id == id && !it.hasOption((byte) 61) && q > 0) {
                bag3[i] = null;
                q--;
            }
        }
    }

    public Item5 findItemById(List<Item5> items, int id) {
        for (Item5 item : items) {
            if (item != null && item.ID == id) {
                return item;
            }
        }
        return null;
    }

    public void add_item_bag5(Item5 item) throws IOException {
        int size = item.quantity;
        if (size > 0) {
            for (int i = bag5.size() - 1; i >= 0; i--) {
                Item5 tempItem = bag5.get(i);
                if (tempItem == null) {
                    continue;
                }
                if (tempItem.ID == item.ID) {
                    size += tempItem.quantity;
                    bag5.remove(i);
                }
            }
            if (size > 32000) {
                item.quantity = 32000;
            } else {
                item.quantity = size;
            }
            bag5.add(item);
        }
    }

    // Túi phụ
    public void char_tui(int type) throws IOException {
        switch (type) {
            case 3: {
                Message m = new Message(65);
                m.writer().writeByte(p.maxtui);
                m.writer().writeByte(0);
                m.writer().writeByte(3);
                m.writer().writeByte(3);
                m.writer().writeByte(total_item_by_type_tui(3));
                for (int i = 0; i < tui3.length; i++) {
                    Item3 temp = tui3[i];
                    if (temp != null) {
                        m.writer().writeUTF(temp.name);
                        m.writer().writeByte(temp.clazz); // item clazz
                        m.writer().writeShort(i); // id : index
                        m.writer().writeByte(temp.type); // type only
                        m.writer().writeShort(temp.icon); // idicon
                        m.writer().writeByte(temp.tier); // tier
                        m.writer().writeShort(temp.level); // level
                        m.writer().writeByte(temp.color); // color name
                        m.writer().writeByte(1); // can sell
                        m.writer().writeByte(temp.islock ? 0 : 1); // can trade
                        m.writer().writeByte(temp.op.size()); // size
                        for (int j = 0; j < temp.op.size(); j++) {
                            m.writer().writeByte(temp.op.get(j).id);
                            m.writer().writeInt(temp.op.get(j).getParam(temp.tier));
                        }
                        if (temp.time_use != 0) {
                            long time_use = temp.time_use - System.currentTimeMillis();
                            time_use /= 3_600_000;
                            m.writer().writeInt((int) ((time_use > 0) ? time_use : 1)); // time use
                        } else {
                            m.writer().writeInt(0); // time use
                        }
                        m.writer().writeByte(temp.islock ? (byte) 1 : (byte) 0); // islock
                        m.writer().writeByte(0); // b10
                        m.writer().writeByte(0); // canShell_notCanTrade
                    }
                }
                p.conn.addmsg(m);
                m.cleanup();
                break;
            }
            case 4:
            case 7: {
                Message m = new Message(65);
                m.writer().writeByte(p.maxtui);
                m.writer().writeByte(0);
                m.writer().writeByte(type);
                m.writer().writeByte(type);
                m.writer().writeByte(total_item_by_type_tui(type));
                for (int i = 0; i < tui47.size(); i++) {
                    Item47 temp = tui47.get(i);
                    if (temp == null) continue;
                    if (temp.category == type) {
                        m.writer().writeShort(temp.id);
                        m.writer().writeShort(temp.quantity);
                        m.writer().writeByte(1);
                        m.writer().writeByte(0);
                    }
                }
                p.conn.addmsg(m);
                m.cleanup();
                break;
            }
        }
    }

    private int total_item_by_type_tui(int type) {
        int quantity = 0;
        switch (type) {
            case 3: {
                for (int i = 0; i < tui3.length; i++) {
                    if (tui3[i] != null) {
                        quantity++;
                    }
                }
                break;
            }
            case 4:
            case 7: {
                for (int i = 0; i < tui47.size(); i++) {
                    Item47 temp = tui47.get(i);
                    if (temp != null && temp.category == type) {
                        quantity++;
                    }
                }
                break;
            }
        }
        return quantity;
    }

    public int total_item_by_id_tui(int type, short id) {
        int quantity = 0;
        switch (type) {
            case 3: {
                for (Item3 it : tui3) {
                    if (it != null && it.id == id) {
                        quantity += 1;
                    }
                }
                break;
            }
            case 4:
            case 7: {
                for (Item47 it : tui47) {
                    if (it != null && it.category == type && it.id == id) {
                        quantity += it.quantity;
                    }
                }
                break;
            }
        }
        return quantity;
    }

    public void add_item_tui47(int type, Item47 item) {
        Item47 temp = new Item47(item);
        temp.category = (byte) type;
        switch (type) {
            case 4:
            case 7: {
                int size = temp.quantity;
                if (size > 0) {
                    for (int i = tui47.size() - 1; i >= 0; i--) {
                        Item47 t = tui47.get(i);
                        if (t == null) continue;
                        if (t.category == type && t.id == temp.id) {
                            size += t.quantity;
                            tui47.remove(i);
                        }
                    }
                    if (size > 32000) {
                        temp.quantity = 32000;
                    } else {
                        temp.quantity = (short) size;
                    }
                    tui47.add(temp);
                }
                break;
            }
        }
    }

    public void add_item_tui3(Item3 buffer) {
        for (int j = 0; j < tui3.length; j++) {
            if (tui3[j] == null) {
                tui3[j] = new Item3(buffer);
                break;
            }
        }
    }

    public void remove_tui(int type, short id, int quantity) {
        switch (type) {
            case 3: {
                tui3[id] = null;
                break;
            }
            case 4:
            case 7: {
                for (int j = tui47.size() - 1; j >= 0; j--) {
                    Item47 it = tui47.get(j);
                    if (it == null) continue;
                    if (it.category == type && it.id == id && quantity > 0) {
                        if (it.quantity > quantity) {
                            it.quantity -= quantity;
                            break;
                        } else {
                            quantity -= it.quantity;
                            tui47.remove(j);
                            continue;
                        }
                    }
                    if (tui47.get(j).quantity <= 0) {
                        tui47.remove(j);
                    }
                }
                break;
            }
        }
    }

    public int get_tui_able() {
        return (p.maxtui - (total_item_by_type_tui(3) + total_item_by_type_tui(4) + total_item_by_type_tui(7)));
    }

    public void tui_process(Message m2) throws IOException {
        byte type = m2.reader().readByte();
        short id = m2.reader().readShort();
        byte tem = m2.reader().readByte();
        short num = m2.reader().readShort();
        if (num <= 0) {
            return;
        }
        if (type == -1) {
            char_tui(3);
            char_tui(4);
            char_tui(7);
            return;
        }
        if (type == 1) { // Cất vào túi phụ
            if ((get_tui_able() < 1 && tem == 3) || 
                (get_tui_able() < 1 && tem == 4 && total_item_by_id_tui(4, id) < 1) || 
                (get_tui_able() < 1 && tem == 7 && total_item_by_id_tui(7, id) < 1)) {
                Service.send_notice_box(p.conn, "Túi đầy!");
                return;
            }
            switch (tem) {
                case 3: {
                    if (id < 0 || id >= bag3.length || bag3[id] == null) {
                        Service.send_notice_box(p.conn, "Vật phẩm không tồn tại!");
                        return;
                    }
                    add_item_tui3(bag3[id]);
                    remove(3, id, 1);
                    break;
                }
                case 4:
                case 7: {
                    if ((total_item_by_id(tem, id) + total_item_by_id_tui(tem, id)) > 32000) {
                        Service.send_notice_box(p.conn, "Số lượng tổng lớn hơn 32k, không thể thực hiện!");
                        return;
                    }
                    int available = total_item_by_id(tem, id);
                    if (num > available) {
                        num = (short) available;
                    }
                    Item47 itbuffer = new Item47();
                    itbuffer.id = id;
                    itbuffer.quantity = num;
                    itbuffer.category = tem;
                    add_item_tui47(tem, itbuffer);
                    remove(tem, id, num);
                    break;
                }
            }
            char_inventory(tem);
            char_tui(tem);
        } else { // Lấy ra từ túi phụ
            if ((get_bag_able() < 1 && tem == 3) || 
                (get_bag_able() < 1 && tem == 4 && total_item_by_id(4, id) < 1) || 
                (get_bag_able() < 1 && tem == 7 && total_item_by_id(7, id) < 1)) {
                Service.send_notice_box(p.conn, "Hành trang đầy!");
                return;
            }
            switch (tem) {
                case 3: {
                    if (id < 0 || id >= tui3.length || tui3[id] == null) {
                        Service.send_notice_box(p.conn, "Vật phẩm không tồn tại trong túi phụ!");
                        return;
                    }
                    add_item_bag3(tui3[id]);
                    remove_tui(3, id, 1);
                    break;
                }
                case 4:
                case 7: {
                    if ((total_item_by_id(tem, id) + total_item_by_id_tui(tem, id)) > 32000) {
                        Service.send_notice_box(p.conn, "Số lượng tổng lớn hơn 32k, không thể thực hiện!");
                        return;
                    }
                    int available = total_item_by_id_tui(tem, id);
                    if (num > available) {
                        num = (short) available;
                    }
                    Item47 itbuffer = new Item47();
                    itbuffer.id = id;
                    itbuffer.quantity = num;
                    itbuffer.category = tem;
                    add_item_bag47(tem, itbuffer);
                    remove_tui(tem, id, num);
                    break;
                }
            }
            char_inventory(tem);
            char_tui(tem);
        }
    }
}