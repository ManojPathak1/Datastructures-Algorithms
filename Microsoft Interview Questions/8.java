//  Length of the longest substring without repeating characters
//  https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    String str = "ABCDDDDDLMNOPRSTTUVWXYZ";
    char ch[] = str.toCharArray();
    System.out.println(longestSubstring(ch));
  }
  public static int longestSubstring(char ch[]) {
    HashMap<Character, Integer> hm = new HashMap<>();
    int breakIndex = 0;
    int max = 0;
    for (int i = 0; i < ch.length; i++) {
      if (hm.get(ch[i]) != null) {
        if (hm.get(ch[i]) >= breakIndex) {
          if (max < i - breakIndex) max = i - breakIndex;
          breakIndex = i;
        } 
      } 
      hm.put(ch[i], i);
    }
    if (max < ch.length - breakIndex - 1) return ch.length - breakIndex;
    if (breakIndex == 0) return ch.length;
    return max;
  }
}

// Space complexity O(n)
// Time Complexity O(n)