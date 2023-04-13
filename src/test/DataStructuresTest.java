package src.test;

// import all files
import src.main.java.mylib.datastructures.linear.*;
import src.main.java.mylib.datastructures.nodes.*;
import src.main.java.mylib.datastructures.trees.*;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.regex.*;
import java.beans.Transient;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Terminal Commands
 * main compilation: javac src/main/java/mylib/datastructures/linear/SLL.java
 * main execution: java src.main.java.mylib.datastructures.linear.SLL
 * App compilation: javac src/main/java/mylib/App.java
 * App execution: java src.main.java.mylib.App
 * test compilation: javac -cp .:src/lib/junit-4.13.2.jar:src/lib/hamcrest-core-1.3.jar src/test/DataStructuresTest.java
 * test execution: java -cp .:src/lib/junit-4.13.2.jar:src/lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore src.test.DataStructuresTest
 */

public class DataStructuresTest {

    // SLL Class Tests

    // SNode variables
    SNode startSNode = new SNode(1, null);
    SNode secondSNode = new SNode(2, null);
    SNode thirdSNode = new SNode(3, null);
    SNode fourthSNode = new SNode(4, null);
    SNode endSNode = new SNode(5, null);
    
    @Test
    //default constructor 
    public void testSLLDefaultConstructor() {
        SLL newFunction = new SLL();
        assertEquals(null,newFunction.getHead());
        assertEquals(null,newFunction.getTail());
        assertEquals(0,newFunction.getSize());
     }

    @Test
    //constructor with parameter
    public void testSLLConstructor() {
        SLL newFunction = new SLL(startSNode);
        assertEquals(startSNode,newFunction.getHead());
        assertEquals(startSNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testSLLGettersAndSetters() {
        SLL newFunction = new SLL(); 
        newFunction.setHead(startSNode);
        newFunction.setTail(endSNode);

        assertEquals(startSNode, newFunction.getHead());
        assertEquals(endSNode, newFunction.getTail());
     }

    @Test
    public void testSLLInsertHead() {
        SLL newFunction = new SLL();
        newFunction.insertHead(startSNode);
        assertEquals(startSNode,newFunction.getHead());
        assertEquals(startSNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testSLLInsertTail() {
        SLL newFunction = new SLL(startSNode);
        newFunction.insertTail(endSNode);
        assertEquals(5,newFunction.getTail().getValue());
        assertEquals(2,newFunction.getSize());
    }

    @Test
    public void testSLLInsert() {
        SLL newFunction = new SLL();
        newFunction.insert(startSNode, 1); // expected: 1
        assertEquals(startSNode, newFunction.getHead());
        assertEquals(startSNode, newFunction.getTail());

        newFunction.insert(secondSNode, 2); // expected: 1, 2
        assertEquals(secondSNode, newFunction.getHead().getNext());
        assertEquals(secondSNode, newFunction.getTail());

        newFunction.insert(thirdSNode, 3); // expected: 1, 2, 3
        assertEquals(thirdSNode, newFunction.getHead().getNext().getNext());
        assertEquals(thirdSNode, newFunction.getTail());

        newFunction.insert(fourthSNode, 2); // expected: 1, 4, 2, 3
        assertEquals(fourthSNode, newFunction.getHead().getNext());
        assertEquals(thirdSNode, newFunction.getTail());
    }

    @Test
    public void testSLLSortedInsert() {
        SLL newFunction = new SLL(startSNode); 
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);
        // expected: 1, 2, 3, 4, 5

        assertEquals(4,newFunction.getHead().getNext().getNext().getNext().getValue());
        assertEquals(5,newFunction.getSize());
    }

    @Test
    public void testSLLSort() {
        SLL newFunction = new SLL(startSNode); 
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        // before: 1, 3, 5, 2
        newFunction.sort();
        // after: 1, 2, 3, 5

        assertEquals(1,newFunction.getHead().getValue());
        assertEquals(2,newFunction.getHead().getNext().getValue());
        assertEquals(3,newFunction.getHead().getNext().getNext().getValue());
        assertEquals(5,newFunction.getTail().getValue());
        assertEquals(4,newFunction.getSize());
    }

    @Test
    public void testSLLSearchDoesNotExist() {
        SLL newFunction = new SLL(startSNode); 
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);

        SNode nodeNotExist = new SNode(30, null);
        assertNull(newFunction.search(nodeNotExist));
    }

    @Test
    public void testSLLSearchExists() {
        SLL newFunction = new SLL(startSNode); 
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);

        SNode nodeExists = new SNode(4, endSNode);
        assertNotNull(newFunction.search(nodeExists));

    }

    @Test
    public void testSLLDeleteHead() {
        SLL newFunction = new SLL(startSNode); 
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);

        newFunction.deleteHead();
        assertEquals(2, newFunction.getHead().getValue());
        assertEquals(4, newFunction.getSize());
     }

    @Test
    public void testSLLDeleteTail() {
        SLL newFunction = new SLL(secondSNode); 
        newFunction.insertTail(endSNode);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);
        // before: 2, 3, 4, 5

        newFunction.deleteTail();
        // after: 2, 3, 4
        assertEquals(4, newFunction.getTail().getValue());
        assertEquals(3, newFunction.getSize());
    }

    @Test
    public void testSLLDelete() { 
        SLL newFunction = new SLL(secondSNode); 
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);
        // before: 2, 3, 4

        newFunction.delete(thirdSNode);
        // after: 2, 4
        assertEquals(2, newFunction.getHead().getValue());
        assertEquals(4, newFunction.getTail().getValue());
        assertEquals(2, newFunction.getSize());
    }

    @Test
    public void testSLLClearAndIsEmpty() {
        SLL newFunction = new SLL(secondSNode); 
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);

        newFunction.clear();
        assertNull(newFunction.getHead());
        assertTrue(newFunction.isEmpty());
    }

    @Test
    public void testSLLPrint() {
        SLL newFunction = new SLL(startSNode); 
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);
        // list: 1, 2, 3, 4, 5

        String expectedOutput = "List length: 5\nSorted status: Sorted\nList content: 1, 2, 3, 4, 5\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        newFunction.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
     }


    // DLL Class Tests
    // DLL Node variables
    DNode startDNode = new DNode(1, null);
    DNode secondDNode = new DNode(2, null);
    DNode thirdDNode = new DNode(3, null);
    DNode fourthDNode = new DNode(4, null);
    DNode endDNode = new DNode(5, null);

    @Test
    //default constructor 
    public void testDLLDefaultConstructor() {
        DLL newFunction = new DLL();
        assertEquals(null,newFunction.getHead());
        assertEquals(null,newFunction.getTail());
        assertEquals(0,newFunction.getSize());
     }

    @Test
    //constructor with parameter
    public void testDLLConstructor() {
        DLL newFunction = new DLL(startDNode);
        assertEquals(startDNode,newFunction.getHead());
        assertEquals(startDNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testDLLGettersAndSetters() {
        DLL newFunction = new DLL();
        newFunction.setHead(startDNode);
        newFunction.setTail(endDNode);

        assertEquals(startDNode, newFunction.getHead());
        assertEquals(endDNode, newFunction.getTail());
     }

    @Test
    public void testDLLInsertHead() {
        DLL newFunction = new DLL();
        newFunction.insertHead(startDNode);
        assertEquals(startDNode,newFunction.getHead());
        assertEquals(startDNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testDLLInsertTail() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        assertEquals(5,newFunction.getTail().getData());
        assertEquals(2,newFunction.getSize());
    }

    @Test
    public void testDLLInsert() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        // expected: 1, 3, 5, 2

        assertEquals(2,newFunction.getTail().getData()); 
        assertEquals(3,newFunction.getHead().getNext().getData());
        assertEquals(4,newFunction.getSize());
    }
 
    @Test
    public void testDLLSortedInsert() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);
        // expected: 1, 2, 3, 4, 5

        assertEquals(4,newFunction.getHead().getNext().getNext().getNext().getData());
        assertEquals(5,newFunction.getSize());
    }

    @Test
    public void testDLLSort() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        // before: 1, 3, 5, 2
        newFunction.sort();
        // after: 1, 2, 3, 5

        assertEquals(1,newFunction.getHead().getData());
        assertEquals(2,newFunction.getHead().getNext().getData());
        assertEquals(3,newFunction.getHead().getNext().getNext().getData());
        assertEquals(5,newFunction.getTail().getData());
        assertEquals(4,newFunction.getSize());
    }

    @Test
    public void testDLLSearchDoesNotExist() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);

        DNode nodeNotExist = new DNode(30, null);
        assertNull(newFunction.search(nodeNotExist));
    }

    @Test
    public void testDLLSearchExists() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);

        DNode nodeExists = new DNode(3, null);
        assertNotNull(newFunction.search(nodeExists));

    }

    @Test
    public void testDLLDeleteHead() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);

        newFunction.deleteHead();
        assertEquals(2, newFunction.getHead().getData());
        assertEquals(4, newFunction.getSize());
     }

    @Test
    public void testDLLDeleteTail() {
        DLL newFunction = new DLL(secondDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);
        // before: 2, 3, 4, 5

        newFunction.deleteTail();
        // after: 2, 3, 4
        assertEquals(4, newFunction.getTail().getData());
        assertEquals(3, newFunction.getSize());
    }

    @Test
    public void testDLLDelete() { 
        DLL newFunction = new DLL(secondDNode);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);
        // before: 2, 3, 4

        newFunction.delete(thirdDNode);
        // after: 2, 4
        
        assertEquals(2, newFunction.getHead().getData());
        assertEquals(4, newFunction.getTail().getData());
        assertEquals(2, newFunction.getSize());
    }

    @Test
    public void testDLLClearAndIsEmpty() {
        DLL newFunction = new DLL(secondDNode);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);

        newFunction.clear();
        assertNull(newFunction.getHead());
        assertTrue(newFunction.isEmpty());
    }

    @Test
    public void testDLLPrint() {
        DLL newFunction = new DLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);
        // list: 1, 2, 3, 4, 5

        String expectedOutput = "List length: 5\nSorted status: Sorted\nList content: 1, 2, 3, 4, 5\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        newFunction.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
     }


    // CSLL Class Tests
    
    @Test
    //default constructor 
    public void testCSLLDefaultConstructor() {
        CSLL newFunction = new CSLL();
        assertEquals(null,newFunction.getHead());
        assertEquals(null,newFunction.getTail());
        assertEquals(0,newFunction.getSize());
     }

    @Test
    //constructor with parameter
    public void testCSLLConstructor() {
        CSLL newFunction = new CSLL(startSNode);
        assertEquals(startSNode,newFunction.getHead());
        assertEquals(startSNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testCSLLGettersAndSetters() {
        CSLL newFunction = new CSLL();
        newFunction.setTail(endSNode);
        assertEquals(endSNode, newFunction.getTail());
    }

    @Test
    public void testCSLLInsertHeadEmptyList() {
        // insert in empty list
        CSLL newFunctionEmpty = new CSLL();
        newFunctionEmpty.insertHead(startSNode);
        assertEquals(startSNode, newFunctionEmpty.getHead());
        assertEquals(startSNode, newFunctionEmpty.getTail().getNext());
        assertEquals(startSNode, newFunctionEmpty.getTail());
    }

    @Test
    public void testCSLLInsertHeadFullList() {
        // insert in non-empty list
        CSLL newFunctionFull = new CSLL(startSNode);
        newFunctionFull.insert(thirdSNode, 2);
        newFunctionFull.insertHead(secondSNode);
        // expected: 2, 1, 3
        assertEquals(secondSNode, newFunctionFull.getHead());
        assertEquals(startSNode, newFunctionFull.getHead().getNext());
        assertEquals(thirdSNode, newFunctionFull.getTail());
        assertEquals(secondSNode, newFunctionFull.getTail().getNext());
    }
    
    @Test
    public void testCSLLInsertTailEmptyList() {
        // insert in empty list
        CSLL newFunctionEmpty = new CSLL();
        newFunctionEmpty.insertTail(endSNode);
        assertEquals(endSNode, newFunctionEmpty.getHead());
        assertEquals(endSNode, newFunctionEmpty.getTail());
        assertEquals(endSNode, newFunctionEmpty.getTail().getNext());

        assertEquals(5, newFunctionEmpty.getTail().getValue());
        assertEquals(1, newFunctionEmpty.getSize());
    }

    @Test
    public void testCSLLInsertTailFullList() {
        // insert in non-empty list
        CSLL newFunctionFull = new CSLL(startSNode);
        newFunctionFull.insert(secondSNode, 2);
        newFunctionFull.insert(thirdSNode, 3);
        newFunctionFull.insertTail(endSNode);
        // expected: 1, 2, 3, 5
        assertEquals(startSNode, newFunctionFull.getHead());
        assertEquals(endSNode, newFunctionFull.getTail());
        assertEquals(startSNode, newFunctionFull.getTail().getNext());
        assertEquals(5, newFunctionFull.getTail().getValue());
    }

    @Test
    public void testCSLLInsert() {
        CSLL newFunction = new CSLL();
        newFunction.insert(startSNode, 1); // expected: 1
        assertEquals(startSNode, newFunction.getHead());
        assertEquals(startSNode, newFunction.getTail().getNext());
        
        newFunction.insert(secondSNode, 2); // expected: 1, 2
        assertEquals(secondSNode, newFunction.getHead().getNext());
        assertEquals(secondSNode, newFunction.getTail());
        assertEquals(startSNode, newFunction.getTail().getNext());

        newFunction.insert(thirdSNode, 3); // expected: 1, 2, 3
        assertEquals(thirdSNode, newFunction.getHead().getNext().getNext());
        assertEquals(startSNode, newFunction.getTail().getNext());

        newFunction.insert(fourthSNode, 2); // expected: 1, 4, 2, 3
        assertEquals(fourthSNode, newFunction.getHead().getNext());
        assertEquals(startSNode, newFunction.getTail().getNext());
    }

    @Test
    public void testCSLLIndexOf() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insert(secondSNode, 2);
        newFunction.insert(thirdSNode, 3);
        newFunction.insert(fourthSNode, 4);
        newFunction.insert(endSNode, 5);
        // expected: 1, 2, 3, 4, 5

        //assertTrue(newFunction.isSorted());
        assertEquals(0, newFunction.indexOf(startSNode.getValue()));
        assertEquals(1, newFunction.indexOf(secondSNode.getValue()));
        assertEquals(2, newFunction.indexOf(thirdSNode.getValue()));
        assertEquals(3, newFunction.indexOf(fourthSNode.getValue()));
        assertEquals(4, newFunction.indexOf(endSNode.getValue()));
    }

    @Test
    public void testCSLLIsSorted() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insert(secondSNode, 2);
        newFunction.insert(thirdSNode, 3);
        newFunction.insert(fourthSNode, 4);
        newFunction.insert(endSNode, 5);
        // expected: 1, 2, 3, 4, 5
        
        assertTrue(newFunction.isSorted());
    }

    @Test
    public void testCSLLSort() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        // before: 1, 3, 5, 2
        newFunction.sort();
        // after: 1, 2, 3, 5

        assertEquals(1, newFunction.getHead().getValue());
        assertEquals(2, newFunction.getHead().getNext().getValue());
        assertEquals(3, newFunction.getHead().getNext().getNext().getValue());
        assertEquals(5, newFunction.getHead().getNext().getNext().getNext().getValue());
        assertEquals(1, newFunction.getHead().getNext().getNext().getNext().getNext().getValue()); // looping back around
    }

    @Test
    public void testCSLLSortedInsert() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 2);
        newFunction.insert(thirdSNode, 2);
        // before: 1, 3, 2, 5
        newFunction.sortedInsert(fourthSNode);
        // expected: 1, 2, 3, 4, 5

        assertEquals(1, newFunction.getHead().getValue());
        assertEquals(2, newFunction.getHead().getNext().getValue());
        assertEquals(3, newFunction.getHead().getNext().getNext().getValue());
        assertEquals(4, newFunction.getHead().getNext().getNext().getNext().getValue());
        assertEquals(5, newFunction.getHead().getNext().getNext().getNext().getNext().getValue());
        assertEquals(5, newFunction.getSize());
    }

    @Test
    public void testCSLLSearchDoesNotExist() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 2);
        newFunction.insert(thirdSNode, 2);
        // expected: 1, 3, 2, 5

        SNode nodeNotExist = new SNode(30, null);
        assertNull(newFunction.search(nodeNotExist));
    }

    @Test
    public void testCSLLSearchExists() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);

        SNode nodeExists = new SNode(4, endSNode);
        assertNotNull(newFunction.search(nodeExists));
    }

    @Test
    public void testCSLLDeleteHead() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        // before: 1, 3, 5, 2

        newFunction.deleteHead();
        // after: 3, 5, 2
        assertEquals(thirdSNode, newFunction.getHead());
        assertEquals(3, newFunction.getHead().getValue());
        assertEquals(3, newFunction.getSize());
     }

    @Test
    public void testCSLLDeleteTail() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(thirdSNode, 2);
        newFunction.insert(fourthSNode, 2);
        // before: 1, 4, 3, 5
        newFunction.deleteTail();
        // after: 1, 4, 3
        assertEquals(thirdSNode, newFunction.getTail());
        assertEquals(3, newFunction.getTail().getValue());
        assertEquals(3, newFunction.getSize());
    }

    @Test
    public void testCSLLDelete() { 
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(thirdSNode, 2);
        newFunction.insert(fourthSNode, 2);
        // before: 1, 4, 3, 5
        assertEquals(4, newFunction.getHead().getNext().getValue());
        assertEquals(fourthSNode, newFunction.getHead().getNext());

        newFunction.delete(fourthSNode);
        // before: 1, 3, 5
        assertEquals(3, newFunction.getHead().getNext().getValue());
        assertEquals(thirdSNode, newFunction.getHead().getNext());
        assertEquals(3, newFunction.getSize());
    }

    @Test
    public void testCSLLClearAndIsEmpty() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insert(thirdSNode, 2);
        newFunction.sortedInsert(fourthSNode);

        newFunction.clear();
        assertNull(newFunction.getHead());
        assertTrue(newFunction.isEmpty());
    }

    @Test
    public void testCSLLPrint() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        // list: 1, 3, 5, 2

        String expectedOutput = "List content: \n[ 1 3 5 2 ]\nList length: 4\nCircular: true\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        newFunction.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
     }
}
