import java.util.Arrays;
import java.util.Scanner;

public class wordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] word = Arrays.stream(scanner.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0).toArray(String[]::new);

        for (int i = 0; i <word.length ; i++) {
            System.out.println(word[i]);
        }
    }
}
