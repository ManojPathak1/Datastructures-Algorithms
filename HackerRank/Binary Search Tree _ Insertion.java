//  Binary Search Tree : Insertion
//  https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

public static Node insert(Node root, int data) {
  if (root == null) {
    root = new Node(data);
    return root;
  }
  if (data < root.data) root.left = insert(root.left, data); 
  else if (data > root.data) root.right = insert(root.right, data);
  return root;
}