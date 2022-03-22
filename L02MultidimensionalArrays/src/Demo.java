import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        scan.nextLine();
        int[][]matrix = new int[row][];

        for (int i = 0; i < row; i++) {
            matrix[i] = extracted(scan.nextLine());
        }

        printArray(matrix);
    }

    private static void printArray(int[][] arr) {
        for (int[] rows : arr) {
            for (int cell : rows) {
                System.out.printf("%d ", cell);
            }
            System.out.println();
        }
    }

    private static int[] extracted(String arrayLine) {
         return Arrays.stream(arrayLine.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
