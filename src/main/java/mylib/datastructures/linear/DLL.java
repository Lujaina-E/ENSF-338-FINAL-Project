package src.main.java.mylib.datastructures.linear;

import java.util.NoSuchElementException;

import src.main.java.mylib.datastructures.nodes.DNode;


public class DLL {
    private DNode head = null;
    private DNode tail = null;
    private int size = 0;
    
    /* Constructors */
    public DLL() {}
    
    public DLL(DNode node) {
        head = node;
        tail = node;
        size = 1;
    }
    
    /* Getters */
    public DNode getHead() { return this.head; }
    public DNode getTail() { return this.tail; }
    public int getSize() { return this.size; }

    /* Setters */
    public void setHead(DNode head){this.head = head;}
    public void setTail(DNode tail){this.tail = tail;}
    public void setSize(int size){this.size = size;} 

    
    /* Insertion Methods */
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (head == node) { return; }
        else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
    }
    
    public void insertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }
    
    public void insert(DNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        if (search(node) != null) { return; }
        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
            current.setNext(node);
            size++;
        }
    }
    
    /* Sorting methods */
    public void sortedInsert(DNode node) {
        if (head == null) {
            insertHead(node);
            return;
        }
        if (!isSorted()) {
            sort();
        }
        DNode current = head;
        DNode previous = null;
        while (current != null && node.compareTo(node, current) > 0) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            insertHead(node);
        } else if (current == null) {
            insertTail(node);
        } else {
            node.setNext(current);
            node.setPrev(previous);
            previous.setNext(node);
            current.setPrev(node);
            size++;
        }
    }    

    private boolean isSorted() {
        DNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.compareTo(current, current.getNext()) > 0) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    
    public void sort() {
        if (head == null || this.head.getNext() == null) { return; }
        boolean swapped;
        do {
            swapped = false;
            DNode current = head;
            DNode prev = null;
            while (current != null && current.getNext() != null) {
                if (current.compareTo(current, current.getNext()) > 0) { //if current.value > current.next.value (meaning unsorted)
                    if (prev == null) { head = current.getNext(); } 
                    else { prev.setNext(current.getNext()); }
                    
                    DNode temp = current.getNext().getNext();
                    current.getNext().setNext(current);
                    current.setNext(temp);
                    swapped = true;
                }
                prev = current;
                current = current.getNext();
            }
            tail = current;
        } while (swapped);

    }

    /* Deleting methods */
    public void deleteHead() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {tail = null; }
        size--; 
    }
    
    public void deleteTail() {
        if (head == null) { throw new IndexOutOfBoundsException("List is empty"); }
        if (tail == null) { throw new NoSuchElementException(); }
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
    }
    
    public void delete(DNode node) {
        if (head == null) { throw new NoSuchElementException(); }
        if (head == node) { deleteHead(); } 
        else if (tail == node) { deleteTail(); } 
        else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());

            size--;
        }
    }
    
    public DNode search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
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
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
        if (head == null) { System.out.print("no contents"); }
        else {
            DNode current = head;
            while (current != null) {
                System.out.print(current.getData());
                if (current.getNext() != null) { System.out.print(", "); }
                current = current.getNext();
            }
        }
        System.out.println();
    }

    public boolean isEmpty() { return head == null; }
}
