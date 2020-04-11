//  Print BST keys in the given range
//  https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    BST b = new BST();
    b.root = new Node(20);
    b.root.left = new Node(8);
    b.root.right = new Node(22);
    b.root.left.left = new Node(4);
    b.root.left.right = new Node(12);
    b.printInRange(4, 15);
  }
}

class BST {
  Node root;
  public void printInRange(int start, int end) {
    printInRange(root, start, end);
  }
  private void printInRange(Node root, int start, int end) {
    if (root == null) return;
    if (root.data > start) printInRange(root.left, start, end);
    if (root.data > start && root.data < end) System.out.print(root.data + " ");
    if (root.data < end) printInRange(root.right, start, end);
  }
}

class Node {
  int data;
  Node left, right;
  Node(int data) {
    this.data = data;
    left = right = null;
  }
}