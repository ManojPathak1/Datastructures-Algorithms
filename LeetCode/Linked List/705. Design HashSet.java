class MyHashSet {

  private final int BUCKET_SIZE = 100;
  private ArrayList<ArrayList<Integer>> list;

  public MyHashSet() {
    list = new ArrayList<>();
    for (int i = 0; i < BUCKET_SIZE; i++) list.add(null);
  }
    
  public void add(int key) {
    int index = key % BUCKET_SIZE;
    ArrayList<Integer> childList = list.get(index);
    if (childList == null) {
      ArrayList<Integer> newChildList = new ArrayList<>();
      newChildList.add(key);
      list.set(index, newChildList);
    } else if (!childList.contains(key)) {
      childList.add(key);
    }
  }
    
  public void remove(int key) {
    int index = key % BUCKET_SIZE;
    ArrayList<Integer> childList = list.get(index);
    if (childList != null) {
      childList.remove(new Integer(key));
    }
  }
  
  public boolean contains(int key) {
    int index = key % BUCKET_SIZE;
    ArrayList<Integer> childList = list.get(index);
    return childList != null && childList.contains(key);
  }
}