class Solution {
  public int pairSum(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    ListNode curr = head;
    int n = 0, max = 0;
    while (curr != null) {
      stack.push(curr.val);
      n++;
      curr = curr.next;
    }
    curr = head;
    n /= 2;
    while (curr != null && n != 0) {
      max = Math.max(curr.val + stack.pop(), max);
      curr = curr.next;
      n--;
    }
    return max;
  }
}