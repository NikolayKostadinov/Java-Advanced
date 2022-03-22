package P02GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = ArrayCreator.<String>create(10, "Default string");
        Arrays.stream(stringArray).forEach(System.out::println);
    }
}
