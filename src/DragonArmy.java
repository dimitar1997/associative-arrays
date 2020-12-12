import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static class Dragon {
        public String type;
        public String name;
        public int damage;
        public int health;
        public int armor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, Dragon>> indexByType = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Dragon dragon = new Dragon();
            dragon.type = tokens[0];
            dragon.name = tokens[1];
            dragon.damage = "null".equals(tokens[2]) ? 45 : Integer.parseInt(tokens[2]);
            dragon.health = "null".equals(tokens[3]) ? 250 : Integer.parseInt(tokens[3]);
            dragon.armor = "null".equals(tokens[4]) ? 10 : Integer.parseInt(tokens[4]);
            TreeMap<String, Dragon> indexByName = indexByType.get(dragon.type);
            if (indexByName == null) {
                indexByName = new TreeMap<>();
                indexByType.put(dragon.type, indexByName);
            }
            indexByName.put(dragon.name, dragon);
        }
        for (var pair : indexByType.entrySet()) {
            String type = pair.getKey();
            TreeMap<String, Dragon> indexByName = pair.getValue();
            double avrDamage = indexByName.values().stream()
                    .mapToInt(d -> d.damage)
                    .average().getAsDouble();
            double avrHealth = indexByName.values().stream()
                    .mapToInt(d -> d.health)
                    .average().getAsDouble();
            double avrArmor = indexByName.values().stream()
                    .mapToInt(d -> d.armor)
                    .average().getAsDouble();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avrDamage, avrHealth, avrArmor);
            for (Dragon dragon : indexByName.values()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.name, dragon.damage, dragon.health, dragon.armor);
            }

        }
    }
}
