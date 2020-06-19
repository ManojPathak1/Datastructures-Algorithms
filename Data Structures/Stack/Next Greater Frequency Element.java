//  Next Greater Frequency Element
//  https://www.geeksforgeeks.org/next-greater-frequency-element/

import java.util.*;

class Main {
  public static void main(String args[]) {
    int a[] = {1, 1, 2, 3, 4, 2, 1};
    int res[] = Main.nextGreaterFrequency(a);
    for (int i = 0; i < res.length; i++) System.out.print(res[i] + " ");
  }
  public static int[] nextGreaterFrequency(int a[]) {
    int n = a.length;
    int res[] = new int[n];
    HashMap<Integer, Integer> hmap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int e = a[i];
      if (hmap.containsKey(e)) hmap.put(e, hmap.get(e) + 1);
      else hmap.put(e, 1);
    }
    for (int i = 0; i < n; i++) {
      int e1 = a[i];
      boolean flag = false;
      for (int j = i + 1; j < n; j++) {
        int e2 = a[j];
        if (hmap.get(e2) > hmap.get(e1)) {
          flag = true;
          res[i] = e2;
          break;
        }
      }
      if (!flag) res[i] = -1;
    }
    return res;
  }
}