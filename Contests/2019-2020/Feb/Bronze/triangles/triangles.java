import java.io.*;
import java.util.*;


public class triangles {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		
		int triangles = Integer.parseInt(s.nextToken());
		int[][] points = new int[triangles][2];
		for (int i = 0; i < triangles; i++) {
			s = new StringTokenizer(f.readLine());
			points[i][0] = Integer.parseInt(s.nextToken());
			points[i][1] = Integer.parseInt(s.nextToken());
		}
		
		double ans = 0;
		
		for (int i = 0; i < triangles; i++) {
			int xOne = points[i][0];
			int yOne = points[i][1];
			for (int j = 0; j < triangles; j++) {
				if (j == i) {
					continue;
				}
				int xTwo = points[j][0];
				int yTwo = points[j][1];
				if (xTwo != xOne && yTwo != yOne) {
					continue;
				}
				boolean xAxis = false;
				if (xTwo == xOne) {
					xAxis = true;
				} 
				
				for (int c = 0; c < triangles; c++) {
					if (c == i || c == j) {
						continue;
					}
					int xThree = points[c][0];
					int yThree = points[c][1];
					double area = 0;
					if (xAxis) {
						if (yThree == yOne || yThree == yTwo) {
							area = (Math.abs(xThree - xOne) * Math.abs(yOne - yTwo) * 0.5);
						} else {
							continue;
						}
					} else {
						if (xThree == xOne || xThree == xTwo) {
							area = (Math.abs(xTwo - xOne) * Math.abs(yOne - yThree) * 0.5);
						} else {
							continue;
						}
					}
					ans = Math.max(ans, area);
				}
				
				
			}
		}
		
		out.println((int)(ans * 2));
		out.close();

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