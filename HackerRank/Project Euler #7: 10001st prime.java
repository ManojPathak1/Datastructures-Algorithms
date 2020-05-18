//  Project Euler #7: 10001st prime
//  https://www.hackerrank.com/contests/projecteuler/challenges/euler007/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      System.out.println(getPrime(n));
    }
  }
  public static int getPrime(int n) {
    if (n == 1) return 2;
    if (n == 2) return 3;
    if (n == 3) return 5;
    int num = 6;
    int index = 3;
    while (true) {
      if (!(num % 2 == 0 || num % 3 == 0 || num % 5 == 0)) {
        index++;
        if (index == n) return num;
      }
      num++; 
    }
  }
}

//  Only 25% testcases passed.