package mylib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    /* Constructors */
    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.left = L;
        this.right = R;
        this.parent = P;
        this.balance = 0;
    }

    /* Getters */
    public int getData() { return this.data; }
    public TNode getLeft() { return this.left; }
    public TNode getRight() { return this.right; }
    public TNode getParent() { return this.parent;  }
    public int getBalance() { return this.balance; }
    
    /* Setters */
    public void setData(int data) { this.data = data; }
    public void setLeft(TNode left) { this.left = left;}
    public void setRight(TNode right) { this.right = right; }
    public void setParent(TNode parent) { this.parent = parent; }
    public void setBalance(int balance) { this.balance = balance; }

    public void print(){
        System.out.println("Data: " + this.data);
        System.out.println("Balance: " + this.balance);
        System.out.println("Left: " + this.left);
        System.out.println("Right: " + this.right);
        System.out.println("Parent: " + this.parent);
        System.out.println("\n");
    }

    public String toString( int data) { //not sure if this is the right format for this method
        return String.valueOf(this.data);
    }

    //calculates the height of the tree
    public void setHeight(int height) {   //not sure about this method at ALL
        int leftHeight = 0;
        int rightHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }
        if (this.right != null) {
            rightHeight = this.right.getHeight();
        }
        height = Math.max(leftHeight, rightHeight) + 1;
    }

    //calculates the height and returns it
    public int getHeight() {    //not sure about this method at ALL
        int leftHeight = 0;
        int rightHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }
        if (this.right != null) {
            rightHeight = this.right.getHeight();
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

