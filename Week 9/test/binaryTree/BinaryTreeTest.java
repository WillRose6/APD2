package binaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testInsertInitialValue(){
        BinaryTree<Integer> integerTree = new BinaryTree<>();
        integerTree.insert(5);
        assertEquals(integerTree.getValue(), 5);
    }

    @Test
    void testInsertingThreeValues(){
        BinaryTree<Integer> integerTree = new BinaryTree<>();
        integerTree.insert(5);
        integerTree.insert(2);
        integerTree.insert(7);

        if(integerTree.getValue() != 5 || integerTree.getLeft().getValue() != 2 || integerTree.getRight().getValue() != 7){
            fail();
        }
    }

    @Test
    void testInsertingFiveValues(){
        BinaryTree<Integer> integerTree = new BinaryTree<>();
        integerTree.insert(5);
        integerTree.insert(2);
        integerTree.insert(7);
        integerTree.insert(10);
        integerTree.insert(1);

        if(integerTree.getValue() != 5 || integerTree.getLeft().getValue() != 2 ||
                integerTree.getRight().getValue() != 7 || integerTree.getLeft().getLeft().getValue() != 1 || integerTree.getRight().getRight().getValue() != 10){
            fail();
        }
    }

    @Test
    void testTraversalOfFiveItems(){
        BinaryTree<Integer> integerTree = new BinaryTree<>();

        integerTree.insert(5);
        integerTree.insert(2);
        integerTree.insert(7);
        integerTree.insert(10);
        integerTree.insert(1);

        ArrayList<Integer> exampleArray = new ArrayList<>();
        exampleArray.add(5);
        exampleArray.add(2);
        exampleArray.add(1);
        exampleArray.add(7);
        exampleArray.add(10);

        List<Integer> list = integerTree.traverse();
        assertEquals(list, exampleArray);
    }

    @Test
    void testContainsElement(){
        BinaryTree<Integer> integerTree = new BinaryTree<>();
        integerTree.insert(5);
        assertTrue((integerTree.contains(5)));
    }

    @Test
    void testContainsThreeElements(){
        BinaryTree<Integer> integerTree = new BinaryTree<>();
        integerTree.insert(5);
        integerTree.insert(3);
        integerTree.insert(7);
        if(!integerTree.contains(5) || !integerTree.contains(3) || !integerTree.contains(7)){
            fail();
        }
    }

    @Test
    void testContainsFiveElements(){
        BinaryTree<Integer> integerTree = new BinaryTree<>();
        integerTree.insert(5);
        integerTree.insert(3);
        integerTree.insert(1);
        integerTree.insert(7);
        integerTree.insert(10);
        if(!integerTree.contains(5) || !integerTree.contains(3) || !integerTree.contains(1) || !integerTree.contains(7) || !integerTree.contains(10)){
            fail();
        }
    }
}