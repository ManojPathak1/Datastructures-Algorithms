// 38. Count and Say
// https://leetcode.com/problems/count-and-say/

class Solution {
  public String countAndSay(int n) {
    String result = "";
    String value = "1";
    if (n == 1) return value;
    for (int i = 2; i <= n; i++) {
      value = getValue(value);
    }
    return value;      
  }

  public String getValue(String str) {
    String result = "";
    char prev = '\0';
    char curr = '\0';
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      curr = str.charAt(i);
      if (prev != '\0' && curr != prev) {
        result += ""+count+""+curr;
        count = 1;
      } else {
        count++;
      }
      prev = curr;
    }
    result += ""+count+""+curr;
    return result;
  }
}