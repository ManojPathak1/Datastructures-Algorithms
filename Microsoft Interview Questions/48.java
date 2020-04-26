//  Union and Intersection of two Linked Lists
//  https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n1 = scan.nextInt();
    LinkedList ll1 = new LinkedList();
    LinkedList ll2 = new LinkedList();
    for (int i = 0 ; i < n1; i++) {
      int e = scan.nextInt();
      ll1.add(e);
    }
    int n2 = scan.nextInt();
    for (int i = 0 ; i < n2; i++) {
      int e = scan.nextInt();
      ll2.add(e);
    }
    ll1.print();
    ll2.print();
    ResultClass rc = new ResultClass();
    rc.intersectionResult(ll1.head, ll2.head);
    rc.getUnionResult(ll1.head, ll2.head);
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
}

class ResultClass {
  Node head;
  private void add(int e) {
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
  private void intersection(Node head1, Node head2) {
    Set<Integer> set = new HashSet<>();
    Node current1 = head1;
    Node current2 = head2;
    while(current1 != null) {
      set.add(current1.data);
      current1 = current1.next;
    }
    while (current2 != null) {
      if (set.contains(current2.data)) add(current2.data);
      current2 = current2.next;
    }
  }
  public void print() {
    Node current = head;
    while(current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
  public void intersectionResult(Node head1, Node head2) {
    head = null;
    intersection(head1, head2);
    print();
  }
  private void union(Node head1, Node head2) {
    head = null;
    Set<Integer> set = new HashSet<>();
    Node current1 = head1;
    Node current2 = head2;
    while(current1 != null) {
      if (!set.contains(current1.data)) {
        set.add(current1.data);
        add(current1.data);
      }
      current1 = current1.next;
    }
    while(current2 != null) {
      if (!set.contains(current2.data)) {
        set.add(current2.data);
        add(current2.data);
      }
      current2 = current2.next;
    }
  }
  public void getUnionResult(Node head1, Node head2) {
    union(head1, head2);
    print();
  }
}

class Node {
  int data;
  Node next;
  Node(int data) {
    this.data = data;
  }
}