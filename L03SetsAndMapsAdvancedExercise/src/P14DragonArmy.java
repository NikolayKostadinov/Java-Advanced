import java.util.*;

public class P14DragonArmy {
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, Statistics>> dataTable = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            parseInput(dataTable, input);
        }

        printData(dataTable);
    }

    private static void printData(Map<String, Map<String, Statistics>> dataTable) {
        for (Map.Entry<String, Map<String, Statistics>> type : dataTable.entrySet()) {
            Map<String, Statistics> dragons = type.getValue();
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmour = 0;

            for (Statistics value : dragons.values()) {
                averageDamage += value.damage;
                averageHealth += value.health;
                averageArmour += value.armor;
            }

            averageDamage /= dragons.size();
            averageHealth /= dragons.size();
            averageArmour /= dragons.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), averageDamage, averageHealth, averageArmour);

            for (Map.Entry<String, Statistics> dragon : type.getValue()
                    .entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragon.getKey(),
                        dragon.getValue().damage,
                        dragon.getValue().health,
                        dragon.getValue().armor);
            }
        }
    }

    private static void parseInput(Map<String, Map<String, Statistics>> dataTable, String input) {
        String[] tokens = input.split("\\s+");
        String type = tokens[0];
        String name = tokens[1];
        Integer damage = (tokens[2].equals("null")) ? null : Integer.parseInt(tokens[2]);
        Integer health = (tokens[3].equals("null")) ? null : Integer.parseInt(tokens[3]);
        Integer armour = (tokens[4].equals("null")) ? null : Integer.parseInt(tokens[4]);

        dataTable.putIfAbsent(type, new TreeMap<>());
        Map<String, Statistics> typeTable = dataTable.get(type);
        typeTable.put(name, new Statistics(damage, health, armour));
    }

    private static class Statistics {
        int damage;
        int health;
        int armor;

        public Statistics(Integer damage, Integer health, Integer armor) {
            this.damage = Objects.requireNonNullElse(damage, DEFAULT_DAMAGE);
            this.health = Objects.requireNonNullElse(health, DEFAULT_HEALTH);
            this.armor = Objects.requireNonNullElse(armor, DEFAULT_ARMOR);
        }
    }
}
