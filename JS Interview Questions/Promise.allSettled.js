const allSettled = (promises) => {
  const resolveHandler = (value) => ({ status: "fulfilled", value });
  const rejectHandler = (reason) => ({ status: "rejected", reason });

  const convertedPromises = promises.map((p) =>
    Promise.resolve(p).then(resolveHandler, rejectHandler)
  );
  return Promise.all(convertedPromises);
};

Promise._allSettled = allSettled;
