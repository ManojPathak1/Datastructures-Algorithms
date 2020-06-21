//  Pascal's Triangle
//  https://leetcode.com/problems/pascals-triangle/

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) return result;
    else if (numRows == 1) {
      List<Integer> list = new ArrayList<>();
      list.add(1);
      result.add(list);
    } else if (numRows == 2) {
      List<Integer> list = new ArrayList<>();
      List<Integer> list2 = new ArrayList<>();
      list.add(1);
      list2.add(1);
      list2.add(1);
      result.add(list);
      result.add(list2);
    } else {
      List<Integer> list = new ArrayList<>();
      List<Integer> list2 = new ArrayList<>();
      list.add(1);
      list2.add(1);
      list2.add(1);
      result.add(list);
      result.add(list2);
      for (int j = 0; j < numRows - 2; j++) {
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        List<Integer> iterate = result.get(result.size() - 1);
        for (int i = 0; i < iterate.size() - 1; i++) {
          int e1 = iterate.get(i);
          int e2 = iterate.get(i + 1);
          list3.add(e1 + e2);
        }
        list3.add(1);
        result.add(list3);
      }
    }
    return result;
  }
}