class Solution {
  private List<Integer> result = new ArrayList<>();
  public List<Integer> preorder(Node root) {
    recur(root);
    return result;
  }

  private void recur(Node root) {
    if (root == null) return;
    result.add(root.val);
    if (root.children != null) {
      for (Node node: root.children) recur(node);
    }
  }
}