import java.util.ArrayList;

public class PrintGraphList {
    public static void printGraphList(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Adjacency list for vertex " + i + ": ");
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.src + " -> " + edge.dst + ") ");
            }
            System.out.println();
        }
    }
}
