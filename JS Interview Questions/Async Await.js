function getFirstVal() {
  console.log("1. I am called");
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(2);
    }, 1000);
  });
}

function getSecondVal(div) {
  console.log("2. I am called");
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      reject(Error(10 % div));
    }, 1000);
  });
}

async function calculateSomething() {
  try {
    const val1 = await getFirstVal();
    const res = await getSecondVal(val1);
    return (res);
  }
  catch (err) {
    console.log("My Err" + err);
    throw (err);
  }
}

async function callMe() {
  try {
    let res = await calculateSomething();
    console.log("Response: ", res);
  }
  catch (err) {
    console.log("Error: ", err);
  }
}

callMe();