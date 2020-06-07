
/**
 * Creates a hash table
 *
 * @author Ritvik Ramakrishnan
 * @version 11/19/19
 */
public class HashTable
{
    private int capacity;
    private Object[] table;
    private int size;
    private int collisions; 
    private long probes; 
    
    public HashTable()
    {
        capacity = 101;
        table = new Object[101];
        size = 0;
        collisions = 0;
        probes = 0;
    }
    
    public HashTable(int initCap)
    {
        capacity = initCap;
        table = new Object[initCap];
        size = 0;
        collisions = 0;
        probes = 0;
    }
    
    public Object put(Object key, Object value)
    {
        if(size<capacity)
        {
            Entry entry = new Entry(key,value);
            int hc = key.hashCode();
            int index = hc % capacity;
            
            for(int x = 0; x < capacity; x++)
            {
                if(table[(index+x)%capacity]==null)
                {
                    table[(index+x)%capacity] = entry;
                    size++;
                    return null;
                }
                else if(((Entry)table[(index+x)%capacity]).removed)
                {
                    table[(index+x)%capacity] = entry;
                    while(table[(index + ++x)%capacity]!=null)
                    {
                        if(!((Entry)table[(index+x)%capacity]).removed && ((Entry)table[(index+x)%capacity]).key.equals(entry.key))
                        {    
                            ((Entry)table[(index+x)%capacity]).removed=true;
                            return ((Entry)table[(index+x)%capacity]).value;
                        }
                    }
                    size++;
                    return null;
                }
                else if(!((Entry)table[(index+x)%capacity]).removed && ((Entry)table[(index+x)%capacity]).key.equals(entry.key))
                {
                    Entry temp = (Entry)table[(index+x)%capacity];
                    table[(index+x)%capacity] = entry;
                    return temp.value;
                }
                collisions++;
            }
            
            throw new IllegalStateException("Could  not be added");
        }
        else
            throw new IllegalStateException("Table is full");
    }
   
    public Object get(Object key)
    {
        int hc = key.hashCode();
        int index = hc % capacity;
        while(table[index] != null)
        {
            if(((Entry)table[index]).key.equals(key) && !((Entry)table[index]).removed)
            {
                Object out = ((Entry)table[index]).value;
                size--;        
                return out;
            }
            else
            {
                index = (index + 1)%capacity;
                probes++;
            }
        }
        return null;
    }  
    
    public Object remove(Object key)
    {
        int hc = key.hashCode();
        int index = hc % capacity;
        while(table[index] != null)
        {
            if(((Entry)table[index]).key.equals(key) && ((Entry)table[index]).removed!=true)
            {
                Entry out = (Entry)table[index];
                ((Entry)table[index]).removed = true;
                size--;        
                return out;
            }
            else
                index = (index + 1)%capacity;
        }
        return null;
    }
    
    public String toString()
    {
        String s = "";
        for( int x = 0; x < table.length; x++)
            if(table[x]!=null)
                s += x + ": " + table[x] + "\n";
        return s;
    }
    
    public int getCapacity()
    {
        return capacity;
    }
    
    public int getCollisions()
    {
        return collisions;
    }
    
    public long getProbes()
    {
        return probes;
    }
    
    private class Entry
    {
        public Object key;
        public Object value;
        public boolean removed;
        
        public Entry()
        {
            key = null;
            value = null;
            removed = false;
        }
        
        public Entry(Object key, Object value)
        {
            this.key = key;
            this.value = value;
            removed = false;
        }
        
        public String toString()
        {
            if(!removed)
                return "" + key + " " + value;
            else
                return "dummy";
        }
    }
}


