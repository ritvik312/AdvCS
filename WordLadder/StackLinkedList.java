public class StackLinkedList
{
    LinkedList linkedList;

    public StackLinkedList()
    {
        linkedList = new LinkedList();
    }

    public StackLinkedList(LinkedList presetLinkedList)
    {
        linkedList = presetLinkedList;
    }

    public void push(Object data)
    {
        linkedList.addFront(data);
    }

    public Object peek()
    {
        return linkedList.get(0);
    }

    public Object pop()
    {
        Object output = linkedList.get(0);
        linkedList.remove(output);
        return output;
    }

    public int size()
    {
        return linkedList.size();
    }

    public boolean isEmpty()
    {
        return linkedList.size() == 0;
    }

    public void clear()
    {
        linkedList = new LinkedList();
    }

    public String toString()
    {
        return linkedList.toString();
    }

    public String toStringBackwards()
    {
        String output = "[";
        for(int i = linkedList.size()-1; i > 0; i--)
        {
            output += linkedList.get(i).toString() + ", ";
        }
        output += linkedList.get(0).toString() + "]";

        return output;
    }

    public StackLinkedList deepCopy()
    {
        StackLinkedList output = new StackLinkedList(linkedList.deepCopy());
        return output;
    }
}