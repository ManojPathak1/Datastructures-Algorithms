//  Cycle Detection
//  https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem

static boolean hasCycle(SinglyLinkedListNode head) {
  SinglyLinkedListNode slow = head;
  SinglyLinkedListNode fast = head;
  while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) return true;
  }
  return false;
}