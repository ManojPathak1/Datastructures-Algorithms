// 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slowPtr = head;
    // Took fastPtr to next.
    ListNode fastPtr = head.next;
    // Compare ptr slow and fast and loop through.
    while (slowPtr != fastPtr) {
      // Find whether the fastPtr is null or its next value is null.
      if (fastPtr == null || fastPtr.next == null) {
        return false;
      }
      // Increment the slowPtr and fastPtr.
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }
    return true;      
  }
}