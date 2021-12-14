class Solution {
  public static void convertToWave(int arr[], int n){
    int pairs = n / 2;
    for (int i = 0; i < pairs; i++) {
      int el1 = arr[2 * i];
      int el2 = arr[2 * i + 1];
      arr[2 * i] = el2;
      arr[2 * i + 1] = el1;
    }
  }
}

Array of object
editor render