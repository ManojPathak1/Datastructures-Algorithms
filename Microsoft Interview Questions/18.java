//  Mobile Numeric Keypad Problem
//  https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/

public class Main {
  public static void main(String args[]) {
    Keypad k = new Keypad();
    System.out.println(k.getResult(1));
    System.out.println(k.getResult(2));
    System.out.println(k.getResult(3));
    System.out.println(k.getResult(4));
  }
}

class Keypad {
  int values[] = { 2, 3, 4, 3, 4, 5, 4, 3, 5, 2 };
  private int times(int n, int count) {
    int result = 1;
    for (int i = 1; i <= count; i++) result *= n;
    return result;
  }
  public int getResult(int N) {
    int sum = 0;
    for (int i = 0; i <= 9; i++) if (values[i] <= N) sum += times(values[i], N - 1);
    return sum;
  }
}