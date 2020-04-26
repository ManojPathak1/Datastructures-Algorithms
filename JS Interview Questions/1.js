function makeCounter() {
  let count = 0;
  return () => {
    return count++;
  }
}

const counter = makeCounter();
console.log(counter());
console.log(counter());
console.log(counter());
console.log(counter());

function func(a = 1, b = a) {
  console.log(a +" " + b);
}

func();

const tasksQueue = [];
function eventLoop() {
  while (tasksQueue.size() > 0) {
    const task = tasksQueue.poll();
    execute(task);
  }
}

function pushTask() {
  tasksQueue.add(task);
  eventLoop();
}