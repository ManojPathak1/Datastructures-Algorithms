// Tic-Tac-Toe Checker
// https://www.codewars.com/kata/525caa5c1bf619d28c000335/train/javascript

function isSolved(board) {
  const newBoard = [...board];
  const rows = 3;
  const columns = 3;
  for (let col = 0; col < columns; col++) {
    const columnsArr = [];
    for (let row = 0; row < rows; row++) columnsArr.push(board[row][col]);
    newBoard.push(columnsArr);
  }
  const leftDiagonal = [];
  const rightDiagonal = [];
  for (let row = 0; row < rows; row++) {
    for (let col = 0; col < columns; col++) {
      if (row === col) leftDiagonal.push(board[row][col]);
      if (row + col === rows - 1) rightDiagonal.push(board[row][col]);
    }
  }
  newBoard.push(leftDiagonal);
  newBoard.push(rightDiagonal);
  let is0Present = false;
  for (const e of newBoard) {
    const xWinPattern = "1-1-1";
    const oWinPattern = "2-2-2";
    if (e.includes(0)) is0Present = true;
    if (e.join("-") === xWinPattern) return 1;
    if (e.join("-") === oWinPattern) return 2;
  }
  return is0Present ? -1 : 0;
}