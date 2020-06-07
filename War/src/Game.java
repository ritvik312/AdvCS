public class Game
{
    RingBuffer hand1;
    RingBuffer hand2;
    RingBuffer table;
    int handcount;

    public Game(RingBuffer h1, RingBuffer h2)
    {
        hand1 = h1;
        hand2 = h2;
        table = new RingBuffer(52);
        handcount = 0;
    }

    public String outcome()
    {
        while(handcount < 100000)
        {
            if(hand1.isEmpty())
                return "Player 2 wins!";
            if(hand2.isEmpty())
                return "Player 1 wins!";
            flip();
        }

        return "Tie game stopped at 100000 plays.";
    }

    private void flip()
    {
        int p1card = hand1.dequeue();
            table.enqueue(p1card);
        int p2card = hand2.dequeue();
            table.enqueue(p2card);

        //testing
        //System.out.printf("hand #%d:%nP1:%s%nP2:%s%nP1card:%d%nP2card:%s%n%n",handcount, hand1,hand2,p1card,p2card);

        if(p1card > p2card)
            hand1Collect();
        else if(p2card > p1card)
            hand2Collect();
        else
        {
            table.enqueue(hand1.dequeue());
            table.enqueue(hand2.dequeue());
            if(!hand1.isEmpty() && !hand2.isEmpty())
                flip();
        }
    }

    private void hand1Collect()
    {
        //testing
        //System.out.printf("P1 took %s from the table%n",table);
        while(!table.isEmpty())
        {
            hand1.enqueue(table.dequeue());
        }
        handcount++;
        //System.out.printf("Afterwards, he had: %s%n",hand1);
    }

    private void hand2Collect()
    {
        //testing
        //System.out.printf("P2 took %s from the table",table);
        while(!table.isEmpty())
        {
            hand2.enqueue(table.dequeue());
        }
        handcount++;
        //System.out.printf("Afterwards, he had: %s%n",hand2);
    }
}
