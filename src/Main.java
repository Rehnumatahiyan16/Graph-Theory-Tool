import java.util.*;

public class
Main {


    public static void main(String[] args) {
        System.out.println("Create Your Graph : ");
        System.out.println("Enter number of vertices: ");
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[v];
        GraphCreator.createGraph(graph);
        int choice;
        boolean isDirected = false; // Define isDirected here

        while (true) {
            Menu.displayOptions();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    PrintGraphList.printGraphList(graph);
                    break;
                case 2:
                    PrintGraphMatrix.printGraphMatrix(graph);
                    break;
                case 3:
                    BFS.bfsDisconnectedGraph(graph);
                    break;
                case 4:
                    DFS.dfsDisconnectedGraph(graph);
                    break;
                case 5:
                    System.out.println("Choose shortest path option: ");
                    System.out.println("1. Single Source Shortest Path (Dijkstra's or Bellman-Ford)");
                    System.out.println("2. All Source Shortest Path (Floyd-Warshall)");
                    int spOption = sc.nextInt();
                    switch (spOption) {
                        case 1:
                            System.out.println("Choose the algorithm for single-source shortest path: ");
                            System.out.println("1. Dijkstra's Algorithm");
                            System.out.println("2. Bellman-Ford Algorithm");
                            int spChoice = sc.nextInt();
                            switch (spChoice) {
                                case 1:
                                    if (GraphChecker.hasNegativeEdge(graph)) {
                                        System.out.println("Dijkstra's will not work (there is a negative edge).");
                                    } else {
                                        System.out.println("Enter source vertex for Dijkstra's Algorithm: ");
                                        int sourceDijkstra = sc.nextInt();
                                        Dijkstra.dijkstra(graph, sourceDijkstra);
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter source vertex for Bellman-Ford Algorithm: ");
                                    int sourceBellman = sc.nextInt();
                                    boolean hasNegativeCycle = BellmanFord.bellmanFord(graph, sourceBellman);

                                    if (hasNegativeCycle) {
                                        System.out.println("The graph has a negative cycle. Bellman-Ford cannot be used.");
                                    } else {
                                        System.out.println("Shortest distances using Bellman-Ford Algorithm:");
                                        BellmanFord.printShortestPathBellmanFord(graph, sourceBellman);
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid choice for single-source shortest path algorithm.");
                            }
                    break;
                        case 2:
                            FloydWarshall.floydWarshall(graph);
                            break;
                        default:
                            System.out.println("Invalid choice for shortest path option.");
                    }
                    break;
                case 6:
                    PrimMST.primMST(graph);
                    break;
                case 7:
                    KosarajuSCC.kosarajuSCC(graph);
                    break;
                case 8:
                    TarjanArticulation.tarjanArticulationPointsAndBridges(graph);
                    break;
                case 9:
                    System.out.println("Enter source vertex for Ford-Fulkerson Algorithm: ");
                    int source = sc.nextInt();
                    System.out.println("Enter sink vertex: ");
                    int sink = sc.nextInt();
                    int maxFlow = FordFulkerson.fordFulkerson(graph, source, sink);
                    System.out.println("Maximum Flow: " + maxFlow);
                    break;

                case 10:
                    if (CycleDetection.hasCycle(graph)) {
                        System.out.println("The graph has cycles. Topological sorting is not possible.");
                    } else {
                        TopologicalSort.topologicalSort(graph);
                    }
                    break;
                case 11:
                    DegreeCentrality.calculateDegreeCentrality(graph);
                    break;

                case 12:
                    System.out.println("Is the graph directed? (Enter 'yes' or 'no')");
                    String directedInput = sc.next();
                    isDirected = directedInput.equalsIgnoreCase("yes");

                    boolean hasCycle = isDirected ?
                            DirectedCycleDetection.hasCycleDirected(graph) :
                            UndirectedCycleDetection.hasCycleUndirected(graph);


                    if (hasCycle) {
                        List<Integer> cycle = UndirectedCycleDetection.getCycle();
                        System.out.print("Cycle detected: ");
                        for (int i = 0; i < cycle.size(); i++) {
                            System.out.print(cycle.get(i));
                            if (i < cycle.size() - 1) {
                                System.out.print(" -> ");
                            }
                        }
                        System.out.print(" -> " + cycle.get(0)); // Add the first vertex to complete the cycle
                        System.out.println();
                    } else {
                        System.out.println("The graph does not have cycles.");
                    }
                    break;


                // Other cases...
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
