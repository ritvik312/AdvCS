public class Goat implements Comparable<Goat>
{
    int[] cycle;
    int ind;

    public Goat(int[] cycle)
    {
        this.cycle = cycle;
    }

    public void nextDay()
    {
        ind = (ind+1)%cycle.length;
    }

    public int output()
    {
        return cycle[ind];
    }

    public int compareTo(Goat otherGoat)
    {
        return this.output() - otherGoat.output();
    }
}
