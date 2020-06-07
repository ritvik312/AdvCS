import java.util.*;
public class Graph
{
    private HashMap<Character, Node> nodeLookup = new HashMap<>();

    private Node getNode(char id)
    {
        if(nodeLookup.containsKey(id))
            return nodeLookup.get(id);
        return null;
    }

    public void addEdge(char source, char destination)
    {
        if(getNode(source) == null)
            nodeLookup.put(source, new Node(source));
        if(getNode(destination) == null)
            nodeLookup.put(destination, new Node(destination));

        Node a = getNode(source);
        Node b = getNode(destination);

        a.adjacent.add(b);
        b.adjacent.add(a);
    }

    public boolean hasPath(char source, char destination)
    {
        Node a = getNode(source);
        Node b = getNode(destination);

        if(a == null || b == null)
            return false;

        return hasPathBFS(a, b);
    }

    private boolean hasPathBFS(Node source, Node destination)
    {
        ArrayDeque<Node> toCheck = new ArrayDeque<>();
        toCheck.add(source);
        while(!toCheck.isEmpty())
        {
            Node current = toCheck.pollFirst();

            current.isVisited = true;

            if(current.id == destination.id)
                return true;

            for(Node node : current.adjacent)
            {
                if(!node.isVisited)
                    toCheck.addLast(node);
            }
        }
        return false;


    }

    private boolean hasPathDFS(Node source, Node destination)
    {
        if(source.isVisited)
            return false;
        source.isVisited = true;

        if(source.id == destination.id)
            return true;

        for(Node node : source.adjacent)
        {
            if(hasPathDFS(node, destination))
                return true;
        }
        return false;

    }

    static class Node
    {
        char id;
        LinkedList<Node> adjacent = new LinkedList<>();
        boolean isVisited = false;
        private Node(char id)
        {
            this.id = id;
        }
    }
}
