import java.io.*;
import java.util.*;

class Graph {
  private int V;
  private ArrayList<Integer> adj[];

  Graph(int V) {
    this.V = V;
    adj = new ArrayList[V];
    for (int i = 0; i < V; i++) adj[i] = new ArrayList<>(); 
  }

  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  void BFS(int v) {
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<>();
    visited[v] = true;
    queue.add(v);
    while (queue.size() != 0) {
      v = queue.poll();
      System.out.print(v + " ");
      ArrayList<Integer> tempList = adj[v];
      for (int i = 0; i < tempList.size(); i++) {
        int e = tempList.get(i);
        if (!visited[e]) {
          queue.add(e);
          visited[e] = true;
        }
      }
    }
  }

  public static void main(String args[]) {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.BFS(2);
  }
}