import java.io.*;
import java.util.*;
/**
 * Plays a game of War based on the input provided by text file
 *
 * @author Ritvik Ramakrishnan
 * @version 9/24/19
 */
public class War 
{
    public static void main (String args[]) throws Exception
    {
        Scanner input = new Scanner(new File("war.txt"));
        ArrayQueue<Integer> firstdeck = new ArrayQueue(52);
        ArrayQueue<Integer> seconddeck = new ArrayQueue(52);
        ArrayQueue<Integer> table = new ArrayQueue(52);
        String line = "";
        String[] cards;
        int lineNumber = 0;
        int count = 0;
        while(input.hasNextLine())
        {
            lineNumber++;
            line = input.nextLine();
            cards = line.split(" ");
            for(String str : cards)
            {    
                try
                {
                    if(lineNumber%2==1)
                        firstdeck.enqueue(Integer.parseInt(str.substring(0,1)));
                    else
                        seconddeck.enqueue(Integer.parseInt(str.substring(0,1)));
                }
                catch(Exception exception)
                {
                    if(lineNumber%2==1)
                        switch(str.charAt(0))
                        {
                            case 'T':
                            firstdeck.enqueue(10);
                            break;
                            case 'J':
                            firstdeck.enqueue(11);
                            break;
                            case 'Q':
                            firstdeck.enqueue(12);
                            break;
                            case 'K':
                            firstdeck.enqueue(13);
                            break;
                            case 'A':
                            firstdeck.enqueue(14);
                            break;
                        }
                    else
                        switch(str.charAt(0))
                        {
                            case 'T':
                            seconddeck.enqueue(10);
                            break;
                            case 'J':
                            seconddeck.enqueue(11);
                            break;
                            case 'Q':
                            seconddeck.enqueue(12);
                            break;
                            case 'K':
                            seconddeck.enqueue(13);
                            break;
                            case 'A':
                            seconddeck.enqueue(14);
                            break;
                        }
                }
            }
            if(lineNumber%2==0)
            {    
                while(!firstdeck.isEmpty()&&!seconddeck.isEmpty()&&count<100000)
                {
                    if(firstdeck.peek()>seconddeck.peek())
                    {
                        while(!table.isEmpty())
                            firstdeck.enqueue(table.dequeue());                        
                        firstdeck.enqueue(firstdeck.dequeue());
                        firstdeck.enqueue(seconddeck.dequeue());
                    }
                    else if(seconddeck.peek()>firstdeck.peek())
                    {
                        while(!table.isEmpty())
                            seconddeck.enqueue(table.dequeue());
                        seconddeck.enqueue(firstdeck.dequeue());
                        seconddeck.enqueue(seconddeck.dequeue());
                    }
                    else if(seconddeck.peek()==firstdeck.peek())
                    {
                        if(firstdeck.size()>2 && seconddeck.size()>2)
                        {   
                            table.enqueue(firstdeck.dequeue());
                            table.enqueue(seconddeck.dequeue());
                            table.enqueue(firstdeck.dequeue());
                            table.enqueue(seconddeck.dequeue());
                        }
                        else if(firstdeck.size() > seconddeck.size())
                            while(!seconddeck.isEmpty())
                                firstdeck.enqueue(seconddeck.dequeue());
                        else if(seconddeck.size() > firstdeck.size())
                            while(!firstdeck.isEmpty())
                                seconddeck.enqueue(firstdeck.dequeue());
                        else
                        {
                            System.out.println("Tie game");
                            while(!firstdeck.isEmpty())
                                firstdeck.dequeue();
                            while(!seconddeck.isEmpty())
                                seconddeck.dequeue();
                        }
                    }
                    count++;
                }
                if(firstdeck.isFull())
                    System.out.println("Player 1 wins!");
                else if(seconddeck.isFull())
                    System.out.println("Player 2 wins!");
                else if(count>=100000)
                    System.out.println("Tie game stopped at 100000 plays.");
                while(!firstdeck.isEmpty())
                    firstdeck.dequeue();
                while(!seconddeck.isEmpty())
                    seconddeck.dequeue();
                while(!table.isEmpty())
                    table.dequeue();
                count=0;
            }
        }
    }
}