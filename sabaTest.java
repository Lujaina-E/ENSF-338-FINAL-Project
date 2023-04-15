package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.BST;
import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.linear.QueueLL;
import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.CDLL;
import main.java.mylib.datastructures.linear.StackLL;


import static org.junit.Assert.*;
import java.io.*;

public class sabaTest<BinarySearchTree> {

    //BST FILE TEST

    @Test
    public void testBSTDefaultConstructor() {
        BST bst = new BST();
        assertNull(bst.getRoot());
    }
    
    @Test
    public void testBSTOverloadConstructorWithVal() {
        int val = 5;
        BST bst = new BST(val);
        assertEquals(val, bst.getRoot().getData());
    }
    
    @Test
    public void testBSTOverloadConstructorWithTNode() {
        TNode node = new TNode(5, 0, null, null, null);
        BST bst = new BST(node);
        assertEquals(node, bst.getRoot());
    }
    
    @Test
    public void testBSTSetRoot() {
        TNode node = new TNode(5, 0, null, null, null);
        BST bst = new BST();
        bst.setRoot(node);
        assertEquals(node, bst.getRoot());
    }
    
    @Test
    public void testBSTGetRoot() {
        TNode node = new TNode(5, 0, null, null, null);
        BST bst = new BST(node);
        assertEquals(node, bst.getRoot());
    }

    @Test
    public void testInsertEmptyTree() {
        BST bst = new BST();
        bst.insert(5);
        TNode root = bst.getRoot();
        assertEquals(5, root.getData());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }
    
    @Test
    public void testInsertLeft() {
        BST bst = new BST(10);
        bst.insert(5);
        TNode root = bst.getRoot();
        assertEquals(10, root.getData());
        assertEquals(5, root.getLeft().getData());
        assertNull(root.getRight());
    }
    
    @Test
    public void testInsertRight() {
        BST bst = new BST(5);
        bst.insert(10);
        TNode root = bst.getRoot();
        assertEquals(5, root.getData());
        assertEquals(10, root.getRight().getData());
        assertNull(root.getLeft());
    }
    
    @Test
    public void testInsertDuplicate() {
        BST bst = new BST(5);
        bst.insert(5);
        TNode root = bst.getRoot();
        assertEquals(5, root.getData());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }
    
    // Test the insert(int val) method
    @Test
    public void testBSTInsert() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        
        // Check that the root has the correct data
        assertEquals(10, bst.getRoot().getData());
        
        // Check that the left subtree is correct
        assertEquals(5, bst.getRoot().getLeft().getData());
        assertEquals(2, bst.getRoot().getLeft().getLeft().getData());
        assertEquals(7, bst.getRoot().getLeft().getRight().getData());
        
        // Check that the right subtree is correct
        assertEquals(15, bst.getRoot().getRight().getData());
        assertEquals(12, bst.getRoot().getRight().getLeft().getData());
        assertEquals(20, bst.getRoot().getRight().getRight().getData());
    }
    
    // Test the insert(TNode node) method
    @Test
    public void testBSTInsertNode() {
        BST bst = new BST();
        TNode node1 = new TNode(10, 0, null, null, null);
        TNode node2 = new TNode(5, 0, null, null, null);
        TNode node3 = new TNode(15, 0, null, null, null);
        TNode node4 = new TNode(2, 0, null, null, null);
        TNode node5 = new TNode(7, 0, null, null, null);
        TNode node6 = new TNode(12, 0, null, null, null);
        TNode node7 = new TNode(20, 0, null, null, null);
        
        bst.insert(node1);
        bst.insert(node2);
        bst.insert(node3);
        bst.insert(node4);
        bst.insert(node5);
        bst.insert(node6);
        bst.insert(node7);
        
        // Check that the root has the correct data
        assertEquals(10, bst.getRoot().getData());
        
        // Check that the left subtree is correct
        assertEquals(5, bst.getRoot().getLeft().getData());
        assertEquals(2, bst.getRoot().getLeft().getLeft().getData());
        assertEquals(7, bst.getRoot().getLeft().getRight().getData());
        
        // Check that the right subtree is correct
        assertEquals(15, bst.getRoot().getRight().getData());
        assertEquals(12, bst.getRoot().getRight().getLeft().getData());
        assertEquals(20, bst.getRoot().getRight().getRight().getData());
    }

//QUEUE FILE TESTS

    private QueueLL queue;

    @Before
    public void setUpQueue() {
        queue = new QueueLL();
    }

    @Test
    public void testEnqueueQueue() {
        SNode node = new SNode(1);
        queue.enqueue(node);
        assertEquals(node, queue.peek());
    }

    @Test
    public void testDequeueQueue() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(node1, queue.dequeue());
        assertEquals(node2, queue.peek());
    }

    @Test
    public void testDequeueEmptyQueue() {
        assertNull(queue.dequeue());
    }

    @Test
    public void testPeekQueue() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(node1, queue.peek());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertNull(queue.peek());
    }

    // These tests are for the methods inherited from SLL
    // They should not modify the queue

    @Test
    public void testInsertHeadQueue() {
        SNode node = new SNode(1);
        queue.insertHead(node);
        assertNull(queue.peek());
    }

    @Test
    public void testInsertQueue() {
        SNode node = new SNode(1);
        queue.insert(node, 0);
        assertNull(queue.peek());
    }

    @Test
    public void testSortedInsertQueue() {
        SNode node = new SNode(1);
        queue.sortedInsert(node);
        assertNull(queue.peek());
    }

    @Test
    public void testDeleteTailQueue() {
        queue.deleteTail();
        assertNull(queue.peek());
    }

    @Test
    public void testDeleteQueue() {
        SNode node = new SNode(1);
        queue.delete(node);
        assertNull(queue.peek());
    }

    @Test
    public void testSortQueue() {
        queue.sort();
        assertNull(queue.peek());
    }

//STACK FILE TESTS

        private StackLL stack;

    @Before
    public void setUpStack() {
        stack = new StackLL();
    }

    @Test
    public void testPush() {
        SNode node = new SNode(1);
        stack.push(node);
        assertEquals(node, stack.peek());
    }

    @Test
    public void testPop() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        assertEquals(node2, stack.pop());
        assertEquals(node1, stack.peek());
    }

    @Test
    public void testPopEmpty() {
        assertNull(stack.pop());
    }

    @Test
    public void testPeekStack() {
        SNode node = new SNode(1);
        stack.push(node);
        assertEquals(node, stack.peek());
    }

    @Test
    public void testPeekEmptyStack() {
        assertNull(stack.peek());
    }

    // These tests are for the methods inherited from SLL
    // They should not modify the stack

    @Test
    public void testInsertTail() {
        SNode node = new SNode(1);
        stack.insertTail(node);
        assertNull(stack.peek());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetNode() {
        stack.getNode(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testInsertStack() {
        SNode node = new SNode(1);
        stack.insert(node, 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIsSorted() {
        stack.isSorted();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortedInsertStack() {
        SNode node = new SNode(1);
        stack.sortedInsert(node);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSearch() {
        SNode node = new SNode(1);
        stack.search(node);
    }

//BST FILE TESTS 
    private BST bst;

    @Before
    public void setUp() {
        bst = new BST();
    }

    @Test
    public void testInsertEmptyBST() {
        bst.insert(5);
        assertEquals(5, bst.getRoot().getData());
    }

    @Test
    public void testInsertLeftBST() {
        bst.insert(5);
        bst.insert(3);
        assertEquals(3, bst.getRoot().getLeft().getData());
    }

    @Test
    public void testInsertRightBST() {
        bst.insert(5);
        bst.insert(7);
        assertEquals(7, bst.getRoot().getRight().getData());
    }

    @Test
    public void testInsertDuplicateBST() {
        bst.insert(5);
        bst.insert(5);
        assertNull(bst.getRoot().getLeft());
        assertNull(bst.getRoot().getRight());
    }

    @Test
    public void testSetAndGetRootBST() {
        TNode root = new TNode(5, 0, null, null, null);
        bst.setRoot(root);
        assertEquals(5, bst.getRoot().getData());
    }

    @Test
    public void testGetRootEmptyBST() {
        assertNull(bst.getRoot());
    }

    
    
    @Test
    public void testInsert() {
        BST tree = new BST();

        // Insert the root node
        TNode root = new TNode(5, 0, null, null, null);
        tree.insert(root);

        // Check that the root node was inserted correctly
        assertEquals(tree.getRoot(), root);

        // Insert a node that should be a left child
        TNode leftChild = new TNode(3, 0, null, null, null);
        tree.insert(leftChild);

        // Check that the left child was inserted correctly
        assertEquals(tree.getRoot().getLeft(), leftChild);
        assertEquals(tree.getRoot().getLeft().getParent(), tree.getRoot());

        // Insert a node that should be a right child
        TNode rightChild = new TNode(7, 0, null, null, null);
        tree.insert(rightChild);

        // Check that the right child was inserted correctly
        assertEquals(tree.getRoot().getRight(), rightChild);
        assertEquals(tree.getRoot().getRight().getParent(), tree.getRoot());

        // Insert a node that already exists in the tree
        tree.insert(rightChild);

        // Check that the duplicate node was not inserted again
        assertNull(tree.getRoot().getLeft().getRight());
    }


    @Before
    public void setUpBST() {
        bst = new BST(10);
        bst.getRoot().setLeft(new TNode(5, 0, bst.getRoot(), null, null));
        bst.getRoot().setRight(new TNode(15, 0, bst.getRoot(), null, null));
        bst.getRoot().getLeft().setLeft(new TNode(3, 0, bst.getRoot().getLeft(), null, null));
        bst.getRoot().getLeft().setRight(new TNode(7, 0, bst.getRoot().getLeft(), null, null));
        bst.getRoot().getRight().setLeft(new TNode(13, 0, bst.getRoot().getRight(), null, null));
        bst.getRoot().getRight().setRight(new TNode(17, 0, bst.getRoot().getRight(), null, null));
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        // Initialize BST and add nodes
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(7);
        
        // Delete node with one child
        bst.Delete(5);
        
        // Check that node was deleted and child was moved up
        TNode root = bst.getRoot();
        assertNotNull(root.getLeft()); // make sure left child is not null
        assertEquals(7, root.getLeft().getData());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        // Initialize BST and add nodes
        BST bst = new BST();
        bst.insert(10);
        bst.insert(13);
        bst.insert(15);
        bst.insert(12);
        
        // Delete node with two children
        bst.Delete(10);
        
        // Check that node was deleted and successor was moved up
        TNode root = bst.getRoot();
        assertNotNull(root); // make sure root is not null
        assertEquals(13, root.getData());
    }

    @Test
    public void testDeleteNonexistentNode() {
        // Initialize BST and add nodes
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        // Delete nonexistent node
        bst.Delete(20);
        
        // Check that tree was not modified
        TNode root = bst.getRoot();
        assertNotNull(root); // make sure root is not null
        assertEquals(10, root.getData());
        assertNull(root.getLeft().getRight()); // make sure other nodes are not modified
        assertNull(root.getRight().getLeft());
    }
    @Test
    public void testSearchValueExists() {
        // Initialize BST and add nodes
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        // Search for existing value
        TNode node = bst.Search(5);
        
        // Check that the correct node is returned
        assertNotNull(node);
        assertEquals(5, node.getData());
    }
    
    @Test
    public void testSearchValueDoesNotExist() {
        // Initialize BST and add nodes
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        // Search for nonexistent value
        TNode node = bst.Search(20);
        
        // Check that null is returned
        assertNull(node);
    }
    @Test
    public void testPrintInOrderEmptyTree() {
        // Initialize an empty BST
        BST bst = new BST();
        
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Print in-order traversal of BST
        bst.printInOrder();
        
        // Check that the correct output is produced
        assertEquals("Tree is empty\n", outContent.toString());
    }
    
    @Test
    public void testPrintInOrderNonemptyTree() {
        // Initialize BST and add nodes
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Print in-order traversal of BST
        bst.printInOrder();
        
        // Check that the correct output is produced
        assertEquals("In-order traversal: 5 10 15 \n", outContent.toString());
    }
    @Test
    public void testPrintBFOnEmptyTree() {
        BST bst = new BST();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        ((BST) bst).printBF();
        String expectedOutput = "Empty tree\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void testPrintBFOnTreeWithOneNode() {
        BST bst = new BST();
        bst.insert(5);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        bst.printBF();
        String expectedOutput = "Level 0: 5 \n";
        assertEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void testPrintBFOnTreeWithMultipleNodes() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        bst.printBF();
        String expectedOutput = "Level 0: 10 \nLevel 1: 5 15 \nLevel 2: 3 7 12 20 \n";
        assertEquals(expectedOutput, outContent.toString());
    }

//CDLL FILE TESTS
      
    @Test
    public void testInsertTailCDLL() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(list.getDLLSize(), 3);
        assertEquals(list.getDLLTail().getData(), 3);
    }


    @Test
    public void testDeleteTail() {
        CDLL list = new CDLL();
        DNode node = new DNode(5);
        list.insertHead(node);
        list.deleteTail();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
        assertTrue(list.isEmpty());
        assertTrue(list.isSorted());
    }

    @Test
    public void testDelete() {
        CDLL list = new CDLL();
        DNode node = new DNode(5);
        list.insertHead(node);
        list.delete(node);
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
        assertTrue(list.isEmpty());
        assertTrue(list.isSorted());
    }

    @Test
    public void testSearchCDLL() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        assertEquals(node2, list.search(new DNode(10)));
        assertNull(list.search(new DNode(20)));
    }
    
    private CDLL list;

    @Before
    public void setUpCDLL() throws Exception {
        list = new CDLL();
    }

    @Test
    public void testInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        list.insertHead(node1);
        assertEquals(node1, list.getDLLHead());
        assertEquals(node1, list.getDLLTail());
        assertEquals(1, list.getDLLSize());

        list.insertHead(node2);
        assertEquals(node2, list.getDLLHead());
        assertEquals(node1, list.getDLLTail());
        assertEquals(2, list.getDLLSize());

        list.insertHead(node3);
        assertEquals(node3, list.getDLLHead());
        assertEquals(node1, list.getDLLTail());
        assertEquals(3, list.getDLLSize());

        // Make sure the links are properly set
        assertEquals(node1, node2.getNext());
        assertEquals(node2, node1.getPrev());
        assertEquals(node2, node3.getNext());
        assertEquals(node3, node2.getPrev());
        assertEquals(node3, node1.getNext());
        assertEquals(node1, node3.getPrev());
    }
    
    @Test
    public void testSortedInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(3);
        DNode node3 = new DNode(2);

        // Insert first node
        list.sortedInsert(node1);
        assertEquals(node1, list.getDLLHead());
        assertEquals(node1, list.getDLLTail());
        assertEquals(1, list.getDLLSize());

        // Insert second node
        list.sortedInsert(node2);
        assertEquals(node1, list.getDLLHead());
        assertEquals(node2, list.getDLLTail());
        assertEquals(2, list.getDLLSize());

        // Insert third node
        list.sortedInsert(node3);
        assertEquals(node1, list.getDLLHead());
        assertEquals(node2, list.getDLLTail());
        assertEquals(3, list.getDLLSize());

        // Make sure the nodes are in the right order
        assertEquals(1, list.getDLLHead().getData());
        assertEquals(2, list.getDLLHead().getNext().getData());
        assertEquals(3, list.getDLLHead().getNext().getNext().getData());

        // Make sure the links are properly set
        assertEquals(node1, node3.getPrev());
        assertEquals(node3, node1.getNext());
        assertEquals(node3, node2.getPrev());
        assertEquals(node2, node3.getNext());
    }


}
