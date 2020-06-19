//  Remove Duplicates from Sorted List
//  https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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

//  1->1->2->3->3
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null) {
      int val1 = current.val;
      ListNode temp = current.next;
      while (temp != null && val1 == temp.val) temp = temp.next;
      current.next = temp;
      current = current.next;
    }
    return head;
  }
}