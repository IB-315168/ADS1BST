package com.IB315168.models;

public class BinaryTreeNode<T>
{
  private final T element;
  private BinaryTreeNode leftChild;
  private BinaryTreeNode rightChild;

  public BinaryTreeNode(T element)
  {
    this.element = element;
    this.leftChild = null;
    this.rightChild = null;
  }
  public BinaryTreeNode(T element, BinaryTreeNode leftChild, BinaryTreeNode rightChild)
  {
    this.element = element;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public T getElement()
  {
    return element;
  }
  public BinaryTreeNode getLeftChild()
  {
    return leftChild;
  }

  public void setLeftChild(BinaryTreeNode leftChild)
  {
    this.leftChild = leftChild;
  }

  public BinaryTreeNode getRightChild()
  {
    return rightChild;
  }

  public void setRightChild(BinaryTreeNode rightChild)
  {
    this.rightChild = rightChild;
  }
}
