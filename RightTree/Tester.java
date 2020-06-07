import java.io.*;
import java.util.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        Scanner console = new Scanner(new File("input.txt"));
        int testCaseNum = console.nextInt();
        console.nextLine();

        for(int testCaseInd = 1; testCaseInd <= testCaseNum; testCaseInd++)
        {
            String line = console.nextLine();
            char[] chars = line.toCharArray();
            int[] nums = new int[chars.length];
            for(int i = 0; i < chars.length; i++)
                nums[i] = (int)chars[i]-48;
            
            System.out.println("Tree " + testCaseInd + (isRight(nums) ? " is " : " is not ") + "a right-tree.");

        }
    }

    public static boolean isRight(int[] nums)
    {
        if(nums.length != (int)Math.pow(2, (int)Math.ceil(Math.log(nums.length+1)/Math.log(2)))-1)
            return false;

        for(int i = nums.length-2; i > 0; i-=2)
        {
            if(nums[i] > nums[i+1])
                return false;
            nums[(i-1)/2] += nums[i] + nums[i+1];
        }
        return true;
    }
}