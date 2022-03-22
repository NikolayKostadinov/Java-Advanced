import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        Map<Character, Integer> charactersOccurrences = new TreeMap<>();

        for (char character : text.toCharArray()) {
            charactersOccurrences.putIfAbsent(character, 0);
            charactersOccurrences.put(character, charactersOccurrences.get(character) + 1);
        }

        charactersOccurrences.entrySet()
                .stream()
                .forEach(entry -> System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue()));
    }
}
