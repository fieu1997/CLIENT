package event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Event_5 {
    private static String name_event = "sự kiện tết";

    public static final HashMap<String, Integer> list_naubanh = new HashMap<>();
    public static final HashMap<String, Integer> list_nhanbanh = new HashMap<>();
    public static NauBanh naubanh;

    public static List<BXH_naubanh> list_bxh_naubanh = new ArrayList<>();
    public static final Set<String> list_bxh_naubanh_name = new HashSet<>();
    public static final List<BXH_naubanh> list_dotphao = new ArrayList<>();
    public static final List<BXH_naubanh> list_moqua = new ArrayList<>();

    public synchronized static boolean check(String name) {
        return list_naubanh.containsKey(name);
    }

    public synchronized static void add_naubanh(String name, int quant) {
        int current = list_naubanh.getOrDefault(name, 0);
        list_naubanh.put(name, current + quant);
        boolean found = false;
        for (BXH_naubanh bxh : list_bxh_naubanh) {
            if (bxh.name.equals(name)) {
                bxh.quant = list_naubanh.get(name);
                bxh.time = System.currentTimeMillis();
                found = true;
                break;
            }
        }
        if (!found) {
            list_bxh_naubanh.add(new BXH_naubanh(name, list_naubanh.get(name), System.currentTimeMillis()));
        }
    }

    public synchronized static void add_dotphao(String name, int quant) {
        boolean found = false;
        for (BXH_naubanh bxh : list_dotphao) {
            if (bxh.name.equals(name)) {
                bxh.quant += quant;
                bxh.time = System.currentTimeMillis();
                found = true;
                break;
            }
        }
        if (!found) {
            list_dotphao.add(new BXH_naubanh(name, quant, System.currentTimeMillis()));
        }
    }
    
    public synchronized static void add_moqua(String name, int quant) {
        boolean found = false;
        for (BXH_naubanh bxh : list_moqua) {
            if (bxh.name.equals(name)) {
                bxh.quant += quant;
                bxh.time = System.currentTimeMillis();
                found = true;
                break;
            }
        }
        if (!found) {
            list_moqua.add(new BXH_naubanh(name, quant, System.currentTimeMillis()));
        }
    }

    public synchronized static void finish() {
        list_nhanbanh.clear();
        list_nhanbanh.putAll(list_naubanh);
        list_naubanh.clear();

        list_bxh_naubanh_name.clear();
        sort_bxh();
        for (int i = 0; i < list_bxh_naubanh.size() && i < 10; i++) {
            list_bxh_naubanh_name.add(list_bxh_naubanh.get(i).name);
        }
    }

    public synchronized static int get_banh(String name) {
        int quant = 0;
        if (list_nhanbanh.containsKey(name)) {
            quant = list_nhanbanh.get(name);
            list_nhanbanh.remove(name);
        }
        return quant;
    }

    public synchronized static boolean check_time_can_register() {
        if (naubanh.h >= 17 && naubanh.h <= 18) return false;
        if (naubanh.h == 16 && naubanh.m >= 30) return false;
        return true;
    }

    public synchronized static int get_banh_now(String name) {
        return list_naubanh.getOrDefault(name, 0);
    }

    public synchronized static String[] get_top_naubanh() {
        sort_bxh();
        if (list_bxh_naubanh.isEmpty()) return new String[]{"Chưa có thông tin"};
        int topCount = Math.min(10, list_bxh_naubanh.size());
        String[] top = new String[topCount];
        for (int i = 0; i < topCount; i++) {
            BXH_naubanh bxh = list_bxh_naubanh.get(i);
            top[i] = "Top " + (i + 1) + " : " + bxh.name + " : " + bxh.quant;
        }
        return top;
    }

    public synchronized static String[] get_top_dotphao() {
        list_dotphao.sort((o1, o2) -> {
            int cmp = Integer.compare(o2.quant, o1.quant);
            return cmp != 0 ? cmp : Long.compare(o1.time, o2.time);
        });
        if (list_dotphao.isEmpty()) return new String[]{"Chưa có thông tin"};
        int topCount = Math.min(10, list_dotphao.size());
        String[] top = new String[topCount];
        for (int i = 0; i < topCount; i++) {
            BXH_naubanh bxh = list_dotphao.get(i);
            top[i] = "Top " + (i + 1) + " : " + bxh.name + " : " + bxh.quant + " lần";
        }
        return top;
    }
    
    public synchronized static String[] get_top_moqua() {
        list_moqua.sort((o1, o2) -> {
            int cmp = Integer.compare(o2.quant, o1.quant);
            return cmp != 0 ? cmp : Long.compare(o1.time, o2.time);
        });
        if (list_moqua.isEmpty()) return new String[]{"Chưa có thông tin"};
        int topCount = Math.min(10, list_moqua.size());
        String[] top = new String[topCount];
        for (int i = 0; i < topCount; i++) {
            BXH_naubanh bxh = list_moqua.get(i);
            top[i] = "Top " + (i + 1) + " : " + bxh.name + " : " + bxh.quant + " lần";
        }
        return top;
    }

    public synchronized static void sort_bxh() {
        list_bxh_naubanh.sort((o1, o2) -> {
            int cmp = Integer.compare(o2.quant, o1.quant);
            return cmp != 0 ? cmp : Long.compare(o1.time, o2.time);
        });
        while (list_bxh_naubanh.size() > 10) {
            list_bxh_naubanh.remove(list_bxh_naubanh.size() - 1);
        }
        list_dotphao.sort((o1, o2) -> {
            int cmp = Integer.compare(o2.quant, o1.quant);
            return cmp != 0 ? cmp : Long.compare(o1.time, o2.time);
        });
        list_moqua.sort((o1, o2) -> {
            int cmp = Integer.compare(o2.quant, o1.quant);
            return cmp != 0 ? cmp : Long.compare(o1.time, o2.time);
        });
    }

    public static class BXH_naubanh {
        public String name;
        public int quant;
        public long time;

        public BXH_naubanh(String name, int quant, long time) {
            this.name = name;
            this.quant = quant;
            this.time = time;
        }
    }

    public static void LoadDB(JSONObject jsob) {
        long t_ = System.currentTimeMillis();
        synchronized (list_dotphao) {
            list_dotphao.clear();
            list_moqua.clear();
            list_naubanh.clear();
            list_bxh_naubanh.clear();

            JSONArray jsar = (JSONArray) JSONValue.parse(jsob.get("list_dotphao").toString());
            for (int i = 0; i < jsar.size(); i++) {
                JSONArray arr = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                list_dotphao.add(new BXH_naubanh(arr.get(0).toString(), Integer.parseInt(arr.get(1).toString()), t_));
            }
            jsar.clear();

            jsar = (JSONArray) JSONValue.parse(jsob.get("list_moqua").toString());
            for (int i = 0; i < jsar.size(); i++) {
                JSONArray arr = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                list_moqua.add(new BXH_naubanh(arr.get(0).toString(), Integer.parseInt(arr.get(1).toString()), t_));
            }
            jsar.clear();

            jsar = (JSONArray) JSONValue.parse(jsob.get("list_naubanh").toString());
            for (int i = 0; i < jsar.size(); i++) {
                JSONArray arr = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                String player = arr.get(0).toString();
                int quant = Integer.parseInt(arr.get(1).toString());
                list_naubanh.put(player, quant);
                list_bxh_naubanh.add(new BXH_naubanh(player, quant, t_));
            }
        }
    }

    public static void saveEventData(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT `data` FROM `event` WHERE `id` = ?;");
        ps.setInt(1, 4);
        ResultSet rs = ps.executeQuery();
        JSONObject jsob;
        if (rs.next()) {
            String jsonData = rs.getString("data");
            if (jsonData == null || jsonData.isEmpty()) {
                jsob = new JSONObject();
            } else {
                jsob = (JSONObject) JSONValue.parse(jsonData);
            }
            if (jsob.get("list_naubanh") == null) jsob.put("list_naubanh", new JSONArray());
            if (jsob.get("list_dotphao") == null) jsob.put("list_dotphao", new JSONArray());
            if (jsob.get("list_moqua") == null) jsob.put("list_moqua", new JSONArray());
            ps = conn.prepareStatement("UPDATE `event` SET `data` = ? WHERE `id` = ?;");
            ps.clearParameters();
            ps.setNString(1, jsob.toJSONString());
            ps.setInt(2, 4);
            ps.executeUpdate();
            ps.close();
        } else {
            jsob = new JSONObject();
            jsob.put("list_naubanh", new JSONArray());
            jsob.put("list_dotphao", new JSONArray());
            jsob.put("list_moqua", new JSONArray());
            ps = conn.prepareStatement("INSERT INTO `event` (id, data) VALUES (?, ?);");
            ps.clearParameters();
            ps.setInt(1, 4);
            ps.setNString(2, jsob.toJSONString());
            ps.executeUpdate();
            ps.close();
        }
        rs.close();
        ps = conn.prepareStatement("UPDATE `event` SET `data` = ? WHERE `id` = ?;");
        ps.clearParameters();
        ps.setNString(1, SaveData().toJSONString());
        ps.setInt(2, 4);
        ps.executeUpdate();
        ps.close();
    }

    public static JSONObject SaveData() {
        synchronized (list_dotphao) {
            JSONArray jsar_dotphao = new JSONArray();
            for (BXH_naubanh bxh : list_dotphao) {
                JSONArray arr = new JSONArray();
                arr.add(bxh.name);
                arr.add(bxh.quant);
                jsar_dotphao.add(arr);
            }

            JSONArray jsar_naubanh = new JSONArray();
            for (Map.Entry<String, Integer> en : list_naubanh.entrySet()) {
                JSONArray arr = new JSONArray();
                arr.add(en.getKey());
                arr.add(en.getValue());
                jsar_naubanh.add(arr);
            }
            
            JSONArray jsar_moqua = new JSONArray();
            for (BXH_naubanh bxh : list_moqua) {
                JSONArray arr = new JSONArray();
                arr.add(bxh.name);
                arr.add(bxh.quant);
                jsar_moqua.add(arr);
            }

            JSONObject jsob = new JSONObject();
            jsob.put("list_naubanh", jsar_naubanh);
            jsob.put("list_dotphao", jsar_dotphao);
            jsob.put("list_moqua", jsar_moqua);
            return jsob;
        }
    }
}
