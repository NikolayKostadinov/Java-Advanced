package P09CustomListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class GenericList<T extends Comparable<T>> implements Iterable<T> {
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

    @Override
    public Iterator<T> iterator() {
        return this.elemens.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.elemens.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return this.elemens.spliterator();
    }
}
