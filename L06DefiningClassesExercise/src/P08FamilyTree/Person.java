package P08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDay;
    private final List<Person> parents;
    private final List<Person> children;

    public Person(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParent(Person parent){
        this.parents.add(parent);
    }

    public void addChild(Person child){
        this.children.add(child);
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + " " + birthDay;
    }
}
