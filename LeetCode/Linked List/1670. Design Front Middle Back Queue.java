class FrontMiddleBackQueue {

  Deque<Integer> deque1, deque2;

  public FrontMiddleBackQueue() {
    deque1 = new LinkedList<>();
    deque2 = new LinkedList<>();
  }
    
  public void pushFront(int val) {
    if (deque1.size() - deque2.size() == 1) {
      deque2.addFirst(deque1.removeLast());
    }
    deque1.addFirst(val);
  }
    
  public void pushMiddle(int val) {
    if (deque1.size() - deque2.size() == 1) {
      deque2.addFirst(deque1.removeLast());
    }
    deque1.addLast(val);
  }
    
  public void pushBack(int val) {
    if (deque1.size() == 0) {
      deque1.addFirst(val);
      return;
    }
    if (deque1.size() == deque2.size()) {
      deque1.addLast(deque2.removeFirst());
    }
    deque2.addLast(val);
  }
    
  public int popFront() {
    if (deque1.size() == 0) return -1;
    if (deque1.size() == deque2.size()) {
      deque1.addLast(deque2.removeFirst());
    }
    return deque1.removeFirst();
  }
    
  public int popMiddle() {
    if (deque1.size() == 0) return -1;
    int val = deque1.removeLast();
    if (deque1.size() != deque2.size()) {
      deque1.addLast(deque2.removeFirst());
    }
    return val;
  }
    
  public int popBack() {
    if (deque2.size() == 0 && deque1.size() == 0) return -1;
    if (deque1.size() - deque2.size() == 1) {
      deque2.addFirst(deque1.removeLast());
    }
    return deque2.removeLast();
  }
}