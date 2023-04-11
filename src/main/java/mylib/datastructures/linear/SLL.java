package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.SNode;

public class SLL {

    protected SNode head = null;
    private SNode tail = null;
    private int size = 0;
    
    /* Constructors */
    public SLL() {}

    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }
    
    /* Getters */
    public SNode getHead() { return this.head; }
    public SNode getTail() { return this.tail; }
    public int getSize() { return this.size; }

    /* Setters */
    public void setHead(SNode head){this.head = head;}
    public void setTail(SNode tail){this.tail = tail;}
    public void setSize(int size){this.size = size;} 

    /* Insertion Methods */
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (head == node) {
            return;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }
    
    public void insertTail(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail == node) {
            return;
        }
        else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    public void insert(SNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        if (search(node) != null) { return; }
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
        if (head == null) {
            insertHead(node);
            return;
        }
        if (!isSorted()) {
            sort();
        }
        SNode current = head;
        SNode previous = null;
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
            previous.setNext(node);
            size++;
        }
    }

    private boolean isSorted() {
        SNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.compareTo(current, current.getNext()) > 0) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    
    private void sort() {
        if (head == null || this.head.getNext() == null) { return; }
        boolean swapped;
        do {
            swapped = false;
            SNode current = head;
            SNode prev = null;
            while (current != null && current.getNext() != null) {
                if (current.compareTo(current, current.getNext()) > 0) { //if current.value > current.next.value (meaning unsorted)
                    if (prev == null) { head = current.getNext(); } 
                    else { prev.setNext(current.getNext()); }
                    
                    SNode temp = current.getNext().getNext();
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
            throw new IndexOutOfBoundsException("List is empty");
        }
        SNode temp = head;
        head = head.getNext();
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        SNode current = head;
        SNode previous = null;
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            head = null;
            tail = null;
        } else {
            previous.setNext(null);
            tail = previous;
        }
        size--;
    }

    public void delete(SNode node) {
        if (head == null) { return; }
        if (head == node) {
            deleteHead();
            return;
        }
        if (tail == node) {
            deleteTail();
            return;
        }
        if (search(node) == null) { return; }
        
        SNode prev = head;
        SNode current = head.getNext();
        while (current != node) {
            prev = prev.getNext();
            current = current.getNext();
        }
        prev.setNext(current.getNext());
        size--;
    }


    public SNode search(SNode node) {
        SNode current = head;
        while (current != null) {
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

    public void print(){
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
        
        if (head == null) { System.out.print("no contents"); }
        else {
            SNode currentNode = head;
            while (currentNode != null) {
                System.out.print(String.valueOf(currentNode.getValue()));
                if (currentNode.getNext() != null) { System.out.print(", "); }
                currentNode = currentNode.getNext();
            }
        }
        System.out.println();
    }

    public boolean isEmpty() { return head == null; }
}