package test;
import main.java.mylib.datastructures.linear.CSLL;
import main.java.mylib.datastructures.linear.DLL;
import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.AVL;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.NoSuchElementException;

/* TERMINAL COMMANDS IGNORE FOR NOW USE VS CODE TESTING
 * Test Compilation of linear folder: javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/main/java/mylib/datastructures/linear/*.java
 * Test Compilation of nodes folder: javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/main/java/mylib/datastructures/nodes/*.java 
 * Test Compilation of test folder: javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3. src.test/*.java 
 * Test Run: java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore src.test.DatastructuresTest
 */

public class DatastructuresTest {
    private SLL list;

    @Test
    public void testGetHeadEmptyList() {
        list = new SLL();
        assertNull(list.getHead());
    }

    @Test
    public void testDefaultConstructor() {
        list = new SLL();
        assertNull(list.getHead());
    }

    @Test
    public void testOverloadConstructor() {
        list = new SLL();
        SNode node = new SNode(1);
        list = new SLL(node);
        assertEquals(node, list.getHead());
    }

    @Test
    public void testInsertHead() {
        list = new SLL();
        SNode node = new SNode(1);
        list.insertHead(node);
        assertEquals(node, list.getHead());
    }

    @Test
    public void testInsertTail() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node1);
        list.insertTail(node2);
        assertEquals(node2, list.getTail());
    }

    @Test
    public void testInsert() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        assertEquals(node2, list.getHead().getNext());
    }

    @Test
    public void testSortedInsert() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.sortedInsert(node2);
        assertEquals(node2, list.getHead().getNext());
    }
    
    @Test
    public void testSearch() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node1);
        list.insertTail(node2);
        assertEquals(node1, list.search(node1));
        assertEquals(null, list.search(new SNode(3)));
    }

    @Test
    public void testDeleteHead() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node1);
        list.insertTail(node2);
        list.deleteHead();
        assertEquals(node2, list.getHead());
    }
    
    @Test
    public void testDeleteTail() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node1);
        list.insertTail(node2);
        list.deleteTail();
        assertEquals(node1, list.getTail());
    }

    @Test
    public void testDelete() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node1);
        list.insert(node2, 1);
        list.insertTail(node3);
        list.delete(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
    }

    @Test
    public void testSort() {
        // Create a linked list with unsorted elements
        SLL list = new SLL();
        list.insertHead(new SNode(5));
        list.insertHead(new SNode(2));
        list.insertHead(new SNode(1));

        // Sort the list
        list.sort();

        // Check if the list is sorted in ascending order
        assertTrue(list.isSorted());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().getNext().getData());
        assertEquals(5, list.getTail().getData());
    }

    @Test
    public void testClear() {
        // Create a linked list with some elements
        SLL list = new SLL(new SNode(1));
        // list.insertTail(new DNode(2));

        // Clear the list
        list.clear();

        // Check if the list is empty
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testPrint() {
        SLL list = new SLL();
        list.insertHead(new SNode(1));
        list.insertTail(new SNode(3));
        list.insertTail(new SNode(2));
        list.sort();
        String expectedOutput = "List length: 3\nSorted: Yes\nList content: 1 2 3 \n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        list.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    // Testing DLL.java

    // testing both default and overloaded constructor
    @Test
    public void testDLLConstructor() {
        // Test default constructor
        DLL list1 = new DLL();
        assertEquals(list1.getDLLSize(), 0);
        assertNull(list1.getDLLHead());
        assertNull(list1.getDLLTail());
        
        // Test overload constructor
        DNode node = new DNode(5);
        DLL list2 = new DLL(node);
        assertEquals(list2.getDLLSize(), 1);
        assertEquals(list2.getDLLHead().getData(), 5);
        assertEquals(list2.getDLLTail().getData(), 5);
    }

    @Test
    public void testDLLInsertHead() {
        // Create a new DLL and add a few nodes
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertHead(node3);
        
        // Check that the head is the last node inserted
        assertEquals(dll.getDLLHead(), node3);
        
        // Check that the head's next node is the second last node inserted
        assertEquals(dll.getDLLHead().getNext(), node2);
        
        // Check that the size of the list is correct
        assertEquals(dll.getDLLSize(), 3);
    }

    @Test
    public void testDLLInsertTail() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(list.getDLLSize(), 3);
        assertEquals(list.getDLLHead().getData(), 1);
        assertEquals(list.getDLLTail().getData(), 3);
        assertEquals(list.getDLLHead().getNext().getData(), 2);
        assertEquals(list.getDLLTail().getPrev().getData(), 2);
    }

    @Test
    public void testDLLInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        DLL dll = new DLL();
        dll.insert(node1, 0);
        assertEquals(1, dll.getDLLSize());
        assertEquals(node1, dll.getDLLHead());
        assertEquals(node1, dll.getDLLTail());

        dll.insert(node2, 1);
        assertEquals(2, dll.getDLLSize());
        assertEquals(node1, dll.getDLLHead());
        assertEquals(node2, dll.getDLLTail());

        dll.insert(node3, 1);
        assertEquals(3, dll.getDLLSize());
        assertEquals(node1, dll.getDLLHead());
        assertEquals(node2, dll.getDLLTail());
        assertEquals(node3, node1.getNext());
        assertEquals(node1, node3.getPrev());
        assertEquals(node3, node2.getPrev());
        assertEquals(node2, node3.getNext());

        dll.insert(node4, 3);
        assertEquals(4, dll.getDLLSize());
        assertEquals(node1, dll.getDLLHead());
        assertEquals(node4, dll.getDLLTail());
        assertEquals(node2, node4.getPrev());
        assertEquals(node4, node2.getNext());
        assertEquals(node3, node4.getPrev().getPrev());
        assertEquals(node4, node3.getNext().getNext());
    }


    @Test
    public void testDLLSortedInsert() {
        DLL list = new DLL();
        list.sortedInsert(new DNode(2));
        list.sortedInsert(new DNode(1));
        list.sortedInsert(new DNode(5));
        list.sortedInsert(new DNode(4));
        list.sortedInsert(new DNode(3));
        
        assertEquals(5, list.getDLLSize());
        assertEquals(1, list.getDLLHead().getData());
        assertEquals(5, list.getDLLTail().getData());
        
        DNode current = list.getDLLHead();
        while (current != null) {
            if (current.getNext() != null) {
                assertTrue(current.getData() <= current.getNext().getData());
            }
            current = current.getNext();
        }
    }

    @Test
    public void testDLLSearch() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertTail(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);

        // Search for a node that exists in the list
        DNode result1 = dll.search(node2);
        assertEquals(node2, result1);

        // Search for a node that doesn't exist in the list
        DNode result2 = dll.search(new DNode(4));
        assertNull(result2);
    }

    @Test
    public void deleteDLLHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node3);
        dll.insertHead(node2);
        dll.insertHead(node1);

        assertEquals(node1, dll.getDLLHead());
        dll.deleteHead();
        assertEquals(node2, dll.getDLLHead());
        dll.deleteHead();
        assertEquals(node3, dll.getDLLHead());
        dll.deleteHead();
        assertNull(dll.getDLLHead());
        assertNull(dll.getDLLTail());

        assertThrows(NoSuchElementException.class, () -> {
            dll.deleteHead();
        });
    }

    @Test
    public void deleteDLLTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node3);
        dll.insertHead(node2);
        dll.insertHead(node1);

        assertEquals(node3, dll.getDLLTail());
        dll.deleteTail();
        assertEquals(node2, dll.getDLLTail());
        dll.deleteTail();
        assertEquals(node1, dll.getDLLTail());
        dll.deleteTail();
        assertNull(dll.getDLLHead());
        assertNull(dll.getDLLTail());

        assertThrows(NoSuchElementException.class, () -> {
            dll.deleteTail();
        });
    }

    @Test
    public void deleteDLL() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node3);
        dll.insertHead(node2);
        dll.insertHead(node1);

        dll.delete(node2);
        assertEquals(node1.getNext(), node3);
        assertEquals(node3.getPrev(), node1);

        dll.delete(node3);
        assertEquals(node1.getNext(), null);
        assertEquals(dll.getDLLTail(), node1);

        dll.delete(node1);
        assertNull(dll.getDLLHead());
        assertNull(dll.getDLLTail());

        assertThrows(NoSuchElementException.class, () -> {
            dll.delete(node1);
        });
    }

    @Test
    public void testDLLSort() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(3));
        dll.insertHead(new DNode(1));
        dll.insertHead(new DNode(4));
        dll.insertHead(new DNode(2));
        
        dll.sort();
        
        DNode current = dll.getDLLHead();
        while (current != null) {
            if (current.getNext() != null) {
                assertTrue(current.getData() <= current.getNext().getData());
            }
            current = current.getNext();
        }
    }

    @Test 
    public void testDLLclear() {
        DLL dll = new DLL();
        dll.insertTail(new DNode(3));
        dll.insertTail(new DNode(1));
        dll.insertTail(new DNode(4));

        assertEquals(3, dll.getDLLSize());
        dll.clear();
        assertEquals(0, dll.getDLLSize());
        assertNull(dll.getDLLHead());
        assertNull(dll.getDLLTail());
    }

    @Test
    public void testDLLPrint() {
        DLL list = new DLL();
        list.insertHead(new DNode(1));
        list.insertTail(new DNode(3));
        list.insertTail(new DNode(2));
        list.sort();
        String expectedOutput = "List length: 3\nSorted: Yes\nList content: 1 2 3 \n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        list.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    // TESTING CSLL.java
    @Test
    public void testCSLLDefaultConstructor() {
        CSLL list = new CSLL();
        assertEquals(0, list.getCSLLSize());
        assertNull(list.getCSLLHead());
        assertNull(list.getCSLLTail());
    }
    
    @Test
    public void testCSLLSingleItemConstructor() {
        // create a new node with value 1
        SNode node = new SNode(1);
        // create a new circular singly linked list with the node as head
        CSLL list = new CSLL(node);
        // assert that the head node is the same as the created node
        assertEquals(node, list.getCSLLHead());
        // assert that the tail node is the same as the head node
        assertEquals(node, list.getCSLLTail());
        // assert that the size of the list is 1
        assertEquals(1, list.getCSLLSize());
        // assert that the next node of the head node is the head node itself
        assertEquals(node, list.getCSLLHead().getNext());
    }


    @Test
    public void testCSLLInsertHead() {
        CSLL list = new CSLL(); // create new list
        SNode node1 = new SNode(1); // create new node with data 1
        SNode node2 = new SNode(2); // create new node with data 2
        SNode node3 = new SNode(3); // create new node with data 3
        
        // Insert node1 at head
        list.insertHead(node1);
        assertEquals(list.getCSLLHead(), node1);
        assertEquals(list.getCSLLTail(), node1);
        assertEquals(list.getCSLLSize(), 1);
        
        // Insert node2 at head
        list.insertHead(node2);
        assertEquals(list.getCSLLHead(), node2);
        assertEquals(list.getCSLLTail(), node1);
        assertEquals(list.getCSLLSize(), 2);
        
        // Insert node3 at head
        list.insertHead(node3);
        assertEquals(list.getCSLLHead(), node3);
        assertEquals(list.getCSLLTail(), node1);
        assertEquals(list.getCSLLSize(), 3);
    }

    @Test
    public void testCSLLInsertTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        
        list.insertTail(node1);
        assertEquals("The tail should be node1", node1, list.getCSLLTail());
        assertEquals("The head should be node1", node1, list.getCSLLHead());
        assertEquals("The size should be 1", 1, list.getCSLLSize());
        
        list.insertTail(node2);
        assertEquals("The tail should be node2", node2, list.getCSLLTail());
        assertEquals("The head should be node1", node1, list.getCSLLHead());
        assertEquals("The size should be 2", 2, list.getCSLLSize());
        
        list.insertTail(node3);
        assertEquals("The tail should be node3", node3, list.getCSLLTail());
        assertEquals("The head should be node1", node1, list.getCSLLHead());
        assertEquals("The size should be 3", 3, list.getCSLLSize());
        assertEquals("The next node after node3 should be node1", node1, node3.getNext());
    }

    @Test
    public void testCSLLInsert() {
        // Initialize a new CSLL
        CSLL list = new CSLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(3));
        list.insertTail(new SNode(5));

        // Insert a new node at index 1
        SNode nodeToInsert = new SNode(4);
        list.insert(nodeToInsert, 1);

        // Verify that the new node is inserted at the correct index
        assertEquals(nodeToInsert, list.getCSLLNode(1));
        assertEquals(4, list.getCSLLSize());

        // Insert a new node at index 0
        nodeToInsert = new SNode(0);
        list.insert(nodeToInsert, 0);

        // Verify that the new node is inserted at the correct index
        assertEquals(nodeToInsert, list.getCSLLNode(0));
        assertEquals(5, list.getCSLLSize());

        // Insert a new node at the end of the list
        nodeToInsert = new SNode(6);
        list.insert(nodeToInsert, list.getCSLLSize());

        // Verify that the new node is inserted at the correct index
        assertEquals(nodeToInsert, list.getCSLLNode(5));
        assertEquals(6, list.getCSLLSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCSLLInsertInvalidIndex() {
        // Initialize a new CSLL
        CSLL list = new CSLL();
        list.insertTail(new SNode(1));

        // Try to insert a new node at an invalid index
        SNode nodeToInsert = new SNode(2);
        list.insert(nodeToInsert, 3);
    }

    @Test
    public void testCSLLGetNode() {
        // Initialize a new CSLL
        CSLL list = new CSLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(2));
        list.insertTail(new SNode(3));

        // Verify that getNode returns the correct node at the specified index
        assertEquals(list.getCSLLNode(0).getData(), 1);
        assertEquals(list.getCSLLNode(1).getData(), 2);
        assertEquals(list.getCSLLNode(2).getData(), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCSLLGetNodeInvalidIndex() {
        // Initialize a new CSLL
        CSLL list = new CSLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(2));

        // Try to get a node at an invalid index
        list.getCSLLNode(3);
    }

    @Test
    public void testCSLLSortedInsert() {
        // Create a new circular singly linked list and insert some nodes
        CSLL list = new CSLL();
        list.sortedInsert(new SNode(5));
        list.sortedInsert(new SNode(2));
        list.sortedInsert(new SNode(10));
        list.sortedInsert(new SNode(7));
        list.sortedInsert(new SNode(1));

        // Check that the list is now sorted
        assertTrue(list.isSorted());

        // Check that the list contains the correct elements in the correct order
        assertEquals(1, list.getCSLLNode(0).getData());
        assertEquals(2, list.getCSLLNode(1).getData());
        assertEquals(5, list.getCSLLNode(2).getData());
        assertEquals(7, list.getCSLLNode(3).getData());
        assertEquals(10, list.getCSLLNode(4).getData());
    }

    @Test
    public void testIsSorted() {
        // Create a new circular singly linked list and insert some nodes
        CSLL list = new CSLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(2));
        list.insertTail(new SNode(3));
        list.insertTail(new SNode(4));

        // Check that the list is sorted
        assertTrue(list.isCSLLSorted());

        // Insert a node out of order
        list.insertTail(new SNode(2));

        // Check that the list is no longer sorted
        assertFalse(list.isCSLLSorted());
    }

    @Test
    public void testCSLLSearch() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(4);
        
        // Test searching an empty list
        assertNull(list.search(node1));
        
        // Test searching for a node that doesn't exist in the list
        list.insertTail(node1);
        list.insertTail(node2);
        assertNull(list.search(node3));
        
        // Test searching for a node that exists in the list
        list.insertTail(node3);
        list.insertTail(node4);
        assertEquals(node2, list.search(node2));
    }

    @Test
    public void testCSLLDeleteHead() {
        // Create a new circular singly linked list and add some nodes
        CSLL list = new CSLL();
        list.insertHead(new SNode(5));
        list.insertHead(new SNode(10));
        list.insertHead(new SNode(15));
        list.insertHead(new SNode(20));
        
        // Check the list size before deleting the head
        assertEquals(4, list.getCSLLSize());
        
        // Delete the head and check that the size has been updated
        list.deleteHead();
        assertEquals(3, list.getCSLLSize());
        
        // Check that the head has been updated correctly
        assertEquals(15, list.getCSLLHead().getData());
        
        // Check that the tail has been updated correctly
        assertEquals(5, list.getCSLLTail().getData());
        
        // Check that the list is still circular
        assertEquals(list.getCSLLTail().getNext(), list.getCSLLHead());
    }

    @Test
    public void testCSLLDeleteTail() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(2));
        list.insertHead(new SNode(3));
        list.deleteTail();
        assertEquals(2, list.getCSLLSize());
        assertEquals(3, list.getCSLLHead().getData());
        assertEquals(2, list.getCSLLTail().getData());
        list.deleteTail();
        assertEquals(1, list.getCSLLSize());
        assertEquals(3, list.getCSLLHead().getData());
        assertEquals(3, list.getCSLLTail().getData());
        list.deleteTail();
        assertEquals(0, list.getCSLLSize());
        assertNull(list.getCSLLHead());
        assertNull(list.getCSLLTail());
        try {
            list.deleteTail();
            fail("Expected NoSuchElementException not thrown");
        } catch (NoSuchElementException e) {
            // Expected
        }
    }

    @Test
    public void testCSLLDelete() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(2));
        list.insertHead(new SNode(3));
        list.insertHead(new SNode(4));
        
        SNode nodeToDelete = new SNode(2);
        
        list.delete(nodeToDelete);
        
        assertEquals(3, list.getCSLLSize());
        assertNotNull(list.search(new SNode(4)));
        assertNotNull(list.search(new SNode(3)));
        assertNull(list.search(new SNode(2)));
        assertNotNull(list.search(new SNode(1)));
    }

    @Test
    public void testCSLLSort() {
        // Create an unsorted list
        CSLL list = new CSLL();
        list.insertHead(new SNode(3));
        list.insertHead(new SNode(5));
        list.insertHead(new SNode(2));
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(4));

        // Sort the list
        list.sort();

        // Verify that the list is sorted
        assertTrue(list.isCSLLSorted());

        // Verify that the list contains the correct values in the correct order
        assertEquals(1, list.getCSLLHead().getData());
        assertEquals(2, list.getCSLLHead().getNext().getData());
        assertEquals(3, list.getCSLLHead().getNext().getNext().getData());
        assertEquals(4, list.getCSLLHead().getNext().getNext().getNext().getData());
        assertEquals(5, list.getCSLLTail().getData());
    }

    @Test
    public void testCSLLClear() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(2));
        list.insertHead(new SNode(3));
        
        assertEquals(3, list.getCSLLSize());
        
        list.clear();
        
        assertEquals(0, list.getCSLLSize());
        assertNull(list.getCSLLHead());
        assertNull(list.getCSLLTail());
    }

    @Test
    public void testCSLLPrint() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        list.insertTail(new SNode(3));
        list.insertTail(new SNode(2));
        list.sort();
        String expectedOutput = "List length: 3\nSorted: Yes\nList content: 1 2 3 \n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        list.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    // TESTING AVL
    @Test
    public void testAVLConstructor() {
        AVL avl = new AVL();
        assertNull(avl.getRoot());
    }
    
    @Test
    public void testAVLConstructorWithSingleNode() {
        AVL avl = new AVL(5);
        assertEquals(5, avl.getRoot().getData());
    }
    
    // testing with tree that needs right rotation
    @Test
    public void testAVLConstructorWithTNode() {
        TNode root = new TNode(3, 2, null, null, null);
        TNode L = new TNode(1, 0, null, null, null);
        TNode node2 = new TNode(2, 1, root, L, null);
        root.setLeft(node2);
        L.setParent(node2);

        AVL avl = new AVL(root);
        assertEquals(2, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getLeft().getData());
        assertEquals(3, avl.getRoot().getRight().getData());
    }

    // testing setters and getters
    @Test
    public void testSetAndGetRoot() {
        AVL avl = new AVL();
        TNode root = new TNode(5, 0, null, null, null);
        avl.setRoot(root);
        assertEquals(root, avl.getRoot());
    }
    
    @Test
    public void testSetRootWithChildren() {
        AVL avl = new AVL();
        TNode root = new TNode(5, 0, null, null, null);
        TNode left = new TNode(3, 0, null, null, null);
        TNode right = new TNode(7, 0, null, null, null);
        left.setParent(root);
        right.setParent(root);
        root.setLeft(left);
        root.setRight(right);
        avl.setRoot(root);
        assertEquals(root, avl.getRoot());
        assertEquals(left, avl.getRoot().getLeft());
        assertEquals(right, avl.getRoot().getRight());
    }

    // Test insert(int val) method
    
    @Test
    public void testInsertOneValue() {
        AVL avl = new AVL();
        avl.insert(5);
        assertEquals(5, avl.getRoot().getData());
    }
    
    @Test
    public void testInsertTwoValues() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(10);
        assertEquals(5, avl.getRoot().getData());
        assertEquals(10, avl.getRoot().getRight().getData());
    }
    
    @Test
    public void testInsertMultipleValues() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(10);
        avl.insert(3);
        avl.insert(7);
        avl.insert(12);
        avl.insert(1);
        avl.insert(4);
        assertEquals(5, avl.getRoot().getData());
        assertEquals(3, avl.getRoot().getLeft().getData());
        assertEquals(1, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(4, avl.getRoot().getLeft().getRight().getData());
        assertEquals(10, avl.getRoot().getRight().getData());
        assertEquals(7, avl.getRoot().getRight().getLeft().getData());
        assertEquals(12, avl.getRoot().getRight().getRight().getData());
    }
    
    // Test insert(TNode node) method
    
    @Test
    public void testInsertSingleNode() {
        AVL avl = new AVL();
        TNode node = new TNode(5, 0, null, null, null);
        avl.insert(node);
        assertEquals(5, avl.getRoot().getData());
    }
    
    @Test
    public void testInsertMultipleNodes() {
        AVL avl = new AVL();
        TNode node1 = new TNode(5, 0, null, null, null);
        TNode node2 = new TNode(10, 0, null, null, null);
        TNode node3 = new TNode(3, 0, null, null, null);
        TNode node4 = new TNode(7, 0, null, null, null);
        TNode node5 = new TNode(12, 0, null, null, null);
        TNode node6 = new TNode(1, 0, null, null, null);
        TNode node7 = new TNode(4, 0, null, null, null);
        avl.insert(node1);
        avl.insert(node2);
        avl.insert(node3);
        avl.insert(node4);
        avl.insert(node5);
        avl.insert(node6);
        avl.insert(node7);
        assertEquals(5, avl.getRoot().getData());
        assertEquals(3, avl.getRoot().getLeft().getData());
        assertEquals(1, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(4, avl.getRoot().getLeft().getRight().getData());
        assertEquals(10, avl.getRoot().getRight().getData());
        assertEquals(7, avl.getRoot().getRight().getLeft().getData());
        assertEquals(12, avl.getRoot().getRight().getRight().getData());
    }

}
