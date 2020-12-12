import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> prices = new LinkedHashMap<>();
        Map<String, Integer> orders = new LinkedHashMap<>();

        while (true){
            String[] tokens = scanner.nextLine().split(" ");
            if (tokens[0].equals("buy")){
                break;
            }
            if (!prices.containsKey(tokens[0])){
                orders.put(tokens[0], Integer.parseInt(tokens[2]));
                double price = Double.parseDouble(tokens[1]) * Double.parseDouble(tokens[2]);
                prices.put(tokens[0], price);
            }else {
                orders.put(tokens[0], orders.get(tokens[0]) + Integer.parseInt(tokens[2]));
                prices.put(tokens[0], orders.get(tokens[0]) * Double.parseDouble(tokens[1]));
            }
        }
        prices.forEach((k, v)-> System.out.printf( "%s -> %.2f%n",k ,v));

    }
}
