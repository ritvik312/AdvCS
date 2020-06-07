import java.io.*;
import java.util.*;
public class Driver
{
    public static void main(String args[]) throws Exception
    {
        ArrayList<String> largeList = new ArrayList<String>(500000);
        ArrayList<String> sucList = new ArrayList<String>(500000);
        ArrayList<String> unsucList = new ArrayList<String>(500000);
        Scanner largeInput = new Scanner(new File("Large Data Set.txt"));
        Scanner sucInput = new Scanner(new File("Successful Search.txt"));
        Scanner unsucInput = new Scanner(new File("Unsuccessful Search.txt"));
        
        while(largeInput.hasNextLine())
        {
            largeList.add(largeInput.nextLine().trim());
        }
        
        while(sucInput.hasNextLine())
        {
            sucList.add(sucInput.nextLine().trim());
        }
        
        while(unsucInput.hasNextLine())
        {
            unsucList.add(unsucInput.nextLine().trim());
        }
        
        //HashTable table = new HashTable(5000011);//alpha=.1
        //HashTable table = new HashTable(1000003);//alpha=.5
        //HashTable table = new HashTable(625007);//alpha=.8
        //HashTable table = new HashTable(555557);//alpha=.9
        HashTable table = new HashTable(500009);//alpha=1
        
        long start = System.currentTimeMillis();
        for(String s : largeList)
        {
            int key = Integer.parseInt(s.substring(0,8));
            String value = s.substring(9);
            table.put(key,value);
        }
        long stop = System.currentTimeMillis();
        long buildTime = stop - start;
        
        start = System.currentTimeMillis();
        for(String s : sucList)
        {
            int key = Integer.parseInt(s.substring(0,8));
            table.get(key);
        }
        stop = System.currentTimeMillis();
        long sucSearchTime = stop - start;
        long sucProbes = table.getProbes();
        
        start = System.currentTimeMillis();
        for(String s : unsucList)
        {
            int key = Integer.parseInt(s.substring(0,8));
            table.get(key);
        }
        stop = System.currentTimeMillis();
        long unsucSearchTime = stop - start;
        long unsucProbes = table.getProbes() - sucProbes;
        
        System.out.println("Linear Probing");
        System.out.println("Hash Value = Integer Value");
        System.out.println("Items Added: 500K, Table Size: "+ table.getCapacity() + ", Load Factor: "+500000.0/table.getCapacity());
        System.out.println("Average Insertion Time: " + buildTime / 500000.00 + "ms");
        System.out.println("Number of Table Insertion Collisions: " + table.getCollisions());
        System.out.println("Collisions vs. Insertions: " + (table.getCollisions()/500000.0));//*100 + "%");
        System.out.println("Average Time to find Entry: " + sucSearchTime / 500000.00 + "ms");
        System.out.println("Average Probes to find Entry: " + sucProbes / 500000.00);
        System.out.println("Average Time to find Entry isn't in Table: " + unsucSearchTime / 500000.00 + "ms");
        System.out.println("Average Probes to find Entry isn't in Table: " + unsucProbes / 500000.00);    
    }
}