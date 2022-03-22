package L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P02PresentDelivery {
    private static Scanner scan = new Scanner(System.in);
    private static Position santaPosition = new Position();
    private static int niceKidsCount = 0;
    private static String[] commands = new String[]{"left", "right", "up", "down"};


    public static void main(String[] args) {
        int presentsCount = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());

        char[][] neighborhood = new char[size][size];
        readMatrix(neighborhood);
        int niceKidsCountBuffer = niceKidsCount;
        int happyKids = 0;

        String command = scan.nextLine();

        while (!"Christmas morning".equals(command) && presentsCount > 0) {
            Position newPosition = calculateNewPosition(command, santaPosition);
            if (isInMatrix(newPosition, size)) {
                neighborhood[santaPosition.row][santaPosition.col] = '-';
                char currenPosition = neighborhood[newPosition.row][newPosition.col];
                if (currenPosition == 'V') {
                    presentsCount--;
                    niceKidsCount--;
                    happyKids++;
                } else if (currenPosition == 'C') {
                    for (String cmd : commands) {
                        Position nextPosition = calculateNewPosition(cmd, newPosition);
                        char currPosition = neighborhood[nextPosition.row][nextPosition.col];
                        neighborhood[nextPosition.row][nextPosition.col] = '-';
                        if (currPosition == 'V' || currPosition == 'X') {
                            presentsCount--;
                            happyKids++;
                            if (currPosition == 'V') niceKidsCount--;
                        }
                        if (presentsCount == 0) break;
                    }
                }
            }

            santaPosition.copy(newPosition);
            neighborhood[santaPosition.row][santaPosition.col] = 'S';
            if (presentsCount == 0) break;
            command = scan.nextLine();
        }

        if (presentsCount == 0 || !isInMatrix(santaPosition, size)) {
            System.out.println("Santa ran out of presents!");
        }

        print(neighborhood);

        if (niceKidsCount > 0) {
            System.out.printf("No presents for %d nice kid/s.", niceKidsCount);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", happyKids);
        }

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
                if (row[j] == 'S') {
                    santaPosition = new Position(i, j);
                } else if (row[j] == 'V') {
                    niceKidsCount++;
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
        System.out.println(
                Arrays
                        .stream(screen)
                        .map(row -> IntStream.range(0, row.length).mapToObj(i -> String.valueOf(row[i])).collect(Collectors.joining(" ")))
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
