import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> courseName = new LinkedHashMap<>();
         String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] tokens = input.split(" : ");
            String program = tokens[0];
            String name = tokens[1];


            if (!courseName.containsKey(program)){
                courseName.put(program, new ArrayList<>());
                courseName.get(program).add(name);
            }else {
                courseName.get(program).add(name);
            }
            input = scanner.nextLine();
        }

        courseName.entrySet().stream().sorted((f, s) ->
                s.getValue().size() - f.getValue().size()
        ).forEach(entry ->{
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            entry.getValue().stream().sorted(String::compareTo)
                    .forEach(e -> System.out.printf("-- %s%n", e));
        });



    }

}
