import java.io.*;
import java.util.*;

public class FileProcessor {
    public static Graph readGalaxyMap(String filename) throws IOException {
        Graph graph = new Graph();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            String vertex = parts[0];
            graph.addVertex(vertex);

            for (int i = 1; i < parts.length; i++) {
                String[] edgeParts = parts[i].split(",");
                graph.addEdge(vertex, edgeParts[0], Integer.parseInt(edgeParts[1]));
            }
        }
        br.close();
        return graph;
    }

    public static List<Pilot> readPilotRoutes(String filename) throws IOException {
        List<Pilot> pilots = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            String name = parts[0];
            List<String> route = Arrays.asList(parts).subList(1, parts.length);
            pilots.add(new Pilot(name, route));
        }
        br.close();
        return pilots;
    }

    public static class Pilot {
        String name;
        List<String> route;

        public Pilot(String name, List<String> route) {
            this.name = name;
            this.route = route;
        }
    }
}
