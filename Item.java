
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
}