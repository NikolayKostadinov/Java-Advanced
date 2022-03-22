import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> firstDeck = readNumbers(scan);
        Set<Integer> secondDeck = readNumbers(scan);

        int round = 50;

        while (round-- > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            int firstCard = pullTopCard(firstDeck);
            int secondCard = pullTopCard(secondDeck);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (firstCard < secondCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }

        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    private static Integer pullTopCard(Set<Integer> deck) {
        int value = deck.stream().findFirst().orElse(0);
        deck.remove(value);
        return value;
    }

    private static Set<Integer> readNumbers(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .limit(20)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
