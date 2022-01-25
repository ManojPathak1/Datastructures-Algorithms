class Solution {
  public ListNode swapNodes(ListNode head, int k) {
    ListNode curr = head;
    int n = 0;
    while (curr != null) {
      n++;
      curr = curr.next;
    }
    int firstIndex = k;
    int secondIndex = n - k;
    ListNode firstNode = head;
    ListNode secondNode = head;
    while (--firstIndex > 0) firstNode = firstNode.next;
    while (secondIndex-- > 0) secondNode = secondNode.next;
    int temp = firstNode.val;
    firstNode.val = secondNode.val;
    secondNode.val = temp;
    return head;
  }
}