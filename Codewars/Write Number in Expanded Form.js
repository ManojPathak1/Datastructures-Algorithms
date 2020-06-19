//  Write Number in Expanded Form
//  https://www.codewars.com/kata/5842df8ccbd22792a4000245/train/javascript

function expandedForm(num) {
  const result = [];
  let i = 0;
  while (num > 0) {
    const r = num % 10;
    const data = r * Math.pow(10, i);
    data !== 0 && result.push(data);
    num = Math.floor(num / 10);
    i++;
  }
  return result.reverse().join(" + ");
}