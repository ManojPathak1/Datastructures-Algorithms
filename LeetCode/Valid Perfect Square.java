//  Valid Perfect Square
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/

class Solution {
  public boolean isPerfectSquare(int num) {
    int start = 1; 
    int end = 46340;
    return binarySearch(num, start, end);
  }
  public boolean binarySearch(int n, int start, int end) {
    int mid = (start + end) / 2;
    int num = mid * mid;
    if (num == n) return true;
    if (start == end || start > end) return false;
    if (num < n) return binarySearch(n, mid + 1, end);
    return binarySearch(n, start, mid - 1);
  }
}