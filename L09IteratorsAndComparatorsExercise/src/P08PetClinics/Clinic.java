package P08PetClinics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private String name;
    private final List<Pet> pets;
    private final ClinicAddIterator iterator;

    public Clinic(String name, int rooms) {
        if (rooms % 2 == 0) throw new IllegalStateException("Invalid Operation!");
        this.name = name;
        this.pets = Arrays.asList(new Pet[rooms]);
        iterator = new ClinicAddIterator(pets);
    }

    public boolean add(Pet pet) {
        if (this.iterator.hasNext()) {
            this.iterator.add(pet);
            return true;
        }
        return false;
    }

    public boolean release() {
        if (!this.pets.stream().allMatch(x -> x == null)) {
            this.iterator.remove();
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public boolean hasEmptyRooms() {
        return iterator.hasNext();
    }

    public Pet getRoom(int roomNumber) {
        return this.pets.get(roomNumber - 1);
    }

    @Override
    public String toString() {
        return this.pets
                .stream()
                .map(x->x == null ? "Room empty": x.toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
