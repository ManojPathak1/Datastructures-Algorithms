//  
//  

public class Main {
  public static void main(String args[]) {

  }
}

class Segment {
  private int a[];
  private int n;
  private int k;
  Segement(int a[], int n, int k) {
    this.a = a;
    this.n = n;
    this.k = k;
  }
  public int getCount() {
    int maxCount = 0;
    int l = 0;
    int r = 0;
    int countMaintain = 0;
    if (a[l] == 0) countMaintain = 1;
    while(r != n) {
      while (countMaintain < k) {
        r++;
        if (a[r] == 0) countMaintain++;
      }
      if (maxCount < (r - l)) maxCount = r - l;
    }
  }
}