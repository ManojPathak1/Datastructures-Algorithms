//  https://leetcode.com/problems/longest-common-prefix/

//  My Solution
class Solution {
  public String longestCommonPrefix(String[] strs) {
    String prefix = "";
    int currentIndex = 0;
    while (true) {
      boolean isEqual = true;
      if (strs.length == 0 || strs[0].length() - 1 < currentIndex) break;
      char ch1 = strs[0].charAt(currentIndex);
      for (int i = 0; i < strs.length; i++) {
        String s = strs[i];
        if (strs[i].length() - 1 < currentIndex || strs[i].charAt(currentIndex) != ch1) {
          isEqual = false;
          break;
        }
      }
      if (!isEqual) break;
      currentIndex++;
      prefix += ch1;
    }
    return prefix;
  }
}