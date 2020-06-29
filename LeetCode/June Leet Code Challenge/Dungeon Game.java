// Dungeon Game
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/

class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int reqPow = calculateMinimumHP(dungeon, 0, 0, dungeon[0][0]);
    if (reqPow )
    return 0 - calculateMinimumHP(dungeon, 0, 0, dungeon[0][0]) + 1;
  }
  public int calculateMinimumHP(int[][] dungeon, int i, int j, int sum, int minSum) {
    int m = dungeon.length;
    int n = dungeon[0].length;
    if (i >= m - 1 || j >= n - 1) return sum;
    int down = calculateMinimumHP(dungeon, i + 1, j, sum);
    int right = calculateMinimumHP(dungeon, i, j + 1, sum);
    int returnSum = sum + Math.max(down, right);
    minSum = Math.min(minSum, returnSum);
    return returnSum;
  }
}

// Not able to solve, TODO.