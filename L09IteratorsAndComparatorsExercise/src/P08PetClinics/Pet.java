package P08PetClinics;

import java.util.Objects;

public class Pet {
    private String name;
    private int age;
    private String king;

    public Pet(String name, int age, String king) {
        this.name = name;
        this.age = age;
        this.king = king;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.king);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(name, pet.name) && Objects.equals(king, pet.king);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, king);
    }
}
