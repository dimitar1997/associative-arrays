import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> wordSyn = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String word = scanner.nextLine();
            String syn = scanner.nextLine();

            List<String> currentSyn = wordSyn.get(word);
            if (currentSyn == null){
                currentSyn = new ArrayList<>();
                wordSyn.put(word, currentSyn);
            }
            currentSyn.add(syn);

        }
        for (Map.Entry<String, List<String>> stringListEntry : wordSyn.entrySet()) {
            System.out.println(stringListEntry.getKey() + " - " + String.join(", ", stringListEntry.getValue()));
        }

    }
}
