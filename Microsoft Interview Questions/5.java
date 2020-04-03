// Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
// https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/

public class Main {
  public static void main(String args[]) {
    LinkedList ll = new LinkedList();
    ll.head = new Node(1);
    ll.head.next = new Node(3);
    ll.head.next.next = new Node(4);
    ll.head.next.next.next = new Node(5);
    ll.head.next.next.next.next = new Node(4);
    ll.head.next.next.next.next.next = new Node(3);
    ll.head.next.next.next.next.next.next = new Node(1);
    ll.print();
    ll.deleteElement(ll.head.next.next.next); // 5
    ll.print();
  }
}

class LinkedList {
  Node head;
  public void deleteElement(Node e) {
    Node temp = e.next;
    e.data = temp.data;
    e.next = temp.next;
    temp = null;
  }
  public void print() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data +" ");
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
  }
}