//  Team
//  https://codeforces.com/contest/231/problem/A

import java.util.*;

class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner();
    int count = 0;
    int tc = scan.nextInt();
    while (tc > 0) {
      int a1 = scan.nextInt();
      int a2 = scan.nextInt();
      int a3 = scan.nextInt();
      int sum = a1 + a2 + a3;
      if (sum >= 2) count++;
      tc--;
    }
    System.out.println(count);
  } 
}

/* TC-1
3
1 1 0
1 1 1
1 0 0   */