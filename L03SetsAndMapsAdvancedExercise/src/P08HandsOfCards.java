import java.util.*;
import java.util.stream.Collectors;

public class P08HandsOfCards {
    private static final Map<String, Integer> POWERS = new HashMap<String, Integer>() {{
        put("1", 1); put("2", 2); put("3", 3); put("4", 4); put("5", 5);
        put("6", 6); put("7", 7); put("8", 8); put("9", 9); put("10", 10);
        put("J", 11); put("Q", 12); put("K", 13); put("A", 14);}};
    private static final Map<String, Integer> TYPES = new HashMap<String, Integer>() {{
        put("S", 4); put("H", 3); put("D", 2); put("C", 1);
    }};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, HashSet<String>> playersScore = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(":\\s+");
            String name = tokens[0];

            List<String> cards = Arrays.stream(tokens[1].split(",\\s+"))
                    .collect(Collectors.toCollection(ArrayList::new));
            playersScore.putIfAbsent(name, new HashSet<>());
            playersScore.get(name).addAll(cards);

            input = scan.nextLine();
        }

        playersScore.entrySet()
                .stream()
                .forEach(player -> System.out.printf("%s: %d%n", player.getKey(), calculateValue(player.getValue())));
    }

     private static int calculateValue(HashSet<String> cards) {
        return  cards.stream().map(card -> {
            String powerStr = card.substring(0, card.length() - 1);
            String typeStr = String.valueOf(card.charAt(card.length() - 1));
            return POWERS.get(powerStr) * TYPES.get(typeStr);
        }).mapToInt(Integer::valueOf).sum();

    }
}
