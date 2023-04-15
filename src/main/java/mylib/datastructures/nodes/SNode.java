package mylib.datastructures.nodes;


public class SNode {
    public SNode next = null;
    public int value = 0;

    /* Constructors */
    public SNode() {}
    public SNode(int value){ this.value = value; }
    public SNode(int value, SNode next){
        this.value = value; 
        this.next = next; 
    }

    /* Getters and Setters */
    public int getValue() { return value; }
    public SNode getNext() { return next; }
    public void setValue(int value) { this.value = value; }
    public void setNext(SNode nextOne) { next = nextOne;}

    public int compareTo(SNode previous, SNode current) {
        SNode node1 = previous;
        SNode node2 = current;
        
        while (node1 != null && node2 != null) {
            int value1 = node1.getValue();
            int value2 = node2.getValue();
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
