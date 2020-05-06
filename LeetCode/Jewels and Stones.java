//  Jewels and Stones
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/

class Solution {
  public int numJewelsInStones(String J, String S) {
    int count = 0;
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < J.length(); i++) set.add(J.charAt(i));
    for (int i = 0; i < S.length(); i++) if (set.contains(S.charAt(i))) count++;
    return count;
  }
}