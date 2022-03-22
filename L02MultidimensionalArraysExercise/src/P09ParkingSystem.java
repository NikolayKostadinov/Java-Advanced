import java.util.Arrays;
import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] parkingDimensions = readArray(scan, "\\s+");
        boolean[][] parking = new boolean[parkingDimensions[0]][parkingDimensions[1]];

        String command = scan.nextLine();

        while (!"stop".equals(command)) {
            int[] parameters = readArray(command, "\\s+");
            ParkingSlot parkingSlot = new ParkingSlot(parameters[1], parameters[2]);

            if (isParkingSlotAvailable(parkingSlot, parking)) {
                System.out.println(calculateDistance(parameters[0], parkingSlot, parking));
                parking[parkingSlot.row][parkingSlot.col] = true;
            } else {
                System.out.printf("Row %d full%n", parkingSlot.row);
            }

            command = scan.nextLine();
        }

    }

    private static int calculateDistance(int inRow, ParkingSlot parkingSlot, boolean[][] parking) {
        int steps = 1;
        steps += Math.abs( inRow - parkingSlot.row);
        steps += parkingSlot.col;
        return steps;
    }

    private static boolean isParkingSlotAvailable(ParkingSlot parkingSlot, boolean[][] parking) {
        boolean isAvailable = true;
        int currentCol = parkingSlot.col;
        if (parking[parkingSlot.row][parkingSlot.col]) {
            isAvailable = false;

            int maxOffset = Math.max(currentCol, parking[0].length - currentCol);
            for (int offset = 1; offset <= maxOffset; offset++) {
                if (isInParking(currentCol - offset, parking)
                        && !parking[parkingSlot.row][currentCol - offset]){
                    parkingSlot.col = currentCol - offset;
                    isAvailable = true;
                    break;
                } else if (isInParking(currentCol + offset, parking)
                        && !parking[parkingSlot.row][currentCol + offset]){
                    parkingSlot.col = currentCol + offset;
                    isAvailable = true;
                    break;
                }
            }
        }
        return isAvailable;
    }

    private static boolean isInParking(int col, boolean[][] parking) {
        return col > 0 && col < parking[0].length;
    }


    private static int[] readArray(Scanner scan, String separator) {
        return Arrays.stream(scan.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[] readArray(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static <T> void printMatrix(T[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }

    private static class ParkingSlot {
        int row;
        int col;

        public ParkingSlot() {
            row = 0;
            col = 0;
        }

        public ParkingSlot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
