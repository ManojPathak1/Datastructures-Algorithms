// Surrounded Regions
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/

class Solution {
  public void solve(char[][] board) {
    int rows = board.length;
    int columns = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        int e = board[i][j];

      }
    }      
  }
  public boolean isValid(int r, int c, ArrayList<Pair> visited, int rows, int columns, char[][] board) {
    if (r == 0 || c == 0 || r == rows - 1 || c == columns - 1) return false;
    int val1 = board[r - 1][c - 1];
    int val2 = board[r - 1][c + 1];
    int val3 = board[r + 1][c - 1];
    int val3 = board[r + 1][c + 1];
    int isVisited1 = isVisited(r - 1, c - 1, visited);
    int isVisited2 = isVisited(r - 1, c + 1, visited);
    int isVisited3 = isVisited(r + 1, c - 1, visited);
    int isVisited4 = isVisited(r + 1, c + 1, visited);
    if (val1 == 'O' && !isVisited1) visited.add(new Pair(r - 1, c - 1));
    return val1 == 'X' || val1 == 'O' && isVisited1 || val1 == 'O' && isValid(r - 1, c - 1, visited, rows, columns, board);
  }
  
  public boolean checkForNo(int val, boolean isVisited, ) {

  }
}


// Still pending