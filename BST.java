package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

import java.util.ArrayList;

 
public class BST {
    
    
    private TNode root;

    // Default constructor
    public BST() {
        root = null;
    }

    // Overload constructor with a single integer argument
    public BST(int val) {
        root = new TNode(val, 0, null, null, null);
    }

    // Overload constructor with a TNode argument
    public BST(TNode obj) {
        root = obj;
    }

    //setter
    public void setRoot(TNode node) {
        root = node;
    }
    
    //getter
    public TNode getRoot() {
        return root;
    }

    //Insert(int val): creates a new node with data val to be inserted into the tree
    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null); // Create a new TNode with val
        
        if (this.root == null) { // If the BST is empty, make the new node the root
            this.root = newNode;
        } else { // Otherwise, find the appropriate place to insert the new node
            TNode current = this.root;
            while (true) {
                if (val < current.getData()) { // If val is less than the current node's data, go left
                    if (current.getLeft() == null) { // If the left child is null, insert the new node there
                        current.setLeft(newNode);
                        newNode.setParent(current);
                        break;
                    } else { // Otherwise, continue traversing the left subtree
                        current = current.getLeft();
                    }
                } else if (val > current.getData()) { // If val is greater than the current node's data, go right
                    if (current.getRight() == null) { // If the right child is null, insert the new node there
                        current.setRight(newNode);
                        newNode.setParent(current);
                        break;
                    } else { // Otherwise, continue traversing the right subtree
                        current = current.getRight();
                    }
                } else { // If the val is equal to the current node's data, it is already in the tree
                    break;
                }
            }
        }
    }

    //Insert(TNode node) : inserts the node passed as argument into the tree
    public void insert(TNode node) {
        if (root == null) { // if the tree is empty, make the new node as the root
            root = node;
            return;
        }
    
        // start searching from the root
        TNode current = root;
        TNode parent = null;
    
        while (true) {
            parent = current;
    
            // if the new node's data is less than the current node's data, move to the left subtree
            if (node.getData() < current.getData()) {
                current = current.getLeft();
    
                // if we've reached a leaf node, add the new node as the left child of the current node
                if (current == null) {
                    parent.setLeft(node);
                    node.setParent(parent);
                    return;
                }
            }
            // if the new node's data is greater than the current node's data, move to the right subtree
            else if (node.getData() > current.getData()) {
                current = current.getRight();
    
                // if we've reached a leaf node, add the new node as the right child of the current node
                if (current == null) {
                    parent.setRight(node);
                    node.setParent(parent);
                    return;
                }
            }
            // if the new node's data is already in the tree, do not insert again
            else {
                return;
            }
        }
    }
    
    // Delete(int val): finds the node with val as data and deletes it, if not found printsa statement that the value is not in the tree
    public void Delete(int val) {
        // Find the node to delete
        TNode nodeToDelete = Search(val);
        
        // If node not found, print message and return
        if (nodeToDelete == null) {
            System.out.println("Value not found in tree.");
            return;
        }
        
        // Case 1: Node to delete has no children
        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            // If node to delete is the root, set root to null
            if (nodeToDelete == root) {
                root = null;
            } 
            // Otherwise, remove node from its parent
            else {
                TNode parent = nodeToDelete.getParent();
                if (parent.getLeft() == nodeToDelete) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        }
        // Case 2: Node to delete has one child
        else if (nodeToDelete.getLeft() == null || nodeToDelete.getRight() == null) {
            TNode child = (nodeToDelete.getLeft() != null) ? nodeToDelete.getLeft() : nodeToDelete.getRight();
            
            // If node to delete is the root, set child as root
            if (nodeToDelete == root) {
                root = child;
            } 
            // Otherwise, replace node with its child
            else {
                TNode parent = nodeToDelete.getParent();
                if (parent.getLeft() == nodeToDelete) {
                    parent.setLeft(child);
                } else {
                    parent.setRight(child);
                }
                child.setParent(parent);
            }
        }
        // Case 3: Node to delete has two children
        else {
            // Find the inorder successor of the node to delete
            TNode successor = nodeToDelete.getRight();
            while (successor.getLeft() != null) {
                successor = successor.getLeft();
            }
            
            // Replace the node to delete with the inorder successor
            int successorData = successor.getData();
            Delete(successorData);
            nodeToDelete.setData(successorData);
        }
    }

    

    //TNode Search(int val): searches for the node with val as data and returns it orreturns null if not found.
    public TNode Search(int val) {
        // Start at the root node
        TNode current = root;
        
        // Traverse the tree until we find the node with the given value or hit a leaf node
        while (current != null && current.getData() != val) {
            if (val < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        
        // Return the node if we found it, or null if we didn't
        return current;
    }
    
    //printInOrder(): prints the content data of the tree in ascending order

    // first checks if the tree is empty
    public void printInOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            System.out.print("In-order traversal: ");
            inOrderTraversal(root);
            System.out.println();
        }
    }
    
    private void inOrderTraversal(TNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void printBF() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
    
        ArrayList<TNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);
    
        int level = 0;
        while (!levelNodes.isEmpty()) {
            System.out.print("Level " + level + ": ");
            ArrayList<TNode> nextLevelNodes = new ArrayList<>();
    
            for (TNode node : levelNodes) {
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    nextLevelNodes.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextLevelNodes.add(node.getRight());
                }
            }
    
            System.out.println();
            level++;
            levelNodes = nextLevelNodes;
        }
    }
        
}


