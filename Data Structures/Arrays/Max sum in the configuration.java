class GfG
{
  int max_sum(int A[], int n) {
    int max = 0;
    int sum = 0;
    int sprev = 0;
    for (int el: A) sum += el;
    for (int i = 0; i < n; i++) sprev += i * A[i];
    for (int i = 1; i < n; i++) {
      si = sprev + n * A[n - i - 1];
      max = Math.max(max, si);
      sprev = si;
    }
    return max;
  }
}