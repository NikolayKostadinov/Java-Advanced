package P07EqualityLogic;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private Comparator<Person> comparator;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.comparator = new PersonComparatorByNameThenByAge();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }

    @Override
    public int compareTo(Person other) {
        return this.comparator.compare(this, other);
    }

    @Override
    public boolean equals(Object o) {
       return this.comparator.compare(this, (Person) o) == 0;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age;
    }
}
