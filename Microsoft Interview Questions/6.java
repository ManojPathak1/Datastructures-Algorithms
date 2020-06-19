// How to determine if a binary tree is height-balanced?
// https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Tree t = new Tree();
    t.root = new Node(1);
    t.root.left = new Node(2);
    t.root.right = new Node(3);
    t.root.left.left = new Node(4);
    // t.root.left.left.left = new Node(5);
    System.out.println(t.isBalanced(t.root));
  }
}

class Tree {
  Node root;
  public boolean isBalanced(Node root) {
    int lh, rh;
    if (root == null) return true;
    lh = height(root.left);
    rh = height(root.right);
    if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) return true;
    return false;
  }
  private int height(Node root) {
    if (root == null) return 0;
    return 1 + max(height(root.left), height(root.right));
  }
  private int max(int a, int b) {
    return a > b ? a : b;
  }
}

class Node {
  int data;
  Node left, right;
  Node(int data) {
    this.data = data;
  }
}