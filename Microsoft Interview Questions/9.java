//  Level order traversal in spiral form
//  https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Tree t = new Tree();
    t.root = new Node(1);
    t.root.left = new Node(2);
    t.root.right = new Node(3);
    t.root.right.right = new Node(4);
    t.root.right.left = new Node(5);
    t.root.left.right = new Node(6);
    t.root.left.left = new Node(7);
    t.printSpiralLOT();
  }
}

class Tree {
  Node root;
  private int height(Node root) {
    if (root == null) return 0;
    return Math.max(height(root.left) + 1, height(root.right) + 1);
  }
  // Print level order traversal.
  private void print(Node root, int level, boolean flag) {
    if (root == null) return;
    else if (level == 1) System.out.print(root.data + " ");
    else if (level > 1) {
      if (flag) {
        print(root.left, level - 1, flag);
        print(root.right, level - 1, flag);
      } else {
        print(root.right, level - 1, flag);
        print(root.left, level - 1, flag);
      }
    }
  }
  public void printSpiralLOT() {
    int height = height(root);
    boolean flag = false;
    for (int i = 1; i <= height; i++) {
      print(root, i, flag);
      flag = !flag;
    }
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