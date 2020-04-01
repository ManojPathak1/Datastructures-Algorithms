// Find next greater number with same set of digits
// https://www.geeksforgeeks.org/find-next-greater-number-set-digits/

import java.util.Arrays;

public class Main {
  public static void main(String args[]) {
    String n = "534976";
    char ch[] = n.toCharArray();
    Index i = Main.findPoints(ch);
    if (i.smallestIndex == -1) {
      System.out.println("Not Possible");
    }
    ch = Main.swap(ch, i.smallestIndex, i.breakIndex);
    Arrays.sort(ch, i.breakIndex + 1, ch.length);
    Main.print(ch);
  }
  public static Index findPoints(char ch[]) {
    int smallestIndex = ch.length - 1;
    for (int i = ch.length - 2; i >= 0; i--) {
      int prev = Character.getNumericValue(ch[i + 1]);
      int curr = Character.getNumericValue(ch[i]);
      if (curr < prev) {
        return new Index(smallestIndex, i);
      } else {
        if (curr < Character.getNumericValue(ch[smallestIndex])) smallestIndex = i;
      }
    }
    return new Index(-1, -1);
  }
  public static char[] swap(char ch[], int i, int j) {
    char temp = ch[i];
    ch[i] = ch[j];
    ch[j] = temp;
    return ch;
  }
  public static void print(char ch[]) {
    for (char e : ch) System.out.print(e);
  }
}

class Index {
  int smallestIndex, breakIndex;
  Index(int smallestIndex, int breakIndex) {
    this.smallestIndex = smallestIndex;
    this.breakIndex = breakIndex;
  }
}