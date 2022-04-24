import java.util.HashMap;
import java.util.Map;

public class Db {
//  card numbers
    private static Map<String, String> cardNumbers = new HashMap<>();
    // categories
    private static Map<String, Category> categories = new HashMap<>();
    // items
    private static Map<String, Item> items = new HashMap<>();
    // orders
    private static Map<String, Order> orders = new HashMap<>();

    public static Map<String, String> getCardNumbers() {
        return cardNumbers;
    }

    public static void setCardNumbers(Map<String, String> cardNumbers) {
        Db.cardNumbers = cardNumbers;
    }

    public static Map<String, Category> getCategories() {
        return categories;
    }

    public static void setCategories(Map<String, Category> categories) {
        Db.categories = categories;
    }

    public static Map<String, Item> getItems() {
        return items;
    }

    public static void setItems(Map<String, Item> items) {
        Db.items = items;
    }

    public static Map<String, Order> getOrders() {
        return orders;
    }

    public static void setOrders(Map<String, Order> orders) {
        Db.orders = orders;
    }


    public static void addCardNumber(String cardNumber, String userName) {
        cardNumbers.put(cardNumber, userName);
    }

    public static void addCategory(String category, Category categoryObj) {
        categories.put(category, categoryObj);
    }

    public static void addItem(String item, Item itemObj) {
        items.put(item, itemObj);
    }

    public static void addOrder(String orderId, Order orderObj) {
        orders.put(orderId, orderObj);
    }


    public static void removeCategory(String category) {
        categories.remove(category);
    }

    public static void removeItem(String item) {
        items.remove(item);
    }

    public static void removeOrder(String orderId) {
        orders.remove(orderId);
    }

    public static void removeCardNumber(String cardNumber) {
        cardNumbers.remove(cardNumber);
    }

    public static void updateCategory(String category, Category categoryObj) {
        categories.put(category, categoryObj);
    }

    public static void updateItem(String item, Item itemObj) {
        items.put(item, itemObj);
    }

    public static void updateOrder(String orderId, Order orderObj) {
        orders.put(orderId, orderObj);
    }


    public static void printCardNumbers() {
        System.out.println("Card Numbers:");
        for (Map.Entry<String, String> entry : cardNumbers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printCategories() {
        System.out.println("Categories:");
        for (Map.Entry<String, Category> entry : categories.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static void printItems() {
        System.out.println("Items:");
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printOrders() {
        System.out.println("Orders:");
        for (Map.Entry<String, Order> entry : orders.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printCardNumber(String cardNumber) {
        System.out.println("Card Number: " + cardNumbers.get(cardNumber));
    }

  


}
