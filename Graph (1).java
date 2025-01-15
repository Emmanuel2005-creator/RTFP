import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        adjacencyList.get(from).add(new Edge(to, weight));
    }

    public int validatePath(List<String> path) {
        int totalWeight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String from = path.get(i);
            String to = path.get(i + 1);
            boolean found = false;

            for (Edge edge : adjacencyList.getOrDefault(from, new ArrayList<>())) {
                if (edge.destination.equals(to)) {
                    totalWeight += edge.weight;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return 0; // Invalid path
            }
        }
        return totalWeight; // Valid path
    }

    private static class Edge {
        String destination;
        int weight;

        public Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
