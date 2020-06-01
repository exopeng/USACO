import java.io.*;
import java.util.*;
public class blockedBillboard {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		/*
		 * BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
		 * PrintWriter out = new PrintWriter(new BufferedWriter(new
		 * FileWriter("billboard.out")));
		 */
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		//first billboard
		int alfafaX1 = Integer.parseInt(st.nextToken());
		int alfafaY1 = Integer.parseInt(st.nextToken());
		int alfafaX2 = Integer.parseInt(st.nextToken());
		int alfafaY2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(f.readLine());
		//second billboard
		int grainX1 = Integer.parseInt(st.nextToken());
		int grainY1 = Integer.parseInt(st.nextToken());
		int grainX2 = Integer.parseInt(st.nextToken());
		int grainY2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(f.readLine());
		
		//truck
		int truckX1 = Integer.parseInt(st.nextToken());
		int truckY1 = Integer.parseInt(st.nextToken());
		int truckX2 = Integer.parseInt(st.nextToken());
		int truckY2 = Integer.parseInt(st.nextToken());
		
		//calculate areas of each billboard
		int alfafaArea = (alfafaX2 - alfafaX1) * (alfafaY2 - alfafaY1);
		int grainArea = (grainX2 - grainX1) * (grainY2 - grainY1);
		
		//find if areas of each billboard and truck intersect
		int alfafaCoveredArea = findXArea(alfafaX1, alfafaX2, truckX1, truckX2) * findXArea(alfafaY1, alfafaY2, truckY1, truckY2);
		//System.out.println(alfafaCoveredArea);
		int grainCoveredArea = findXArea(grainX1, grainX2, truckX1, truckX2) * findXArea(grainY1, grainY2, truckY1, truckY2);
		//System.out.println(grainCoveredArea);
		
		out.println((alfafaArea - alfafaCoveredArea) + (grainArea - grainCoveredArea));
		
	
		out.close();
	}
	
	public static int findXArea(int AX1, int AX2, int BX1, int BX2) {
		//boi setting this to -1 costed me an extra 15 minutes, and 3 test cases
		//problem is how to set this to 0 so i don't have to handle for -1 in the end
		//because the first point shared doesn't mean anything, only the second and on does...
		int xLength = -1;
		//check if each x val falls in the truck's x val
		int[] array1 = new int[] {AX1, AX2, BX1, BX2};
		Arrays.sort(array1);
		//get min x and max x
		int minX = array1[0];
		int maxX = array1[array1.length - 1];
		
		//iterate on this big interval, if there is an shared point add 1 to xLength
		for (int i = minX; i <= maxX; i++) {
			//check if i falls in both intervals
			if (i >= AX1 && i <= AX2 && i >= BX1 && i <= BX2) {
				xLength++;
			}
		}
		//handle if there is not intersection
		if (xLength == -1) {
			return 0;
		}
		return xLength;
	}
	
}
