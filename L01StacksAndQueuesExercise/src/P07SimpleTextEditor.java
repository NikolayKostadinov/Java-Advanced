import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> operationsStack = new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < n; i++) {
            String tokens[] = scan.nextLine().split("\\s+");
            switch (tokens[0]){
                case "1":
                    operationsStack.push(sb.toString());
                    sb.append(tokens[1]);
                    break;
                case "2":
                    operationsStack.push(sb.toString());
                    int count = Integer.parseInt(tokens[1]);
                    sb.delete(sb.length() - count, sb.length());
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    sb = new StringBuilder(operationsStack.pop());
                    break;
            }
        }
    }
}
