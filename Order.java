import java.util.Map;
import java.util.Map.Entry;

public class Order {
    private String cardNumber;
    private Map<String, Item> items;
    private int totalAmount;

    public Order(String cardNumber, Map<String, Item> items) {
        this.cardNumber = cardNumber;
        this.items = items;
        this.totalAmount = 0;
        // calculate total amount
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            this.totalAmount += entry.getValue().getQuantity() * entry.getValue().getPrice();
        }

    }

    public Order(String orderId, String cardNumber2, String item, int quantity) {
        this.cardNumber = cardNumber2;
        this.items.entrySet().add((Entry<String, Item>) new Item(item, quantity));
        this.totalAmount = 0;
        // calculate total amount
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            this.totalAmount += entry.getValue().getQuantity() * entry.getValue().getPrice();
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    
}
