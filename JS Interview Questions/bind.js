function _bind(context, ...args1) {
  context.func = this;
  return (...args2) => {
    const value = context.func(...args1.concat(args2));
    delete context.func;
    return value;
  }
}

const obj = {
  firstName: "Manoj",
  lastName: "Pathak"
};

function printName(postMessage) {
  return this.firstName + " " + this.lastName + " " + postMessage;
}

Function.prototype._bind = _bind;

const bindedFunction = printName._bind(obj, "Hello");

console.log(bindedFunction("Brother"));
console.log(obj);