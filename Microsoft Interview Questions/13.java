//  Largest Sum Contiguous Subarray
//  https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

public class Main {
  public static void main(String args[]) {
    int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
    MaxDTO m = Main.maxSum(a);
    System.out.println("Max: " + m.max + "  Start: " + m.start + "  End: " + m.end);
  }
  //  Kadane Algorithm
  public static MaxDTO maxSum(int a[]) {
    int maxEndingHere = 0;
    int maxSoFar = Integer.MIN_VALUE;
    int start = 0;
    int end = 0;
    int s = 0;
    for (int i = 0; i < a.length; i++) {
      int e = a[i];
      maxEndingHere += e;
      if (maxEndingHere > maxSoFar) {
        maxSoFar = maxEndingHere;
        start = s;
        end = i;
      }
      if (maxEndingHere < 0) {
        maxEndingHere = 0;
        s = i + 1;
      }
    }
    return new MaxDTO(start, end, maxSoFar);
  }
}

class MaxDTO {
  int start, end, max;
  MaxDTO(int start, int end, int max) {
    this.start = start;
    this.end = end;
    this.max = max;
  }
}