import java.io.*;
import java.util.*;
public class IMDb
{
    public static void main(String args[]) throws IOException
    {
        //store actors into LinkedList allActors
        Scanner actorsFile = new Scanner(new File("actors.txt"));

        LinkedList allActors = new LinkedList();

        while(actorsFile.hasNext())
            allActors.add(new Actor(actorsFile.nextLine().trim()));


        //store movies into LinkedList allMovies
        Scanner moviesFile = new Scanner(new File("movies.txt"));

        LinkedList allMovies = new LinkedList();

        while(moviesFile.hasNext())
        {
            //movie file was meant to be split into columns. no indexOf necessary
            int date = moviesFile.nextInt();

            String line = moviesFile.nextLine();

            String title = line.substring(1, 34).trim();

            String actorsString = line.substring(34, 80).trim();
            String[] actorsArr = actorsString.split(",");
            LinkedList actors = new LinkedList();
            for(int i = 0; i < actorsArr.length; i++)
                actors.add(new Actor(actorsArr[i].trim()));

            String directorsString = line.substring(80).trim();
            String[] directorsArr = directorsString.split(",");
            LinkedList directors = new LinkedList();
            for(int i = 0; i < directorsArr.length; i++)
                directors.add(new Actor(directorsArr[i].trim()));

            allMovies.add(new Movie(date, title, actors, directors));
        }


        //Print each actor name, and the date and title of each of their movies, starting with most recent

        //inefficient way
        /*
        for(int a = 0; a < allActors.size(); a++)
        {
            System.out.println(((Actor)allActors.get(a)).getName() + ":");

            for(int m = 0; m < allMovies.size(); m++)
            {
                if(((Movie)allMovies.get(m)).getActors().contains((Actor)allActors.get(a)))
                {
                    System.out.println("\t" + ((Movie)allMovies.get(m)).getDate() + " - " + ((Movie)allMovies.get(m)).getTitle());
                }
            }
        }
        */

        System.out.println();

        //efficient way
        Node currentActor = allActors.getNode(0);
        while(currentActor != null)
        {
            System.out.println(((Actor)currentActor.get()).getName() + ":");

            Node currentMovie = allMovies.getNode(0);
            while(currentMovie != null)
            {
                if(((Movie)currentMovie.get()).getActors().contains(currentActor))
                    System.out.println("\t" + ((Movie)currentMovie.get()).getDate() + " - " + ((Movie)currentMovie.get()).getTitle());

                currentMovie = currentMovie.getNextPtr();
            }

            currentActor = currentActor.getNextPtr();
        }

    }
}
