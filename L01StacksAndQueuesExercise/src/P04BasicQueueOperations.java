import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] params = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < params[0]; i++) {
            queue.offer(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < params[1]; i++) {
            queue.poll();
        }

        if (queue.contains(params[2])){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
