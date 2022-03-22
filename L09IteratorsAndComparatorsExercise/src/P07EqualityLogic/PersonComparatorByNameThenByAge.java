package P07EqualityLogic;

import java.util.Comparator;

public class PersonComparatorByNameThenByAge implements Comparator<Person> {


    @Override
    public int compare(Person left, Person right) {
        int result = left.getName().compareTo(right.getName());
        if (result == 0){
            result = Integer.compare(left.getAge(), right.getAge());
        }
        return result;
    }
}
