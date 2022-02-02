class LinkedList {
  char value;
  LinkedList next;
  public LinkedList(char value) {
    this.value = value;
  }
}

class Solution {
  public String predictPartyVictory(String senate) {
    char ch[] = senate.toCharArray();
    LinkedList head = createLinkedList(ch);
    LinkedList curr = head;
    int countR = getPartMembersCount(ch);
    int countD = ch.length - countR;
    while (countR != 0 && countD != 0) {
      char c = curr.value;
      char n = curr.next.value;
      if (c != n) {
        if (n == 'D') countD--;
        else countR--;
        curr.next = curr.next.next;
      }
      curr = curr.next;
    }
    if (countR == 0) return getPartyName('D');
    else return getPartyName('R');
  }

  private LinkedList createLinkedList(char ch[]) {
    LinkedList head = new LinkedList(ch[0]);
    LinkedList curr = head;
    for (int i = 1; i < ch.length; i++) {
      curr.next = new LinkedList(ch[i]);
      curr = curr.next;
    }
    curr.next = head;
    return head;
  }

  private int getPartyMembersCount(char ch[]) {
    int count = 0;
    for (char c: ch) if (ch == 'R') count++;
    return count;
  }

  private String getPartyName(char ch) {
    if (ch == 'D') return "Dire";
    else return "River";
  }
}