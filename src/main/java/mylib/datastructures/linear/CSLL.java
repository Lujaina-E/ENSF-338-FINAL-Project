package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    private int size;
    private SNode tail;
    
    public CSLL() {
        super();
    }

    public CSLL(SNode node) {
        super(node);
    }

    public void insertHead(SNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            tail.setNext(head);
        } else {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        }
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Insert at tail
    public void insertTail(SNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            tail.setNext(head);
        } else {
            tail.setNext(node);
            tail = node;
            tail.setNext(head);
        }
        size++;
    }

    // Delete head
    public SNode deleteHead() {
        if (!isEmpty()) {
            head = head.getNext();
            tail.setNext(head);
            size--;
        }
        return tail;
    }

    // Delete tail
    public SNode deleteTail() {
        if (!isEmpty()) {
            SNode current = head;
            SNode previous = null;
            while (current.getNext() != head) {
                previous = current;
                current = current.getNext();
            }
            tail = previous;
            if (tail == null) {
                head = null;
            } else {
                tail.setNext(head);
            }
            size--;
        }
        return tail;
    }

    // Insert at position
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    // Delete node
    public void delete(SNode node) {
        if (!isEmpty()) {
            SNode current = head;
            SNode previous = null;
            while (current != null && current != node) {
                previous = current;
                current = current.getNext();
            }
            if (current == node) {
                if (previous == null) {
                    deleteHead();
                } else if (current == tail) {
                    deleteTail();
                } else {
                    previous.setNext(current.getNext());
                    size--;
                }
            }
        }
    }

    // Clear list
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Print list
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty list");
        } else {
            System.out.print("[ ");
            SNode current = head;
            do {
                System.out.print(current.getValue() + " ");
                current = current.getNext();
            } while (current != head);
            System.out.println("]");
            System.out.println("List length: " + size);
            System.out.println("Circular: true");
        }
    }
}
