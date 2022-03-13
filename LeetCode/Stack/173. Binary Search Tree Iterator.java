class BSTIterator {

  Stack<Integer> stack = new Stack<>();
  Stack<Integer> tempStack = new Stack<>();

  public BSTIterator(TreeNode root) {
    inorder(root);
    while (!stack.empty()) tempStack.push(stack.pop());
  }

  private void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    stack.push(root.val);
    inorder(root.right);
  }
  
  public int next() {
    return tempStack.pop();
  }
  
  public boolean hasNext() {
    return !tempStack.empty();
  }
}