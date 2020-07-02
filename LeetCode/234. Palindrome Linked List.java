// 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/

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
    int len = getLinkedListLength(head);
    if (len == 0) return true;
    else if (len == 1) return true;
    int mid = len % 2 == 0 ? (len / 2) : (int)Math.ceil(len / 2);
    mid = mid - 1;
    head = reverseHalf(head, mid);
    mid = mid + 1;
    ListNode firstPtr = head;
    ListNode secondPtr = head;
    while (mid != 0) {
      mid--;
      secondPtr = secondPtr.next;
    }
    while (firstPtr != null && secondPtr != null && firstPtr.val == secondPtr.val) {
      System.out.println(firstPtr.val + " - " + secondPtr.val);
    System.out.println("---------------");
      firstPtr = firstPtr.next;
      secondPtr = secondPtr.next;
    }
    return firstPtr != null && secondPtr == null;
  }
  public ListNode reverseHalf(ListNode head, int mid) {
    ListNode current = head;
    while (mid != 0) {
      mid--;
      current = current.next;
    }
    current.next = reverse(current.next);
    return head;
  }
  public int getLinkedListLength(ListNode head) {
    int length = 0;
    ListNode current = head;
    while (current != null) {
      length++;
      current = current.next;
    }
    return length; 
  }
  public ListNode reverse(ListNode head) {
    ListNode next = null;
    ListNode current = head;
    ListNode prev = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
    return head;
  }
}

// TODO: Not able to solve.