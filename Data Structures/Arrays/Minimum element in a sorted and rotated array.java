class Solution {
  int findMin(int arr[], int n) {
    int left = 0;
    int right = n - 1;

    if (arr[0] < arr[n - 1]) return arr[0];

    while (left != right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > arr[mid + 1]) return arr[mid + 1];
      else if (arr[mid] < arr[mid - 1]) return arr[mid];
      else if (arr[mid] > arr[left]) left = mid + 1;
      else if (arr[mid] < arr[right]) right = mid - 1;
    }
    return arr[left];
  }
}