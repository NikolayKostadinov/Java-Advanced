import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            int[] input = readArray(scan, "\\s+");
            int rows = input[0];
            int cols = input[1];

            int[][] matrix = readMatrix(rows, cols, scan, "\\s+");

        int maxSum = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                int sum = calculateSum3x3(i,j, matrix);
                if (sum > maxSum){
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(getSubMatrix(maxRow, maxCol, matrix));
    }

    private static int calculateSum3x3(int row, int col, int[][] matrix) {
        Integer[][] subMatrix = getSubMatrix(row, col, matrix);
        int sum = 0;
        for (Integer[] cols : subMatrix) {
            for (Integer cell : cols) {
                sum += cell;
            }
        }
        return sum;
    }


    private static Integer[][] getSubMatrix(int row, int col, int[][] matrix) {
        Integer[][] subMatrix = new Integer[3][3];
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix.length; j++) {
                subMatrix[i][j] = matrix[i+row][j+col];
            }
        }

        return subMatrix;
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

    private static <T> void printMatrix(T[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }
}
