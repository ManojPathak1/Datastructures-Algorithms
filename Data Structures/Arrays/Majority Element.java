// Moore's Voting Algorithm

class Solution {
  static int majorityElement(int a[], int size) {
    if (a.length == 1) return a[0];
    int e = a[0];
    int c = 1;
    for (int i = 1; i < n; i++) {
      if (e == a[i]) c++;
      else c--;
      if (c == 0) {
        e = a[i];
        c = 1;
      }
    }
    c = 0;
    for (int i = 0; i < n; i++) {
      if (e == a[i]) c++;
    }
    if (c > n/2) return e;
    return -1; 
  }
}