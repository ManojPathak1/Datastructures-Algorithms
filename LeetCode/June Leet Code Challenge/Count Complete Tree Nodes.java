// Count Complete Tree Nodes
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/

// Number of tree nodes using Level Order Traversal.

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
  public int countNodes(TreeNode root) {
    int height = getHeight(root);
    int sum = 0;
    for (int i = 1; i <= height; i++) sum += getGivenLevelNodes(root, i);
    return sum;
  }
  public int getHeight(TreeNode root) {
    if (root == null) return 0;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
  public int getGivenLevelNodes(TreeNode root, int level) {
    if (root == null || level == 0) return 0;
    if (level == 1) return 1;
    return getGivenLevelNodes(root.left, level - 1) + getGivenLevelNodes(root.right, level - 1);
  }
}