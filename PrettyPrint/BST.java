public class BST
{
    Node root;
    String inorderStr;
    String prettyStr;

    public BST()
    {
        inorderStr = "";
        prettyStr = "";
    }

    public void insertValue(int k)
    {
        if(root == null)
        {
            root = new Node(k, 0);
            return;
        }

        Node parent = findParent(k, root);
        if(k <= parent.value)
            parent.left = new Node(k, parent.depth+1);
        else
            parent.right = new Node(k, parent.depth+1);
    }

    public Node findParent(double k, Node v)
    {
        if(k <= v.value && v.left == null)
            return v;
        else if(k > v.value && v.right == null)
            return v;
        else
        {
            if(k <= v.value)
                return findParent(k, v.left);
            else
                return findParent(k, v.right);
        }
    }

    public void traverse() //inorder
    {
        visit(root);
        inorderStr = inorderStr.substring(0, inorderStr.length()-2);
    }

    public void visit(Node parent)
    {
        if(parent == null)
            return;

        visit(parent.left);

        inorderStr += parent.value + ", ";

        String nextLayer = "";
        for (int i = 0; i < parent.depth*4; i++)
        {
            nextLayer += " ";
        }
        nextLayer += parent.value + "\n";
        prettyStr = nextLayer + prettyStr;

        visit(parent.right);
    }

    class Node
    {
        int value;
        int depth;
        Node left, right;

        public Node(int value, int depth)
        {
            this.value = value;
            this.depth = depth;
        }
    }
}
