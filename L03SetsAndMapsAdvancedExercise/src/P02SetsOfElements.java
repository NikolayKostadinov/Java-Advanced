import java.util.*;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        String input = scanner.nextLine();//"4 3".SPLIT -> ["4", "3"]
        int countFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int countSecondSet = Integer.parseInt(input.split("\\s+")[1]);

        //1. напълним двата сета
        for (int i = 0; i < countFirstSet; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < countSecondSet; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }
        // 2. взимаме елементите, които ги има в двата сета
        //1. нов сет за съхранение на поввтарящите елементи
        //{1, 3, 5, 7}
        //{3, 4, 5}
        LinkedHashSet<Integer> duplicatedElements = new LinkedHashSet<>();
        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                duplicatedElements.add(number);
            }
        }

        //{1, 3, 5, 7}
        //{3, 4, 5}
        //firstSet.retainAll(secondSet);
        //в първия сет остават елементите, които ги има във втория

        duplicatedElements.forEach(number -> System.out.print(number + " "));
    }
}
