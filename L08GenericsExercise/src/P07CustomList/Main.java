package P07CustomList;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        GenericList<String> list = new GenericList<>();
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while (!"END".equals(command)) {
            executeCommand(list, command);
            command = scan.nextLine();
        }
    }

    private static void executeCommand(GenericList<String> list, String command) {
        String[] tokens = command.split(" ");
        switch (tokens[0]) {
            case "Add":
                list.add(tokens[1]);
                break;
            case "Remove":
                list.remove(Integer.parseInt(tokens[1]));
                break;
            case "Contains":
                System.out.println(list.contains(tokens[1]));
                break;
            case "Swap":
                int index1 = Integer.parseInt(tokens[1]);
                int index2 = Integer.parseInt(tokens[2]);
                list.swap(index1, index2);
                break;
            case "Greater":
                System.out.println(list.countGreaterThan(tokens[1]));
                break;
            case "Max":
                System.out.println(list.getMax());
                break;
            case "Min":
                System.out.println(list.getMin());
                break;
            case "Print":
                System.out.println(list.getElements().stream().collect(Collectors.joining(System.lineSeparator())));
                break;
        }


    }
}
