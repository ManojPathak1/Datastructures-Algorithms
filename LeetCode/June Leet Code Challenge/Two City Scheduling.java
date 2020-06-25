//  Two City Scheduling
//  https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/

class Solution {
  public int twoCitySchedCost(int[][] costs) {
    int n = costs.length;
    ArrayList<int[]> a = new ArrayList<>();
    ArrayList<int[]> b = new ArrayList<>();
    for (int i = 0; i < costs.length; i++) {
      if (costs[i][0] < costs[i][1]) a.add(costs[i]);
      else b.add(costs[i]);
    }
    int sizeA = a.size();
    int sizeB = b.size();
    if (sizeA == sizeB) return getCost(a, b);
    int diff = Math.max(sizeA, sizeB) - (n/2);
    if (sizeA > sizeB) {
      for (int j = 1; j <= diff; j++) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
          int e[] = a.get(i);
          int num = Math.abs(e[0] - e[1]);
          if (num < min) {
            min = num;
            minIndex = i;
          }
        }
        b.add(a.remove(minIndex));
      }
    } else {
      for (int j = 1; j <= diff; j++) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < b.size(); i++) {
          int e[] = b.get(i);
          int num = Math.abs(e[0] - e[1]);
          if (num < min) {
            min = num;
            minIndex = i;
          }
        }
        a.add(b.remove(minIndex));
      }
    }
    return getCost(a, b);
  }
  public int getCost(ArrayList<int[]> a, ArrayList<int[]> b) {
    int cost = 0;
    for (int[] e1 : a) cost += e1[0];
    for (int[] e2 : b) cost += e2[1];
    return cost; 
  }
}