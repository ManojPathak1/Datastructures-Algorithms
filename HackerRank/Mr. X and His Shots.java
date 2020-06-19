//  Mr. X and His Shots
//  https://www.hackerrank.com/challenges/x-and-his-shots/problem

static int solve(int[][] shots, int[][] players) {
  int strengths = 0;
  for (int player[] : players) {
    int s1 = player[0];
    int s2 = player[1];
    int count = 0;
    for (int shot[] : shots) {
      int r1 = shot[0];
      int r2 = shot[1];
      if ((s1 >= r1 && s1 <= r2) || (s2 >= r1 && s2 <= r2) || (s1 <= r1 && s2 >= r2)) count++;
    }
    strengths += count;
  }
  return strengths;
}