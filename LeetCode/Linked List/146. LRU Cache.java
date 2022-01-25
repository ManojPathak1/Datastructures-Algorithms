class Node {
  Node next, prev;
  int key, value;
  Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class DLL {
  Node head, tail;
  DLL() {
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public Node addFront(int key, int val) {
    Node newNode = new Node(key, val);
    Node next = head.next;
    head.next = newNode;
    newNode.prev = head;
    newNode.next = next;
    next.prev = newNode;
    return newNode;
  }

  public void remove(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
  }
}

class LRUCache {

  private int capacity;
  private int size;
  private HashMap<Integer, Node> hm;
  private DLL dll;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = size;
    this.hm = new HashMap();
    this.dll = new DLL();
  }
    
  public int get(int key) {
    if (hm.containsKey(key)) {
      Node node = hm.get(key);
      dll.remove(node);
      int value = node.value;
      Node newNode = dll.addFront(key, value);
      hm.put(key, newNode);
      return value;
    }
    return -1;
  }
    
  public void put(int key, int value) {
    if (hm.containsKey(key)) {
      Node node = hm.get(key);
      dll.remove(node);
      Node newNode = dll.addFront(key, value);
      hm.put(key, newNode);
    } else {
      if (size == capacity) {
        int prevKey = dll.tail.prev.key;
        dll.remove(dll.tail.prev);
        hm.remove(prevKey);
        size--;
      }
      Node newNode = dll.addFront(key, value);
      hm.put(key, newNode);
      size++;
    }
  }
}