//  Ransom Note
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> hmap = new HashMap<>();
    for (int i = 0; i < ransomNote.length(); i++) {
      char e = ransomNote.charAt(i);
      if (hmap.containsKey(e)) hmap.put(e, hmap.get(e) + 1);
      else hmap.put(e, 1);
    }
    for (int i = 0; i < magazine.length(); i++) {
      char e = magazine.charAt(i);
      if (hmap.containsKey(e)) hmap.put(e, hmap.get(e) - 1);
    }
    for (Map.Entry<Character, Integer> e : hmap.entrySet()) {
      if (e.getValue() > 0) return false;
    }
    return true;
  }
}