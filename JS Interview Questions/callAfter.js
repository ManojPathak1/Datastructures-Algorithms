Function.prototype.callAfter = callAfter;

function callAfter(delay, ...args) {
  var context = this;
  setTimeout(() => {
    context(...args);
  }, delay);
}

function sum(a, b) {
  console.log(a + b);
}

sum.callAfter(5000, 1, 2);