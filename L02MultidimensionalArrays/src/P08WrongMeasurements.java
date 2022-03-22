import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(rows, scan, "\\s+");
        int[] wrongValueRowCol = readArray(scan, "\\s+");
        int[][] correctMatrix = getCorrectMatrix(wrongValueRowCol, matrix);
        printMatrix(correctMatrix);
    }

    private static int [][] getCorrectMatrix(int[] wrongValueRowCol, int[][] matrix) {
        int[][] correctMatrix = new int[matrix.length][matrix[0].length];
        int wrongValue = matrix[wrongValueRowCol[0]][wrongValueRowCol[1]];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    correctMatrix[i][j] = getRightValue(matrix, i, j, wrongValue);
                } else {
                    correctMatrix[i][j] = matrix[i][j];
                }
            }
        }

        return correctMatrix;
    }

    private static int getRightValue(int[][] matrix, int i, int j, int wrongValue) {
        int sum = 0;
        //get lent
        if (j > 0) sum += (matrix[i][j - 1] != wrongValue ) ? matrix[i][j - 1] : 0;
        //get right
        if (j < matrix[0].length - 1) sum += matrix[i][j + 1] != wrongValue ? matrix[i][j + 1] : 0;
        //get upper
        if (i > 0) sum += matrix[i - 1][j] != wrongValue ? matrix[i - 1][j] : 0;
        //get downer
        if (i <matrix.length - 1) sum += matrix[i + 1][j] != wrongValue ? matrix[i + 1][j] : 0;

        return sum;
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

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int cell : row) {
                sb.append(String.format("%d ", cell));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
