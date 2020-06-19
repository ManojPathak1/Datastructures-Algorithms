//  First Bad Version
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    for (int i = 1; i <= n; i++) if (isBadVersion(i)) return i;
    return 0;
  }
}