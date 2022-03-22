import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(42);
        stack.push(33);
        stack.push(28);
        stack.push(13);

        stack.forEach(System.out::println);

        SmartArray<Integer> numbers = new SmartArray<>();

        IntStream.range(0,10)
                .forEach(i->numbers.add(i));

        numbers.forEach(System.out::println);

        System.out.println(numbers.contains(5));
    }
}
