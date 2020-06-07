import java.util.*;
import java.io.*;
public class Driver
{
    public static void main (String[]args)
    {
        HashTable table = new HashTable(101);
        Scanner console = new Scanner(new File("ArraySize101.txt"));
        while (console.hasNextLine())
        {
            table.put(console.nextInt(), console.nextLine().trim());
        }
        System.out.println(table);       
    }
}
