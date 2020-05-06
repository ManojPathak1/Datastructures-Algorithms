console.log(1);
SetTimeout(() => console.log(2), 0);
console.log(3);

1
3
2

function foo() {
  var bar = function () { console.log(3) }
  return bar();
  var bar = function () { console.log(8) }
}
foo();


3
undefined


Sum(2)(3)(5) = 10
Sum(3)(3)(3)(4) = 9


const sum = (a) => (b) => (c) => (a + b + c);

var, let, const

const a = [1];
a.push(2);
console.log(a); // 1,2



variable, function, class

var add_the_handlers = function (nodes) {
  for (let i = 0; i < nodes.length; i += 1) {
    nodes[i].onclick = function (e) {
      alert(i);
    }
  }
};


// IIFE
(function () {
  var i;
  for (i = 0; i < nodes.length; i += 1) {
    nodes[i].onclick = function (e) {
      alert(i);
    }
  }
})();

const arr = [10, 12, 15, 21];
for (var i = 0; i < arr.length; i++) {
  setTimeout(function () {
    console.log('Index: ' + i + ', element: ' + arr[i]);
  }, 3000);
}
21 3



console.log(1);

for (let i = 0; i < arr.length; i++) {
  setTimeout(function () {
    console.log('Index: ' + i + ', element: ' + arr[i]);
  }, 3000);
}

(function () {
  for (var i = 0; i < arr.length; i++) {
    setTimeout(function () {
      console.log('Index: ' + i + ', element: ' + arr[i]);
    }, 3000);
  }
})();

function fn() {
  console.log(this);
}
fn();

obj.func();


function func() {
  console.log(this); --> obj
}

var building = {
  floors: 5,
  printThis: function () {
    function bar() {
      console.log(this);
    }
    bar();
  }
}
building.printThis();




doSomething().then(function () {
  return doSomethingElse();
}).then(finalHandler);


doSomething().then(function () {
  doSomethingElse(); // wait 4 seconds
}).then(finalHandler);


doSomething().then(doSomethingElse())
  .then(finalHandler);


doSomething().then(doSomethingElse)
  .then(finalHandler);



filter -> polyfill for filter



[1, 2, 3].filter(el => el > 1);


  function _filter(cb) {
    const arr = this;
    const result = [];
    arr.forEach(el => {
      if (cb(el)) result.push(el);
    });
    return result;
  }

Array.prototype._filter = _filter;



inheritance

foo -> print method, num -> 4

bar -> printx


function foo(num) {
  var privateVar = 10;	// Private variable
  this.num = num;
  this.print = function () { };
}

foo.prototype.staticVar = 10;

function bar() {
  this.printx = function () { };
}

bar.__proto = foo;



static
private