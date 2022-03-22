import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ix = 1;

        Map<String, String> emails = new LinkedHashMap<>();
        String resourceName = scan.nextLine();
        while (!"stop".equals(resourceName)) {
            if (ix % 2 == 0) {
                resourceName = scan.nextLine();
            } else {
                String email = scan.nextLine();
                if (!(email.endsWith("us")
                        || email.endsWith("uk")
                        || email.endsWith("com")))
                    emails.putIfAbsent(resourceName, email);
            }
            ix++;
        }

        emails.entrySet()
                .stream()
                .forEach(resource -> System.out.printf("%s -> %s%n", resource.getKey(), resource.getValue()));
    }
}
