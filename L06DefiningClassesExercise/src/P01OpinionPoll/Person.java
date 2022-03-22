package P01OpinionPoll;

public class Person {
    private String name;
    private int age;

    public Person(String input) {
        String[] tokens = input.split("\\s+");
        this.name = tokens[0];
        this.age = Integer.parseInt(tokens[1]);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }
}
