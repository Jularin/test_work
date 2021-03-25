import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Order> orders;

    public City(String name, ArrayList<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }
}
