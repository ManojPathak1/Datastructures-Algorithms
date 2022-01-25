class Solution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    Queue<Integer> ticketsQ = new LinkedList<>();
    for (int t: tickets) ticketsQ.add(t);
    int ticketsCount = tickets[k];
    int seconds = 0;
    while (ticketsCount != 0) {
      int t = ticketsQ.poll() - 1;
      if (t != 0) ticketsQ.add(t);
      if (k == 0) {
        ticketsCount--;
        k = ticketsQ.size() - 1;
      } else {
        k--;
      }
      seconds++;
    }
    return seconds;
  }
}