let data = [
  [null, null, null],
  [null, null, null],
  [null, null, null],
];
const clone = data => JSON.parse(JSON.stringify(data));
const reset = clone(data);
let chance = 'X';
const indexes = {
  FIRST_ROW: [[0, 0], [0, 1], [0, 2]],
  FIRST_COLUMN: [[0, 0], [1, 0], [2, 0]],
  LAST_ROW: [[2, 2], [2, 0], [2, 1]],
  LAST_COLUMN: [[2, 2], [0, 2], [1, 2]],
  LEFT_DIAGONAL: [[1, 1], [0, 0], [2, 2]],
  RIGHT_DIAGONAL: [[1, 1], [0, 2], [2, 0]],
  VERTICAL_DIAGONAL: [[0, 1], [1, 1], [2, 1]],
  HORIZONTAL_DIAGONAL: [[1, 0], [1, 1], [1, 2]],
};

const getUnit = (value, rI, cI, winner) => {
  const div = document.createElement('DIV');
  const img = document.createElement('IMG');
  !(winner || value) && div.addEventListener('click', function () {
    modifyData(rI, cI);
  });
  if (value) img.src = value === 'X' ? './images/cross.png' : './images/circle.png';
  img.width = 60;
  div.classList.add('unit');
  (winner || []).find(([r, c]) => r === rI && c === cI) && div.classList.add('animate');
  div.appendChild(img);
  return div;
};

const renderColumn = (columnData, rowIndex, winner) => {
  const div = document.createElement('DIV');
  div.classList.add('column');
  columnData.forEach((e, columnIndex) => {
    div.appendChild(getUnit(e, rowIndex, columnIndex, winner));
  });
  return div;
};

const renderTicTac = (data, winner) => {
  const ticToc = document.getElementById('ticTocContainer');
  ticToc.innerHTML = '';
  const fragment = new DocumentFragment();
  data.forEach((e, i) => {
    fragment.appendChild(renderColumn(e, i, winner));
  });
  ticToc.appendChild(fragment);
};

const modifyData = (rowIndex, columnIndex) => {
  data[rowIndex][columnIndex] = chance;
  const winner = checkForWinner();
  renderTicTac(data, winner);
  chance = chance === 'O' ? 'X' : 'O';
};

const checkForWinner = () => {
  let startValue = data[0][0];
  if (startValue && startValue === data[0][1] && startValue === data[0][2]) return indexes.FIRST_ROW;
  if (startValue && startValue === data[1][0] && startValue === data[2][0]) return indexes.FIRST_COLUMN;
  startValue = data[2][2];
  if (startValue && startValue === data[2][0] && startValue === data[2][1]) return indexes.LAST_ROW;
  if (startValue && startValue === data[0][2] && startValue === data[1][2]) return indexes.LAST_COLUMN;
  startValue = data[1][1];
  if (startValue && startValue === data[0][0] && startValue === data[2][2]) return indexes.LEFT_DIAGONAL;
  if (startValue && startValue === data[0][2] && startValue === data[2][0]) return indexes.RIGHT_DIAGONAL;
  if (startValue && startValue === data[0][1] && startValue === data[2][1]) return indexes.VERTICAL_DIAGONAL;
  if (startValue && startValue === data[1][0] && startValue === data[1][2]) return indexes.HORIZONTAL_DIAGONAL;
  return undefined;
};

const resetData = () => {
  data = clone(reset);
  renderTicTac(data);
};

const resetButton = document.getElementById('resetButton');
resetButton.addEventListener('click', resetData);

renderTicTac(data);