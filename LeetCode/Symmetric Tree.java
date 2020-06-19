//  Symmetric Tree
//  https://leetcode.com/problems/symmetric-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;  // If the root is null then the tree is symmetric.
    return isMirror(root.left, root.right); // Checking for the left subtree and right subtree.
  }
  public boolean isMirror(TreeNode tree1, TreeNode tree2) {
    // Checking if any of the left or right tree is null.
    if (tree1 == null || tree2 == null) return tree1 == tree2;
    if (tree1.val != tree2.val) return false;
    return isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
  }
}