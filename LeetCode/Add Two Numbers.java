//  Add Two Numbers
//  https://leetcode.com/problems/add-two-numbers/

class Solution {
  public ListNode addTwoNumbers(ListNode c1, ListNode c2) {
    int carry = 0;
    ListNode l1 = c1;
    ListNode l2 = c2;
    ListNode res = null;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      carry = sum / 10;
      res = add(res, sum % 10);
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int sum = l1.val + carry;
      carry = sum / 10;
      res = add(res, sum % 10);
      l1 = l1.next;
    }
    while (l2 != null) {
      int sum = l2.val + carry;
      carry = sum / 10;
      res = add(res, sum % 10);
      l2 = l2.next;
    }
    if (carry == 1) add(res, carry);
    return res;
  }
  public ListNode add(ListNode res, int e) {
    ListNode curr = res;
    if (res == null) {
      res = new ListNode(e, null);
      return res;
    }
    while (curr.next != null) curr = curr.next;
    curr.next = new ListNode(e, null);
    return res;
  }
}