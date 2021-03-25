import java.util.Comparator;

public class BuyerByCityCountComparator implements Comparator<Buyer> {

    @Override
    public int compare(Buyer o1, Buyer o2) {
        return o1.getCities().size() - o2.getCities().size();
    }
}
