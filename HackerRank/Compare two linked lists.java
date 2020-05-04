//  Compare two linked lists
//  https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?h_r=next-challenge&h_v=zen

static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
  SinglyLinkedListNode current1 = head1;
  SinglyLinkedListNode current2 = head2;
  while (current1 != null && current2 != null) {
    if (current1.data != current2.data) return false;
    current1 = current1.next;
    current2 = current2.next;
  }
  if (current1 != null || current2 != null) return false;
  return true;
}