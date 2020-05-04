//  Merge two sorted linked lists
//  https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
  SinglyLinkedListNode current1 = head1;
  SinglyLinkedListNode current2 = head2;
  SinglyLinkedListNode result = null;
  while (current1 != null && current2 != null) {
    if (current1.data > current2.data) {
      result = add(result, current2.data);
      current2 = current2.next;
    } else {
      result = add(result, current1.data);
      current1 = current1.next;
    }
  }
  while (current1 != null) {
    result = add(result, current1.data);
    current1 = current1.next;
  }
  while (current2 != null) {
    result = add(result, current2.data);
    current2 = current2.next;
  }
  return result;
}

static SinglyLinkedListNode add(SinglyLinkedListNode head, int data) {
  SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
  SinglyLinkedListNode current = head;
  if (head == null) {
    head = newNode;
    return head;
  }
  while (current.next != null) current = current.next;
  current.next = newNode;
  return head;
}