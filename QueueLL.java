

package main.java.mylib.datastructures.linear;
import java.util.NoSuchElementException;
import main.java.mylib.datastructures.nodes.SNode;


public class QueueLL extends SLL {

    public QueueLL() {
        super();
    }

    public void enqueue(SNode node) {
        super.insertTail(node);
    }

    public SNode dequeue() {
        if (this.head == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        SNode temp = this.head;
        this.deleteHead();
        return temp;
    }

    public SNode peek() {
        if (this.head == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        return super.getHead();
    }

    @Override
    public void insertHead(SNode node) {
    }
    
    @Override
    public void insert(SNode node, int position) {
    }
    
    @Override
    public void sortedInsert(SNode node) {
    }
    
    @Override
    public void deleteTail() {
    }
    
    @Override
    public void delete(SNode node) {
    }
    
    @Override
    public void sort() {
    }

}