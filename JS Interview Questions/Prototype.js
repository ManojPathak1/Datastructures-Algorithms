const animal = {
  eats: true,
  walk() {
    alert("Animal");
  }
}

const rabbit = {
  jump: true,
  __proto__: animal
};

const longEar = {
  earLength: 10,
  __proto__: rabbit
};


// Rabbit
longEar.__proto__;

// Animal
longEar.__proto__.__proto__;

//  Object
longEar.__proto__.__proto__.__proto__;