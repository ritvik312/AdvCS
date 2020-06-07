public class LinkedList
{
    Node head;
    int count;

    public LinkedList()
    {
        head = null;
    }

    public void add(Object data)
    {
        Node newNode = new Node(data);
        newNode.setNextPtr(head);
        head = newNode;
        count++;
    }

    public void remove(Object data)
    {
        Node current = head;
        while(current.getNextPtr() != null)
        {
            //bad code: should compare more than just their toStrings. Works in this context, though.
            if(current.getNextPtr().get().toString().equals(data.toString()))
            {
                current.setNextPtr(current.getNextPtr().getNextPtr());
                count--;
                break;
            }
            else
            {
                current = current.getNextPtr();
            }
        }
    }

    public Object get(int index)
    {
        if(index < 0 || index >= count)
            return null;

        Node current = head;

        for(int i = 0; i < index; i++)
        {
            current = current.next;
        }

        return current.get();
    }

    public Node getNode(int index)
    {
        if(index < 0 || index >= count)
            return null;

        Node current = head;

        for(int i = 0; i < index; i++)
        {
            current = current.next;
        }

        return current;
    }

    public boolean contains(Object data)
    {
        Node current = head;
        while(current != null)
        {
            //bad code: should compare more than just their toStrings. Works in this context, though.
            if(current.get().toString().equals(data.toString()))
            {
                return true;
            }
            else
            {
                current = current.getNextPtr();
            }
        }
        return false;
    }

    public int size()
    {
        return count;
    }

    public String toString()
    {
        Node current = head;
        String output = "[";
        while(current.getNextPtr() != null)
        {
            output += current + ", ";
            current = current.getNextPtr();
        }
        output += current + "]";

        return output;
    }

}
