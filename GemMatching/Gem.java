import java.awt.Font;
import java.util.*;
enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
    public static GemType random() {
        switch (new Random().nextInt(GemType.values().length)) {
            case 0: return GREEN;
            case 1: return BLUE;
            case 2: return ORANGE;
            default: return GREEN;
        }
    }
}

public class Gem 
{   
    /** Tester main method */
    private int points;
    private GemType type;
    private static StdDraw pointText;
    public Gem() {
        this(GemType.random(), new Random().nextInt(11)*5);
    }

    public Gem(GemType type, int points) {
        this.type = type;
        this.points = points;
    }

    public String toString() {
        return type + " " + points;
    }

    public GemType getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }

    public void draw(double x, double y) {
        String fileName = "gem_";
        switch (type) {
            case GREEN: fileName += "green.png"; break;
            case BLUE: fileName += "blue.png"; break;
            case ORANGE: fileName += "orange.png"; break;
            default: fileName += "green.png"; break;
        }
        StdDraw.picture(x, y, fileName);
        pointText.text(x, y, Integer.toString(getPoints()));
    }

    public static void main(String [] args)
    {
        final int maxGems = 16;

        // Create a gem of each type
        Gem green  = new Gem(GemType.GREEN,10);
        Gem blue   = new Gem(GemType.BLUE, 20);
        Gem orange = new Gem(GemType.ORANGE, 30);
        System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());        
        System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
        System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
        green.draw(0.3, 0.7);
        blue.draw(0.5, 0.7);
        orange.draw(0.7, 0.7);

        // A row of random gems
        for (int i = 0; i < maxGems; i++) {
            Gem g = new Gem();
            g.draw(1.0 / maxGems * (i + 0.5), 0.5);
        }
    }
}