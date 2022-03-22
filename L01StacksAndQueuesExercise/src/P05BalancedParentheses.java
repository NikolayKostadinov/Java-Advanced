import java.util.*;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String parenthesis = scan.nextLine();
        if (isBalanced(parenthesis)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String parenthesis) {
        Map<String, String> oppositeBracket =
                new HashMap<String, String>() {{
                    put(")", "(");
                    put("}", "{");
                    put("]", "[");
                }};
        ArrayDeque<String> parenthesisQueue = new ArrayDeque<>();
        for (int i = 0; i < parenthesis.length(); i++) {
            String bracket = parenthesis.substring(i, i + 1);
            if ("({[".contains(bracket)) {
                parenthesisQueue.push(bracket);
            } else {
                String openBracket = oppositeBracket.get(bracket);
                if (openBracket.equals(parenthesisQueue.peek())) {
                    parenthesisQueue.pop();
                } else {
                    return false;
                }
            }
        }

        return parenthesisQueue.isEmpty();
    }
}
