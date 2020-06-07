import java.util.*;
import java.io.*;
public class NodeTester
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(new File("input.txt"));

        Node[] nodes = new Node[5];

        for(int i = 0; i < nodes.length; i++)
            nodes[i] = new Node(new Actor(sc.nextLine()));

        Node head = nodes[0];
        for(int i = 1; i < nodes.length; i++)
        {
            nodes[i].setNextPtr(head);
            head = nodes[i];
        }

        Node current = head;
        while(current != null)
        {
            System.out.println(current);
            current = current.next;
        }

        System.out.println("\n" + ((Actor)head.get()).getName());
    }
}
