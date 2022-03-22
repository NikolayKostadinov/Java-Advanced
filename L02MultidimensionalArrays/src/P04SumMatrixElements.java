import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);

        printMatrixDescription(matrix);
    }

    private static void printMatrixDescription(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(getSumOfMatrix(matrix));
    }

    private static long getSumOfMatrix(int[][] matrix) {
        long sum = 0L;
        for (int[] rows : matrix) {
            for (int cell : rows) {
                sum+=cell;
            }
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scan) {
        String separator = ",\\s+";
        int[] rowsAndCols = readArray(scan, separator);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
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
