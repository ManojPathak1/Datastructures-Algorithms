import java.util.*;

public class Main {
  public static void main(String args[]) {
    int a[] = {1, 3, 2, 4};
    int n = a.length;
    NextLargerElement obj = new NextLargerElement(n, a);
    obj.printList();
  }
}

class NextLargerElement {
  private int n;
  private int a[];
  NextLargerElement(int n, int a[]) {
    this.n = n;
    this.a = a;
  }
  public ArrayList<Integer> nextLargerElements() {
    ArrayList<Integer> al = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(a[0]);
    for (int i = 1; i < n; i++) {
      int e = a[i];
      while (!stack.empty() && e > stack.peek()) {
        stack.pop();
        al.add(e);
      }
      stack.push(e);
    }
    while (!stack.empty()) {
      stack.pop();
      al.add(-1);
    }
    return al;
  }
  public void printList() {
    ArrayList<Integer> results = nextLargerElements();
    for (int e : results) {
      System.out.print(e + " ");
    }
  }
}