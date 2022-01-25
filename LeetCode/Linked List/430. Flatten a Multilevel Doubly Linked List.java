class Solution {
  public Node flatten(Node head) {
    Node curr = head;
    while (curr != null) {
      Node childCurr = curr.child;
      if (childCurr != null) {
        Node currNext = curr.next;
        curr.child = null;
        curr.next = childCurr;
        childCurr.prev = curr;
        while (childCurr.next != null) {
          childCurr = childCurr.next;
        }
        if (currNext != null) {
          childCurr.next = currNext;
          currNext.prev = childCurr;
        }
      }
      curr = curr.next;
    }
    return head;
  }
}