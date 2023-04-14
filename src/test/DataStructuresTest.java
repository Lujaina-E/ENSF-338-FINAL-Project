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

    /* SLL Class Tests */

    // SNode variables
    SNode startSNode = new SNode(1);
    SNode secondSNode = new SNode(2);
    SNode thirdSNode = new SNode(3);
    SNode fourthSNode = new SNode(4);
    SNode endSNode = new SNode(5);
    
    @Test 
    public void testSLLDefaultConstructor() {
        SLL newList = new SLL();
        assertEquals(null,newList.getHead());
        assertEquals(null,newList.getTail());
        assertEquals(0,newList.getSize());
    }

    @Test 
    public void testSLLConstructor() {
        SLL newList = new SLL(startSNode);
        assertEquals(startSNode,newList.getHead());
        assertEquals(startSNode,newList.getTail());
        assertEquals(1,newList.getSize());
    }

    @Test
    public void testSLLGettersAndSetters() {
        SLL newList = new SLL(); 
        newList.setHead(startSNode);
        newList.setTail(endSNode);
        newList.setSize(2);

        assertEquals(startSNode, newList.getHead());
        assertEquals(endSNode, newList.getTail());
        assertEquals(2, newList.getSize());
    }

    @Test
    public void testSLLInsertHead() {
        // scenario 1: empty list
        SLL emptyList = new SLL();
        emptyList.insertHead(startSNode);
        assertEquals(startSNode,emptyList.getHead());
        assertEquals(startSNode,emptyList.getTail());
        assertEquals(1,emptyList.getSize());

        // scenario 2: if head == node
        SLL listInsertSameHead = new SLL(startSNode);
        listInsertSameHead.insertHead(startSNode);
        assertEquals(startSNode,listInsertSameHead.getHead());
        assertEquals(startSNode,listInsertSameHead.getTail());
        assertEquals(1,listInsertSameHead.getSize());

        // scenario 3: full list
        SLL newList = new SLL(startSNode);
        newList.insertHead(secondSNode);
        assertEquals(secondSNode,newList.getHead());
        assertEquals(startSNode,newList.getTail());
        assertEquals(2,newList.getSize());
    }

    @Test
    public void testSLLInsertTail() {
        // scenario 1: empty list
        SLL emptyList = new SLL();
        emptyList.insertTail(endSNode);
        assertEquals(endSNode, emptyList.getHead());
        assertEquals(endSNode, emptyList.getTail());
        assertEquals(1, emptyList.getSize());

        // scenario 2: if tail == node
        SLL listInsertSameTail = new SLL(endSNode);
        listInsertSameTail.insertTail(endSNode);
        assertEquals(endSNode, listInsertSameTail.getHead());
        assertEquals(endSNode, listInsertSameTail.getTail());
        assertEquals(1, listInsertSameTail.getSize());
    
        // scenario 3: full list
        SLL newList = new SLL(startSNode);
        newList.insertTail(endSNode);
        assertEquals(startSNode,newList.getHead());
        assertEquals(endSNode,newList.getTail());
        assertEquals(2,newList.getSize());
    }

    @Test
    public void testSLLInsertEmptyList() {
        // scenario 1: if size+1 < position < 1
        SLL invalidIndexList = new SLL();
        boolean passed = false;
        try { invalidIndexList.insert(startSNode, 0); }
        catch (IndexOutOfBoundsException e) { passed = true; }
        assertTrue("SLL insert did not throw IndexOutOfBoundsException when given invalid index value", passed);
    }

    @Test
    public void testSLLInsertAlreadyExists() {
        // scenario 2: if node already exists
        SLL alreadyExistsList = new SLL(startSNode); // list: 1
        alreadyExistsList.insert(secondSNode, 1); // list: 2, 1
        alreadyExistsList.insert(startSNode, 1); // list: 2, 1

        assertEquals(secondSNode, alreadyExistsList.getHead());
        assertEquals(startSNode, alreadyExistsList.getTail());
    }

    @Test
    public void testSLLInsertVariousPositions() {
        // scenario 3: if position == 1
        SLL insertListHead = new SLL(startSNode); // list: 1
        insertListHead.insert(secondSNode, 1); // list: 2, 1
        
        assertEquals(secondSNode, insertListHead.getHead());
        assertEquals(startSNode, insertListHead.getTail());

        // scenario 4: if position == size + 1
        SLL insertListTail = new SLL(startSNode);
        insertListHead.insert(secondSNode, 1); // list: 2, 1
        insertListHead.insert(endSNode, 3); // list: 2, 1, 5
        assertEquals(secondSNode, insertListHead.getHead());
        assertEquals(endSNode, insertListHead.getTail());
    }

    @Test
    public void testSLLInsertBetweenNodes() {
        // scenario 5: if inserting in between nodes
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
        // before: 1, 3, 5, 2
        newFunction.sortedInsert(fourthSNode);
        // after: 1, 2, 3, 4, 5

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


     
    /* CSLL Class Tests */

    @Test
    public void testCSLLDefaultConstructor() {
        CSLL newFunction = new CSLL();
        assertEquals(null,newFunction.getHead());
        assertEquals(null,newFunction.getTail());
        assertEquals(0,newFunction.getSize());
    }

    @Test 
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
    public void testCSLLSort() {
        CSLL newFunction = new CSLL(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 3);
        newFunction.insert(thirdSNode, 2);
        newFunction.insertTail(fourthSNode);
        // before: 1, 3, 5, 2, 4
        newFunction.sort();
        // after: 1, 2, 3, 4, 5

        assertEquals(1, newFunction.getHead().getValue());
        assertEquals(2, newFunction.getHead().getNext().getValue());
        assertEquals(3, newFunction.getHead().getNext().getNext().getValue());
        assertEquals(4, newFunction.getHead().getNext().getNext().getNext().getValue());
        assertEquals(5, newFunction.getHead().getNext().getNext().getNext().getNext().getValue());
        assertEquals(1, newFunction.getHead().getNext().getNext().getNext().getNext().getNext().getValue()); // looping back around
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


    /* StackLL Class Tests */

    @Test 
    public void testStackLLDefaultConstructor() {
        StackLL newFunction = new StackLL();
        assertEquals(null, newFunction.peek());
        assertEquals(0,newFunction.getSize());
    }

    @Test 
    public void testStackLLConstructor() {
        StackLL newFunction = new StackLL(startSNode);
        assertEquals(startSNode,newFunction.peek());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testStackLLGettersAndSetters() {
        StackLL newFunction = new StackLL();
        newFunction.setHead(startSNode);
        assertEquals(startSNode, newFunction.peek());
        assertEquals(null, newFunction.getTail());
    }

    @Test
    public void testStackLLOverrideMethods() {
        StackLL newFunction = new StackLL();
        newFunction.setTail(endSNode);

        assertEquals(null, newFunction.getTail());

        newFunction.insertHead(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 2);
        newFunction.sortedInsert(thirdSNode);
        assertEquals(null, newFunction.getTail());
        assertEquals(null, newFunction.getHead());
        assertEquals(0, newFunction.getSize());

        newFunction.deleteHead();
        newFunction.deleteTail();
        newFunction.delete(thirdSNode);
        assertEquals(null, newFunction.getTail());
        assertEquals(null, newFunction.getHead());
        assertEquals(null, newFunction.getHead());
        assertEquals(0, newFunction.getSize());
    }

    @Test
    public void testStackLLPush() {
        StackLL newFunction = new StackLL();
        newFunction.push(startSNode);
        assertEquals(startSNode, newFunction.peek());
        assertEquals(startSNode, newFunction.getTail());
        assertEquals(1, newFunction.getSize());
    }

    @Test
    public void testStackLLPop() {
        StackLL newFunction = new StackLL(startSNode);
        SNode lastELement = newFunction.pop();
        assertEquals(startSNode, lastELement);
        assertEquals(null, newFunction.peek());
        assertEquals(0, newFunction.getSize());
    }

    @Test
    public void testStackLLPeek() {
        StackLL newFunction = new StackLL(startSNode);
        assertEquals(startSNode, newFunction.peek());
        assertEquals(1, newFunction.getSize());
    }
    
    @Test
    public void testStackLLSort() {
        StackLL newFunction = new StackLL(startSNode);
        newFunction.push(endSNode);
        newFunction.push(secondSNode);
        newFunction.push(thirdSNode);
        // before: 1, 3, 5, 2
        newFunction.sort();
        // after: 1, 2, 3, 5

        assertEquals(1,newFunction.peek().getValue());
        assertEquals(2,newFunction.peek().getNext().getValue());
        assertEquals(3,newFunction.peek().getNext().getNext().getValue());
        assertEquals(5,newFunction.peek().getNext().getNext().getNext().getValue());
        assertEquals(4,newFunction.getSize());
    }

    @Test
    public void testStackLLSearchDoesNotExist() {
        StackLL newFunction = new StackLL(startSNode);
        newFunction.push(endSNode);
        newFunction.push(secondSNode);
        newFunction.push(thirdSNode);
        newFunction.push(fourthSNode);

        SNode nodeNotExist = new SNode(30, null);
        assertNull(newFunction.search(nodeNotExist));
    }

    @Test
    public void testStackLLSearchExists() {
        StackLL newFunction = new StackLL(startSNode);
        newFunction.push(endSNode);
        newFunction.push(secondSNode);
        newFunction.push(thirdSNode);
        newFunction.push(fourthSNode);

        SNode nodeExists = new SNode(4, endSNode);
        assertNotNull(newFunction.search(nodeExists));

    }

    @Test
    public void testStackLLClearAndIsEmpty() {
        StackLL newFunction = new StackLL(startSNode);
        newFunction.push(endSNode);
        newFunction.push(secondSNode);
        newFunction.push(thirdSNode);
        newFunction.push(fourthSNode);

        newFunction.clear();
        assertNull(newFunction.peek());
        assertTrue(newFunction.isEmpty());
    }

    @Test
    public void testStackLLPrint() {
        StackLL newFunction = new StackLL(startSNode);
        newFunction.push(endSNode);
        newFunction.push(secondSNode);
        newFunction.push(thirdSNode);
        newFunction.push(fourthSNode);
        newFunction.sort();
        // list: 1, 2, 3, 4, 5

        String expectedOutput = "List length: 5\nSorted status: Sorted\nList content: 1, 2, 3, 4, 5\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        newFunction.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    /* QueueLL Class Tests */

    @Test 
    public void testQueueLLDefaultConstructor() {
        QueueLL newFunction = new QueueLL();
        assertEquals(null, newFunction.getHead());
        assertEquals(0, newFunction.getSize());
    }

    @Test 
    public void testQueueLLConstructor() {
        QueueLL newFunction = new QueueLL(startSNode);
        assertEquals(startSNode, newFunction.peek());
        assertEquals(1, newFunction.getSize());
    }

    @Test
    public void testQueueLLGettersAndSetters() {
        QueueLL newFunction = new QueueLL();
        newFunction.setTail(startSNode);
        assertEquals(null, newFunction.peek());
        assertEquals(startSNode, newFunction.getTail());
    }

    @Test
    public void testQueueLLOverrideMethods() {
        QueueLL newFunction = new QueueLL();
        newFunction.setHead(endSNode);

        assertEquals(null, newFunction.getTail());

        newFunction.insertHead(startSNode);
        newFunction.insertTail(endSNode);
        newFunction.insert(secondSNode, 2);
        newFunction.sortedInsert(thirdSNode);
        assertEquals(null, newFunction.getTail());
        assertEquals(null, newFunction.getHead());
        assertEquals(0, newFunction.getSize());

        newFunction.deleteHead();
        newFunction.deleteTail();
        newFunction.delete(thirdSNode);
        assertEquals(null, newFunction.getTail());
        assertEquals(null, newFunction.getHead());
        assertEquals(null, newFunction.getHead());
        assertEquals(0, newFunction.getSize());
    }

    @Test
    public void testQueueLLEnqueue() {
        QueueLL newFunction = new QueueLL();
        newFunction.enqueue(startSNode);
        assertEquals(startSNode, newFunction.peek());
        assertEquals(startSNode, newFunction.getTail());
        assertEquals(1, newFunction.getSize());
    }

    @Test
    public void testQueueLLDequeue() {
        QueueLL newFunction = new QueueLL(startSNode);
        SNode lastELement = newFunction.dequeue();
        assertEquals(startSNode, lastELement);
        assertEquals(null, newFunction.peek());
        assertEquals(0, newFunction.getSize());
    }

    @Test
    public void testQueueLLPeek() {
        QueueLL newFunction = new QueueLL(startSNode);
        assertEquals(startSNode, newFunction.peek());
        assertEquals(1, newFunction.getSize());
    }

    @Test
    public void testQueueLLLSort() {
        QueueLL newFunction = new QueueLL(startSNode);
        newFunction.enqueue(endSNode);
        newFunction.enqueue(secondSNode);
        newFunction.enqueue(thirdSNode);
        // before: 1, 3, 5, 2
        newFunction.sort();
        // after: 1, 2, 3, 5

        assertEquals(1,newFunction.peek().getValue());
        assertEquals(2,newFunction.peek().getNext().getValue());
        assertEquals(3,newFunction.peek().getNext().getNext().getValue());
        assertEquals(5,newFunction.peek().getNext().getNext().getNext().getValue());
        assertEquals(4,newFunction.getSize());
    }

    @Test
    public void testQueueLLSearchDoesNotExist() {
        QueueLL newFunction = new QueueLL(startSNode);
        newFunction.enqueue(endSNode);
        newFunction.enqueue(secondSNode);
        newFunction.enqueue(thirdSNode);
        newFunction.enqueue(fourthSNode);
        SNode nodeNotExist = new SNode(30, null);
        assertNull(newFunction.search(nodeNotExist));
    }

    @Test
    public void testQueueLLSearchExists() {
        QueueLL newFunction = new QueueLL(startSNode);
        newFunction.enqueue(endSNode);
        newFunction.enqueue(secondSNode);
        newFunction.enqueue(thirdSNode);
        newFunction.enqueue(fourthSNode);

        SNode nodeExists = new SNode(4, endSNode);
        assertNotNull(newFunction.search(nodeExists));
    }

    @Test
    public void testQueueLLClearAndIsEmpty() {
        QueueLL newFunction = new QueueLL(startSNode);
        newFunction.enqueue(endSNode);
        newFunction.enqueue(secondSNode);
        newFunction.enqueue(thirdSNode);
        newFunction.enqueue(fourthSNode);

        newFunction.clear();
        assertNull(newFunction.getHead());
        assertNull(newFunction.getTail());
        assertTrue(newFunction.isEmpty());
    }

    @Test
    public void testQueueLLPrint() {
        QueueLL newFunction = new QueueLL(startSNode);
        newFunction.enqueue(endSNode);
        newFunction.enqueue(secondSNode);
        newFunction.enqueue(thirdSNode);
        newFunction.enqueue(fourthSNode);
        newFunction.sort();
        // list: 1, 2, 3, 4, 5

        String expectedOutput = "List length: 5\nSorted status: Sorted\nList content: 1, 2, 3, 4, 5\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        newFunction.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }


    /* DLL Class Tests */

    // DLL Node variables
    DNode startDNode = new DNode(1);
    DNode secondDNode = new DNode(2);
    DNode thirdDNode = new DNode(3);
    DNode fourthDNode = new DNode(4);
    DNode endDNode = new DNode(5);

    @Test 
    public void testDLLDefaultConstructor() {
        DLL newFunction = new DLL();
        assertEquals(null,newFunction.getHead());
        assertEquals(null,newFunction.getTail());
        assertEquals(0,newFunction.getSize());
    }

    @Test 
    public void testDLLConstructor() {
        DLL newFunction = new DLL(startDNode);
        assertEquals(startDNode,newFunction.getHead());
        assertEquals(startDNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testDLLGettersAndSetters() {
        DLL newList = new DLL();
        newList.setHead(startDNode);
        newList.setTail(endDNode);
        newList.setSize(2);

        assertEquals(startDNode, newList.getHead());
        assertEquals(endDNode, newList.getTail());
        assertEquals(2, newList.getSize());
    }

    @Test
    public void testDLLInsertHead() {
        // scenario 1: empty list
        DLL emptyList = new DLL();
        emptyList.insertHead(startDNode);
        assertEquals(startDNode,emptyList.getHead());
        assertEquals(startDNode,emptyList.getTail());
        assertEquals(1,emptyList.getSize());

        // scenario 2: if head == node
        DLL listInsertSameHead = new DLL(startDNode);
        listInsertSameHead.insertHead(startDNode);
        assertEquals(startDNode,listInsertSameHead.getHead());
        assertEquals(startDNode,listInsertSameHead.getTail());
        assertEquals(1,listInsertSameHead.getSize());

        // scenario 3: full list
        DLL newList = new DLL(startDNode);
        newList.insertHead(secondDNode);
        assertEquals(secondDNode,newList.getHead());
        assertEquals(secondDNode,newList.getTail().getPrev());
        assertEquals(startDNode,newList.getTail());
        assertEquals(2,newList.getSize());
    }

    @Test
    public void testDLLInsertTail() {
        // scenario 1: empty list
        DLL emptyList = new DLL();
        emptyList.insertTail(endDNode);
        assertEquals(endDNode, emptyList.getHead());
        assertEquals(endDNode, emptyList.getTail());
        assertEquals(1, emptyList.getSize());

        // scenario 2: if tail == node
        DLL listInsertSameTail = new DLL(endDNode);
        listInsertSameTail.insertTail(endDNode);
        assertEquals(endDNode, listInsertSameTail.getHead());
        assertEquals(endDNode, listInsertSameTail.getTail());
        assertEquals(1, listInsertSameTail.getSize());
    
        // scenario 3: full list
        DLL newList = new DLL(startDNode);
        newList.insertTail(endDNode);
        assertEquals(startDNode,newList.getHead());
        assertEquals(endDNode,newList.getTail());
        assertEquals(2,newList.getSize());
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


    /* CDLL Class Tests */

    @Test
    public void testCDLLDefaultConstructor() {
        CDLL newFunction = new CDLL();
        assertEquals(null,newFunction.getHead());
        assertEquals(null,newFunction.getTail());
        assertEquals(0,newFunction.getSize());
    }

    @Test 
    public void testCDLLConstructor() {
        CDLL newFunction = new CDLL(startDNode);
        assertEquals(startDNode,newFunction.getHead());
        assertEquals(startDNode,newFunction.getHead().getNext());
        assertEquals(startDNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void testCDLLGettersAndSetters() {
        CDLL newFunction = new CDLL();
        newFunction.setHead(startDNode);
        newFunction.setTail(endDNode);
        assertEquals(startDNode, newFunction.getHead());
        assertEquals(endDNode, newFunction.getTail());
    }

    @Test
    public void testCDLLInsertHeadEmptyList() {
        // insert in empty list
        CDLL newFunctionEmpty = new CDLL();
        newFunctionEmpty.insertHead(startDNode);
        assertEquals(startDNode, newFunctionEmpty.getHead());
        assertEquals(startDNode, newFunctionEmpty.getTail().getNext());
        assertEquals(startDNode, newFunctionEmpty.getTail());
    }

    @Test
    public void testCDLLInsertHeadFullList() {
        // insert in non-empty list
        CDLL newFunctionFull = new CDLL(startDNode);
        newFunctionFull.insert(thirdDNode, 2);
        newFunctionFull.insertHead(secondDNode);
        // expected: 2, 1, 3
        assertEquals(secondDNode, newFunctionFull.getHead());
        assertEquals(startDNode, newFunctionFull.getHead().getNext());
        assertEquals(thirdDNode, newFunctionFull.getTail());
        assertEquals(secondDNode, newFunctionFull.getTail().getNext());
    }
    
    @Test
    public void testCDLLInsertTailEmptyList() {
        // insert in empty list
        CDLL newFunctionEmpty = new CDLL();
        newFunctionEmpty.insertTail(endDNode);
        assertEquals(endDNode, newFunctionEmpty.getHead());
        assertEquals(endDNode, newFunctionEmpty.getTail());
        assertEquals(endDNode, newFunctionEmpty.getTail().getNext());

        assertEquals(5, newFunctionEmpty.getTail().getData());
        assertEquals(1, newFunctionEmpty.getSize());
    }

    @Test
    public void testCDLLInsertTailFullList() {
        // insert in non-empty list
        CDLL newFunctionFull = new CDLL(startDNode);
        newFunctionFull.insert(secondDNode, 2);
        newFunctionFull.insert(thirdDNode, 3);
        newFunctionFull.insertTail(endDNode);
        // expected: 1, 2, 3, 5
        assertEquals(startDNode, newFunctionFull.getHead());
        assertEquals(endDNode, newFunctionFull.getTail());
        assertEquals(startDNode, newFunctionFull.getTail().getNext());
        assertEquals(5, newFunctionFull.getTail().getData());
    }

    @Test
    public void testCDLLInsert() {
        CDLL newFunction = new CDLL();
        newFunction.insert(startDNode, 1); // expected: 1
        assertEquals(startDNode, newFunction.getHead());
        assertEquals(startDNode, newFunction.getTail().getNext());
        
        newFunction.insert(secondDNode, 2); // expected: 1, 2
        assertEquals(secondDNode, newFunction.getHead().getNext());
        assertEquals(startDNode, newFunction.getTail().getPrev());
        assertEquals(secondDNode, newFunction.getTail());
        assertEquals(startDNode, newFunction.getTail().getNext());

        newFunction.insert(thirdDNode, 3); // expected: 1, 2, 3
        assertEquals(thirdDNode, newFunction.getHead().getNext().getNext());
        assertEquals(secondDNode, newFunction.getTail().getPrev());
        assertEquals(startDNode, newFunction.getTail().getNext());

        newFunction.insert(fourthDNode, 2); // expected: 1, 4, 2, 3
        assertEquals(fourthDNode, newFunction.getHead().getNext());
        assertEquals(secondDNode, newFunction.getTail().getPrev());
        assertEquals(startDNode, newFunction.getTail().getNext());
    }

    @Test
    public void testCDLLSort() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 3);
        newFunction.insert(thirdDNode, 2);
        // before: 1, 3, 5, 2
        newFunction.sort();
        // after: 1, 2, 3, 5

        assertEquals(1, newFunction.getHead().getData());
        assertEquals(2, newFunction.getHead().getNext().getData());
        assertEquals(3, newFunction.getHead().getNext().getNext().getData());
        assertEquals(5, newFunction.getHead().getNext().getNext().getNext().getData());
        assertEquals(1, newFunction.getHead().getNext().getNext().getNext().getNext().getData()); // looping back around
    }

    @Test
    public void testCDLLSortedInsert() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 2);
        newFunction.insert(thirdDNode, 2);
        // before: 1, 3, 5, 2
        newFunction.sortedInsert(fourthDNode);
        // expected: 1, 2, 3, 4, 5

        assertEquals(1, newFunction.getHead().getData());
        assertEquals(2, newFunction.getHead().getNext().getData());
        assertEquals(3, newFunction.getHead().getNext().getNext().getData());
        assertEquals(4, newFunction.getHead().getNext().getNext().getNext().getData());
        assertEquals(5, newFunction.getHead().getNext().getNext().getNext().getNext().getData());
        assertEquals(5, newFunction.getSize());
    }

    @Test
    public void testCDLLSearchDoesNotExist() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 2);
        newFunction.insert(thirdDNode, 2);
        // expected: 1, 3, 2, 5

        DNode nodeNotExist = new DNode(30);
        assertNull(newFunction.search(nodeNotExist));
    }

    @Test
    public void testCDLLSearchExists() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 2);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);

        DNode nodeExists = new DNode(4, endDNode);
        assertNotNull(newFunction.search(nodeExists));
    }

    @Test
    public void testCDLLDeleteHead() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(secondDNode, 2);
        newFunction.insert(thirdDNode, 2);
        // before: 1, 3, 5, 2

        newFunction.deleteHead();
        // after: 3, 5, 2
        assertEquals(thirdDNode, newFunction.getHead());
        assertEquals(endDNode, newFunction.getHead().getPrev());
        assertEquals(3, newFunction.getHead().getData());
        assertEquals(3, newFunction.getSize());
    }

    @Test
    public void testCDLLDeleteTail() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(thirdDNode, 2);
        newFunction.insert(fourthDNode, 2);
        // before: 1, 4, 3, 5
        newFunction.deleteTail();
        // after: 1, 4, 3

        assertEquals(thirdDNode, newFunction.getTail());
        assertEquals(fourthDNode, newFunction.getTail().getPrev());
        assertEquals(3, newFunction.getTail().getData());
        assertEquals(3, newFunction.getSize());
    }

    @Test
    public void testCDLLDelete() { 
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(thirdDNode, 2);
        newFunction.insert(fourthDNode, 2);
        // before: 1, 4, 3, 5
        assertEquals(4, newFunction.getHead().getNext().getData());
        assertEquals(fourthDNode, newFunction.getHead().getNext());

        newFunction.delete(fourthDNode);
        // before: 1, 3, 5
        assertEquals(3, newFunction.getHead().getNext().getData());
        assertEquals(thirdDNode, newFunction.getHead().getNext());
        assertEquals(3, newFunction.getSize());
    }

    @Test
    public void testCDLLClearAndIsEmpty() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insert(thirdDNode, 2);
        newFunction.sortedInsert(fourthDNode);

        newFunction.clear();
        assertNull(newFunction.getHead());
        assertTrue(newFunction.isEmpty());
    }

    @Test
    public void testCDLLPrint() {
        CDLL newFunction = new CDLL(startDNode);
        newFunction.insertTail(endDNode);
        newFunction.insert(thirdDNode, 2);
        newFunction.insertTail(secondDNode);
        // list: 1, 3, 5, 2

        String expectedOutput = "List content: \n[ 1 3 5 2 ]\nList length: 4\nCircular: true\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        newFunction.print();
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }


    /* AVL Class Tests */

    /* BST Class Tests */
}
