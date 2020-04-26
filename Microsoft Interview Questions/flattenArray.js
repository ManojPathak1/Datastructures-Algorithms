Array.prototype.flatten = function () {
  const context = this;
  const result = [];
  const flat = arr => {
    arr.forEach(el => {
      if (Array.isArray(el)) flat(el);
      else result.push(el);
    });
  }
  flat(context);
  return result;
}

[1, [1, [2, [3]]], 4, 5, 6].flatten();