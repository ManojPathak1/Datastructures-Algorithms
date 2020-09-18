const _setInterval = (callback, delay) => {
  const timerRef = { id: null };
  const timeout = () => {
    timerRef.id = setTimeout(() => {
      callback();
      timeout();
    }, delay);
  }
  timeout();
  return timerRef;
};

const timerRef = _setInterval(() => {
  console.log("Callback");
}, 1000);

setTimeout(() => {
  clearTimeout(timerRef.id);
}, 5000);