//  Maximum Depth of Binary Tree
//  https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
  public int maxDepth(TreeNode root) {
    return height(root);
  }
  public int height(TreeNode root) {
    if (root == null) return 0;
    int lHeight = height(root.left);  // Calculating left side of binary tree.
    int rHeight = height(root.right); // Calculating right side of binary tree.
    return Math.max(lHeight, rHeight) + 1;  // Maximum height of both the tree + 1.
  }
}