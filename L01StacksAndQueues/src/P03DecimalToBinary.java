import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> binary = new ArrayDeque<>();

        while (number != 0) {
            binary.push(number % 2);
            number /= 2;
        }

        while (!binary.isEmpty()){
            System.out.print(binary.pop());
        }
        System.out.println();
    }
}
