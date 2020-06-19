//  _.chunk
const chunk = (arr, size) => {
  if (size === 0) return arr;
  const result = [];
  const subArr = [];
  let multiple = size;
  arr.forEach((e, i) => {
    subArr.push(e);
    if (multiple === (i + 1) || arr.length === (i + 1)) {
      result.push(subArr);
      subArr.length = 0;
      multiple += size; 
    }
  });
  return result;
};

//  _.compact
const compact = (arr) => arr.filter(e => Boolean(e));

//  _.concat
const concat = (arr, ...args) => {
  let result = [...arr];
  args.forEach(e => {
    if (!Array.isArray(e)) e = [e];
    result = [...result, ...e];
  });
  return result;
};

//  _.difference
const difference = (arr1, arr2) => {
  const set = new Set(arr2);
  return arr1.filter(e => !set.has(e));
};

