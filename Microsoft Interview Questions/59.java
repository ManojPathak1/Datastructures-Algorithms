import java.util.*;

public class Main {
  public static void main(String args[]) {
    int a[] = {16, 17, 4, 3, 5, 2};
    int n = a.length;
    Leader l = new Leader();
    l.printResult();
  }
}

class Leader {
  private int n;
  private int a[];
  Leader(int n, int a[]) {
    this.n = n;
    this.a = a;
  }
  public Stack<Integer> getLeaders() {
    Stack<Integer> leadersStack = new Stack<>();
    int currLeader = a[n - 1];
    leadersStack.push(currLeader);
    for (int i = n - 2; i >= 0; i--) {
      if (a[i] >= currLeader) {
        currLeader = a[i];
        leadersStack.push(currLeader);
      }
    }
    return leadersStack;
  }
  public void printResult() {
    Stack<Integer> leadersStack = getLeaders();
    while(!leadersStack.empty()) {
      System.out.print(leadersStack.pop() + " ");
    }
  }
}