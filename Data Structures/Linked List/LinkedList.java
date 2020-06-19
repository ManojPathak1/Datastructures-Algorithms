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
}

class Node {
  int data;
  Node next;
  Node(int data) {
    this.data = data;
  }
}