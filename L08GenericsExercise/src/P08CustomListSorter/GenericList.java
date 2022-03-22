package P08CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T extends Comparable<T>> {
    private List<T> elemens;

    public GenericList() {
        this.elemens = new ArrayList<>();
    }

    public void add(T element) {
        this.elemens.add(element);
    }

    public T remove(int index) {
        return this.elemens.remove(index);
    }

    public boolean contains(T element) {
        return this.elemens.contains(element);
    }

    public void swap(int srcIndex, int dstIndex) {
        T element = this.elemens.get(srcIndex);
        this.elemens.set(srcIndex, this.elemens.get(dstIndex));
        this.elemens.set(dstIndex, element);
    }

    public int countGreaterThan(T element) {
        return (int) this.elemens
                .stream()
                .filter(o -> o.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return this.elemens.stream().max(T::compareTo).orElse(null);
    }

    public T getMin() {
        return this.elemens.stream().min(T::compareTo).orElse(null);
    }

    public List<T> getElements() {
        return this.elemens;
    }
}
