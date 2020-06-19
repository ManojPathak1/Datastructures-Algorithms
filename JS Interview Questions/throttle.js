const throttle = (func, delay) => {
  let callFunc = true;
  return (...args) => {
    if (callFunc) {
      callFunc = false;
      func.apply(null, args);
      setTimeout(() => {
        callFunc = true;
      }, delay);
    }
  }
};

const log = count => console.log(count);

const throttledLog = throttle(log, 2000);

throttledLog(1);
throttledLog(2);
throttledLog(3);
const timer = setTimeout(() => {
  throttledLog(4);
  throttledLog(5);
  setTimeout(() => {
    throttledLog(6);
  }, 2000);
}, 2000);


//  Output is 1, 4, 6.