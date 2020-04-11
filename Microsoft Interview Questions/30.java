//  Program to validate an IP address
//  https://www.geeksforgeeks.org/program-to-validate-an-ip-address/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int tc = scan.nextInt();
    scan.nextLine();
    while(tc > 0) {
      String ip4 = scan.nextLine();
      IP4 i = new IP4(ip4);
      System.out.println(i.isValid());
      tc--;
    }
  }
}

class IP4 {
  private String str;
  IP4(String str) {
    this.str = str;
  }
  public boolean isValid() {
    ArrayList<String> list = split();
    if (list.size() != 4) return false;
    for (String s : list) {
      if (isNumber(s)) {
        int num = Integer.parseInt(s);
        if (!(num >= 0 && num <= 255)) return false;
      } else return false;
    }
    return true;
  }
  private ArrayList<String> split() {
    ArrayList<String> list = new ArrayList<>();
    char ch[] = str.toCharArray();
    String temp = "";
    for (char c : ch) {
      if (c == '.') {
        list.add(temp);
        temp = "";
      } else temp += c;
    }
    list.add(temp);
    return list;
  }
  private boolean isNumber(String num) {
    boolean isNum = false;
    try {
      Integer.parseInt(num);
      isNum = true;
    } catch(NumberFormatException e) {}
    return isNum;
  }
}

/*

INPUT
2
172.16.254.1
1.1.1.-1

OUTPUT
true
false

*/