class Solution {
  public ListNode deleteMiddle(ListNode head) {
    ListNode slow = head, fast = head, prev = head;
    if (head.next == null) return null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = prev.next.next;
    return head;
  }
}