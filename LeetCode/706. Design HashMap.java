class Pair {
  int key, value;
  Pair(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class MyHashMap {

  private final int BUCKET_SIZE = 100;
  private ArrayList<ArrayList<Pair>> list;

  public MyHashMap() {
    list = new ArrayList<>();
    for (int i = 0; i < BUCKET_SIZE; i++) list.add(null);
  }
  
  public void put(int key, int value) {
    int index = key % BUCKET_SIZE;
    ArrayList<Pair> childList = list.get(index);
    if (childList == null) {
      ArrayList<Pair> newChildList = new ArrayList<>();
      newChildList.add(new Pair(key, value));
      list.set(index, newChildList);
    } else {
      boolean contains = false;
      for (int i = 0; i < childList.size(); i++) {
        if (childList.get(i).key == key) {
          contains = true;
          childList.get(i).value = value;
          break;
        }
      }
      if (!contains) childList.add(new Pair(key, value));
    }
  }
  
  public int get(int key) {
    int index = key % BUCKET_SIZE;
    ArrayList<Pair> childList = list.get(index);
    if (childList == null) return -1;
    else {
      for (Pair p: childList) {
        if (p.key == key) return p.value;
      }
    }
    return -1;
  }
  
  public void remove(int key) {
    int index = key % BUCKET_SIZE;
    ArrayList<Pair> childList = list.get(index);
    if (childList != null) {
      for (int i = 0; i < childList.size(); i++) {
        if (childList.get(i).key == key) {
          childList.remove(i);
          break;
        }
      }
    }
  }
}p