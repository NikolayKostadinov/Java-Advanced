package L99ExamPreparation.E02JavaAdvancedExam26June2021.P03groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroomingSalon {
    private int capacity;
    private final List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet pet = getPet(x -> x.getName().equals(name));
        if (pet == null) {
            return false;
        }

        data.remove(pet);
        return true;
    }

    public Pet getPet(String name, String owner){
        return this.getPet(x->x.getName().equals(name) && x.getOwner().equals(owner));
    }

    public int getCount() {
        return data.size();
    }

    private Pet getPet(Predicate<Pet> predicate) {
        return this.data
                .stream()
                .filter(predicate)
                .findFirst().orElse(null);
    }

    public String getStatistics(){
        return "The grooming salon has the following clients:" + (this.data.isEmpty()?"":
                System.lineSeparator() +
                this.data.stream().map(p-> p.getName() + " " + p.getOwner())
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
