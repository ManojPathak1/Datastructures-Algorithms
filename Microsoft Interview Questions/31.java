//  Queue using Stacks
//  https://www.geeksforgeeks.org/queue-using-stacks/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int tc = scan.nextInt();
    QueueUsingStack q = new QueueUsingStack();
    while(tc > 0) {
      String op = scan.next();
      int n = 0;
      if (op.equals("ADD")) n = scan.nextInt();
      executeTC(op, n, q);
      tc--;
    }
  }
  public static void executeTC(String op, int n, QueueUsingStack q) {
    switch(op) {
      case "ADD": q.add(n); break;
      case "PEEK": System.out.println(q.peek()); break;
      case "POLL": System.out.println(q.poll()); break;
      case "EMPTY": System.out.println(q.empty()); break;
      case "SIZE": System.out.println(q.size()); break;
      default:
    }
  }
}

class QueueUsingStack {
  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();
  private int size = 0;
  public void add(int elem) {
    stack1.push(elem);
    size++;
  }
  public Object peek() {
    Object data = null;
    if (size > 0) {
      copyData(stack1, stack2);
      data = stack2.peek();
      copyData(stack2, stack1);
    }
    return data;
  }
  public Object poll() {
    Object data = null;
    if (size > 0) {
      copyData(stack1, stack2);
      data = stack2.pop();
      copyData(stack2, stack1);
      size--;
    }
    return data;
  }
  public boolean empty() {
    if (size == 0) return true;
    return false;
  }
  public int size() {
    return size;
  }
  private void copyData(Stack<Integer> stack1, Stack<Integer> stack2) {
    while(!stack1.empty()) stack2.push(stack1.pop());
  }
}

/**
INPUT
10
ADD 1
ADD 2
ADD 4
PEEK
POLL
POLL
POLL
POLL
EMPTY
SIZE

OUTPUT
1
1
2
4
null
true
0
 */