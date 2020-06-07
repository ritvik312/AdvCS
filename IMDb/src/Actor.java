public class Actor
{
    String name;

    public Actor()
    {
        name = null;
    }

    public Actor(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return ("Name: " + name);
    }

}
