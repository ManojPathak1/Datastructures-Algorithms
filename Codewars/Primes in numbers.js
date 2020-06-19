//  Primes in numbers
//  https://www.codewars.com/kata/54d512e62a5e54c96200019e/train/javascript

const primeFactors = n => {
  let result = "";
  const getPrime = getNextPrimeNo();
  while (n !== 1) {
    let primeNo = getPrime();
    let count = 0;
    while (n % primeNo === 0) { n /= primeNo; count++; }
    if (count > 0 && count === 1) result += `(${primeNo})`;
    else if (count > 0) result += `(${primeNo}**${count})`;
  }
  return result;
};

const isPrime = n => {
  for (let i = 2; i < n; i++) if (n % i === 0) return false;
  return true;
};

const getNextPrimeNo = () => {
  let i = 1;
  return () => {
    i++;
    while (!isPrime(i)) i++;
    return i;
  };
};

//  Time complexity definition.