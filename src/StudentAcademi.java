import java.util.*;

public class StudentAcademi {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new HashMap<>();

        for (int i = 1; i <= n ; i++) {
            String name = scanner.nextLine();
            double score = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(name)){
                students.put(name, new ArrayList<>());
                students.get(name).add(score);
            }else {
                students.get(name).add(score);
            }
        }
        Map<String, Double> averageGrade = new LinkedHashMap<>();
      for (Map.Entry<String, List<Double>> kvp : students.entrySet()){
          double average = kvp.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
          if (average >= 4.50){
              averageGrade.put(kvp.getKey(), average);
          }
      }
      averageGrade.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
              .forEach(grade -> {
                  System.out.printf("%s -> %.2f%n", grade.getKey(), grade.getValue());
              });
    }
}
