// Immutable way of deleting an element at a praticular index in an array.
const removeElement = (arr, index) => {
  const newArr = [...arr];  // Clone the array.
  newArr.splice(index, 1);
  return newArr;
};

const addElement = (arr, elem) => {
  const newArr = [...arr];
  newArr.push(elem);
  return newArr;
};