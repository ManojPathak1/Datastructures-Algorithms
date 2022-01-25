class Solution {
  public int[] nextLargerNodes(ListNode head) {
    ListNode curr = head;
    int n = 0, i = -1;
    while (curr != null) {
      n++;
      curr = curr.next;
    }
    int result[] = new int[n];
    curr = head;
    while (curr != null) {
      i++;
      ListNode curr2 = curr.next;
      while (curr2 != null) {
        result[i] = 0;
        if (curr2.val > curr.val) {
          result[i] = curr2.val;
          break;
        }
        curr2 = curr2.next;
      }
      curr = curr.next;
    }
    return result;
  }
}