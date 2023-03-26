package com.IB315168.models;

public class BinaryTreeNode<T extends Comparable<T>>
{
  private final T element;
  private BinaryTreeNode<T> leftChild;
  private BinaryTreeNode<T> rightChild;

  public BinaryTreeNode(T element)
  {
    this.element = element;
    this.leftChild = null;
    this.rightChild = null;
  }
  public BinaryTreeNode(T element, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild)
  {
    this.element = element;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public T getElement()
  {
    return element;
  }
  public BinaryTreeNode<T> getLeftChild()
  {
    return leftChild;
  }

  public void setLeftChild(BinaryTreeNode<T> leftChild)
  {
    this.leftChild = leftChild;
  }

  public BinaryTreeNode<T> getRightChild()
  {
    return rightChild;
  }

  public void setRightChild(BinaryTreeNode<T> rightChild)
  {
    this.rightChild = rightChild;
  }
}
