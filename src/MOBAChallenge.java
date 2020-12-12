import java.util.*;

public class MOBAChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> mobaPlayers = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Season end")) {
            if (input.contains(" -> ")) {
                String[] tokens = input.split(" -> ");
                String player = tokens[0];
                String position = tokens[1];
                int skills = Integer.parseInt(tokens[2]);
                if (!mobaPlayers.containsKey(player)) {
                    mobaPlayers.put(player, new TreeMap<>());
                    mobaPlayers.get(player).put(position, skills);
                } else {
                    if (!mobaPlayers.get(player).containsKey(position)) {
                        mobaPlayers.get(player).put(position, skills);
                    } else {
                        if (mobaPlayers.get(player).get(position) < skills) {
                            mobaPlayers.get(player).put(position, skills);
                        }
                    }
                }
            } else if (input.contains(" vs ")){
                String[] tokens = input.split(" vs ");
                String player1 = tokens[0];
                String player2  = tokens[1];

                if (mobaPlayers.containsKey(player1)
                        && mobaPlayers.containsKey(player2)) {
                    for (String f1 : mobaPlayers.get(player1).keySet()) {
                        int score1 = mobaPlayers.get(player1).get(f1);
                        for (String f2 : mobaPlayers.get(player2).keySet()) {
                            int score2 = mobaPlayers.get(player2).get(f2);
                            if (f1.equals(f2)) {
                                if (score1 < score2) {
                                    mobaPlayers.remove(player1);
                                } else if (score1 == score2) {
                                    break;
                                } else {
                                    mobaPlayers.remove(player2);
                                }
                            }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        mobaPlayers.entrySet().stream().sorted((k1, k2) -> {
            int score = Integer.compare(k2.getValue().values().stream().mapToInt(n -> n).sum(),
                    k1.getValue().values().stream().mapToInt(n -> n).sum());
            return score;
        })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(),
                            entry.getValue().values().stream().mapToInt(n -> n).sum());
                    entry.getValue().entrySet().stream().sorted((v1, v2) ->
                            v2.getValue().compareTo(v1.getValue()))
                            .forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });
    }
}
