import java.util.*;

public class Sorter {
    public static void quickSort(List<Result> results, int low, int high) {
        if (low < high) {
            int pi = partition(results, low, high);
            quickSort(results, low, pi - 1);
            quickSort(results, pi + 1, high);
        }
    }

    private static int partition(List<Result> results, int low, int high) {
        Result pivot = results.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (results.get(j).compareTo(pivot) < 0) {
                i++;
                Collections.swap(results, i, j);
            }
        }
        Collections.swap(results, i + 1, high);
        return i + 1;
    }

    public static class Result implements Comparable<Result> {
        String name;
        int weight;
        String validity;

        public Result(String name, int weight, String validity) {
            this.name = name;
            this.weight = weight;
            this.validity = validity;
        }

        @Override
        public int compareTo(Result other) {
            if (this.weight != other.weight) {
                return Integer.compare(this.weight, other.weight);
            }
            return this.name.compareTo(other.name);
        }
    }
}
