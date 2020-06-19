//  First Unique Character in a String
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/

class Solution {
  public int firstUniqChar(String s) {
    char cArr[] = s.toCharArray();
    HashMap<Character, Integer> hmap = new HashMap<>();
    for (char e : cArr) {
      if (hmap.containsKey(e)) hmap.put(e, hmap.get(e) + 1);
      else hmap.put(e, 1);
    }
    for (int i = 0; i < cArr.length; i++) {
      if (hmap.get(cArr[i]) == 1) return i;
    }
    return -1;
  }
}