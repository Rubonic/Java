import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafeUtil {

    public int getStreakGoal(int num) {
        int number = 0;
        for (int i = 0; i <= num; i++) {
            number+=i;
        }
        return number;
    }
    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum;
    }
    public void displayMenu(ArrayList<String> menuItems ) {
        int index = 0;
        for (String string : menuItems) {
            System.out.println((index++)+" "+ string);
        }
    }
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println(String.format("!Hello %s",userName));
        System.out.println("There are "+ customers.size()+ " people ahead of you");
        customers.add(userName);
        System.out.println(Arrays.toString(customers.toArray()));
    }
    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 0; i <= maxQuantity; i++) {
            double subtotal = price;
            double discount = 400 * (i);
            double total = subtotal*(i+1) - discount;
            System.out.println(String.format("%s $%.2f", i,total));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i) + " -- " + prices.get(i));
        }
        return true;
    }
}
