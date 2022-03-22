package L100FinalExam;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Problem2 {
    private static Scanner scan = new Scanner(System.in);
    private static Position playersPosition = new Position();

    public static void main(String[] args) {

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
