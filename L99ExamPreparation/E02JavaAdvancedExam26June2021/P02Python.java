package L99ExamPreparation.E02JavaAdvancedExam26June2021;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Python {
    private static int foodQuantity = 0;
    private static int pythonLength = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int screenSize = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",\\s+");
        Position snakePosition = new Position();
        char[][] screen = new char[screenSize][screenSize];
        foodQuantity = readScreen(scan, screen, snakePosition);

        for (String command : commands) {
            if (executeCommand(snakePosition, screen, command)) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (foodQuantity == 0) {
                System.out.printf("You win! Final python length is %d%n", pythonLength);
                return;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", foodQuantity);
    }

    private static void print(char[][] screen) {
        System.out.println(Arrays.stream(screen).map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        System.out.println();
    }

    private static boolean executeCommand(Position snakePosition, char[][] screen, String command) {

        Position newSnakePosition = calculateNewPosition(snakePosition, screen.length, command);
        char currentStep = screen[newSnakePosition.row][newSnakePosition.col];
        if (currentStep == 'e') {
            return true;
        } else {
            screen[snakePosition.row][snakePosition.col] = '*';
            screen[newSnakePosition.row][newSnakePosition.col] = 's';
            snakePosition.copy(newSnakePosition);
            if (currentStep == 'f') {
                foodQuantity--;
                pythonLength++;
            }
        }

        return false;
    }

    private static int readScreen(Scanner scan, char[][] screen, Position snakePosition) {
        int foodQuantity = 0;
        for (int i = 0; i < screen.length; i++) {
            char[] row = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < screen.length; j++) {
                screen[i][j] = row[j];
                if (row[j] == 's') {
                    snakePosition.row = i;
                    snakePosition.col = j;
                } else if (row[j] == 'f') {
                    foodQuantity++;
                }
            }
        }

        return foodQuantity;
    }

    private static Position calculateNewPosition(Position snakePosition, int screenSize, String command) {
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
