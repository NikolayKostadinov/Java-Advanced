import java.util.*;
import java.util.stream.Collectors;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> studentsGrade = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsGrade.putIfAbsent(studentName, new ArrayList<>());
            studentsGrade.get(studentName).add(grade);
        }

        studentsGrade
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, List<Double>>comparingByKey())
                .forEach(student -> {
                    double sum = 0;
                    for (int i = 0; i < student.getValue().size(); i++) {
                        sum += student.getValue().get(i);
                    }
                    double avgSum = sum / student.getValue().size();

                    System.out.printf("%s -> %s (avg: %.2f)\n",
                            student.getKey(),
                            student.getValue()
                                    .stream()
                                    .map(x -> String.format("%.2f", x))
                                    .collect(Collectors.joining(" ")),
                            avgSum);
                });
    }
}
