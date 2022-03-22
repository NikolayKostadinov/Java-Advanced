package L99ExamPreparation.E03JavaAdvancedRetakeExam14April2021.P03university;

public class Student {
    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s", this.firstName, this.lastName, this.bestSubject);
    }

    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
        return this.firstName == other.firstName
                && this.lastName == other.lastName
                && this.bestSubject == other.bestSubject;
    }
}
