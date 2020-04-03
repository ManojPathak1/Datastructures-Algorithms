// Find the row with maximum number of 1s
// https://geeksforgeeks.org/find-the-row-with-maximum-number-1s/

import java.util.*;
public class Main {
    static int R = 4;
    static int C = 4;
    public static void main(String args[]) {
        int mat[][] = { { 0, 0, 0, 1 }, 
                        { 0, 1, 1, 1 }, 
                        { 1, 1, 1, 1 }, 
                        { 0, 0, 0, 0 } };
        System.out.println(Main.rowWithMax1s(mat));
    }
    public static int rowWithMax1s(int mat[][]) {
        int row = 0;
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < R; r++) {
            int value = Main.binaryMax(mat, 0, C - 1, r);
            if (value > max) {
                max = value;
                row = r;
            }
        }
        return row;
    }
    public static int binaryMax(int mat[][], int l, int h, int row) {
        int m = (l + h) / 2;
        if (m - 1 >= 0) {
            if (mat[row][m - 1] == 0 && mat[row][m] == 1) return C - m;
            else if (l == h) return 0;
            else if (mat[row][m] == 0 && mat[row][m - 1] == 0) return binaryMax(mat, m+1, h, row);
            else if (mat[row][m] == 1 && mat[row][m - 1] == 1) return binaryMax(mat, l, m-1, row);
        }
        return C;
    }
}