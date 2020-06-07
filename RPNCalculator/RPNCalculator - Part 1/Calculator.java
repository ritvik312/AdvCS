/**
 * Defines common Stack methods.
 * 
 * @author Ritvik Ramakrishnan 
 */
import java.util.*;
import java.io.*;
public class Calculator 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        ArrayStack stack = new ArrayStack();
        Scanner console = new Scanner(new File("expressions.txt"));
        int numCalc = console.nextInt();
        console.nextLine();
        for (int i = 0; i < numCalc; i++)
        {
            String calculation = console.nextLine();
            String[] calculationSplit = calculation.split(" ");
            boolean noTwoVals = false;
            for (String item : calculationSplit) 
            {
                if (isOperator(item)) 
                {
                    if (stack.size() < 2)
                    {
                        noTwoVals = true;
                        break;
                    }
                    else
                    {
                        double val1 = stack.pop();
                        double val2 = stack.pop();
                        switch (item) 
                        {
                            case "+":
                            stack.push(val1 + val2);
                            break;
                            case "-":
                            stack.push(val2 - val1);
                            break;
                            case "*":
                            stack.push(val1 * val2);
                            break;
                            case "/":
                            stack.push(val2 / val1);
                            break;
                        }
                    }
                } 
                else 
                {
                    stack.push(Double.parseDouble(item));
                }
            }
            if (noTwoVals == true)
            {
                System.out.println("Invalid");
                break;
            }
            System.out.println(stack.pop());
            stack.clear();
        }
    }

    private static boolean isOperator(String input) 
    {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }
}