package template;

import ai.Fusion;
import java.util.ArrayList;
import java.util.List;
import client.Player;

public class Part_fashion {
    public static final List<Short> fashions = new ArrayList<>();
    public static final List<Part_fashion> entrys = new ArrayList<>();
    public short id;
    public byte[] part;

    public static byte[] get_part(Player p) {
        
         Fusion fusion = new Fusion();
         boolean[] status = Fusion.getFusionStatus(p);
                    boolean Fusion = status[0];
        if (Fusion == true) {
       
        for (Part_fashion temp : entrys) {
            if (temp.id == 4818) {  // Trang ph?c ID 3615
                return temp.part;   // Hi?n th? hi?u ?ng trang ph?c ID 3615
            }
        }
    }
        if(!p.an_wear){
        if (p.item.wear[11] != null) {
            for (Part_fashion temp : entrys) {
                if (temp.id == p.item.wear[11].id) {
                    return temp.part;
                }
            }
        }
        }
        
       
       
        if (p.item.wear[20] != null) {
            for (Part_fashion temp : entrys) {
                if (temp.id == p.item.wear[20].id) {
                    return temp.part;
                }
            }
        }
        return new byte[]{-1, -1, -1, -1, -1, -1, -1};
    }
}
