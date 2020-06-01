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

public class pails {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pails.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int x = Integer.parseInt(s.nextToken());
		int y = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		int yStart = m / y;
		//if ystart can still be filled
		int diff = m % y;
		
		for (int i = yStart ; i > -1; i--) {
			int sum = y * i;
			//System.out.println(sum);
			int xStart = (m - sum) / x;
			sum += xStart * x;
			
			diff = Math.min(diff, m - sum);
		}
		out.println(m - diff);
		out.close();

	}
	
	
	
	

}
