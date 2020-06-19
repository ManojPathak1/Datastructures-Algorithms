// Find N’th item in a set formed by sum of two arrays
// https://www.geeksforgeeks.org/find-nth-item-set-formed-sum-two-arrays/

import java.util.*;

public class Main {
	public static void main(String args[]) {
		int arr1[] = { 1,3, 4, 8, 10};
    int arr2[] = {20, 22, 30, 40};
    int pos = 4;
		int m = arr1.length;
		int n = arr2.length;
		System.out.println(Main.nthElement(arr1, arr2, m, n, pos));
	}
	public static int nthElement(int arr1[], int arr2[], int m, int n, int pos) {
		SortedSet<Integer> hs = new TreeSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int sum = arr1[i] + arr2[j];
				hs.add(sum);
			}
		}
		if (hs.size() < pos) return -1;
		return (int)hs.toArray()[pos - 1];
	}
}