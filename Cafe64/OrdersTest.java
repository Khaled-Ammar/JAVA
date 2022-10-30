import java.util.*;
public class OrdersTest {
    public static void main(String[] args) {
        Items item1 = new Items();
        Items item2 = new Items();
        Items item3 = new Items();
        Items item4 = new Items();

        Orders order1 = new Orders();
        Orders order2 = new Orders();
        Orders order3 = new Orders();
        Orders order4 = new Orders();
        ArrayList<Items> items = new ArrayList<Items>();

        item1.setName("Mocha");
        item2.setName("Latte");
        item3.setName("Drip Coffee");
        item4.setName("Cappuccino");
        item1.setPrice(3.0);
        item2.setPrice(4.5);
        item3.setPrice(5.5);
        item4.setPrice(2.5);

        order1.setName("Cindhuri");
        order1.setReady(true);
        order2.setName("Zaki");
        order2.setReady(false);
        order3.setName("Khaled");
        order4.setName("Yousef");
        order4.setReady(false);
        order2.getItems().add(item1);
        order3.getItems().add(item3);

        order4.getItems().add(item4);
        order4.getItems().add(item4);
        order4.getItems().add(item4);
        order4.addItem(item4);
        
        order4.display();
        order4.getStatusMessage();
    }
}