package P09LinkedListTraversal;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer>{

    private Node head; // head of list
    private int size;

    public Node getHead() {
        return head;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(this);
    }

    public int getSize() {
        return size;
    }

    // Method to insert a new node
    public void add(int number) {
        // Create a new node with given data
        Node new_node = new Node(number);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            this.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        this.size++;
    }

    public void remove(int number) {
        // Store head node
        Node currNode = this.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.value == number) {
            this.head = currNode.next; // Changed head
            this.size--;
            return;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.value != number) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;
            this.size--;
        }
    }
}
