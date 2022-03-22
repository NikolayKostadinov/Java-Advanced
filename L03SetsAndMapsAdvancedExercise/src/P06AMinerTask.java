import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ix = 1;

        Map<String, Long> resources = new LinkedHashMap<>();
        String resourceName = scan.nextLine();
        while (!"stop".equals(resourceName)) {
            if (ix % 2 == 0) {
                resourceName = scan.nextLine();
            } else {
                int quantity = Integer.parseInt(scan.nextLine());
                resources.putIfAbsent(resourceName, 0L);
                resources.put(resourceName, resources.get(resourceName) + quantity);
            }
            ix++;
        }

        resources.entrySet()
                .stream()
                .forEach(resource -> System.out.printf("%s -> %d%n", resource.getKey(), resource.getValue()));
    }
}
