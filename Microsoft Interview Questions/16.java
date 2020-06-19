//  Minimum time required to rot all oranges
//  https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    int R = 4, C = 5;
    int arr[][] = {
      {2, 1, 0, 2, 1},
      {1, 0, 1, 2, 1},
      {1, 0, 0, 2, 1},
      {1, 0, 0, 0, 0}
      };
    Oranges o = new Oranges(arr, R, C);
    System.out.println(o.getTimeFrame());
  }
}

class Oranges {
  private int R, C;
  private int orange[][];
  private ArrayList<Index> listOfRottenOranges = new ArrayList<>();
  Oranges(int orange[][], int R, int C) {
    this.orange = orange;
    this.R = R;
    this.C = C;
  }
  public int getTimeFrame() {
    getList();
    boolean hasRottenOranges = listOfRottenOranges.size() > 0;
    boolean contains1 = containsOne();
    if (!hasRottenOranges && contains1) return Integer.MIN_VALUE;
    if (hasRottenOranges) {
      for (Index i : listOfRottenOranges) {
        Index upIndex = getUpIndex(i.rowIndex, i.columnIndex);
        Index downIndex = getDownIndex(i.rowIndex, i.columnIndex);
        Index leftIndex = getLeftIndex(i.rowIndex, i.columnIndex);
        Index rightIndex = getRightIndex(i.rowIndex, i.columnIndex);
        if (isUp1(i.rowIndex, i.columnIndex)) orange[upIndex.rowIndex][upIndex.columnIndex] = 2;
        if (isDown1(i.rowIndex, i.columnIndex)) orange[downIndex.rowIndex][downIndex.columnIndex] = 2;
        if (isLeft1(i.rowIndex, i.columnIndex)) orange[leftIndex.rowIndex][leftIndex.columnIndex] = 2;
        if (isRight1(i.rowIndex, i.columnIndex)) orange[rightIndex.rowIndex][rightIndex.columnIndex] = 2;
      }
      return getTimeFrame() + 1;
    } else {
      return 0;
    }
  }
  private boolean containsOne() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int e = orange[i][j];
        if (e == 1) return true;
      }
    }
    return false;
  }
  private void getList() {
    listOfRottenOranges.clear();
    for (int i = 0; i < R; i++)
      for (int j = 0; j < C; j++) {
        int e = orange[i][j];
        if (haveFreshNeighbour(e, i, j))  listOfRottenOranges.add(new Index(i, j));
      }
  }
  private boolean haveFreshNeighbour(int e, int i, int j) {
    if (e == 2)
      if (isUp1(i, j) || isDown1(i, j) || isLeft1(i, j) || isRight1(i, j)) return true;
    return false;
  }
  private Index getUpIndex(int i, int j) {
    return new Index(i - 1, j);
  }
  private Index getDownIndex(int i, int j) {
    return new Index(i + 1, j);
  }
  private Index getLeftIndex(int i, int j) {
    return new Index(i, j - 1);
  }
  private Index getRightIndex(int i, int j) {
    return new Index(i, j + 1);
  }
  private boolean isUp1(int i, int j) {
    return isValid(i - 1, j) && orange[i-1][j] == 1;
  }
  private boolean isDown1(int i, int j) {
    return isValid(i + 1, j) && orange[i+1][j] == 1;
  }
  private boolean isLeft1(int i, int j) {
    return isValid(i, j - 1) && orange[i][j - 1] == 1;
  }
  private boolean isRight1(int i, int j) {
    return isValid(i, j+1) && orange[i][j+1] == 1;
  }
  private boolean isValid(int i, int j) {
    if (i >= 0 && i <= R-1 && j >= 0 && j <= C-1) return true;
    return false;
  }
}

class Index {
  int rowIndex, columnIndex;
  Index(int rowIndex, int columnIndex) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
  }
}