//  Letter Combinations of a Phone Number
//  https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    HashMap<Character, char[]> hmap = new HashMap<>();
    char ch2[] = { 'a', 'b', 'c' };
    char ch3[] = { 'd', 'e', 'f' };
    char ch4[] = { 'g', 'h', 'i' };
    char ch5[] = { 'j', 'k', 'l' };
    char ch6[] = { 'm', 'n', 'o' };
    char ch7[] = { 'p', 'q', 'r', 's' };
    char ch8[] = { 't', 'u', 'v' };
    char ch9[] = { 'w', 'x', 'y', 'z' }; 
    hmap.put('2', ch2);
    hmap.put('3', ch3);
    hmap.put('4', ch4);
    hmap.put('5', ch5);
    hmap.put('6', ch6);
    hmap.put('7', ch7);
    hmap.put('8', ch8);
    hmap.put('9', ch9);
    recursionSolution(result, digits, "", hmap, 0);
    return result;
  }
  public void recursionSolution(List<String> result, String digits, String pre, HashMap<Character, char[]> hmap, int index) {
    if (digits.length() == index) {
      if (pre != "") result.add(pre);
      return;
    }
    char ch[] = hmap.get(digits.charAt(index));
    for (char e : ch) recursionSolution(result, digits, pre + e, hmap, index + 1);
  }
}