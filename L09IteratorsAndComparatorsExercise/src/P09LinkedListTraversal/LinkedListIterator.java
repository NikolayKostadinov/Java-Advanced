package P09LinkedListTraversal;

import java.util.Iterator;

public class LinkedListIterator implements Iterator<Integer> {
    private final LinkedList list;
    private Node currentNode;

    public LinkedListIterator(LinkedList list) {
        this.list = list;
        currentNode = this.list.getHead();
    }

    @Override
    public boolean hasNext() {
        return this.currentNode != null;
    }

    @Override
    public Integer next() {
        int value = this.currentNode.value;
        this.currentNode = this.currentNode.getNext();
        return value;
    }
}
