import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] plants = Arrays.stream(
                        scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] plantsDieDay = new int[n];
        ArrayDeque<Integer> previousPlantStack = new ArrayDeque<>();
        previousPlantStack.push(0);
        for (int i = 1; i < n; i++) {
            int lastDay = 0;

            while (!previousPlantStack.isEmpty() && plants[previousPlantStack.peek()] >= plants[i]) {
                lastDay = Math.max(lastDay, plantsDieDay[previousPlantStack.pop()]);
            }

            if (!previousPlantStack.isEmpty()) {
                plantsDieDay[i] = lastDay + 1;
            }

            previousPlantStack.push(i);
        }

        System.out.println(Arrays.stream(plantsDieDay).max().orElse(0));
    }
}
