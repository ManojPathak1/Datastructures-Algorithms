import java.util.*;

public class Main {
  public static void main(String args[]) {
    int a[] = {1, 2, 3, 4, 5};
    int n = a.length;
    CountTriplets ct = new CountTriplets(n, a);
    System.out.println(ct.countTriplets());
  }
}

class CountTriplets {
  private int n;
  private int a[];
  CountTriplets(int n, int a[]) {
    this.n = n;
    this.a = a;
  }
  public int countTriplets() {
    int count = 0;
    HashMap<Integer, Integer> hmap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      hmap.put(a[i], i)
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = a[i] + a[j];
        if (hmap.containsKey(sum) && hmap.get(sum) != i && hmap.get(sum) != j) count++;
      }
    }
    return count;
  }
}