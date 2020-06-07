public class QueueLinkedList
{
    LinkedList linkedList;

    QueueLinkedList()
    {
        linkedList = new LinkedList();
    }

    public void enqueue(Object data)
    {
        linkedList.addBack(data);
    }

    public Object peek()
    {
        return linkedList.get(0);
    }

    public Object dequeue()
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

    public String toString()
    {
        return linkedList.toString();
    }
}
