import java.io.*;
import java.util.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        Scanner console = new Scanner(new File("rake.txt"));
        int caseNum = 0;

        while(console.hasNext())
        {
            String line = console.nextLine();
            if(line.equals("-1"))
                break;
            caseNum++;
            String[] strings = line.split(" ");
            int[] nums = new int[strings.length];
            for(int i = 0; i < nums.length; i++)
            {
                nums[i] = Integer.parseInt(strings[i]);
            }

            Tree tree = new Tree(nums);
            tree.fill();
            System.out.printf("Case %d:%n%s%n%n", caseNum, tree.pilesOutput());
        }
    }
}
