package com.IB315168.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>>
{
  private BinaryTreeNode<T> root;

  public BinaryTree()
  {
    this.root = null;
  }

  public BinaryTreeNode<T> getRoot()
  {
    return root;
  }

  public void setRoot(BinaryTreeNode<T> root)
  {
    this.root = root;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public int size() {
    int count = 0;

    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty()) {
      BinaryTreeNode<T> temp = stack.pop();

      count++;

      if(temp.getLeftChild() != null) {
        stack.push(temp.getLeftChild());}

      if(temp.getRightChild() != null) {
        stack.push(temp.getRightChild());}
    }

    return count;
  }

  public boolean contains(T element) {
    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty()) {
      BinaryTreeNode<T> temp = stack.pop();

      if(temp.getElement().equals(element)) {
        return true;
      }

      if(temp.getLeftChild() != null) {
        stack.push(temp.getLeftChild());}

      if(temp.getRightChild() != null) {
        stack.push(temp.getRightChild());}
    }

    return false;
  }

  public ArrayList<T> inOrder() {
    ArrayList<T> elements = new ArrayList<>();

    return inOrderRec(elements, root);
  }

  public ArrayList<T> preOrder() {
    ArrayList<T> elements = new ArrayList<>();

    return preOrderRec(elements, root);
  }

  public ArrayList<T> postOrder() {
    ArrayList<T> elements = new ArrayList<>();

    return postOrderRec(elements, root);
  }

  public ArrayList<T> levelOrder() {
    ArrayList<T> elements = new ArrayList<>();

    List<BinaryTreeNode<T>> list = new ArrayList<>();
    list.add(root);

    while(!list.isEmpty()) {
      BinaryTreeNode<T> temp = list.remove(0);

      elements.add(temp.getElement());

      if(temp.getLeftChild() != null) {
        list.add(temp.getLeftChild());}

      if(temp.getRightChild() != null) {
        list.add(temp.getRightChild());}
    }

    return elements;
  }

  public int height() {
    //Not optimal, requires an update
    ArrayList<Integer> elements = new ArrayList<>();

    List<BinaryTreeNode<T>> list = new ArrayList<>();
    list.add(root);

    int count = 0;

    while(!list.isEmpty()) {
      BinaryTreeNode<T> temp = list.remove(0);

      count++;

      if(temp.getLeftChild() != null) {
        list.add(temp.getLeftChild());}

      if(temp.getRightChild() != null) {
        list.add(temp.getRightChild());}

      if(temp.getLeftChild() == null && temp.getRightChild() == null) {
        elements.add(count);
        count = 0;
      }
    }

    //Accounting for root
    return elements.stream().max(Integer::compareTo).get()-1;
  }

  private ArrayList<T> preOrderRec(ArrayList<T> list, BinaryTreeNode<T> node) {
    if (node != null) {
      list.add(node.getElement());
      preOrderRec(list, node.getLeftChild());
      preOrderRec(list, node.getRightChild());
    }

    return list;
  }
  private ArrayList<T> inOrderRec(ArrayList<T> list, BinaryTreeNode<T> node) {
    if (node != null) {
      inOrderRec(list, node.getLeftChild());
      list.add(node.getElement());
      inOrderRec(list, node.getRightChild());
    }

    return list;
  }

  private ArrayList<T> postOrderRec(ArrayList<T> list, BinaryTreeNode<T> node) {
    if (node != null) {
      postOrderRec(list, node.getLeftChild());
      postOrderRec(list, node.getRightChild());
      list.add(node.getElement());
    }

    return list;
  }
//  public ArrayList<T> postOrder() {
//    ArrayList<T> elements = new ArrayList<>();
//
//    List<BinaryTreeNode<T>> list = new ArrayList<>();
//    list.add(root);
//
//    while(!list.isEmpty()) {
//      BinaryTreeNode<T> temp = list.remove(0);
//
//      elements.add(temp.getElement());
//
//      if(temp.getLeftChild() != null) {
//        list.add(temp.getLeftChild());}
//
//      if(temp.getRightChild() != null) {
//        list.add(temp.getRightChild());}
//    }
//
//    return elements;
//  }
}
