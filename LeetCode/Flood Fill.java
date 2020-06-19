//  Flood Fill
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/

class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int rows = image.length;
    int columns = image[0].length;
    boolean visited[][] = new boolean[rows][columns];
    for (int i = 0; i < visited.length; i++) Arrays.fill(visited[i], false);
    Queue<Index> queue = new LinkedList<>();
    queue.add(new Index(sr, sc));
    while (!queue.isEmpty()) {
      Index i = queue.poll();
      sr = i.i;
      sc = i.j;
      visited[sr][sc] = true;
      int color = image[sr][sc];
      image[sr][sc] = newColor;
      if (sr > 0 && image[sr - 1][sc] == color && !visited[sr - 1][sc])
        queue.add(new Index(sr - 1, sc));
      if (sr < rows - 1 && image[sr + 1][sc] == color && !visited[sr + 1][sc])
        queue.add(new Index(sr + 1, sc));
      if (sc > 0 && image[sr][sc - 1] == color && !visited[sr][sc - 1])
        queue.add(new Index(sr, sc - 1));
      if (sc < columns - 1 && image[sr][sc + 1] == color && !visited[sr][sc + 1])
        queue.add(new Index(sr, sc + 1));
    }  
    return image;    
  }
}

class Index {
  int i, j;
  Index(int i, int j) {
    this.i = i;
    this.j = j;
  }
}