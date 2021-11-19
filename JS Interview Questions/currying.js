const curry = (fn) => {
  return (a) => {
    return (b) => {
      return fn(a, b);
    };
  };
};

const sum = (a, b) => {
  return a + b;
};

const curriedSum = curry(sum);

console.log(curriedSum(1)(2));

// Advanced curry implementation

const curry = (fn) => {
  return function curried(...args) {
    if (args.length >= fn.length) return fn.apply(this, args);
    else return (...args2) => curried.apply(this, args.concat(args2));
  };
};

const sum = (a, b, c) => a + b + c;
const curriedSum = curry(sum);

console.log(curriedSum(1, 2)(3));
console.log(curriedSum(1)(2)(3));
console.log(curriedSum(1, 2, 3));