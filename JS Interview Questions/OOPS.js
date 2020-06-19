//  OOP Principle
//  4 Core principles

//  Encapsulation
//  Abstraction
//  Inheritance
//  Polymorphism

//  Encapsulation Example

let baseSalary = 30_000;
let overtime = 10;
let rate = 20;

//  Function with so many parameters
function getWage(baseSalary, overtime, rate) {
  return baseSalary + (overtime * rate);
}

//  Object oriented way
let employee = {
  baseSalary: 30_000,
  overtime: 10,
  rate: 20,
  getWage: function () {
    return this.baseSalary + (this.overtime * this.rate);
  }
};

employee.getWage();


//  Abstraction
//  Inheritance - Helps in eliminating redundant code

//  Polymorphism - Many forms

//  Benefits
//  1. Reduce complexity + Increase Reusability
//  2. Reduce Complexity + isolate impact of changes
//  3. Eliminate Redundant code
//  4. Refactor ugly switch/case statements