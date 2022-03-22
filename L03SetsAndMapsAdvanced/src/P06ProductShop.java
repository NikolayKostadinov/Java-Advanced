import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Double>> data = new TreeMap<>();

        String input = scan.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(",\\s+");
            data.putIfAbsent(tokens[0], new LinkedHashMap<>());
            data.get(tokens[0]).put(tokens[1], Double.parseDouble(tokens[2]));
            input = scan.nextLine();
        }

        System.out.println(data.entrySet()
                .stream()
                .map(shop ->
                        String.format("%s->%n%s", shop.getKey(),
                                shop.getValue()
                                        .entrySet()
                                        .stream()
                                        .map((product ->
                                                String.format("Product: %s, Price: %.1f",
                                                        product.getKey(),
                                                        product.getValue())))
                                        .collect(Collectors.joining(System.lineSeparator()))
                        )
                )
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
