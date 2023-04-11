package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    private DNode head;
    private DNode tail;

    public CDLL() {
        super();
        head.setPrev(tail);
        tail.setNext(head);
    }

    public CDLL(DNode node) {
        super(node);
        head.setPrev(tail);
        tail.setNext(head);
        head.setNext(tail);
        tail.setPrev(head);
    } 

    public void InsertHead(DNode data) {
        super.insertHead(data);
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    public void InsertTail(DNode data) {
        super.insertTail(data);
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    public void SortedInsert(DNode data) {
        super.SortedInsert(data);
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    public void DeleteHead() {
        super.deleteHead();
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    public void DeleteTail() {
        super.deleteTail();
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    public void Delete(DNode data) {
        super.delete(data);
        head.setPrev(tail);
        tail.setNext(head);
    }
    
}
