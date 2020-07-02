// Word Search II
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/

class Solution {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    for (String e : words) {
      if (isWordExist(board, e.toCharArray())) {
        result.add(e);
      }
    }
    return result;
  }
  public boolean isWordExist(char[][] board, char[] word) {
    int rowLength = board.length;
    int colLength = board[0].length;
    for (int row = 0; row < rowLength; row++) {
      for (int col = 0; col < colLength; col++) {
        if (rowLength * colLength < word.length) return false;
        HashSet<String> visited = new HashSet<>();
        if (word[0] == board[row][col] && checkAdjacentElements(board, word, 1, word.length, row, col, rowLength, colLength, visited)) return true;
      }
    }
    return false;
  }
  public boolean checkAdjacentElements(char[][] board, char[] word, int index, int wordLength,
    int row, int col, int rowLength, int colLength, HashSet<String> visited) {
    // visited.add(intToString(row, col));
    if (index >= wordLength - 1) return true;
    char toMatch = word[index];
    boolean left = col != 0 && board[row][col - 1] == toMatch && !visited.contains(intToString(row, col - 1));
    boolean right = col != colLength - 1 && board[row][col + 1] == toMatch && !visited.contains(intToString(row, col + 1));
    boolean up = row != 0 && board[row - 1][col] == toMatch && !visited.contains(intToString(row - 1, col));
    boolean down = row != rowLength - 1 && board[row + 1][col] == toMatch && !visited.contains(intToString(row + 1, col));
    boolean leftUp = row != 0 && col != 0 && board[row - 1][col - 1] == toMatch && !visited.contains(intToString(row - 1, col - 1));
      boolean leftDown = row != rowLength -1 && col != 0 && board[row + 1][col - 1] == toMatch && !visited.contains(intToString(row + 1, col - 1));
      boolean rightUp = row != 0 && col != colLength - 1 && board[row - 1][col + 1] == toMatch && !visited.contains(intToString(row - 1, col + 1));
      boolean rightDown = row != rowLength - 1 && col != colLength - 1 && board[row + 1][col + 1] == toMatch && !visited.contains(intToString(row + 1, col + 1));
    return (left && checkAdjacentElements(board, word, index + 1, wordLength, row, col - 1, rowLength, colLength, visited)) ||
    (right && checkAdjacentElements(board, word, index + 1, wordLength, row, col + 1, rowLength, colLength, visited)) ||
    (up && checkAdjacentElements(board, word, index + 1, wordLength, row - 1, col, rowLength, colLength, visited)) ||
    (down && checkAdjacentElements(board, word, index + 1, wordLength, row + 1, col, rowLength, colLength, visited)) ||
        (leftUp && checkAdjacentElements(board, word, index + 1, wordLength, row - 1, col - 1, rowLength, colLength, visited)) ||
    (leftDown && checkAdjacentElements(board, word, index + 1, wordLength, row + 1, col - 1, rowLength, colLength, visited)) ||
    (rightUp && checkAdjacentElements(board, word, index + 1, wordLength, row - 1, col + 1, rowLength, colLength, visited)) ||
    (rightDown && checkAdjacentElements(board, word, index + 1, wordLength, row + 1, col + 1, rowLength, colLength, visited));
  }
  public String intToString(int a, int b) {
    return Integer.toString(a) + "-" + Integer.toString(b);
  }
}

// TODO: Not able to solve.