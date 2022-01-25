class MyStack {

  private Queue<Integer> queue1, queue2;

  public MyStack() {
    queue1 = new LinkedList<>();
    queue2 = new LinkedList<>();
  }

  private void transferToQueue(Queue<Integer> q1, Queue<Integer> q2) {
    while (q1.size() != 0) q2.add(q1.poll());
  }
    
  public void push(int x) {
    transferToQueue(queue1, queue2);
    queue1.add(x);
    transferToQueue(queue2,queue1);
  }
    
  public int pop() {
    return queue1.poll();
  }
    
  public int top() {
    return queue1.peek();
  }
    
  public boolean empty() {
     return queue1.size() == 0;   
  }
}