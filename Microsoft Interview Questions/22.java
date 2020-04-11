//  Print a pattern without using any loop
//  https://www.geeksforgeeks.org/print-a-pattern-without-using-any-loop/

public class Main {
  public static void main(String args[]) {
    RecursivePrint p = new RecursivePrint(16, 5);
    p.recursivePrint();
  }
}

class RecursivePrint {
  private int n;
  private int limit;
  RecursivePrint(int n, int limit) {
    this.n = n;
    this.limit = limit;
  }
  public void recursivePrint() {
    recursivePrint(n, 0, false);
  }
  public void recursivePrint(int n, int count, boolean increase) {
    System.out.print(n + " ");
    if (count == 0 && increase) return;
    if (n <= 0) increase = true;
    if (increase) {
      n += limit;
      count++;
    } else {
      n -= limit;
      count--;
    }
    recursivePrint(n, count, increase);
  }
}