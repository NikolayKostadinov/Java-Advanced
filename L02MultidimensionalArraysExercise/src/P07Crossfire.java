import java.util.*;
//todo: solve this again
public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = readArray(scan, "\\s+");
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = createMatrix(rows, cols);

        String command = scan.nextLine();
        while (!"Nuke it from orbit".equals(command)) {
            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];
            nukeTheMatrix(row, col, radius, matrix);
            command = scan.nextLine();
        }

        printMatrix(matrix);
    }

    private static void nukeTheMatrix(int row, int col, int radius, List<List<Integer>> matrix) {
        for (int i = row - radius; i <= row + radius; i++) {
            if (isInBoundary(i, col, matrix) && i != row){
                matrix.get(i).remove(col);
            }
        }

        for (int i = col + radius; i >= col - radius; i--) {
            if (isInBoundary(row, i, matrix)){
                matrix.get(row).remove(i);
            }
        }

        matrix.removeIf(List::isEmpty);
    }

    private static boolean isInBoundary(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && col >= 0
                && row < matrix.size() && col < matrix.get(row).size();
    }

    private static List<List<Integer>> createMatrix(int rows, int cols) {
        int number = 1;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(Integer.valueOf(number++));
            }

            matrix.add(row);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scan, String separator) {
        return Arrays.stream(scan.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.forEach(row -> {
            StringBuilder sb = new StringBuilder();
            row.forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }
}
