//  Print all Jumping Numbers smaller than or equal to a given value
//  https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    JumpingNumber j = new JumpingNumber(105);
    j.print();
  }
}

class JumpingNumber {
  private int n;
  private ArrayList<Integer> jumpingNos = new ArrayList<>();
  JumpingNumber(int n) {
    this.n = n;
    getJumpingNos();
  }
  public ArrayList<Integer> getJumpingNos() {
    for (int i = 0; i <= n; i++) if (isJumpingNo(i)) jumpingNos.add(i);
    return jumpingNos;
  }
  public void print() {
    for (int e : jumpingNos) System.out.print(e + " ");
    System.out.println();
  }
  private boolean isJumpingNo(int num) {
    if (num <= 10) return true;
    else return isJumpingNo(getList(num));
  }
  private ArrayList<Integer> getList(int num) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    while(num > 0) {
      int rem = num % 10;
      num /= 10;
      digits.add(rem);
    }
    return digits;
  }
  private boolean isJumpingNo(ArrayList<Integer> digits) {
    for (int i = 0; i < digits.size() - 1; i++) {
      boolean noDiffOne = Math.abs(digits.get(i) - digits.get(i + 1)) != 1;
      if (noDiffOne) return false;
    }
    return true;
  }
}