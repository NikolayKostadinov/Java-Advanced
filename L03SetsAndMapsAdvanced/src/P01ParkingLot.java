import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String command = scan.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split(",\\s+");

            if ("IN".equals(tokens[0])) {
                parkingLot.add(tokens[1]);
            } else {
                parkingLot.remove(tokens[1]);
            }

            command = scan.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(pl -> System.out.println(pl));
        }
    }
}
