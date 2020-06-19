// Function to check if a singly linked list is palindrome
// https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/

// 1. Using Stack

import java.util.*;

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
    System.out.println(ll.isPalindrome());
  }
}

class LinkedList {
  Node head;
  public boolean isPalindrome() {
    Stack<Integer> stack = new Stack<>();
    Node current = head;
    while (current != null) {
      stack.push(current.data);
      current = current.next;
    }
    current = head;
    while (current != null) {
      int e = stack.pop();
      if (e != current.data) return false;
      current = current.next;
    }
    return true;
  }
}

class Node {
  int data;
  Node next;
  Node(int data) {
    this.data = data;
  }
}