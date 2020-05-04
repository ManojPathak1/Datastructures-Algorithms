//  https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
//  Reverse a linked list

static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
  Stack<Integer> stack = new Stack<>();
  SinglyLinkedListNode current = head;
  SinglyLinkedListNode reverse = null;
  while (current != null) {
    stack.push(current.data);
    current = current.next;
  }
  while (!stack.empty()) {
    reverse = add(reverse, stack.pop());
  }
  return reverse;
}

static SinglyLinkedListNode add(SinglyLinkedListNode head, int data) {
  SinglyLinkedListNode current = head;
  SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
  if (head == null) {
    head = newNode;
    return head;
  };
  while (current.next != null) current = current.next;
  current.next = newNode;
  return head;
}