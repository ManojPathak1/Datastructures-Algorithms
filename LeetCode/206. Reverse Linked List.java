// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/

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
  public ListNode reverseList(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    ListNode reversedList = new ListNode(-1);
    head = reversedList;
    while (!stack.isEmpty()) {
      ListNode current = stack.pop();
      head.next = new ListNode(current.val);
      head = head.next;
    }
    return reversedList.next;
  }
}