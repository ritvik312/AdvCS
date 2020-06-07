import java.io.*;
import java.util.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(new File("mathCosts.txt"));
        while(in.hasNext())
        {
            int size = in.nextInt();
            if(size == 0)
                break;
            PriorityQueue<Integer> nums = new PriorityQueue<>();
            for(int i = 0; i < size; i++)
            {
                nums.add(in.nextInt());
            }
            int sum = 0;
            for(int i = 0; i < size-1; i++)
            {
                int newNum = nums.poll() + nums.poll();
                sum += newNum;
                nums.add(newNum);
            }
            System.out.println(sum);
        }
    }
}
