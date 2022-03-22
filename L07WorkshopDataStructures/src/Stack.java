import java.util.Iterator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Stack implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int value = current.element;
                current = current.prev;
                return value;
            }
        };
    }

    private static class Node {
        private int element;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public Stack() {
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.prev = top;
        }
        this.top = newNode;
        this.size++;
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty!");
        }
        int element = top.element;

        Node oldTop = this.top;
        this.top = this.top.prev;
        oldTop.prev = null;
        this.size--;
        return element;
    }

    public int peek() {
        return this.top.element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
