import java.util.*;

public class Tree
{
    int[] leafCounts;
    int currentInd;
    HashMap<Integer, Integer> piles;

    public Tree(int[] leafCounts)
    {
        this.leafCounts = leafCounts;
        currentInd = 0;
        piles = new HashMap<>();
    }

    public void fill()
    {
        Node root = new Node(0, leafCounts[0]);
        visit(root);
    }

    public void visit(Node parent)
    {
        int init = 0;
        if(piles.get(parent.pos) != null)
            init = piles.get(parent.pos);
        piles.put(parent.pos, init + leafCounts[currentInd]);
        leftNode(parent);
        rightNode(parent);
    }

    public void leftNode(Node parent)
    {
        currentInd++;
        if(leafCounts[currentInd] == -1)
            return;
        parent.left = new Node(parent.pos-1, leafCounts[currentInd]);
        visit(parent.left);
    }

    public void rightNode(Node parent)
    {
        currentInd++;
        if(leafCounts[currentInd] == -1)
            return;
        parent.right = new Node(parent.pos+1, leafCounts[currentInd]);
        visit(parent.right);
    }

    public String pilesOutput()
    {
        int lowest = 0;
        for(Integer index : piles.keySet())
        {
            if(index < lowest)
                lowest = index;
        }

        String output = "";
        int i = lowest;
        while(piles.containsKey(i))
        {
            output += piles.get(i) + " ";
            i++;
        }

        return output;
    }

    public class Node
    {
        Node left, right;
        int leaves;
        int pos;

        public Node(int pos, int leaves)
        {
            this.pos = pos;
            this.leaves = leaves;
        }
    }
}
