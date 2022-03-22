import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int circuitSize = Integer.parseInt(scan.nextLine());
        int commandCount = Integer.parseInt(scan.nextLine());

        Position playersPosition = new Position();
        char[][] circuit = readMatrix(scan, circuitSize, playersPosition);

        boolean isFinished = false;
        while (commandCount-- > 0) {
            String command = scan.nextLine();
            if(executeCommand(circuit, playersPosition, command)){
                isFinished = true;
                break;
            }
        }
        if (isFinished){
            System.out.println("Well done, the player won first place!");
        }else{
            System.out.println("Oh no, the player got lost on the track!");
        }

        Arrays.stream(circuit).forEach(System.out::println);

    }

    private static boolean executeCommand(char[][] circuit, Position playersPosition, String command) {
        boolean isFinished = false;
        Map<String, String> traps = Map.of(
                "up", "down",
                "down", "up",
                "left", "right",
                "right", "left");

        Position newPosition = calculateNewPosition(playersPosition, circuit.length, command);
        if (circuit[newPosition.row][newPosition.col] == 'B') {
            newPosition = calculateNewPosition(newPosition, circuit.length, command);
        } else if (circuit[newPosition.row][newPosition.col] == 'T') {
            newPosition = calculateNewPosition(newPosition, circuit.length, traps.get(command));
        } else if (circuit[newPosition.row][newPosition.col] =='F') {
            isFinished = true;
        }

        circuit[playersPosition.row][playersPosition.col] = '.';
        circuit[newPosition.row][newPosition.col] = 'P';
        playersPosition.copy(newPosition);

        return isFinished;
    }

    private static Position calculateNewPosition(Position playersPosition, int circuitLength, String command) {
        Position newPosition = new Position(playersPosition.row, playersPosition.col);

        switch (command) {
            case "up":
                newPosition.row = (newPosition.row > 0) ? newPosition.row - 1 : circuitLength - 1;
                break;
            case "down":
                newPosition.row = (newPosition.row < circuitLength - 1) ? newPosition.row + 1 : 0;
                break;
            case "left":
                newPosition.col = (newPosition.col > 0) ? newPosition.col - 1 : circuitLength - 1;
                break;
            case "right":
                newPosition.col = (newPosition.col < circuitLength - 1) ? newPosition.col + 1 : 0;
                break;
        }

        return newPosition;
    }


    private static char[][] readMatrix(Scanner scan, int matrixSize, Position playersPosition) {
        char[][] matrix = new char[matrixSize][];
        for (int i = 0; i < matrixSize; i++) {
            String row = scan.nextLine();
            matrix[i] = row.toCharArray();
            int col = row.indexOf("P");
            if (col > -1) {
                playersPosition.row = i;
                playersPosition.col = col;
            }
        }
        return matrix;
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
