class Solution {
  public int minSwaps(String s) {
    int n = s.length(), open = 0, close = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '[') open++;
      else if (open > 0) open--;
      else close++;
    }
    if (open == 0) return 0;
    return (int) Math.ceil((double) open / 2);
  }
}