package P04Froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lake lake = new Lake(
                Arrays.stream(scan.nextLine().split(",\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
        scan.nextLine();
        StringBuilder sb = new StringBuilder();
        for (Integer step : lake) {
            sb.append(step);
            if (lake.iterator().hasNext()){
                sb.append(", ");
            }
        }

        System.out.println(sb);
    }
}
