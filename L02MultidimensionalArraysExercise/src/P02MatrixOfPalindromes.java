import javax.swing.text.AttributeSet;
import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = generateMatrix(rows, cols);
        printMatrix(matrix);
    }

    private static String[][] generateMatrix(int rows, int cols) {
        String[][] matrix = new String [rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = generateString(i,j);
            }
        }
        return matrix;
    }

    private static String generateString(int row, int col) {
        char startAndEnd = (char)('a'+ row);
        char middle = (char)('a'+ row + col);
        return String.format("%c%c%c",startAndEnd,middle,startAndEnd);
    }

    private static <T> void printMatrix(T[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }
}
