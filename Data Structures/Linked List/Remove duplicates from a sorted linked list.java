//  Remove duplicates from a sorted linked list
//  https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/

class Main {
  public static void main(String args[]) {
    LinkedList ll = new LinkedList();
    //  11->11->11->21->43->43->60
    ll.insert(11);
    ll.insert(11);
    ll.insert(11);
    ll.insert(21);
    ll.insert(43);
    ll.insert(43);
    ll.insert(60);
    ll.removeDuplicates(ll.head);
    ll.print(ll.head);
  }
}

class Node {
  int data;
  Node next;
  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  Node head;
  LinkedList() {
    this.head = null;
  }
  public void insert(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      return;
    }
    Node current = head;
    while (current.next != null) current = current.next;
    current.next = newNode;
  }
  public Node removeDuplicates(Node head) {
    Node current = head;
    while (current != null) {
      int val = current.data;
      Node temp = current;
      while (temp != null && temp.data == val) temp = temp.next;
      current.next = temp;
      current = current.next;
    }
    return head;
  }
  public void print(Node head) {
    Node current = head;
    while(current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
}