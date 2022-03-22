import java.util.*;
import java.util.stream.Collectors;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> usersLog = new TreeMap<>();

        String input = scan.nextLine();

        while (!"end".equals(input)) {
            Map.Entry<String, String> entry = parseInput(input);
            usersLog.putIfAbsent(entry.getKey(), new LinkedHashMap<>());
            Map<String, Integer> user = usersLog.get(entry.getKey());
            user.putIfAbsent(entry.getValue(), 0);
            user.put(entry.getValue(), user.get(entry.getValue()) + 1);
            input = scan.nextLine();
        }

        usersLog.entrySet()
                .stream()
                .forEach(user ->
                {
                    String ipStatistics = String.join(", " ,
                            user.getValue().entrySet()
                            .stream()
                            .map(ip-> String.format("%s => %d", ip.getKey(), ip.getValue()))
                                    .collect(Collectors.toCollection(ArrayList::new)));
                    System.out.printf("%s:%n%s.%n", user.getKey(),ipStatistics);
                });
    }

    private static Map.Entry<String, String> parseInput(String input) {
        String[] tokens = input.split("\\s+");
        String ip = tokens[0].split("=")[1];
        String user = tokens[2].split("=")[1];
        return new AbstractMap.SimpleEntry<>(user,ip);
    }
}
