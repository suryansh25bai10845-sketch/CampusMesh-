import java.util.*;

class Node {
    String name;
    boolean online = true;
    ArrayList<Node> connections = new ArrayList<>();
    ArrayList<String> messages = new ArrayList<>();

    Node(String name) {
        this.name = name;
    }

    void connect(Node n) {
        connections.add(n);
        n.connections.add(this);
    }
}

public class Main {

    // Finds the route between two nodes using BFS
    static ArrayList<Node> findRoute(Node start, Node end) {

        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> previous = new HashMap<>();

        q.add(start);
        previous.put(start, null);

        while (!q.isEmpty()) {

            Node current = q.remove();

            if (current == end)
                break;

            for (Node n : current.connections) {

                if (!previous.containsKey(n) && n.online) {
                    previous.put(n, current);
                    q.add(n);
                }
            }
        }

        ArrayList<Node> route = new ArrayList<>();

        if (!previous.containsKey(end))
            return route;

        Node current = end;

        while (current != null) {
            route.add(current);
            current = previous.get(current);
        }

        Collections.reverse(route);

        return route;
    }

    // Sends a message from one node to another
    static void sendMessage(Node from, Node to, String message) {

        if (!to.online) {
            to.messages.add(message);
            System.out.println("Node " + to.name + " is offline.");
            System.out.println("Message saved.");
            return;
        }

        ArrayList<Node> route = findRoute(from, to);

        if (route.size() == 0) {
            System.out.println("No route found.");
            return;
        }

        System.out.print("Route: ");

        for (Node n : route) {
            System.out.print(n.name + " ");
        }

        System.out.println();
        System.out.println("Message: " + message);
        System.out.println("Message delivered.");
    }

    public static void main(String[] args) {

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");

        // Connecting the nodes
        A.connect(B);
        B.connect(C);
        C.connect(D);

        System.out.println("===== CampusMesh =====");

        // Find route
        System.out.println("\nFinding route from A to D:");

        ArrayList<Node> route = findRoute(A, D);

        for (Node n : route) {
            System.out.print(n.name + " ");
        }

        // Send a message
        System.out.println("\n\nSending message:");
        sendMessage(A, D, "Hello D");

        // Test offline node
        System.out.println("\nD is now offline.");
        D.online = false;

        sendMessage(A, D, "Emergency message");

        // Bring D online
        System.out.println("\nD is online again.");
        D.online = true;

        if (!D.messages.isEmpty()) {
            System.out.println("Saved message delivered: "
                    + D.messages.remove(0));
        }
    }
}
