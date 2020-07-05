// Prison Cells After N Days
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/

class Solution {
  public int[] prisonAfterNDays(int[] cells, int N) {
    int len = cells.length;
    for (int i = 1; i <= N; i++) {
      int cellsClone[] = new int[len];
      cellsClone[0] = 0;
      cellsClone[len - 1] = 0;
      for (int j = 1; j < len - 1; j++) {
        int prev = cells[j - 1];
        int next = cells[j + 1];
        if ((prev == 1 && next == 1) || (prev == 0 && next == 0)) cellsClone[j] = 1;
        else cellsClone[j] = 0;
      }
      cells = cellsClone;
    }
    return cells;   
  }
}