package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge {

    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

// Una clase para almacenar un nodo de heap
class Node {

    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Una clase para representar un objeto graph
class Graph {

    // Una lista de listas para representar una lista de adyacencia
    List<List<Edge>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // agrega bordes al grafo dirigido
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}

class Dijkstra {

    private static void getRoute(int[] prev, int i, List<Integer> route) {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }

    // Ejecutar el algoritmo de Dijkstra en un graph dado
    public static ArrayList<Integer> findShortestPaths(Graph graph, int source, int n, int fin) {
        // crea un nodo de fuente min-heap y push con distancia 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        // establece la distancia inicial desde la fuente a `v` como infinito
        ArrayList<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        // la distancia de la fuente a sí misma es cero
        dist.set(source, 0);

        // array booleana para rastrear vértices para los cuales mínimo
        // el costo ya se encuentra
        boolean[] done = new boolean[n];
        done[source] = true;

        // almacena el predecesor de un vértice (en una ruta de impresión)
        int[] prev = new int[n];
        prev[source] = -1;

        // ejecutar hasta que el min-heap esté vacío
        while (!minHeap.isEmpty()) {
            // Elimina y devuelve el mejor vértice
            Node node = minHeap.poll();

            //obtenemos el número de vértice
            int u = node.vertex;

            // hacer para cada vecino `v` de `u`
            for (Edge edge : graph.adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                // Paso de relajación
                if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            // marca el vértice `u` como hecho para que no se vuelva a recoger
            done[u] = true;
        }

        ArrayList<Integer> route = new ArrayList<>();
        getRoute(prev, fin, route);
        return route;
    }
}
