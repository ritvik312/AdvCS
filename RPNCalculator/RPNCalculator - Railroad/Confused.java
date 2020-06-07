import java.io.*;
import java.util.*;
public class Confused {

    public static void main(String[] args) throws FileNotFoundException 
    {
        ArrayStack<String> stack = new ArrayStack<>();
        Scanner console = new Scanner(new File("confused.txt"));
        int numCalc = 3; 
        console.nextLine();
        while (console.hasNextLine()) 
        {
            String next = console.nextLine();
            next = next.replaceAll("\\s", "");
            String[] chars = next.split("");
            if (next.length() == 0)
            {
                System.out.println("Yes");
            }
            else
            {
                if (chars.length % 2 == 0)
                {
                    for (String aChar : chars) 
                    {
                        switch(aChar)
                        {
                            case "(":
                            stack.push("(");
                            break;
                            case "[":
                            stack.push("[");
                            break;
                            case ")":
                            if (stack.isEmpty() || !(stack.peek().equals('(')))
                                System.out.println("No");
                            else stack.pop();
                            break;
                            case "]":
                            if (stack.isEmpty() || !(stack.peek().equals('[')))
                                System.out.println("No");
                            else stack.pop();
                            break;
                        }
                    }
                    if (stack.isEmpty()) 
                    {
                        System.out.println("Yes");
                    }
                    else System.out.println("No");
                    stack.clear();
                }
                else System.out.println("No");
            }
        }
    }
}
