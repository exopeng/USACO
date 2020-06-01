import java.io.*;
import java.util.*;


public class convention {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("convention.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int cows = Integer.parseInt(s.nextToken());
		int bus = Integer.parseInt(s.nextToken());
		int cap = Integer.parseInt(s.nextToken());
		int[] arr = new int[cows];
		s = new StringTokenizer(f.readLine());
		for (int i = 0; i < cows; i++) {
			arr[i] = Integer.parseInt(s.nextToken());
		}
		Arrays.sort(arr);
		int time = bsearchFunctChange(arr, bus, cap);
		out.println(time + 1);
		out.close();

	}
	public static int bsearchFunctChange(int[] cows, int bus, int cap) {
		int minW = -1;
	    int maxW = cows[cows.length - 1];
	    while(minW != maxW) {
	      int mid = (minW + maxW + 1) / 2;
	      if(works(mid, cows, bus, cap)) maxW = mid - 1;
	      else minW = mid;
	    }
	    return minW;
	}
	public static boolean works(int time, int[] cows, int bus, int cap) {
		int counter = 0;
		for (int i = 0; i < bus; i++) {
			int tempCap = 0;
			int tempTime = 0;
			int initial = cows[counter];
			int cow = 0;
			
			while (tempCap < cap && tempTime <= time && counter < cows.length) {
				cow = cows[counter];
				tempTime = cow - initial;
				if (tempTime > time) {
					break;
				}
				tempCap++;
				counter++;
			}
			if (counter == cows.length) {
				break;
			}
		}
		return (counter == cows.length);
	}
	
	// you should actually read the stuff at the bottom
	

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, BASH TEST CASES, MAKE MILLIONS
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */