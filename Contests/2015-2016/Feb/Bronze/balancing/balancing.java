import java.io.*;
import java.util.*;
/* REMINDERS
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */

public class balancing {
	public static int[] tallies = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = Integer.MAX_VALUE;
		int numCows = Integer.parseInt(s.nextToken());
		int b = Integer.parseInt(s.nextToken());
		
		int[][] cows = new int[numCows][2];
		ArrayList<Integer> xPoints = new ArrayList<Integer>();
		ArrayList<Integer> yPoints = new ArrayList<Integer>();
		
		for (int i = 0; i < numCows; i++) {
			s = new StringTokenizer(f.readLine());
			cows[i][0] = Integer.parseInt(s.nextToken());
			xPoints.add(cows[i][0] + 1);
			cows[i][1] = Integer.parseInt(s.nextToken());
			yPoints.add(cows[i][1] + 1);
		}
		
		//loop through x and y points,
		for (int i = 0; i < xPoints.size(); i++) {
			for (int j = 0; j < yPoints.size(); j++) {
				//System.out.println(xPoints.get(i) + " " + yPoints.get(j));
				tallies = new int[4];
				//look through all the cows positions
				for (int c = 0; c < numCows; c++) {
					checker(cows[c][0], cows[c][1], xPoints.get(i), yPoints.get(j));
				}
				Arrays.sort(tallies);
				//ArrayPrinter(tallies);
				ans = Math.min(tallies[3], ans);
				
			}
		}
		
		
		out.println(ans);
		out.close();

	}
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	public static void ArrayListPrinter(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	public static void checker(int x, int y, int currX, int currY) {
		if (x > currX && y > currY) {
			tallies[0]++;
		}
		if (x > currX && y < currY) {
			tallies[1]++;
		}
		if (x < currX && y < currY) {
			tallies[2]++;
		}
		if (x < currX && y > currY) {
			tallies[3]++;
		}
	}
	
	
	
	

}
