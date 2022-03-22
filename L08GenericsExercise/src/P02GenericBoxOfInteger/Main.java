package P02GenericBoxOfInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = Integer.parseInt(scan.nextLine());
        IntStream.range(0,counter)
                .forEach(x->{
                    Integer input = Integer.parseInt(scan.nextLine());
                    System.out.println(new Box<>(input));
                });
    }
}
