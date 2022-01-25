class CircularList {
  int val;
  CircularList prev, next;
  CircularList(int val) {
    this.val = val;
    prev = null;
    next = null;
  }
}

class MyCircularDeque {

  private int MAX_SIZE;
  private int size;
  private CircularList front, rear;

  public MyCircularDeque(int k) {
    MAX_SIZE = k;
    front = null;
    rear = null;
    size = 0;
  }
    
  public boolean insertFront(int value) {
    if (size < MAX_SIZE) {
      CircularList newNode = new CircularList(value);
      if (size == 0) {
        front = newNode;
        rear = newNode;
      } else {
        front.prev = newNode;
        newNode.next = front;
        front = front.prev;
      }
      size++;
      return true;
    }
    return false;
  }
    
  public boolean insertLast(int value) {
    if (size < MAX_SIZE) {
      CircularList newNode = new CircularList(value);
      if (size == 0) {
        front = newNode;
        rear = newNode;
      } else {
        rear.next = newNode;
        newNode.prev = rear;
        rear = rear.next;
      }
      size++;
      return true;
    }
    return false;
  }
    
  public boolean deleteFront() {
    if (size == 0) return false;
    front = front.next;
    size--;
    return true;      
  }
    
  public boolean deleteLast() {
    if (size == 0) return false;
    rear = rear.prev;
    size--;
    return true;      
  }
    
  public int getFront() {
    if (size == 0) return -1;
    return front.val;      
  }
    
  public int getRear() {
    if (size == 0) return -1;
    return rear.val;      
  }
    
  public boolean isEmpty() {
    return size == 0;      
  }
    
  public boolean isFull() {
    return size == MAX_SIZE;      
  }
}