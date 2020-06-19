//  Add Binary
//  https://leetcode.com/problems/add-binary/

class Solution {
  public String addBinary(String a, String b) {
    int na = a.length();
    int nb = b.length();
    int minLen = Math.min(na, nb);
    String reva = reverse(a);
    String revb = reverse(b);
    int carry = 0;
    String result = "";
    int i = 0;
    for (i = 0; i < minLen; i++) {
      int n1 = Integer.parseInt(String.valueOf(reva.charAt(i)));
      int n2 = Integer.parseInt(String.valueOf(revb.charAt(i)));
      int value = n1 + n2 + carry;
      result += (value % 2);
      carry = value / 2;
    }
    for (; i < na; i++) {
      int n1 = Integer.parseInt(String.valueOf(reva.charAt(i)));
      int value = n1 + carry;
      result += (value % 2);
      carry = value / 2;
    }
    for (; i < nb; i++) {
      int n1 = Integer.parseInt(String.valueOf(revb.charAt(i)));
      int value = n1 + carry;
      result += (value % 2);
      carry = value / 2;
    }
    if (carry == 1) result += carry;
    result = reverse(result);
    return result;
  }
  public String reverse(String str) {
    String revStr = "";
    char ch[] = str.toCharArray();
    for (int i = ch.length - 1; i >= 0; i--) revStr += ch[i];
    return revStr;
  }
}