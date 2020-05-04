//  Delete duplicate-value nodes from a sorted linked list
//  https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
  SinglyLinkedListNode current = head;
  while (current.next != null) {
    if (current.data == current.next.data) {
      current.next = current.next.next;
    } else {
      current = current.next;
    }
  }
  return head;
}