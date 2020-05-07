//  Maximum Element
//  https://www.hackerrank.com/challenges/maximum-element/problem

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    MaximumElement m = new MaximumElement();
    int q = scan.nextInt();
    while (q > 0) {
      int type = scan.nextInt();
      switch (type) {
        case 1:
          int e = scan.nextInt();
          m.add(e);
          break;
        case 2:
          m.delete();
          break;
        case 3:
          System.out.println(m.max());
          break;
        default:
      }
      q--;
    }
  }
}

class MaximumElement {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> maxStack = new Stack<>();
  public void add(int e) {
    if (stack.empty() || maxStack.peek() < e) maxStack.push(e);
    else maxStack.push(maxStack.peek());
    stack.push(e);
  }
  public void delete() {
    if (!stack.empty()) {
      stack.pop();
      maxStack.pop();
    }
  }
  public int max() {
    return maxStack.peek();
  }
}