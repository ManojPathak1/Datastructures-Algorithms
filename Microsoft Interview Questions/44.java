//  Find the leftmost right cousin of a given binary tree

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Tree t = new Tree();
    t.root = new Node(1);
    t.root.left = new Node(2);
    t.root.right = new Node(3);
    t.root.left.left = new Node(4);
    t.root.left.right = new Node(5);
    t.root.right.left = new Node(6);
    t.root.right.right = new Node(7);
    System.out.println(t.getLeftCousin(4).data);
    System.out.println(t.getLeftCousin(5).data);
    System.out.println(t.getLeftCousin(6));
    System.out.println(t.getLeftCousin(2));
  }
}

class Tree {
  Node root;
  public Node getLeftCousin(int e) {
    boolean flag = false;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while(queue.size() != 0) {
      Node elem = queue.poll();
      boolean isLeftExist = elem.left != null;
      boolean isRightExist = elem.left != null;
      if (flag) {
        if (isLeftExist) return elem.left;
        if (isRightExist) return elem.right;
        return null;
      }
      flag = isLeftExist && elem.left.data == e || isRightExist && elem.right.data == e;
      if (flag) continue;
      if (isLeftExist) queue.add(elem.left);
      if (isRightExist) queue.add(elem.right);
    }
    return null;
  }
}

class Node {
  int data;
  Node left, right;
  Node(int data) {
    this.data = data;
    left = right = null;
  }
}