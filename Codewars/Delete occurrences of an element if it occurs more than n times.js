//  Delete occurrences of an element if it occurs more than n times
//  https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/javascript

function deleteNth(arr, n) {
  if (n === 0 || n === undefined) return arr;
  const countMap = {};
  const result = arr.filter(e => {
    if (countMap[e]) ++countMap[e];
    else countMap[e] = 1;
    return countMap[e] <= n;
  });
  return result;
}