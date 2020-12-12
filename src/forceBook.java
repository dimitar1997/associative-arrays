import java.util.*;

public class forceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceUsers = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")){
            String[] command;
            String operand = "";

            if (input.contains("|")) {
                command = input.split("\\s+\\|\\s+");
                operand = "|";
            } else {
                command = input.split("\\s+->\\s+");
                operand = "->";
            }

            switch (operand){
                case "|":
                    String forceSide = command[0];
                    String forceUser = command[1];
                    if (!forceUsers.containsKey(forceSide)){
                        forceUsers.put(forceSide, new ArrayList<>());
                        forceUsers.get(forceSide).add(forceUser);
                    }else {
                        forceUsers.get(forceSide).add(forceUser);
                    }
                    break;
                case "->":
                    String forceUser1 = command[0];
                    String forceSide1 = command[1];

                    for (Map.Entry<String, List<String>> k : forceUsers.entrySet()) {
                        if (k.getValue().contains(forceUser1)) {
                            forceUsers.get(k.getKey()).remove(forceUser1);
                            break;
                        }
                    }
                       if (!forceUsers.containsValue(forceUser1) && forceUsers.containsKey(forceSide1)){
                           forceUsers.get(forceSide1).add(forceUser1);
                           System.out.printf("%s joins the %s side!%n", forceUser1, forceSide1);
                          break;
                       }

            }
            input = scanner.nextLine();
        }
        forceUsers .entrySet()
                .stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());

                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });
    }
}
