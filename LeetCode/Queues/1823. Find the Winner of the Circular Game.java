class Solution {
  public int findTheWinner(int n, int k) {
    int count = 1;
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    if (k == 1) return n;
    for (int i = 1; i <= n; i++) queue1.add(i);
    while (true) {
      while (queue1.size() != 0) {
        int val = queue1.poll();
        if (count % k != 0) queue2.add(val);
        count++;
      }
      if (queue2.size() == 1) return queue2.poll();
      while (queue2.size() != 0) {
        int val = queue2.poll();
        if (count % k != 0) queue1.add(val);
        count++;
      }
      if (queue1.size() == 1) return queue1.poll();
    }
  }
}