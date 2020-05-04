Function.prototype._bind = _bind;

function _bind(context, ...args1) {
  // context => obj
  // this -> printName
  context.func = this;
  return (...args2) => {
    return context.func(...args1.concat(args2));
  }
}

const obj = {
  firstName: "Manoj",
  lastName: "Pathak"
};

function printName(postMessage) {
  return this.firstName + " " + this.lastName + " " + postMessage;
}

const bindedFunction = printName._bind(obj, "Hello");

bindedFunction("Brother");