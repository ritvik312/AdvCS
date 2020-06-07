import java.util.*;
import java.io.*;
public class ListTester
{
    public static void main(String args[]) throws IOException
    {
        Scanner actorsFile = new Scanner(new File("actors.txt"));

        LinkedList ll = new LinkedList();

        while(actorsFile.hasNext())
            ll.add(new Actor(actorsFile.nextLine()));

        //ll.remove(new Actor("David"));

        for(int i = 0; i < ll.size(); i++)
        {
            System.out.println(ll.get(i));
        }

        //System.out.println(ll);

        System.out.println("\n" + ((Actor)ll.get(0)).getName());


        Scanner moviesFile = new Scanner(new File("movies.txt"));

        LinkedList movies = new LinkedList();

        while(moviesFile.hasNext())
        {
            int date = moviesFile.nextInt();

            String line = moviesFile.nextLine();

            String title = line.substring(1, line.indexOf("  "));

            String actorsString = line.substring(line.indexOf("  "), line.indexOf("Dir:")).trim();
            String[] actorsArr = actorsString.split(",");
            LinkedList actors = new LinkedList();
            for(int i = 0; i < actorsArr.length; i++)
                actors.add(new Actor(actorsArr[i].trim()));

            String directorsString = line.substring(line.indexOf("Dir:")+5).trim();
            String[] directorsArr = directorsString.split(",");
            LinkedList directors = new LinkedList();
            for(int i = 0; i < directorsArr.length; i++)
                directors.add(new Actor(directorsArr[i].trim()));

            movies.add(new Movie(date, title, actors, directors));
        }

        System.out.println(movies);

        System.out.println(((Movie)movies.get(0)).getTitle());

    }
}
