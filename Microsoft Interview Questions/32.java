//  Remove duplicates from a given string
//  https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/


// METHOD 1: Using HashMap
import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int tc = scan.nextInt();
    scan.nextLine();
    while(tc > 0) {
      String str = scan.nextLine();
      RemoveDuplicates r = new RemoveDuplicates(str);
      System.out.println(r.duplicate());
      tc--;
    }
  }
}

class RemoveDuplicates {
  private char ch[];
  RemoveDuplicates(String str) {
    this.ch = str.toCharArray();
  }
  public String duplicate() {
    Set<Character> s = new HashSet<>();
    String result = "";
    for (char e : ch) {
      if (!s.contains(e)) {
        s.add(e);
        result += e;
      }
    }
    return result;
  }
}

/**
INPUT
2
geeksforgeeks
manojpathak

OUTPUT
geksfor
manojpthk
 */