class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode left = head;
    ListNode mid = getMid(head);
    ListNode right = mid.next;
    mid.next = null;
    left = sortList(left);
    right = sortList(right);
    return merge(left, right);
  }

  private ListNode getMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return fast;
  }

  private ListNode merge(ListNode list1, ListNode list2) {
    ListNode result = new ListNode();
    while (list1 != null && list2 != null) {
      int el1 = list1.val;
      int el2 = list2.val;
      if (el1 < el2) {
        result.next = list1;
        list1 = list1.next;
      } else {
        result.next = list2;
        list2 = list2.next;
      }
      result = result.next;
    }
    while (list1 != null) {
      result.next = list1;
    }
    while (list2 != null) {
      result.next = list2;
    }
    return result;
  }
}