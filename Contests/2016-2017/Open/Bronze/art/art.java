import java.io.*;
import java.util.*;
import java.util.Collections;  
public class art {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("art.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int dimensions = Integer.parseInt(st.nextToken());
		int[][] canvas = new int[dimensions][dimensions];
		for (int i = 0; i < canvas.length; i++) {
			st = new StringTokenizer(f.readLine());
			String s = (st.nextToken());
			for (int j = 0; j < canvas.length; j++) {
				canvas[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}
		//find colors not used in the art
		ArrayList<Integer> colorsUsed = new ArrayList<Integer>();
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas.length; j++) {
				if (canvas[i][j] != 0) {
					if (!colorsUsed.contains(canvas[i][j])) {
						colorsUsed.add(canvas[i][j]);
					}
				}
				
			}
		}
		int colorsNotUsed = 9 - colorsUsed.size();
		boolean[] isntFirst = new boolean[9];
		
		//check if its just 1 by 1, if it is, print 1 if greater than 0, print 0 if not, edge case
		if (dimensions == 1) {
			if (canvas[0][0] > 0) {
				out.println(1);
				System.exit(0);
			}
		}
		
		//for each valid color, find the minimum dimensions of it if it weren't obstructed
		for (int i = 0; i < colorsUsed.size(); i++) {
			//get x vals and y vals, then sort to get max y and max x and min y and min x
			ArrayList<Integer> xVals = new ArrayList<Integer>();
			ArrayList<Integer> yVals = new ArrayList<Integer>();
			for (int j = 0; j < canvas.length; j++) {
				for (int e = 0; e < canvas.length; e++) {
					if (canvas[j][e] == colorsUsed.get(i)) {
						xVals.add(e);
						yVals.add(j);
					}
				}
				
			}
			Collections.sort(xVals);
			Collections.sort(yVals);
			
			//get min x and min y and max x and max y
			int minX = xVals.get(0);
			int minY = yVals.get(0);
			int maxX = xVals.get(xVals.size() - 1);
			int maxY = yVals.get(yVals.size() - 1);
			
			//now we have 4 points that define each color's rectangle
			//1st point: (minX, minY), 2nd point: (minX, maxY), 3rd point: (maxX, maxY), 4th point: (maxX, minY)
			
			//now iterate through the rectangle, checking if something that isn't the current color is there, that means it can't be first, as it is obstructing
			for (int c = minY; c < maxY + 1; c++) {
				for (int u = minX; u < maxX + 1; u++) {
					if (canvas[c][u] != colorsUsed.get(i)) {
						isntFirst[canvas[c][u] - 1] = true;
					}
				}
			}
			
		}
		
		//loop through boolean array to see which ones are available to be first
		int counter = 0;
		for (int i = 0; i < isntFirst.length; i++) {
			if (!isntFirst[i]) {
				counter++;
			}
		}
		//ArrayPrinter(isntFirst);
		out.println(counter - colorsNotUsed);
		out.close();

	}
	public static void ArrayPrinter(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}	
	
	
	
	

}
