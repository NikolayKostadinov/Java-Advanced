import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> dataTable = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            dataTable.putIfAbsent(continent, new LinkedHashMap<>());
            dataTable.get(continent).putIfAbsent(country, new ArrayList<>());
            dataTable.get(continent).get(country).add(city);
        }

        dataTable.entrySet()
                .stream()
                .forEach(continent -> {
                    System.out.printf("%s:\n", continent.getKey());
                    continent.getValue()
                            .entrySet()
                            .forEach(country ->
                            {
                                System.out.printf("  %s -> ", country.getKey());
                                System.out.println(country.getValue().toString().replaceAll("[\\[\\]]", ""));
                            });
                });
    }
}
