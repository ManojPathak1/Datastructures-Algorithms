//  Search a Word in a 2D Grid of characters
//  https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int R = scan.nextInt();
    int C = scan.nextInt();
    char ch[][] = new char[R][C];
    scan.nextLine();
    for (int i = 0; i < R; i++) {
      String str = scan.nextLine();
      ch[i] = str.toCharArray();
    }
    String pattern = scan.nextLine();
    PatternSearch p = new PatternSearch(ch, R, C, pattern);
    p.print();
  }
}

class PatternSearch {
  private char mat[][];
  private int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
  private int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
  private int R;
  private int C;
  private String pattern;
  private ArrayList<Index> indexes = new ArrayList<>();
  PatternSearch(char mat[][], int R, int C, String pattern) {
    this.mat = mat;
    this.R = R;
    this.C = C;
    this.pattern = pattern;
  }
  public void print() {
    getList();
    for (Index i : indexes) System.out.println(i.row + " " + i.column);
  }
  public ArrayList<Index> getList() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (isPatternAvailable(i, j)) indexes.add(new Index(i, j));
      }
    }
    return indexes;
  }
  private boolean isPatternAvailable(int r, int c) {
    for (int dir = 0; dir < 8; dir++) {
      int row = r;
      int col = c;
      int pattLength = pattern.length();
      for (int i = 0; i < pattLength; i++) {
        if (row >= 0 && col >= 0 && row < R && col < C) {
          if (mat[row][col] != pattern.charAt(i)) break;
        } else {
          break;
        }
        if (i == pattLength - 1) return true;
        row += x[dir];
        col += y[dir];
      }
    }
    return false;
  }
}

class Index {
  int row, column;
  Index(int row, int column) {
    this.row = row;
    this.column = column;
  }
}

/**
INPUT
TESTCASE - 1
3 13
geeksforgeeks
forgeeksmanoj
manojforgeeks
geeks

TESTCASE - 2
5 15
geeksgooosgeeke
oooooegeeksoooo
oooooegeeksoooo
oooookgeeksoooo
ooooosgeeksoooo
geeks

OUTPUT
TESTCASE - 1
0 0
0 8
1 3
2 8

TESTCASE - 2
0 0
0 5
1 6
2 6
3 6
4 6
 */