//  Check If It Is a Straight Line
//  https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/

class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
    int x1 = coordinates[0][0];
    int y1 = coordinates[0][1];
    int x2 = coordinates[1][0];
    int y2 = coordinates[1][1];
    for (int i = 2; i < coordinates.length; i++) {
      int x = coordinates[i][0];
      int y = coordinates[i][1];
      int value = (y-y1)*(x2-x1)-(y2-y1)*(x-x1);
      if (value != 0) return false; 
    }
    return true;
  }
}