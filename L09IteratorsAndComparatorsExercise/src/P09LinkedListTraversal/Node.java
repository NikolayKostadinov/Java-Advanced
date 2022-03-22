package P09LinkedListTraversal;

// Linked list Node.
// This inner class is made static
// so that main() can access it
public class Node {

    int value;
    Node next;

    // Constructor
    Node(int number) {
        value = number;
        next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
