package main.java.mylib.datastructures.trees;
import java.util.LinkedList;
import java.util.Queue;
import main.java.mylib.datastructures.nodes.TNode;


public class BST {

    private TNode root;

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode(val);
    }

    public BST(TNode obj) {
        this.root = obj;
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    private TNode getSuccessor(TNode node) {
        TNode successor = node.getRight();
        while (successor.getLeft() != null) {
            successor = successor.getLeft();
        }
        return successor;
    }


    public void delete(int val) {
        TNode nodeToDelete = search(val);
        if (nodeToDelete == null) {
            System.out.println("Value not found in tree");
            return;
        }

        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            if (nodeToDelete == root) {
                root = null;
            } else if (nodeToDelete.getParent().getLeft() == nodeToDelete) {
                nodeToDelete.getParent().setLeft(null);
            } else {
                nodeToDelete.getParent().setRight(null);
            }
        } else if (nodeToDelete.getLeft() != null && nodeToDelete.getRight() == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.getLeft();
            } else if (nodeToDelete.getParent().getLeft() == nodeToDelete) {
                nodeToDelete.getParent().setLeft(nodeToDelete.getLeft());
            } else {
                nodeToDelete.getParent().setRight(nodeToDelete.getLeft());
            }
            nodeToDelete.getLeft().setParent(nodeToDelete.getParent());
        } else if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() != null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.getRight();
            } else if (nodeToDelete.getParent().getLeft() == nodeToDelete) {
                nodeToDelete.getParent().setLeft(nodeToDelete.getRight());
            } else {
                nodeToDelete.getParent().setRight(nodeToDelete.getRight());
            }
            nodeToDelete.getRight().setParent(nodeToDelete.getParent());
        } else {
            TNode successor = getSuccessor(nodeToDelete);
            delete(successor.getData());
            nodeToDelete.setData(successor.getData());
        }
    }

    public void insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            TNode current = root;
            while (true) {
                if (node.getData() < current.getData()) {
                    if (current.getLeft() == null) {
                        current.setLeft(node);
                        node.setParent(current);
                        break;
                    }
                    current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(node);
                        node.setParent(current);
                        break;
                    }
                    current = current.getRight();
                }
            }
        }
    }

    public void insert(int val) {
        TNode newNode = new TNode(val);
        if (root == null) {
            root = newNode;
        } else {
            TNode current = root;
            while (true) {
                if (val < current.getData()) {
                    if (current.getLeft() == null) {
                        current.setLeft(newNode);
                        newNode.setParent(current);
                        break;
                    }
                    current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(newNode);
                        newNode.setParent(current);
                        break;
                    }
                    current = current.getRight();
                }
            }
        }
    }


    public TNode search(int val) {
        TNode current = root;
        while (current != null) {
            if (current.getData() == val) {
                return current;
            } else if (current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    //prints in ascending order
    public void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    
    //prints the content of the tree in Breadth-First order, each level of the tree will be printed on a separate line
    public void printBF() {
        if (root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TNode node = queue.poll();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            System.out.println();
        }
    }

    
    
}

