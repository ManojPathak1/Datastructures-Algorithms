/**
 * Given a JS object, obj = {a: 1, getA: function() { return this.a } }
var get = obj.getA;
console.log(get());
what will it print? How will you prevent it to fit undefined?
 */

const obj = {
  a: 1,
  getA: function () {
    return this.a;
  }
};

const getA = obj.getA;
console.log(getA());  // Output: undefined

//  Can be fixed using call function passing the this context.