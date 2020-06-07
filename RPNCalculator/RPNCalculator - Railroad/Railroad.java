import java.io.*;
import java.util.*;
/**
 * Checks if a permutation of railroad cars is possible to assemble
 *
 * @author Ritvik Ramakrishnan
 * @version 9/6/2019
 */
public class Railroad
{
    public static void main (String args[]) throws Exception
    {
        boolean works = true;
        boolean go = false;
        boolean finished = false;
        int N = 1;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        String line;
        Scanner input = new Scanner(new File("railroad.txt"));
        ArrayStack<Integer> station = new ArrayStack<Integer>();
        ArrayStack<Integer> train1 = new ArrayStack<Integer>();
        ArrayStack<Integer> train2 = new ArrayStack<Integer>();
        while(input.hasNextLine() && !finished)
        {
           line = input.nextLine();
           for(String s: line.split(" "))
                nums.add(Integer.parseInt(s));
           if(!go)
           {
                 N = nums.get(0);
                 if(N==0)
                 {
                     finished = true;
                     break;
                 }
                 go = true;                 
           }
           else if(nums.get(0) == 0 && !finished)
           {
                 go = false;
                 System.out.println();
           }
           else
           {
                 for(int y = 0; y < nums.size() && works; y++)
                 {
                     if(!train1.isEmpty() && nums.get(y)== train1.peek())
                        train2.push(train1.pop());
                     else if(!station.isEmpty() && nums.get(y)== station.peek()) 
                        train2.push(station.pop());
                     else if(!train1.isEmpty())
                     {
                         station.push(train1.pop());
                         y--;
                     }
                     else
                        works = false;
                 }
                 if(works)
                      System.out.println("Yes");
                 else
                      System.out.println("No");
                 train1.clear();
                 station.clear();
                 train2.clear();
           }
           works = true;
           nums.clear();
           for(int x = N; x >= 1; x --)
                     train1.push(x);
        }
    }
}
