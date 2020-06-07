import java.io.*;
import java.util.*;

public class War
{
    public static void main(String args[]) throws IOException
    {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNext())
        {
            //fill up player hands
            RingBuffer player1 = new RingBuffer(52);
            RingBuffer player2 = new RingBuffer(52);

            for(int i = 0; i < 52; i++) //for(int i = 0; i < 52; i++)
            {
                char card = sc.next().charAt(0);
                int cardNum = 0;
                switch(card)
                {
                    case 'T':
                        cardNum = 10;
                        break;
                    case 'J':
                        cardNum = 11;
                        break;
                    case 'Q':
                        cardNum = 12;
                        break;
                    case 'K':
                        cardNum = 13;
                        break;
                    case 'A':
                        cardNum = 14;
                        break;
                    default:
                        cardNum = card - 48;
                }

                if(i < 26) //if(i < 26)
                    player1.enqueue(cardNum);
                else
                    player2.enqueue(cardNum);

            }

            Game game = new Game(player1, player2);
            //System.out.println("P1: " + player1 + "\nP2: " + player2 + "\n");
            System.out.println(game.outcome());

        }
    }
}
