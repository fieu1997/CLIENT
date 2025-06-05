
package ev_he;

import client.Player;
import core.Log;
import core.Manager;
import core.SaveData;
import core.Service;
import core.Util;
import io.Session;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import map.Map;
import map.MapService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import template.Item3;
import template.ItemTemplate3;
import template.Option;


public class Event_4 {
    private static String name_event = "sự kiện Vua Hùng";
    public static final CopyOnWriteArrayList<MobMiNuong> entrys = new CopyOnWriteArrayList<>();
    public static long timeCreate;
    public static final List<BXH_DoiQua> list_DatMiNuong = new ArrayList<>();
    
    public static MobMiNuong getMob(int idx){
        for(MobMiNuong m : entrys){
            if(m.index == idx )
                return m;
        }
        return null;
    }
    
    public static void addmob(MobMiNuong mob){
        synchronized(entrys){
            if(!entrys.contains(mob)){
                entrys.add(mob);
            }
        }
    }
    public static void removemob(MobMiNuong mob){
        try{
            synchronized(entrys){
                mob.MobLeave();
                entrys.remove(mob);
            }
        }
        catch(Exception e){}
        
    }
    
    public static void ClearMob(){
        long time = System.currentTimeMillis();
        synchronized(entrys){
            for(MobMiNuong mob:entrys)
            {
                try{
                    mob.MobLeave();
                }
                catch(Exception e){}
            }
            entrys.clear();
        }
        if(timeCreate > 0 && (time - timeCreate) / 1000 / 60 > 44){
            
        }
    }
    
    public static void ResetMob() throws IOException {
    long time = System.currentTimeMillis();
    timeCreate = time;
    short idx = 30000;

    // Danh sách các ID map mục tiêu
    int[] targetMapIds = {5, 8, 9, 11, 12, 13, 15, 16, 17};

    // Trộn danh sách map mục tiêu và chọn ngẫu nhiên 2 map
    List<Integer> selectedMapIds = new ArrayList<>();
    for (int id : targetMapIds) {
        selectedMapIds.add(id);
    }
    Collections.shuffle(selectedMapIds);
    selectedMapIds = selectedMapIds.subList(0, 3);  // Lấy ngẫu nhiên 2 map

    synchronized (entrys) {
        for (Map[] mapArray : Map.entrys) {
            for (Map m : mapArray) {
                if (m == null || m.ismaplang || m.showhs || m.typemap != 0 || Map.is_map_cant_save_site(m.map_id)) continue;

                // Kiểm tra xem ID của map có nằm trong 2 map đã chọn không
                if (selectedMapIds.contains((int) m.map_id)) {
                    // Chọn ngẫu nhiên một khu (zone_id) từ 1 đến 7
                    int randomZoneId = Util.random(1, 7);

                    // Tìm khu có zone_id ngẫu nhiên này
                    for (Map zone : mapArray) {
                        if (zone != null && zone.map_id == m.map_id && zone.zone_id == randomZoneId) {
                            short leng = (short) 1;  // Số lượng mob ngẫu nhiên
                            for (int j = 0; j < leng; j++) {
                                MobMiNuong mob = new MobMiNuong(zone, idx);
                                addmob(mob);
                                idx++;

                                // Log thông tin về map và khu
                                System.out.println("MobMiNuong xuất hiện ở map ID: " + zone.map_id + ", khu ID: " + zone.zone_id);
                            }
                            break;  // Chỉ cần xử lý 1 khu trong mỗi map
                        }
                    }
                }
            }
        }
        Manager.gI().chatKTGprocess("Mỵ nương đã xuất hiện hãy nhanh chân lên nào");
    }
}



    
    public static void Update(){
        try{
            long time = System.currentTimeMillis();
            if(time - timeCreate > 1000 * 60 * 28 && !entrys.isEmpty())
                ClearMob();
            if(time - timeCreate > 1000 * 60 * 30)
                ResetMob();
            for(MobMiNuong mob: entrys){
                mob.update();
            }
            
        }catch(Exception e){}
    }
    
    public static class BXH_DoiQua {

        public String name;
        public int quant;
        public long time;

        public BXH_DoiQua(String name2, int integer, long t) {
            name = name2;
            quant = integer;
            time = t;
        }
    }
    // add point
    public static void add_topbxh(String name, int quant) {
        synchronized(list_DatMiNuong){
            for (int i = 0; i < list_DatMiNuong.size(); i++) {
                if (list_DatMiNuong.get(i).name.equals(name)) {
                    list_DatMiNuong.get(i).quant += quant;
                    list_DatMiNuong.get(i).time = System.currentTimeMillis();
                    return;
                }
            }
            list_DatMiNuong.add(new BXH_DoiQua(name, quant, System.currentTimeMillis()));
        }
    }
    public static void LoadDB(JSONObject jsob){
        synchronized(list_DatMiNuong){
            list_DatMiNuong.clear();
            long t_ = System.currentTimeMillis();
            JSONArray jsar_1 = (JSONArray) JSONValue.parse(jsob.get("list_dat_mi_nuong").toString());
            for (int i = 0; i < jsar_1.size(); i++) {
                JSONArray jsar_2 = (JSONArray) JSONValue.parse(jsar_1.get(i).toString());
                list_DatMiNuong.add(new BXH_DoiQua(jsar_2.get(0).toString(), Integer.parseInt(jsar_2.get(1).toString()), t_));
            }
            jsar_1.clear();
        }
    }
    public static JSONObject SaveData(){
        synchronized(list_DatMiNuong){
            JSONArray jsar_1 = new JSONArray();
            for (int i = 0; i < list_DatMiNuong.size(); i++) {
                JSONArray jsar_2 = new JSONArray();
                jsar_2.add(list_DatMiNuong.get(i).name);
                jsar_2.add(list_DatMiNuong.get(i).quant);
                jsar_1.add(jsar_2);
            }
            //
            JSONObject jsob = new JSONObject();
            jsob.put("list_dat_mi_nuong", jsar_1);
            return jsob;
        }
    }
    public static void sort_bxh() {
    synchronized(list_DatMiNuong){
        Collections.sort(list_DatMiNuong, new Comparator<BXH_DoiQua>() {
            @Override
            public int compare(BXH_DoiQua o1, BXH_DoiQua o2) {
                // Sắp xếp theo số lượng (quant) từ cao xuống thấp
                int compare = Integer.compare(o2.quant, o1.quant);  // o2 trước o1 để sắp xếp giảm dần
                if (compare != 0) {
                    return compare;
                }
                // Nếu điểm bằng nhau, sắp xếp theo thời gian (time) từ sớm đến muộn
                return Long.compare(o1.time, o2.time);
            }
        });
    }
}

public static String[] get_top() {
    synchronized(list_DatMiNuong){
        if (list_DatMiNuong.isEmpty()) {
            return new String[]{"Chưa có thông tin"};
        }
        // Sắp xếp bảng xếp hạng trước khi hiển thị
         SaveData.process();
        sort_bxh();
        
        String[] top;
        if (list_DatMiNuong.size() < 10) {
            top = new String[list_DatMiNuong.size()];
        } else {
            top = new String[10];  // Giới hạn top 10
        }

        // Hiển thị danh sách top
        for (int i = 0; i < top.length; i++) {
            top[i] = "Top " + (i + 1) + " : " + list_DatMiNuong.get(i).name + " : " + list_DatMiNuong.get(i).quant + " điểm";
        }
        return top;
    }
}
    public static boolean isBuyItemSK(Session conn,int cat, int idbuy, int quant)throws IOException{
        List<Integer> it3 = new ArrayList<>(java.util.Arrays.asList(4714,4715,4769,4770,4771,4772,4716,4717,4718,4719));
        //System.out.println("ev_he.Event_2.isBuyItemSK()"+idbuy);
        if(cat == 3 && it3.contains(idbuy)){
            if(conn.p.item.get_bag_able()<1){
                Service.send_notice_box(conn, "Hàng trang đầy");
                return true;
            }
            if((conn.p.get_ngoc() < 500 && idbuy == 4762) || (conn.p.get_ngoc() < 50 && idbuy != 4762))
            {
                Service.send_notice_box(conn, "Không đủ ngọc");
                return true;
            }
            conn.p.update_ngoc(idbuy == 4762? -500 : -50);
            Item3 itbag = new Item3();
            itbag.id = (short)idbuy;
            itbag.clazz = ItemTemplate3.item.get(idbuy).getClazz();
            itbag.type = ItemTemplate3.item.get(idbuy).getType();
            itbag.level = ItemTemplate3.item.get(idbuy).getLevel();
            itbag.icon = ItemTemplate3.item.get(idbuy).getIcon();
            itbag.color = ItemTemplate3.item.get(idbuy).getColor();
            itbag.part = ItemTemplate3.item.get(idbuy).getPart();
            itbag.islock = true;
            itbag.name = ItemTemplate3.item.get(idbuy).getName();
            itbag.tier = 0;
            itbag.op = new ArrayList<>();
            if(idbuy != 4762)
                itbag.op.addAll(ItemTemplate3.item.get(idbuy).getOp());
            itbag.time_use = 0;
            itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * (idbuy == 4762? 0: 7);
            
            conn.p.item.add_item_bag3(itbag);
            conn.p.item.char_inventory(3);
            conn.p.item.char_inventory(5);
            Service.send_notice_box(conn, "Bạn đã mua thành công vật phẩm "+itbag.name);
            return true;
        }
        return false;
    }
    
    
    public static void saveEventData(Connection conn) throws SQLException {
    // Chuẩn bị truy vấn dữ liệu sự kiện với ID 3
    PreparedStatement ps = conn.prepareStatement("SELECT `data` FROM `event` WHERE `id` = ?;");
    ps.setInt(1, 3);  // ID của sự kiện là 3
    ResultSet rs = ps.executeQuery();
    JSONObject jsob;
    // Nếu có dữ liệu
    if (rs.next()) {
        String jsonData = rs.getString("data");
        // Kiểm tra nếu dữ liệu jsonData là null hoặc rỗng
        if (jsonData == null || jsonData.isEmpty()) {
             jsob = new JSONObject();  // Tạo đối tượng JSONObject mới
        } else {
            // Chuyển đổi chuỗi JSON thành đối tượng JSON
            jsob = (JSONObject) JSONValue.parse(jsonData);
        }
        // Kiểm tra xem trường "list_dat_mi_nuong" có tồn tại không
        if (jsob.get("list_dat_mi_nuong") == null) {
            // Nếu chưa có, tạo mới trường "list_dat_mi_nuong"
            JSONArray jsar_1 = new JSONArray();
            jsob.put("list_dat_mi_nuong", jsar_1);
             }
        // Cập nhật lại cột 'data' trong bảng sự kiện
        ps = conn.prepareStatement("UPDATE `event` SET `data` = ? WHERE `id` = ?;");
        ps.clearParameters();
        ps.setNString(1, jsob.toJSONString());  // Chuyển đối tượng JSON thành chuỗi để lưu vào cơ sở dữ liệu
        ps.setInt(2, 3);  // ID của sự kiện là 3
        ps.executeUpdate();
        ps.close();
         } else {
        // Nếu không tìm thấy sự kiện có ID là 3, tạo mới sự kiện
        jsob = new JSONObject();
        JSONArray jsar_1 = new JSONArray();
        jsob.put("list_dat_mi_nuong", jsar_1);  // Tạo mới trường list_dat_mi_nuong

        ps = conn.prepareStatement("INSERT INTO `event` (id, data) VALUES (?, ?);");
        ps.clearParameters();
        ps.setInt(1, 3);  // ID của sự kiện là 3
        ps.setNString(2, jsob.toJSONString());  // Chuyển đối tượng JSON thành chuỗi để lưu vào cơ sở dữ liệu
        ps.executeUpdate();
        ps.close();
    }
    rs.close();
    // Sau khi xử lý xong kiểm tra và cập nhật dữ liệu, tiếp tục cập nhật sự kiện từ Event_4.SaveData()
    ps = conn.prepareStatement("UPDATE `event` SET `data` = ? WHERE `id` = ?;");
    ps.clearParameters();
    ps.setNString(1, Event_4.SaveData().toJSONString());  // Cập nhật dữ liệu sự kiện từ SaveData
    ps.setInt(2, 3);  // ID của sự kiện là 3
    ps.executeUpdate();  // Thực thi lệnh cập nhật
    ps.close();  // Đóng kết nối.
}

}
