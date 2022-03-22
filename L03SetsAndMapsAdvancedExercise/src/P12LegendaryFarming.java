import java.util.*;

public class P12LegendaryFarming {

    public static final int MAXVALUE = 250;

    public static final Map<String, String> ITEMS = new HashMap<>() {{
        put("shards", "Shadowmourne");
        put("fragments", "Valanyr");
        put("motes", "Dragonwrath");
    }};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>() {{
            put("shards", 0);
            put("fragments", 0);
            put("motes", 0);
        }};

        Map<String, Integer> junkMaterials = new TreeMap<>();
        int value = 0;

        Boolean completed = false;
        while (!completed) {
            String[] input = scan.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                value = Integer.parseInt(input[i]);
                String material = input[i + 1];
                if (keyMaterials.containsKey(material)) {
                    int result = keyMaterials.get(material) + value;
                    keyMaterials.put(material, result);
                    if (result >= MAXVALUE) {
                        System.out.printf("%s obtained!%n", ITEMS.get(material));
                        keyMaterials.put(material, result - MAXVALUE);
                        completed = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + value);
                }
            }
        }

        keyMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach((entry) -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junkMaterials.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));

    }
}
