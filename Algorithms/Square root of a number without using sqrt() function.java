//  Square root of a number without using sqrt() function
//  https://www.geeksforgeeks.org/square-root-of-a-number-without-using-sqrt-function/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    SquareRoot s = new SquareRoot(10);
    System.out.println(s.squareRoot());
    SquareRoot s2 = new SquareRoot(16);
    System.out.println(s2.squareRoot());
  }
}

class SquareRoot {
  private int n;
  SquareRoot(int n) {
    this.n = n;
  }
  private PerfectSquare nextGreater() {
    int i = 1;
    while (true) {
      if (i * i == n) return new PerfectSquare(true, i);
      if (i * i > n) return new PerfectSquare(false, i);
      ++i;
    }
  }
  private double binarySquareRoot(int n, double l, double h) {
    double m = (l + h) / 2;
    double mul = m * m;
    if (Math.abs(mul - n) < 0.00001) return m;
    else if (mul > n) return binarySquareRoot(n, l, m);
    else return binarySquareRoot(n, m, h);
  }
  public double squareRoot() {
    PerfectSquare p = nextGreater();
    if (p.isPerfectSquare) return Double.valueOf(p.n);
    double nextNum = Double.valueOf(p.n);
    double prevNum = Double.valueOf(nextNum - 1);
    return binarySquareRoot(n, prevNum, nextNum);
  }
}

class PerfectSquare {
  boolean isPerfectSquare;
  int n;
  PerfectSquare(boolean isPerfectSquare, int n) {
    this.isPerfectSquare = isPerfectSquare;
    this.n = n;
  }
}