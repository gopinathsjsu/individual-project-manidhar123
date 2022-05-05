
public class Item {
    private String category;
    private String item;
    private int quantity;
    private int price;

    public Item(String category, String item, int quantity, int price) {
        this.category = category;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(String item2, int quantity2) {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "Item [category=" + category + ", item=" + item + ", quantity=" + quantity + ", price=" + price + "]";
    }

    public static void main(String[] args) {
        Item item = new Item("category", "item", 1, 1);
        // create 10 items
        // / "Item","Quantity","Card number"
        // "Milk","1","1234 5678 9101 1121"
        // "Bread","2","1235 5678 9101 1121"
        // "Oil","1","1236 5678 9101 1121"
        // "Apples","10","3423 6785 1234 1234"
        // "Blanket","3","3424 6785 1234 1234"
        Item[] items = new Item[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item("Drinks", "Milk", 1, 1);
        }

        // print 
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
}