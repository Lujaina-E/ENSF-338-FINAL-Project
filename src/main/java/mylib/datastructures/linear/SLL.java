// import main.java.mylib.datastructures.nodes.SNode;

// javac -cp .:src/main/java/mylib/datastructures/linear/SLL.java
// java -cp .:src.main.java.mylib.datastructures.linear.SLL
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
    public SNode deleteHead() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        SNode temp = head;
        head = head.getNext();
        size--;
        return temp;
    }

    public SNode deleteTail() {
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
        return current;
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
            if (current.getValue() == node.getValue() && current.getNext() == node.getNext()) {
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