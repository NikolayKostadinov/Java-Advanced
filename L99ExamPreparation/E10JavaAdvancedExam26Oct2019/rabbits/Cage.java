package L99ExamPreparation.E10JavaAdvancedExam26Oct2019.rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        Rabbit rabbit = this.data.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
        if (rabbit != null) {
            return this.data.remove(rabbit);
        }

        return false;
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = this.data.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
        if (rabbit != null) {
            int indexOfRabbit = this.data.indexOf(rabbit);
            if (indexOfRabbit > -1) {
                rabbit.setAvailable(false);
                this.data.set(indexOfRabbit, rabbit);
            }
        }

        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> sold = new ArrayList<>();
        this.data.stream()
                .filter(r -> r.getSpecies().equals(species))
                .map(r -> r.getName())
                .forEach(n -> sold.add(this.sellRabbit(n)));
        return sold;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        return String.format("Rabbits available at %s:", this.name)
                + (this.data.isEmpty() ? ""
                : String.format("%n%s",
                this.data.stream()
                        .filter(r -> r.isAvailable())
                        .map(Rabbit::toString)
                        .collect(Collectors.joining(System.lineSeparator()))));
    }
}
