import java.io.File;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P12TheMatrix {
    public static void main(String[] args) {
        readInput();

    }

    private static void readInput() {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        char[][] matrix = readMatrix(rows, cols, scan, "\\s+");
        char fillSymbol = scan.nextLine().charAt(0);
        int startRow = scan.nextInt();
        int startCol = scan.nextInt();
        scan.nextLine();
        fillMatrix(matrix, startRow, startCol, fillSymbol);
        printMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix, int startRow, int startCol, char fillChar) {
        ArrayDeque<Coordinates> coordinates = new ArrayDeque<>();
        char startChar = matrix[startRow][startCol];
        coordinates.push(new Coordinates(startRow, startCol));

        while (!coordinates.isEmpty()) {
            Coordinates currentPosition = coordinates.pop();
            matrix[currentPosition.row][currentPosition.col] = fillChar;
            //get up
            if (currentPosition.row > 0 && matrix[currentPosition.row - 1][currentPosition.col] == startChar) {
                matrix[currentPosition.row - 1][currentPosition.col] = fillChar;
                coordinates.push(new Coordinates(currentPosition.row - 1, currentPosition.col));
            }
            //get down
            if (currentPosition.row < matrix.length - 1 && matrix[currentPosition.row + 1][currentPosition.col] == startChar) {
                matrix[currentPosition.row + 1][currentPosition.col] = fillChar;
                coordinates.push(new Coordinates(currentPosition.row + 1, currentPosition.col));
            }
            //get left
            if (currentPosition.col > 0 && matrix[currentPosition.row][currentPosition.col - 1] == startChar) {
                matrix[currentPosition.row][currentPosition.col - 1] = fillChar;
                coordinates.push(new Coordinates(currentPosition.row, currentPosition.col - 1));
            }

            //get left
            if (currentPosition.col < matrix[currentPosition.row].length - 1 && matrix[currentPosition.row][currentPosition.col + 1] == startChar) {
                matrix[currentPosition.row][currentPosition.col + 1] = fillChar;
                coordinates.push(new Coordinates(currentPosition.row, currentPosition.col + 1));
            }
        }
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scan, String separator) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] arr = readArray(scan, separator);
            matrix[i] = arr;
        }
        return matrix;
    }

    private static char[] readArray(Scanner scan, String separator) {
        return scan.nextLine().replaceAll(separator, "").toCharArray();
    }

    private static void printMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (char[] row : matrix) {
            for (char chr : row) {
                sb.append(String.valueOf(chr));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static class Coordinates {
        int row;
        int col;

        public Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }}
