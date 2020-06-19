//  Merge Two Sorted Lists
//  https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode curr1 = l1;
    ListNode curr2 = l2;
    ListNode result = null;
    while (curr1 != null && curr2 != null) {
      int data1 = curr1.val;
      int data2 = curr2.val;
      result = add(result, Math.min(data1, data2));
      if (data1 > data2) curr2 = curr2.next;
      else curr1 = curr1.next;
    }
    while (curr1 != null) {
      result = add(result, curr1.val);
      curr1 = curr1.next;
    }
    while (curr2 != null) {
      result = add(result, curr2.val);
      curr2 = curr2.next;
    }
    return result;     
  }

  public ListNode add(ListNode result, int data) {
    ListNode temp = result;
    ListNode newNode = new ListNode(data);
    if (result == null) {
      result = newNode;
      return result;
    }
    while (temp.next != null) temp = temp.next;
    temp.next = newNode;
    return result;
   }
}