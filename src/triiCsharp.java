import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class triiCsharp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String num = input.replace(".", "");
        String nun = num.replace("--", "");

        int[] array = new int[nun.length()];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.getNumericValue(Math.abs(nun.charAt(i)));
        }

        for (int p = 0; p < array.length; p++) {
            sum = sum + (array[p]);
            if (sum > 9){
                sum = sum/10 + sum%10;
            }

        }
        System.out.printf("%d", sum);
    }
}
