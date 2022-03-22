import java.util.Arrays;
import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(",\\s+");
        int size = Integer.parseInt(tokens[0]);

        int[][] matrix = new int[0][];
        if (tokens[1].equals("A")) {
            matrix = generateAMatrix(size);
        } else if (tokens[1].equals("B")) {
            matrix = generateBMatrix(size);
        }

        printMatrix(matrix);
    }

    private static int[][] generateBMatrix(int size) {
        int number = 1;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < size; j++) {
                    matrix[j][i] = number++;
                }
            } else {
                for (int j = 0; j < size; j++) {
                    matrix[matrix.length - 1 -j][i] = number++;
                }
            }
        }
        return matrix;
    }

    private static int[][] generateAMatrix(int size) {
        int number = 1;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[j][i] = number++;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%d ", cell)));
            System.out.println(sb);
        });
    }
}
