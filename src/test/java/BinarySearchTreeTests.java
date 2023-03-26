import com.IB315168.models.BinarySearchTree;
import com.IB315168.models.BinaryTree;
import com.IB315168.models.BinaryTreeNode;
import com.IB315168.models.BinaryTreePrint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTests
{
  private BinarySearchTree<Integer> binarySearchTree;
  private BinaryTreePrint printer = new BinaryTreePrint();

  @BeforeEach public void setUp() {
    binarySearchTree = new BinarySearchTree<>();

    //Using working structure from BinaryTreeTests
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
    binarySearchTree.setRoot(root);

    //Create some nodes
    BinaryTreeNode<Integer> child2 = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> child7 = new BinaryTreeNode<>(7);

    //Make them children
    root.setLeftChild(child2);
    root.setRightChild(child7);

    //Create some more nodes
    BinaryTreeNode<Integer> child6 = new BinaryTreeNode<>(6);
    BinaryTreeNode<Integer> child8 = new BinaryTreeNode<>(8);
    BinaryTreeNode<Integer> child9 = new BinaryTreeNode<>(9);
    BinaryTreeNode<Integer> child1 = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> child3 = new BinaryTreeNode<>(3);

    //Make more children
    child7.setLeftChild(child6);
    child7.setRightChild(child8);

    child8.setRightChild(child9);

    child2.setLeftChild(child1);
    child2.setRightChild(child3);

    System.out.println("---> Start test");
  }

  @AfterEach public void breakDown() {
    System.out.println("----------------------------------------Tree layout----"
        + "------------------------------------");
    printer.printTree(binarySearchTree.getRoot());
    System.out.println("\n<--- End test");
  }

  @Test
  public void insertTest1() {
    assertTrue(binarySearchTree.insert(10));
  }

  @Test
  public void insertTest2() {
    assertFalse(binarySearchTree.insert(7));
  }

  @Test
  public void insertTest3() {
    assertTrue(binarySearchTree.insert(4));
  }

  @Test
  public void minTest() {
    assertEquals(1, binarySearchTree.findMin());
  }
  @Test
  public void maxTest() {
    assertEquals(9, binarySearchTree.findMax());
  }

  @Test
  public void removeLeafTest() {
    assertTrue(binarySearchTree.removeElement(9));
  }
  @Test
  public void removeParent1Test() {
    assertTrue(binarySearchTree.removeElement(8));
  }
  @Test
  public void removeParent2Test() {
    assertTrue(binarySearchTree.removeElement(2));
  }

  @Test
  public void removeRootTest() {
    assertTrue(binarySearchTree.removeElement(5));
  }

  @Test
  public void balancing1() {
    binarySearchTree.insert(10);
    binarySearchTree.insert(11);
    binarySearchTree.insert(12);
    binarySearchTree.rebalance();
  }

  @Test
  public void balancing2() {
    binarySearchTree.removeElement(2);
    binarySearchTree.removeElement(1);
    binarySearchTree.rebalance();
  }
}
