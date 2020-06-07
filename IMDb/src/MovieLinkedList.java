//because the data given to me in this project has already been sorted, I found out this code has no purpose. Oh well.

public class MovieLinkedList extends LinkedList
{

    //bad code: make add method only take Movie, not object

    public void sortRecent()
    {
        for(int i = 0; i < count; i++)
        {
            Node current = getNode(i);
            Node oldest = current;
            while(current.getNextPtr() != null)
            {
                current = current.getNextPtr();
                if(((Movie)oldest.get()).getDate() > ((Movie)current.get()).getDate())
                {
                    oldest = current;
                }
            }
            remove(oldest);
            add(oldest);
        }
    }
}
