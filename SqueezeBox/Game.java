import java.io.*;
import java.util.*;
public class Game
{
    String[] cards;
    int cardIndex;
    ArrayList<ArrayDeque<String>> piles;

    public Game(String[] cards)
    {
        this.cards = cards;
        cardIndex = 0;
        piles = new ArrayList<>();
    }

    /*
    from left to right, check:
    if can move three spaces left, do it and check left to right again
    if can move one space left, do it and check left to right again
    if neither, check next item
    if get to end of the list without a move, flip and check from left to right again
    if out of cards, end
     */
    public void play()
    {
        while(cardIndex < 52)
        {
            flip();
            boolean moved;
            do
            {
                moved = false;
                for(int i = 0; i < piles.size(); i++)
                {
                    if(i >= 3)
                    {
                        //[move 3 spaces left, moved = true, and break] if possible
                        if(topCardsMatch(i, i-3))
                        {
                            moveCard(i, i-3);
                            moved = true;
                            break;
                        }
                    }
                    //[move 1 space left, moved = true, and break] if possible
                    if(i >= 1)
                    {
                        if(topCardsMatch(i, i-1))
                        {
                            moveCard(i, i-1);
                            moved = true;
                            break;
                        }
                    }
                }

            } while(moved);
        }
    }

    public void flip()
    {
        ArrayDeque newArrayDeque = new ArrayDeque();
        newArrayDeque.add(cards[cardIndex]);
        cardIndex++;
        piles.add(newArrayDeque);
    }

    public boolean topCardsMatch(int pileIndex1, int pileIndex2)
    {
        String card1 = piles.get(pileIndex1).getFirst();
        String card2 = piles.get(pileIndex2).getFirst();
        return card1.charAt(0) == card2.charAt(0) || card1.charAt(1) == card2.charAt(1);
    }

    public void moveCard(int pileIndexRight, int pileIndexLeft)
    {
        //store/remove first val from right pile
        String movingCard = piles.get(pileIndexRight).removeFirst();

        //add val to first of left pile
        piles.get(pileIndexLeft).addFirst(movingCard);

        //if right pile is now empty, remove it from piles
        if(piles.get(pileIndexRight).isEmpty())
        {
            piles.remove(pileIndexRight);
        }
    }

    public String output()
    {
        String output;
        if(piles.size() == 1)
            output = "1 pile remaining: ";
        else
            output = piles.size() + " piles remaining: ";

        for(ArrayDeque arrDeq : piles)
        {
            output += arrDeq.size() + " ";
        }
        return output;
    }
}
