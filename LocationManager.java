public class LocationManager {
    private Graph graph;
    private AVLTree tree;

    public LocationManager() {
        graph = new Graph();
        tree = new AVLTree();
    }

    public void addLocation(String name) {
        tree.insert(name);
        graph.addLocation(name);
        System.out.println("Location added: " + name);
    }

    public void removeLocation(String name) {
        graph.removeLocation(name);
        tree.delete(name);
        System.out.println("Location removed: " + name);
    }

    public void addRoad(String from, String to) {
        graph.addRoad(from, to);
        System.out.println("Road added between " + from + " and " + to);
    }

    public void removeRoad(String from, String to) {
        graph.removeRoad(from, to);
        System.out.println("Road removed between " + from + " and " + to);
    }

    public void showConnections() {
        graph.displayConnections();
    }

    public void showAllLocations() {
        System.out.print("Locations (from AVL Tree): ");
        tree.inOrder();
        System.out.println();
    }

    public void findPath(String from, String to) {
        graph.findPath(from, to);
    }
}