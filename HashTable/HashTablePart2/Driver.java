import java.io.*;
import java.util.*;
public class Driver
{
    public static void main(String args[]) throws Exception
    {
        HashTable table = new HashTable(101);
        Scanner in1 = new Scanner(new File("1 - put 50 items.txt"));
        Scanner in2 = new Scanner(new File("2 - remove 10 items.txt"));
        Scanner in3 = new Scanner(new File("3 - put (overwriting) 5 items.txt"));
        Scanner in4 = new Scanner(new File("4 - put 10 items.txt"));
        
        while(in1.hasNextLine())
        {
            in1.nextInt();
            in1.next();
            table.put(in1.nextInt(), in1.nextLine().trim());
        }
        System.out.println(table);
        while(in2.hasNextLine())
        {
            in2.nextInt();
            in2.next();
            table.remove(in2.nextInt());
            in2.nextLine();
        }
        System.out.println(table);
        while(in3.hasNextLine())
        {
            in3.nextInt();
            in3.next();
            table.put(in3.nextInt(), in3.nextLine().trim());
        }
        System.out.println(table);
        while(in4.hasNextLine())
        {
            in4.nextInt();
            in4.next();
            table.put(in4.nextInt(), in4.nextLine().trim());
        }
        System.out.println(table);
    }
}