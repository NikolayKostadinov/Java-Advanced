package L99ExamPreparation.E06JavaAdvancedRetakeExam19August2020.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        Pet pet  = this.data
                .stream()
                .filter(p->p.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);
        if (pet == null){
            return false;
        }

        return this.data.remove(pet);
    }

    public Pet getPet(String name, String owner){
        return this.data
                .stream()
                .filter(p->p.getName().equals(name)
                        &&p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public Pet getOldestPet(){
        return this.data
                .stream()
                .max(Comparator.comparingInt(Pet::getAge))
                .orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        return "The clinic has the following patients:" +
                (this.data.isEmpty() ? ""
                        : System.lineSeparator() + this.data.stream()
                        .map(p->String.format("%s %s", p.getName(), p.getOwner()))
                        .collect(Collectors.joining(System.lineSeparator())));

    }
}
