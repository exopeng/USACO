import java.io.*;
import java.util.*;


public class swapEff {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("swap.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(s.nextToken());
		int k = Integer.parseInt(s.nextToken());
		s = new StringTokenizer(f.readLine());
		int a1 = Integer.parseInt(s.nextToken()) - 1;
		int a2 = Integer.parseInt(s.nextToken()) - 1;
		s = new StringTokenizer(f.readLine());
		int b1 = Integer.parseInt(s.nextToken()) - 1;
		int b2 = Integer.parseInt(s.nextToken()) - 1;
		
		int[] cows = new int[n];
		
		for (int i = 0; i < cows.length; i++) {
			cows[i] = i + 1;
		}
		int modulo = 0;
		
		for (int i = 0; i < k; i++) {
			int counter = 0;
			for (int j = a1; j <= (a1 + a2) / 2; j++) {
				int temp1 = cows[j];
				int temp2 = cows[a2 - counter];
				cows[j] = temp2;
				cows[a2 - counter] = temp1;
				counter++;
			}
			
			counter = 0;
			for (int j = b1; j <= (b1 + b2) / 2; j++) {
				int temp1 = cows[j];
				int temp2 = cows[b2 - counter];
				cows[j] = temp2;
				cows[b2 - counter] = temp1;
				counter++;
			}
			
			if (checker(cows)) {
				modulo = i + 1;
				cows = special((k) % modulo, a1, a2, b1, b2, n);
				break;
			}
		}
		
		for (int i = 0; i < n; i++) {
			out.println(cows[i]);
		}
		
		out.close();

	}
	public static void swap(int a1, int a2, int[] arr) {
		int counter = 0;
		for (int j = a1; j <= (a1 + a2) / 2; j++) {
			int temp1 = arr[j];
			int temp2 = arr[a2 - counter];
			arr[j] = temp2;
			arr[a2 - counter] = temp1;
			counter++;
		}
	}
	public static int[] special(int modulo, int a1, int a2, int b1, int b2, int n) {
		int[] cows = new int[n];
		for (int i = 0; i < cows.length; i++) {
			cows[i] = i + 1;
		}
		
		for (int i = 0; i < modulo; i++) {
			int counter = 0;
			for (int j = a1; j <= (a1 + a2) / 2; j++) {
				int temp1 = cows[j];
				int temp2 = cows[a2 - counter];
				cows[j] = temp2;
				cows[a2 - counter] = temp1;
				counter++;
			}
			
			counter = 0;
			for (int j = b1; j <= (b1 + b2) / 2; j++) {
				int temp1 = cows[j];
				int temp2 = cows[b2 - counter];
				cows[j] = temp2;
				cows[b2 - counter] = temp1;
				counter++;
			}
		}
		
		return cows;
	}
	public static boolean checker(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				return false;
			}
		}
		return true;
	}
	public static int getIntersection(int x1, int x2, int x3, int x4) {
		//test using sorting
		//Assumes sorted points, smallest to biggest
		int[] interval = new int[] {x1, x2, x3, x4};
		int intersection = 0;
		Arrays.sort(interval);
		
		//the interval covers the entire, thing, intersection is just the interval in it
		if ((interval[0] == x3 && interval[3] == x4) || (interval[0] == x1 && interval[3] == x2)) {
			intersection = Math.abs(interval[2] - interval[1]) + 1;
		}
	
		//no intersection
		if ((interval[2] == x3 && interval[3] == x4) || (interval[2] == x1 && interval[3] == x2)) {
			intersection = 0;
		}
		
		//partial intersection
		if ((interval[1] == x3 && interval[3] == x4) || (interval[1] == x1 && interval[3] == x2)) {
			intersection = Math.abs(interval[2] - interval[1]) + 1;
		}
		
		
		return intersection;
	}
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
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