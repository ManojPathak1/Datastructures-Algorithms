class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        for (int c = 0; c < m; c++)
            for (int r = 0; r < n; r++)
                if (arr[r][c] == 1) return r;
        
        return -1;
    }
}