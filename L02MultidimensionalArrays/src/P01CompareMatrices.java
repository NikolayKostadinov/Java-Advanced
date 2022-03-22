import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix1 = readMatrix(scan);
        int[][] matrix2 = readMatrix(scan);

        if (matricesAreEqual(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean matricesAreEqual(int[][] first, int[][] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i].length != second[i].length) return false;
            for (int j = 0; j < first[i].length; j++) {
                if (first[i][j] != second[i][j]) return false;
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scan) {
        int[] rowsAndCols = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
