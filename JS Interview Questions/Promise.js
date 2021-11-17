class MyPromise {
  resolvedData;
  rejectedData;

  resolveChain = [];
  rejectChain = [];

  isResolved = false;
  isRejected = false;

  constructor(executor) {
    const resolve = (value) => {
      this.resolvedData = value;
      this.isResolved = true;
      if (this.resolveChain.length)
        this.resolveChain.reduce((acc, cb) => cb(acc), this.resolvedData);
    };
    const reject = (value) => {
      this.rejectedData = value;
      this.isRejected = true;
      if (this.rejectChain.length)
        this.rejectChain.reduce((acc, cb) => cb(acc), this.rejectedData);
    };
    executor(resolve, reject);
  }

  then = (cb) => {
    this.resolveChain.push(cb);
    if (this.isResolved)
      this.resolveChain.reduce((acc, cb) => cb(acc), this.resolvedData);
    return this;
  };

  catch = (cb) => {
    this.rejectChain.push(cb);
    if (this.isRejected)
      this.rejectChain.reduce((acc, cb) => cb(acc), this.rejectedData);
    return this;
  };

  finally = (cb) => {
    this.resolveChain.add(cb);
    this.rejectChain.add(cb);

    if (this.isResolved)
      this.resolveChain.reduce((acc, cb) => cb(acc), this.resolvedData);
    if (this.isRejected)
      this.rejectChain.reduce((acc, cb) => cb(acc), this.rejectedData);
  };
}
