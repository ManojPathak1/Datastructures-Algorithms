Array.prototype._forEach = function (cb) {
  for (let i = 0; i < this.length; i++) cb(this[i], i, this);
};

[1, 2, 3]._forEach((el, index, arr) => console.log(`${el} ${index} ${arr}`));
