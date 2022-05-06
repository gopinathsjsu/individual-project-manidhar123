import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Billing {

    static Db db;

    // read the input file and process the data to various maps
    // example of the input file:
    // Item,Quantity,Card number, TotalPrice
    // Shampoo,2, 20, 165
    // chocolates, 5, 15
    // Wallet ,1, 100
    // Pen ,10 ,30

    public static void readInputFile(String inputFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = br.readLine();
            int totalPrice = 0;
            // igonre the first line
           
            line = br.readLine();
            
            while (line != null) {
                String[] data = line.split(",");
                String item = data[0];
                int quantity = Integer.parseInt(data[1]);
                String cardNumber = data[2];
                if (data.length == 4) {
                totalPrice = Integer.parseInt(data[3]);
                } else {
                    totalPrice = 0;
                }
                // add the item to the map
                Item itemObj = new Item(item, item, quantity, totalPrice);
                System.out.println(itemObj);
                db.addItem(item, itemObj);
                // add the card number to the map
                // db.addCardNumber(cardNumber, item);
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
                System.out.println(tokens[0]);
                System.out.println(tokens[1]);

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
        // processOrder("output.csv");
        Db.printOrders();
        Db.printCardNumbers();
        ;
        Db.printItems();
    }

}