class ProductOfNumbers {

  private List<Integer> list;

  public ProductOfNumbers() {
    list = new LinkedList<>();
  }
    
  public void add(int num) {
    if (num == 0) {
      list.clear();
      return;
    }
    int size = list.size();
    int prev = size > 0 ? list.get(size - 1) : 1;
    list.add(num * prev); 
  }
    
  public int getProduct(int k) {
    int n = list.size() - 1;
    int last = list.get(n);
    if (n + 1 == k) return list.get(n);
    if (n + 1 < k) return 0;
    int val = list.get(n - k);
    return last / val;
  }
}