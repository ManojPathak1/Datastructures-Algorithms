//  Remove duplicates from an unsorted linked list
//  https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/

import java.util.*;

class Main {
  public static void main(String args[]) {
    LinkedList ll = new LinkedList();
    //  12->11->12->21->41->43->21
    ll.add(12);
    ll.add(11);
    ll.add(12);
    ll.add(21);
    ll.add(41);
    ll.add(43);
    ll.add(21);
    ll.print();
    ll.removeDuplicates(ll.head);
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
    while(current.next != null) current = current.next;
    current.next = newNode;
  }
  public void print() {
    Node current = head;
    while(current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
  public void removeDuplicates(Node head) {
    HashSet<Integer> set = new HashSet<>();
    Node current = head;
    while (current != null) {
      int data = current.data;
      set.add(data);
      Node temp = current;
      while (temp != null && set.contains(temp.data)) temp = temp.next;
      current.next = temp;
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