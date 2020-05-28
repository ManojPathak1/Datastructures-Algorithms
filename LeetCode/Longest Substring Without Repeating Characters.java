//  Longest Substring Without Repeating Characters
//  https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
  public int lengthOfLongestSubstring(String s) {
    char ch[] = s.toCharArray();
    int size = ch.length;
    int res = 0;
    int i = 0;
    int j = 0;
    HashSet<Character> set = new HashSet<>();
    while (j < size) {
      if (!set.contains(ch[j])) {
        set.add(ch[j]);
        j++;
        res = Math.max(set.size(), res);
      } else {
        set.remove(ch[i]);
        i++;
      }
    }
    return res;
  }
}