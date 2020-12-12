import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class proba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courseName = new LinkedHashMap<>();
        List<Integer> list = List.of();
        var avg = list.stream().mapToInt(Integer::intValue).average();
        if (avg.isPresent()) {
            double value = avg.getAsDouble();
            System.out.println(value);
        }
        else {
            System.out.println("The stream is empty.");
        }
        final List<Map.Entry<String, List<String>>> filteredAndSortedEntryList = courseName.entrySet().stream()
                .filter(entry -> !entry.getKey().equals("gosho"))
                .sorted(Map.Entry.comparingByKey())
                .peek(entry -> System.out.println(entry.getKey()))
                .distinct()
                .peek(entry -> System.out.println(entry.getKey()))
                .limit(20)
                .skip(5)
                .collect(Collectors.toList());
        final boolean isAllMatch = filteredAndSortedEntryList.stream()
                .allMatch(entry -> entry.getKey().equals("ivan"));
        if(isAllMatch){
            filteredAndSortedEntryList.forEach(entry -> System.out.println(entry.getKey()));
        }
    }


}
