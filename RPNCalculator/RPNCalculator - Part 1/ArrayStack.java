import java.util.*;
import java.io.*;
public class ArrayStack implements IStack 
{
    private int top;
    private double[] stack;
    private int size;
    private final int GENSIZE = 100;
    public ArrayStack() 
    {
        top = 0;
        size = GENSIZE;
        stack = new double[size];
    }

    public ArrayStack(int size) 
    {
        top = 0;
        this.size = size;
        stack = new double[size];
    }

    public void push(double num) 
    {
        if (isFull()) 
        {
            return;
        }
        stack[top] = num;        
        top++;
    }

    public double pop() 
    {
        if (isEmpty()) 
        {
            return 0;
        }
        top--;
        return stack[top];
    }

    public double peek() 
    {
        if (isEmpty()) 
        {
            return 0;
        }
        return stack[top];
    }

    public int size() 
    {
        return top;
    }

    public boolean isEmpty() 
    {
        return top <= 0;
    }

    public boolean isFull() 
    {
        return top >= size - 1;
    }

    public void clear() 
    {
        top = 0;
    }

    public String toString() 
    {
        StringBuilder output = new StringBuilder();
        for (int i = top - 1; i >= 0; i--) {
            output.append("\n").append(stack[i]);
        }
        return output.toString();
    }

    public String ArrayToString() 
    {
        StringBuilder output = new StringBuilder();
        for (int i = GENSIZE - 1; i >= 0; i--) {
            output.append("\n").append(stack[i]);
        }
        return output.toString();
    }
}
