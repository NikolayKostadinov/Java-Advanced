package P06GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> list = new ArrayList<>();

        int counter = Integer.parseInt(scan.nextLine());
        while (counter-->0){
            list.add(Double.parseDouble(scan.nextLine()));
        }

        Double target = Double.parseDouble(scan.nextLine());
        System.out.println(getGreaterElements(list, target).size());
    }

    public static <T extends Comparable<T>> List<T> getGreaterElements(List<T> list, T targetValue){
        return list.stream().filter(x->x.compareTo(targetValue) > 0).collect(Collectors.toList());
    }
}
