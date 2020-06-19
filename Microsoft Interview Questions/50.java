//  
//  https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) a[i] = scan.nextInt();
    int expectedSum = scan.nextInt();
    SubArray s = new SubArray(n, a, expectedSum);
    s.printResult();
  }
}

class SubArray {
  private int n;
  private int a[];
  private int expectedSum;
  SubArray(int n, int a[], int expectedSum) {
    this.n = n;
    this.a = a;
    this.expectedSum = expectedSum;
  }
  private SubArrayIndex getIndex() {
    int startIndex = 0;
    int endIndex = 0;
    int sum = a[startIndex];
    while(startIndex < n && endIndex < n) {
      if (sum == expectedSum) return new SubArrayIndex(startIndex, endIndex);
      if (startIndex == endIndex) {
        if (sum > expectedSum) {
          startIndex++;
          endIndex++;
          sum = a[startIndex];
        } else {
          endIndex++;
          sum += a[endIndex];
        }
      } else if (sum < expectedSum) {
        endIndex++;
        sum += a[endIndex];
      } else {
        startIndex++;
        sum -= a[startIndex];
      }
      if (startIndex < n && endIndex < n) break;
    }
    return new SubArrayIndex(-1, -1);
  }
  public void printResult() {
    SubArrayIndex index = getIndex();
    System.out.println(index.startIndex + " " + index.endIndex);
  }
}

class SubArrayIndex {
  int startIndex, endIndex;
  SubArrayIndex(int startIndex, int endIndex) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }
}