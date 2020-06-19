//  Sorted insert for circular linked list
//  https://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/

public class Main {
  public static void main(String args[]) {
    CircularLinkedList cll = new CircularLinkedList();
    cll.insert(new Node(1));
    cll.insert(new Node(2));
    cll.insert(new Node(3));
    cll.print();
  }
}

class CircularLinkedList {
  Node head;
  CircularLinkedList() {
    head = null;
  }
  public void insert(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    Node current = head;
    if (current == null) {
      current = newNode;
      return;
    }
    Node startNode = head;
    while(current.next != startNode) {
      int currData = current.data;
      int nextData = current.next.data;
      if (data > currData && data < nextData) {
        Node temp = current.next;
        newNode.next = temp;
        current.next = newNode;
      }
    }
  }
  public void print() {
    Node current = head;
    Node startNode = head;
    while (current.next != startNode) {
      System.out.print(current.data + " ");
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