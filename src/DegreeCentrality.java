import java.util.ArrayList;

public class DegreeCentrality {
    public static void calculateDegreeCentrality(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;

        for (int i = 0; i < numVertices; i++) {
            int degree = graph[i].size();
            System.out.println("Degree Centrality for Node " + i + ": " + degree);
        }
    }
}
