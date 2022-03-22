import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> playersQueue = new ArrayDeque<>(List.of(scan.nextLine().split("\\s+")));
        int number = Integer.parseInt(scan.nextLine());
        int index = 1;
        while (playersQueue.size() > 1) {
            for (int i = 0; i < number - 1; i++) {
                playersQueue.offer(playersQueue.poll());
            }
            if (isPrime(index)) {
                System.out.printf("Prime %s%n", playersQueue.peek());
            } else {
                System.out.printf("Removed %s%n", playersQueue.poll());
            }
            index++;
        }

        System.out.printf("Last is %s%n", playersQueue.poll());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
