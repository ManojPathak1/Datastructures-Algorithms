class Solution {

  private ListNode head;

  public Solution(ListNode head) {
    this.head = head;
  }
    
  public int getRandom() {
    int rand = (int)(Math.random() * length()) + 1;
    ListNode cur = head;
    int count = 1;
    while (cur != null && rand != count) {
      cur = cur.next;
      count++;
    }
    return cur.val;
  }

  private int length() {
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      len++;
    }
    return len;
  }
}

// Try using another method.