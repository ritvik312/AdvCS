
/**
 * Outlines a basic queue
 *
 * @author Ritvik Ramakrishnan
 * @version 9/24/19
 */
public class ArrayQueue<T>
{
    private int size = 0, front = 0;
    private Object[] queue;
    
    public ArrayQueue(int capacity)
    {
        queue = new Object[capacity];
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        if(size==0)
            return true;
        else
            return false;
    }
    
    public boolean isFull()
    {
        if(size==queue.length)
            return true;
        else
            return false;
    }
    
    public void enqueue(T x)
    {
        if(this.isFull())
            throw new IllegalStateException("Queue is full");
        else
            {
                queue[(front+size)%queue.length] = x;
                size++;
            }
    }
    
    public T dequeue()
    {
        if(this.isEmpty())
            throw new IllegalStateException("Queue is empty");
        else
            {
               size--;
               int lastFront = front;
               front=(front+1)%queue.length;
               return (T)queue[lastFront];
            }
    }
    
    public T peek()
    {
        if(this.isEmpty())
            throw new IllegalStateException("Queue is empty");
        else
            {
               return (T)queue[front];
            }
    }
}
