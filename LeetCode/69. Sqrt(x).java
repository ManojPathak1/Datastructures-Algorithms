//  Using the binary search method.
//  69. Sqrt(x)

class Solution {
  public int mySqrt(int x) {
    int res = 0;
    if (x == 0) return res;
    int start = 1;
    int end = x;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (mid <= x / mid) {
        res = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }
}