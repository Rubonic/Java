import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil cafeApp = new CafeUtil();
        
        int num = 10;
        int goal = cafeApp.getStreakGoal(num);
        
        System.out.println("-------- Streak Goal Test -------");
        System.out.println(goal);
        
        System.out.println("----------- Order Total Test --------");
        double[] lineItems = {3.5,1.5,4.0,4.5};
        double orderTotal = cafeApp.getOrderTotal(lineItems);
        System.out.println("Order Total: "+ orderTotal);
        
        System.out.println("-------------Display menu Test----------");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("capuccino");
        menu.add("latte");
        menu.add("mocha");
        cafeApp.displayMenu(menu);

        System.out.println("--------- Add Customer Test --------");
        ArrayList<String> customers = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            cafeApp.addCustomer(customers);
            System.out.println("\n");
        }

        cafeApp.printPriceChart("Cafe Ground Colombianian", 12000.0, 3);
        cafeApp.printPriceChart("Cafe Ground Colombianian", 1600.0, 4);

        System.out.println("--------- overload Test --------");
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("drip coffee");
        menus.add("capuccino");
        menus.add("latte");
        menus.add("mocha");

        ArrayList<Double> price = new ArrayList<Double>();
        price.add(1200.00);
        price.add(3200.00);
        price.add(3600.00);
        price.add(3200.00);
        cafeApp.displayMenu(menus,price);
    }
}
