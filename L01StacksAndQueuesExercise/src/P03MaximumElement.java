import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (input.length > 1){
                if (input[0] == 1){
                    stack.push(input[1]);
                }
            } else {
                if (input[0] == 2){
                    stack.pop();
                } else if(input[0] == 3){
                    System.out.println(stack.stream().max(Integer::compare).orElse(0));
                }
            }
        }
    }
}
