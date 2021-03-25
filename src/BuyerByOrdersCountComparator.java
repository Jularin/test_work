import java.util.ArrayList;
import java.util.Comparator;

public class BuyerByOrdersCountComparator implements Comparator<Buyer> {
    @Override
    public int compare(Buyer o1, Buyer o2) {
        int o1Orders = 0;
        int o2Orders = 0;
        for (int i = 0; i < o1.getCities().size(); i++) {
            ArrayList<Order> orders = o1.getCities().get(i).getOrders();
            for (Order order : orders) {
                o1Orders += order.getCount();
            }
        }
        for (int i = 0; i < o2.getCities().size(); i++) {
            ArrayList<Order> orders = o2.getCities().get(i).getOrders();
            for (Order order : orders) {
                o1Orders += order.getCount();
            }
        }
        return o1Orders - o2Orders;
    }
}
