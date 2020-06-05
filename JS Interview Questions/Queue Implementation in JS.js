class Queue {
  Queue(data) {
    this.data = data;
  }
  add() {

  }
}


Array.prototype._shift = _shift;
function _shift() {
  const arr = this;
  const len = arr.length - 1;
  for (let i = 0; i < len; i++) arr[i] = arr[i + 1];
  arr.length = len;
  return arr;
}

[1, 2, 3, 4, 5]._shift();