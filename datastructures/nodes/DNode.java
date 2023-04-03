package main.java.mylib.datastructures.nodes;

public class DNode {
    private int data;
    private DNode prev;
    private DNode next;
    public DNode(int data) {
        this.data = data;
        prev = null;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public DNode getPrev() {
        return prev;
    }

    public void setNext(DNode oneAfter) {
        next = oneAfter;
    }

    public void setPrev(DNode oneBefore) {
        prev = oneBefore;
    }

    public DNode getNext() {
        return next;
    }
}