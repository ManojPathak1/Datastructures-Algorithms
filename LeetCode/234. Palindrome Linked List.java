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
  public boolean isPalindrome(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode current = head;
    while (current != null) {
      stack.push(current);
      current = current.next;
    }
    ListNode reversedList = new ListNode(-1);
    current = reversedList;
    while (!stack.isEmpty()) {
      current.next = new ListNode(stack.pop().val);
      current = current.next;
    }
    reversedList = reversedList.next;
    while (head != null) {
      if (head.val != reversedList.val) return false;
      head = head.next;
      reversedList = reversedList.next;
    }
    return true;
  }
}