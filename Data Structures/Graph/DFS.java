import java.io.*;
import java.util.*;

class Graph {
  // No of vertices.
  private int V;
  // Each vertice vertices
  private ArrayList<Integer> adj[];

  Graph(int V) {
    this.V = V;
    adj = new ArrayList[V];
    for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
  }
  
  // Add edge to the vertice.
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  void DFS(int v) {
    boolean visited[] = new boolean[V];
    DFSUtil(v, visited);
  }

  void DFSUtil(int v, boolean visited[]) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int e : adj[v]) {
      if (!visited[e]) DFSUtil(e, visited);
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
    g.DFS(2);
  }
}