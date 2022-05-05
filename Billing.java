import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Billing {

   static Db db;

    // read the input file and process the data to various maps
    // example of the input file:
        // "Item","Quantity","Card number"
        // "Milk","1","1234 5678 9101 1121"
        // "Bread","2","1235 5678 9101 1121"
        // "Oil","1","1236 5678 9101 1121"
        // "Apples","10","3423 6785 1234 1234"
        // "Blanket","3","3424 6785 1234 1234"

    public static void readInputFile(String inputFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = br.readLine();
            // igonre the first line
            line = br.readLine(); 
            while (line != null) {
                String[] tokens = line.split(",");

                if (tokens[0].equals("Item")) {
                    // do nothing
                } else {
                    String item = tokens[0];
                    int quantity = Integer.parseInt(tokens[1]);
                    String cardNumber = tokens[2];
                    Item itemObj = new Item(item, quantity);
                    Db.addItem(item, itemObj);
                    Db.addCardNumber("card 1",cardNumber );
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
        Db.printCardNumbers();;
        Db.printItems();
    }
   
}