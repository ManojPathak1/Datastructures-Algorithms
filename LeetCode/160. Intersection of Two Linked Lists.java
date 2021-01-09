/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Stack<ListNode> stack1 = new Stack<>();
    Stack<ListNode> stack2 = new Stack<>();

    ListNode result = null;

    while (headA != null) {
      stack1.push(headA);
      headA = headA.next;
    }
    while (headB != null) {
      stack2.push(headB);
      headB = headB.next;
    }

    while (!stack1.isEmpty() && !stack2.isEmpty()) {
      ListNode el1 = stack1.pop();
      ListNode el2 = stack2.pop();
      if (el1 == el2) {
        result = el1;
      } else {
        break;
      }
    }
    return result;
  }
}

// Space Complexity - O(1)
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int sizeA = getSize(headA);
    int sizeB = getSize(headB);
    int diff = Math.max(sizeA, sizeB) - Math.min(sizeA, sizeB);
    while (diff > 0) {
      if (sizeA > sizeB) {
        headA = headA.next;
      } else {
        headB = headB.next;
      }
      diff--;
    }
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  public int getSize(ListNode head) {
    int size = 0;
    if (head == null) return size;
    while (head != null) {
      size++;
      head = head.next;
    }
    return size;
  }
}