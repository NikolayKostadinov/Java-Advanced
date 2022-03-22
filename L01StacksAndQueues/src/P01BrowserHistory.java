import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String command = scan.nextLine();

        while (!"Home".equals(command)){
            if ("back".equals(command)){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(command);
            }

            if (!stack.isEmpty()){
                System.out.println(stack.peek());
            } else {
                System.out.println("no previous URLs");
            }
            command = scan.nextLine();
        }
    }
}
