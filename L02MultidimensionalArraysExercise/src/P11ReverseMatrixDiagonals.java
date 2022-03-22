import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] matrixDimensions = readArray(scan, "\\s+");
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = readMatrix(rows, cols, scan, "\\s+");

        int row = rows - 1;
        int col = cols - 1;

        StringBuilder sb = new StringBuilder();
        while (row >= 0) {
            int i = row;
            int j = col;
            while (i >= 0 && j < cols) {
                sb.append(String.format("%d ", matrix[i--][j++]));
            }
            sb.append("\n");

            if (col > 0) {
                col--;
            } else {
                row--;
                col = 0;
            }
        }

        System.out.print(sb);
    }

    private static void appendDiagonal(int cols, int[][] matrix, StringBuilder sb, int i, int j) {

    }

    private static int[][] readMatrix(int rows, int cols, Scanner scan, String separator) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(readArray(scan, separator)).limit(cols).toArray();
        }
        return matrix;
    }

    private static int[] readArray(Scanner scan, String separator) {
        return Arrays.stream(scan.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }
}
