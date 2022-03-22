import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Set<String> names = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            names.add(scan.nextLine());
        }

        names.forEach(name-> System.out.println(name));
    }
}
