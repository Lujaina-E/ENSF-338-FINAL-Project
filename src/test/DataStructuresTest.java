package test;

import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.nodes.TNode;

import org.junit.Test;

import SNode;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.regex.*;
import java.beans.Transient;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Terminal Commands
 * the following commands can be used for...
 * test compilation: javac -cp .:src/lib/junit-4.13.2.jar:src/lib/hamcrest-core-1.3.jar src/test/DataStructuresTest.java
 * test execution: java -cp .:src/lib/junit-4.13.2.jar:src/lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore src.test.DataStructuresTest
 */

public class DataStructuresTest {

    // SLL Class Tests

    SNode startNode = null;
   
    @Test
    public void SLLDefaultConstructor() { }

    @Test
    public void SLLInsertHead() { }

    @Test
    public void SLLInsertTail() { }

    @Test
    public void SLLInsert() { }

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
