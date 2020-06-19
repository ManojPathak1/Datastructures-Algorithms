//  Given an array A[] and a number x, check for pair in A[] with sum as x
//  https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) a[i] = scan.nextInt();
    int x = scan.nextInt();
    SumPairs sp = new SumPairs(x, n, a);
    sp.pairs();
  }
}

class SumPairs {
  private int x;
  private int n;
  private int a[];
  private Pair p;
  SumPairs(int x, int n, int a[]) {
    this.x = x;
    this.n = n;
    this.a = a;
    this.p = null;
  }
  private void getPairs() {
    Set<Integer> set = new HashSet<>();
    for (int e : a) {
      if (set.contains(x - e)) {
        p = new Pair(x - e, e);
        return;
      }
      set.add(e);
    }
  }
  public void pairs() {
    getPairs();
    if (p != null) System.out.println(p.e1 + " " + p.e2);
    else System.out.println("Pair doesn't exist !");
  }
}

class Pair {
  int e1, e2;
  Pair(int e1, int e2) {
    this.e1 = e1;
    this.e2 = e2;
  }
}