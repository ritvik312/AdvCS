public class MovieSortTester
{
    public static void main(String args[])
    {
        Movie m1 = new Movie(1980, "Old movie", null, null);
        Movie m2 = new Movie(1970, "Oldest movie", null, null);
        Movie m3 = new Movie(2010, "Newest movie", null, null);
        Movie m4 = new Movie(2000, "New movie", null, null);

        MovieLinkedList movies = new MovieLinkedList();
            movies.add(m1);
            movies.add(m2);
            movies.add(m3);
            movies.add(m4);

        System.out.println(movies);

        movies.sortRecent();

        System.out.println(movies);
    }
}
