const result = await Promise.all([]);

Promise.all = (promises) =>
  new Promise((resolve, reject) => {
    const results = [];
    const completed = 0;
    promises.forEach((promise, index) => {
      Promise.resolve(promise)
        .then((result) => {
          completed++;
          results[index] = result;
          if (completed === promises.length) resolve(results);
        })
        .catch(reject);
    });
  });
