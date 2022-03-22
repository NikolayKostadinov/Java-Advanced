package P09LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int counter = Integer.parseInt(scan.nextLine());

        while (counter-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens[0].equals("Add")) {
                list.add(Integer.parseInt(tokens[1]));
            } else {
                list.remove(Integer.parseInt(tokens[1]));
            }
        }

        System.out.println(list.getSize());

        StringBuilder sb = new StringBuilder();
        for (Integer number : list) {
            sb.append(number).append(list.iterator().hasNext() ? " " : "");
        }
        System.out.println(sb);
    }
}
