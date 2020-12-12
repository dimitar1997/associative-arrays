import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsinString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String input = scanner.nextLine();

        Map<Character, Integer> counts = new LinkedHashMap<>();

      for (char c : input.toCharArray()){
        if (c != ' '){
            if (counts.containsKey(c)){
                int num = counts.get(c);
                counts.put(c, num + 1);
            }else {
                counts.put(c, 1);
            }
        }
      }
      counts.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
