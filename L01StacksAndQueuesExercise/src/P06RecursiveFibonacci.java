import java.util.Scanner;
//todo: solve this again
public class P06RecursiveFibonacci {
    private static long[] memo;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());

        memo = new long[n + 1];
        System.out.println(recursiveFibonacciWithMemoization(n));
    }

    // Top down DP: recursion + memoization
    private static long recursiveFibonacciWithMemoization(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] =
                recursiveFibonacciWithMemoization(n - 1) +
                        recursiveFibonacciWithMemoization(n - 2);
        return memo[n];
    }
}
