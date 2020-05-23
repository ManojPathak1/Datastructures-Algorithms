//  Using ES6 class
class Logger {
  constructor() {
    if (Logger.instance === undefined) {
      this.logs = [];
      Logger.instance = this;
    }
    return Logger.instance;
  }
  printLog(message) {
    this.logs.push(message);
    console.log(`Log: ${message}`);
  }
  getLength() {
    console.log(`Length: ${this.log.length}`);
  }
}

//  Using ES5
function Logger() {
  if (Logger.instance === undefined) {
    this.logs = [];
    Logger.instance = this;
  }
  return Logger.instance;
}