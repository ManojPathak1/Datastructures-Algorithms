function func(arr) {
  for (var i = 0; i < arr.length; i++) {
    setTimeout(() => {
      console.log("I: " + i + " Value: " + arr[i]);
    });
  }
}

func([1, 2, 3, 4, 5]);


const arr = [1, 1, 2, 2, 3, 3];

//  1. Iterating two for loops 
//  2. HashMap O(n)

  
function unique(arr = [1, 2, 3, 4, 1, 2]) {
  const set = new Set(arr);
  const newArr = [];
  for (let val of set.entries()) {
    newArr.push(val[0]);
  }
  return newArr;
}

unique();


const arr = [1, 2, 3, 4, 5];

function rotate(arr, n) {
  const len = arr.length;
  n = n % len;
  while (n > 0) {
    const temp = arr[0];
    for (let i = 1; i < len; i++) {
      arr[i - 1] = arr[i];
    }
    arr[len - 1] = temp;
    n--;
  }
  return arr;
}

// rotate([1, 2, 3, 4, 5], 3);
// rotate([1, 2, 3, 4, 5], 6);
rotate([1, 2, 3, 4, 5], 1);