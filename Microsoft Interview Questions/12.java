//  Majority Element
//  https://www.geeksforgeeks.org/majority-element/

//  METHOD 1: Iteration Time Complexity - O(n^2)   Space Complexity - O(1)

//  METHOD 2: Hashing  Time Complexity - O(n)    Space Complexity - O(n)

//  METHOD 3: Using BST

//  METHOD 4: Moore's Voting Algorithm

public class Main {
  public static void main(String args[]) {
    int a1[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
    int a2[] = {3, 3, 4, 2, 4, 4, 2, 4};
    // System.out.println(Main.getMajorElement(a1, a1.length));
    System.out.println(Main.getMajorElement(a2, a2.length));
  }
  public static int getCandidate(int a[], int n) {
    int majIndex = 0, count = 1;
    for (int i = 1; i < n; i++) {
      if (a[i] == a[majIndex]) count++;
      else count--;
      if (count == 0) {
        majIndex = i;
        count = 1;
      }
    }
    return a[majIndex];
  }
  public static int getMajorElement(int a[], int n) {
    int candidate = Main.getCandidate(a, n);
    int majorCount = n/2 + 1;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == candidate) count++;
      if (count == majorCount) return candidate; 
    }
    System.out.print("Major element not available !");
    return -1;
  }
}