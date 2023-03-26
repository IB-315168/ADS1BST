package com.IB315168.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>
{
  public BinarySearchTree()
  {
  }

  public boolean insert(T element) {
    if(getRoot() == null) {
      setRoot(new BinaryTreeNode<>(element));
      return true;
    }

    if(contains(element)) {
      return false;
    }

    BinaryTreeNode<T> temp = getRoot();

    while(temp != null) {
      if(element.compareTo(temp.getElement()) < 0) {
        if(temp.getLeftChild() != null) {
          temp = temp.getLeftChild();
        } else {
          temp.setLeftChild(new BinaryTreeNode<>(element));
          return true;
        }
      } else {
        if(temp.getRightChild() != null) {
          temp = temp.getRightChild();
        } else {
          temp.setRightChild(new BinaryTreeNode<>(element));
          return true;
        }
      }
    }

    return false;
  }

  public boolean removeElement(T element) {
    if(getRoot() == null) {
      return false;
    }

    if(!contains(element)) {
      return false;
    }

    BinaryTreeNode<T> parent = getRoot();
    BinaryTreeNode<T> nodeToDelete = getRoot();

    //Fetch parent of the node to be deleted
    if(parent.getElement().compareTo(element) != 0) {
      Stack<BinaryTreeNode<T>> stack = new Stack<>();
      stack.push(getRoot());

      while(!stack.isEmpty()) {
        BinaryTreeNode<T> temp = stack.pop();

        if(temp.getLeftChild() != null && temp.getLeftChild().getElement().compareTo(element) == 0) {
          parent = temp;
          nodeToDelete = temp.getLeftChild();
          break;
        }

        if(temp.getRightChild() != null && temp.getRightChild().getElement().compareTo(element) == 0) {
          parent = temp;
          nodeToDelete = temp.getRightChild();
          break;
        }

        if(temp.getLeftChild() != null) {
          stack.push(temp.getLeftChild());}

        if(temp.getRightChild() != null) {
          stack.push(temp.getRightChild());}
      }
    }

    //Deleting process
    //Case 1 - Node is a leaf
    if(nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null) {
      if(nodeToDelete.equals(getRoot())) {
        setRoot(null);
        return true;
      }

      if(parent.getLeftChild() != null && parent.getLeftChild().equals(nodeToDelete)) {
        parent.setLeftChild(null);
      } else if(parent.getRightChild() != null && parent.getRightChild().equals(nodeToDelete)){
        parent.setRightChild(null);
      }

      return true;
    }

    //Case 2 - Node has only one child
    if(nodeToDelete.getLeftChild() == null) {
      if(nodeToDelete.equals(getRoot())) {
        setRoot(nodeToDelete.getRightChild());
        nodeToDelete.setRightChild(null);
        return true;
      }

      if(parent.getLeftChild().equals(nodeToDelete)) {
        parent.setLeftChild(nodeToDelete.getRightChild());
      } else {
        parent.setRightChild(nodeToDelete.getRightChild());
      }

      return true;
    } else if(nodeToDelete.getRightChild() == null) {
      if(nodeToDelete.equals(getRoot())) {
        setRoot(nodeToDelete.getLeftChild());
        nodeToDelete.setLeftChild(null);
        return true;
      }


      if(parent.getLeftChild().equals(nodeToDelete)) {
        parent.setLeftChild(nodeToDelete.getLeftChild());
      } else {
        parent.setRightChild(nodeToDelete.getLeftChild());
      }

      return true;
    }

    //Case 3 - Node has both children
    if(nodeToDelete.getLeftChild() != null && nodeToDelete.getRightChild() != null) {
      BinaryTreeNode<T> replParent = nodeToDelete;
      BinaryTreeNode<T> replacement = nodeToDelete.getRightChild();

      //Find a replacement (and its parent) in right subtree of node to be deleted
      while(replacement.getLeftChild() != null) {
        replParent = replacement;
        replacement = replacement.getLeftChild();
      }

      //Set replacements children to be of the node that is to be deleted
      replacement.setLeftChild(nodeToDelete.getLeftChild());
      if(!replacement.equals(nodeToDelete.getRightChild())) {
        replacement.setRightChild(nodeToDelete.getRightChild());
      }

      //Remove children of node to be deleted
      nodeToDelete.setLeftChild(null);
      nodeToDelete.setRightChild(null);

      //Remove replacement as a leaf
      replParent.setLeftChild(null);

      if(nodeToDelete.equals(getRoot())) {
        setRoot(replacement);
        return true;
      }

      //Set replacement node as child in place of the node to be deleted
      if(parent.getLeftChild().equals(nodeToDelete)) {
        parent.setLeftChild(replacement);
      } else {
        parent.setRightChild(replacement);
      }
      return true;
    }

    return false;
  }

  public T findMin() {
    if(getRoot() == null) {
      return null;
    }

    BinaryTreeNode<T> temp = getRoot();
    while(temp.getLeftChild() != null) {
      temp = temp.getLeftChild();
    }

    return temp.getElement();
  }

  public T findMax() {
    if(getRoot() == null) {
      return null;
    }

    BinaryTreeNode<T> temp = getRoot();
    while(temp.getRightChild() != null) {
      temp = temp.getRightChild();
    }

    return temp.getElement();
  }

  public boolean contains(T element) {
    return super.contains(element);
  }

  public void rebalance() {
    if (getRoot() == null) {
      return;
    }

    while (true) {
      int balanceFactor = checkBalance(getRoot());
      if (balanceFactor > 1) {
        if (checkBalance(getRoot().getLeftChild()) == 1) {
          getRoot().setLeftChild(rotateLeft(getRoot().getLeftChild()));
        }
        setRoot(rotateRight(getRoot()));
      } else if (balanceFactor < -1) {
        if (checkBalance(getRoot().getRightChild()) == -1) {
          getRoot().setRightChild(rotateRight(getRoot().getRightChild()));
        }
        setRoot(rotateLeft(getRoot()));
      } else {
        break;
      }
    }
  }

  private int checkBalance(BinaryTreeNode<T> node) {
    return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
  }

  int getHeight(BinaryTreeNode<T> node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = getHeight(node.getLeftChild());
    int rightHeight = getHeight(node.getRightChild());
    return 1 + Math.max(leftHeight, rightHeight);
  }

  BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> node) {
    BinaryTreeNode<T> leftChild = node.getLeftChild();
    BinaryTreeNode<T> leftRightChild = leftChild.getRightChild();

    leftChild.setRightChild(node);
    node.setLeftChild(leftRightChild);

    return leftChild;
  }

  BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> node) {
    BinaryTreeNode<T> rightChild = node.getRightChild();
    BinaryTreeNode<T> rightLeftChild = rightChild.getLeftChild();

    rightChild.setLeftChild(node);
    node.setRightChild(rightLeftChild);

    return rightChild;
  }
}
