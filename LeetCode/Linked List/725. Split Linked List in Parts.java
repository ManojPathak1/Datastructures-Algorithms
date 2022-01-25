class Solution {
  public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode cur = head, startNode = head;
    int len = length(head);
    int m = k;
    ListNode result[] = new ListNode[k];
    while (k > 0) {
      int ne = (int) Math.ceil((double) len / k);
      cur = startNode;
      result[m - k] = startNode;
      while (ne > 1) {
        cur = cur.next;
        ne--;
        len--;
      }
      if (cur != null) {
        startNode = cur.next;
        cur.next = null; 
        len--;
      }
      k--;
    }
    return result;
  }

  private int length(ListNode head) {
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    return len;
  }
}