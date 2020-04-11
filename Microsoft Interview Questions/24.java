//  Print all subarrays with 0 sum
//  https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    int a[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
    SumSubArray s = new SumSubArray(a);
    s.print();
  }
}

class SumSubArray {
  private int a[];
  private ArrayList<Index> results = new ArrayList<>();
  private HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
  SumSubArray(int a[]) {
    this.a = a;
    getResult();
  }
  private void createHashMap() {
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      ArrayList<Integer> al = new ArrayList<>();
      if (sum == 0 && !hm.containsKey(0)) al.add(-1);
      if (hm.containsKey(sum)) al = hm.get(sum);
      al.add(i);
      hm.put(sum, al);
    }
  }
  private void addPairs() {
    for (Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()) {
      ArrayList<Integer> al = entry.getValue();
      for (int i = 0; i < al.size() - 1; i++) {
        for (int j = i + 1; j < al.size(); j++) {
          results.add(new Index(al.get(i) + 1, al.get(j)));
        }
      }
    }
  }
  public ArrayList<Index> getResult() {
    createHashMap();
    addPairs();
    return results;
  }
  public void print() {
    for (Index e : results) {
      System.out.println(e.start + " : " + e.end);
    }
  }
}

class Index {
  int start, end;
  Index(int start, int end) {
    this.start = start;
    this.end = end;
  }
}