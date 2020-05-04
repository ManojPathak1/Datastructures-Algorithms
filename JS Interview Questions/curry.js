class MyClass {
  constructor() { }
  method1() { }
  method2() { }
  method3() { }
}

const myClassInstance = new MyClass();
let user = new MyClass();

function makeClass(phrase) {
  return class {
    sayHi() {
      alert(phrase);
    }
  }
}

const User = makeClass("Hello");

new User().sayHi();


class MyClass {
  prop = value;
  constructor() { }
  method() { }
  get something() { }
  set something(value) { }
  [Symbol.iterator]() { }
}


class Clock {
  constructor(template) {
    this.template = template;
    this.timerId = null;
  }
  render = () => {
    const date = new Date();
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();
    if (hours < 10) hours = `0${hours}`;
    if (minutes < 10) minutes = `0${minutes}`;
    if (seconds < 10) seconds = `0${seconds}`;
    const output = this.template.replace('h', hours).replace('m', minutes).replace('s', seconds);
    console.log(output);
  }
  start = () => {
    this.timerId = setInterval(this.render, 1000);
  }
  stop = () => {
    clearInterval(this.timerId);
  }
}

const clock = new Clock("h-m-s");
clock.start();
setTimeout(clock.stop, 5000);



const urls = [];
const promises = urls.map(url => fetch(url));
Promise.all(promises).then(values => {
  console.log(values);
});


function all(promises) {
  let count = promises.length;
  const result = [];
  const isDone = () => count == 0 && Promise.resolve(result);
  promises.forEach((promise, index) => {
    promise
      .then(res => {
        result[index] = res;
        count--;
        isDone();
      })
      .catch(error => { throw new Error(error); });
  });
  return Promise.resolve(result);
}


function curry(func) {
  return function curried(...args) {
    if (args.length >= func.length) return func.apply(this, args);
    else return (...args2) => curried.apply(this, args.concat(args2));
  }
}


i = i ? (i < 0 ? Math.max(0, len + i) : i) : 0;

const text = document.querySelector(".title");
const changeColor = document.querySelector(".changeColor");

text.classList.add("change");