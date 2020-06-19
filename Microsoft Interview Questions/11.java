//  Lowest Common Ancestor in a Binary Search Tree.
//  https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

// METHOD 1: Using path variable.

import java.util.*;

public class Main {
  public static void main(String args[]) {
    BST bt = new BST();
    bt.root = new Node(20);
    bt.root.left = new Node(8);
    bt.root.right = new Node(22);
    bt.root.left.left = new Node(4);
    bt.root.left.right = new Node(12);
    bt.root.left.right.left = new Node(10);
    bt.root.left.right.right = new Node(14);
    System.out.println(bt.getLCA(4, 14));
  }
}

class BST {
  Node root;
  private ArrayList<Integer> path1 = new ArrayList<>();
  private ArrayList<Integer> path2 = new ArrayList<>();
  private boolean getPath(Node root, int e, ArrayList<Integer> path) {
    if (root == null) { path.clear(); return false; }
    path.add(root.data);
    if (root.data == e) return true;
    if (root.data > e) return getPath(root.left, e, path);
    else return getPath(root.right, e, path);
  }
  public int getLCA(int e1, int e2) {
    path1.clear();
    path2.clear();
    boolean isN1Exist = getPath(root, e1, path1);
    boolean isN2Exist = getPath(root, e2, path2);
    int size1 = path1.size();
    int size2 = path2.size();
    if (!(isN1Exist && isN2Exist)) {
      if (size1 > 0) System.out.println("n1 exist, n2 doesn't.");
      else if (size2 > 0) System.out.println("n2 exist, n1 doesn't.");
      else System.out.println("Both n1 and n2 exist.");
      return -1;
    }
    int size = Math.min(size1, size2);
    int i;
    for (i = 0; i < size; i++) if (path1.get(i) != path2.get(i)) break;
    return path1.get(i - 1);
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


// METHOD 2: Recursive Solution

// METHOD 3: Iterative Solution