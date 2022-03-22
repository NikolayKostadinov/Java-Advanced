import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String rotation = scan.nextLine();
        int degrees = getDegrees(rotation);

        String command = scan.nextLine();
        while (!"END".equals(command)) {
            input.add(command);
            command = scan.nextLine();
        }

        char[][] matrix = toCharArray(input);

        for (int i = 0; i < degrees / 90; i++) {
            matrix = rotateMatrix90(matrix);
        }

        printMatrix(matrix);
    }

    private static int getDegrees(String rotation) {
        String regex = "Rotate\\((?<degree>\\d+)\\)";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(rotation);
        matcher.find();
        int degree = Integer.parseInt(matcher.group("degree"));
        return degree;
    }

    private static char[][] rotateMatrix90(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] rotatedMatrix = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedMatrix[j][rows-1-i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    private static char[][] toCharArray(List<String> input) {
        int maxStringLength = input.stream().max((a1, a2) -> a1.length() - a2.length()).orElse("").length();
        char[][] matrix = new char[input.size()][maxStringLength];
        for (int i = 0; i < input.size(); i++) {
            String word =  input.get(i);
            for (int j = 0; j < maxStringLength; j++) {
               matrix[i][j] = (word.length() > j) ? word.charAt(j) : ' ';
            }
        }
        return matrix;
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

    private static char[] readArray(Scanner scan, String separator) {
        return scan.nextLine().replaceAll(separator, "").toCharArray();
    }
}
