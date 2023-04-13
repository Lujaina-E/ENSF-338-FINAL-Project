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

    /* Sorting methods */
    public void sortedInsert(SNode node) {
        if (isEmpty()) {
            insertHead(node);
            return;
        }
        if (!isSorted()) {
            sort();
        }
        SNode previous = head;
        SNode current = head.getNext();
        do {
            previous = current;
            current = current.getNext();
        } while (node.compareTo(node, current) > 0 && current != head); // if node's value is larger than current's value 

        if (current == head) insertHead(node);
        node.setNext(current);
        previous.setNext(node);
        size++;
    }

    public boolean isSorted() {
        if (isEmpty() || size == 1) {
            return true;
        }
        SNode current = head.getNext();
        do {
            if (current == null) {
                return false; // list is not circular
            }
            if (current.compareTo(current, current.getNext()) > 0) { // if current's value is larger than current.next's value 
                return false;
            }
            current = current.getNext();
        } while (current != head && current.getNext() != head);
        return true;
    }

    public void sort() {
        if (isEmpty()) {
            return;
        }
        SNode current = head;
        do {
            SNode next = current.getNext();
            while (next != head) {
                if (current.compareTo(current, next) > 0) {
                    // swap the data of current and next nodes
                    int temp = current.getValue();
                    current.setValue(next.getValue());
                    next.setValue(temp);
                }
                next = next.getNext();
            }
            current = current.getNext();
        } while (current != head);
    }

    public int indexOf(int data) {
        if (isEmpty()) {
            return -1;
        }
        SNode current = head.getNext();
        int index = 1;
        do {
            if (current.getValue() == data) {
                return index;
            }
            current = current.getNext();
            index++;
        } while (current != head);
        return 0;
    }
    
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


    public SNode search(SNode node) {
        SNode current = head.getNext();
        while (current != head) {
            if (current.getValue() == node.getValue()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

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
