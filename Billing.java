import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Billing {

    private Db db;

    // read the input file and process the data to various maps
    public static void readInputFile(String inputFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = br.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                if (tokens[0].equals("Item")) {
                    // process the item
                    String item = tokens[1];
                    String category = tokens[2];
                    int quantity = Integer.parseInt(tokens[3]);
                    int price = Integer.parseInt(tokens[4]);
                    Item itemObj = new Item(item, category, quantity, price);
                    Db.addItem(item, itemObj);
                } else if (tokens[0].equals("Category")) {
                    // process the category
                    String category = tokens[1];
                    int maxQuantity = Integer.parseInt(tokens[2]);
                    Category categoryObj = new Category(category, maxQuantity);
                    Db.addCategory(category, categoryObj);
                } else if (tokens[0].equals("Card")) {
                    // process the card
                    String cardNumber = tokens[1];
                    String userName = tokens[2];
                    Db.addCardNumber(cardNumber, userName);
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // process the order
    public static void processOrder(String orderFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(orderFile));
            String line = br.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                if (tokens[0].equals("Order")) {
                    // process the order
                    String orderId = tokens[1];
                    String cardNumber = tokens[2];
                    String item = tokens[3];
                    int quantity = Integer.parseInt(tokens[4]);
                    Order orderObj = new Order(orderId, cardNumber, item, quantity);
                    Db.addOrder(orderId, orderObj);
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Billing billing = new Billing();
        billing.db = new Db();
        readInputFile("input.csv");
        processOrder("output.csv");
        billing.db.printOrders();
        billing.db.printCardNumbers();;
        billing.db.printItems();
    }
   
}