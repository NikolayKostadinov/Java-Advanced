import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(n, scan, "\\s++");

        int diagonal1Sum = 0;
        int diagonal2Sum = 0;

        for (int i = 0; i < n; i++) {
                diagonal1Sum += matrix[i][i];
                diagonal2Sum += matrix[n-1-i][i];
        }

        System.out.println(Math.abs(diagonal1Sum - diagonal2Sum));


    }

    private static int[][] readMatrix(int rows, Scanner scan, String separator) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scan, separator);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scan, String separator) {
        return Arrays.stream(scan.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }
}
