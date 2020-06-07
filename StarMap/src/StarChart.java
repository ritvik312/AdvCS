import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class StarChart {
	public static ArrayList<Integer> hD = new ArrayList<>();
	
	public void plotStars(HashTable c, ArrayList<Integer> list)
	{
		StdDraw.setPenColor(StdDraw.WHITE);
		for (Integer i : list)
		{
			Coordinate temp = translate((Coordinate) c.get(i));
			StdDraw.filledRectangle(temp.x, temp.y, 1, 1);
		}
	}

	public void plotStarsByMagnitude(HashTable c, HashTable m, ArrayList<Integer> list)
	{
		StdDraw.setPenColor(StdDraw.WHITE);
		double StarSize = 0;
		for (Integer i : list)
		{
			Coordinate temp = translate((Coordinate) c.get(i));
			StarSize = Math.round(10.0 / ((double) m.get(i) + 2.0));
			StdDraw.filledCircle(temp.x, temp.y, StarSize);
		}
	}
	
	public void plotConst(HashTable coordinates, ArrayList<Couple> list)
	{
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(0.001);
		for(Couple c : list)
		{
			int hd1 = c.hd1;
			int hd2 = c.hd2;
			Coordinate a = translate((Coordinate) coordinates.get(hd1));
			Coordinate b = translate((Coordinate) coordinates.get(hd2));
			StdDraw.line(a.x, a.y, b.x, b.y);
		}
	}
	
	public HashTable[] readCoords(String fileName) throws IOException
	{
		Scanner scan = new Scanner(new File(fileName));
		HashTable coordinates = new HashTable(10000);
		HashTable magnitude = new HashTable(10000);
		HashTable names = new HashTable(10000);
		
		while(scan.hasNextLine())
		{
			String[] line = scan.nextLine().split(" ");

			double x = Double.parseDouble(line[0]);
			double y = Double.parseDouble(line[1]);
			double z = Double.parseDouble(line[2]);
			int hDNum = Integer.parseInt(line[3]);
			double magnitudes = Double.parseDouble(line[4]);
			double hRNum = Double.parseDouble(line[5]);
			hD.add(hDNum);
			
			coordinates.put(hDNum, new Coordinate(x, y));
			magnitude.put(hDNum, magnitudes);

			String conc = "";
			for(int i = 6, cnt = 0; i < line.length; i++, cnt++)
			{
				if (cnt > 0) 
					conc += " ";
				conc += line[i];
			}
			String[] temporary = conc.split(";");
			
			for(String name : temporary)
			{
				names.put(redName(name), hDNum);
			}
		}
		HashTable[] result = {coordinates, magnitude, names};
		return result;
	}
	
	public ArrayList<Couple> readConst(String fileName, HashTable names) throws IOException
	{
		Scanner scan = new Scanner(new File(fileName));
		ArrayList<Couple> list= new ArrayList<Couple>();
		
		while (scan.hasNextLine())
		{
			String[] temp = scan.nextLine().split(",");
			list.add(new Couple(temp[0], temp[1], (Integer) names.get(temp[0]), (Integer) names.get(temp[1])));
		}
		scan.close();
		return list;
	}
	
	public static String redName(String s)
	{
		int i;
		for(i = 0; i < s.length(); i++)
		{
			String temporary = s.substring(i, i + 1);
			if(!temporary.equals(" "))
				break;
		}
		return s.substring(i); 
	}
	
	public static Coordinate translate(Coordinate c)
	{
        double newX = 0 + ((c.x - -1) / (1 - -1)) * (1000 - 0);
        double newY = 0 + ((c.y - 1) / (-1 - 1)) * (1000 - 0);
        return new Coordinate(newX, newY);
	}
	
	public ArrayList<Integer> getHDList()
	{
		return hD;
	}
}