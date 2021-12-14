class Solution {
  static int missingNumber(int arr[], int size) {
    for (int i = 0; i < size; i++) {
      while (arr[i] != i + 1 && arr[i] > 0 && arr[i] <= size) {
        int temp = arr[i];
        int index1 = arr[i] - 1;
        arr[i] = arr[index1];
        arr[index1] = temp;
      }
    }

    for (int i = 0; i < size; i++) {
      if (arr[i] != i + 1) return i + 1;
    }
    return size + 1;
  }
}