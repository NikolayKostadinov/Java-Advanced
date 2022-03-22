package P11Threeuple;

public class Person {
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
