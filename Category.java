import java.util.HashMap;
import java.util.Map;

public class Category {
    private String category;
    private Map<String, Item> items;

    public Category(String category, int maxQuantity) {
        this.category = category;
        this.items = new HashMap<>();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }
    

}