import java.util.*;
import java.io.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        HashSet<String> dictionary = new HashSet<>();
        HashSet<String> miniDictionary = new HashSet<>();
        Scanner dictFile = new Scanner(new File("dictionary.txt"));     //make alphabetized dict, use binary sort

        while(dictFile.hasNext())
            dictionary.add(dictFile.nextLine());

        Scanner in = new Scanner(new File("input.txt"));
        while(in.hasNext())
        {
            String start = in.next().trim();
            String finish = in.next().trim();

            if(start.length() != finish.length() || !dictionary.contains(start) || !dictionary.contains(finish))
            {
                System.out.printf("There is no word ladder between %s and %s!%n", start, finish);
                continue;
            }

            //Make hashmap of minidicts, key being word length and value being the minidict.
            //make copy of it to manipulate. going through the big dictionary again to make another 4-word dictionary won't be necessary
            int targetLength = start.length();
            Iterator dictionaryIteration1 = dictionary.iterator();
            while(dictionaryIteration1.hasNext())
            {
                String entry = (String)dictionaryIteration1.next();
                if(entry.length() == targetLength)
                    miniDictionary.add(entry);
            }

            QueueLinkedList stacks = new QueueLinkedList();

            StackLinkedList firstStack = new StackLinkedList();
            firstStack.push(start);

            stacks.enqueue(firstStack);

            while(true)
            {
                if(stacks.isEmpty())
                {
                    System.out.printf("There is no word ladder between %s and %s!%n", start, finish);
                    break;
                }

                StackLinkedList baseStack = (StackLinkedList)stacks.dequeue();
                if(baseStack.peek().equals(finish))
                {
                    System.out.println(baseStack.toStringBackwards());
                    break;
                }

                char[] topWordArr = ((String)baseStack.peek()).toCharArray();
                for(int repl = 0; repl < topWordArr.length; repl++)
                {
                    for(int c = 97; c < 123; c++)
                    {
                        if(c == topWordArr[repl])
                            continue;
                        char[] tempWordArr = ((String)baseStack.peek()).toCharArray();
                        tempWordArr[repl] = (char)c;
                        String tempWord = String.valueOf(tempWordArr);

                        if(miniDictionary.contains(tempWord))
                        {
                            StackLinkedList tempStack = baseStack.deepCopy();
                            tempStack.push(tempWord);
                            stacks.enqueue(tempStack);
                            miniDictionary.remove(tempWord);
                        }

                    }
                }
            }
        }

    }
}
