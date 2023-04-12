package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    private int size;
    private SNode tail;
    
    /* Getters */
    public SNode getTail() { return this.tail; }
    public int getSize() { return this.size; }

    /* Setters */
    public void setTail(SNode node) { this.tail = node; }
    public void setSize(int size) { this.size = size; }

    /* Constructors */
    public CSLL() { super(); }
    public CSLL(SNode node) { 
        super(node); 
        tail = head;
        size = 1;
    }

    /* Insertion Methods */
    @Override
    public void insertHead(SNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else if (head == node) {
            return;
        } else {
            node.setNext(head);
            head = node;
        }
        tail.setNext(head); 
        size++;
    }
    
    @Override
    public void insertTail(SNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else if (tail == node) {
            return;
        } else {
            tail.setNext(node);
            tail = node;
            if (size == 1) head.setNext(tail);
        }
        tail.setNext(head);
        size++;
    }

    @Override
    public void insert(SNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException();
        } 
        //if (search(node) != null) { return; }
        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public void sortedInsert(SNode node) {
        super.sortedInsert(node);
    }
    /* Sorting methods - MISSING */
    // sortedInsert, isSorted(), sort()
    
    /* Deleting methods */
    public void deleteHead() {
        if (!isEmpty()) {
            head = head.getNext();
            tail.setNext(head);
            size--;
        }
    }

    public void deleteTail() {
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
    }

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


    // search(SNode node) - MISSING  
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty list");
        } else {
            System.out.print("List content: \n");
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

    public boolean isEmpty() { return tail == null; }
}
