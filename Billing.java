import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
    public static void processOrder(int totalprice) {
        try {
            String messagefile = "message.txt";
            String outputfile = "output.txt";
            // Wrtie total price in ooutput.csv or a message in txt file if order is not processed
            if (totalprice > 0) {
                FileWriter fw = new FileWriter(outputfile);
                fw.write("Total price " + totalprice);
                fw.write(totalprice);
                fw.close();
            } else {
                FileWriter fw = new FileWriter(messagefile);
                fw.write("Order not processed");
                fw.close();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Billing billing = new Billing();
        billing.db = new Db();

  

        Item[] items = new Item[10];
        items[0] = new Item("Clothes", "Essentials", 100, 20);
        items[1] = new Item("Soap", "Essentials", 200, 5);
        items[2] = new Item("Shampoo", "Essentials", 200, 10);
        items[3] = new Item("Milk", "Essentials", 100, 5);
        items[4] = new Item("Perfume", "Luxury", 50, 50);
        items[5] = new Item("Chocolates", "Luxury", 300, 3);
        items[6] = new Item("Handbag", "Luxury", 75, 150);
        items[7] = new Item("Wallet", "Luxury", 100, 100);
        items[8] = new Item("Bedsheet", "Misc", 150, 75);
        items[9] = new Item("Footware", "Misc", 200, 25);
        for (int i = 0; i < items.length; i++) {
            db.addItem(items[i].getItem(), items[i]);
        }


        readInputFile("input.csv");
        processOrder(165);
        Db.printOrders();
        Db.printCardNumbers();
        ;
        Db.printItems();
    }

}



// Items	

// Item	Category	Quantity	Price (per unit)
// Clothes	Essentials	100	20
// Soap	Essentials	200	5
// Shampoo	Essentials	200	10
// Milk	Essentials	100	5
// Perfume	Luxury	50	50
// Chocolates	Luxury	300	3
// Handbag	Luxury	75	150
// Wallet	Luxury	100	100
// Bedsheet	Misc	150	75
// Footware	Misc	200	25
// HomeDecorPiece	Misc	100	40
// pen	Misc	400	3
// pencil	Misc	400	3


// Cards			
// CardNumber			
// 5.41E+15			
// 4.12E+12			
// 3.41E+14			
// 6.01E+15


// Item	Quantity	CardNumber
// Shampoo	2	4.12E+12
// chocolates	5	
// Wallet	1	
// Pen	10	

// Item	Quantity	Price	TotalPrice
// Shampoo	2	20	165
// chocolates	5	15	
// Wallet	1	100	
// Pen	10	30	