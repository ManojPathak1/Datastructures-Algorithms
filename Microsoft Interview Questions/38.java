//  Search an element in a sorted and rotated array
//  https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int tc = scan.nextInt();
    while(tc > 0) {
      int n = scan.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
      int e = scan.nextInt();
      SortedRotated s = new SortedRotated(n, arr);
      System.out.println(s.getIndex(e));
      tc--;
    }
  }
}

class SortedRotated {
  private int arr[];
  private int n;
  SortedRotated(int n, int arr[]) {
    this.n = n;
    this.arr = arr;
  }
  public int getIndex(int e) {
    for (int i = 1; i < n; i++) {
      int currElement = arr[i];
      int prevElement = arr[i - 1];
      if (currElement < prevElement) {
        if (arr[0] < e) return binarySearch(e, 0, i - 1);
        else return binarySearch(e, i, n - 1);
      }
    }
    return -1;
  }
  private int binarySearch(int e, int l, int h) {
    int mid = (l + h) / 2;
    if (e == arr[mid]) return mid;
    if (l == h) return -1;
    else if (e > arr[mid]) return binarySearch(e, mid + 1, h);
    else return binarySearch(e, l, mid - 1);
  }
}

/**
INPUT
3
9
5 6 7 8 9 10 1 2 3
3
9
5 6 7 8 9 10 1 2 3
30
5
30 40 50 10 20
10

OUTPUT
8
-1
3
 */