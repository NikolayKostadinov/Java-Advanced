import java.util.HashSet;
import java.util.List;

public class P00Demo {
    public static void main(String[] args) {
        HashSet<String> elements =
                new HashSet<>(
                        List.of("AaAa", "BBBB", "AaBB", "BBAa"));

        for (String element : elements) {
            System.out.println(element.hashCode());
        }


    }
}
