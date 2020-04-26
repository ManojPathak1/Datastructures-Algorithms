//  Stock Buy Sell to Maximize Profit
//  https://www.geeksforgeeks.org/stock-buy-sell/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) a[i] = scan.nextInt();
    BuySell b = new BuySell(n, a);
    b.print();
  }
}

class BuySell {
  private int a[];
  private int n;
  BuySell(int n, int a[]) {
    this.n = n;
    this.a = a;
  }
  private ArrayList<Index> getList() {
    ArrayList<Index> list = new ArrayList<>();
    int buyIndex;
    int sellIndex;
    int i = 0;
    // Loop for getting minima and maxima.
    while (i < n - 1) {
      // Index for minima.
      while (i < n - 1 && (a[i + 1] <= a[i])) i++;
      if (i == n - 1) break;
      buyIndex = i++;
      // Index for maxima.
      while (i < n && (a[i - 1] <= a[i])) i++;
      sellIndex = i - 1;
      // Saving minima and maxima to the list.
      list.add(new Index(buyIndex, sellIndex));
    }
    return list;
  }
  public void print() {
    ArrayList<Index> list = getList();
    for (Index e : list) System.out.print(e.buyIndex + ":" + e.sellIndex + " ");
    System.out.println();
  }
}

class Index {
  int buyIndex, sellIndex;
  Index(int buyIndex, int sellIndex) {
    this.buyIndex = buyIndex;
    this.sellIndex = sellIndex;
  }
}

/**
INPUT
7
100 180 260 310 40 535 695

OUTPUT
0:3 4:6
 */