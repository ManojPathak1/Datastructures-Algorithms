//  Reverse Level Order Traversal
//  https://www.geeksforgeeks.org/reverse-level-order-traversal/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Tree t = new Tree();
    t.root = new Node(1);
    t.root.left = new Node(2);
    t.root.right = new Node(3);
    t.root.left.left = new Node(4);
    t.root.left.right = new Node(5);
    t.root.right.left = new Node(6);
    t.root.right.right = new Node(7);
    t.reverseLOT();
  }
}

class Tree {
  Node root;
  public void reverseLOT() {
    int h = height(root);
    for (int i = h; i >= 1; i--) {
      reverseLOT(root, i);
      System.out.println();
    }
  }
  private int height(Node root) {
    if (root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
  }
  private void reverseLOT(Node root, int level) {
    if (root == null) return;
    if (level == 1) System.out.print(root.data + " ");
    else {
      reverseLOT(root.left, level - 1);
      reverseLOT(root.right, level - 1);
    }
  }
}

class Node {
  int data;
  Node left, right;
  Node(int data) {
    this.data = data;
  }
}