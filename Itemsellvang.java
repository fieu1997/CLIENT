package template;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class Itemsellvang {

    public static List<Itemsellvang> entry = new ArrayList<>();
    public short id;
    public List<Option> op;
    public int price;
    public byte color;

    static { 
        String vang
                = " [[4587,[[1,1000][2,1000],[3,1000],[4,1000],[5,1000],[6,1000][96,15]],5,2000000000],"
                //sách
                // + "[4577,[],4,500000000]"
                // + "[4578,[],4,500000000]"
                // + "[4579,[],4,500000000]"
                // + "[4580,[],4,500000000]"
                // + "[4581,[],4,500000000]"
                // + "[4582,[],4,500000000]"
                // + "[4583,[],4,500000000]"
                // + "[4584,[],4,500000000]"

               + "[4757,[[23,50],[24,50],[25,50],[26,50],[27,1500]],5,350000000]]";
        
        
        JSONArray js = (JSONArray) JSONValue.parse(vang);
        for (int i = 0; i < js.size(); i++) {
            Itemsellvang temp = new Itemsellvang();
            JSONArray js2 = (JSONArray) JSONValue.parse(js.get(i).toString());
                
            short it = Short.parseShort(js2.get(0).toString());
                 temp.id = it;
            temp.op = new ArrayList<>();
            JSONArray js3 = (JSONArray) JSONValue.parse(js2.get(1).toString());
            for (int j = 0; j < js3.size(); j++) {
                JSONArray js4 = (JSONArray) JSONValue.parse(js3.get(j).toString());
                temp.op.add(new Option(Byte.parseByte(js4.get(0).toString()), Integer.parseInt(js4.get(1).toString())));
            }
            temp.color = Byte.parseByte(js2.get(2).toString());
            temp.price = Integer.parseInt(js2.get(3).toString());
            Itemsellvang.entry.add(temp);
        }
        //
        js.clear();
        // js = (JSONArray) JSONValue.parse(tt);
        // for (int i = 0; i < js.size(); i++) {
            // Itemsellvang temp = new Itemsellvang();
            // JSONArray js2 = (JSONArray) JSONValue.parse(js.get(i).toString());
            // temp.id = Short.parseShort(js2.get(0).toString());
            // temp.op = new ArrayList<>();
            // JSONArray js3 = (JSONArray) JSONValue.parse(js2.get(1).toString());
            // for (int j = 0; j < js3.size(); j++) {
                // JSONArray js4 = (JSONArray) JSONValue.parse(js3.get(j).toString());
                // temp.op.add(new Option(Byte.parseByte(js4.get(0).toString()), Integer.parseInt(js4.get(1).toString())));
            // }
            // temp.color = Byte.parseByte(js2.get(2).toString());
            // temp.price = Integer.parseInt(js2.get(3).toString());
            // Itemsellvang.entry.add(temp);
        }
    }

