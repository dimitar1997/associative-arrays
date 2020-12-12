import java.util.*;
import java.util.stream.Collectors;

public class companyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> users = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];

            if (!users.containsKey(company)) {
                users.put(company, new ArrayList<>());
                users.get(company).add(id);
            } else {
                if (!users.get(company).contains(id)) {
                    users.get(company).add(id);
                }
            }
            input = scanner.nextLine();
        }
        users.entrySet()
                .forEach(id -> {
                    System.out.println(id.getKey());
                    id.getValue().forEach(k -> System.out.printf("-- %s%n", k));
                });

    }
}
