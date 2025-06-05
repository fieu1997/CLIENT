package template;

public class Item5 {
    public int ID;
    public String name;
    public int quantity;

    public Item5(int ID, int quantity) {
    if (ID < 0 || ID >= ItemTemplate5.items.size()) {
        throw new IllegalArgumentException("ID không hợp lệ: " + ID);
    }
    this.ID = ID;
    this.quantity = quantity;
    this.name = ItemTemplate5.items.get(ID).name;
}

}
