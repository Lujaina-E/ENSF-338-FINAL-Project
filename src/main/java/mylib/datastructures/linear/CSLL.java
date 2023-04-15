package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    /* Constructors */
    public CSLL() { super(); }
    public CSLL(SNode node) { 
        super(node); 
        tail.setNext(head); 
    }

    /* Insertion Methods */
    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
        tail.setNext(head); 
    }
    
    @Override
    public void insertTail(SNode node) {
        super.insertTail(node);
        if (size == 1) { head.setNext(tail); }
        tail.setNext(head);
    }

    /* Sorting methods */
    @Override
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
        while (current != head && node.compareTo(node, current) > 0) {
            previous = current;
            current = current.getNext();
        } // if node's value is larger than current's value, stay in loop

        if (current == head) { insertHead(node); }
        else {
            node.setNext(current);
            previous.setNext(node);
            size++;   
        }
    }

    private boolean isSorted() {
        SNode current = head.getNext();
        while (current != head && current.getNext() != head) {
            // if current's value is larger than current.next's value 
            if (current.compareTo(current, current.getNext()) > 0) { return false; }
            current = current.getNext();
        } 
        return true;
    }

    @Override
    public void sort() {
        if (isEmpty() || size == 1) {
            return;
        }
        SNode current = head.getNext();
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

    /* Deleting methods */
    @Override
    public void deleteHead() {
        super.deleteHead();
        tail.setNext(head);
    }

    @Override
    public void deleteTail() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
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

    @Override
    public void delete(SNode node) {
        if (search(node) == null) { return; }
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

    @Override
    public SNode search(SNode node) {
        if (isEmpty()) { return null; }
        SNode current = head.getNext();
        while (current != head) {
            if (current.getValue() == node.getValue()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
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
}
