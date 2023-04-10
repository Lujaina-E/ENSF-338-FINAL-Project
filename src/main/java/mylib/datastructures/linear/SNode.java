

public class SNode {

    public SNode next;
    public int value;
    private Object head;

    public SNode(){
        this.value = 0;
        this.next = null; 
    }

    public SNode(int value, SNode next){
        this.value = value; 
        this.next = next; 
    }

    public int getValue() { return value; }
    public SNode getNext() { return next; }
    
    public void setValue(int value) { this.value = value; }
    public void setNext(SNode nextOne) { next = nextOne;}
    
    public int compareTo(SNode current) {
        SNode node1 = ((SNode) this.head).getNext();
        SNode node2 = ((SNode) current.head).getNext();
        
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
    
        if (node1 == null && node2 == null) {
            return 0;
        } else if (node1 == null) {
            return -1;
        } else {
            return 1;
        }
    }
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
        
        if (node1 == null && node2 == null) {
            return 0;
        } else if (node1 == null) {
            return -1;
        } else {
            return 1;
        }
    }
    
}
