//  Queue using Two Stacks
//  https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    QueueUsingStack queue = new QueueUsingStack();
    int q = scan.nextInt();
    while (q > 0) {
      int type = scan.nextInt();
      switch(type) {
        case 1:
          int e = scan.nextInt();
          queue.add(e);
          break;
        case 2:
          queue.poll();
          break;
        case 3:
          System.out.println(queue.peek());
          break;
      }
      q--;
    }
  }
}

class QueueUsingStack {
  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();
  public void add(int e) {
    stack1.push(e);
  }
  public int poll() {
    if (stack1.empty()) return -1;
    while (!stack1.empty()) {
      stack2.push(stack1.pop());
    }
    int pollElem = stack2.pop();
    while (!stack2.empty()) {
      stack1.push(stack2.pop());
    }
    return pollElem;
  }
  public int peek() {
    if (stack1.empty()) return -1;
    while (!stack1.empty()) {
      stack2.push(stack1.pop());
    }
    int peekElem = stack2.peek();
    while (!stack2.empty()) {
      stack1.push(stack2.pop());
    }
    return peekElem;
  }
}