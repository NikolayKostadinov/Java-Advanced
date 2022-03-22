package L99ExamPreparation.E07JavaAdvancedExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class P02Snake {
    private static Scanner scan = new Scanner(System.in);
    private static Position snakePosition = new Position();
    private static List<Position> burrows = new ArrayList<>();
    private static int foodCount = 0;

    public static void main(String[] args) {
        int size = Integer.parseInt(scan.nextLine());
        char[][] territory = new char[size][size];
        readMatrix(territory);

        String command = scan.nextLine();
        boolean isOutside = false;
        while (!"End".equals(command)) {
            isOutside = executeCommand(territory, command);
            if (isOutside || foodCount >= 10) break;
            command = scan.nextLine();
        }

        if (isOutside) System.out.println("Game over!");

        if (foodCount >= 10) System.out.println("You won! You fed the snake.");

        System.out.printf("Food eaten: %d%n", foodCount);

        print(territory);
    }

    private static boolean isInMatrix(Position cookPosition, int size) {
        return cookPosition.row >= 0 && cookPosition.row < size
                && cookPosition.col >= 0 && cookPosition.col < size;
    }

    private static boolean executeCommand(char[][] matrix, String command) {
        matrix[snakePosition.row][snakePosition.col] = '.';
        Position newPosition = calculateNewPosition(command, snakePosition);
        boolean isInTerritory = isInMatrix(newPosition, matrix.length);
        if (isInTerritory) {
            char currentField = matrix[newPosition.row][newPosition.col];
            if (currentField == '*') {
                foodCount++;
            } else if (currentField == 'B') {
                matrix[newPosition.row][newPosition.col] = '.';
                burrows.remove(newPosition);
                newPosition = burrows.get(0);
            }
            matrix[newPosition.row][newPosition.col] = 'S';
            snakePosition.copy(newPosition);
        }
        return !isInTerritory;
    }

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == 'S') {
                    snakePosition = new Position(i, j);
                } else if (row[j] == 'B') {
                    burrows.add(new Position(i, j));
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
