package src.main.java.mylib.datastructures.nodes;


public class DNode {
    private int data = 0;
    private DNode prev = null;
    private DNode next = null;

    public DNode(){}

    public DNode(int data, DNode node) {
        this.data = data;
        this.prev = node;
        this.next = node;
    }
    
    public int getData() { return data; }
    public DNode getPrev() { return prev; }
    public DNode getNext() { return next; }

    public void setData(int data) { this.data = data; }
    public void setPrev(DNode oneBefore) { this.prev = oneBefore; }
    public void setNext(DNode oneAfter) { this.next = oneAfter; }

    public int compareTo(DNode previous, DNode current) {
        DNode node1 = previous;
        DNode node2 = current;
        
        while (node1 != null && node2 != null) {
            int value1 = node1.getData();
            int value2 = node2.getData();
            int result = value1 - value2;
            if (result != 0) {
                return result;
            }
            node1 = node1.getNext();
            node2 = node2.getNext();
        }
        
        if (node1 == null && node2 == null) { // if the values in the nodes are the same, return 0
            return 0; 
        } else if (node1 == null) { // if value in first node is smaller than value in second node, return -1
            return -1;
        } else { // if value in first node is larger than value in second node, return -1
            return 1;
        }
    }
    
}