//  Get Node Value
//  https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem?h_r=next-challenge&h_v=zen

static int getNode(SinglyLinkedListNode head, int positionFromTail) {
  int len = length(head);
  int position = len - positionFromTail;
  SinglyLinkedListNode current = head;
  int i = 1;
  while (current != null) {
    if (position == i) return current.data;
    current = current.next;
    i++;
  }
  return -1;
}

static int length(SinglyLinkedListNode head) {
  int len = 0;
  SinglyLinkedListNode current = head;
  while (current != null) {
    len++;
    current = current.next;
  }
  return len;
}