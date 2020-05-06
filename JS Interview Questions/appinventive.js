// Palindrome Question
function getPalindrome(arr) {
  return arr.filter(el => isPalindrome(el));
}

function isPalindrome(str) {
  const tempStr = str;
  let j = 0;
  for (let i = str.length - 1; i >= 0; i--) {
    str[j] = str[i];
    j++;
  }
  if (tempStr === str) return true;
  return false;
}

const result = getPalindrome(arr);

// Calculate frequency of an object strings
function getFrequencyObject(arr) {
  const obj = {};
  arr.forEach(el => {
    if (obj[el]) obj[el]++;
    else obj[el] = 1;
  });
  return obj;
}

const frequencyObject = getFrequencyObject(arr);

// Adding a function in the function prototype
function _filter() {

}

Array.prototype._filter = _filter; // Create prototype


// Removing an event in useEffect
useEffect(() => {
  return () => {
    // Remove anything which is subscribed.    
  }
});

// Update a particular key, using dynamic key in this.state.
function updateState(key, value) {
  this.setState({ [key]: value });
}



// Rest arguments
abc(1, 2, 3, 4);

// Promise.all
function apiCall() {
  return Promise();
}

function getUsersData(userIds) {
  return Promise.all(userIds.map(el => apiCall(el)));
}

async function data(userIds) {
  const userData = await getUsersDataData(userIds);
  console.log(userData);
}

// Create singleton class
function ABC() {
  this.a = 10;
}

function createSingleTon() {

}

const a = new ABC();
const b = new ABC();