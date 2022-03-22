package P01ListyIterator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        ListyIterator iterator = null;
        String command = scan.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    iterator = create(Arrays.copyOfRange(tokens, 1, tokens.length));
                    break;
                case "Move":
                    System.out.println(iterator.Move());
                    break;
                case "Print":
                    print(iterator);
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static void print(ListyIterator iterator) {
        try {
            iterator.print();
        } catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static ListyIterator create(String... records) {
        return new ListyIterator(Arrays.stream(records).collect(Collectors.toList()));
    }

}
