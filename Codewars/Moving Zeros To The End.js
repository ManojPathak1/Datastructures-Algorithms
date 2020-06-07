//  Moving Zeros To The End
//  https://www.codewars.com/kata/52597aa56021e91c93000cb0/train/javascript

var moveZeros = function (arr) {
  const arr1 = arr.filter(e => e !== 0);
  const arr2 = arr.filter(e => e === 0);
  return [...arr1, ...arr2];
};