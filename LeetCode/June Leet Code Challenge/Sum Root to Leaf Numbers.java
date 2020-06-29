// Sum Root to Leaf Numbers
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/

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
  public int sumNumbers(TreeNode root) {
    return pathRecur(root, 0);
  }
  public int pathRecur(TreeNode root, int val) {
    if (root == null) return 0;
    val = val * 10 + root.val;
    if (root.left == null && root.right == null) return val;
    return pathRecur(root.left, val) + pathRecur(root.right, val);
  }
}