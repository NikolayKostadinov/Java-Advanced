import java.util.*;

public class P11LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Integer> durations = new TreeMap<>();
        Map<String, Set<String>> ipAddresses = new HashMap<>();

        int counter = Integer.parseInt(scan.nextLine());

        while (counter-- > 0){
            String[] tokens = scan.nextLine().split("\\s+");
            String ipAddress = tokens[0];
            String userName = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            durations.putIfAbsent(userName, 0);
            durations.put(userName, durations.get(userName) + duration);

            ipAddresses.putIfAbsent(userName, new TreeSet<>());
            ipAddresses.get(userName).add(ipAddress);
        }

        durations.entrySet()
                .stream()
                .forEach(user ->{
                    System.out.printf("%s: %s %s%n",
                            user.getKey(),
                            user.getValue(),
                            ipAddresses.get(user.getKey()).toString());
                });
    }
}
