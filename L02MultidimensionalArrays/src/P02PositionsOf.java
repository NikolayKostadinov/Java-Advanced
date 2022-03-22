import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);

        int number = Integer.parseInt(scan.nextLine());

        List<int[]> result = findNumber(matrix, number);
        printResult(result);
    }

    private static List<int[]> findNumber(int[][] matrix, int number) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private static void printResult(List<int[]> result) {
        if (result.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] finding : result) {
                System.out.println(String.format("%d %d", finding[0], finding[1]));
            }
        }
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
