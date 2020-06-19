//  A program to check if a binary tree is BST or not
//  https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

//  METHOD 1 - Using min & max.
import java.util.*;

public class Main {
  public static void main(String args[]) {
    BST b = new BST();
    b.root = new Node();
    b.root = new Node();
    b.root = new Node();
    b.root = new Node();
    b.root = new Node();
    b.root = new Node();
    b.root = new Node();
    System.out.println(b.isBST());
  }
}

class BST {
  Node root;
  BST() {
    root = null;
  }
  public boolean isBST() {
    return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean isBSTUtil(Node root, int min, int max) {
    if (root == null) return true;
    if (root.data < min || root.data > max) return false;
    return isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max);
  }
}

class Node {
  int data;
  Node left, right;
  Node(int data) {
    this.data = data;
  }
}