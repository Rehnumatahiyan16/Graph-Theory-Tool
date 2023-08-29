import java.util.ArrayList;

public class GraphChecker {
    public static boolean hasNegativeEdge(ArrayList<Edge>[] graph) {
        for (ArrayList<Edge> edges : graph) {
            for (Edge edge : edges) {
                if (edge.weight < 0) {
                    return true; // Return true if any edge has a negative weight
                }
            }
        }
        return false; // Return false if no edge has a negative weight
    }
}
