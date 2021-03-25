import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {
        ArrayList<Buyer> buyers = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Admin\\Desktop\\homework\\java-homework\\src\\data\\orders.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] arr = line.split("\\|");

                if (contain_user(buyers, arr[0]) != -1){
                    Buyer buyer = buyers.get(contain_user(buyers, arr[0]));
                    if (contain_city(buyer.getCities(), arr[1]) != -1){
                        City city = buyer.getCities().get(contain_city(buyer.getCities(), arr[1]));
                        if (contain_orders(city.getOrders(), arr[2]) != -1){
                            Order order = city.getOrders().get(contain_orders(city.getOrders(), arr[2]));
                            order.addCount(Integer.parseInt(arr[3]));

                        }
                        else{
                            Order order = new Order(arr[2], Integer.parseInt(arr[3]));
                            city.addOrder(order);
                        }
                    }
                    else {
                        City city = new City(arr[1], new ArrayList<>());
                        Order order = new Order(arr[2], Integer.parseInt(arr[3]));
                        city.addOrder(order);
                    }
                }
                else{
                    Buyer buyer = new Buyer(arr[0], new ArrayList<>());
                    buyers.add(buyer);
                    City city = new City(arr[1], new ArrayList<>());
                    Order order = new Order(arr[2], Integer.parseInt(arr[3]));
                    city.addOrder(order);
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstSort(buyers);

    }
    public static int contain_user(ArrayList<Buyer> buyers, String name){
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public static int contain_city(ArrayList<City> cities, String name){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public static int contain_orders(ArrayList<Order> orders, String name){
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public static void firstSort(ArrayList<Buyer> notSortedBuyers) {
        TreeSet<Buyer> buyers = new TreeSet<>(
                new BuyerByNameComparator().thenComparing(
                        new BuyerByCityCountComparator().thenComparing(
                                new BuyerByOrdersCountComparator())));
        buyers.addAll(notSortedBuyers);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Desktop\\homework\\java-homework\\src\\data\\sortedByName.txt")))
        {
            oos.writeObject(buyers);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void secondSort(ArrayList<Buyer> notSortedBuyers) {
        TreeSet<Buyer> buyers = new TreeSet<>(
                new BuyerByOrdersCountComparator().thenComparing(
                        new BuyerByCityCountComparator().thenComparing(
                                new BuyerByNameComparator())));
        buyers.addAll(notSortedBuyers);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Desktop\\homework\\java-homework\\src\\data\\sortedByOrders.txt")))
        {
            oos.writeObject(buyers);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
