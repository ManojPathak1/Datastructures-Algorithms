//  3Sum
//  https://leetcode.com/problems/3sum/

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    HashMap<Integer, Pair> hmap = new HashMap<>();
    List<List<Integer>> list = new ArrayList<>();
    int n = sums.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int pairSum = nums[i] + nums[j];
        hmap.put(pairSum, new Pair(i, j));
      }
    }
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      num -= 2 * num;
      Pair p = hmap.get(num);
      if (hmap.containsKey(num) && p.i != i && p.j != i) {
        List<Integer> l = new ArrayList<Integer>();
        l.addAll(List.of(nums[p.i], nums[p.j], nums[i]));
        list.add(l)
      } 
    }
    return list;
  }
}

class Pair {
  int x, y;
  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

//  Sample test case not passed.