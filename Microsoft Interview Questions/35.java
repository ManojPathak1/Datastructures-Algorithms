//  Reverse words in a given string
//  https://www.geeksforgeeks.org/reverse-words-in-a-given-string/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    ReverseString r = new ReverseString("Donald Trump steps in to end a price war");
    System.out.println(r.reverse());
  }
}

class ReverseString {
  private char ch[];
  ReverseString(String str) {
    this.ch = str.toCharArray();
  }
  public String reverse() {
    String reverseStr = "";
    Stack<String> stack = new Stack<>();
    String temp = "";
    for(char e : ch) {
      if (e == ' ') {
        stack.push(temp);
        temp = "";
      } else {
        temp += e;
      }
    }
    stack.push(temp);
    while(!stack.empty()) reverseStr += stack.pop() + " ";
    return reverseStr;
  } 
}