public class QueueLL extends SLL{

    public QueueLL() {
        super();
    }
    
    public void enque(SNode node) {
        super.insertTail(node);
    }
    
    public SNode dequeue() {
        return super.deleteHead();
    }
    
    public void InsertHead(SNode node) {}
    
    public void InsertTail(SNode node) {
        super.insertTail(node);
    }
    
    public SNode RemoveHead() {
        return null;
    }
}
