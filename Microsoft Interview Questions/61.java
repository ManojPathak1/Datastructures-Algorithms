import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int q = scan.nextInt();
    LRU lru = new LRU(n);
    for (int i = 1; i <= q; i++) {
      String op = scan.next();
      if (op.equals("SET")) {
        int key = scan.nextInt();
        int value = scan.nextInt();
        lru.set(key, value);
      } else {
        int key = scan.nextInt();
        System.out.print(lru.get(key) + " ");
      }
    }
  }
}

class LRU {
  private Queue<Integer> queue;
  private HashMap<Integer, Integer> hm;
  private int n;
  LRU(int n) {
    queue = new LinkedList<>();
    hm = new HashMap<>();
    this.n = n;
  }
  public void set(int key, int value) {
    if (queue.size() >= n) hm.remove(queue.poll());
    queue.add(key);
    hm.put(key, value);
  }
  public int get(int key) {
    if (hm.containsKey(key)) return hm.get(key);
    return -1;
  }
}