package ev_he;

import client.Player;
import core.Manager;
import core.Util;
import ev_he.Event_tet.MobNpc;
import io.Message;
import io.Session;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import map.Map;

public class Event_tet { 

    private static final CopyOnWriteArrayList<MobNpc> mob_npc = new CopyOnWriteArrayList<>();
    
        public static MobNpc getMob(int idx){
        for(MobNpc m : mob_npc){
            if(m.index == idx )
                return m;
        }
        return null;
    }
    // Phương thức tạo và thêm mob cây vào map
    public static void spawnEmptyPlots() {
    try {
        Map[] maps = Map.get_map_by_id(1);
        if (maps == null || maps.length == 0) {
            System.out.println("Map ID 1 không tồn tại.");
            return;
        }
       // Map map = maps[0];
           for (Map map: maps) {
            short index = (short) (3000 + mob_npc.size());
            MobNpc npc1 = new MobNpc(map, index); 
            npc1.nameOwner = "Nồi Bánh";
            npc1.icon = 218;
            npc1.eff_111 = 61;
            npc1.x = (short) (529);
            npc1.y = 324;
            mob_npc.add(npc1);
            
            for (Player player : map.players) {
                if (player != null && player.conn != null && player.conn.connected) {
                    npc1.SendMob(player.conn);
                }
        }
        //
           short index1 = (short) (3000 + mob_npc.size());
            MobNpc npc2 = new MobNpc(map, index1); 
            npc2.nameOwner = "Cây Mai";
            npc2.icon = 218;
            npc2.eff_111 = 59;
            npc2.x = (short) (402);
            npc2.y = 330;
            mob_npc.add(npc2);
            
            for (Player player : map.players) {
                if (player != null && player.conn != null && player.conn.connected) {
                    npc2.SendMob(player.conn);
                }
        }
        //
          short index3 = (short) (3000 + mob_npc.size());
            MobNpc npc3 = new MobNpc(map, index3); 
            npc3.nameOwner = "Cây Đào";
            npc3.icon = 218;
            npc3.eff_111 = 60;
            npc3.x = (short) (642);
            npc3.y = 276;
            mob_npc.add(npc3);
            
            for (Player player : map.players) {
                if (player != null && player.conn != null && player.conn.connected) {
                    npc3.SendMob(player.conn);
                }
        }
        //
        short index4 = (short) (3000 + mob_npc.size());
            MobNpc npc4 = new MobNpc(map, index4); 
            npc4.nameOwner = "Cây Nêu";
            npc4.icon = 218;
            npc4.eff_111 = 64;
            npc4.x = (short) (430);
            npc4.y = 186;
            mob_npc.add(npc4);
            
            for (Player player : map.players) {
                if (player != null && player.conn != null && player.conn.connected) {
                    npc4.SendMob(player.conn);
                }
        }
        //
        short index5 = (short) (3000 + mob_npc.size());
            MobNpc npc5 = new MobNpc(map, index5); 
            npc5.nameOwner = "Cây Lì Xì";
            npc5.icon = 218;
            npc5.eff_111 = 110;
            npc5.x = (short) (312);
            npc5.y = 612;
            mob_npc.add(npc5);
            
            for (Player player : map.players) {
                if (player != null && player.conn != null && player.conn.connected) {
                    npc5.SendMob(player.conn);
                }
        }
        //
          }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    // Phương thức cập nhật trạng thái của tất cả mob cây
    public static void updateMobTrees() {
        try {
            long currentTime = System.currentTimeMillis();
            for (MobNpc mobTree : mob_npc) {
                if (mobTree.Owner == null && (currentTime - mobTree.timeUpdate > 1000 * 60 * 4)) {
                    mobTree.mobMove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức xóa tất cả mob cây
    public static void clearMobTrees() {
        try {
            for (MobNpc mobTree : mob_npc) {
                mobTree.MobLeave();
            }
            mob_npc.clear();
            System.out.println("Tất cả mob cây đã được xóa.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Class MobNpc
    public static class MobNpc {

        public long timeUpdate;
        public short index;
        public String name = "";
        public String nameOwner = "";
        public Player Owner;
        public boolean isRemove;
        public Map map;
        public short x, y;
        public short icon;
        public short eff_111;

        public MobNpc(Map map, short idx) {
    this.timeUpdate = System.currentTimeMillis();
    this.map = map;
    this.index = idx;
    this.x = (short) (Util.random(map.mapW) * 24);
    this.y = (short) (Util.random(map.mapH) * 24);
    this.nameOwner = ""; // Giá trị mặc định
    this.name = ""; // Không có cây trồng
    map.mobnpc.add(this);
}


        public void SendMob(Session conn)throws IOException{
        if(!conn.p.isShowMobEvents)return;
        Message m = new Message(4);
        m.writer().writeByte(1);
        m.writer().writeShort(icon);
        m.writer().writeShort(index);
        m.writer().writeShort(x);
        m.writer().writeShort(y);
        m.writer().writeByte(-1);
        conn.addmsg(m);
        m.cleanup();
        //SendEffMob(conn);
        m = new Message(7);
        m.writer().writeShort(index);
        m.writer().writeByte(10); // Lv
        m.writer().writeShort(x); 
        m.writer().writeShort(y);
        m.writer().writeInt(10); // hp
        m.writer().writeInt(10); // hp max
        m.writer().writeByte(0);
        m.writer().writeInt(-2);
        m.writer().writeShort(-1);

        m.writer().writeByte(1);
        m.writer().writeByte(1);
        m.writer().writeByte(0);
        m.writer().writeUTF(nameOwner);
        m.writer().writeLong(-11111);
        m.writer().writeByte(0);
        conn.addmsg(m);
        m.cleanup();
        
       SendEffMob(conn, (byte) (eff_111));

    }

        public void SendEffMob(Session conn, byte id_eff) throws IOException {
            if (!conn.p.isShowMobEvents) {
                return;
            }
            Message m = new Message(-49);
            byte[] data = Util.loadfile("data/part_char/imgver/x" + conn.zoomlv + "/Data/" + (111 + "_" + id_eff));
            m.writer().writeByte(0);
            m.writer().writeShort(data.length);
            m.writer().write(data);
            m.writer().writeByte(0);
            m.writer().writeByte(1);
            m.writer().writeByte(id_eff);
            m.writer().writeShort(index);
            m.writer().writeByte(1); // tem mob
            m.writer().writeByte(0);
            m.writer().writeShort(8000);
            m.writer().writeByte(0);
            conn.addmsg(m);
            m.cleanup();
        }

        public void MobLeave() throws IOException {
            Message m = new Message(17);
            m.writer().writeShort(Owner == null ? -1 : Owner.index);
            m.writer().writeShort(index);
            for (Player player : map.players) {
                if (player != null && player.conn != null && player.conn.connected) {
                    player.conn.addmsg(m);
                }
            }
            m.cleanup();
            map.mobnpc.remove(this);
        }

        public void mobMove() {
            try {
                this.timeUpdate = System.currentTimeMillis();
                this.x = (short) (Util.random(map.mapW) * 24);
                this.y = (short) (Util.random(map.mapH) * 24);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        public short getId() {
        return this.index;  // id chính là index của MobNpc
    }
    
    }
}
