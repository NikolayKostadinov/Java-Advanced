import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String equation = scan.nextLine();

        ArrayDeque<Integer> openBrackets = new ArrayDeque<>();

        for (int i = 0; i < equation.length(); i++) {
            switch (equation.charAt(i)) {
                case '(':
                    openBrackets.push(i);
                    break;
                case ')':
                    if (!openBrackets.isEmpty()) {
                        int startIndex = openBrackets.pop();
                        System.out.println(equation.substring(startIndex, i + 1));
                    }
            }
        }
    }
}
