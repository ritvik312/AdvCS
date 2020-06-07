import java.util.*;
import java.io.*;
public class GuitarString
{
    RingBuffer queue;
    private static int time = 0;
    public GuitarString (double frequency)
    {
        int num = (int)Math.ceil(44100/frequency);
        queue = new RingBuffer(num);
        for (int i = 0; i < num; i++)
            queue.enqueue(0);
    }

    public GuitarString(double[] init)
    {
        queue = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++)
            queue.enqueue(init[i]);
    }

    public void pluck()
    {
        for (int i  = 0; i < queue.size(); i++)
        {
            queue.dequeue();
            queue.enqueue(Math.random()-0.5);
        }
    }

    public void tic()
    {
        double n1 = queue.dequeue();
        double n2 = queue.peek();
        double result = (n1+n2)*0.994*.5;
        queue.enqueue(result);
        time++;
    }

    public double sample()
    {
        return queue.peek();
    }

    public int time()
    {
        return time; 
    }
}
