class Solution {
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode nodeA = list1, nodeB = list1, list2Last = list2;
    while (--a > 0) nodeA = nodeA.next;
    while (b-- >= 0) nodeB = nodeB.next;
    while (list2Last.next != null) list2Last = list2Last.next;
    nodeA.next = list2;
    list2Last.next = nodeB;
    return list1;
  }
}