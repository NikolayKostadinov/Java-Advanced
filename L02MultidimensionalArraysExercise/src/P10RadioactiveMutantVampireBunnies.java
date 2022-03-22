import java.util.Arrays;
import java.util.Scanner;

public class P10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] lairDimensions = readArray(scan, "\\s+");

        char[][] lair = new char[lairDimensions[0]][lairDimensions[1]];
        Position playerPosition = initializeLair(lair, scan);

        String commands = scan.nextLine();
        for (char command : commands.toCharArray()) {
            Position lastPosition = new Position(playerPosition.row, playerPosition.col);
            playerPosition = executeMovement(command, playerPosition, lair);

            lair[lastPosition.row][lastPosition.col] = '.';

            if (isInBoundaries(playerPosition.row, playerPosition.col, lair)
                    && lair[playerPosition.row][playerPosition.col] != 'B') {
                lair[playerPosition.row][playerPosition.col] = 'P';
            }

            lair = multiplyBunnies(lair);

            if (!isInBoundaries(playerPosition.row, playerPosition.col, lair)) {
                printMatrix(lair);
                System.out.printf("won: %d %d", lastPosition.row, lastPosition.col);
                break;
            } else if (lair[playerPosition.row][playerPosition.col] == 'B') {
                printMatrix(lair);
                System.out.printf("dead: %d %d", playerPosition.row, playerPosition.col);
                break;
            }
        }
    }

    private static char[][] multiplyBunnies(char[][] lair) {
        char[][] nextLair = new char[lair.length][lair[0].length];
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[0].length; j++) {
                if (lair[i][j] == 'B') {
                    nextLair[i][j] = lair[i][j];
                    if (isInBoundaries(i - 1, j, lair)) {
                        nextLair[i - 1][j] = 'B';
                    }
                    if (isInBoundaries(i + 1, j, lair)) {
                        nextLair[i + 1][j] = 'B';
                    }
                    if (isInBoundaries(i, j - 1, lair)) {
                        nextLair[i][j - 1] = 'B';
                    }
                    if (isInBoundaries(i, j + 1, lair)) {
                        nextLair[i][j + 1] = 'B';
                    }
                } else if (nextLair[i][j] != 'B') {
                    nextLair[i][j] = lair[i][j];
                }
            }
        }
        return nextLair;
    }

    private static Position executeMovement(char command, Position playerPosition, char[][] lair) {
        int rowCorrection = 0;
        int colCorrection = 0;
        switch (command) {
            case 'U':
                rowCorrection = -1;
                break;
            case 'D':
                rowCorrection = 1;
                break;
            case 'L':
                colCorrection = -1;
                break;
            case 'R':
                colCorrection = 1;
                break;
        }

        return new Position(playerPosition.row + rowCorrection, playerPosition.col + colCorrection);
    }


    private static Position initializeLair(char[][] lair, Scanner scan) {
        Position playerPosition = new Position(0, 0);
        for (int i = 0; i < lair.length; i++) {
            String row = scan.nextLine();
            lair[i] = row.toCharArray();
            int playerCol = row.indexOf('P');
            if (playerCol > -1) {
                playerPosition.row = i;
                playerPosition.col = playerCol;
            }
        }

        return playerPosition;
    }

    private static void printMatrix(char[][] lair) {
        for (char[] row : lair) {
            System.out.println(row);
        }
    }

    private static int[] readArray(Scanner scan, String separator) {
        return Arrays.stream(scan.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isInBoundaries(int row, int col, char[][] matrix) {
        return row >= 0 && col >= 0
                && row < matrix.length && col < matrix[row].length;
    }

    private static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
