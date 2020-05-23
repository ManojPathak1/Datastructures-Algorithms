/**
 * 1. filter
 * 2. map
 * 3. find
 * 4. forEach
 * 5. some
 * 6. every
 * 7. reduce
 * 8. includes
 */

const items = [
  { name: 'Bike', price: 100 },
  { name: 'TV', price: 200 },
  { name: 'Album', price: 10 },
  { name: 'Book', price: 5 },
  { name: 'Phone', price: 500 },
  { name: 'Computer', price: 1000 },
  { name: 'Keyboard', price: 25 },
];

//  1. filter
const filteredItems = items.filter(el => el.price <= 100);

console.log(filteredItems);

//  2. map
const mappedArray = items.map(item => item.name);
console.log(mappedArray);

//  3. find
const foundItem = items.find(item => item.name === 'Book');

//  4. forEach
items.forEach(item => {
  console.log(item.name);
});

//  5. some
const hasInexpensive = items.some(item => item.price < 100);
console.log(hasInexpensive);

//  6. every
const hasEveryInexpensive = items.every(item => item.price < 1001);
console.log(hasEveryInexpensive);

//  7. reduce
const sumOfPrice = items.reduce((acc, item) => acc + item.price, 0);
console.log(sumOfPrice);

const it = [10, 20, 30, 40, 5, 60];
console.log(it.includes(10));

function every(arr, cb) {
  for (let i = 0; i < arr.length; i++) if (!cb(arr[i])) return false;
  return true;
}

function some(arr, cb) {
  for (let i = 0; i < arr.length; i++) if (cb(arr[i])) return true; 
  return false;
}

