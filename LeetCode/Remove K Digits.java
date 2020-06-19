//  Remove K Digits
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/

class Solution {
  public String removeKdigits(String num, int k) {
    char ch[] = num.toStringArray();
    if (ch.length == k) return 0;
    int i = 0;
    int j = 1;
    int e1, e2;
    String newStr = "";
    while (k > 0) {
      e1 = ch[i];
      e2 = ch[j];
      if (toNum(e1) > toNum(e2)) {
        newStr += e2;
        i = j;
        j += 1;
      } else {
        newStr += e1;
        j += 1;
      }
      k--;
    }
    System.out.println(newStr);
  }
  public int toNum(char ch) {
    return String.valueOf(ch);
  }
}

//  Some Improvements needed