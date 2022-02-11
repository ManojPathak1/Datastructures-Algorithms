class Solution {
  public List<String> buildArray(int[] target, int n) {
    List<String> list = new ArrayList<>();
    int targetIndex = 0;
    for (int i = 1; i <= n; i++) {
      if (targetIndex == target.length) break;
      list.add("Push");
      if (target[targetIndex] != i) list.add("Pop");
      else targetIndex++;
    }
    return list;
  }
}