//  Is This a Binary Search Tree?
//  https://www.hackerrank.com/challenges/is-binary-search-tree/problem

boolean checkBST(Node root) {
  if (root == null) return true;
  if (root.left != null && root.left.data > root.data) return false;
  if (root.right != null && root.right.data < root.data) return false;
  return checkBST(root.left) && checkBST(root.right);         
}