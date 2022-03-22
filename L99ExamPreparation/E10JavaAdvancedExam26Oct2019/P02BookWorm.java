package L99ExamPreparation.E10JavaAdvancedExam26Oct2019;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02BookWorm {
    private static Scanner scan = new Scanner(System.in);
    private static Position playersPosition = new Position();

    public static void main(String[] args) {
        String greeting = scan.nextLine();
        int matrixSize = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[matrixSize][matrixSize];
        readMatrix(matrix);

        String command = scan.nextLine();
        while (!"end".equals(command)) {
            greeting = executeCommand(greeting, matrix, command);
            command = scan.nextLine();
        }

        System.out.println(greeting);
        print(matrix);
    }

    private static String executeCommand(String greeting, char[][] matrix, String command) {
        Position newPosition = calculateNewPosition(command, playersPosition);
        if (isInMatrix(newPosition, matrix.length)) {
            matrix[playersPosition.row][playersPosition.col] = '-';
            char currPosition = matrix[newPosition.row][newPosition.col];
            greeting += currPosition != '-' ? currPosition : "";
            matrix[newPosition.row][newPosition.col] = 'P';
            playersPosition.copy(newPosition);
        } else {
            if (greeting.length() > 0) {
                greeting = greeting.substring(0, greeting.length() - 1);
            }
        }
        return greeting;
    }

    private static boolean isInMatrix(Position cookPosition, int size) {
        return cookPosition.row >= 0 && cookPosition.row < size
                && cookPosition.col >= 0 && cookPosition.col < size;
    }

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == 'P') {
                    playersPosition = new Position(i, j);
                }
            }
        }
    }

    private static Position calculateNewPosition(String command, Position position) {
        Position newPosition = new Position(position.row, position.col);

        switch (command) {
            case "up":
                newPosition.row = newPosition.row - 1;
                break;
            case "down":
                newPosition.row = newPosition.row + 1;
                break;
            case "left":
                newPosition.col = newPosition.col - 1;
                break;
            case "right":
                newPosition.col = newPosition.col + 1;
                break;
        }

        return newPosition;
    }

    private static void print(char[][] screen) {
        System.out.println(Arrays.stream(screen).map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static class Position {
        int row;
        int col;

        public Position() {
            this(0, 0);
        }

        public void copy(Position position) {
            this.row = position.row;
            this.col = position.col;
        }

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
