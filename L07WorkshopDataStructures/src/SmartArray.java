import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SmartArray<T> {
    private static final int INITIAL_CAPACITY = 8;
    private int size = 0;
    private Object[] elements;

    public SmartArray() {

        this.elements = new Object[INITIAL_CAPACITY];
    }

    public void add(T element) {
        if (this.elements.length == size) {
            this.elements = grow();
        }
        this.elements[this.size++] = element;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, T element) {
        validateIndex(index);
        T lastElement = (T) this.elements[this.size - 1];

        if (this.size - 1 - index > 0) {
            System.arraycopy(this.elements, index, this.elements, index + 1, this.size - 1 - index);
        }

        this.elements[index] = element;
        this.add(lastElement);
    }

    private Object[] grow() {
        Object[] newElements = new Object[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, elements.length);
        return newElements;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        validateIndex(index);
        return (T) this.elements[index];
    }

    public T remove(int index) {
        T element = this.get(index);
        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
        }

        this.elements[--this.size] = 0;

        if (this.size == 0) {
            this.elements = new Object[INITIAL_CAPACITY];
        }

        if (size >= INITIAL_CAPACITY && size <= this.elements.length / 4) {
            this.elements = shrink();
        }
        return element;
    }

    private Object[] shrink() {
        Object[] newElements = new Object[this.elements.length / 2];
        System.arraycopy(this.elements, 0, newElements, 0, newElements.length);
        return newElements;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public int size() {
        return this.size;
    }

    public boolean contains(T element) {
        return IntStream.range(0, this.size)
                .anyMatch(i -> this.elements[i].equals(element));
    }

    public void forEach(Consumer<T> consumer) {
        IntStream.range(0, this.size)
                .mapToObj(i -> this.elements[i])
                .forEach(e -> consumer.accept((T) e));
    }


}
