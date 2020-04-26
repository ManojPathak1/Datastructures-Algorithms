//  Platform problem

import java.util.*;

public class Main {
  public static void main(String args[]) {
    int arrival[] = { 900,  940, 950,  1100, 1500, 1800 };
    int departure[] = { 910,  1200,  1120, 1130, 1900, 2000};
    int trains = arrival.length;
    MinimumPlatform m = new MinimumPlatform(trains, arrival, departure);
    m.printResult();
  }
}

class MinimumPlatform {
  private int trains;
  private int arrival[];
  private int departure[];
  MinimumPlatform(int trains, int arrival[], int departure[]) {
    this.trains = trains;
    this.arrival = arrival;
    this.departure = departure;
  }
  private int getMinimumPlatforms() {
    int a = 0;
    int d = 0;
    int maxPlatform = 0;
    int countSoFar = 0;
    Arrays.sort(arrival);
    Arrays.sort(departure);
    while (a < trains && d < trains) {
      if (arrival[a] <= departure[d]) {
        countSoFar++;
        a++;
      } else {
        countSoFar--;
        d++;
      }
      maxPlatform = Math.max(maxPlatform, countSoFar);
    }
    while (a < trains) maxPlatform++;
    return maxPlatform;
  }
  public void printResult() {
    System.out.println(getMinimumPlatforms());
  }
}