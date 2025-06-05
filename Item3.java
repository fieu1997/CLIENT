package template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import map.ItemMap;
public class Item3 {

    public short id;
    public byte clazz;
    public byte type;
    public short level;
    public short icon;
    public byte color;
    public byte part;
    public boolean islock;
    public byte isHopdo;
    public String name;
    public String name1;
    public byte tier;
    public byte tierStar;
    public byte tierSt;
    public List<Option> op;
    public List<Option> opMedal;
    public long time_use;
    public long expiry_date;
    public boolean map_124;
    
    public Item3() {
    }

    public Item3(Item3 Origin) {
        this.id = Origin.id;
        this.clazz = Origin.clazz;
        this.type = Origin.type;
        this.level = Origin.level;
        this.icon = Origin.icon;
        this.color = Origin.color;
        this.part = Origin.part;
        this.islock = Origin.islock;
        this.isHopdo = Origin.isHopdo;
        this.name = Origin.name;
        this.name1 = Origin.name1;
        this.tier = Origin.tier;
        this.tierStar = Origin.tierStar;
        this.tierSt = Origin.tierSt;
        this.op = new ArrayList<>();
        if (Origin.op != null) {
            this.op.addAll(Origin.op);
        }
        this.opMedal = new ArrayList<>();
        if (Origin.opMedal != null) {
            this.opMedal.addAll(Origin.opMedal);
        }
        this.time_use = Origin.time_use;
        this.expiry_date = Origin.expiry_date;
    }

    public Option GetNextOPMedal() {
        if (this.opMedal == null || this.opMedal.size() < 1) {
            this.opMedal = null;
            return null;
        }
        return this.opMedal.remove(0);
    }

    public void UpdateName() {
        name = ItemTemplate3.item.get(id).getName();
        
        String st = "";
        if (tierStar ==10) {
            st = "Siêu Thần +1";
        } else if (tierStar ==11) {
            st = "Siêu Thần +2";
        } else if (tierStar ==12) {
            st = "Siêu Thần +3";
        } else if (tierStar ==13) {
            st = "Siêu Thần +4";
        }  else if (tierStar ==14) {
            st = "Siêu Thần +5";
        }  else if (tierStar ==15) {
            st = "Siêu Thần +6";
        }  else if (tierStar ==16) {
            st = "Siêu Thần +7";
        }  else if (tierStar ==17) {
            st = "Siêu Thần +8";
        }  else if (tierStar ==18) {
            st = "Siêu Thần +9";
        } 
                     
        if (islock) {
            name += " [Khóa]";
        }
        if (tierStar > 0 && tierStar <= 9 ) {
            name += " [Cấp " + tierStar + "]";
        }
        if (tierStar > 9) {
          
            name += "[" + st + "]";
        }
        //
        if (isHopdo > 0 && isHopdo <= 9 ) {
            name += " [Test " + isHopdo + "]";
        }
        
        
        if (tier > 15 && (id >= 4587 && id <= 4590)) {
            name += " [Siêu Cấp ]";
        }
        
    }

    public boolean isTT() {
        return (id >= 3732 && id <= 3736) || id >= 3807 && id <= 3811 || id >= 3897 && id <= 3901 || id >= 4656 && id <= 4675;
    }

    public void UpdateOption() {
        int[] opAo = {-123, -122, -121, -120, -119};
        int[] opNon = {-114, -125, -117};
        int[] opVK = {-128, -125, 99, -85, -83, -81};
        int[] opNhan = {-103, -88, -116, 99, -85, -83, -81};
        int[] opDayChuyen = {-88, -117, -115, -92};
        int[] opGang = {-90, -115, -92};
        int[] opGiay = {-116, -115, -92};
        Integer[] opAoOld = {-111, -110, -109, -108, -107};
        Integer[] opNonOld = {-102, -113, -105};
        Integer[] opVKOld = {-101, -113, -86, -84, -82, -80};
        Integer[] opNhanOld = {-91, -87, -104, -86, -84, -82, -80};
        Integer[] opDayChuyenOld = {-87, -105, -103, -91};;
        Integer[] opGangOld = {-89, -103, -91};
        Integer[] opGiayOld = {-104, -103, -91};

        if (type == 0 || type == 1) {
            List<Integer> list = Arrays.asList(opAoOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opAo[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 2) {
            List<Integer> list = Arrays.asList(opNonOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opNon[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 3) {
            List<Integer> list = Arrays.asList(opGangOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opGang[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 4) {
            List<Integer> list = Arrays.asList(opNhanOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opNhan[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 5) {
            List<Integer> list = Arrays.asList(opDayChuyenOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opDayChuyen[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 6) {
            List<Integer> list = Arrays.asList(opGiayOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opGiay[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type > 7) {
            List<Integer> list = Arrays.asList(opVKOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opVK[list.indexOf((int) op.get(i).id)];
                }
            }
        }

    }

    public void ReUpdateOption() {
        Integer[] opAoOld = {-123, -122, -121, -120, -119};
        Integer[] opNonOld = {-114, -125, -117};
        Integer[] opVKOld = {-128, -125, 99, -85, -83, -81};
        Integer[] opNhanOld = {-103, -88, -116, 99, -85, -83, -81};
        Integer[] opDayChuyenOld = {-88, -117, -115, -92};
        Integer[] opGangOld = {-90, -115, -92};
        Integer[] opGiayOld = {-116, -115, -92};
        int[] opAo = {-111, -110, -109, -108, -107};
        int[] opNon = {-102, -113, -105};
        int[] opVK = {-101, -113, -86, -84, -82, -80};
        int[] opNhan = {-91, -87, -104, -86, -84, -82, -80};
        int[] opDayChuyen = {-87, -105, -103, -91};;
        int[] opGang = {-89, -103, -91};
        int[] opGiay = {-104, -103, -91};
        if (type == 0 || type == 1) {
            List<Integer> list = Arrays.asList(opAoOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opAo[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 2) {
            List<Integer> list = Arrays.asList(opNonOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opNon[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 3) {
            List<Integer> list = Arrays.asList(opGangOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opGang[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 4) {
            List<Integer> list = Arrays.asList(opNhanOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opNhan[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 5) {
            List<Integer> list = Arrays.asList(opDayChuyenOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opDayChuyen[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type == 6) {
            List<Integer> list = Arrays.asList(opGiayOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opGiay[list.indexOf((int) op.get(i).id)];
                }
            }
        } else if (type > 7) {
            List<Integer> list = Arrays.asList(opVKOld);
            for (int i = 0; i < op.size(); i++) {
                if (list.contains((int) op.get(i).id)) {
                    op.get(i).id = (byte) opVK[list.indexOf((int) op.get(i).id)];
                }
            }
        }

    }
    
    public boolean hasOption(int id) {
        for (Option o : op) {
            if (o.id == id) {
                return true;
            }
        }
        return false;
    }
    
    public Item3(ItemTemplate3 template) {
    this.id = template.getId();
    this.clazz = template.getClazz();
    this.type = template.getType();
    this.level = template.getLevel();
    this.icon = template.getIcon();
    this.color = template.getColor();
    this.name = template.getName();
    this.part = template.getPart();
    this.op = new ArrayList<>(template.getOp());  // Sao chép danh sách các Option
    this.map_124 = false;
}

    
      
}
