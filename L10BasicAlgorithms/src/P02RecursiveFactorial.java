import java.math.BigInteger;
import java.util.Scanner;

public class P02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(factorial(n));
    }

    private static BigInteger factorial(int n) {
        if (n==0){
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}
