package client;

import core.GameSrc;
import event.Event_1;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import core.Log;
import core.Manager;
import core.SQL;
import core.Service;
import core.Util;
import event.Event_5;

import io.Message;
import io.Session;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import map.Map;
import map.MapService;
import map.Vgo;
import template.Clan_mems;
import template.Item3;
import template.Item47;
import template.Item5;
import template.ItemTemplate3;
import template.ItemTemplate4;
import template.ItemTemplate5;
import template.ItemTemplate7;
import template.Level;
import template.Option;
import template.OptionItem;
import template.box_item_template;

public class TextFromClient {

    public static void process(Session conn, Message m2) throws IOException, SQLException {
        short idnpc = m2.reader().readShort();
        short idmenu = m2.reader().readShort();
        byte size = m2.reader().readByte();
        if (idmenu != 0) {
            return;
        }
        switch (idnpc) {

            case 30: {
                if (size != 3) {
                    return;
                }
                String value1 = m2.reader().readUTF();
                String value2 = m2.reader().readUTF();
                String value3 = m2.reader().readUTF();

                if (!value1.equals(conn.pass)) {
                    Service.send_notice_box(conn, "Mật khẩu không đúng");
                    return;
                }
                if (value2.equals(value1) || !value2.equals(value3)) {
                    Service.send_notice_box(conn, "Mật khẩu mới không hợp lệ");
                    return;
                }
                try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement()) {
                    st.execute("UPDATE `account` SET `pass` = '" + value2 + "' WHERE `user` = '" + conn.user + "';");
                    connection.commit();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Service.send_notice_box(conn, "Có lỗi xảy ra");
                    return;
                }
                Service.send_notice_box(conn, " Đổi mật khẩu mới thành công");

                break;
            }
            case 66: {
                if (size != 2) {
                    return;
                }
                String value1 = m2.reader().readUTF();
                String value2 = m2.reader().readUTF();
                if (!(Util.isnumber(value1))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int quant = Integer.parseInt(value1);
                Player p0 = Map.get_player_by_name(value2);
                if (p0 != null) {
                    if (p0.item.wear[23] != null) {
                        Service.send_notice_box(conn, "Đối phương đã kết đôi với người khác!");
                        return;
                    }
                    if (p0.level < 60) {
                        Service.send_notice_box(conn, "Yêu cầu level trên 60");
                        return;
                    }
                    switch (quant) {
                        case 1: {
                            if (conn.p.get_vang() < 3_000_000_000L) {
                                Service.send_notice_box(conn, "Không đủ 3 tỷ vàng");
                                return;
                            }
                            conn.p.update_vang(-3_000_000_000L);
                            break;
                        }
                        case 2: {
                            if (conn.p.get_ngoc() < 300_000) {
                                Service.send_notice_box(conn, "Không đủ 300k ngọc");
                                return;
                            }
                            conn.p.update_ngoc(-300_000);
                            break;
                        }
                        case 3: {
                            if (conn.p.get_ngoc() < 600_000) {
                                Service.send_notice_box(conn, "Không đủ 600k ngọc");
                                return;
                            }
                            conn.p.update_ngoc(-600_000);
                            break;
                        }
                        case 4: {
                            if (conn.p.get_ngoc() < 900_000) {
                                Service.send_notice_box(conn, "Không đủ 900k ngọc");
                                return;
                            }
                            conn.p.update_ngoc(-900_000);
                            break;
                        }
                        default: {
                            Service.send_notice_box(conn, "Chọn nhẫn từ 1 - 4 thôi!");
                            return;
                        }
                    }
                    conn.p.item.char_inventory(5);
                    p0.in4_wedding = new String[]{"" + quant, conn.p.name};
                    Service.send_box_input_yesno(p0.conn, 110, conn.p.name + " muốn cầu hôn bạn, đồng ý lấy mình nhé?");
                } else {
                    Service.send_notice_box(conn, "Không tìm thấy đối phương!");
                }
                break;
            }
            case 16: {
                if (size != 1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                long quant = Integer.parseInt(value);
                if (quant > 32_000 || quant <= 0) {
                    Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                    return;
                }
                int quant_ngoc_can_create = conn.p.item.total_item_by_id(7, conn.p.id_ngoc_tinh_luyen);
                if (quant > quant_ngoc_can_create) {
                    Service.send_notice_box(conn, "Số lượng trong hành trang không đủ!");
                    return;
                }
                long vang_required
                        = (quant * (GameSrc.get_vang_hopngoc(conn.p.id_ngoc_tinh_luyen) / 50_000L) * 1_000_000L);
                if (conn.p.get_vang() < vang_required) {
                    Service.send_notice_box(conn, "Không đủ " + vang_required + " vàng");
                    return;
                }
                if (conn.p.get_vang() < vang_required) {
                    Service.send_notice_box(conn, "Tinh luyện cần " + vang_required + " vàng!");
                    return;
                }
                conn.p.update_vang(-vang_required);
                Item47 it = new Item47();
                it.id = (short) (conn.p.id_ngoc_tinh_luyen + 30);
                it.quantity = (short) quant;
                conn.p.item.add_item_bag47(7, it);
                conn.p.item.remove(7, conn.p.id_ngoc_tinh_luyen, (int) quant);
                Service.send_notice_box(conn,
                        "Tinh luyện thành công " + quant + " " + ItemTemplate7.item.get(it.id).getName());
                conn.p.id_ngoc_tinh_luyen = -1;
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);
                break;
            }
            case 0: {
                if (!conn.p.isOwner) {
                    return;
                }
                if (size != 1) {
                    return;
                }
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt, hãy kích hoạt");
                    return;
                }
                String text = m2.reader().readUTF();
                text = text.toLowerCase();
                Pattern p = Pattern.compile("^[a-zA-Z0-9]{1,15}$");
                if (!p.matcher(text).matches()) {
                    Service.send_notice_box(conn, "Đã xảy ra lỗi");
                    return;
                }
                for (String txt : conn.p.giftcode) {
                    txt = txt.toLowerCase();
                    if (txt.equals((text)) && conn.ac_admin < 4) {
                        Service.send_notice_box(conn, "Bạn đã nhập giftcode này rồi");
                        return;
                    }
                }
                try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM `giftcode` WHERE `giftname` = '" + text + "';")) {
                    byte empty_box = (byte) 0;
                    if (!rs.next()) {
                        Service.send_notice_box(conn, "Giftcode đã được nhập hoặc không tồn tại");
                    } else {
                        List<Short> IDs = new ArrayList<>();
                        List<Integer> Quants = new ArrayList<>();
                        List<Short> Types = new ArrayList<>();
                        empty_box = rs.getByte("empty_box");
                        int limit = rs.getInt("limit");
                        int time = rs.getInt("time");
                        if (limit < 1 && conn.ac_admin < 4) {
                            Service.send_notice_box(conn, "Đã hết lượt dùng giftcode này");
                        } else if (conn.p.item.get_bag_able() >= empty_box) {
                            conn.p.giftcode.add(text);
                            JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("item3"));
                            for (int i = 0; i < jsar.size(); i++) {
                                JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                                Item3 itbag = new Item3();
                                short it = Short.parseShort(jsar2.get(0).toString());
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
                                itbag.islock = false;
                                if (time == 1) {

                                    itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                                }
                                IDs.add(it);
                                Quants.add((int) 1);
                                Types.add((short) 3);
                                conn.p.item.add_item_bag3(itbag);
                            }
                            jsar.clear();
                            //
                            jsar = (JSONArray) JSONValue.parse(rs.getString("item4"));
                            for (int i = 0; i < jsar.size(); i++) {
                                JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                                Item47 itbag = new Item47();
                                itbag.id = Short.parseShort(jsar2.get(0).toString());
                                itbag.quantity = Short.parseShort(jsar2.get(1).toString());
                                itbag.category = 4;
                                IDs.add(itbag.id);
                                Quants.add((int) itbag.quantity);
                                Types.add((short) itbag.category);
                                conn.p.item.add_item_bag47(4, itbag);
                            }
                            jsar.clear();
                            //
                            jsar = (JSONArray) JSONValue.parse(rs.getString("item7"));
                            for (int i = 0; i < jsar.size(); i++) {
                                JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                                Item47 itbag = new Item47();
                                itbag.id = Short.parseShort(jsar2.get(0).toString());
                                itbag.quantity = Short.parseShort(jsar2.get(1).toString());
                                itbag.category = 7;
                                IDs.add(itbag.id);
                                Quants.add((int) itbag.quantity);
                                Types.add((short) itbag.category);
                                conn.p.item.add_item_bag47(7, itbag);

                            }
                            jsar.clear();
                            //
                            String table = rs.getString("item47random");

                            if (table != null) {
                                jsar = (JSONArray) JSONValue.parse(table);
                                List<Item47> item47Ran = new ArrayList<>();
                                for (int i = 0; jsar != null && i < jsar.size(); i++) {
                                    JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                                    Item47 itbag = new Item47();
                                    itbag.id = Short.parseShort(jsar2.get(0).toString());
                                    itbag.quantity = Short.parseShort(jsar2.get(1).toString());
                                    itbag.category = Byte.parseByte(jsar2.get(2).toString());
                                    item47Ran.add(itbag);
                                    //conn.p.item.add_item_bag47(7, itbag);
                                }
                                if (item47Ran != null && !item47Ran.isEmpty());
                                {
                                    byte count_item_random = rs.getByte("countrandom");

                                    for (int i = 0; i < count_item_random; i++) {
                                        Item47 itbag = item47Ran.get(Util.random(0, item47Ran.size()));
                                        if (itbag != null) {
                                            IDs.add(itbag.id);
                                            Quants.add((int) itbag.quantity);
                                            Types.add((short) itbag.category);
                                            conn.p.item.add_item_bag47(itbag.category, itbag);
                                        }

                                    }

                                }
                                if (jsar != null) {
                                    jsar.clear();
                                }
                            }

                            //
//                            int vang_up = rs.getInt("vang");
                            long vang_up = rs.getLong("vang");
                            int ngoc_up = rs.getInt("ngoc");
                            int coin_up = rs.getInt("coin");
                            int tongnap_up = rs.getInt("tongnap");
                            int tiennap_up = rs.getInt("tiennap");
                            int pointnap_up = rs.getInt("point_nap");
                            conn.p.update_vang(vang_up);
                            conn.p.update_ngoc(ngoc_up);
                            conn.p.update_coin(coin_up);
                            conn.p.update_tongnap(tongnap_up);
                            conn.p.update_tiennap(tiennap_up);
                            conn.p.update_point_nap(pointnap_up);
                            if (vang_up != 0) {
                                IDs.add((short) -1);
                                Quants.add((int) (vang_up > 2_000_000_000 ? 2_000_000_000 : vang_up));
                                Types.add((short) 4);
                            }

                            if (ngoc_up != 0) {
                                IDs.add((short) -2);
                                Quants.add((int) (ngoc_up > 2_000_000_000 ? 2_000_000_000 : ngoc_up));
                                Types.add((short) 4);
                            }
                            if (coin_up != 0) {
                                IDs.add((short) -3);
                                Quants.add((int) (coin_up > 2_000_000_000 ? 2_000_000_000 : coin_up));
                                Types.add((short) 4);
                            }
                            Log.gI().add_log(conn.p.name,
                                    "Nhận giftcode " + text + " : " + Util.number_format(vang_up) + " vàng");
                            Log.gI().add_log(conn.p.name,
                                    "Nhận giftcode " + text + " : " + Util.number_format(ngoc_up) + " ngọc");

                            Log.gI().add_log(conn.p.name,
                                    "Nhận giftcode " + text + " : " + Util.number_format(coin_up) + " coin");
                            conn.p.item.char_inventory(3);
                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            short[] ar_id = new short[IDs.size()];
                            int[] ar_quant = new int[Quants.size()];
                            short[] ar_type = new short[Types.size()];
                            for (int i = 0; i < ar_id.length; i++) {
                                ar_id[i] = IDs.get(i);
                                ar_quant[i] = Quants.get(i);
                                ar_type[i] = Types.get(i);
                            }
                            Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ar_id, ar_quant, ar_type);
                            //Service.send_notice_box(conn, "Nhận thành công giftcode");
                        } else {
                            Service.send_notice_box(conn, "Hành trang phải trống " + empty_box + " ô trở lên!");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 1: {
                if (conn.ac_admin > 3) {
                    if (size != 3) {
                        return;
                    }
                    String type = m2.reader().readUTF();
                    String id = m2.reader().readUTF();
                    String quantity = m2.reader().readUTF();
                    if (!(Util.isnumber(id) && Util.isnumber(quantity))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    Short sl = Short.parseShort(quantity);
                    if (sl > 32_000 || sl <= 0) {
                        Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                        return;
                    }
                    if (conn.p.item.get_bag_able() > 0) {
                        switch (type) {
                            case "3": {
                                short iditem = (short) Integer.parseInt(id);
                                if (iditem > (ItemTemplate3.item.size() - 1) || iditem < 0) {
                                    return;
                                }
                                Item3 itbag = new Item3();
                                itbag.id = iditem;
                                itbag.name = ItemTemplate3.item.get(iditem).getName();
                                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                                itbag.type = ItemTemplate3.item.get(iditem).getType();
                                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                                itbag.op = new ArrayList<>();
                                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                                itbag.tier = 0;
                                itbag.islock = false;
                                itbag.time_use = 0;
                                conn.p.item.add_item_bag3(itbag);
                                conn.p.item.char_inventory(3);
                                break;
                            }
                            case "4": {
                                short iditem = (short) Integer.parseInt(id);
                                if (iditem > (ItemTemplate4.item.size() - 1) || iditem < 0) {
                                    return;
                                }
                                Item47 itbag = new Item47();
                                itbag.id = iditem;
                                itbag.quantity = sl;
                                itbag.category = 4;
                                conn.p.item.add_item_bag47(4, itbag);
                                conn.p.item.char_inventory(4);
                                break;
                            }
                            case "7": {
                                short iditem = (short) Integer.parseInt(id);
                                if (iditem > (ItemTemplate7.item.size() - 1) || iditem < 0) {
                                    return;
                                }
                                Item47 itbag = new Item47();
                                itbag.id = iditem;
                                itbag.quantity = Short.parseShort(quantity);
                                itbag.category = 7;
                                conn.p.item.add_item_bag47(7, itbag);
                                conn.p.item.char_inventory(7);
                                break;
                            }
                            case "5": {
                                short iditem = (short) Integer.parseInt(id);
                                if (iditem > (ItemTemplate5.items.size() - 1) || iditem < 0) {
                                    return;
                                }
                                Item5 itbag = new Item5(iditem, sl);
                                conn.p.item.add_item_bag5(itbag);  // Assuming there's a method to add item5 to the bag.
                                conn.p.item.char_inventory(5);     // Update character's inventory display for item5.
                                break;
                            }

                        }
                        Service.send_notice_box(conn, "Nhận Item thành công");
                    }
                }
                break;
            }
            case 2: {
                if (conn.ac_admin > 3) {
                    if (size != 1) {
                        return;
                    }
                    String level = m2.reader().readUTF();
                    if (!(Util.isnumber(level))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    int levelchange = Integer.parseInt(level);
                    if (levelchange > 32000 || levelchange <= 0) {
                        Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                        return;
                    }
                    if (levelchange < 2) {
                        levelchange = 2;
                    }
                    if (levelchange > Manager.gI().lvmax) {
                        levelchange = Manager.gI().lvmax;
                    }
                    conn.p.level = (short) (levelchange - 1);
                    conn.p.exp = Level.entrys.get(levelchange - 2).exp - 1;
                    // conn.p.tiemnang = (short) (1 + Level.get_tiemnang_by_level(conn.p.level - 1));
                    // conn.p.kynang = (short) (1 + Level.get_kynang_by_level(conn.p.level - 1));
                    // conn.p.point1 = (short) (4 + conn.p.level);
                    // conn.p.point2 = (short) (4 + conn.p.level);
                    // conn.p.point3 = (short) (4 + conn.p.level);
                    // conn.p.point4 = (short) (4 + conn.p.level);
                    conn.p.update_Exp(1, false);
                    Service.send_char_main_in4(conn.p);
                    for (int i = 0; i < conn.p.map.players.size(); i++) {
                        Player p0 = conn.p.map.players.get(i);
                        if (p0.index != conn.p.index && (Math.abs(p0.x - conn.p.x) < 200) && (Math.abs(p0.y - conn.p.y) < 200)) {
                            MapService.send_in4_other_char(p0.map, p0, conn.p);
                        }
                    }
                    Service.send_notice_box(conn, "Up level thành công");
                }
                break;
            }
            case 3: {
                if (!conn.p.isOwner) {
                    return;
                }
                if (size != 1) {
                    return;
                }
                String vang_join = m2.reader().readUTF();
                if (!(Util.isnumber(vang_join))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int vang_join_vxmm = Integer.parseInt(vang_join);
                if (vang_join_vxmm <= 0 || vang_join_vxmm > 2000000000) {
                    Service.send_notice_box(conn, "Số lượng nhập vào không hợp lệ");
                    return;
                }
                if (vang_join_vxmm < 10_000_000 || conn.p.get_vang() < vang_join_vxmm) {
                    Service.send_notice_box(conn, "vàng không đủ!");
                    return;
                }
                if (vang_join_vxmm > 200_000_000) {
                    Service.send_notice_box(conn, "tối đa 200tr vàng!");
                    return;
                }
                Manager.gI().vxmm.join_vxmm(conn.p, vang_join_vxmm);
                break;
            }
            case 4: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                if (size != 1) {
                    return;
                }
                String xp = m2.reader().readUTF();
                if (!(Util.isnumber(xp))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int xp_ = Integer.parseInt(xp);
                if (xp_ <= 0 || xp_ > 2000000000) {
                    Service.send_notice_box(conn, "Số lượng nhập vào không hợp lệ!");
                    return;
                }
                if (xp_ > 1) {
                    Manager.gI().exp = xp_;
                }
                Service.send_notice_box(conn, "Thay đổi xp thành công x" + Util.number_format(xp_));
                break;
            }
            case 5: { // coin ra ngọc
    if (size != 1) {
        return;
    }
    String value = m2.reader().readUTF();
    if (!Util.isnumber(value)) {
        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
        return;
    }
    int coin_exchange = Integer.parseInt(value);
    if (coin_exchange < 1000 || coin_exchange > 300_000) {
        Service.send_notice_box(conn, "Chỉ có thể đổi tối thiểu là 1k và tối đa là 300k");
        return;
    }

    if (conn.p.update_coin(-coin_exchange)) {
        int tyLe = (conn.vip >= 4) ? 2 : 1; // Nếu VIP >= 3 thì x2 ngọc
        int ngoc_nhan_duoc = coin_exchange * tyLe; 

        conn.p.update_ngoc(ngoc_nhan_duoc);
        conn.p.item.char_inventory(5);
        Service.send_notice_box(conn, "Đổi thành công, nhận được " + ngoc_nhan_duoc + " ngọc");
//        Log.gI().add_log(conn.p.name,
//                        "đổi coin sang ngọc " + text + " : " + Util.number_format(ngoc_nhan_duoc) + " ngọc");
    } else {
        Service.send_notice_box(conn, "Thất bại xin hãy thử lại");
    }
    break;
}

            case 6: {
                if (size != 2) {
                    return;
                }
                String value1 = m2.reader().readUTF();
                String value2 = m2.reader().readUTF();
                Pattern p = Pattern.compile("^[a-zA-Z0-9]{5,15}$");
                if (!p.matcher(value1).matches() || !p.matcher(value2).matches()) {
                    Service.send_notice_box(conn, "Ký tự không hợp lệ, hãy thử lại");
                    return;
                }
               
                int ac_admin_value = Manager.isServerTest ? 5 : 0; // test = 5 , false = 0
                
                String query = "UPDATE `account`  SET `user` = '" + value1 + "', `pass` = '" + value2 + "' ,`ac_admin` = '" + ac_admin_value + "' ,`status` = '" + 1 + "'WHERE `user` = '"
                        + conn.user + "' LIMIT 1";
                try (Connection connnect = SQL.gI().getConnection(); Statement statement = connnect.createStatement();) {
                    if (statement.executeUpdate(query) > 0) {
                        connnect.commit();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Service.send_notice_box(conn, "Có lỗi xảy ra hoặc tên đã được sử dụng, hãy thử lại");
                    return;
                }
                Message md = new Message(31);
                md.writer().writeUTF(value1);
                md.writer().writeUTF(value2);
                conn.addmsg(md);
                md.cleanup();
                conn.user = value1;
                conn.pass = value2;

               if (Manager.isServerTest) {// khi Sever_test = true
                    conn.p.update_coin(500000000);
                    conn.p.update_tongnap(5000000);
                    conn.p.update_tiennap(5000000);
                    conn.p.update_point_nap(5000000);
                    conn.p.chuyencan = 5000000;
                    conn.p.vang = 2__000_000_000_000_000L;
                    conn.p.kimcuong = 2_000_000_000;

                }


                Service.send_notice_box(conn,
                        "Đăng ký thành công tài khoản :\n Tên đăng nhập : " + value1 + "\nMật khẩu : " + value2);
                break;
            }
            case 7: {
                if (size != 1 || conn.p.fusion_material_medal_id == -1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int quant = Integer.parseInt(value);
                if (quant > 32000 || quant <= 0) {
                    Service.send_notice_box(conn, "Số lượng không hợp lệ");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Hành trang đầy!");
                    return;
                }
                int quant_inbag = conn.p.item.total_item_by_id(7, conn.p.fusion_material_medal_id);
                int quant_real = quant_inbag / 5;
                short id_next_material = (short) (conn.p.fusion_material_medal_id + 100);
                String name_next_material = ItemTemplate7.item.get(id_next_material).getName();
                if ((quant_real - quant) >= 0) {
                    if ((quant * 5000) > conn.p.get_vang()) {
                        Service.send_notice_box(conn, "Vàng không đủ!");
                        return;
                    }

                    conn.p.update_vang(-(quant * 5000));
                    conn.p.item.remove(7, conn.p.fusion_material_medal_id, (quant * 5));
                    Item47 it = new Item47();
                    it.id = id_next_material;
                    it.quantity = (short) quant;
                    conn.p.item.add_item_bag47(7, it);
                    conn.p.item.char_inventory(7);
                    //
                    Message m = new Message(-105);
                    m.writer().writeByte(2);
                    m.writer().writeByte(3);
                    m.writer().writeUTF("Chúc mừng bạn nhận được " + quant + " " + name_next_material);
                    m.writer().writeShort(id_next_material);
                    m.writer().writeByte(7);
                    conn.addmsg(m);
                    m.cleanup();
                } else {
                    Service.send_notice_box(conn, "Chỉ có thể hợp thành tối đa " + quant_real + " " + name_next_material);
                }
                conn.p.fusion_material_medal_id = -1;
                break;
            }
            case 8: {
//                if (size != 1) {
//                    return;
//                }
//                String value = m2.reader().readUTF();
//                if (!(Util.isnumber(value))) {
//                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
//                    return;
//                }
//                int coin_exchange = Integer.parseInt(value);
//                if (coin_exchange <= 0 || coin_exchange > 1_000_000_000) {
//                    Service.send_notice_box(conn, "Số nhập không hợp lệ, hãy thử lại");
//                    return;
//                }
//                if (conn.p.update_coin(-coin_exchange)) {
//                    conn.p.update_vang(coin_exchange * 5000);
//                    conn.p.item.char_inventory(5);
//                    Service.send_notice_box(conn, "Đổi thành công");
//                }
//                break;
            }
            case 9: {
                if (size != 1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int quant = Integer.parseInt(value);
                if (quant > 2_000_000_000 || quant <= 0) {
                    Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                    return;
                }
                if (idnpc == 8) {
                    if (quant > conn.p.get_vang()) {
                        Service.send_notice_box(conn, "Vàng không đủ!");
                        return;
                    }
                    conn.p.myclan.member_contribute_vang(conn, quant);
                } else {
                    if (quant > conn.p.get_ngoc()) {
                        Service.send_notice_box(conn, "Ngọc không đủ!");
                        return;
                    }
                    conn.p.myclan.member_contribute_ngoc(conn, quant);
                }
                break;
            }
            case 10: {
                if (Manager.gI().event == 1) {
                    if (size != 1) {
                        return;
                    }
                    String value = m2.reader().readUTF();
                    if (!(Util.isnumber(value))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    int quant = Integer.parseInt(value);
                    if (quant > 500 || quant <= 0) {
                        Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                        return;
                    }
                    //
                    if (conn.p.get_vang() < (quant * 20_000)) {
                        Service.send_notice_box(conn, "Vàng không đủ!");
                        return;
                    }
                    short[] id = new short[]{118, 119, 120, 121, 122};
                    for (int i = 0; i < id.length; i++) {
                        if (conn.p.item.total_item_by_id(4, id[i]) < (quant * 50)) {
                            Service.send_notice_box(conn, (ItemTemplate4.item.get(id[i]).getName() + " không đủ!"));
                            return;
                        }
                    }
                    conn.p.update_vang(-(quant * 20_000));
                    for (int i = 0; i < id.length; i++) {
                        conn.p.item.remove(4, id[i], quant * 50);
                    }
                    Item47 it = new Item47();
                    it.category = 4;
                    it.id = (short) 158;
                    it.quantity = (short) quant;
                    conn.p.item.add_item_bag47(4, it);
                    //
                    conn.p.item.char_inventory(4);
                    conn.p.item.char_inventory(7);
                    conn.p.item.char_inventory(3);
                    //
                    Service.send_notice_box(conn, "Đổi thành công " + quant + " hộp đồ chơi");
                }
                break;
            }
            case 11: {
                if (Manager.gI().event == 1) {
                    if (size != 1) {
                        return;
                    }
                    String value = m2.reader().readUTF();
                    if (!(Util.isnumber(value))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    int quant = Integer.parseInt(value);
                    if (quant > 500 || quant <= 0) {
                        Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                        return;
                    }
                    //
                    short[] id = new short[]{153, 154, 155, 156};
                    for (int i = 0; i < id.length; i++) {
                        if (conn.p.item.total_item_by_id(4, id[i]) < (quant)) {
                            Service.send_notice_box(conn, (ItemTemplate4.item.get(id[i]).getName() + " không đủ!"));
                            return;
                        }
                    }
                    for (int i = 0; i < id.length; i++) {
                        conn.p.item.remove(4, id[i], quant);
                    }
                    Event_1.add_material(conn.p.name, quant);
                    //
                    conn.p.item.char_inventory(4);
                    conn.p.item.char_inventory(7);
                    conn.p.item.char_inventory(3);
                    //
                    Service.send_notice_box(conn, "Đóng góp nguyên liệu tạo " + quant + " kẹo");
                }
                break;
            }
            case 12: {
                if (Manager.gI().event == 1) {
                    if (size != 1) {
                        return;
                    }
                    String value = m2.reader().readUTF();
                    if (!(Util.isnumber(value))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    int quant = Integer.parseInt(value);
                    if (quant > 500 || quant <= 0) {
                        Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                        return;
                    }
                    //
                    if (conn.p.get_vang() < (quant * 50_000)) {
                        Service.send_notice_box(conn, "Vàng không đủ!");
                        return;
                    }
                    if (conn.p.item.total_item_by_id(4, 162) < (quant * 5)) {
                        Service.send_notice_box(conn, (ItemTemplate4.item.get(162).getName() + " không đủ!"));
                        return;
                    }
                    conn.p.update_vang(-(quant * 50_000));
                    conn.p.item.remove(4, 162, quant * 5);
                    //
                    Item47 it = new Item47();
                    it.category = 4;
                    it.id = 157;
                    it.quantity = (short) quant;
                    conn.p.item.add_item_bag47(4, it);
                    //
                    conn.p.item.char_inventory(4);
                    conn.p.item.char_inventory(7);
                    conn.p.item.char_inventory(3);
                    //
                    Service.send_notice_box(conn, "Đổi thành công " + quant + " túi kẹo");
                }
                break;
            }
            case 13: {
                if (size != 1) {
                    return;
                }
                String name = m2.reader().readUTF();
                Pattern p = Pattern.compile("^[a-zA-Z0-9]{6,10}$");
                if (!p.matcher(name).matches()) {
                    Service.send_notice_box(conn, "tên không hợp lệ, nhập lại đi!!");
                    return;
                }
                if (conn.p.myclan != null && !conn.p.myclan.mems.get(0).name.equals(name)) {

                    conn.p.name_mem_clan_to_appoint = name;
                    Service.send_box_input_yesno(conn, 113, "Xác nhận nhường thủ lĩnh cho " + name);
                }
                break;
            }
            case 14: { // coin ra vàng
    if (size != 1) {
        return;
    }
    String value = m2.reader().readUTF();
    if (!(Util.isnumber(value))) {
        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
        return;
    }
    long coin_exchange = Long.parseLong(value); // Dùng long thay vì int
    if (coin_exchange < 1000 || coin_exchange > 300_000) {
        Service.send_notice_box(conn, "Chỉ có thể đổi tối thiểu là 1k và tối đa là 300k");
        return;
    }
    if (conn.p.update_coin(-coin_exchange)) {
        int tyLe = (conn.vip >= 3) ? 2 : 1; // Nếu VIP >= 3 thì x2 vàng
        long vang_nhan_duoc = ((coin_exchange / 2) * 10_000) * tyLe; // Sử dụng long cho vàng

        // Kiểm tra nếu vàng nhận được vượt quá giới hạn tối đa của long (2 tỷ vàng)
        if (vang_nhan_duoc < 0) {
            Service.send_notice_box(conn, "Số vàng nhận được quá lớn và bị tràn.");
            return;
        }

        conn.p.update_vang(vang_nhan_duoc);
        conn.p.item.char_inventory(5);
        Service.send_notice_box(conn, "Đổi thành công");
    } else {
        Service.send_notice_box(conn, "Thất bại xin hãy thử lại");
    }
    break;
}
            case 15: {
                if (size != 1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int quant = Integer.parseInt(value);
                if (quant > 32_000 || quant <= 0) {
                    Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Hành trang đầy!");
                    return;
                }
                int quant_ngoc_can_create = conn.p.item.total_item_by_id(7, conn.p.id_hop_ngoc) / 5;
                if (quant > quant_ngoc_can_create) {
                    Service.send_notice_box(conn, "Số lượng trong hành trang không đủ!");
                    return;
                }
                int vang_required = GameSrc.get_vang_hopngoc(conn.p.id_hop_ngoc) * quant;
                if (conn.p.get_vang() < vang_required) {
                    Service.send_notice_box(conn, "Không đủ " + vang_required + " vàng");
                    return;
                }
                conn.p.update_vang(-vang_required);
                conn.p.item.remove(7, conn.p.id_hop_ngoc, (quant * 5));
                Item47 itbag = new Item47();
                itbag.id = (short) (conn.p.id_hop_ngoc + 1);
                itbag.quantity = (short) quant;
                itbag.category = 7;
                conn.p.item.add_item_bag47(7, itbag);
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);
                conn.p.id_hop_ngoc = -1;
                //
                Message m = new Message(-100);
                m.writer().writeByte(3);
                m.writer().writeUTF("Nhận được " + quant + " " + ItemTemplate7.item.get(itbag.id).getName());
                m.writer().writeShort(itbag.id);
                m.writer().writeByte(7);
                conn.addmsg(m);
                m.cleanup();
                break;
            }
            case 17: {
                if (size != 1) {
                    return;
                }
                String vang_join = m2.reader().readUTF();
                if (!(Util.isnumber(vang_join))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int vang_join_vxmm = Integer.parseInt(vang_join);
                if (vang_join_vxmm < 500 || conn.p.get_ngoc() < vang_join_vxmm) {
                    Service.send_notice_box(conn, "ngọc không đủ!");
                    return;
                }
                if (vang_join_vxmm > 50_000) {
                    Service.send_notice_box(conn, "tối đa 50k ngọc!");
                    return;
                }
                Manager.gI().vxkc.join_vxmm(conn.p, vang_join_vxmm);
                break;
            }
            case 18: {
                if (conn.ac_admin <= 3) {
                    Service.send_notice_box(conn, "Không đủ thẩm quyền!");
                    return;
                }
                String nameUser = m2.reader().readUTF();
                //Pattern p = Pattern.compile("^[a-zA-Z0-9@.]{1,15}$");
//                if ( !p.matcher(nameUser).matches() ) {
//                    Service.send_notice_box(conn,"ký tự nhập vào không hợp lệ!!");
//                    return;
//                }
                for (int i = Session.client_entrys.size() - 1; i >= 0; i--) {
                    Session s = Session.client_entrys.get(i);
                    if (s != null && s.p != null && s.p.name != null && s.p.name.equals(nameUser)) {
                        Session.client_entrys.get(i).p.timeBlockCTG = Helps._Time.GetTimeNextDay();
                        Service.send_notice_box(conn, "Khóa mõm nhân vật " + nameUser + " 1 ngày thành công.");
                        return;
                    }
                }
                Service.send_notice_box(conn, "Không tìm thấy nhân vật hoặc không online");

                break;
            }
            case 19: {
                if (conn.ac_admin <= 3) {
                    Service.send_notice_box(conn, "Không đủ thẩm quyền!");
                    return;
                }
                String nameUser = m2.reader().readUTF();
                for (int i = Session.client_entrys.size() - 1; i >= 0; i--) {
                    Session s = Session.client_entrys.get(i);
                    if (s != null && s.p != null && s.p.name != null && s.p.name.equals(nameUser)) {
                        Session.client_entrys.get(i).p.timeBlockCTG = 0;
                        Service.send_notice_box(conn, "Đã gỡ mõm nhân vật " + nameUser);
                        return;
                    }
                }
                break;
            }
            case 20: {
                String namePlayer = m2.reader().readUTF();
                conn.p.Store_Sell_ToPL = namePlayer;
                Service.send_notice_box(conn, "Đã cài đặt chỉ bán cho nhân vật " + namePlayer);
                break;
            }
            case 21: {
                if (conn.ac_admin > 3) {
                    if (size != 3) {
                        return;
                    }
                    try {
                        Vgo v = new Vgo();
                        v.id_map_go = Byte.parseByte(m2.reader().readUTF());
                        v.x_new = Short.parseShort(m2.reader().readUTF());
                        v.y_new = Short.parseShort(m2.reader().readUTF());
                        conn.p.change_map(conn.p, v);
                    } catch (Exception e) {
                        Service.send_notice_box(conn, "Đã xảy ra lỗi!");
                    }

                }
                break;
            }
            case 22: {
                if (size != 1) {
                    return;
                }
                String thue = m2.reader().readUTF();
                if (!(Util.isnumber(thue))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int thuechange = Byte.parseByte(thue);
                if (thuechange < 0 || thuechange > 5) {
                    Service.send_notice_box(conn, "Chỉ có thể cài đặt thuế trong khoảng từ 0 đến 5%");
                    return;
                }
                if (conn.p.myclan == null || Manager.ClanThue == null || !conn.p.myclan.equals(Manager.ClanThue)) {
                    Service.send_notice_box(conn, "Chỉ clan chiếm được thành mới có thể đặt thuế!");
                } else if (!Manager.ClanThue.mems.get(0).name.equals(conn.p.name)) {
                    Service.send_notice_box(conn, "Chỉ chủ bang mới có quyền thực hiện hành động này!");
                } else {
                    Manager.thue = (byte) thuechange;
                    Service.send_notice_box(conn, "Bạn đã thay đổi mức thuế lên " + Manager.thue + " %");
                }
                break;
            }
            case 23: {
                String[] value = new String[]{m2.reader().readUTF(), m2.reader().readUTF()};
                if (!value[0].equals("") && !value[1].equals("")) {
                    // Service.send_notice_box(conn, "Bạn đã đặt tên bang là \"" + value[0] + "\" và tên viết tắt là \""
                    // + value[1] + "\" đúng không?\n đang test thôi nên éo có bang đâu kkk :v");
                    if (value[0].contains("_") || value[0].contains("-") || value[0].contains("@") || value[0].contains("#")
                            || value[0].contains("^") || value[0].contains("$") || value[0].length() > 20
                            || value[0].length() < 4) {
                        Service.send_notice_box(conn, "Tên nhập vào không hợp lệ");
                        return;
                    }
                    Pattern p = Pattern.compile("^[a-zA-Z0-9]{3,3}$");
                    if (!p.matcher(value[1]).matches()) {
                        Service.send_notice_box(conn, "Tên rút gọn nhập vào không hợp lệ");
                        return;
                    }
                    if (conn.p.get_ngoc() < 20000) {
                        Service.send_notice_box(conn, "Không đủ 20k ngọc!");
                        return;
                    }
                    if (Clan.create_clan(conn, value[0], value[1])) {
                        conn.p.update_ngoc(-20000);
                        Log.gI().add_log(conn.p.name, "Tạo bang mất 20000 ngọc");
                        conn.p.item.char_inventory(5);
                        Service.send_box_UI(conn, 20);
                        Service.send_notice_box(conn, "Hãy chọn một icon bất kỳ đặt làm biểu tượng");
                    }
                } else {
                    Service.send_notice_box(conn, "bỏ ô trống thì tạo bang cho mày thế éo nào đc hả?");
                }
                break;
            }
            case 24: {
                if (conn.ac_admin <= 3) {
                    Service.send_notice_box(conn, "Không đủ thẩm quyền!");
                    return;
                }
                try {
                    String type = m2.reader().readUTF();
                    String nameUser = m2.reader().readUTF();
                    if (type == null || type.isEmpty() || nameUser == null || nameUser.isEmpty()) {
                        Service.send_notice_box(conn, "Không được bỏ trống trường dữ liệu!");
                        return;
                    }
                    int count = 0;
                    switch (type) {
                        case "1":
                            for (int i = Session.client_entrys.size() - 1; i >= 0; i--) {
                                Session s = Session.client_entrys.get(i);
                                if (s != null && s.user != null && s.user.toLowerCase().equals(nameUser.toLowerCase())) {
                                    count++;
                                    System.out.println("=============close session " + s.user);
                                    Session.client_entrys.get(i).close();
                                }
                            }
                            Service.send_notice_box(conn, "Đã disconnect " + count + " session có tên tài khoản: " + nameUser);
                            break;
                        case "2":
                            for (int i = Session.client_entrys.size() - 1; i >= 0; i--) {
                                Session s = Session.client_entrys.get(i);
                                if (s != null && s.p != null && s.p.name != null && s.p.name.toLowerCase().equals(nameUser.toLowerCase())) {
                                    count++;
                                    System.out.println("=============close session " + s.user);
                                    Session.client_entrys.get(i).close();
                                }
                            }
                            Service.send_notice_box(conn, "Đã disconnect " + count + " session có tên nhân vật: " + nameUser);
                            break;
                        default:
                            Service.send_notice_box(conn, "Không đúng định dạng loại:\n1: Tên tài khoản \n2: Tên nhân vật");
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                    Service.send_notice_box(conn, "lỗi cmnr3!");
                }

                break;
            }
            case 25:
            case 26:
            case 27: {
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int quant = Integer.parseInt(value);
                if (quant > 200 || quant <= 0) {
                    Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Hành trang đầy!");
                    return;
                }
                short id_cu = 306, id_moi = 307, chuyendoi = 30;
                long vag = quant * 100_000;
                if (idnpc == 26) {
                    id_cu = 306;
                    id_moi = 304;
                    chuyendoi = 10;
                    vag = quant * 25_000;
                } else if (idnpc == 27) {
                    id_cu = 304;
                    id_moi = 305;
                    chuyendoi = 5;
                    vag = quant * 500;
                }
                if (idnpc == 27 && vag > conn.p.get_ngoc()) {
                    Service.send_notice_box(conn, "Không đủ " + vag + " ngọc để đổi " + quant + " bó sen");
                    return;
                } else if (vag > conn.p.get_vang()) {
                    Service.send_notice_box(conn, "Không đủ " + vag + " vàng để đổi " + quant + " bó sen");
                    return;
                }
                if (id_cu > (ItemTemplate4.item.size() - 1) || id_cu < 0 || id_moi > (ItemTemplate4.item.size() - 1) || id_moi < 0) {
                    Service.send_notice_box(conn, "Đã xảy ra lỗi...");
                    return;
                }
                int quant_inbag = conn.p.item.total_item_by_id(4, id_cu);
                int quant_real = quant_inbag / chuyendoi;
                if (quant_real < quant) {
                    Service.send_notice_box(conn, "Chỉ có thể đổi tối đa " + quant_real + " " + ItemTemplate4.item.get(id_moi).getName());
                    return;
                }

                if (idnpc == 27) {
                    conn.p.update_ngoc(-(vag));
                } else {
                    conn.p.update_vang(-(vag));
                }
                Item47 itbag = new Item47();
                itbag.id = id_moi;
                itbag.quantity = (short) quant;
                itbag.category = 4;
                conn.p.item.remove(4, id_cu, quant * chuyendoi);
                conn.p.item.add_item_bag47(4, itbag);
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(5);

                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", new short[]{id_moi}, new int[]{quant}, new short[]{4});
                break;
            }

            case 29: {
                String value1 = m2.reader().readUTF();
                String value2 = m2.reader().readUTF();
                int value_ = Integer.parseInt(value2);
                Player p0 = null;
                for (Player p1 : conn.p.map.players) {
                    if (p1.conn != null && p1.conn.connected && p1.name.equals(value1) && Math.abs(conn.p.x - p1.x) < 70 && Math.abs(conn.p.y - p1.y) < 70) {
                        p0 = p1;
                        break;
                    }
                }
                if (p0 == null) {
                    Service.send_notice_box(conn, "Bạn và người thả cùng cần phải đứng gần nhau");
                    break;
                }
                if (conn.p.item.get_bag_able() < 3) {
                    Service.send_notice_box(conn, "Cần 3 ô trống trong hành trang!");
                    return;
                }
                if (conn.p.item.total_item_by_id(4, 329) < 1) {
                    Service.send_notice_box(conn, "Không Có Vé Tặng Ngọc");
                    return;
                }
                if (conn.p.get_ngoc() < 10000) {
                    Service.send_notice_box(conn, "Không đủ 10k Ngọc");
                    return;
                }
                if (value_ < 1000 || value_ > 300_000) {
                    Service.send_notice_box(conn, "Chỉ có thể đổi tối thiểu là 1k và tối đa là 300k");
                    return;
                }

                if (conn.p.item.total_item_by_id(4, 329) > 0) {
//                    try{
                    conn.p.item.remove(4, 329, 1);
                    List<box_item_template> ids = new ArrayList<>();

                    List<Integer> it7 = new ArrayList<>(java.util.Arrays.asList(12, 13, 11, 3, 4, 8, 9, 10));
                    List<Integer> it7_vip = new ArrayList<>(java.util.Arrays.asList(14, 471, 346, 33));

                    List<Integer> it4 = new ArrayList<>(java.util.Arrays.asList(329));
                    List<Integer> it4_vip = new ArrayList<>(java.util.Arrays.asList(206, 147, 131, 304, 306));
                    for (int i = 0; i < Util.random(1, 1); i++) {
                        int ran = Util.random(100);
                        if (ran < 100) {
                            short id = Util.random(it4, new ArrayList<>()).shortValue();
                            short quant = 0;;
                            ids.add(new box_item_template(id, quant, (byte) 4));
                            conn.p.item.add_item_bag47(id, quant, (byte) 4);
                            conn.p.update_ngoc(-value_);

                        }

                        break;
                    }
                    //ev_he.Event_3.add_DoiQua(conn.p.name, 1);

                    Service.Show_open_box_notice_item(conn.p, "Tặng " + value_ + " Ngọc Cho " + p0.name, ids);
//                    }catch(Exception e){e.printStackTrace();}
                }

                if (p0.item.get_bag_able() < 3) {
                    Service.send_notice_box(p0.conn, "Cần 3 ô trống trong hành trang để có thể nhận quà hoa đăng từ " + conn.p.name);
                    return;
                }

                List<box_item_template> ids = new ArrayList<>();

                List<Integer> it7 = new ArrayList<>(java.util.Arrays.asList(1, 2, 3));
                List<Integer> it7_vip = new ArrayList<>(java.util.Arrays.asList(12, 8, 9, 10));
                List<Integer> it4 = new ArrayList<>(java.util.Arrays.asList(329));
                List<Integer> it4_vip = new ArrayList<>(java.util.Arrays.asList(205, 207, 24, 52, 275, 84));
                for (int i = 0; i < Util.random(1, 1); i++) {
                    int ran = Util.random(100);
                    if (ran < 100) {
                        short id = Util.random(it4, new ArrayList<>()).shortValue();
                        short quant = 0;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        p0.item.add_item_bag47(id, quant, (byte) 4);
                        //conn.p.item.remove(4, 329, 1);
                        p0.update_ngoc(value_);
                    }

                    break;

                }

                Service.Show_open_box_notice_item(p0, "Bạn Nhận " + value_ + " Ngọc Tặng Từ " + conn.p.name, ids);
                break;
            }

            case 28: {
                String namep = m2.reader().readUTF();
                Player p0 = null;
                for (Player p1 : conn.p.map.players) {
                    if (p1.conn != null && p1.conn.connected && p1.name.equals(namep) && Math.abs(conn.p.x - p1.x) < 70 && Math.abs(conn.p.y - p1.y) < 70) {
                        p0 = p1;
                        break;
                    }
                }
                if (p0 == null) {
                    Service.send_notice_box(conn, "Bạn và người thả cùng cần phải đứng gần nhau");
                    break;
                }
                if (conn.p.item.get_bag_able() < 3) {
                    Service.send_notice_box(conn, "Cần 3 ô trống trong hành trang!");
                    return;
                }
                if (conn.p.item.total_item_by_id(4, 303) > 0) {
//                    try{
                    conn.p.item.remove(4, 303, 1);
                    List<box_item_template> ids = new ArrayList<>();

                    List<Integer> it7 = new ArrayList<>(java.util.Arrays.asList(12, 13, 11, 3, 4, 8, 9, 10));
                    List<Integer> it7_vip = new ArrayList<>(java.util.Arrays.asList(14, 471, 346, 33));

                    List<Integer> it4 = new ArrayList<>(java.util.Arrays.asList(294, 275, 52, 18));
                    List<Integer> it4_vip = new ArrayList<>(java.util.Arrays.asList(206, 147, 131, 304, 306));
                    for (int i = 0; i < Util.random(1, 4); i++) {
                        int ran = Util.random(100);
                        if (ran < 0) {
                            short id = Util.random(it7, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(2, 5);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 2) { //sách
                            short idsach = (short) Util.random(4577, 4585);
                            ids.add(new box_item_template(idsach, (short) 1, (byte) 3));
                            conn.p.item.add_item_bag3_default(idsach, 0, false);
                        } else if (ran < 5) {//nlmd vang tim
                            short id = (short) Util.random(126, 146);
                            short quant = (short) 1;
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 15) { // nltt
                            short id = (short) Util.random(417, 464);
                            short quant = (short) Util.random(2);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 28) {
                            short id = Util.random(it7_vip, new ArrayList<>()).shortValue();
                            short quant = (short) 1;
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 45) {
                            short id = Util.random(it4_vip, new ArrayList<>()).shortValue();
                            short quant = (short) 1;
                            ids.add(new box_item_template(id, quant, (byte) 4));
                            conn.p.item.add_item_bag47(id, quant, (byte) 4);
                        } else if (ran < 70) {
                            short id = Util.random(it4, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(1, 3);
                            ids.add(new box_item_template(id, quant, (byte) 4));
                            conn.p.item.add_item_bag47(id, quant, (byte) 4);
                        } else {
                            short id = Util.random(it7, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(1, 3);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        }
                    }
                    ev_he.Event_3.add_DoiQua(conn.p.name, 1);
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
//                    }catch(Exception e){e.printStackTrace();}
                }

                if (p0.item.get_bag_able() < 3) {
                    Service.send_notice_box(p0.conn, "Cần 3 ô trống trong hành trang để có thể nhận quà hoa đăng từ " + conn.p.name);
                    return;
                }

                List<box_item_template> ids = new ArrayList<>();

                List<Integer> it7 = new ArrayList<>(java.util.Arrays.asList(1, 2, 3));
                List<Integer> it7_vip = new ArrayList<>(java.util.Arrays.asList(12, 8, 9, 10));
                List<Integer> it4 = new ArrayList<>(java.util.Arrays.asList(48, 49, 50, 51, 18, 10));
                List<Integer> it4_vip = new ArrayList<>(java.util.Arrays.asList(205, 207, 24, 52, 275, 84));
                for (int i = 0; i < Util.random(1, 3); i++) {
                    int ran = Util.random(100);
                    if (ran < 0) {
                        short id = Util.random(it7, new ArrayList<>()).shortValue();
                        short quant = (short) Util.random(2, 5);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        p0.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran < 2) { // nltt
                        short id = (short) Util.random(417, 464);
                        short quant = (short) Util.random(2);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        p0.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran < 12) {
                        short id = Util.random(it4_vip, new ArrayList<>()).shortValue();
                        short quant = (short) 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        p0.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran < 27) {
                        short id = Util.random(it7_vip, new ArrayList<>()).shortValue();
                        short quant = (short) 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        p0.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran < 45) {
                        short id = Util.random(it4, new ArrayList<>()).shortValue();
                        short quant = (short) Util.random(1, 3);
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        p0.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran < 70) {
                        short id = Util.random(it7, new ArrayList<>()).shortValue();
                        short quant = (short) Util.random(1, 3);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        p0.item.add_item_bag47(id, quant, (byte) 7);
                    } else {
                        short id = (short) Util.random(new int[]{2, 5});
                        short quant = (short) Util.random(100, 300);
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        p0.item.add_item_bag47(id, quant, (byte) 4);
                    }
                }
                Service.Show_open_box_notice_item(p0, "Quà hoa đăng từ " + conn.p.name, ids);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Đã xảy ra lỗi");
                break;
            }

            case 31: { // ngọc ra coin
                if (size != 1) {
                    return;
                }
if (conn.vip < 2) {
        Service.send_notice_box(conn, "Dành cho Vip 2!");
        return;
    }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int ngoc_exchange = Integer.parseInt(value);
                if (ngoc_exchange < 0 || ngoc_exchange > 1_500_000) {
                    Service.send_notice_box(conn, "Chỉ có thể đổi tối thiểu là 1k và tối đa là 1m5!");
                    return;
                }

                if (conn.p.get_ngoc() >= ngoc_exchange) {
                    conn.p.update_ngoc(-ngoc_exchange);
                    try {
                        if (conn.p.update_coin((int) (ngoc_exchange / 10))) {
                            conn.p.item.char_inventory(5);
                            String percents = String.format("%,.0f", (((float) ngoc_exchange / 10)));
                            Service.send_notice_box(conn, "Đổi Thành công nhận được : " + percents + " coin!");
                            // Log.gI().add_log(conn.p.name, "đổi ngọc sang coin " + text + " : " + Util.number_format(ngoc_exchange) + " ngọc");
                        } else {
                            // Lỗi trong quá trình đổi hoàn ngọc
                            conn.p.update_ngoc(ngoc_exchange);
                            Service.send_notice_box(conn, "Thất bại xin hãy thử lại");
                        }
                    } catch (IOException e) {
                        // Lỗi Hệ thống như mkn hoàn lại ngọc
                        conn.p.update_ngoc(ngoc_exchange);
                        Service.send_notice_box(conn, "Thất bại xin hãy thử lại");
                    }
                } else {
                    Service.send_notice_box(conn, "Không đủ ngọc");
                }
                break;
            }

            case 32: { // tài xỉu
                if (size != 2) {
                    return;
                }
                String value1 = m2.reader().readUTF();
                String value2 = m2.reader().readUTF();
                if (!(Util.isnumber(value1)) || !(Util.isnumber(value2))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }
                int coin_join = Integer.parseInt(value1);
                int type_join = Integer.parseInt(value2);
                if (coin_join < 1_000 || coin_join > 10_000_000) {
                    Service.send_notice_box(conn, "Coin tối thiểu 1k!");
                    return;
                }
                if (!(type_join == 1 || type_join == 2)) {
                    Service.send_notice_box(conn, "Nhập 1 nếu bạn chọn tài và 2 nếu bạn chọn xỉu!!");
                    return;
                }
                if (!conn.p.update_coin(-coin_join)) {
                    Service.send_notice_box(conn, "Không đủ coin!");
                    return;
                }
                Manager.gI().tx.join(conn.p, coin_join, type_join);
                Service.send_notice_box(conn,
                        "Cược " + coin_join + " coin vào " + ((type_join == 1) ? "Tài" : "Xỉu") + " thành công");
                Player p = conn.p;

                break;
            }

            case 33: { // khtk
               if (conn.ac_admin <= 10) {
                    Service.send_notice_box(conn, "Chỉ admin mới mở được");
                    return;
                }
                    String value1 = m2.reader().readUTF();

                    try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement()) {
                        st.execute("UPDATE `account` SET `status` = '" + 1 + "' WHERE `id` = '" + value1 + "';");
                        connection.commit();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Service.send_notice_box(conn, "Có lỗi xảy ra");
                        return;
                    }
                    Service.send_notice_box(conn, " Khích hoạt thành công id: " + value1 + "");
                
                break;
            }

            case 34: { // nạp
                if (conn.ac_admin <= 10) { // nếu admin bé hưn
                    Service.send_notice_box(conn, "Chỉ admin mới mở được");
                    return;
                }
                    String value1 = m2.reader().readUTF();
                    String value2 = m2.reader().readUTF();
                    String value3 = m2.reader().readUTF();

                    if (!(Util.isnumber(value2) && Util.isnumber(value3))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    int sl_ = Integer.parseInt(value2);
                    int sl_1 = Integer.parseInt(value3);

                    if (sl_ < 0 || sl_1 < 0 || sl_ >= 2_000_000_000 || sl_1 >= 2_000_000_000) {
                        Service.send_notice_box(conn, "Số nhập không hợp lệ");
                        return;
                    }

                    String sql = "UPDATE `account` SET `tiennap` = `tiennap` + ?, `naptuan` = `naptuan` + ?, `tongnap` = `tongnap` + ?, `point_nap` = `point_nap` + ?, `coin` = `coin` + ? WHERE `id` = ?";
                    try (Connection connection = SQL.gI().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
                        ps.setString(1, value2);
                        ps.setString(2, value2);
                        ps.setString(3, value2);
                        ps.setString(4, value2);
                        ps.setString(5, value3);
                        ps.setString(6, value1);
                        ps.executeUpdate();
                        connection.commit();
                    }
                    Service.send_notice_box(conn, " Nạp Thành công cho id: " + value1 + "\nSố Tiền: " + value2 + "\nSố Coin: " + value3 + " ");               

                break;
            }

            case 35: { // senaptuan
               if (conn.ac_admin == 100 && conn.p.name.equals("xxdrak")) {
                    String value1 = m2.reader().readUTF();

                    try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement()) {
                        st.execute("UPDATE `account` SET `naptuan` = '" + 0 + "' ;");
                        connection.commit();
                        Service.send_notice_box(conn, " Đã Reset Nap Tuân Về: " + 0 + "");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Service.send_notice_box(conn, "Có lỗi xảy ra");
                        return;
                    } 
               }else {
                    Service.send_notice_box(conn, "bạn đéo đủ quyền");
               }
               
                break;
            }

            case 36: { // reset account
                if (conn.ac_admin != 100) {
                    Service.send_notice_box(conn, "Chỉ admin mới mở được");
                    return;
                }
                    String value1 = m2.reader().readUTF();

                    try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement()) {
                        st.execute("DELETE FROM `account` WHERE `status` ='" + 2 + "';");
                        st.execute("DELETE FROM `player` WHERE `status` ='" + 2 + "';");
                        st.execute("DELETE FROM `history_del_item`;");
                        st.execute("DELETE FROM `history_kmb2`;");
                        st.execute("DELETE FROM `history_vxmm`;");
                        connection.commit();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Service.send_notice_box(conn, "Có lỗi xảy ra");
                        return;
                    }
                    Service.send_notice_box(conn, " Đã Reset account có status : " + 2 + "");
                
                break;
            }

            case 37: {
                if (size != 1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }

                Short sl = Short.parseShort(value);
                if (sl >= 32_000 || sl <= 0) {
                    Service.send_notice_box(conn, "số lượng không hợp lệ!");
                    return;
                }

                if (sl > conn.p.tiemnang) {
                    Service.send_notice_box(conn, "Tiềm năng không đủ!");
                    return;
                }

                int value_ = Integer.parseInt(value);
                conn.p.tiemnang -= value_;
                conn.p.point1 += value_;
                MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                Service.send_char_main_in4(conn.p);
                Service.send_notice_box(conn, "Tăng thành công!");
                break;
            }
            case 38: {
                if (size != 1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }

                Short sl = Short.parseShort(value);
                if (sl > 32_000 || sl <= 0) {
                    Service.send_notice_box(conn, "số lượng không hợp lệ!");
                    return;
                }

                if (sl > conn.p.tiemnang) {
                    Service.send_notice_box(conn, "Tiềm năng không đủ!");
                    return;
                }

                int value_ = Integer.parseInt(value);
                conn.p.tiemnang -= value_;
                conn.p.point2 += value_;
                MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                Service.send_char_main_in4(conn.p);
                Service.send_notice_box(conn, "Tăng thành công!");
                break;
            }
            case 39: {
                if (size != 1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }

                Short sl = Short.parseShort(value);
                if (sl > 32_000 || sl <= 0) {
                    Service.send_notice_box(conn, "số lượng không hợp lệ!");
                    return;
                }

                if (sl > conn.p.tiemnang) {
                    Service.send_notice_box(conn, "Tiềm năng không đủ!");
                    return;
                }

                int value_ = Integer.parseInt(value);
                conn.p.tiemnang -= value_;
                conn.p.point3 += value_;
                MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                Service.send_char_main_in4(conn.p);
                Service.send_notice_box(conn, "Tăng thành công!");
                break;
            }
            case 40: {
                if (size != 1) {
                    return;
                }
                String value = m2.reader().readUTF();
                if (!(Util.isnumber(value))) {
                    Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                    return;
                }

                Short sl = Short.parseShort(value);
                if (sl > 32_000 || sl <= 0) {
                    Service.send_notice_box(conn, "số lượng không hợp lệ!");
                    return;
                }

                if (sl > conn.p.tiemnang) {
                    Service.send_notice_box(conn, "Tiềm năng không đủ!");
                    return;
                }

                int value_ = Integer.parseInt(value);
                conn.p.tiemnang -= value_;
                conn.p.point4 += value_;
                MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                Service.send_char_main_in4(conn.p);
                Service.send_notice_box(conn, "Tăng thành công!");
                break;
            }

            case 41: { // n?p
                if (conn.ac_admin > 10) {
                    Service.send_notice_box(conn, "Chỉ admin mới được truy cập");

                    String value1 = m2.reader().readUTF();
                    String value2 = m2.reader().readUTF();
                    String value3 = m2.reader().readUTF();

                    if (!(Util.isnumber(value2) && Util.isnumber(value3))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    int totalThrows = 1000000; // Số lần tung Xúc Xắc
                    int totalPossibilities = 6 * 6 * 6; // Tổng số khả năng

                    int countTai = 0;
                    int countXiu = 0;

                    // Tính xác suất
                    double taiProbability = (double) (Integer.parseInt(value1) * Integer.parseInt(value2) * Integer.parseInt(value3)) / totalPossibilities;
                    double xiuProbability = 1 - taiProbability;

                    Service.send_notice_box(conn, "Xác suất ra Tài: " + taiProbability + "\nXác suất ra Xỉu: " + xiuProbability + "");
                }

                break;
            }

            case 42: {
                String value1 = m2.reader().readUTF();
                Item3 it_pr = null;
                Player p = conn.p;
                for (int i = 0; i < conn.p.item.bag3.length; i++) {
                    Item3 it = conn.p.item.bag3[i];

                    if (it != null && it.id >= 4656 && it.id <= 4675) {
                        it_pr = it;
                        break;
                    }
                }

                if (it_pr == null) {
                    Service.send_notice_box(conn, "Không tìm thấy vật phẩm phù hợp");
                    return;
                }

                it_pr.clazz = (byte) Util.random(0, 4);

                if (it_pr.clazz >= 0 && it_pr.clazz <= 3) {// icon part vktt
                    int[] ids = {4672, 4673, 4675, 4674};
                    int[] types = {8, 9, 11, 10};
                    int[] parts = {21, 22, 20, 23};
                    int[] icons = {13111, 13112, 13114, 13113};

                    it_pr.id = (short) ids[it_pr.clazz];
                    it_pr.type = (byte) types[it_pr.clazz];
                    it_pr.part = (byte) parts[it_pr.clazz];
                    it_pr.icon = (short) icons[it_pr.clazz];
                }
                for (int i = 0; i < it_pr.op.size(); i++) {
                    Option op = it_pr.op.get(i);
                    if (op != null && op.id >= 0 && op.id <= 4) {
                        int _st = op.param;
                        int[] clazzOptions = {2, 4, 1, 3};
                        it_pr.op.set(i, new Option(clazzOptions[it_pr.clazz], _st, it_pr.id));
                    }

                    if (op != null && op.id >= 33 && op.id <= 36) {
                        int _st = op.param;
                        int[] clazzOptions = {33, 34, 35, 36};
                        it_pr.op.set(i, new Option(clazzOptions[it_pr.clazz], _st, it_pr.id));
                    }
                }
                int[] optionValues = {Integer.parseInt(value1)};
                int defaultQuantity = 500;

                for (int value : optionValues) {
                    it_pr.op.add(new Option(value, defaultQuantity, it_pr.id));
                }

                boolean suc = 15 > Util.random(100) || conn.ac_admin > 10;
                if (suc) {

                    it_pr.name = ItemTemplate3.item.get(it_pr.id).getName() + "";
                    it_pr.UpdateName();

                    conn.p.item.char_inventory(4);
                    conn.p.item.char_inventory(7);
                    conn.p.item.char_inventory(3);

                    Service.send_notice_box(conn, "Nhận Được " + it_pr.name + "");
                    conn.p.item.char_inventory(3);
                } else {
                    Service.send_notice_box(conn, "Nâng cấp thất bại!");
                }
                break;
            }

            case 43: {
                String value = m2.reader().readUTF();
                Service.chat_clan(conn.p.myclan, "" + value + "");
                break;
            }

            case 44: { // sửa tất cả các chỉ số
                if (conn.p.chon_item3_index != -1) { // Check if an item is selected
                    int value0 = Integer.parseInt(m2.reader().readUTF());
                    int value1 = Integer.parseInt(m2.reader().readUTF());
                    int value2 = Integer.parseInt(m2.reader().readUTF());

                    Item3 it = conn.p.item.bag3[conn.p.chon_item3_index];
                    if (it != null) {
                        for (int i = 0; i < it.op.size(); i++) {
                            Option op = it.op.get(i);
                            if (op != null && op.id >= value0 && op.id <= value1) {
                                it.op.set(i, new Option(op.id, value2, it.id));
                            }
                        }
                        boolean suc = 15 > Util.random(100) || conn.ac_admin > 10;
                        if (suc) {
                            it.name = ItemTemplate3.item.get(it.id).getName() + "";
                            it.UpdateName();

                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.item.char_inventory(3);
                            conn.p.chon_item3_index = -1;
                            Service.send_notice_box(conn, "Nhận Được " + it.name + "");
                            conn.p.item.char_inventory(3);
                        } else {
                            Service.send_notice_box(conn, "Nâng cấp thất bại!");
                        }
                    }
                }
                break;
            }

            case 45: { // đổi chỉ số
                if (conn.p.chon_item3 != null && conn.p.chon_option != -1) {
                    int value = Integer.parseInt(m2.reader().readUTF());
                    int selectedIndex = conn.p.chon_item3_index; // Lấy chỉ số của mục đã chọn
                    if (selectedIndex != -1 && conn.p.item.bag3[selectedIndex] != null
                            && conn.p.item.bag3[selectedIndex].id == conn.p.chon_item3.id) {

                        Item3 it_pr = conn.p.chon_item3;
                        Option op = it_pr.op.get(conn.p.chon_option);
                        op.setParam(value);
                        //it_pr.op.remove(conn.p.chon_option);

                        conn.p.item.bag3[selectedIndex] = conn.p.chon_item3; // Cập nhật mục cụ thể
                        conn.p.item.char_inventory(5);
                        conn.p.item.char_inventory(3);
                        Service.send_notice_box(conn, "Nhận Được " + it_pr.name + "");
                    }

                    // Đặt lại thông tin lựa chọn
                    conn.p.chon_item3 = null;
                    conn.p.chon_item3_index = -1; // Đặt lại chỉ số
                    conn.p.chon_option = -1;

                    // Gửi cập nhật tới client
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                }
                break;
            }

            case 46: {
                if (conn.p.chon_item3 != null && conn.p.chon_option != -1) {
                    int value = Integer.parseInt(m2.reader().readUTF());
                    int selectedIndex = conn.p.chon_item3_index; // Lấy chỉ số của mục đã chọn
                    if (selectedIndex != -1 && conn.p.item.bag3[selectedIndex] != null
                            && conn.p.item.bag3[selectedIndex].id == conn.p.chon_item3.id) {

                        Item3 it_pr = conn.p.chon_item3;
                        Option op = it_pr.op.get(conn.p.chon_option);
                        if (op != null) {
                            // 
                            it_pr.op.set(conn.p.chon_option, new Option(value, op.param, it_pr.id));
                        }

                        conn.p.item.bag3[selectedIndex] = conn.p.chon_item3; // Cập nhật mục cụ thể
                        conn.p.item.char_inventory(5);
                        conn.p.item.char_inventory(3);
                        Service.send_notice_box(conn, "Nhận Được " + it_pr.name + "");
                    }

                    // Đặt lại thông tin lựa chọn
                    conn.p.chon_item3 = null;
                    conn.p.chon_item3_index = -1; // Đặt lại chỉ số
                    conn.p.chon_option = -1;

                    // Gửi cập nhật tới client
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                }
                break;
            }

            case 47: { // thêm option
                if (conn.p.chon_item3_index != -1) { // Kiểm tra xem có mục nào được chọn không
                    int value0 = Integer.parseInt(m2.reader().readUTF());
                    int value1 = Integer.parseInt(m2.reader().readUTF());

                    Item3 it = conn.p.item.bag3[conn.p.chon_item3_index];
                    if (it != null) {
                       
                        it.op.add(new Option(value0, value1, it.id));

                        boolean suc = 15 > Util.random(100) || conn.ac_admin > 10;
                        if (suc) {
                            it.name = ItemTemplate3.item.get(it.id).getName() + "";
                            it.UpdateName();

                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.item.char_inventory(3);
                            conn.p.chon_item3_index = -1;
                            Service.send_notice_box(conn, "Nhận Được " + it.name + "");
                            conn.p.item.char_inventory(3);
                        } else {
                            Service.send_notice_box(conn, "Nâng cấp thất bại!");
                        }
                    }
                }
                break;
            }

            case 48: {
                if (conn.p.chon_item3 != null && conn.p.chon_option != -1) {
                    int value = Integer.parseInt(m2.reader().readUTF());
                    int selectedIndex = conn.p.chon_item3_index; // Lấy chỉ số của mục đã chọn
                    if (selectedIndex != -1 && conn.p.item.bag3[selectedIndex] != null
                            && conn.p.item.bag3[selectedIndex].id == conn.p.chon_item3.id) {

                        Item3 it_pr = conn.p.chon_item3;
                        Option op = it_pr.op.get(conn.p.chon_option);

                        it_pr.op.remove(conn.p.chon_option);

                        conn.p.item.bag3[selectedIndex] = conn.p.chon_item3; // Cập nhật mục cụ thể
                        conn.p.item.char_inventory(5);
                        conn.p.item.char_inventory(3);
                        Service.send_notice_box(conn, "Nhận Được " + it_pr.name + "");
                    }

                    // Đặt lại thông tin lựa chọn
                    conn.p.chon_item3 = null;
                    conn.p.chon_item3_index = -1; // Đặt lại chỉ số
                    conn.p.chon_option = -1;

                    // Gửi cập nhật tới client
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                }
                break;
            }

            case 49: { // tặng ngọc cho người chơi
            if (conn.ac_admin != 100) {
                    Service.send_notice_box(conn, "Chỉ admin mới mở được");
                    return;
                }
                String name_ = m2.reader().readUTF();
                long vang_ = Long.parseLong(m2.reader().readUTF());
                long ngoc_ = Long.parseLong(m2.reader().readUTF());
                Player p0 = Map.get_player_by_name(name_);

                if (p0 == null) {
                    Service.send_notice_box(conn, "Người chơi không online");
                    return;
                }

                if (vang_ < 0 || ngoc_ < 0 || vang_ > 3_000_000_000_000L || ngoc_ > 2000000000L) {
                    String message = (vang_ < 0 || ngoc_ < 0) ? "Không Thể Âm" : "Số lượng không thể vượt quá 2 tỷ";
                    Service.send_notice_box(conn, message);
                    return;
                }

                p0.update_vang(vang_);
                p0.update_ngoc(ngoc_);
                String pe1 = String.format("%,.0f", (((float) vang_)));
                String pe2 = String.format("%,.0f", (((float) ngoc_)));
                Service.send_notice_box(conn, "Tặng\n " + pe1 + " Vàng\n " + pe2 + " Ngọc\n Cho " + p0.name);
                Service.send_notice_box(p0.conn, "Nhận " + pe1 + " Vàng\n " + pe2 + " Ngọc\n Từ " + conn.p.name);

                break;
            }

            case 50: {
                if (size != 2) {
                    return;
                }
                String oldName = m2.reader().readUTF();  // Tên cũ của nhân vật
                String newName = m2.reader().readUTF();  // Tên mới của nhân vật

                // Kiểm tra nếu tên mới hợp lệ
                //Pattern p = Pattern.compile("^[a-zA-Z0-9]{5,15}$");
                // if (!p.matcher(newName).matches()) {
                // Service.send_notice_box(conn, "Tên mới không hợp lệ, hãy thử lại");
                // return;
                // }
                // Kiểm tra xem tên cũ có khớp với tài khoản hiện tại không
                try (Connection connection = SQL.gI().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT `char` FROM account WHERE user = ?")) {
                    ps.setString(1, conn.user);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        String chars = rs.getString("char");
                        if (!chars.contains(oldName)) {
                            Service.send_notice_box(conn, "Tên cũ không khớp với nhân vật của bạn.");
                            return;
                        }
                    } else {
                        Service.send_notice_box(conn, "Tài khoản không tồn tại.");
                        return;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Service.send_notice_box(conn, "Có lỗi xảy ra khi kiểm tra tên cũ.");
                    return;
                }

                // Kiểm tra xem tên mới đã tồn tại hay chưa
                try (Connection connection = SQL.gI().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT name FROM player WHERE name = ?")) {
                    ps.setString(1, newName);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        Service.send_notice_box(conn, "Tên mới đã tồn tại, hãy chọn tên khác");
                        return;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Service.send_notice_box(conn, "Có lỗi xảy ra khi kiểm tra tên mới.");
                    return;
                }

                // Bắt đầu tiến hành đổi tên
                try (Connection connection = SQL.gI().getConnection(); PreparedStatement ps1 = connection.prepareStatement("UPDATE account SET `char` = REPLACE(`char`, ?, ?) WHERE user = ?"); PreparedStatement ps2 = connection.prepareStatement("UPDATE player SET name = ? WHERE name = ?")) {

                    // Cập nhật tên trong bảng account
                    ps1.setString(1, oldName);  // Tên cũ
                    ps1.setString(2, newName);  // Tên mới
                    ps1.setString(3, conn.user); // Tài khoản người dùng
                    ps1.executeUpdate();

                    // Cập nhật tên trong bảng player
                    ps2.setString(1, newName);  // Tên mới
                    ps2.setString(2, oldName);  // Tên cũ
                    ps2.executeUpdate();

                    connection.commit(); // Xác nhận thay đổi

                    // Thông báo thành công
                    Service.send_notice_box(conn, "Đổi tên thành công!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Service.send_notice_box(conn, "Có lỗi xảy ra trong quá trình đổi tên");
                }
                break;
            }

            case 51: { // Xử lý nhận vé ngọc
                String inputQuantity = m2.reader().readUTF(); // Đọc số lượng nhập từ người chơi
                if (!Util.isnumber(inputQuantity)) { // Kiểm tra số lượng có phải số không
                    Service.send_notice_box(conn, "Số lượng nhập không hợp lệ!");
                    return;
                }

                int quantity = Integer.parseInt(inputQuantity); // Chuyển số lượng thành số nguyên
                if (quantity <= 0) { // Kiểm tra số lượng phải lớn hơn 0
                    Service.send_notice_box(conn, "Số lượng phải lớn hơn 0!");
                    return;
                }

                int totalCost = quantity * 50000; // Tính tổng chi phí dựa trên số lượng

                if (conn.p.item.get_bag_able() < quantity) { // Kiểm tra có đủ ô trống trong hành trang không
                    Service.send_notice_box(conn, "Cần ít nhất " + quantity + " ô trống trong hành trang!");
                    return;
                }

                if (conn.p.get_point_nap() < totalCost) { // Kiểm tra người chơi có đủ điểm nạp không
                    Service.send_notice_box(conn, "Không đủ " + totalCost + " Điểm Nạp!");
                    return;
                }

                // Danh sách các item được nhận
                List<box_item_template> ids = new ArrayList<>();
                int itemId = 329; // ID của vé ngọc

                // Thêm một vé ngọc vào danh sách với tổng số lượng yêu cầu
                short quant = (short) quantity; // Số lượng vé ngọc
                ids.add(new box_item_template((short) itemId, quant, (byte) 4));

                // Thêm item vào hành trang
                conn.p.item.add_item_bag47((short) itemId, quant, (byte) 4);

                conn.p.update_point_nap(-totalCost); // Trừ tổng điểm nạp
                ev_he.Event_3.add_DoiQua(conn.p.name, quantity); // Ghi nhận giao dịch
                Service.Show_open_box_notice_item(conn.p, "Bạn Nhận Được " + quantity + " Vé Ngọc", ids); // Thông báo chỉ với 1 icon và số lượng
                break;
            }

            case 52: {
                int value = Integer.parseInt(m2.reader().readUTF());

                Message mm = new Message(75);
                mm.writer().writeByte(value);
                mm.writer().writeByte(0);
                mm.writer().writeShort(conn.p.index);
                mm.writer().writeShort(30);
                mm.writer().writeByte(0);
                mm.writer().writeShort(conn.p.index);
                for (int i = 0; i < conn.p.map.players.size(); i++) {
                    conn.p.map.players.get(i).conn.addmsg(mm);
                }
                mm.cleanup();
                /*
                int value = Integer.parseInt(m2.reader().readUTF());

                Message m = new Message(-49);
                byte[] data = Util.loadfile("data/part_char/imgver/x" + conn.zoomlv + "/Data/" + (111 + "_" + value));
                m.writer().writeByte(0);
                m.writer().writeShort(data.length);
                m.writer().write(data);

                m.writer().writeByte(0);
                m.writer().writeByte(1);
                m.writer().writeByte(value);// id part char
                
                m.writer().writeShort(conn.id =1);
                m.writer().writeByte(1);//tem mob
                m.writer().writeByte(0);
                m.writer().writeShort(8000);
                m.writer().writeByte(0);
                conn.addmsg(m);
                m.cleanup();*/
            }
            
            case 53: { // Góp nguyên liệu nấu Bánh
                if (Manager.gI().event == 5) {
                    if (size != 1) {
                        return;
                    }
                    String value = m2.reader().readUTF();
                    if (!(Util.isnumber(value))) {
                        Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
                        return;
                    }
                    int quant = Integer.parseInt(value);
                    if (quant > 500 || quant <= 0) {
                        Service.send_notice_box(conn, "Số lượng không hợp lệ!");
                        return;
                    }
                    //
                    if (conn.ac_admin < 10) {
                    short[] id = new short[]{28, 29, 89, 30};
                    for (int i = 0; i < id.length; i++) {
                        if (conn.p.item.total_item_by_id(4, id[i]) < (quant)) {
                            Service.send_notice_box(conn, (ItemTemplate4.item.get(id[i]).getName() + " không đủ!"));
                            return;
                        }
                    }
                      
                    for (int i = 0; i < id.length; i++) {
                        conn.p.item.remove(4, id[i], quant);
                    }
                      }
                    Event_5.add_naubanh(conn.p.name, quant);
                    //
                    conn.p.item.char_inventory(4);
                    conn.p.item.char_inventory(7);
                    conn.p.item.char_inventory(3);
                    //
                    Service.send_notice_box(conn, "Đóng góp nguyên liệu nấu " + quant + " Bánh");
                }
                break;
            }
                       
     case 54: { // Đổi Bánh dày
    if (Manager.gI().event == 5) {
        if (size != 1) {
            return;
        }
        String value = m2.reader().readUTF();
        if (!Util.isnumber(value)) {
            Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
            return;
        }
        int quant = Integer.parseInt(value);
        if (quant > 32000 || quant <= 0) {
            Service.send_notice_box(conn, "Số lượng không hợp lệ!");
            return;
        }
        if (conn.p.get_vang() < quant * 500_000) {
            Service.send_notice_box(conn, "Không đủ " + (quant * 500_000) + " vàng");
            return;
        }
        //
        if (conn.ac_admin < 10) {
            short[] id = new short[]{28, 29, 89, 33};
            int sl =5;          
            for (int i = 0; i < id.length; i++) {
                if (conn.p.item.total_item_by_id(4, id[i]) < (quant * sl)) {
                    Service.send_notice_box(conn, ItemTemplate4.item.get(id[i]).getName() + " không đủ!");
                    return;
                }
            }
            
            for (int i = 0; i < id.length; i++) {
                conn.p.item.remove(4, id[i], quant * sl);
            }
        }
        //
        Item47 it = new Item47();
        it.category = 4;
        it.id = 195;
        it.quantity = (short) quant;
        conn.p.item.add_item_bag47(4, it);
        //
        conn.p.update_vang(-quant * 500_000);
        conn.p.item.char_inventory(4);
        conn.p.item.char_inventory(7);
        conn.p.item.char_inventory(3);
        //
        Service.send_notice_box(conn, "Nhận được " + quant + " Bánh dày");
    }
    break;
}

case 55: { // Đổi chữ
    if (Manager.gI().event == 5) {
        if (size != 1) {
            return;
        }
        String value = m2.reader().readUTF();
        if (!Util.isnumber(value)) {
            Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
            return;
        }
        int quant = Integer.parseInt(value);
        if (quant > 32000 || quant <= 0) {
            Service.send_notice_box(conn, "Số lượng không hợp lệ!");
            return;
        }
        if (conn.p.get_vang() < quant * 5_000_000) {
            Service.send_notice_box(conn, "Không đủ " + (quant * 5_000_000) + " vàng");
            return;
        }
        //
        if (conn.ac_admin < 10) {
            short[] id = new short[]{184,185,185,186,187,188,189,190,191};
            int sl =1;          
            for (int i = 0; i < id.length; i++) {
                if (conn.p.item.total_item_by_id(4, id[i]) < (quant * sl)) {
                    Service.send_notice_box(conn, ItemTemplate4.item.get(id[i]).getName() + " không đủ!");
                    return;
                }
            }
            
            for (int i = 0; i < id.length; i++) {
                conn.p.item.remove(4, id[i], quant * sl);
            }
        }
        //
        Item47 it = new Item47();
        it.category = 4;
        it.id = 194;
        it.quantity = (short) quant;
        conn.p.item.add_item_bag47(4, it);
        //
        conn.p.update_vang(-quant * 5_000_000);
        conn.p.item.char_inventory(4);
        conn.p.item.char_inventory(7);
        conn.p.item.char_inventory(3);
        //
        Service.send_notice_box(conn, "Nhận được " + quant + " Hộp quà thọ");
    }
    break;
}

case 56: { // Dâng bánh
    if (Manager.gI().event == 5) {
        if (size != 1) {
            return;
        }
        String value = m2.reader().readUTF();
        if (!Util.isnumber(value)) {
            Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
            return;
        }
        int quant_ = Integer.parseInt(value);
        if (quant_ > 32000 || quant_ <= 0) {
            Service.send_notice_box(conn, "Số lượng không hợp lệ!");
            return;
        }
        if (conn.p.get_vang() < quant_ * 500_000) {
            Service.send_notice_box(conn, "Không đủ " + (quant_ * 500_000) + " vàng");
            return;
        }
        
        // Kiểm tra và trừ nguyên liệu (các id 31 và 195)
        if (conn.ac_admin < 10) {
            short[] arrId = new short[]{31, 195};
            int sl = 1;
            for (short id : arrId) {
                if (conn.p.item.total_item_by_id(4, id) < (quant_ * sl)) {
                    Service.send_notice_box(conn, ItemTemplate4.item.get(id).getName() + " không đủ!");
                    return;
                }
            }
            for (short id : arrId) {
                conn.p.item.remove(4, id, quant_ * sl);
            }
        }
        
        // Kiểm tra không gian túi đồ
        if (conn.p.item.get_bag_able() <= 5) {
            Service.send_notice_box(conn, "Hành trang đầy");
            return;
        }
        
        // Sinh phần thưởng cho mỗi lượt đóng góp
        List<box_item_template> rewards = new ArrayList<>();
        List<Integer> item3 = Arrays.asList(4718, 4719);
        List<Integer> duclo = Arrays.asList(33, 44, 45);
        List<Integer> ngockham = Arrays.asList(354, 355, 356, 359, 360, 361, 364, 365, 366, 369, 370, 371, 374, 375, 376, 379, 380, 381);
        
        for (int i = 0; i < quant_; i++) {
            int ran = Util.random(101);
            if (ran > 100.999999) { // tai nghe
                short idsach = Util.random(item3, new ArrayList<>()).shortValue();
                rewards.add(new box_item_template(idsach, (short)1, (byte)3));
                conn.p.item.add_item_bag3_default(idsach, 0, false);
            } else if (ran > 100) { // Cũng sách 110
                short idsach = (short) Util.random(4577, 4585);
                rewards.add(new box_item_template(idsach, (short)1, (byte)3));
                conn.p.item.add_item_bag3_default(idsach, 0, false);
            } else if (ran > 95 && ran <= 99) { // NL MD
                short idItem = (short) Util.random(46, 346);
                short q = 1;
                rewards.add(new box_item_template(idItem, q, (byte)7));
                conn.p.item.add_item_bag47(idItem, q, (byte)7);
            } else if (ran > 90 && ran <= 95) { // NL TT
                short idItem = (short) Util.random(417, 464);
                short q = 1;
                rewards.add(new box_item_template(idItem, q, (byte)7));
                conn.p.item.add_item_bag47(idItem, q, (byte)7);
            } else if (ran > 85 && ran < 88) { // Đục
                short idItem = Util.random(duclo, new ArrayList<>()).shortValue();
                short q = 1;
                rewards.add(new box_item_template(idItem, q, (byte)7));
                conn.p.item.add_item_bag47(idItem, q, (byte)7);
            } else if (ran > 70 && ran < 80) { // Vé đi buôn
                short idItem = 147;
                short q = (short) Util.random(0, 5);
                rewards.add(new box_item_template(idItem, q, (byte)4));
                conn.p.item.add_item_bag47(idItem, q, (byte)4);
            } else if (ran > 60 && ran < 70) { // Vé mở ly
                short idItem = 52;
                short q = (short) Util.random(1, 10);
                rewards.add(new box_item_template(idItem, q, (byte)4));
                conn.p.item.add_item_bag47(idItem, q, (byte)4);
            } else if (ran > 40 && ran < 55) { // Ngọc khảm
                short idItem = Util.random(ngockham, new ArrayList<>()).shortValue();
                short q = 1;
                rewards.add(new box_item_template(idItem, q, (byte)7));
                conn.p.item.add_item_bag47(idItem, q, (byte)7);
            } else if (ran > 20 && ran < 35) { // Sách nâng skill
                short idItem = (short) Util.random(472, 480);
                short q = (short) Util.random(1, 5);
                rewards.add(new box_item_template(idItem, q, (byte)7));
                conn.p.item.add_item_bag47(idItem, q, (byte)7);
            } else if (ran > 10 && ran < 20) { // Hồ quang
                short idItem = (short) Util.random(472, 480);
                short q = (short) Util.random(1, 5);
                rewards.add(new box_item_template(idItem, q, (byte)7));
                conn.p.item.add_item_bag47(idItem, q, (byte)7);
            } else {
                //Service.send_notice_nobox_white(conn, "Đen vl. Bạn dell đc gì");
            }
        }
        
        // Gộp các phần thưởng trùng nhau dựa trên id (bỏ qua type)
        java.util.Map<Short, box_item_template> mergedMap = new java.util.HashMap<>();
        for (box_item_template reward : rewards) {
            short key = reward.id;
            if (mergedMap.containsKey(key)) {
                box_item_template existing = mergedMap.get(key);
                existing.quantity = (short)(existing.quantity + reward.quantity);
            } else {
                mergedMap.put(key, new box_item_template(reward.id, reward.quantity, reward.catagory));
            }
        }
        List<box_item_template> mergedList = new ArrayList<>(mergedMap.values());
        
        conn.p.item.char_inventory(4);
        conn.p.item.char_inventory(7);
        conn.p.item.char_inventory(3);
        Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", mergedList);
    }
    break;
}
//
case 57: { // Đốt Pháo
    if (Manager.gI().event == 5) {
        if (size != 1) {
            return;
        }
        String value = m2.reader().readUTF();
        if (!Util.isnumber(value)) {
            Service.send_notice_box(conn, "Dữ liệu nhập không phải số!!");
            return;
        }
        int quant_ = Integer.parseInt(value);
        if (quant_ > 32000 || quant_ <= 0) {
            Service.send_notice_box(conn, "Số lượng không hợp lệ!");
            return;
        }
        if (conn.p.get_vang() < quant_ * 5_000_000) {
            Service.send_notice_box(conn, "Không đủ " + (quant_ * 5_000_000) + " vàng");
            return;
        }
        if (conn.p.get_ngoc() < quant_ * 5_000) {
            Service.send_notice_box(conn, "Không đủ " + (quant_ * 5_000) + " ngọc");
            return;
        }
        
        // Kiểm tra và trừ nguyên liệu (các id 31 và 195) – giả sử ở đây dùng arrId là 129 và 259 như cũ
        if (conn.ac_admin < 10) {
            short[] arrId = new short[]{129, 259};
            int sl = 1;
            for (short id : arrId) {
                if (conn.p.item.total_item_by_id(4, id) < (quant_ * sl)) {
                    Service.send_notice_box(conn, ItemTemplate4.item.get(id).getName() + " không đủ!");
                    return;
                }
            }
            for (short id : arrId) {
                conn.p.item.remove(4, id, quant_ * sl);
            }
        }
        
        // Kiểm tra không gian túi đồ
        if (conn.p.item.get_bag_able() <= 5) {
            Service.send_notice_box(conn, "Hành trang đầy");
            return;
        }
        
        List<box_item_template> rewards = new ArrayList<>();
        for (int i = 0; i < quant_; i++) {
            short rewardId = (short) Util.ngaunhien(184, 191);
            rewards.add(new box_item_template(rewardId, (short)1, (byte)4));
            conn.p.item.add_item_bag47(rewardId, (short)1, (byte)4);
        }
        
        // Gộp các phần thưởng trùng nhau dựa trên id (bỏ qua type)
        java.util.Map<Short, box_item_template> mergedMap = new java.util.HashMap<>();
        for (box_item_template reward : rewards) {
            short key = reward.id;
            if (mergedMap.containsKey(key)) {
                box_item_template existing = mergedMap.get(key);
                existing.quantity = (short)(existing.quantity + reward.quantity);
            } else {
                mergedMap.put(key, new box_item_template(reward.id, reward.quantity, reward.catagory));
            }
        }
        List<box_item_template> mergedList = new ArrayList<>(mergedMap.values());
        conn.p.update_vang(-quant_ * 5_000_000);
        conn.p.update_ngoc(-quant_ * 5_000);
        Event_5.add_dotphao(conn.p.name, quant_);
        //Event_5.add_moqua(conn.p.name, quant_);
        Map.Sen_eff_111(conn.p, (byte) 62);
        conn.p.item.char_inventory(4);
        conn.p.item.char_inventory(7);
        conn.p.item.char_inventory(3);
        Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", mergedList);
    }
    break;
}

//
        }
    }
}
