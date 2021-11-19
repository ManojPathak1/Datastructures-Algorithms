const map = function (cb) {
  const result = [];
  this.forEach((el, index) => result.push(cb(el, index, this)));
  return result;
};

Array.prototype.map = map;

[1, 2, 3].map((el, index, arr) => {
  console.log(index, arr);
  return el * 2;
});