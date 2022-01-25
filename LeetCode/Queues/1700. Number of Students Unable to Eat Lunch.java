class Solution {
  public int countStudents(int[] students, int[] sandwiches) {
    Queue<Integer> studentsQ = new LinkedList<>();
    Queue<Integer> sandwichesQ = new LinkedList<>();
    for (int s: students) studentsQ.add(s);
    for (int s: sandwiches) sandwichesQ.add(s);
    int count = 0;
    while (studentsQ.size() != 0 && count < studentsQ.size()) {
      int student = studentsQ.peek();
      int sandwich = sandwichesQ.peek();
      if (student == sandwich) {
        studentsQ.poll();
        sandwichesQ.poll();
        count = 0;
      } else {
        int s = studentsQ.poll();
        studentsQ.add(s);
        count++;
      }
    }
    return studentsQ.size();
  }
}