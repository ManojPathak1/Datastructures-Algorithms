// Insert Delete GetRandom O(1) Solution
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/

class RandomizedSet {

  private HashSet<Integer> set;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    set = new HashSet<>();
  }
    
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (!set.contains(val)) {
      set.add(val);
      return true;
    }
    return false;
  }
    
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (set.contains(val)) {
      set.remove(val);
      return true;
    }
    return false;
  }
    
  /** Get a random element from the set. */
  public int getRandom() {
    int randomIndex = (int)(Math.random() * set.size());
    int index = 0;
    for (int temp : set) {
      if (index == randomIndex) return temp;
      index++;
    }
    return -1;
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
