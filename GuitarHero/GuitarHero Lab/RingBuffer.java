import java.util.*;
import java.io.*;
public class RingBuffer
{
    private double [] array;
    private int front, size;
    public RingBuffer(int capacity)
    {
        array = new double [capacity];
        front = 0;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull()
    {
        return size == array.length;
    }

    public void enqueue(double val)
    {
        if (isFull())
        {
            throw new IllegalStateException("It is full...");
        }
        else
        {
            array[(front + size) % array.length] = val;
            size++;
        }
    }

    public double dequeue()
    {
        double temp;  
        if (isEmpty())
        {
            throw new IllegalStateException("It is empty...");
        }
        else
        {
            temp = array[front];
            size--;
            front = (front+1) % array.length;
        }
        return temp;
    }

    public double peek()
    {
        if(size > 0)
        {
            return array[front];
        }
        else
        {
            throw new IllegalStateException ("{Peek ERROR: RingBuffer is empty.\n" + toString());
        }
    }
}
