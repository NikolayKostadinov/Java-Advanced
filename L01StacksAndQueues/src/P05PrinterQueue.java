import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String command = scan.nextLine();

        while (!"print".equals(command)) {
            if ("cancel".equals(command)) {
                if (!queue.isEmpty()) {
                    System.out.printf("Canceled %s%n", queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(command);
            }
            command = scan.nextLine();
        }

        for (String document : queue) {
            System.out.println(document);
        }
    }
}
