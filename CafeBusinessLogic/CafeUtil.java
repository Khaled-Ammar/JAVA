import java.util.*;

class CafeUtil {
    public void addCustomer(ArrayList<String> customersList) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName + "!");
        System.out.println("There are "+ customersList.size() + " people in front of you");
        customersList.add(userName);
        System.out.println(customersList);
    }

    public void displayMenu(ArrayList<String> menuItems) {
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");
 
        System.out.println("Elements of menu list are:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i) + " ");
        }
    }


    public double getOrderTotal(double[] prices) {
        double sum = 0.0;
        for (double price:prices) {
            sum += price;
        } 
        return sum;
    } 


    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 0; i <=numWeeks; i++) {
            sum += i;
        }
        return sum;
    } 
    
}