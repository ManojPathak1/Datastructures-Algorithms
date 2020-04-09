//  Maximum width of a binary tree
//  https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/

//  METHOD 1: Using Level Order Traversal.
import java.util.*;

public class Main {
  public static void main(String args[]) {
    Tree t = new Tree();
    t.root = new Node(1);
    t.root.left = new Node(2);
    t.root.right = new Node(3);
    t.root.left.left = new Node(4);
    t.root.left.right = new Node(5);
    t.root.right.right = new Node(8);
    t.root.left.left.left = new Node(9);
    t.root.left.left.right = new Node(10);
    t.root.right.right.left = new Node(6);
    t.root.right.right.right = new Node(7);
    System.out.println(t.getMaxWidth());
  }
}

class Tree {
  Node root;
  private int getHeight(Node root) {
    if (root == null) return 0;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
  private int getWidth(Node root, int level) {
    if (root == null) return 0;
    if (level == 1) return 1;
    else return getWidth(root.left, level - 1) + getWidth(root.right, level - 1);
  }
  public int getMaxWidth() {
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= getHeight(root); i++) {
      int width = getWidth(root, i);
      if (width > max) max = width;
    }
    return max;
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


// METHOD 2: Level Order Traversal using Queue based method.