public class Cafe{
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double lattes = 4.5;
        double cappuccino = 5;
        double cafePrice = 5.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Noah";
        String customer3 = "Sam";
        String customer4 = "Jimmy";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println(readyMessage +  customer2 + displayTotalMessage + cappuccino );
        System.out.println(pendingMessage +  customer3 + displayTotalMessage + (lattes * 2 ) );
        System.out.println(pendingMessage +  customer4 + displayTotalMessage + cafePrice );

        boolean isReadyOrder = true;
    
if(isReadyOrder) {
    System.out.println(", your order is ready.");
}
else {
    System.out.println(", your order will be ready shortly!");
}



    }
}