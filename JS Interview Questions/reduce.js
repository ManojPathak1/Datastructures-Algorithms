const sum = [1, 2, 3, 4, 5].reduce((acc, e) => acc + e);

const reduce = (cb, initial) => {
  const arr = this;
  const isInitialUndefined = initial === undefined;
  if (isInitialUndefined && arr.length >= 1) initial = arr[0];
  let acc = initial;
  for (let i = isInitialUndefined ? 1 : 0; i < arr.length; i++) {
    acc = cb(acc, arr[i]);
  }
  return acc;
};

Array.prototype.reduce = reduce;