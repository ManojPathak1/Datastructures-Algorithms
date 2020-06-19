import java.util.*;

public class Main {
  public static void main(String args[]) {
    int a[] = {1, 2, 3, 5, 8, 9};
    int b[] = {4, 6, 7, 10};
    int n = a.length;
    int m = b.length;
    MergeSortedArrays mt = new MergeSortedArrays(n, a, m, b);
    mt.printResult();
  }
}

class MergeSortedArrays {
  private int n;
  private int a[];
  private int m;
  private int b[];
  private int c[];
  MergeSortedArrays(int n, int a[], int m, int b[]) {
    this.n = n;
    this.a = a;
    this.m = m;
    this.b = b;
    this.c = new int[m + n];
  }
  private int[] merge() {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < n && j < m) {
      c[k] = Math.min(a[i], b[j]);
      if (a[i] < b[j]) i++;
      else j++;
      k++;
    }
    for (i = i; i < n; i++) { c[k] = a[i]; k++; }
    for (j = j; j < m; j++) { c[k] = b[j]; k++; }
    return c;
  }
  public void printResult() {
    merge();
    for (int elem : c) {
      System.out.print(elem + " ");
    }
  }
}