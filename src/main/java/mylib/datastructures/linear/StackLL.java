package src.main.java.mylib.datastructures.linear;
import src.main.java.mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {
    public StackLL() {
        super();
    }

    public void InsertTail(SNode node) {}
    public void InsertAfter(SNode node, SNode newNode) {}
    public void Delete(int position) {}
    
    // Function wrappers with proper naming conventions for stack functionality
    public void push(SNode node) {
        super.insertHead(node);
    }
    
    public SNode pop() {
        return super.deleteHead();
    }
    
    public SNode peek() {
        return super.getHead();
    }
    
    public boolean isEmpty() {
        return super.isEmpty();
    }
    
    public int size() {
        return super.getSize();
    }


}
