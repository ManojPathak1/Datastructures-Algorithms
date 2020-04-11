//  Print the string by ignoring alternate occurrences of any character
//  https://www.geeksforgeeks.org/print-string-ignoring-alternate-occurrences-character/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    String str = "It is a long day Dear.";
    SkipString s = new SkipString(str.toCharArray());
    System.out.println(s.getResult());
  }
}

class SkipString {
  private char c[];
  private String result;
  SkipString(char c[]) {
    this.c = c;
    this.result = "";
  }
  public String getResult() {
    Set<Character> s = new HashSet<>();
    for (char ch : c) {
      char t = Character.toLowerCase(ch);
      if (!s.remove(t)) {
        s.add(t);
        result += ch;
      }
    }
    return result;
  }
}