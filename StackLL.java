package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {


    // Returns the top element of the stack without removing it
    public SNode peek() {
        return super.getHead();
    }

    // Adds an element to the top of the stack
    public void push(SNode data) {
        super.insertHead(data);
    }

    // Removes and returns the top element of the stack
    public SNode pop() {
        SNode top = super.getHead();
        super.deleteHead();
        return top;
    }





    // Override methods from singlyLL that are not relevant for stacks
    @Override
    public void insertTail(SNode node) {
        // Do nothing
    }

    @Override
    public SNode getNode(int position) {
        throw new UnsupportedOperationException("Operation not supported for stacks");
    }

    @Override
    public void insert(SNode node, int position) {
        throw new UnsupportedOperationException("Operation not supported for stacks");
    }

    @Override
    public boolean isSorted() {
        throw new UnsupportedOperationException("Operation not supported for stacks");
    }

    @Override
    public void sortedInsert(SNode node) {
        throw new UnsupportedOperationException("Operation not supported for stacks");
    }

    @Override
    public SNode search(SNode node) {
        throw new UnsupportedOperationException("Operation not supported for stacks");
    }

}
