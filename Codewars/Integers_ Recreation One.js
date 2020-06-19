//  Integers: Recreation One
//  https://www.codewars.com/kata/55aa075506463dac6600010d/train/javascript

function listSquared(m, n) {
  const result = [];
  for (let i = m; i <= n; i++) {
    const squareSum = getSquareSum(getDivisors(i));
    isPerfectSquare(squareSum) && result.push([i, squareSum]);
  }
  return result;
}

function isDivisible(n, d) {
  return n % d === 0;
}

function getDivisors(n) {
  const divisors = [];
  for (let i = 1; i <= n; i++) isDivisible(n, i) && divisors.push(i);
  return divisors;
}

function getSquareSum(a) {
  return a.reduce((acc, e) => {
    acc += e * e;
    return acc;
  }, 0);
}

function isPerfectSquare(n) {
  const sq = Math.sqrt(n);
  return sq > 0 && sq % 1 === 0;
}