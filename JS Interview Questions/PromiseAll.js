// Checking whether Promise.all rejects the other promises once the early promise are rejected.

let i = 0;

const p1 = () => new Promise((resolve, reject) => setTimeout(() => { i++; reject(1); }));
const p2 = () => new Promise((resolve, reject) => setTimeout(() => { i++; reject(1); }, 2000));
const p3 = () => new Promise(resolve => { console.log("called"); setTimeout(() => { i++; resolve(1); }, 3000); });
const p4 = () => new Promise(resolve => setTimeout(() => { i++; resolve(1); }, 4000));

function main() {
  Promise.all([p1(), fetch("https://jsonplaceholder.typicode.com/todos/1")]).then(() => { }).catch(() => {
    console.log(i);
  });
}

main();