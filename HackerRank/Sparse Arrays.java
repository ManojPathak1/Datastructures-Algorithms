//  https://www.hackerrank.com/challenges/sparse-arrays/problem?h_r=next-challenge&h_v=zen
//  Sparse Arrays

static int[] matchingStrings(String[] strings, String[] queries) {
  HashMap<String, Integer> stringToCount = new HashMap<>();
  for (String e : strings) {
    if (stringToCount.containsKey(e)) stringToCount.put(e, stringToCount.get(e) + 1);
    else stringToCount.put(e, 1);
  }
  int queriesLen = queries.length;
  int result[] = new int[queriesLen];
  for (int i = 0; i < queriesLen; i++) {
    String e = queries[i];
    if (stringToCount.containsKey(e)) result[i] = stringToCount.get(e);
    else result[i] = 0;
  }
  return result;
}