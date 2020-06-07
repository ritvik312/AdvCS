import java.io.*;
import java.util.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(new File("input.txt"));

        while(in.hasNext())
        {
            String[] strs = in.nextLine().split(", ");
            int[] nums = new int[strs.length];
            for(int i = 0; i < nums.length; i++)
                nums[i] = Integer.parseInt(strs[i]);

            BST bst = new BST();
            for(int num : nums)
                bst.insertValue(num);

            bst.traverse();

            System.out.printf("%s%nIn order: %s%n", bst.prettyStr, bst.inorderStr);
        }
    }
}
