package sample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class lab3 {

    private int[] parent;
    private Queue<Integer> queue;
    private int numberOfVertices;
    private boolean[] visited;

    public lab3(int numberOfVertices) {

        this.numberOfVertices = numberOfVertices;
        this.queue = new LinkedList<Integer>();
        parent = new int[numberOfVertices + 1];
        visited = new boolean[numberOfVertices + 1];
    }

    public lab3() {

    }

    public boolean bfs(int source, int goal, int graph[][]) {
        boolean pathFound = false;
        int destination, element;

        for (int vertex = 1; vertex <= numberOfVertices; vertex++) {
            parent[vertex] = -1;
            visited[vertex] = false;
        }

        queue.add(source);
        parent[source] = -1;
        visited[source] = true;

        while (!queue.isEmpty()) {
            element = queue.remove();
            destination = 1;

            while (destination <= numberOfVertices) {
                if (graph[element][destination] > 0 && !visited[destination]) {
                    parent[destination] = element;
                    queue.add(destination);
                    visited[destination] = true;
                }
                destination++;
            }
        }
        if (visited[goal]) {
            pathFound = true;
        }
        return pathFound;
    }

    public int fordFulkerson(int graph[][], int source, int destination) {
        int u, v;
        int maxFlow = 0;
        int pathFlow;

        int[][] residualGraph = new int[numberOfVertices + 1][numberOfVertices + 1];
        for (int sourceVertex = 1; sourceVertex <= numberOfVertices; sourceVertex++) {
            for (int destinationVertex = 1; destinationVertex <= numberOfVertices; destinationVertex++) {
                residualGraph[sourceVertex][destinationVertex] = graph[sourceVertex][destinationVertex];
            }
        }

        while (bfs(source, destination, residualGraph)) {
            pathFlow = Integer.MAX_VALUE;
            for (v = destination; v != source; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }
            for (v = destination; v != source; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public String Labolatorna3(int count, String matrix, int start, int finish) {
        int[][] graph;
        int numberOfNodes;
        int source;
        int sink;
        int maxFlow;

        Scanner scanner = new Scanner(matrix);
        numberOfNodes = count;
        graph = new int[numberOfNodes + 1][numberOfNodes + 1];

        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++) {
            for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++) {
                graph[sourceVertex][destinationVertex] = scanner.nextInt();
            }
        }

        source = start;

        sink = finish;

        lab3 fordFulkerson = new lab3(numberOfNodes);
        maxFlow = fordFulkerson.fordFulkerson(graph, source, sink);

        return "Максимальний потік:-" + maxFlow;
    }

}
