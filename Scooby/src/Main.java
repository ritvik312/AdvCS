import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(new File("input.txt"));
        int cases = in.nextInt();
        in.nextLine();

        for (int c = 0; c < cases; c++) {
            String[] edges = in.nextLine().split(" ");
            String question = in.nextLine();
            Graph graph = new Graph();

            for(String edge : edges)
                graph.addEdge(edge.charAt(0), edge.charAt(1));
            System.out.println(graph.hasPath(question.charAt(0), question.charAt(1)) ? "yes" : "no");
        }

    }
}
