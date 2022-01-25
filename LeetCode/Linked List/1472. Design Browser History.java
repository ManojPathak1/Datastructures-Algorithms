class DLL {
  String value;
  DLL prev, next;
  public DLL(String value) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }
  public DLL(String value, DLL prev) {
    this.value = value;
    this.prev = prev;
    this.next = null;
  }
  public DLL(String value, DLL prev, DLL next) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}

class BrowserHistory {

  private DLL curr;

  public BrowserHistory(String homepage) {
    curr = new DLL(homepage);
  }
    
  public void visit(String url) {
    DLL newNode = new DLL(url, curr);
    curr.next = newNode;
    curr = newNode;
  }
    
  public String back(int steps) {
    while (steps-- > 0 && curr.prev != null) curr = curr.prev;
    return curr.value;
  }
    
  public String forward(int steps) {
    while (steps-- > 0 && curr.next != null) curr = curr.next;
    return curr.value;
  }
}