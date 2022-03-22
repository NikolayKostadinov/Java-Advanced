package L99ExamPreparation.E05JavaAdvancedRetakeExam16December2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Selling {
    public static Position cookPosition = new Position();
    public static List<Position> pillars = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int shopSize = Integer.parseInt(scan.nextLine());
        char[][] shop = new char[shopSize][shopSize];
        readMatrix(shop);
        int collectedMoney = 0;

        while (collectedMoney < 50) {
            shop[cookPosition.row][cookPosition.col] = '-';
            String command = scan.nextLine();
            cookPosition = calculateNewPosition(command, cookPosition);
            if (isInMatrix(cookPosition, shopSize)) {
                char currentStep = shop[cookPosition.row][cookPosition.col];
                if (Character.isDigit(currentStep)) {
                    collectedMoney += Integer.parseInt(String.valueOf(currentStep));
                } else if (currentStep == 'O') {
                    shop[cookPosition.row][cookPosition.col] = '-';
                    Position nextPillarPosition = pillars.stream()
                            .filter(x -> x.row != cookPosition.row && x.col != cookPosition.col)
                            .findFirst()
                            .orElse(new Position());
                    cookPosition.copy(nextPillarPosition);
                }
                shop[cookPosition.row][cookPosition.col] = 'S';
            } else {
                break;
            }
        }

        if (collectedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the L99ExamPreparation.E05JavaAdvancedRetakeExam16December2020.bakery.");
        }

        System.out.printf("Money: %d%n", collectedMoney);
        print(shop);
    }

    private static boolean isInMatrix(Position cookPosition, int size) {
        return cookPosition.row >= 0 && cookPosition.row < size
                && cookPosition.col >= 0 && cookPosition.col < size;
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

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == 'S') {
                    cookPosition = new Position(i, j);
                } else if (row[j] == 'O') {
                    pillars.add(new Position(i, j));
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
