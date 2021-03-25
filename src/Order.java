import java.io.Serializable;

public class Order implements Serializable {
    private String name;
    private int count;

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCount(int amount){
        this.count += amount;
    }
}
