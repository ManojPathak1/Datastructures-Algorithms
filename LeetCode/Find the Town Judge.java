//  Find the Town Judge
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/

class Solution {
  public int findJudge(int N, int[][] trust) {
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    if (trust.length == 0) return N;
    for (int t[] : trust) {
      int p1 = t[0];
      int p2 = t[1];
      set.add(p1);
      if (map.containsKey(p2)) map.put(p2, map.get(p2) + 1);
      else map.put(p2, 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      if (!set.contains(key) && value == N - 1) return key; 
    }
    return -1;
  }
}