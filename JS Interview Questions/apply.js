function _apply(context, args) {
  context.func = this;
  const value = context.func(...args);
  delete context.func;
  return value;
};

Function.prototype._apply = _apply;

function myfunction(arg1, arg2) {
  return `${this.name} ${arg1} : ${arg2}`;
}

myfunction._apply({ name: "Charlie" }, [1, 2]);