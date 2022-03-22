import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        long sum = sum(array, 0);
        System.out.println(sum);
    }

    private static long sum(int[] array, int i) {
        if (i < array.length-1) {
            return array[i] + sum(array, i + 1);
        }

        return array[i];
    }
}
