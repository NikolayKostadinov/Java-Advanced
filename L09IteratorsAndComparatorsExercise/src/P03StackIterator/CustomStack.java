package P03StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack<T> implements Iterable<T> {
    private final List<T> elements;

    public CustomStack() {
        this.elements = new ArrayList<>();
    }

    public void push(T element){
        this.elements.add(0, element);
    }

    public T pop (){
        return this.elements.remove(0);
    }

    public T peek(){
        return this.elements.get(0);
    }

    public boolean isEmpty(){
        return this.elements.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }
}
