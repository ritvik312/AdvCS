import java.util.*;
import java.io.*;
public class Plant 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner console = new Scanner(new File("plant.dat"));
        int TC = console.nextInt();
        console.nextLine();
        console.nextLine();
        for(int i = 0; i < TC; i++)
        {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            double count = 0;
            while(console.hasNextLine())
            {
                String line = console.nextLine();
                if(line.equals(""))
                    break;
                if(map.containsKey(line))
                {
                    int val = map.get(line);
                    val++;
                    map.replace(line, val);
                }
                else
                    map.put(line, 1);
                count++;
            }
            Object[] keys = map.keySet().toArray();
            Arrays.sort(keys);
            for(Object key : keys)
            {
                System.out.print(key + " ");
                int val = map.get(key);
                System.out.printf("%.4f", (val / count) * 100);
                System.out.println();
            }
            System.out.println();
        }
    }
}
