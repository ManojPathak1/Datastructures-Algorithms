class Solution {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    int result[] = new int[2];
    result[0] = -1;
    result[1] = -1;
    if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) return result;
    int index = 0;
    ArrayList<Integer> cp = new ArrayList<>();
    ListNode prev = head, curr = head.next;
    while (curr.next != null) {
      if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val))
        cp.add(index);
      prev = curr;
      curr = curr.next;
      index++;
    }
    if (cp.size() == 0 || cp.size() == 1) return result;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int el: cp) {
      max = Math.max(max, el);
      min = Math.min(min, el);
    }
    result[1] = max - min;
    min = Integer.MAX_VALUE;
    for (int i = 1; i < cp.size(); i++) {
      min = Math.min(min, cp.get(i) - cp.get(i - 1));
    }
    result[0] = min;
    return result;
  }
}