//  Two elements whose sum is closest to zero
//  https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) a[i] = scan.nextInt();
    Arrays.sort(a);
    CloserToZero c = new CloserToZero(n, a);
    Pair p = c.getPair();
    System.out.println(p.i1 + " " + p.i2);
  }
}

class CloserToZero {
  private int n;
  private int a[];
  CloserToZero(int n, int a[]) {
    this.n = n;
    this.a = a;
  }
  private int abs(int n) {
    return Math.abs(n);
  }
  public Pair getPair() {
    int firstIndex = 0;
    int lastIndex = n - 1;
    int p1 = a[firstIndex];
    int p2 = a[lastIndex];
    int min = Integer.MAX_VALUE;
    while(firstIndex < lastIndex) {
      int sum = a[firstIndex] + a[lastIndex];
      if (abs(min) > abs(sum)) {
        min = sum;
        p1 = a[firstIndex];
        p2 = a[lastIndex];
      }
      if (sum < 0) firstIndex++;
      else lastIndex--;
    }
    return new Pair(p1, p2);
  } 
} 

class Pair {
  int i1, i2;
  Pair(int i1, int i2) {
    this.i1 = i1;
    this.i2 = i2;
  }
}