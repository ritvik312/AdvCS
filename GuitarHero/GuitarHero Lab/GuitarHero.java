import java.util.*;
import java.io.*;
public class GuitarHero
{
    public static void main(String[] args)
    {
        double CONCERT_A = 440.0;
        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < 37; i++)
        {
            strings[i] = new GuitarString(CONCERT_A * Math.pow(1.05956, i-24));
        }
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        ArrayList<Character> notesPlayed = new ArrayList<>();
        ArrayList<Integer> timesPlayed = new ArrayList<>();
        int timestamp = 0;
        int playstamp = 0;
        boolean recording = false;
        boolean playing = false;
        int lasttime = 0;
        while (true)
        {
            if(recording)
            {
                timestamp++;
            }

            if(playing)
            {
                playstamp++;

                if(timesPlayed.contains(playstamp))
                {
                    strings[keyboard.indexOf(notesPlayed.get(timesPlayed.indexOf(new Integer(playstamp))))].pluck();
                }

                if(playstamp ==  lasttime)
                {
                    playing = false;
                    playstamp = 0;
                }
            }
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if(keyboard.contains(Character.toString(key)))
                {
                    strings[keyboard.indexOf(key)].pluck();

                    if(recording)
                    {
                        notesPlayed.add(key);
                        timesPlayed.add(timestamp);
                    }
                }

                if(key == '`')
                {
                    recording = !recording;
                    if(timestamp > lasttime)
                        lasttime = timestamp;
                    timestamp = 0;
                }

                if(key == '~')
                {
                    playing = !playing;
                    playstamp = 0;
                }

                if(key == '*')
                {
                    notesPlayed = new ArrayList<>();
                    timesPlayed = new ArrayList<>();
                    lasttime = 0;
                }

                if(key == '+')
                {
                    recording = !recording;
                    playing = recording;
                }

            }
            double sample2 = 0;
            for(GuitarString str : strings)
            {
                sample2 += str.sample();
            }
            StdAudio.play(sample2);
            for(GuitarString str : strings)
            {
                str.tic();
            }

        }
    }

}
