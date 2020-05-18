//  First way of inheritance using Object.create
const animal = {
  walk: true,
  eats: true,
  shout: function () {
    console.log(`Sound ${this.sound} !`);
  }
};
const rabbit = Object.create(animal);
console.log(rabbit);
rabbit.jump = true;
rabbit.sound = "Rabbit Sound";
console.log(rabbit);


//  Second way of inheritance using __proto__
const animal = {
  walk: true,
  eats: true,
  shout: function () {
    console.log(`Sound ${this.sound} !`);
  }
};
const rabbit = { jump: true, sound: "Rabbit Sound" };
rabbit.__proto__ = animal;

// Third way of inheritance.
class Animal {
  constructor(walk, eats) {
    this.walk = walk;
    this.eats = eats;
  }
  shout() {
    console.log(`Sound ${this.sound}`);
  }
}

class Rabbit extends Animal {
  constructor(jump, sound) {
    super(true, true);
    this.jump = jump;
    this.sound = sound;
  }
}

const rabbit = new Rabbit(true, "Rabbit Sound");
rabbit.shout();

// Fourth way of inheritance
function Animal(walk, eats) {
  this.jump = walk;
  this.sound = eats;
}

Animal.prototype.walk = true;
Animal.prototype.eats = true;
Animal.prototype.shout = function () {
  console.log(`Sound ${this.sound}`);
};

const rabbit = new Animal(true, "Rabbit Sound");
rabbit.shout();