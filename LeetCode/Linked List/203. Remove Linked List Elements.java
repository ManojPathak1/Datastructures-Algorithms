class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode curr = head;
    ListNode prev = null;
    while (curr != null) {
      if (curr.val == val) {
        if (prev == null) head = head.next;
        else prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }
    return head;
  }
}