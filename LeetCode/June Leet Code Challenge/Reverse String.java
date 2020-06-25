//  Reverse String
//  https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/

class Solution {
  public void reverseString(char[] s) {
    int l = 0;
    int h = s.length - 1;
    while (l < h) {
      char temp = s[l];
      s[l] = s[h];
      s[h] = temp;
      l++;
      h--;
    }
  }
}