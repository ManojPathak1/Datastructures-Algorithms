//  
//  https://practice.geeksforgeeks.org/problems/maximum-index/0

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
    }
    MaximumIndex m = new MaximumIndex(n, a);
    System.out.println(m.setMinMax());
  }
}

class MaximumIndex {
  private int n;
  private int minArr[];
  private int maxArr[];
  private int a[];
  MaximumIndex(int n, int a[]) {
    this.n = n;
    minArr = new int[n];
    maxArr = new int[n];
    this.a = a;
  }
  public int setMinMax() {
    minArr[0] = a[0];
    for (int i = 1; i < n; i++) {
      minArr[i] = Math.min(a[i], a[i - 1]);
    }
    maxArr[n - 1] = a[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      maxArr[i] = Math.max(a[i], a[i + 1]);
    }
    int i = 0;
    int j = 0;
    int maxIndex = -1;
    while(i < n && j < n) {
      if (minArr[i] < maxArr[j]) {
        maxIndex = Math.max(maxIndex, j - i);
        j++;
      }
      else i++;
    }
    return maxIndex;
  }
}