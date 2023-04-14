package src.main.java.mylib.datastructures.linear;
import src.main.java.mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    public StackLL() { super(); } 
    public StackLL(SNode node) { super(node); }

    @Override // methods from SLL to not misuse
    public void setTail(SNode tail) {}
    public SNode getHead() { return null; }
    public void insertHead(SNode node) {}
    public void insertTail(SNode node) {}
    public void insert(SNode node, int position) {}
    public void sortedInsert(SNode node) {}
    public void deleteHead() {}
    public void deleteTail() {}
    public void delete(SNode node) {}
    
    // Function wrappers with proper naming conventions for stack functionality
    public void push(SNode node) { super.insertHead(node); }
    public SNode pop() { 
        SNode top = super.getHead();
        super.deleteHead(); 
        return top;
    }
    public SNode peek() { return super.getHead(); }
}
