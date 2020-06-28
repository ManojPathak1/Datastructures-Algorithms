// Is Subsequence
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/

class Solution {
  public boolean isSubsequence(String s, String t) {
    char chS[] = s.toCharArray();
    char chT[] = t.toCharArray();
    int sLen = chS.length;
    int tLen = chT.length;
    int sIndex = 0;
    int tIndex = 0;
    if (sLen == tLen) return s.equals(t);
    while (sIndex < sLen) {
      while (tIndex < tLen) {
        if (chS[sIndex] == chT[tIndex++]) {
          sIndex++;
          break;
        }
      }
      if (sIndex == sLen) return true;
      if (tIndex == tLen) return false;
    }
    return sIndex == sLen;
  }
}