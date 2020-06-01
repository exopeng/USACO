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

public class cbarn {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int barns = Integer.parseInt(s.nextToken());
		int[] vals = new int[barns];
		int cows = 0;
		for (int i = 0; i < barns; i++) {
			s = new StringTokenizer(f.readLine());
			vals[i] = Integer.parseInt(s.nextToken());
			cows += vals[i];
		}
		
		for (int i = 0; i < barns; i++) {
			int curr = cows - vals[i];
			int diff = vals[i];
			//loop through the array, stop when you reach the index - 1
			for (int j = 1; j < barns - 1; j++) {
				//System.out.println(curr + " " + diff);
				int index = (i + j) % barns;
				diff += vals[index];
				curr += cows - diff;
				
			}
			
			if (i == 0) {
				ans = curr;
			} else {
				ans = Math.min(ans, curr);
			}
			//System.out.println();
			
		}
		out.println(ans);
		out.close();

	}
	
	
	
	

}
