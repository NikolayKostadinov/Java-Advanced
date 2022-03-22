package L99ExamPreparation.E06JavaAdvancedRetakeExam19August2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Bee {
    private static final int NEEDED_FLOWERS = 5;
    private static Scanner scan = new Scanner(System.in);
    private static Position beePosition = new Position();
    private static int flowersCount = 0;

    public static void main(String[] args) {
        int size = Integer.parseInt(scan.nextLine());
        char[][] territory = new char[size][size];
        readMatrix(territory);
        String command = scan.nextLine();
        boolean isOutside = false;
        while (!"End".equals(command)) {
            isOutside = executeCommand(territory, command);
            if (isOutside) break;
            command = scan.nextLine();
        }
        if (isOutside) {
            System.out.println("The bee got lost!");
        }

        if (flowersCount < NEEDED_FLOWERS) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n"
                    , NEEDED_FLOWERS - flowersCount);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowersCount);
        }

        print(territory);
    }

    private static boolean executeCommand(char[][] territory, String command) {
        territory[beePosition.row][beePosition.col] = '.';
        Position newPosition = calculateNewPosition(command, beePosition);
        boolean isInTerritory = isInMatrix(newPosition, territory.length);
        if (isInTerritory) {
            char currentField = territory[newPosition.row][newPosition.col];
            if (currentField == 'f') {
                flowersCount++;
            } else if (currentField == 'O') {
                beePosition.copy(newPosition);
                return executeCommand(territory, command);
            }
            territory[newPosition.row][newPosition.col] = 'B';
            beePosition.copy(newPosition);
        }
        return !isInTerritory;
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
                if (row[j] == 'B') {
                    beePosition = new Position(i, j);
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
