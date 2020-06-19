//  Tree Isomorphism Problem
//  https://www.geeksforgeeks.org/tree-isomorphism-problem/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Tree tree = new Tree();
    tree.root1 = new Node(1); 
    tree.root1.left = new Node(2); 
    tree.root1.right = new Node(3); 
    tree.root1.left.left = new Node(4); 
    tree.root1.left.right = new Node(5); 
    tree.root1.right.left = new Node(6); 
    tree.root1.left.right.left = new Node(7); 
    tree.root1.left.right.right = new Node(8); 
   
    tree.root2 = new Node(1); 
    tree.root2.left = new Node(3); 
    tree.root2.right = new Node(2); 
    tree.root2.right.left = new Node(4); 
    tree.root2.right.right = new Node(5); 
    tree.root2.left.right = new Node(6); 
    tree.root2.right.right.left = new Node(8); 
    tree.root2.right.right.right = new Node(7);
    System.out.println(tree.isIsomorphic());
  }
}

class Tree {
  Node root1, root2;
  public boolean isIsomorphic() {
    return isIsomorphic(root1, root2);
  }
  private boolean isIsomorphic(Node root1, Node root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    if (root1.data != root2.data) return false;
    return
      (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) ||
      (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
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