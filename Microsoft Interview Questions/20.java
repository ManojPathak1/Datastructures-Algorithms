//  Pairwise swap elements of a given linked list
//  https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/

public class Main {
  public static void main(String args[]) {
    LinkedList ll = new LinkedList();
    ll.head = new Node(1);
    ll.head.next = new Node(2);
    ll.head.next.next = new Node(3);
    ll.head.next.next.next = new Node(4);
    ll.head.next.next.next.next = new Node(5);
    ll.head.next.next.next.next.next = new Node(6);
    ll.print();
    ll.reversePair();
    ll.print();
  }
}

class LinkedList {
  Node head;
  public void print() {
    Node current = head;
    while(current.next != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
  public void reversePair() {
    Node current = head;
    while(current != null && current.next != null) {
      int data1 = current.data;
      int data2 = current.next.data;
      current.data = data2;
      current.next.data = data1;
    }
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