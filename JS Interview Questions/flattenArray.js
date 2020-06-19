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

const flatten = (...a) => {
  const result = [];
  const flat = arr => {
    arr.forEach(el => {
      if (Array.isArray(el)) flat(el);
      else result.push(el);
    });
  }
  flat(a);
  return result;
}


const CalculateSum = arr => arr.reduce((acc, e) => acc + e);

CalculateSum(flatten([10, [20, [30, 40], 50]], 60, [70, 80], 90));