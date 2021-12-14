class Solution {
  static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
    ArrayList<Integer> result = new ArrayList<>();
    int rowMin = 0;
    int rowMax = r - 1;
    int colMin = 0;
    int colMax = c - 1;
    int count = 0;
    int total = r * c;

    while (count < total) {
      // Top section
      for (int i = rowMin, j = colMin; j <= colMax && count < total; j++) {
        result.add(matrix[i][j]);
        count++;
      }
      rowMin++;

      // Right Section
      for (int i = rowMin, j = colMax; i <= rowMax && count < total; i++) {
        result.add(matrix[i][j]);
        count++;
      }
      colMax--;

      // Bottom Section
      for (int i = rowMax, j = colMax; j >= colMin && count < total; j--) {
        result.add(matrix[i][j]);
        count++;
      }
      rowMax--;

      // Left Section
      for (int i = rowMax, j = colMin; i >= rowMin && count < total; i--) {
        result.add(matrix[i][j]);
        count++;
      }
      colMin++;
    }

    return result;
  }
}