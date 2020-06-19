//  The Celebrity Problem
//  https://www.geeksforgeeks.org/the-celebrity-problem/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int mat[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        mat[i][j] = scan.nextInt();
    }
    FindCelebrity fc = new FindCelebrity(n, mat);
    int celebrity = fc.getCelebrity();
    if (celebrity >= 0) System.out.println(celebrity);
    else System.out.println("No celebrity in the group.");
  }
}

class FindCelebrity {
  private int mat[][];
  private ArrayList<Integer> list[];
  private int n;
  FindCelebrity(int n, int mat[][]) {
    this.list = new ArrayList[n];
    this.mat = mat;
    this.n = n;
  }
  private void createList() {
    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        int value = mat[i][j];
        if (value == 1) list[i].add(j);
      }
    }
  }
  private int findCelebrity() {
    createList();
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int e : list[i]) {
        if (hm.containsKey(e)) hm.put(e, hm.get(e) + 1);
        else hm.put(e, 1);
      }
    }
    for (int i = 0; i < n; i++) {
      if (hm.containsKey(i) && hm.get(i) == n - 1 && list[i].size() == 0) return i; 
    }
    return -1;
  }
  public int getCelebrity() {
    return findCelebrity();
  }
}

/**
INPUT
4
0 0 1 0
0 0 1 0
0 0 0 0
0 0 1 0

OUTPUT
2
 */