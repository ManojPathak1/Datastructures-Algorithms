var counter = (function () {
  var i = 0;
  return {
    get: function () {
      return i;
    },
    set: function (val) {
      i = val;
    },
    increment: function () {
      i++;
    }
  };
})();

console.log(counter.get());
console.log(counter.set(5));
console.log(counter.increment());
console.log(counter.get());