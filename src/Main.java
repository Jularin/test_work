import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.*;
import java.util.ArrayList;


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
                    int buyer_id = contain_user(buyers, arr[0]);
                    св
                }


                Order order = (new Order(arr[0], Integer.parseInt(arr[3])));
                City city = new City(arr[1], );
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int contain_user(ArrayList<Buyer> buyers, String name){
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public static int contain_city(ArrayList<Buyer> buyers, String name){
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public static int contain_orders(ArrayList<Buyer> buyers, String name){
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
