import java.util.*;

public class Main {
  public static void main(String args[]) {
    int a[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
    int n = a.length;
    int m = 7;
    ChocolateDistribution c = new ChocolateDistribution(n, a, m);
    c.printResult();
  }
}

class ChocolateDistribution {
  private int n;
  private int a[];
  private int m;
  ChocolateDistribution(int n, int a[], int m) {
    this.n = n;
    this.a = a;
    this.m = m;
  }
  public int minimumDifference() {
    int min = Integer.MAX_VALUE;
    Arrays.sort(a);
    for (int i = 0; i <= (n - m); i++) {
      min = Math.min(min, a[m - 1 + i] - a[i]);
    }
    return min;
  }
  public void printResult() {
    System.out.println(minimumDifference());
  }
}