//  https://www.hackerrank.com/challenges/crush/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
//  Array Manipulation

// All testcases are not passed, need to optimize the solution.
static long arrayManipulation(int n, int[][] queries) {
  long max = Long.MIN_VALUE;
  long arr[] = new long[n];
  int queriesLen = queries.length;
  for (int i = 0; i < queriesLen; i++) {
    int a = queries[i][0];
    int b = queries[i][1];
    long add = queries[i][2];
    for (int j = a - 1; j < b; j++) {
      arr[j] += add;
      max = Math.max(max, arr[j]);
    }
  }
  return max;
}

// Optimizing the solution
static long arrayManipulation(int n, int[][] queries) {
  long max = Integer.MIN_VALUE;
  int queriesLen = queries.length;
  for (int i = 0; i < queriesLen; i++) {
    int a1 = queries[i][0];
    int b1 = queries[i][1];
    int sum = queries[i][2];
    for (int j = i + 1; j < queriesLen; j++) {
      int a2 = queries[j][0];
      int b2 = queries[j][1];
      int k2 = queries[j][2];
      if ((a2 <= a1 && b2 >= b1) || (a2 >= a1 && a2 <= b1) || (b2 >= a1 && b2 <= b1)) {
        sum += k2;
      }
    }
    max = Math.max(max, sum);
  }
  return max;
}