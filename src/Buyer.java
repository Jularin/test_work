import java.util.ArrayList;

public class Buyer {
    private String name;
    private ArrayList<City> cities;

    public Buyer(String name, ArrayList<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
}
