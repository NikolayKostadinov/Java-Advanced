package P03GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<String> elements = new ArrayList<>();

        while (count-- > 0) {
            String element = scan.nextLine();
            elements.add(element);
        }

        int[] indexes = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        swap(elements, indexes[0], indexes[1]);

        elements
                .stream()
                .map(Box::new)
                .forEach(System.out::println);
    }

    public static <T> void swap(List<T> list, int sourceIx, int destinationIx) {
        T element = list.get(sourceIx);
        list.set(sourceIx, list.get(destinationIx));
        list.set(destinationIx, element);
    }
}
