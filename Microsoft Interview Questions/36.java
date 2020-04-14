//  Root to leaf path sum equal to a given number
//  https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    Tree t = new Tree();
    t.root = new Node(1);
    t.root.left = new Node(2);
    t.root.right = new Node(3);
    t.root.left.left = new Node(4);
    t.root.left.right = new Node(5);
    t.root.right.left = new Node(6);
    t.root.right.right = new Node(7);
    int tc = scan.nextInt();
    while(tc > 0) {
      int n = scan.nextInt();
      System.out.println(t.isNumberExist(n));
      tc--;
    }
  }
}

class Tree {
  Node root;
  private ArrayList<Integer> sums = new ArrayList<>();
  private void sumsOfPath(Node root, ArrayList<Integer> sums, int sum) {
    if (root == null) return;
    sum += root.data;
    if (root.left == null && root.right == null) {
      sums.add(sum);
      return;
    } else {
      sumsOfPath(root.left, sums, sum);
      sumsOfPath(root.right, sums, sum);
    }
  }
  public boolean isNumberExist(int k) {
    sumsOfPath(root, sums, 0);
    for (int e : sums) if (e == k) return true;
    return false; 
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