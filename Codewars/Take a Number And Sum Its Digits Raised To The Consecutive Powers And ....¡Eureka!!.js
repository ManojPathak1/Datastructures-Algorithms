//  Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!
//  https://www.codewars.com/kata/5626b561280a42ecc50000d1/train/javascript

function sumDigPow(a, b) {
  return times(a, b).filter(e => String(e).split("").reduce((acc, val, i) => {
    acc += Math.pow(Number(val), i + 1);
    return acc;
  }, 0) === e);
}

function times(a, b) {
  const result = [];
  for (let i = a; i <= b; i++) result.push(i);
  return result;
}