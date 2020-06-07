import java.io.IOException;
import java.util.ArrayList;
public class StarChartMaker {
	public static void main(String[] args) throws IOException
	{
		StarChart star = new StarChart();
		HashTable[] data = star.readCoords("stars.txt");
		HashTable coordinates = data[0];
		HashTable magnitudes = data[1];
		HashTable names = data[2];
		ArrayList<Integer> list = star.getHDList();
		ArrayList<Couple> list1 = star.readConst("constellations.txt", names);
		StdDraw.setCanvasSize(1000, 1000);
		StdDraw.clear(StdDraw.BLACK);
		star.plotStarsByMagnitude(coordinates, magnitudes, list);
		star.plotConst(coordinates, list1);
	}
}