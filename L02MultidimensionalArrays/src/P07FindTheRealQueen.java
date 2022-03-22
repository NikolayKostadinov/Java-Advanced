import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = readMatrix(8, 8, scan);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == 'q' && isQueenValid(matrix, i, j)) {
                    System.out.printf("%d %d", i, j);
                    return;
                }
            }
        }
    }

    private static boolean isQueenValid(char[][] matrix, int row, int col) {
        return checkRow(matrix, row, col) && checkCol(matrix, row, col) && checkDiagonals(matrix, row, col);
    }

    private static boolean checkDiagonals(char[][] matrix, int row, int col) {
        int rowD = row;
        int colD = col;

        while (rowD > 0 && colD > 0) {
            rowD--;
            colD--;
            if (matrix[rowD][colD] == 'q') {
                return false;
            }
        }

        rowD = row;
        colD = col;

        while (rowD < 7 && colD < 7) {
            rowD++;
            colD++;
            if (matrix[rowD][colD] == 'q') {
                return false;
            }
        }

        rowD = row;
        colD = col;

        while (rowD > 0 && colD < 7) {
            rowD--;
            colD++;
            if (matrix[rowD][colD] == 'q') {
                return false;
            }
        }

        rowD = row;
        colD = col;

        while (rowD < 7 && colD > 0) {
            rowD++;
            colD--;
            if (matrix[rowD][colD] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(char[][] matrix, int row, int col) {
        for (int i = 0; i < 8; i++) {
            if (i != row && matrix[i][col] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(char[][] matrix, int row, int col) {
        for (int i = 0; i < 8; i++) {
            if (i != col && matrix[row][i] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scan, "\\s+");
        }
        return matrix;
    }

    private static char[] readArray(Scanner scan, String separator) {
        return scan.nextLine().replaceAll(separator, "").toCharArray();
    }
}
