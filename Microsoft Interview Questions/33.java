//  Remove every k-th node of the linked list
//  https://www.geeksforgeeks.org/remove-every-k-th-node-linked-list/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    LinkedList ll = new LinkedList();
    for (int i = 0; i < n; i++) ll.add(scan.nextInt());
    int k = scan.nextInt();
    ll.removeKthNode(k);
    ll.print();
  }
}

class LinkedList {
  Node head;
  LinkedList() {
    head = null;
  }
  public void add(int e) {
    Node newNode = new Node(e);
    if (head == null) {
      head = newNode;
      return;
    }
    Node current = head;
    while(current.next != null) {
      current = current.next;
    }
    current.next = new Node(e);
  }
  public void print() {
    Node current = head;
    while(current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
  public void removeKthNode(int k) {
    int c = 0;
    Node current = head;
    while(current != null && current.next != null) {
      c++;
      if (c == k - 1) {
        current.next = current.next.next;
        c = 0;
      }
      current = current.next;
    }
  } 
}

class Node {
  int data;
  Node next;
  Node(int data) {
    this.data = data;
  }
}

/**
INPUT
7
8 7 5 6 8 9 10
3

OUTPUT
8 7 6 8 10
 */