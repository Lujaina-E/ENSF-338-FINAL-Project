package main.java.mylib.datastructures.nodes;


public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;
    private int height;

    // Default constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    // Overload constructor
    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.parent = P;
        this.left = L;
        this.right = R;
    }

    // Getters
    public int getData() {
        return data;
    }

    public TNode getLeft() {
        return left;
    }

    public TNode getRight() {
        return right;
    }

    public TNode getParent() {
        return parent;
    }

    public int getBalance() {
        return balance;
    }

    public int getHeight() {
        return height;
    }

    // Setters
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

    public void setHeight(int height) {
        this.height = height;
    }

    // Print the node information to console
    public void print() {
        System.out.println("Data: " + data + ", Balance: " + balance); //CHANGE THIS IF NEED BE
    }

    // Returns the data member as a string
    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
