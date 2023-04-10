import main.java.mylib.datastructures.nodes.DNode;

public class DLL {
    private DNode head = null;
    private DNode tail = null;
    private int size = 0;
    
    public DLL() {}
    
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
    
    public void SortedInsert(DNode data) {
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

    public static void main (String[] args){
        SNode startNode = new SNode(1, null);
        SNode secondNode = new SNode(2, null);
        SNode thirdNode = new SNode(3, null);
        SNode fourthNode = new SNode(4, null);
        SNode endNode = new SNode(5, null);
        
        //default constructor 
        SLL newFunction = new SLL();
        System.out.print("After new SLL(): \n");
        newFunction.print();

        //default constructor 
        newFunction = new SLL(startNode);
        System.out.print("\nAfter new SLL(startNode): \n");
        newFunction.print();

        //insert methods
        System.out.print("\nAfter insertHead(startNode): \n");
        newFunction.insertHead(startNode);
        newFunction.print();
        System.out.print("\nAfter insertTail(endNode): \n");
        newFunction.insertTail(endNode);
        newFunction.print();
        System.out.print("\nAfter insert(secondNode): \n");
        newFunction.insert(secondNode, 3);
        newFunction.print();

        // sorting methods
        System.out.print("\nAfter sort(): \n");
        newFunction.sort();
        newFunction.print();

        System.out.print("\nAfter insert(thirdNode, 2) (so function isn't sorted): \n");
        newFunction.insert(thirdNode, 2);
        newFunction.print();

        System.out.print("\nAfter sortedInsert(fourthNode): \n");
        newFunction.sortedInsert(fourthNode);
        newFunction.print();

        // searching method
        System.out.print("\nChecking search()... \n");
        SNode nodeNotExist = new SNode(30, null);
        if (newFunction.search(nodeNotExist) == null) {
            System.out.println(nodeNotExist.getValue() + " does not exist in the linked list.");
        }
        else { System.out.println(nodeNotExist.getValue() + " exists in the linked list.\n"); }

        SNode nodeExists = new SNode(4, endNode);
        if (newFunction.search(nodeExists) == null) {
            System.out.println(nodeExists.getValue() + " does not exist in the linked list.");
        }
        else { System.out.println(nodeExists.getValue() + " exists in the linked list.\n"); }
        
        // deleting methods
        System.out.print("After deleteHead(): \n");
        newFunction.deleteHead();
        newFunction.print();

        System.out.print("\nAfter deleteTail(): \n");
        newFunction.deleteTail();
        newFunction.print();
        
        System.out.print("\nAfter delete(thirdNode): \n");
        newFunction.delete(thirdNode);
        newFunction.print();

        System.out.print("\nAfter clear(): \n");
        newFunction.clear();
        newFunction.print();

        System.out.print("\nChecking isEmpty()... \n");
        if (newFunction.isEmpty()) System.out.print("list is empty!\n");
        else System.out.print("list is not empty!\n");

        System.out.println();
    }
}
