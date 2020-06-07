import java.util.*;
import java.io.*;
public class ArrayStack<T> //implements IStack<T>
{
    private int top;
    private T[] stack;
    private int size;
    private final int GENSIZE = 100;
    public ArrayStack() 
    {
        top = 0;
        size = GENSIZE;
        stack = (T[]) new Object[size];
    }

    public ArrayStack(int size) 
    {
        top = 0;
        this.size = size;
        stack = (T[]) new Object[size];
    }

    public void push(T val) 
    {
        if (this.isFull()) 
        {
            throw new IllegalStateException("Stack is full");
        }
        else
        {
            stack[top] = (T) val;   
            top++;
        }
    }

    public T pop() 
    {
        if (this.isEmpty()) 
        {
            throw new IllegalStateException("Stack is empty");
        }
        else
        {
            top--;
            return stack[top];
        }
    }

    public T peek() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Stack is empty");
        }
        else
        {
            return stack[top];
        }
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
