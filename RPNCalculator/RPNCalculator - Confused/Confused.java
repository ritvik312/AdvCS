import java.io.*;
import java.util.*;
/**
 * Checks to make sure every bracket and parentheses are formatted properly
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Confused
{
    public static void main (String args[]) throws Exception
    {
        ArrayStack<Character> stack= new ArrayStack<Character>();
        Scanner input = new Scanner(new File("confused.txt"));
        int numLines = input.nextInt();
        input.nextLine();
        String line;
        Boolean valid = true;
        for(int x = 0; x < numLines; x++)
        {
            line = input.nextLine();
            for(int y = 0; y<line.length() && valid; y++)
            {
                switch(line.charAt(y))
                {
                    case '(':  
                    stack.push('(');
                    break;
                    case '[':  
                    stack.push('[');
                    break;
                    case ')':  
                    if(stack.isEmpty()||!(stack.peek().equals('(')))
                        valid = false;
                    else
                        stack.pop();
                    break;
                    case ']':  
                    if(stack.isEmpty()||!(stack.peek().equals('[')))
                        valid = false;
                    else
                        stack.pop();
                    break;
                }
            }
            if(!stack.isEmpty())
                valid = false;
            stack.clear();
            if(valid)
                System.out.println("Yes");
            else
                System.out.println("No");
            valid = true;   
        }
    }
}
