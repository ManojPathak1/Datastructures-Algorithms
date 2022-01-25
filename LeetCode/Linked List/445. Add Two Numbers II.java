class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    Stack<Integer> s3 = new Stack<>();
    while (l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    }
    while (l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }
    int quotient = 0;
    while (s1.size() != 0 || s2.size() != 0 || quotient == 1) {
      int e1 = s1.size() > 0 ? s1.pop() : 0;
      int e2 = s2.size() > 0 ? s2.pop() : 0;
      int sum = e1 + e2 + quotient;
      quotient = sum >= 10 ? 1 : 0;
      sum = sum % 10;
      s3.push(sum);
    }
    while (s1.size() != 0) s3.push(s1.pop());
    while (s2.size() != 0) s3.push(s2.pop());
    ListNode head = null;
    if (s3.size() != 0) head = new ListNode(s3.pop());
    ListNode curr = head;
    while (s3.size() != 0) {
      curr.next = new ListNode(s3.pop());
      curr = curr.next;
    }
    return head;
  }
}