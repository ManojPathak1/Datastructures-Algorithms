//  https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//  Lowest Common Ancestor in a Binary Tree | Set 1

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
    System.out.println(t.getLCA(1, 1));
    System.out.println(t.getLCA(1, 2));
    System.out.println(t.getLCA(4, 5));
    System.out.println(t.getLCA(6, 7));
    System.out.println(t.getLCA(8, 3));
    System.out.println(t.getLCA(8, 8));
  } 
}

class Tree {
  Node root;
  private ArrayList<Integer> path1 = new ArrayList<>();
  private ArrayList<Integer> path2 = new ArrayList<>();
  private boolean findPath(Node root, int n, ArrayList<Integer> path) {
    if (root == null) return false;
    path.add(root.data);
    if (root.data == n) return true;
    if (root.left != null && findPath(root.left, n, path)) return true;
    if (root.right != null && findPath(root.right, n, path)) return true;
    path.remove(path.size() - 1); // Delete last element.
    return false;
  }
  public int getLCA(int e1, int e2) {
    path1.clear();
    path2.clear();
    boolean e1Status = findPath(root, e1, path1);
    boolean e2Status = findPath(root, e2, path2);
    if (!(e1Status && e2Status)) {
      if (path1.size() > 0) {
        System.out.print("n1 exist. n2 doesn't exist.");
        return -1;
      } else if (path2.size() > 0) {
        System.out.print("n2 exist. n1 doesn't exist.");
        return -1;
      } else {
        System.out.print("Both n1 & n2 doesn't exist.");
        return -1;
      }
    }
    int min = Math.min(path1.size(), path2.size());
    int i;
    for (i = 0; i < min; i++)
      if (!(path1.get(i) == path2.get(i))) break;
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