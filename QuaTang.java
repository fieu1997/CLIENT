package core;

import client.Player;
import io.Session;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import template.Item3;
import template.Item47;
import template.ItemTemplate3;

class QuaTang {

private static int index;

    public static void get_qua(Session conn, byte index) throws IOException, SQLException {
        switch (index) {
            case 0:
                getQuaMoc(conn, "moc50", 50_000);
                break;
            case 1:
                getQuaMoc(conn, "moc100", 100_000);
                break;
            case 2:
                getQuaMoc(conn, "moc200", 200_000);
                break;
            case 3:
                getQuaMoc(conn, "moc500", 500_000);
                break;
            case 4:
                getQuaMoc(conn, "moc1m", 1_000_000);
                break;
            case 5:
                getQuaMoc(conn, "moc1m5", 1_500_000);
                break;
            case 6:
                getQuaMoc(conn, "moc2m", 2_000_000);
                break;
            case 7:
                getQuaMoc(conn, "moc3m", 3_000_000);
                break;
            case 8:
                getQuaMoc(conn, "moc4m", 4_000_000);
                break;
            case 9:
                getQuaMoc(conn, "moc5m", 5_000_000);
                break;
            default:
                Service.send_notice_box(conn.p.conn, "Nạp Chưa Đủ");
        }
    }

    private static void getQuaMoc(Session conn, String text, int tongNap) throws IOException, SQLException {
    if (conn.p.check_moc_nap(tongNap)) {
        // Nếu đã nhận quà từ mốc này rồi, xử lý tại đây (ví dụ: thông báo đã nhận)
        Service.send_notice_box(conn.p.conn, "Bạn đã nhận quà từ mốc " + tongNap + " rồi!");
    } else if (conn.p.get_tongnap() >= tongNap) {
        try (Connection connection = SQL.gI().getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM `giftcode3` WHERE `name` = '" + text + "';")) {
            if (!rs.next()) {
                Service.send_notice_box(conn.p.conn, "Không tìm thấy quà hoặc chưa nạp đủ tiền");
                return;
            }
            String mess = rs.getString("logger");
            byte empty_box = rs.getByte("empty_box");
            if (conn.p.item.get_bag_able() >= empty_box) {
                addItems(conn, rs);
                conn.p.conn.moc_nap.add(String.valueOf(tongNap));
                conn.p.conn.save_moc_nap();
                Service.send_notice_box(conn.p.conn, mess);
            } else {
                Service.send_notice_box(conn.p.conn, "Hành trang phải trống " + empty_box + " ô trở lên!");
            }
        }
    } else {
        Service.send_notice_box(conn.p.conn, "Bạn chưa đủ điều kiện để nhận quà từ mốc " + tongNap);
    }
}


    private static void addItems(Session conn, ResultSet rs) throws SQLException, IOException {
        JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("item3_defauft"));
        addItem3(conn, jsar, false);
        jsar.clear();
        jsar = (JSONArray) JSONValue.parse(rs.getString("item3"));
        addItem3(conn, jsar, true);
        jsar.clear();

        jsar = (JSONArray) JSONValue.parse(rs.getString("item4"));
        addItem47(conn, jsar, 4);
        jsar.clear();

        jsar = (JSONArray) JSONValue.parse(rs.getString("item7"));
        addItem47(conn, jsar, 7);
        jsar.clear();

        conn.p.update_vang(rs.getLong("vang"));
        conn.p.update_ngoc(rs.getLong("ngoc"));
        conn.p.update_coin(rs.getInt("coin"));
        conn.p.update_naptuan(rs.getInt("naptuan"));
        conn.p.update_tongnap(rs.getInt("tongnap"));
        Log.gI().add_log(conn.p.name, "Get order :" + rs.getInt("id"));
        conn.p.item.char_inventory(5);
        conn.p.item.char_inventory(3);
        conn.p.item.char_inventory(4);
        conn.p.item.char_inventory(7);
    }

    private static void addItem3(Session conn, JSONArray jsar, boolean isLock) throws SQLException {
        for (int i = 0; i < jsar.size(); i++) {
            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
            if (jsar2 == null || jsar2.size() < 1) {
                continue;
            }
            Item3 itbag = new Item3();
            short it = Short.parseShort(jsar2.get(0).toString());
            short date = Short.parseShort(jsar2.get(1).toString());
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
            if (itbag.islock) {
                itbag.name += " [Khóa]";
            }
            if (date > 0) {
                // itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * date;
            }
            conn.p.item.add_item_bag3(itbag);
        }
    }

    private static void addItem47(Session conn, JSONArray jsar, int category) throws SQLException {
        for (int i = 0; i < jsar.size(); i++) {
            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
            Item47 itbag = new Item47();
            itbag.id = Short.parseShort(jsar2.get(0).toString());
            itbag.quantity = Short.parseShort(jsar2.get(1).toString());
            itbag.category = (byte) category;
            conn.p.item.add_item_bag47(category, itbag);
        }
    }
}