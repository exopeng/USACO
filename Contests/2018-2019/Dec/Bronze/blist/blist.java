/*
LANG: JAVA
ID: exopeng
PROG: blist
*/
import java.io.*;
import java.util.*;
public class blist {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("blist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[][] intervals = new int[Integer.parseInt(st.nextToken())][3];
		int maxTime = 0;
		int minTime = 0;
		int counter = 0;
		int[] timePoints = new int[intervals.length * 2];
		for (int i = 0; i < intervals.length; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < intervals[0].length; j++) {
				intervals[i][j] = Integer.parseInt(st.nextToken());
				if (j != 2) {
					timePoints[counter] = intervals[i][j];
					counter++;
				}
			}
		}
		Arrays.sort(timePoints);
		int buckets = 0;
		
		//loop through all the times
		for (int i = 0; i < timePoints.length; i++) {
			//check against all other intervals
			int currBuckets = 0;
			boolean checked = false;
			for (int j = 0; j < intervals.length; j++) {
				//don't check it against itself
				if (!(timePoints[i] == intervals[j][0] || timePoints[i] == intervals[j][1])) {
					if ((timePoints[i] > intervals[j][0] && timePoints[i] < intervals[j][1]) ) {
						currBuckets += intervals[j][2];
					}
					//if it is itself, than add the interval bucket
				} else if (!checked){
					currBuckets += intervals[j][2];
					checked = true;
				}
				
			}
			
			if (currBuckets > buckets) {
				buckets = currBuckets;
			}
		}
		
		out.println(buckets);
		out.close();
	
	}
	public static void ArrayPrinter(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println();
		
	}
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
