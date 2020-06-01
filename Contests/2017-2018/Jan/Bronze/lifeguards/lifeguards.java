/*
LANG: JAVA
ID: exopeng
PROG: lifeguards
*/
import java.io.*;
import java.util.*;

public class lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numIntervals = Integer.parseInt(st.nextToken());
		int[][] intervals = new int[numIntervals][2];
		int[] timeLine = new int[numIntervals * 2];
		int counter = 0;
		for (int i = 0; i < intervals.length; i++) {
			st = new StringTokenizer(f.readLine());
			int startPoint = Integer.parseInt(st.nextToken());
			int endPoint = Integer.parseInt(st.nextToken());
			intervals[i][0] = startPoint;
			intervals[i][1] = endPoint;
			timeLine[counter] = startPoint;
			timeLine[counter + 1] = endPoint;
			counter += 2;
		}
		Arrays.sort(timeLine);
		int maxDays = 0;
		//get max day
		int maxDay = timeLine[timeLine.length - 1];
		//get min day
		int minDay = timeLine[0];
		
		
		for (int i = 0; i < intervals.length; i++) {
			int Days = 0;
			//make array of intervals without current interval
			int[][] newIntervals = makeArray(intervals, i);
			for (int j = minDay; j < maxDay + 1; j++) {
				//goes through all intervals to see if the day is covered in the lifeguard's shift
				for (int e = 0; e < newIntervals.length; e++) {
					if ( j > newIntervals[e][0] && j <= newIntervals[e][1]) {
						Days++;
						break;
					}
 				}
			}
			if (Days > maxDays) {
				maxDays = Days;
			}
		}
		
		out.println(maxDays);
		
		
		out.close();

	}
	
	public static int[][] makeArray(int[][] array, int removedInterval) {
		int[][] newArray = new int[array.length - 1][2];
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (i != removedInterval) {
				int startPoint = array[i][0];
				int endPoint = array[i][1];
				newArray[counter][0] = startPoint;
				newArray[counter][1] = endPoint;
				counter++;
			}
		}
		return newArray;
		
		
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
