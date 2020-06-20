const inputField = document.getElementById('inputField');
const delayInputField = document.getElementById('delayInputField');
const numsContainer = document.getElementById('numsContainer');

sortButton.addEventListener('click', async () => {
  const nums = eval(inputField.value);
  renderNums(nums);
  await sleep(1000);
  await bubbleSort(nums);
  renderNums(nums, -1, -1);
});

const renderNums = (nums, i, j) => {
  numsContainer.innerHTML = '';
  const numsFragment = new DocumentFragment();
  nums.forEach((n, index) => {
    const numDiv = document.createElement('DIV');
    numDiv.classList.add('numBox');
    if (i === index || j === index) numDiv.classList.add('greenBg');
    const numSpan = document.createElement('SPAN');
    numSpan.innerHTML = n;
    numDiv.append(numSpan);
    numsFragment.append(numDiv);
  });
  numsContainer.append(numsFragment);
};

const bubbleSort = async nums => {
  const len = nums.length;
  for (let i = 0; i < len; i++) {
    let isSwapped = false;
    for (let j = 0; j < len - i - 1; j++) {
      if (nums[j] > nums[j + 1]) {
        await swap(nums, j, j + 1);
        isSwapped = true;
      }
    }
    if (!isSwapped) return;
  }
};

const swap = async (nums, i, j) => {
  const temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
  renderNums(nums, i, j);
  await sleep(Number(delayInputField.value));
};

const sleep = delay => new Promise(resolve => {
  setTimeout(resolve, delay);
});