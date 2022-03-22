import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Map<String, Double[]> averageGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String studentName = scan.nextLine();
            String[] scores = scan.nextLine().split("\\s+");
            Double[] grades = new Double[scores.length];
            for (int j = 0; j < scores.length; j++) {
                grades[j] = Double.parseDouble(scores[j]);
            }
            averageGrades.put(studentName, grades);
        }

        for (Map.Entry<String, Double[]> student : averageGrades.entrySet()) {
            double sum = 0;
            Double[] grades = student.getValue();
            for (int i = 0; i < grades.length; i++) {
                sum += grades[i];
            }
            double avgSum = sum / student.getValue().length;
            System.out.printf("%s is graduated with %s\n", student.getKey(), avgSum);
        }
    }
}
