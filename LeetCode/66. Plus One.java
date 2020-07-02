// 66. Plus One
// https://leetcode.com/problems/plus-one/

class Solution {
  public int[] plusOne(int[] digits) {
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      int e = digits[i];
      if (e == 9) {
        digits[i] = 0;
        continue;
      }
      digits[i] = e + 1;
      break;
    }
    if (digits[0] == 0) {
      int result[] = new int[len + 1];
      result[0] = 1;
      for (int i = 0; i < len; i++) result[i + 1] = digits[i];
      return result;
    }
    return digits;     
  }
}