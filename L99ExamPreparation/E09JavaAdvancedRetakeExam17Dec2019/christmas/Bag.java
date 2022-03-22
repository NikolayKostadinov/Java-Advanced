package L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        Present present = getPresent(name);
        if (present != null) {
            return this.data.remove(present);
        }
        return false;
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .max(Comparator.comparingDouble(Present::getWeight))
                .orElse(null);
    }

    public Present getPresent(String name) {
        return this.data
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        return String.format("%s bag contains:%s",
                this.color,
                this.data.isEmpty() ? ""
                        : String.format("%n%s",
                        this.data
                                .stream()
                                .map(Present::toString)
                                .collect(Collectors.joining(System.lineSeparator())))).trim();
    }

    private String toSentenceCase(String string) {
        return string.substring(0, 1).toUpperCase(Locale.ROOT) + string.substring(1, this.color.length());
    }
}
