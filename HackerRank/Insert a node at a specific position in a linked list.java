//  Insert a node at a specific position in a linked list
//  https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
  SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
  if (position == 0) {
    newNode.next = head;
    return newNode;
  }
  SinglyLinkedListNode current = head;
  while (position > 1) {
    current = current.next;
    position--;
  }
  newNode.next = current.next;
  current.next = newNode;
  return head;
}