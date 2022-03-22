package L99ExamPreparation.E04JavaAdvancedExam20February2021;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Bomb {
    private static Scanner scan = new Scanner(System.in);
    private static Position sapperPosition = new Position();
    private static int bombsCount = 0;

    public static void main(String[] args) {
        int fieldSize = Integer.parseInt(scan.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        String[] commands = scan.nextLine().split(",");
        readMatrix(field);
        for (String command : commands) {
            field[sapperPosition.row][sapperPosition.col] = '+';
            sapperPosition = calculateNewPosition(sapperPosition, fieldSize, command);
            char currentStep = field[sapperPosition.row][sapperPosition.col];
            if (currentStep == 'B') {
                bombsCount--;
                System.out.println("You found a bomb!");
            } else if (currentStep == 'e') {
                System.out.printf("END! %s bombs left on the field%n", bombsCount);
                return;
            }
            if (bombsCount == 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
            field[sapperPosition.row][sapperPosition.col] = 's';
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                bombsCount, sapperPosition.row, sapperPosition.col);

    }

    private static Position calculateNewPosition(Position position, int fieldSize, String command) {
        Position newPosition = new Position(position.row, position.col);

        switch (command) {
            case "up":
                newPosition.row = (newPosition.row > 0) ? newPosition.row - 1 : newPosition.row;
                break;
            case "down":
                newPosition.row = (newPosition.row < fieldSize - 1) ? newPosition.row + 1 : newPosition.row;
                break;
            case "left":
                newPosition.col = (newPosition.col > 0) ? newPosition.col - 1 : newPosition.col;
                break;
            case "right":
                newPosition.col = (newPosition.col < fieldSize - 1) ? newPosition.col + 1 : newPosition.col;
                break;
        }

        return newPosition;
    }

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == 's') {
                    sapperPosition = new Position(i, j);
                } else if (row[j] == 'B') {
                    bombsCount++;
                }
            }
        }
    }

    private static void print(char[][] screen) {
        System.out.println(Arrays.stream(screen).map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        System.out.println();
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
