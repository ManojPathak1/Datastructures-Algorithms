//  Balanced Brackets
//  https://www.hackerrank.com/challenges/balanced-brackets/problem?h_r=next-challenge&h_v=zen

static String isBalanced(String s) {
  char arr[] = s.toCharArray();
  int l = arr.length;
  Stack<Character> stack = new Stack<>();
  for (int i = 0; i < l; i++) {
    char ch = arr[i];
    if (stack.size() > ((l/2) + 1)) break;
    if (stack.empty()) stack.push(ch);
    else {
      if ((ch == '}' && stack.peek() == '{') || (ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '['))
        stack.pop();
      else stack.push(ch);
    }
  }
  if (stack.empty()) return "YES";
  return "NO";
}