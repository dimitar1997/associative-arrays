import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> contest = new LinkedHashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");

            String userName = tokens[0];
            String contestPerPerson = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            if (!contest.containsKey(contestPerPerson)) {
                    contest.put(contestPerPerson, new LinkedHashMap<>());
                    contest.get(contestPerPerson).put(userName, points);

            } else {

                if (!contest.get(contestPerPerson).containsKey(userName)) {
                    contest.get(contestPerPerson).put(userName, points);
                } else {
                    if (contest.get(contestPerPerson).get(userName) < points) {
                        contest.get(contestPerPerson).put(userName, points);
                    }
                }
            }

            input = scanner.nextLine();
        }
        AtomicInteger num = new AtomicInteger(1);

        contest.entrySet().stream().sorted((f, s) ->
                s.getValue().size() - f.getValue().size())
                .forEach(entry -> {
                    num.set(1);
                    System.out.println(entry.getKey() + ": " + entry.getValue().size()
                            + " participants");
                    entry.getValue().entrySet().stream().sorted((k, v) ->
                            v.getValue().compareTo(k.getValue()))
                            .forEach(element ->
                            {
                                System.out.printf("%d. %s <::> %d%n", num.getAndIncrement(), element.getKey(), element.getValue());

                            });
                });
        Map<String, Integer> individual = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> k : contest.entrySet()) {
            for (Map.Entry<String, Integer> m : k.getValue().entrySet()) {
                individual.putIfAbsent(m.getKey(), 0);
                individual.put(m.getKey(), individual.get(m.getKey())
                + m.getValue());

            }
        }
        System.out.println("Individual standings:");
        num.set(1);
        individual.entrySet().stream().sorted((k, v) ->
                v.getValue().compareTo(k.getValue()))
                .forEach(val -> {
                    System.out.printf("%d. %s -> %d%n", num.getAndIncrement(),
                            val.getKey(), val.getValue());
                });
    }
}
