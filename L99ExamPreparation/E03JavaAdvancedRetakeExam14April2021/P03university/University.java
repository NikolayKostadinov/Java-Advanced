package L99ExamPreparation.E03JavaAdvancedRetakeExam14April2021.P03university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String message;
        if (this.students.indexOf(student) > -1) {
            message = "Student is already in the university";
        } else if (this.capacity == this.students.size()) {
            message = "No seats in the university";
        } else {
            this.students.add(student);
            message = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }

        return message;
    }

    public String dismissStudent(Student student) {
        int indexOfStudent = this.students.indexOf(student);
        if (indexOfStudent > -1) {
            this.students.remove(indexOfStudent);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream()
                .filter(st -> st.getFirstName().equals(firstName)
                        && st.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        return (students.isEmpty()) ? ""
                : students.stream()
                .map(University::forStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String forStatistics(Student student) {
        return
                String.format(
                        "==Student: First Name = %s, Last Name = %s, Best Subject = %s"
                        , student.getFirstName(), student.getLastName(), student.getBestSubject());
    }
}
