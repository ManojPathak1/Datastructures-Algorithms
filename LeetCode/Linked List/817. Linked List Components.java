class Solution {
  public int numComponents(ListNode head, int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int el: nums) set.add(el);
    boolean componentFound = false;
    ListNode cur = head;
    int count = 0;
    while (cur != null) {
      int val = cur.val;
      if (set.contains(val)) {
        componentFound = true;
        set.remove(val);
      } else {
        if (componentFound) count++;
        componentFound = false; 
      }
      cur = cur.next;
    }
    if (componentFound) count++;
    return count;
  }
}