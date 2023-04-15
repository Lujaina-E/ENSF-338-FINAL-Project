package src.main.java.myLib.datastructures.trees;

public class TNode {
    public int data; 
    public TNode left;
    public TNode right; 
    public TNode parent; 
    public int balance; 
    /*Constructors */

    public TNode(){
        this.left = null; 
        this.right = null; 
        this.parent = null;
        this.balance = 0; 
        this.data = 0;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R){
        this.left = L; 
        this.right = R; 
        this.parent = P;
        this.balance = balance; 
        this.data = data;
    }
    /* Setters */
    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /* Getters */
    public int getData() {
        return this.data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public TNode getRight() {
        return this.right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public int getBalance() {
        return this.balance;
    }

    /*Printing statements */
    public void print(){
        System.out.println("The value: " + this.data);
        System.out.println("The balance: " + this.balance);
        System.out.println("The left node points to value of: " + this.left.data); 
        System.out.println("The right node points to value of: " + this.right.data); 
        System.out.println("The tree node belongs to the parent of the value of: " + this.parent.data);  
    }
    public String toString(){
        return Integer.toString(data); 
    } 

}
