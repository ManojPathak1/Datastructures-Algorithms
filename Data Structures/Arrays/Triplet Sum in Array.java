/**
Using the nested for loops approach.
Time Complexity -> O(n^3)
Space Complexity -> O(1)
 */

class Solution {
  public static boolean find3Numbers(int A[], int n, int X) {
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          int sum = A[i] + A[j] + A[k];
          if (sum == X) return true;
        }
      }
    }
    return false;
  }
}

/**
Using the hashing technique.
Time Complexity -> O(n^2)
Space Complexity -> O(n)
 */

class Solution {
  public static boolean find3Numbers(int A[], int n, int X) {
    for (int i = 0; i < n - 2; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = i + 1; j < n; j++) {
        int sum = A[i] + A[j];
        if (set.contains(X - sum)) return true;
        set.add(A[j]);
      }
    }
    return false;
  }
}


/**
Using the sorting technique.
Time Complexity -> O(n^2)
Space Complexity -> O(1)
 */

class Solution {
  public static boolean find3Numbers(int A[], int n, int X) {
    Arrays.sort(A);
    for (int i = 0; i < n - 2; i++) {
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        int sum = A[i] + A[left] + A[right];
        if (sum == X) return true;
        else if (sum < X) left++;
        else right--;
      }
    }
    return false;
  }
}