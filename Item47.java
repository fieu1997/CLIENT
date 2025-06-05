package template;

public class Item47 {
    public short id;
    public short quantity;
    public byte category;
    public long expiry_time = 0;
    public Item47(){}
    public Item47(Item47 Origin){
        this.id = Origin.id;
        this.quantity = Origin.quantity;
        this.category = Origin.category;
        this.expiry_time = Origin.expiry_time;
        
    }
    
    @Override
    public Item47 clone() {
        try {
            Item47 clone = (Item47) super.clone();
            // Sao chép các thuộc tính khác nếu cần
            return clone;
        } catch (CloneNotSupportedException e) {
            // Xử lý exception nếu cần
            return null;
        }
    }
}
