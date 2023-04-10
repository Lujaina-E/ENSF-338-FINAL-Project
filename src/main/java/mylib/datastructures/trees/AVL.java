package main.java.mylib.datastructures.trees;
import main.java.mylib.datastructures.nodes.TNode;

public class AVL extends BST {
    private TNode root;

    public AVL() {
        super();
    }

    public AVL(int val) {
        super(val);
    }

    public AVL(TNode obj) {
        this.root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            this.root = balance(obj);
        }
    }

    public TNode getRoot() {
        return this.root;
    }
    
    // setter for root
    public void setRoot(TNode node) {
        this.root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            this.root = balance(node);
        }
    }


    public void insert(int val) {
        super.insert(val);
        this.root = balance(this.root);
    }

    public void insert(TNode node) {
        super.insert(node);
        this.root = balance(this.root);
    }


    public void delete(int val) {
        TNode node = super.search(val);
        if (node == null) {
            System.out.println("Value " + val + " not found in the tree.");
            return;
        }
        TNode parent = node.getParent();
        super.delete(val);
        this.root = balance(parent);
    }


    private int height(TNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }


    private int balanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private TNode rotateLeft(TNode node) {
        int height = height(node);  
        TNode right = node.getRight();
        TNode leftOfRight = right.getLeft();
        right.setLeft(node);
        node.setRight(leftOfRight);
        node.setHeight(height(node));
        right.setHeight(height(right));
        return right;
    }


    private TNode rotateRight(TNode node) {
        TNode left = node.getLeft();
        TNode rightOfLeft = left.getRight();
        left.setRight(node);
        node.setLeft(rightOfLeft);
        node.setHeight(height(node));
        left.setHeight(height(left));
        return left;
    }

    private TNode balance(TNode node) {
        if (node == null) {
            return null;
        }
        int bf = balanceFactor(node);
        if (bf > 1) {
            if (balanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            node = rotateRight(node);
        } else if (bf < -1) {
            if (balanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }
        return node;
    }


}
