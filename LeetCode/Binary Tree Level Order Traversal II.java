// Binary Tree Level Order Traversal II
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/

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
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    int height = getHeight(root);
    List<List<Integer>> result = new ArrayList<>();
    for (int level = height; level >= 1; level--) {
      List<Integer> list = new ArrayList<>();
      level(root, level, list);
      result.add(list);
    }
    return result;
  }
  public void level(TreeNode root, int level, List<Integer> list) {
    if (root == null) return;
    if (level == 1) list.add(root.val);
    else {
      level(root.left, level - 1, list);
      level(root.right, level - 1, list);
    }
  }
  public int getHeight(TreeNode root) {
    if (root == null) return 0;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}