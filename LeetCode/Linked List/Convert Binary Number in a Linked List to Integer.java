class Solution {
  public int getDecimalValue(ListNode head) {
    int dec = 0;
    int pow = getLinkedListLength(head) - 1;
    while (head != null) {
      int bin = head.val;
      dec += bin == 1 ? Math.pow(2, pow) : 0;
      pow--;
      head = head.next;
    }
    return dec;
  }

  private int getLinkedListLength(ListNode head) {
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    return len;
  }
}