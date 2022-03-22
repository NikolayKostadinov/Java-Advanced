import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayDeque <String> stackURLs = new ArrayDeque<>();
        ArrayDeque <String> forwardsQueue = new ArrayDeque<>();

        while (!command.equals("Home")){
            switch (command){
                case "back":
                    if (stackURLs.size() < 2){
                        System.out.println("no previous URLs");
                    }
                    else {
                        String currentURL = stackURLs.pop();
                        forwardsQueue.push(currentURL);
                        System.out.println(stackURLs.peek());
                    }
                    break;
                case "forward":
                    if (forwardsQueue.isEmpty()){
                        System.out.println("no next URLs");
                    }
                    else {
                        String currentForward = forwardsQueue.pop();
                        System.out.println(currentForward);
                        stackURLs.push(currentForward);
                    }
                    break;
                default:
                    stackURLs.push(command);
                    System.out.println(command);
                    forwardsQueue.clear();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
