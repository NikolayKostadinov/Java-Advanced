package L99ExamPreparation.E08JavaAdvancedExam22Feb2020;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ReVolt {
    private static Scanner scan = new Scanner(System.in);
    private static Position playerPosition = new Position();
    private static Map<String, String> backwardsCommand =
            Map.of("up", "down",
                    "down", "up",
                    "left", "right",
                    "right", "left");

    public static void main(String[] args) {
        int matrixSize = Integer.parseInt(scan.nextLine());
        int count = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[matrixSize][matrixSize];
        readMatrix(matrix);
        boolean isFinish = false;
        while (count-- > 0) {
            String command = scan.nextLine();
            isFinish = executeCommand(matrix, command,true);
            if (isFinish) break;
        }

        if (isFinish) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        print(matrix);
    }


    private static boolean isInMatrix(Position position, int size) {
        return position.row >= 0 && position.row < size
                && position.col >= 0 && position.col < size;
    }

    private static boolean executeCommand(char[][] matrix, String command, boolean clearField) {
        if (clearField) matrix[playerPosition.row][playerPosition.col] = '-';
        Position newPosition = calculateNewPosition(command, playerPosition, matrix.length);
        char currentField = matrix[newPosition.row][newPosition.col];
        boolean isFinished = false;
        if (currentField == 'F') {
            isFinished = true;
        } else if (currentField == 'B') {
            playerPosition.copy(newPosition);
            return executeCommand(matrix, command, false);
        } else if (currentField == 'T') {
            playerPosition.copy(newPosition);
            return executeCommand(matrix, backwardsCommand.get(command), false);
        }
        matrix[newPosition.row][newPosition.col] = 'f';
        playerPosition.copy(newPosition);
        return isFinished;
    }

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == 'f') {
                    playerPosition = new Position(i, j);
                }
            }
        }
    }

    private static Position calculateNewPosition(String command, Position snakePosition, int screenSize) {
        Position newPosition = new Position(snakePosition.row, snakePosition.col);

        switch (command) {
            case "up":
                newPosition.row = (newPosition.row > 0) ? newPosition.row - 1 : screenSize - 1;
                break;
            case "down":
                newPosition.row = (newPosition.row < screenSize - 1) ? newPosition.row + 1 : 0;
                break;
            case "left":
                newPosition.col = (newPosition.col > 0) ? newPosition.col - 1 : screenSize - 1;
                break;
            case "right":
                newPosition.col = (newPosition.col < screenSize - 1) ? newPosition.col + 1 : 0;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
