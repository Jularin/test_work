import java.util.Comparator;

public class BuyerByNameComparator implements Comparator<Buyer> {

    @Override
    public int compare(Buyer o1, Buyer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
