//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
//  Number Complement

class Solution {
  public int findComplement(int num) {
    int value = 0;
    int i = 0;
    while (num > 0) {
      if ((num % 2) == 0) value += Math.pow(2, i);
      num /= 2;
      i++;
    }  
    return value;
  }
}