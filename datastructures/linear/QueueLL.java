import main.java.mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL{

    public QueueLL() {
        super();
    }
    
    public void enque(SNode node) {
        super.insertTail(node);
    }
    
    public SNode dequeue() {
        return super.removeHead();
    }
    
    public void InsertHead(SNode node) {}
    
    public void InsertTail(SNode node) {
        super.insertTail(node);
    }
    
    public SNode RemoveHead() {
        return null;
    }
}
