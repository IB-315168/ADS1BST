package com.IB315168.models;

import java.util.ArrayList;

public class BinaryTree<T>
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
    return true;
  }

  public int size() {
    return 0;
  }

  public boolean contains(T element) {
    return true;
  }

  public ArrayList<T> inOrder() {
    return new ArrayList<>();
  }

  public ArrayList<T> preOrder() {
    return new ArrayList<>();
  }

  public ArrayList<T> postOrder() {
    return new ArrayList<>();
  }

  public ArrayList<T> levelOrder() {
    return new ArrayList<>();
  }

  public int height() {
    return 0;
  }
}
