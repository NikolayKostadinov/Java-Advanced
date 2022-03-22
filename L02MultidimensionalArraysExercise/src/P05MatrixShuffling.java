import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = readArray(scan, "\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = readMatrix(rows, cols, scan, "\\s+");

        String command = scan.nextLine();
        while (!"END".equals(command)) {
            if (commandIsValid(command, matrix)) {
                {
                    String[] tokens = command.split("\\s+");
                    int row1 = Integer.parseInt(tokens[1]);
                    int col1 = Integer.parseInt(tokens[2]);
                    int row2 = Integer.parseInt(tokens[3]);
                    int col2 = Integer.parseInt(tokens[4]);

                    swapElements(matrix, row1, col1, row2, col2);
                    printMatrix(matrix);
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scan.nextLine();
        }
    }

    private static boolean commandIsValid(String command, String[][] matrix) {
        String[] tokens = command.split("\\s+");
        if (tokens.length == 5 && tokens[0].equals("swap")) {
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);
            return inMatrixBoundary(row1, col1, matrix)
                    && inMatrixBoundary(row2, col2, matrix);
        }
        return false;
    }


    private static void swapElements(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static boolean inMatrixBoundary(int row, int col, String[][] matrix) {
        return row >= 0
                && col >= 0
                && row <= matrix.length
                && col <= matrix[row].length;
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scan, String separator) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] arr = readArray(scan, separator);
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[j];
            }
        }
        return matrix;
    }

    private static String[] readArray(Scanner scan, String separator) {
        return scan.nextLine().split(separator);
    }

    private static <T> void printMatrix(T[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }
}
