import main.java.mylib.datastructures.nodes.SNode;

class SLL{

    protected SNode head;
    private SNode tail;
    private int size;
    

    public SLL(){
        head = null;
        tail = null;
        size = 0;
    }

    public SLL(SNode head) {
        this.head = head;
        this.tail = null;
        this.size = 1;
    }
    
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
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
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    public void insert(SNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
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
        if (head == null) {
            insertHead(node);
            return;
        }
        if (!isSorted()) {
            sort();
        }
        SNode current = head;
        SNode previous = null;
        while (current != null && node.compareTo(current) > 0) {
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

    public SNode search(SNode node) {
        SNode current = head;
        while (current != null) {
            if (current.equals(node)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    private boolean isSorted() {
        SNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.compareTo(current.getNext()) > 0) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    private void sort() {
        if (head == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            SNode current = head;
            SNode prev = null;
            while (current.getNext() != null) {
                if (current.compareTo(current.getNext()) > 0) {
                    if (prev == null) {
                        head = current.getNext();
                    } else {
                        prev.setNext(current.getNext());
                    }
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

    public void Delete(SNode node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            deleteHead();
            return;
        }
        if (tail == node) {
            deleteTail();
            return;
        }
        SNode current = head;
        while (current != null && current.getNext() != node) {
            current = current.getNext();
        }
        if (current != null) {
            current.next = current.getNext().next; //does this work right?
            size--;
        }
    }

    public void Sort() {
        SNode current = head;
        while (current != null) {
            SNode innerCurrent = current.next;
            while (innerCurrent != null) {
                if (innerCurrent.value < current.value) {
                    int temp = current.value;
                    current.value = innerCurrent.value;
                    innerCurrent.value = temp;
                }
                innerCurrent = innerCurrent.getNext();
            }
            current = current.next;
        }
    }

    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print(){
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
    
        SNode currentNode = head;
        while (currentNode != null) {
            System.out.print(String.valueOf(currentNode.getValue()) + " ");
            currentNode = currentNode.getNext();
    }
    System.out.println();
    }

    public SNode getHead() {
        return head;
    }

    public boolean isEmpty() { 
        return head == null;
    }

    public int getSize() { 
        return size;
    }

    public SNode removeHead() { //todo
        return null;
    }
}