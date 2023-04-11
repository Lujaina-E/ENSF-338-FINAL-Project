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
    SNode startNode = new SNode(1, null);
    SNode secondNode = new SNode(2, null);
    SNode thirdNode = new SNode(3, null);
    SNode fourthNode = new SNode(4, null);
    SNode endNode = new SNode(5, null);
    
    @Test
    //default constructor 
    public void SLLDefaultConstructor() {
        SLL newFunction = new SLL();
        assertEquals(null,newFunction.getHead());
        assertEquals(null,newFunction.getTail());
        assertEquals(0,newFunction.getSize());
     }

    @Test
    //constructor with parameter
    public void SLLConstructor() {
        SLL newFunction = new SLL(startNode);
        assertEquals(startNode,newFunction.getHead());
        assertEquals(startNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());
    }

    @Test
    public void SLLInsertHead() {
        SLL newFunction = new SLL();
        newFunction.insertHead(startNode);
        assertEquals(startNode,newFunction.getHead());
        assertEquals(startNode,newFunction.getTail());
        assertEquals(1,newFunction.getSize());

        
        // System.out.print("\nAfter insert(secondNode, 3): \n");
        // 
        // newFunction.print();
        // System.out.print("\nAfter insert(thirdNode, 2)\n");
        // 
        // newFunction.print();
        // System.out.print("\nAfter sortedInsert(fourthNode): \n");
        // newFunction.sortedInsert(fourthNode);
        // newFunction.print();

        // // searching method
        // System.out.print("\nChecking search()... \n");
        // SNode nodeNotExist = new SNode(30, null);
        // if (newFunction.search(nodeNotExist) == null) {
        //     System.out.println(nodeNotExist.getValue() + " does not exist in the linked list.");
        // }
        // else { System.out.println(nodeNotExist.getValue() + " exists in the linked list.\n"); }

        // SNode nodeExists = new SNode(4, endNode);
        // if (newFunction.search(nodeExists) == null) {
        //     System.out.println(nodeExists.getValue() + " does not exist in the linked list.");
        // }
        // else { System.out.println(nodeExists.getValue() + " exists in the linked list.\n"); }
        
        // // deleting methods
        // System.out.print("After deleteHead(): \n");
        // newFunction.deleteHead();
        // newFunction.print();

        // System.out.print("\nAfter deleteTail(): \n");
        // newFunction.deleteTail();
        // newFunction.print();
        
        // System.out.print("\nAfter delete(thirdNode): \n");
        // newFunction.delete(thirdNode);
        // newFunction.print();

        // System.out.print("\nAfter clear(): \n");
        // newFunction.clear();
        // newFunction.print();

        // System.out.print("\nChecking isEmpty()... \n");
        // if (newFunction.isEmpty()) System.out.print("list is empty!\n");
        // else System.out.print("list is not empty!\n");

        // System.out.println();
     }

    @Test
    public void SLLInsertTail() {
        SLL newFunction = new SLL(startNode);
        newFunction.insertTail(endNode);
        assertEquals(5,newFunction.getTail().getValue());
        assertEquals(2,newFunction.getSize());
    }

    @Test
    public void SLLInsert() {
        SLL newFunction = new SLL(startNode);
        newFunction.insertTail(endNode);
        newFunction.insert(secondNode, 3);
        newFunction.insert(thirdNode, 2);

        assertEquals(2,newFunction.getTail().getValue()); //1, 3, 5, 2
        assertEquals(3,newFunction.getHead().getNext().getValue());
        assertEquals(4,newFunction.getSize());
    }

    @Test
    public void SLLSortedInsert() { }

    @Test
    public void SLLSearch() { }

    @Test
    public void SLLIsSorted() { }

    @Test
    public void SLLDeleteHead() { }

    @Test
    public void SLLDeleteTail() { }

    @Test
    public void SLLDelete() { }

    @Test
    public void SLLClearAndIsEmpty() { }

    @Test
    public void SLLPrint() { }

    @Test
    public void SLLGetters() { }


    // DLL Class Tests
    
    // DNode startNode = null;
   
    @Test
    public void DLLDefaultConstructor() { }

    @Test
    public void DLLInsertHead() { }

    @Test
    public void DLLInsertTail() { }

    @Test
    public void DLLInsert() { }

    @Test
    public void DLLSortedInsert() { }

    // @Test
    // public void DLLSearch() { }

    // @Test
    // public void SLLIsSorted() { }

    @Test
    public void DLLDeleteHead() { }

    @Test
    public void DLLDeleteTail() { }

    @Test
    public void DLLDelete() { }

    @Test
    public void DLLClearAndIsEmpty() { }

    @Test
    public void DLLPrint() { }

    @Test
    public void DLLGetters() { }
    

}
