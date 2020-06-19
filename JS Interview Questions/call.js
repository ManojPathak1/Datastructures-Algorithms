function _call(context, ...args) {
  context.func = this;
  const value = context.func(...args);
  delete context.func;
  return value;
};

Function.prototype._call = _call;

function myfunction(arg1, arg2) {
  return `${this.name} ${arg1} : ${arg2}`;
}

myfunction._call({ name: "Charlie" }, 1, 2);