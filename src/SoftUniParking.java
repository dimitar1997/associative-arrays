import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> namesLicense = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
           String[] tokens = scanner.nextLine().split(" ");
           switch (tokens[0]){
               case "register":
                   if (namesLicense.containsKey(tokens[1])){
                       System.out.println("ERROR: already registered with plate number " + tokens[2]);
                   }else {
                       namesLicense.put(tokens[1], tokens[2]);
                       System.out.printf("%s registered %s successfully%n", tokens[1], tokens[2]);
                   }
                   break;
               case "unregister":
                   if (namesLicense.containsKey(tokens[1])){
                       namesLicense.remove(tokens[1]);
                       System.out.printf("%s unregistered successfully%n", tokens[1]);
                   }else {
                       System.out.printf("ERROR: user %s not found%n", tokens[1]);
                   }
                   break;
           }
        }
        namesLicense.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
