import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    public void removeLocation(String location) {

        adjList.remove(location);

        for (List<String> connections : adjList.values()) {
            connections.remove(location);
        }
    }

    public void addRoad(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            System.out.println("Error: One or both locations not found.");
            return;
        }

        // Add road (undirected)
        if (!adjList.get(from).contains(to)) {
            adjList.get(from).add(to);
        }
        if (!adjList.get(to).contains(from)) {
            adjList.get(to).add(from);
        }
    }

    public void removeRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).remove(to);
            adjList.get(to).remove(from);
        } else {
            System.out.println("Error: One or both locations not found.");
        }
    }

    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No locations or connections to display.");
            return;
        }
        for (String loc : adjList.keySet()) {
            System.out.println(loc + " -> " + adjList.get(loc));
        }
    }

    public void findPath(String start, String end) {
        if (!adjList.containsKey(start) || !adjList.containsKey(end)) {
            System.out.println("Error: One or both locations do not exist.");
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(start);
        visited.add(start);
        parentMap.put(start, null);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                found = true;
                break;
            }

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (found) {
            // Reconstruct path
            List<String> path = new ArrayList<>();
            String current = end;
            while (current != null) {
                path.add(current);
                current = parentMap.get(current);
            }
            Collections.reverse(path);
            System.out.println("Path found: " + path);
        } else {
            System.out.println("No path found between " + start + " and " + end);
        }
    }
}