//  Cousins in Binary Tree
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/

class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    return (level(root, x, 1) == level(root, y, 1)) && !isSibling(root, x, y);
  }
  public boolean isSibling(TreeNode root, int x, int y) {
    if (root == null) return false;
    return (root.left != null && root.right != null && root.left.val == x && root.right.val == y) ||
      (root.left != null && root.right != null && root.left.val == y && root.right.val == y) ||
      isSibling(root.left, x, y) ||
      isSibling(root.right, x, y);
  }
  public int level(TreeNode root, int x, int level) {
    if (root == null) return 0;
    if (root.val == x) return level;
    int l = level(root.left, x, level + 1);
    if (l != 0) return l;
    return level(root.right, x, level + 1);
  }
}