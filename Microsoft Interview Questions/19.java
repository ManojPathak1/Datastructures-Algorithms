//  Number of buildings facing the sun
//  https://www.geeksforgeeks.org/number-buildings-facing-sun/

public class Main {
  public static void main(String args[]) {
    int building[] = { 7, 4, 8, 2, 9 };
    Building b = new Building(building, 5);
    System.out.println(b.buildingsSeeSunset());
  }
}

class Building {
  private int maxAtLeft[];
  private int building[];
  private int N;
  Building(int building[], int N) {
    this.N = N;
    maxAtLeft = new int[N];
    this.building = building;
    initializeMaxLeft();
  }
  private void initializeMaxLeft() {
    int max = 0;
    for (int i = 0; i < N; i++) {
      maxAtLeft[i] = max;
      if (max < building[i]) max = building[i];
    }
  }
  public int buildingsSeeSunset() {
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (building[i] > maxAtLeft[i]) count++;
    }
    return count;
  }
}