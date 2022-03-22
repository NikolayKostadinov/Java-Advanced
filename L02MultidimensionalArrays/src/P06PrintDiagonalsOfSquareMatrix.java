import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rowsCols = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(rowsCols, rowsCols, scan, "\\s+");

        StringBuffer diagonal1 = new StringBuffer();
        StringBuffer diagonal2 = new StringBuffer();
        for (int i = 0; i < rowsCols; i++) {
            diagonal1.append(matrix[i][i] + " ");
            diagonal2.append(matrix[rowsCols - 1 - i][i] + " ");
        }
        System.out.println(diagonal1);
        System.out.println(diagonal2);
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scan, String separator) {
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
