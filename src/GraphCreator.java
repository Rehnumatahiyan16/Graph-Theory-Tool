import java.util.ArrayList;
import java.util.Scanner;

public class GraphCreator {
    public static void createGraph(ArrayList<Edge>[] graph) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Prompt the user to enter the number of edges
        System.out.print("Enter the number of edges: ");
        int numOfEdges = scanner.nextInt();

        // Prompt the user to enter the edges and weights
        System.out.println("Enter the edges in the format 'source destination weight':");
        for (int i = 0; i < numOfEdges; i++) {
            int src = scanner.nextInt();
            int dst = scanner.nextInt();
            int weight = scanner.nextInt();
            graph[src].add(new Edge(src, dst, weight));
        }
    }
}
