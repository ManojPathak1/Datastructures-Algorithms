//  Find Merge Point of Two Lists
//  https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
  int c1 = getCount(head1);
  int c2 = getCount(head2);
  if (c1 > c2) return getIntersection(c1 - c2, head1, head2);
  return getIntersection(c2 - c1, head2, head1);
}

static int getCount(SinglyLinkedListNode head) {
  SinglyLinkedListNode current = head;
  int count = 0;
  if (current != null) {
    current = current.next;
    count++;
  }
  return count;
}

static int getIntersection(int d, SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
  SinglyLinkedListNode current1 = head1;
  SinglyLinkedListNode current2 = head2;
  while (d > 0) {
    current1 = current1.next;
    d--;
  }
  while (current1 != null && current2 != null) {
    if (current1 == current2) return current1.data;
    current1 = current1.next;
    current2 = current2.next;
  }
  return -1;
}

// Second test case failure