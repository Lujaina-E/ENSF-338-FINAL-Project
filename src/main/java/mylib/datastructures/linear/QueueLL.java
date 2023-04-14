package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL{

    public QueueLL() { super(); }
    public QueueLL(SNode node) { super(node); }

    @Override // methods from SLL to not misuse
    public void setHead(SNode head) {}
    public SNode getHead() { return null; }
    public void insertHead(SNode node) {}
    public void insertTail(SNode node) {}
    public void insert(SNode node, int position) {}
    public void sortedInsert(SNode node) {}
    public void deleteHead() {}
    public void deleteTail() {}
    public void delete(SNode node) {}
    
    public void enqueue(SNode node) { super.insertTail(node); }
    public SNode dequeue() { 
        SNode top = super.getHead();
        super.deleteHead(); 
        return top;
    }
    public SNode peek() { return super.getHead(); }
}
