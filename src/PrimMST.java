import java.util.ArrayList;
import java.util.Arrays;

public class PrimMST {
    public static void primMST(ArrayList<Edge>[] graph) {
        System.out.println("Finding Minimum Spanning Tree using Prims Algorithm");
        int numVertices = graph.length;
        boolean[] inMST = new boolean[numVertices];
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0; // Start with the first vertex
        try {
            for (int i = 0; i < numVertices - 1; i++) {
                int u = minKey(key, inMST);
                inMST[u] = true;

                for (Edge edge : graph[u]) {
                    int v = edge.dst;
                    int weight = edge.weight;

                    if (!inMST[v] && weight < key[v]) {
                        parent[v] = u;
                        key[v] = weight;
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex)
        {

        }

        System.out.println("Minimum Spanning Tree using Prim's Algorithm:");
        for (int i = 1; i < numVertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + key[i]);
        }
    }
    private static int minKey(int[] key, boolean[] inMST) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}
