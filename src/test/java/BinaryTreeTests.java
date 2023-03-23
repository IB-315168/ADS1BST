import com.IB315168.models.BinaryTreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTests
{
  private BinaryTree binaryTree;

  @BeforeEach public void setUp() {
    binaryTree = new BinaryTree();
    System.out.println("---> Start test");
  }

  @AfterEach public void breakDown() {
    System.out.println("<--- End test");
  }

  @Test
  public void emptyTree() {
    assertNull(binaryTree.getRoot());
  }

  @Test
  public void isEmptyTree() {
    assertTrue(binaryTree.isEmpty());
  }

  @Test
  public void setRootTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    binaryTree.setRoot(root);
    assertFalse(binaryTree.isEmpty());
  }

  @Test
  public void sizeTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    binaryTree.setRoot(root);
    assertEquals(1, binaryTree.size());
  }

  @Test
  public void containsTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    binaryTree.setRoot(root);
    assertTrue(binaryTree.contains(root.getElement()));
  }

  //Following set of tests will involve a tree that has plenty of nodes, for easier
  // visualization, see reference image in README tests section
  @Test
  public void inOrderTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

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

    assertEquals(new ArrayList<>(Arrays.asList(1,2,3,5,6,7,8,9)), binaryTree.inOrder());
  }

  @Test
  public void preOrderTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

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

    assertEquals(new ArrayList<>(Arrays.asList(5,2,1,3,7,6,8,9)), binaryTree.preOrder());
  }

  @Test
  public void postOrderTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

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

    assertEquals(new ArrayList<>(Arrays.asList(1,3,2,6,9,8,7,5)), binaryTree.postOrder());
  }

  @Test
  public void levelOrderTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

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

    assertEquals(new ArrayList<>(Arrays.asList(5,2,7,1,3,6,8,9)), binaryTree.levelOrder());
  }

  @Test
  public void heightTree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

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

    assertEquals(3, binaryTree.height());
  }
}
