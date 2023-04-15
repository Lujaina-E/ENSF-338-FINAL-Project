package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;

public class AVL extends BST {
    /* Constructors */
    public AVL() { super(); }
    public AVL(int val) { super(val); }
    public AVL(TNode obj) {
        super(obj);
        if (obj.getLeft() != null || obj.getRight() != null) {
            root = balance(obj);
        }
    }
    
    /* Setter */
    @Override
    public void setRoot(TNode node) {
        super.setRoot(node);
        if (node.getLeft() != null || node.getRight() != null) {
            root = balance(node);
        }
    }

    /* Insertion Methods */
    @Override
    public void insert(int val) {
        super.insert(val);
        root = balance(root);
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        root = balance(root);
    }

    /* Deleting method */
    @Override
    public void delete(int val) {
        root = deleteNode(root, val);
        balance(root);
    }

    // Helper function to delete a node with a given value from the AVL tree
    private TNode deleteNode(TNode node, int val) {
        if (node == null) { return node; }
        if (val < node.getData()) { 
            node.setLeft(deleteNode(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(deleteNode(node.getRight(), val));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                TNode current;
                if (node.getLeft() == null) { current = node.getRight(); } 
                else { current = node.getLeft(); }
                if (current == null) { node = null; } 
                else { node = current; }
            } else {
                TNode current = minValueNode(node.getRight());
                node.setData(current.getData());
                node.setRight(deleteNode(node.getRight(), current.getData()));
            }
        }
        if (node == null) { return node; }
        balance(node);
        return node;
    }

    // Helper function to get the node with the minimum value from a given subtree
    private TNode minValueNode(TNode node) {
        TNode current = node;
        while (current.getLeft() != null) { current = current.getLeft(); }
        return current;
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

    /* Rotating methods */
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

    /* Balance method */
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
