//  Sort a linked list of 0s, 1s and 2s
//  https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int tc = scan.nextInt();
    while(tc > 0) {
      LinkedList ll = new LinkedList();
      int n = scan.nextInt();
      for (int i = 0; i < n; i++) {
        int data = scan.nextInt();
        ll.add(data);
      }
      ll.print();
      ll.sortAndPrint();
      tc--;
    }
  }
}

class LinkedList {
  Node head;
  LinkedList() {
    head = null;
  }
  public void add(int data) {
    Node current = head;
    Node newNode = new Node(data);
    if (head == null) { head = newNode; return; }
    while(current.next != null) current = current.next;
    current.next = newNode;
  }
  public void print() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
  private Count getCount() {
    int zeroes = 0;
    int ones = 0;
    int twoes = 0;
    Node current = head;
    while(current != null) {
      int data = current.data;
      if (data == 0) zeroes++;
      else if (data == 1) ones++;
      else if (data == 2) twoes++;
      current = current.next;
    }
    return new Count(zeroes, ones, twoes);
  }
  private void sort() {
    Node current = head;
    Count c = getCount();
    int zeroes = c.zeroes;
    int ones = c.ones;
    int twoes = c.twoes;
    while (current != null) {
      if (zeroes > 0) { current.data = 0; zeroes--; }
      else if (ones > 0) { current.data = 1; ones--; }
      else if (twoes > 0) { current.data = 2; twoes--; }
      current = current.next;
    }
  }
  public void sortAndPrint() {
    sort();
    print();
  }
}

class Node {
  int data;
  Node next;
  Node(int data) {
    this.data = data;
    next = null;
  }
}

class Count {
  int zeroes, ones, twoes;
  Count(int zeroes, int ones, int twoes) {
    this.zeroes = zeroes;
    this.ones = ones;
    this.twoes = twoes;
  }
}

/**
INPUT
1
6
0 1 2 0 1 2

OUTPUT
0 1 2 0 1 2 
0 0 1 1 2 2
 */