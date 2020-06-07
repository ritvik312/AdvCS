import java.util.*;
import java.io.*;
public class SqueezeSolitaire
{
    public static void main(String args[]) throws IOException
    {
        Scanner console = new Scanner(new File("squeezebox.txt"));

        while(console.hasNext())
        {
            String[] cards = new String[52];
            cards[0] = console.next();
            if(cards[0].equals("#"))
                break;
            for(int i = 1; i < 52; i++)
                cards[i] = console.next();

            Game game = new Game(cards);
            game.play();
            System.out.println(game.output());
        }
    }
}
