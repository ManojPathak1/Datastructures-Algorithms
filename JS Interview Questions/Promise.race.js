const race = (promises) => new Promise((resolve) => {
  promises.forEach(p => {
    Promise.resolve(p).then(promise => {
      resolve(promise);
    });
  });
});

Promise._race = race;

const p1 = new Promise(resolve => {
  setTimeout(() => {
    resolve(2000);
  }, 2000);
});

const p2 = new Promise(resolve => {
  setTimeout(() => {
    resolve(4000);
  }, 4000);
});

Promise._race([p1, p2]).then(result => {
  console.log(result);
});