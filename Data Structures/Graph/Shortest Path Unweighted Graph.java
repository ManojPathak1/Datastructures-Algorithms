// Shortest Path Unweighted Graph

import java.io.*;
import java.util.*;

class ShortestPath {
  private int V;
  private ArrayList<Integer> adj[];
  private int EDGE_DISTANCE = 5;

  ShortestPath(int V) {
    this.V = V;
    adj = new ArrayList[V];
    for (int i = 0; i < V; i++) adj[i] = new ArrayList<>(); 
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public int[] shortestPath(int s) {
    LinkedList<Integer> queue = new LinkedList<>();
    int distances[] = new int[V];
    Arrays.fill(distances, -1);
    queue.add(s);
    distances[s] = 0;
    while (!queue.isEmpty()) {
      int p = queue.poll();
      for (int neighbor : adj[p]) {
        if (distances[neighbor] == -1) {
          distances[neighbor] = distances[p] + EDGE_DISTANCE;
          queue.add(neighbor);
        }
      }
    }
    return distances;
  }

  public static void main(String args[]) {
    ShortestPath s = new ShortestPath(6);
    s.addEdge(0, 1);
    s.addEdge(1, 2);
    s.addEdge(1, 3);
    s.addEdge(1, 4);
    s.addEdge(3, 5);
    s.addEdge(0, 5);
    for (int e : s.shortestPath(0)) {
      System.out.print(e + " ");
    }  
  }
}