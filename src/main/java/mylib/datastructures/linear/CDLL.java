package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    public CDLL() { super(); }

    public CDLL(DNode node) {
        super(node);
        head.setPrev(tail);
        tail.setNext(head);
        head.setNext(tail);
        tail.setPrev(head);
    } 

    /* Insertion Methods */
    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    @Override
    public void insertTail(DNode data) {
        super.insertTail(data);
        head.setPrev(tail);
        tail.setNext(head);
    }
     
    @Override
    public void sortedInsert(DNode node) {
        if (isEmpty()) {
            insertHead(node);
            return;
        }
        if (!isSorted()) {
            sort();
        }
        DNode previous = head;
        DNode current = head.getNext();
        while (current != head && node.compareTo(node, current) > 0) {
            previous = current;
            current = current.getNext();
        }
        if (current == head) { insertHead(node); }
        else {
            node.setNext(current);
            node.setPrev(previous);
            previous.setNext(node);
            current.setPrev(node);
            size++;
        }
    }    
    
    private boolean isSorted() {
        DNode current = head.getNext();
        while (current != head && current.getNext() != head) {
            if (current.compareTo(current, current.getNext()) > 0) { return false; }
            current = current.getNext();
        }
        return true;
    }

    public void sort() {
        if (isEmpty() || size == 1) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            DNode current = head;
            DNode prev = tail;
            while (current.getNext() != head) {
                if (current.compareTo(current, current.getNext()) > 0) {
                    // Swap nodes
                    DNode next = current.getNext();
                    DNode nextNext = next.getNext();
    
                    if (current == head) { head = next; } 
                    else if (current == tail) { tail = current; }
    
                    current.setNext(nextNext);
                    next.setNext(current);
                    prev.setNext(next);
    
                    // Update pointers
                    prev = next;
                    next = current.getNext();
                    swapped = true;
                } else {
                    prev = current;
                    current = current.getNext();
                }
            } 
        } while (swapped);
    }
    
    
    /* Deleting methods */
    @Override
    public void deleteHead() {
        super.deleteHead();
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    @Override
    public void deleteTail() {
        super.deleteTail();
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    @Override
    public void delete(DNode data) {
        super.delete(data);
        head.setPrev(tail);
        tail.setNext(head);
    }

    @Override
    public DNode search(DNode node) {
        if (isEmpty()) { return null; }
        DNode current = head.getNext();
        while (current != head) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
        
    }
 
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty list");
        } else {
            System.out.print("List content: \n");
            System.out.print("[ ");
            DNode current = head;
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != head);
            System.out.println("]");
            System.out.println("List length: " + size);
            System.out.println("Circular: true");
        }
    }
    /* print() - MISSING */

    @Override
    public boolean isEmpty() { return super.isEmpty(); }
}
