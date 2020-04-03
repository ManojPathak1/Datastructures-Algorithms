//  Intersection of two Sorted Linked Lists
//  https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/

public class Main {
  public static void main(String args[]) {
    LinkedList ll = new LinkedList();
    ll.head1 = new Node(1);
    ll.head1.next = new Node(3);
    ll.head1.next.next = new Node(5);
    ll.head1.next.next.next = new Node(8);
    ll.head1.next.next.next.next = new Node(9);
    ll.head1.next.next.next.next.next = new Node(10);
    ll.head2 = new Node(2);
    ll.head2.next = new Node(4);
    ll.head2.next.next = new Node(6);
    ll.head2.next.next.next = new Node(7);
    ll.mergeList();
    ll.print();
  }
}

class LinkedList {
  Node head1, head2, result;
  Node mergeList() {
    Node current1 = head1;
    Node current2 = head2;
    Node temp = null;
    result = null;
    while(current1 != null && current2 != null) {
      Node newNode;
      if (current1.data < current2.data) {
        newNode = new Node(current1.data);
        current1 = current1.next;
      } else {
        newNode = new Node(current2.data);
        current2 = current2.next;
      }
      if (result == null) {
        temp = newNode;
        result = temp;
      }
      else {
        temp.next = newNode;
        temp = temp.next;
      }
    }
    while (current1 != null) {
      temp.next = new Node(current1.data);
      temp = temp.next;
      current1 = current1.next;
    }
    while (current2 != null) {
      temp.next = new Node(current2.data);
      temp = temp.next;
      current2 = current2.next;
    }
    return result;
  }
  void print() {
    Node current = result;
    while(current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
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