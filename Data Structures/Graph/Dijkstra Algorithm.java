import java.io.*;
import java.util.*;

class Dijkstra {
  private int V;
  private ArrayList<Edge> adj[];
  private int distances[];

  Dijkstra(int V) {
    this.V = V;
    adj = new ArrayList[V];
    distances = new int[V];
    Arrays.fill(distances, Integer.MAX_VALUE);
    for (int i = 0; i < V; i++) adj[i] = new ArrayList<>(); 
  }

  public void addEdge(int source, int destination, int weight) {
    adj[source - 1].add(new Edge(source - 1, destination - 1, weight));
  }

  public int[] shortestPaths(int s) {
    s = s - 1;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(s);
    boolean visited[] = new boolean[V];
    distances[s] = 0;
    while (!queue.isEmpty()) {
      int p = queue.poll();
      visited[p] = true;
      for (Edge e : adj[p]) {
        distances[e.destination] = Math.min(e.weight + distances[p], distances[e.destination]);
      }
      int minimumVertice = getMinimumVertice(visited);
      if (minimumVertice != -1) queue.add(minimumVertice);
    }
    return distances;
  }

  public int getMinimumVertice(boolean visited[]) {
    int minimumVertice = -1;
    int minimumValue = Integer.MAX_VALUE;
    for (int i = 0; i < distances.length; i++) {
      if (!visited[i] && minimumValue > distances[i]) {
        minimumValue = distances[i];
        minimumVertice = i;
      }
    }
    return minimumVertice;
  }

  public static void main(String args[]) {
    Dijkstra d = new Dijkstra(6);
    d.addEdge(1, 2, 2);
    d.addEdge(2, 4, 7);
    d.addEdge(4, 6, 1);
    d.addEdge(5, 6, 5);
    d.addEdge(3, 5, 3);
    d.addEdge(1, 3, 4);
    d.addEdge(2, 3, 1);
    d.addEdge(5, 4, 2);
    int distances[] = d.shortestPaths(1);
    for (int i = 0; i < distances.length; i++) System.out.print(distances[i] + " ");
  }
}

class Edge {
  int source, destination, weight;
  Edge(int source, int destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }
}