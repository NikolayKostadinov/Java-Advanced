import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCompounds = Integer.parseInt(scan.nextLine());

        TreeSet<String> dataTable = new TreeSet<>();
        for (int i = 0; i < numberOfCompounds; i++) {
            dataTable.addAll(Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList()));
        }

        System.out.println(String.join(" ", dataTable));
    }
}
