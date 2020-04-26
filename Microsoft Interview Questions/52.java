//  
//  

public class Main {
  public static void main(String args[]) {
    String str = "eedaaad";
    char ch[] = str.toCharArray();
    Occurence o = new Occurence(ch);
    System.out.println(o.newString());
  }
}

class Occurence {
  private char ch[];
  Occurence(char ch[]) {
    this.ch = ch;
  }
  public String newString() {
    String str = "";
    char temp = '\0';
    int count = 0;
    for (char c : ch) {
      if (c != temp) {
        temp = c;
        count = 1;
      } else {
        count++;
      }
      if (count < 3) {
        str += c;
      }
    }
    return str;
  }
}