//  Maximum Product Subarray
//  https://www.geeksforgeeks.org/maximum-product-subarray/

// Time Complexity O(n), Space Complexity O(1)
import java.util.*;

public class Main {
  public static void main(String args[]) {
    int a[] = { 1, -2, -3, 0, 7, -8, -2 };
    System.out.println(Main.maxProduct(a));
  }
  public static int maxProduct(int a[]) {
    int maxEndingHere = 1;
    int minEndingHere = 1;
    int maxSoFar = 1;
    int flag = 0;
    for (int e : a) {
      if (e == 0) {
        maxEndingHere = 1;
        minEndingHere = 1;
      } else if (e > 0) {
        maxEndingHere *= e;
        minEndingHere = Math.min(minEndingHere*e, 1);
      } else {
        int temp = maxEndingHere;
        maxEndingHere = Math.max(minEndingHere*e, 1);
        minEndingHere = temp*e;
      }
      if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
    }
    if (flag == 0 && maxSoFar == 1) return 0;
    return maxSoFar;
  }
}