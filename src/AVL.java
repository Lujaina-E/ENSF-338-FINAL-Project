package src.main.java.myLib.datastructures.trees;

public class AVL extends BST {
    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val , 0, null, null, null);
    }

    public AVL(TNode obj) {
        if (obj == null) {
            this.root = null;
        } else {
            this.root = obj;
            balance(root);
        }
    }

    // Helper function to create a balanced AVL tree from a given node
    private void balance(TNode node) {
        int bf = getBalanceFactor(node);
        if (bf > 1) {
            if (getBalanceFactor(node.left) < 0) {
                rotateLeft(node.left);
            }
            rotateRight(node);
        } else if (bf < -1) {
            if (getBalanceFactor(node.right) > 0) {
                rotateRight(node.right);
            }
            rotateLeft(node);
        }
        if (node.left != null) {
            balance(node.left);
        }
        if (node.right != null) {
            balance(node.right);
        }
    }

    public void setRoot(TNode node) {
        if (node == null) {
            root = null;
        } else {
            root = node;
            balance(root);
        }
    }

    public TNode getRoot() {
        return root;
    }

    @Override
    public void insert(int val) {
        super.insert(val);
        balance(root);
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balance(root);
    }

    // Optional: Implement the Delete function as a bonus
    public void delete(int val) {
        root = deleteNode(root, val);
        balance(root);
    }

    // Helper function to delete a node with a given value from the AVL tree
    private TNode deleteNode(TNode node, int val) {
        if (node == null) {
            return node;
        }
        if (val < node.data) {
            node.left = deleteNode(node.left, val);
        } else if (val > node.data) {
            node.right = deleteNode(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                TNode temp;
                if (node.left == null) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                TNode temp = minValueNode(node.right);
                node.data = temp.data;
                node.right = deleteNode(node.right, temp.data);
            }
        }
        if (node == null) {
            return node;
        }
        balance(node);
        return node;
    }

    // Helper function to get the node with the minimum value from a given subtree
    private TNode minValueNode(TNode node) {
        TNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

}
