import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class P00Demo1 {
    public static void main(String[] args) {
        TreeSet<Integer> numbersInTreeSet = new TreeSet<>(List.of(42,13,73,69));
        HashSet<Integer> numbersInHashSet = new HashSet<>(List.of(42,13,73,69));

        for (Integer integer : numbersInTreeSet) {
            System.out.println(integer);
        }
        for (Integer integer : numbersInHashSet) {
            System.out.println(integer);
        }
    }
}
