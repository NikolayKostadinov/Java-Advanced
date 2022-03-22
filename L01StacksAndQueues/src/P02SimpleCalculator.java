import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> equation =
                new ArrayDeque<>(Arrays.asList(scan.nextLine().split("\\s+")));
        int sum = (!equation.isEmpty()) ? 0 : Integer.parseInt(equation.pop());

        while (equation.size() > 1) {
            int operand1 = Integer.parseInt(equation.pop());
            String operation = equation.pop();
            int operand2 = Integer.parseInt(equation.pop());

            int result = ("+".equals(operation)) ? (operand1 + operand2) : (operand1 - operand2);

            equation.push(String.valueOf(result));
        }
        System.out.println(equation.pop());
    }
}
