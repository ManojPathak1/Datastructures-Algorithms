//  Game of Two Stacks
//  https://www.hackerrank.com/challenges/game-of-two-stacks/problem

static int twoStacks(int x, int[] a, int[] b) {
  int stackIndex1 = 0;
  int stackIndex2 = 0;
  int sum = 0;
  int count = 0;
  while (sum <= x && stackIndex1 < a.length && stackIndex2 < b.length) {
    int min = Math.min(a[stackIndex1], b[stackIndex2]);
    sum += min;
    if (a[stackIndex1] < b[stackIndex2]) stackIndex1++;
    else stackIndex2++;
    count++; 
  }
  while (sum <= x && stackIndex1 < a.length) {
    sum += a[stackIndex1];
    stackIndex1++;
    count++;
  }
  while (sum <= x && stackIndex2 < b.length) {
    sum += b[stackIndex2];
    stackIndex2++;
    count++;
  }
  if (sum <= x) return count;
  return count - 1;
}

// ALL_TESTCASES_NOT_PASSED