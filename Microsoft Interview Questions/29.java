//  Program to add two binary strings
//  https://www.geeksforgeeks.org/program-to-add-two-binary-strings/

import java.util.*;

public class Tree {
  public static void main(String args[]) {
    String b1 = "11";
    String b2 = "1";
    BinaryNumber b = new BinaryNumber(b1, b2, b1.length(), b2.length());
    System.out.println(b.addBinaryNumbers());
  }
}

class BinaryNumber {
  private String b1;
  private String b2;
  private int n1;
  private int n2;
  private String result;
  BinaryNumber(String b1, String b2, int n1, int n2) {
    this.b1 = b1;
    this.b2 = b2;
    this.n1 = n1;
    this.n2 = n2;
    this.result = "";
  }
  public String addBinaryNumbers() {
    int size = Math.max(n1, n2);
    int carry = 0;
    for (int i = 0; i < size; i++) {
      int num1 = 0;
      int num2 = 0;
      if (n1 - 1 >= i) num1 = Character.getNumericValue(b1.charAt(i));
      if (n2 - 1 >= i) num2 = Character.getNumericValue(b2.charAt(i));
      int sum = num1 + num2 + carry;
      if (sum == 0 || sum == 1) carry = 0;
      else carry = 1;
      result += sum % 2;
    }
    if (carry == 1) result += carry;
    return reverse(result);
  }
  private String reverse(String str) {
    String reversedStr = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      reversedStr += str.charAt(i);
    }
    return reversedStr;
  }
}