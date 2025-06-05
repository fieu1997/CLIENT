package template;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ax_item {

    // Hàm lấy dữ liệu JSON từ cơ sở dữ liệu và chuyển thành danh sách ánh xạ
    public static List<List<Short>> getIdMappingsById(Connection conn, int id, String tableName) throws Exception {
        String sql = "SELECT data FROM " + tableName + " WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        String jsonData = null;
        if (rs.next()) {
            jsonData = rs.getString("data");
        }
        rs.close();
        stmt.close();

        // Phân tích chuỗi JSON thành danh sách ánh xạ List<List<Short>>
        return parseJsonDataToList(jsonData);
    }

    // Hàm phân tích chuỗi JSON thành List<List<Short>>
    private static List<List<Short>> parseJsonDataToList(String jsonData) {
        List<List<Short>> idMappings = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) JSONValue.parse(jsonData);

        for (Object obj : jsonArray) {
            JSONArray innerArray = (JSONArray) obj;
            List<Short> mapping = new ArrayList<>();
            mapping.add(Short.parseShort(innerArray.get(0).toString())); // ID ảo
            mapping.add(Short.parseShort(innerArray.get(1).toString())); // ID gốc
            if (innerArray.size() > 2) { // Chỉ thêm giá tiền và loại tiền nếu có (chỉ dành cho item7 và item4)
                mapping.add(Short.parseShort(innerArray.get(2).toString())); // Giá tiền
                mapping.add(Short.parseShort(innerArray.get(3).toString())); // Loại tiền
            }
            idMappings.add(mapping);
        }

        return idMappings;
    }

    // Hàm tạo item ảo từ cơ sở dữ liệu
    public static void addVirtualItemsFromDB(Connection conn, int id, String tableName, int Type) {
        try {
            List<List<Short>> idMappings = getIdMappingsById(conn, id, tableName);

            for (List<Short> mapping : idMappings) {
                short virtualId = mapping.get(0); // ID ảo
                short originalId = mapping.get(1); // ID gốc

                switch (Type) {
                    case 7:
                        long price7 = mapping.size() > 2 ? mapping.get(2) : 0; // Giá tiền (nếu có)
                        byte pricetype7 = mapping.size() > 3 ? mapping.get(3).byteValue() : -1; // Loại tiền (nếu có)
                        addVirtualItem7(virtualId, originalId, price7, pricetype7);
                        break;

                    case 4:
                        long price4 = mapping.size() > 2 ? mapping.get(2) : 0; // Giá tiền (nếu có)
                        byte pricetype4 = mapping.size() > 3 ? mapping.get(3).byteValue() : -1; // Loại tiền (nếu có)
                        addVirtualItem4(virtualId, originalId, price4, pricetype4);
                        break;

                    case 3:
                        addVirtualItem3(virtualId, originalId);
                        break;

                    default:
                        System.out.println("Loại item không hợp lệ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm tạo item ảo từ ItemTemplate7, bao gồm cả giá tiền và loại tiền
    private static void addVirtualItem7(short virtualId, short originalId, long price, byte pricetype) {
        ItemTemplate7 originalItem = null;
        for (ItemTemplate7 item : ItemTemplate7.item) {
            if (item.getId() == originalId) {
                originalItem = item;
                break;
            }
        }

        if (originalItem != null) {
            ItemTemplate7 virtualItem = new ItemTemplate7();
            virtualItem.setId(virtualId);
            virtualItem.setName(originalItem.getName());
            virtualItem.setIcon(originalItem.getIcon());
            virtualItem.setType(originalItem.getType());
            virtualItem.setPrice(price > 0 ? price : originalItem.getPrice());
            virtualItem.setPricetype(pricetype != -1 ? pricetype : originalItem.getPricetype());
            virtualItem.setSell(originalItem.getSell());
            virtualItem.setValue(originalItem.getValue());
            virtualItem.setTrade(originalItem.getTrade());
            virtualItem.setColor(originalItem.getColor());
            virtualItem.setContent(originalItem.getContent()); // Sao chép thêm nội dung nếu cần

            ItemTemplate7.item.add(virtualItem);
            System.out.println("Item ảo Item7 được tạo: ID " + virtualId + " từ ID gốc " + originalId + " với giá tiền " + price + " và loại tiền " + (pricetype == 0 ? "vàng" : "ngọc"));
        } else {
            System.out.println("Không tìm thấy item gốc với ID " + originalId);
        }
    }

    // Hàm tạo item ảo từ ItemTemplate4, bao gồm cả giá tiền và loại tiền
    private static void addVirtualItem4(short virtualId, short originalId, long price, byte pricetype) {
        ItemTemplate4 originalItem = null;
        for (ItemTemplate4 item : ItemTemplate4.item) {
            if (item.getId() == originalId) {
                originalItem = item;
                break;
            }
        }

        if (originalItem != null) {
            ItemTemplate4 virtualItem = new ItemTemplate4();
            virtualItem.setId(virtualId);
            virtualItem.setName(originalItem.getName());
            virtualItem.setIcon(originalItem.getIcon());
            virtualItem.setType(originalItem.getType());
            virtualItem.setPrice(price > 0 ? price : originalItem.getPrice());
            virtualItem.setPricetype(pricetype != -1 ? pricetype : originalItem.getPricetype());
            virtualItem.setSell(originalItem.getSell());
            virtualItem.setValue(originalItem.getValue());
            virtualItem.setTrade(originalItem.getTrade());
            virtualItem.setContent(originalItem.getContent()); // Sao chép thêm nội dung nếu cần

            ItemTemplate4.item.add(virtualItem);
            System.out.println("Item ảo ITem4 được tạo: ID " + virtualId + " từ ID gốc " + originalId + " với giá tiền " + price + " và loại tiền " + (pricetype == 0 ? "vàng" : "ngọc"));
        } else {
            System.out.println("Không tìm thấy item gốc với ID " + originalId);
        }
    }

    // Hàm tạo item ảo từ ItemTemplate3 chỉ với ID ảo và ID gốc
    private static void addVirtualItem3(short virtualId, short originalId) {
        ItemTemplate3 originalItem = null;
        for (ItemTemplate3 item : ItemTemplate3.item) {
            if (item.getId() == originalId) {
                originalItem = item;
                break;
            }
        }

        if (originalItem != null) {
            ItemTemplate3 virtualItem = new ItemTemplate3();
            virtualItem.setId(virtualId);
            virtualItem.setName(originalItem.getName());
            virtualItem.setIcon(originalItem.getIcon());
            virtualItem.setType(originalItem.getType());
            virtualItem.setPart(originalItem.getPart());
            virtualItem.setClazz(originalItem.getClazz());
            virtualItem.setLevel(originalItem.getLevel());
            virtualItem.setColor(originalItem.getColor());
            virtualItem.setOp(new ArrayList<>(originalItem.getOp())); // Sao chép các thuộc tính bổ sung nếu có

            ItemTemplate3.item.add(virtualItem);
            System.out.println("Item ảo ITEM 3 được tạo: ID " + virtualId + " từ ID gốc " + originalId);
        } else {
            System.out.println("Không tìm thấy item gốc với ID " + originalId);
        }
    }
}
