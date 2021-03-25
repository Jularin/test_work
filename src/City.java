import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    private String name;
    private ArrayList<Order> orders;

    public City(String name, ArrayList<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
}
