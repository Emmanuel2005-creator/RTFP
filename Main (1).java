import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the galaxy map file name: ");
        String mapFile = scanner.nextLine();
        System.out.print("Enter the pilot routes file name: ");
        String routesFile = scanner.nextLine();

        Graph graph = FileProcessor.readGalaxyMap(mapFile);
        List<FileProcessor.Pilot> pilots = FileProcessor.readPilotRoutes(routesFile);

        List<Sorter.Result> results = new ArrayList<>();
        for (FileProcessor.Pilot pilot : pilots) {
            int weight = graph.validatePath(pilot.route);
            String validity = (weight > 0) ? "valid" : "invalid";
            results.add(new Sorter.Result(pilot.name, weight, validity));
        }

        Sorter.quickSort(results, 0, results.size() - 1);

        BufferedWriter writer = new BufferedWriter(new FileWriter("patrols.txt"));
        for (Sorter.Result result : results) {
            writer.write(result.name + "\t" + result.weight + "\t" + result.validity + "\n");
        }
        writer.close();
        System.out.println("Results written to patrols.txt");
    }
}
