import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Double, Integer> numbers = new LinkedHashMap<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(n -> {
                    numbers.putIfAbsent(n,0);
                    numbers.put(n,numbers.get(n) + 1);
                });

        numbers.entrySet()
                .stream()
                .forEach(entry-> System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue()));
    }
}
