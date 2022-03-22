package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Function<String, Double> mapWitVat = (price) -> Double.parseDouble(price) * 1.2;
        Consumer<Double> printFormatted = (e)-> System.out.printf("%.2f%n", e);

        String input = scan.nextLine();
        System.out.println("Prices with VAT:");
        Arrays.stream(input.split(", "))
                .map(mapWitVat)
                .forEach(printFormatted);
    }
}
