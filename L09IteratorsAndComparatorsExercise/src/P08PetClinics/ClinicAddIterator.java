package P08PetClinics;

import java.util.Iterator;
import java.util.List;

public class ClinicAddIterator implements Iterator<Pet> {
    private List<Pet> rooms;
    private int center;

    public ClinicAddIterator(List<Pet> rooms) {
        this.rooms = rooms;
        this.center = rooms.size() / 2;

    }

    private int getNextFreeIndex() {
        if (rooms.get(center) == null) {
            return center;
        } else {
            for (int i = 1; i <= rooms.size() / 2; i++) {
                if (rooms.get(center - i) == null) {
                    return center - i;
                } else if (rooms.get(center + i) == null) {
                    return center + i;
                }
            }
        }

        return rooms.size();
    }

    @Override
    public boolean hasNext() {
        return this.rooms.stream().anyMatch(r -> r == null);
    }

    @Override
    public Pet next() {
        return null;
    }

    public void add(Pet pet) {
        this.rooms.set(getNextFreeIndex(), pet);
    }

    @Override
    public void remove() {
        for (int i = center; i < this.rooms.size(); i++) {
            if (this.rooms.get(i) != null) {
                this.rooms.set(i, null);
                return;
            }
        }

        for (int i = 0; i < center; i++) {
            if (this.rooms.get(i) != null) {
                this.rooms.set(i, null);
                return;
            }
        }
    }
}
