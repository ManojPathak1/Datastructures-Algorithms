class Solution {
  int celebrity(int M[][], int n) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) stack.push(i);
    while (stack.size() > 1) {
      int e1 = stack.pop();
      int e2 = stack.pop();
      if (M[e1][e2] == 1) stack.add(e2);
      else stack.add(e1);
    }
    int c = stack.pop();
    for (int i = 0; i < n; i++) {
      if (c != i && M[i][c] == 0) return -1;
      if (M[c][i] == 1) return -1;
    }
    return c;
  }
}