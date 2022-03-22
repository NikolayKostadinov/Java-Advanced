import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        String command = scan.nextLine();
        while (!"search".equals(command)) {
            String[] tokens = command.split("-");
            phonebook.putIfAbsent(tokens[0], tokens[1]);
            command = scan.nextLine();
        }

        String name = scan.nextLine();
        while (!"stop".equals(name)) {
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scan.nextLine();
        }
    }
}
