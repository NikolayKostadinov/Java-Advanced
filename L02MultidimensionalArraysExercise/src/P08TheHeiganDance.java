import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int playerLife = 18500;
        double heiganLife = 3000000;

        Position playerPosition = new Position(7, 7);

        String spell = "";
        boolean heatedPrevTime = false;

        double heiganDamage = Double.parseDouble(scan.nextLine());

        while (playerLife > 0 && heiganLife > 0) {
            heiganLife -= heiganDamage;

            if (heatedPrevTime) {
                playerLife -= 3500;
                heatedPrevTime = false;
            }

            if (playerLife < 0 || heiganLife < 0) break;

            String[] tokens = scan.nextLine().split("\\s");

            spell = tokens[0];
            int hitRow = Integer.parseInt(tokens[1]);
            int hitCol = Integer.parseInt(tokens[2]);

            boolean[][] playGround = new boolean[15][15];

            drawDamageZone(hitRow, hitCol, playGround);

            if (playerIsHit(playerPosition, playGround)) {
                playerLife -= calculateDamage(spell);
                heatedPrevTime = spell.equals("Cloud");
            }
        }

        if (heiganLife <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganLife);
        }

        if (playerLife <= 0) {
            if (spell.equals("Cloud")) spell = "Plague Cloud";
            System.out.printf("Player: Killed by %s\n", spell);
        } else {
            System.out.printf("Player: %d\n", playerLife);
        }

        System.out.printf("Final position: %s\n", playerPosition);
    }

    private static boolean playerIsHit(Position playerPosition, boolean[][] playGround) {

        boolean isHit = false;
        if (playGround[playerPosition.row][playerPosition.col]) {
            if (isInBoard(playerPosition.row - 1, playerPosition.col, playGround)               //up
                    && !playGround[playerPosition.row - 1][playerPosition.col]) {
                playerPosition.row -= 1;
            } else if (isInBoard(playerPosition.row, playerPosition.col + 1, playGround)        //right
                    && !playGround[playerPosition.row][playerPosition.col + 1]) {
                playerPosition.col += 1;
            } else if (isInBoard(playerPosition.row + 1, playerPosition.col, playGround)       //down
                    && !playGround[playerPosition.row + 1][playerPosition.col]) {
                playerPosition.row += 1;
            } else if (isInBoard(playerPosition.row, playerPosition.col - 1, playGround)        //left
                    && !playGround[playerPosition.row][playerPosition.col - 1]) {
                playerPosition.col -= 1;
            } else {
                isHit = true;                                                                       //there is no escape
            }
        }

        return isHit;
    }

    private static boolean isInBoard(int row, int col, boolean[][] playGround) {
        return row >= 0 && col >= 0
                && row < playGround.length && col < playGround[row].length;
    }

    private static int calculateDamage(String spell) {
        switch (spell) {
            case "Cloud":
                return 3500;
            case "Eruption":
                return 6000;
            default:
                return 0;
        }
    }

    private static void drawDamageZone(int hitRow, int hitCol, boolean[][] playGround) {
        for (int i = hitRow - 1; i <= hitRow + 1; i++) {
            for (int j = hitCol - 1; j <= hitCol + 1; j++) {
                if (isInBoard(i, j, playGround))
                    playGround[i][j] = true;
            }
        }
    }

    private static class Position {
        int row = 0;
        int col = 0;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("%s, %s", row, col);
        }
    }
}
