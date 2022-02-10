class Solution {
  public List<Integer> postorder(Node root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    Deque<Node> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.removeLast();
      stack.push(node.val);
      for (Node n: node.children) {
        queue.add(n);
      }
    }
    while (!stack.empty()) list.add(stack.pop());
    return list; 
  }
}