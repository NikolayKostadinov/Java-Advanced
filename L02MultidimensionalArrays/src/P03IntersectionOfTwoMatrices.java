import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] matrix1 = readMatrix(rows, cols, scan);
        char[][] matrix2 = readMatrix(rows, cols, scan);

        char[][] intersectedMatrix = intersectMatrices(matrix1, matrix2);
        printMatrix(intersectedMatrix);

    }

    private static void printMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (char[] row : matrix) {
            for (char chr : row) {
                sb.append(String.valueOf(chr));
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static char[][] intersectMatrices(char[][] first, char[][] second) {
        char[][] result = new char[first.length][first[0].length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                result[i][j] = (first[i][j] == second[i][j]) ? first[i][j] : '*';
            }
        }
        return result;
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
