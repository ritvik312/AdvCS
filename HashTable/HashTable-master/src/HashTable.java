public class HashTable
{
    Node[] nodes;
    int size;

    //testing purposes
    long collisionCount;

    public HashTable()
    {
        nodes = new Node[101];
        size = 0;
        collisionCount = 0;
    }

    public HashTable(int initCap)
    {
        nodes = new Node[initCap];
        size = 0;
        collisionCount = 0;
    }

    public long getCollisionCount()
    {
        return collisionCount;
    }

    public void resetCollisionCount()
    {
        collisionCount = 0;
    }

    public int getCapacity()
    {
        return nodes.length;
    }

    public Object put(Object key, Object value)
    {
        //return null if hashtable is full?
        if(size == nodes.length)
            return null;

        int currentIndex = Math.abs(key.hashCode()) % nodes.length;

        while(true)
        {
            if(nodes[currentIndex] == null)
            {
                nodes[currentIndex] = new Node(key, value);
                size++;
                return null;
            }
            else if(nodes[currentIndex].removed)
            {
                nodes[currentIndex] = new Node(key, value);
                size++;

                currentIndex++;
                while(true)
                {
                    if(nodes[currentIndex] == null)
                        return null;
                    else if(nodes[currentIndex].key.equals(key))
                    {
                        nodes[currentIndex].removed = true;
                        size--;
                        return null;
                    }
                    else
                    {
                        currentIndex = (currentIndex+1)%nodes.length;
                        collisionCount++;
                    }

                }
            }
            else if(nodes[currentIndex].key.equals(key))
            {
                Object output = nodes[currentIndex].value;
                nodes[currentIndex] = new Node(key, value);
                return output;
            }
            else
            {
                currentIndex = (currentIndex+1)%nodes.length;
                collisionCount++;
            }

        }
    }

    //is the parameter supposed to be the key or a node?
    public Object remove(Object key)
    {
        int currentIndex = Math.abs(key.hashCode()) % nodes.length;

        //if node is null return null
        //if node isn't removed and is correct key, remove, decrement size, and return value
        //if else check next
        while(true)
        {
            if(nodes[currentIndex] == null)
                return null;
            else if(!nodes[currentIndex].removed && nodes[currentIndex].key.equals(key))
            {
                nodes[currentIndex].removed = true;
                size--;
                return nodes[currentIndex].value;
            }
            else
            {
                currentIndex = (currentIndex+1)%nodes.length;
                collisionCount++;
            }


        }
    }

    public Object get(Object key)
    {
        int currentIndex = Math.abs(key.hashCode()) % nodes.length;

        //if node is null return null
        //if node isn't removed and is correct key, return value
        //if else check next
        while(true)
        {
            if(nodes[currentIndex] == null)
                return null;
            else if(!nodes[currentIndex].removed && nodes[currentIndex].key.equals(key))
                return nodes[currentIndex].value;
            else
            {
                currentIndex = (currentIndex+1)%nodes.length;
                collisionCount++;
            }

        }
    }

    public String toString()
    {
        String output = "";

        for(int i = 0; i < nodes.length; i++)
        {
            if(nodes[i] != null)
            {
                output += "" + i + ": ";
                if(nodes[i].removed)
                    output += "<dummy>\n";
                else
                    output += nodes[i] + "\n";
            }

        }

        return output;
    }

    public class Node
    {
        public Object key;
        public Object value;
        public boolean removed;

        public Node()
        {
            key = null;
            value = null;
            removed = false;
        }

        public Node(Object key, Object value)
        {
            this.key = key;
            this.value = value;
            removed = false;
        }

        public String toString()
        {
            return "<"+key+", "+value+">";
        }
    }
}
