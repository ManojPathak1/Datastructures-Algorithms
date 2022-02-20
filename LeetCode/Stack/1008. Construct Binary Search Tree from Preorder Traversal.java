class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {
    TreeNode root = new TreeNode(preorder[0]);
    TreeNode last = null;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    for (int i = 1; i < preorder.length; i++) {
      int num = preorder[i];
      TreeNode newNode = new TreeNode(num);
      if (stack.peek().val > num) {
        stack.peek().left = newNode;
      } else {
        while (!stack.empty() && stack.peek().val < num) last = stack.pop();
        last.right = newNode;
      }
      stack.push(newNode);
    }
    return root;
  }
}