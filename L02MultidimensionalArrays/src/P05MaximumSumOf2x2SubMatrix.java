import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan, ",\\s+");

        int[][] maxMatrix = getMaxMatrix2x2(matrix);

        printMatrix(maxMatrix);
        System.out.println(calculateTwoByTwoSum(maxMatrix, 0, 0));
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

    private static int[][] getMaxMatrix2x2(int[][]matrix) {
        int maxSum = 0;
        int maxStartRow = 0;
        int maxStartCol = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int currentSum = calculateTwoByTwoSum(matrix, i, j);
                if( currentSum > maxSum){
                    maxSum = currentSum;
                    maxStartRow = i;
                    maxStartCol = j;
                }
            }
        }

        return new int[][]{
                {matrix[maxStartRow][maxStartCol], matrix[maxStartRow][maxStartCol+1]},
                {matrix[maxStartRow+1][maxStartCol], matrix[maxStartRow+1][maxStartCol+1]}
        };
    }

    private static int calculateTwoByTwoSum(int[][] matrix, int startRow, int startCol) {
        int sum = 0;
        for (int i = startRow; i < startRow + 2; i++) {
            for (int j = startCol; j < startCol + 2; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    private static int[][] readMatrix(Scanner scan, String separator) {
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
