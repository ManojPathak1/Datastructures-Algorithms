// Path Crossing
// https://leetcode.com/contest/weekly-contest-195/problems/path-crossing/

class Solution {
  public boolean isPathCrossing(String path) {
    HashSet<String> hset = new HashSet<>();
    int x = 0;
    int y = 0;
    hset.add(toString(x, y));
    char ch[] = path.toCharArray();
    for (char e : ch) {
      switch(e) {
        case 'N': y++; break;
        case 'S': y--; break;
        case 'E': x++; break;
        case 'W': x--; break;
      }
      String elem = toString(x, y);
      if (hset.contains(elem)) return true;
      else hset.add(elem);
    }
    return false;
  }
  public String toString(int x, int y) {
    return Integer.toString(x) + ":" + Integer.toString(y);
  }
}