//todo: extract method
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> vipReservation = new TreeSet<>();
        Set<String> reservation = new TreeSet<>();

        String command = scan.nextLine();

        while (!"PARTY".equals(command)) {
            if (Character.isDigit(command.charAt(0))) {
                vipReservation.add(command);
            } else {
                reservation.add(command);
            }

            command = scan.nextLine();
        }

        command = scan.nextLine();
        while (!"END".equals(command)) {
            if (Character.isDigit(command.charAt(0))) {
                vipReservation.remove(command);
            } else {
                reservation.remove(command);
            }

            command = scan.nextLine();
        }

        System.out.println(vipReservation.size() + reservation.size());

        printSetIfNotEmpty(vipReservation);
        printSetIfNotEmpty(reservation);
    }

    public static void printSetIfNotEmpty(Set<String> set) {
        if (!set.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }
}
