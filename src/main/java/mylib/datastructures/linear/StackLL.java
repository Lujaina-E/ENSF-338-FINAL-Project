package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    /* Constructors */
    public StackLL() { super(); } 
    public StackLL(SNode node) { super(node); }

    /* SLL methods to not misuse - overriding them with emtpy methods */
    @Override
    public void setTail(SNode tail) {}
    public SNode getHead() { return null; }
    public void insertHead(SNode node) {}
    public void insertTail(SNode node) {}
    public void insert(SNode node, int position) {}
    public void sortedInsert(SNode node) {}
    public void deleteHead() {}
    public void deleteTail() {}
    public void delete(SNode node) {}
    
    /* Stack methods - peek, push, pop */
    public SNode peek() { return super.getHead(); }
    public void push(SNode node) { super.insertHead(node); }
    public SNode pop() { 
        SNode top = super.getHead();
        super.deleteHead(); 
        return top;
    }
}
