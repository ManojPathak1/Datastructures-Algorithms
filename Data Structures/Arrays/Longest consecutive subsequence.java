class Solution {
	static int findLongestConseqSubseq(int arr[], int N) {
    int max = 0;
    Set<Integer> set = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    for (int el: arr) set.add(el);
    for (int el: arr) {
      if (!visited.contains(el)) {
        int count = 1;
        visited.add(el);
        int temp = el;
        while (set.contains(--temp)) {
          count++;
          visited.add(temp);
        }
        temp = el;
        while (set.contains(++temp)) {
          count++;
          visited.add(temp);
        }
        max = Math.max(count, max);
      }
    }
    return max;
	}
}