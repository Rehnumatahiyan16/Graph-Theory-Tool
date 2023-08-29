import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuSCC {
    public static void kosarajuSCC(ArrayList<Edge>[] graph) {

        System.out.println("We use kosaraju algorithm for  Strongly connected components ");
        int numVertices = graph.length;

        // Step 1: Perform DFS on the original graph and push vertices onto a stack
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfsForStack(graph, i, visited, stack);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<Edge>[] transposeGraph = transposeGraph(graph);

        // Step 3: Perform DFS on the transposed graph to find SCCs
        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                System.out.print("Strongly Connected Component: ");
                dfsForSCC(transposeGraph, v, visited);
                System.out.println();
            }
        }
    }
    private static ArrayList<Edge>[] transposeGraph(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        ArrayList<Edge>[] transpose = new ArrayList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            transpose[i] = new ArrayList<>();
        }

        for (int u = 0; u < numVertices; u++) {
            for (Edge edge : graph[u]) {
                int v = edge.dst;
                int weight = edge.weight;
                transpose[v].add(new Edge(v, u, weight));
            }
        }

        return transpose;
    }
    private static void dfsForStack(ArrayList<Edge>[] graph, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (Edge edge : graph[v]) {
            int u = edge.dst;
            if (!visited[u]) {
                dfsForStack(graph, u, visited, stack);
            }
        }
        stack.push(v);
    }
    private static void dfsForSCC(ArrayList<Edge>[] graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Edge edge : graph[v]) {
            int u = edge.dst;
            if (!visited[u]) {
                dfsForSCC(graph, u, visited);
            }
        }
    }
}
