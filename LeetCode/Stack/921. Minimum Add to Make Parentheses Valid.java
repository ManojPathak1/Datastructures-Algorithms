class Solution {
  public int minAddToMakeValid(String s) {
    int open = 0, close = 0, n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '(') open++;
      else if (open > 0) open--;
      else close++; 
    }
    return open + close;
  }
}