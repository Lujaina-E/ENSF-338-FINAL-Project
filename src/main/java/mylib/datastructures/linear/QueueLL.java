package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL{

    /* Constructors */
    public QueueLL() { super(); }
    public QueueLL(SNode node) { super(node); }

    /* SLL methods to not misuse - overriding them with emtpy methods */
    @Override 
    public void setHead(SNode head) {}
    public SNode getHead() { return null; }
    public void insertHead(SNode node) {}
    public void insertTail(SNode node) {}
    public void insert(SNode node, int position) {}
    public void sortedInsert(SNode node) {}
    public void deleteHead() {}
    public void deleteTail() {}
    public void delete(SNode node) {}
    
    /* Queue methods - peek, enqueue, dequeue */
    public SNode peek() { return super.getHead(); }
    public void enqueue(SNode node) { super.insertTail(node); }
    public SNode dequeue() { 
        SNode top = super.getHead();
        super.deleteHead(); 
        return top;
    }
    
}
