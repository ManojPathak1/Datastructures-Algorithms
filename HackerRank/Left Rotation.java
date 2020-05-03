//  https://www.hackerrank.com/challenges/array-left-rotation/problem?h_r=profile
// Left Rotation

import java.util.*;

class Solution {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int d = scan.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) a[i] = scan.nextInt();
    RotateArray r = new RotateArray(n, d, a);
    r.print();
  }
}

class RotateArray {
  private int n;
  private int d;
  private int a[];
  RotateArray(int n, int d, int a[]) {
    this.n = n;
    this.d = d;
    this.a = a;
  }
  private int[] rotate() {
    while (d > 0) {
      int first = a[0];
      for (int i = 1; i < n; i++) a[i - 1] = a[i];
      a[n - 1] = first;
      d--;
    }
    return a;
  }
  public void print() {
    int a[] = rotate();
    for (int e : a) System.out.print(e + " ");
  }
}
