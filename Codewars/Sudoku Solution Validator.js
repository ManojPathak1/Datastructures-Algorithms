//  Sudoku Solution Validator
//  https://www.codewars.com/kata/529bf0e9bdf7657179000008/train/javascript

const validSolution = (board) => {
  // Validate rows
  const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  const validRow = board.every(row => {
    const set = new Set(nums);
    row.forEach(e => {
      set.delete(e);
    });
    return set.size === 0;
  });
  if (!validRow) return false;
  //  Validate Columns
  for (let col = 0; col < 9; col++) {
    const set = new Set(nums);
    for (let row = 0; row < 9; row++) {
      const e = board[row][col];
      set.delete(e);
    }
    if (set.size !== 0) return false;
  }
  return true;
};

/*
1 2 3 4 5 6 7 8 9
2 3 1 5 6 4 8 9 7
3 1 2 6 4 5 9 7 8
4 5 6 7 8 9 1 2 3
5 6 4 8 9 7 2 3 1
6 4 5 9 7 8 3 1 2
7 8 9 1 2 3 4 5 6
8 9 7 2 3 1 5 6 4
9 7 8 3 1 2 6 4 5
*/
//  Failing for this test case.