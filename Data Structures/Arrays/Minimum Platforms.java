// Sorting technique is used.

class Solution {
  static int findPlatform(int arr[], int dep[], int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);
    int ai = 0;
    int di = 0;
    int max = 0;
    int count = 0;
    while (ai < n && di < n) {
      if (arr[ai] <= dep[di]) {
        count++;
        ai++;
      } else {
        count--;
        di++;
      }
      max = Math.max(max, count);
    }
    return max;
  }
}