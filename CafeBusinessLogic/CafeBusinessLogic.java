import java.util.*;

public class CafeBusinessLogic {
    public static void main(String[] args) {
        CafeUtil cafe = new CafeUtil();
        System.out.println(cafe.getStreakGoal(20));
        
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",cafe.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        List<String> loadMenu = Arrays.asList(
            "drip coffee",
            "cappucino",
            "latte",
            "mocha"
        );
        ArrayList<String> menu = new ArrayList<String>();
        menu.addAll(loadMenu);
        cafe.displayMenu(menu);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            cafe.addCustomer(customers);
            System.out.println("\n");
        }
    }
}