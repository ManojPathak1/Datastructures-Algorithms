function actionCreator(type, ...argNames) {
  return (...args) => {
    const action = { type };
    argNames.forEach((argName, i) => action[argName] = args[i]);
    return action;
  }
}

let timerId = setTimeout(function request() {
  for (let i = 0; i < 100000000; i++) {}
  timerId = setTimeout(request, 1000);
}, 1000);


// Using caching mechanism for the function with single argument.

function cachingDecorator(func) {
  const cache = new Map();
  return x => {
    if (cache.has(x)) return cache.get(x);
    const result = func(x);
    cache.put(x, result);
    return result;
  }
}



function throttle(func, delay) {
  let callFunc = true;
  return (...args) => {
    if (callFunc) {
      callFunc = false;
      func.apply(this, args);
      setTimeout(() => {
        callFunc = true;
      }, delay);
    }
  }
}