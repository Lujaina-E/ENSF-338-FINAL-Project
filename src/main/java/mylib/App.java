package src.main.java.mylib;

// import all files
import src.main.java.mylib.datastructures.linear.*;
import src.main.java.mylib.datastructures.linear.DLL;
import src.main.java.mylib.datastructures.nodes.*;
import src.main.java.mylib.datastructures.trees.*;

/**
 * Terminal Commands
 * main compilation: javac src/main/java/mylib/datastructures/linear/SLL.java
 * main execution: java src.main.java.mylib.datastructures.linear.SLL
 * App compilation: javac src/main/java/mylib/App.java
 * App execution: java src.main.java.mylib.App
 * test compilation: javac -cp .:src/lib/junit-4.13.2.jar:src/lib/hamcrest-core-1.3.jar src/test/DataStructuresTest.java
 * test execution: java -cp .:src/lib/junit-4.13.2.jar:src/lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore src.test.DataStructuresTest
 */

public class App {

    public void SLLOutput() {
        System.out.print("\nTESTING SLL.JAVA...\n");
        System.out.print("\n------------------------------\n");

        SNode startNode = new SNode(1, null);
        SNode secondNode = new SNode(2, null);
        SNode thirdNode = new SNode(3, null);
        SNode fourthNode = new SNode(4, null);
        SNode endNode = new SNode(5, null);
        
        //default constructor 
        SLL newFunction = new SLL();
        System.out.print("\nAfter new SLL(): \n");
        newFunction.print();

        //constructor with parameter
        newFunction = new SLL(startNode);
        System.out.print("\nAfter new SLL(startNode): \n");
        newFunction.print();

        //insert methods
        System.out.print("\nAfter insertHead(startNode): \n");
        newFunction.insertHead(startNode);
        newFunction.print();
        System.out.print("\nAfter insertTail(endNode): \n");
        newFunction.insertTail(endNode);
        newFunction.print();
        System.out.print("\nAfter insert(secondNode, 3): \n");
        newFunction.insert(secondNode, 3);
        newFunction.print();
        System.out.print("\nAfter insert(thirdNode, 2)\n");
        newFunction.insert(thirdNode, 2);
        newFunction.print();
        System.out.print("\nAfter sortedInsert(fourthNode): \n");
        newFunction.sortedInsert(fourthNode);
        newFunction.print();

        // searching method
        System.out.print("\nChecking search()... \n");
        SNode nodeNotExist = new SNode(30, null);
        if (newFunction.search(nodeNotExist) == null) {
            System.out.println(nodeNotExist.getValue() + " does not exist in the linked list.");
        }
        else { System.out.println(nodeNotExist.getValue() + " exists in the linked list.\n"); }

        SNode nodeExists = new SNode(4, endNode);
        if (newFunction.search(nodeExists) == null) {
            System.out.println(nodeExists.getValue() + " does not exist in the linked list.");
        }
        else { System.out.println(nodeExists.getValue() + " exists in the linked list.\n"); }
        
        // deleting methods
        System.out.print("After deleteHead(): \n");
        newFunction.deleteHead();
        newFunction.print();

        System.out.print("\nAfter deleteTail(): \n");
        newFunction.deleteTail();
        newFunction.print();
        
        System.out.print("\nAfter delete(thirdNode): \n");
        newFunction.delete(thirdNode);
        newFunction.print();

        System.out.print("\nAfter clear(): \n");
        newFunction.clear();
        newFunction.print();

        System.out.print("\nChecking isEmpty()... \n");
        if (newFunction.isEmpty()) System.out.print("list is empty!\n");
        else System.out.print("list is not empty!\n");

        System.out.println();

    }

    public void DLLOutput() {
        System.out.print("\nTESTING DLL.JAVA...\n");
        System.out.print("\n------------------------------\n");

        DNode startNode = new DNode(1, null);
        DNode secondNode = new DNode(2, null);
        DNode thirdNode = new DNode(3, null);
        DNode fourthNode = new DNode(4, null);
        DNode endNode = new DNode(5, null);
        
        //default constructor 
        DLL newFunction = new DLL();
        System.out.print("\nAfter new DLL(): \n");
        newFunction.print();

        //constructor with parameter
        newFunction = new DLL(startNode);
        System.out.print("\nAfter new SLL(startNode): \n");
        newFunction.print();

        //insert methods
        System.out.print("\nAfter insertHead(startNode): \n");
        newFunction.insertHead(startNode);
        newFunction.print();
        System.out.print("\nAfter insertTail(endNode): \n");
        newFunction.insertTail(endNode);
        newFunction.print();
        System.out.print("\nAfter insert(secondNode, 3): \n");
        newFunction.insert(secondNode, 3);
        newFunction.print();

        System.out.print("\nAfter insert(thirdNode, 2)\n");
        newFunction.insert(thirdNode, 2);
        newFunction.print();
        System.out.print("\nAfter sortedInsert(fourthNode): \n");
        newFunction.sortedInsert(fourthNode);
        newFunction.print();

        // searching method
        System.out.print("\nChecking search()... \n");
        DNode nodeNotExist = new DNode(30, null);
        if (newFunction.search(nodeNotExist) == null) {
            System.out.println(nodeNotExist.getData() + " does not exist in the linked list.");
        }
        else { System.out.println(nodeNotExist.getData() + " exists in the linked list."); }

        DNode nodeExists = new DNode(3, null);
        if (newFunction.search(nodeExists) == null) {
            System.out.println(nodeExists.getData() + " does not exist in the linked list.\n");
        }
        else { System.out.println(thirdNode.getData() + " exists in the linked list.\n"); }
        
        // deleting methods
        System.out.print("After deleteHead(): \n");
        newFunction.deleteHead();
        newFunction.print();

        System.out.print("\nAfter deleteTail(): \n");
        newFunction.deleteTail();
        newFunction.print();
        
        System.out.print("\nAfter delete(thirdNode): \n");
        newFunction.delete(thirdNode);
        newFunction.print();

        System.out.print("\nAfter clear(): \n");
        newFunction.clear();
        newFunction.print();

        System.out.print("\nChecking isEmpty()... \n");
        if (newFunction.isEmpty()) System.out.print("list is empty!\n");
        else System.out.print("list is not empty!\n");

        System.out.println();

    }

    public void CSLLOutput() {
        System.out.print("\nTESTING CSLL.JAVA...\n");
        System.out.print("\n------------------------------\n");

        SNode startNode = new SNode(1, null);
        SNode secondNode = new SNode(2, null);
        SNode thirdNode = new SNode(3, null);
        SNode fourthNode = new SNode(4, null);
        SNode endNode = new SNode(5, null);
        
        //default constructor 
        CSLL newFunction1 = new CSLL();
        System.out.print("\nAfter new CSLL(): \n");
        newFunction1.print();

        //constructor with parameter
        CSLL newFunction = new CSLL(startNode);
        System.out.print("\nAfter new CSLL(startNode): \n");
        newFunction.print();

        //insert methods
        System.out.print("\nAfter insertHead(startNode): \n");
        newFunction.insertHead(startNode);
        newFunction.print();
        System.out.print("\nAfter insertTail(endNode): \n");
        newFunction.insertTail(endNode);
        newFunction.print();
        System.out.print("\nAfter insert(secondNode, 3): \n");
        newFunction.insert(secondNode, 3);
        newFunction.print();
        System.out.print("\nAfter insert(thirdNode, 2)\n");
        newFunction.insert(thirdNode, 2);
        newFunction.print();
        System.out.print("\nAfter sortedInsert(fourthNode): \n");
        newFunction.sortedInsert(fourthNode);
        newFunction.print();

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


    public static void main (String[] args){
        App testingClasses = new App();
        //testingClasses.SLLOutput();
        testingClasses.DLLOutput();
        testingClasses.CSLLOutput();
        
    }
    
}
