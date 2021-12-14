class Solution {
  static long trappingWater(int arr[], int n) { 
    long waterTrapped = 0;
    int left[] = new int[n];
    int right[] = new int[n];
    int max = -1;

    for (int i = 0; i < n; i++) {
      max = Math.max(arr[i], max);
      left[i] = max;
    }

    max = -1;

    for (int i = n - 1; i >= 0; i--) {
      max = Math.max(arr[i], max);
      right[i] = max;
    }

    for (int i = 0; i < n; i++) {
      waterTrapped += Math.min(left[i], right[i]) - arr[i];
    }

    return waterTrapped;
  }
}