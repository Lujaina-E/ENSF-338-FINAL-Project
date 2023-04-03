import main.java.mylib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    private int size;
    
    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public DLL(DNode node) {
        head = node;
        tail = node;
        size = 1;
    }
    
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
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
        if (position <= 0) {
            insertHead(node);
        } else if (position >= size) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current);
            node.setPrev(current.getPrev());
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
        }
    }
    
    public void deleteHead() {
        if (head != null) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            } else {
                head.setPrev(null);
            }
            size--;
        }
    }
    
    public void deleteTail() {
        if (tail != null) {
            tail = tail.getPrev();
            if (tail == null) {
                head = null;
            } else {
                tail.setNext(null);
            }
            size--;
        }
    }
    
    public void delete(DNode node) {
        DNode current = head;
        while (current != null && current != node) {
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        if (current == head) {
            deleteHead();
        } else if (current == tail) {
            deleteTail();
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            size--;
        }
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: N/A");
        System.out.print("List content: ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void SortedInsert(DNode data) {
    }
}
