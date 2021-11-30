class Solution {
  long maxProduct(int[] arr, int n) {
    long ans = arr[0];
    long max = ans;
    long min = ans;

    for (int i = 1; i < n; i++) {
      int el = arr[i];
      // For negative numbers swap the min and max numbers.
      if (el < 0) {
        long temp = max;
        max = min;
        min = temp;
      }
      // Evaludate the max based on the contiguous max or current element.
      max = Math.max(el, el * max);
      min = Math.min(el, el * min);
      ans = Math.max(ans, max);
    }

    return ans;
  }
}