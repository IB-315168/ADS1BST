package com.IB315168.models;

public class BinaryTreeNode<T>
{
  private final T element;

  private BinaryTreeNode parent;
  private BinaryTreeNode leftChild;
  private BinaryTreeNode rightChild;

  public BinaryTreeNode(T element)
  {
    this.element = element;
    this.parent = null;
    this.leftChild = null;
    this.rightChild = null;
  }

  public BinaryTreeNode(T element, BinaryTreeNode parent)
  {
    this.element = element;
    this.parent = parent;
    this.leftChild = null;
    this.rightChild = null;
  }

  public BinaryTreeNode(T element, BinaryTreeNode parent,
      BinaryTreeNode leftChild, BinaryTreeNode rightChild)
  {
    this.element = element;
    this.parent = parent;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public T getElement()
  {
    return element;
  }

  public BinaryTreeNode getParent()
  {
    return parent;
  }

  public void setParent(BinaryTreeNode parent)
  {
    this.parent = parent;
  }

  public BinaryTreeNode getLeftChild()
  {
    return leftChild;
  }

  public void setLeftChild(BinaryTreeNode leftChild)
  {
    this.leftChild = leftChild;
    leftChild.setParent(this);
  }

  public BinaryTreeNode getRightChild()
  {
    return rightChild;
  }

  public void setRightChild(BinaryTreeNode rightChild)
  {
    this.rightChild = rightChild;
    rightChild.setParent(this);
  }
}
