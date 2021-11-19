const filter = function (cb) {
  const result = [];
  this.forEach((el, index, arr) => cb(el, index, arr) && result.push(el));
  return result;
};

Array.prototype._filter = filter;

[1, 2, 3, 4, 5, 6]._filter((el) => el % 2 === 0);